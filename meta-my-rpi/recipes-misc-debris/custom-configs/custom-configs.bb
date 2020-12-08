DESCRIPTION = "Custom config files"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SECTION = "base"
PR = "r0"

SRC_URI = "\
file://wlan0.network \
file://session \
"

FILES_${PN} = "*"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/etc/systemd/network
    install -m 0644 ${S}/wlan0.network ${D}/etc/systemd/network/wlan0.network

    install -d ${D}/etc/mini_x
    install -m 0755 ${S}/session ${D}/etc/mini_x/session
}
