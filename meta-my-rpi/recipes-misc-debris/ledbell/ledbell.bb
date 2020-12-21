DESCRIPTION = "Make a blink with ethernet LEDs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SECTION = "base"
PR = "r0"

SRC_URI = "\
file://ledbell \
"

FILES_${PN} = "*"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/usr/bin
    install -m 0755 ${S}/ledbell ${D}/usr/bin/ledbell
}

RDEPENDS_${PN} += " mdio-tool"