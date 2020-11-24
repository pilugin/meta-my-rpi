FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_rpi = "\
    file://x11vnc.service \
"

do_install_append_rpi() {
    install -d ${D}/lib/systemd/system
    install -m 0644 ${WORKDIR}/x11vnc.service ${D}/lib/systemd/system/x11vnc.service

    install -d ${D}/etc/systemd/system/multi-user.target.wants/
    ln -s /lib/systemd/system/x11vnc.service ${D}/etc/systemd/system/multi-user.target.wants/x11vnc.service
}

FILES_${PN} += "/lib/systemd/system/* /etc/systemd/system/*"