FILESEXTRAPATHS_append := ":${THISDIR}/${PN}"

SRC_URI_append = "file://0001-removed-startup-of-weston.service.patch;patchdir=${WORKDIR}"