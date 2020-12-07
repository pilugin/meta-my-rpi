DESCRIPTION = "Service that blinks with ETH leds on ALSA playback"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SECTION = "base"
PR = "r0"

SRC_URI = "\
file://sound2led.sh \
file://sound2led.service \
"

FILES_${PN} = "*"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/lib/systemd/system
    install -m 0644 ${S}/sound2led.service ${D}/lib/systemd/system/sound2led.service

    install -d ${D}/etc/systemd/system/multi-user.target.wants
    ln -s /lib/systemd/system/sound2lef.service ${D}/etc/systemd/system/multi-user.target.wants/sound2led.service

    install -d ${D}/usr/bin
    install -m 0755 ${S}/sound2led.sh ${D}/usr/bin/sound2led.sh
}

RDEPENDS_${PN} += " mdio-tool"