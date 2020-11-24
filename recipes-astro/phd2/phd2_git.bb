# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.txt
#   thirdparty/openssag/LICENSE.txt
#   thirdparty/VidCapture/License.txt
#   debian/copyright
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ded813e58b64cdf7cf2fbd330ee7d50f \
                    file://thirdparty/openssag/LICENSE.txt;md5=ec198afd1b0907c3700255f590c55570 \
                    file://thirdparty/VidCapture/License.txt;md5=c5ead351133da7e153348e552554c489 \
                    file://debian/copyright;md5=554b870432906c662a22bc88e839d91f"

SRC_URI = "git://github.com/OpenPHDGuiding/phd2.git;protocol=https \
           file://0001-Fix-find_library-for-camera-blobs.patch \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "65a094f430914e55ffd87f59f7c0d81d8f672997"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: Eigen3 GTest OpenCV Nova INDI wxWidgets CFITSIO
# NOTE: the following library dependencies are unknown, ignoring: OpenGL 2 System Carbon y k S sbigudrv AudioToolbox CoreFoundation b QuickTime IOKit Webkit SBIG Cocoa
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "zlib curl libusb1 wxwidgets"

inherit cmake gettext

FILES_${PN} += "${datadir}/metainfo/*"

INSANE_SKIP_${PN} += "already-stripped"


