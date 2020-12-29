# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PV = "0.82.2"

SRC_URI = "https://www.astrodmx-capture.org.uk/sites/downloads/astrodmx/current/rpi/astrodmx-glibc-2.27_${PV}_armhf-manual.tar.gz"
SRC_URI[sha256sum] = "756897cbd3e2c21141035d0ff83387511c6b7e5d0ae76db88bc257010084cdf8"

inherit bin_package

INSANE_SKIP_${PN} += "already-stripped libdir file-rdeps ldflags"

SRC_PRFX="/usr/local/AstroDMx_Capture"

S_ = "${S}/R-Linux-PI32-2.27"
do_patch() {
    mv ${S_}/etc ${S_}/usr ${S}/ ||:
    find ${S} -name libgcc_s.so.1 -exec rm {} \;
    find ${S} -name libstdc++.so.6 -exec rm {} \;

    mkdir -p ${S}/usr/bin
    ln -s ${SRC_PRFX}/bin/launcher.sh ${S}/usr/bin/astrodmx

    rm -fr ${S_}
}

DEPENDS += "gcc-runtime"
RDEPENDS_${PN} += " libglu libltdl "

FILES_${PN} = "*"