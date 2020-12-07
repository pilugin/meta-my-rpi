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

SRC_URI = "https://www.linux-astro-imaging.uk/sites/downloads/linux/dmx/astrodmx-glibc-2.27_${PV}_armhf.manual.tar.gz;subdir=${BP}"
SRC_URI[md5sum] = "4f7f22cf712d9288f0803965a7543436"
SRC_URI[sha1sum] = "996dd17aa719c2621a5342f327418888056a968a"
SRC_URI[sha256sum] = "aa648ed453f709cd196fbf7e58126a07b3c1ada54de73dd7f785d84866949b19"
SRC_URI[sha384sum] = "c00ab39a2965f45a4a0f6cd1fdf27051b9bace6082e6fe061861239b9052d59dedf333d9794b9326db3465974c52598f"
SRC_URI[sha512sum] = "12e4b2e98c31108d2d3da7e94a3eba31aca98d69bef2605c374b0dd62c8ac8e6ee7c46cd5c71d77bdf80e669578bc142490f348fd744c794ec56cdddae6d8f25"

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