do_deploy_append() {
    sed -i 's,#dtparam=audio=off,dtparam=audio=on,g' ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
