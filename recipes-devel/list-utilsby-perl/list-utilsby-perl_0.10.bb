DESCRIPTION = "This module provides a number of list utility functions, all of which \
take an initial code block to control their behaviour. They are \
variations on \
similar core perl or \"List::Util\" functions of similar names, but \
which use \
the block to control their behaviour. For example, the core Perl \
function \
\"sort\" takes a list of values and returns them, sorted into order by \
their \
string value. The \"sort_by\" function sorts them according to the \
string \
value returned by the extra function, when given each value."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/List-UtilsBy"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://cpan.metacpan.org/authors/id/P/PE/PEVANS/List-UtilsBy-0.10.tar.gz"

SRC_URI[md5sum] = "2b4e2ffdfa99ab3eba8e221545c67522"
SRC_URI[sha256sum] = "bed74094c625aa34a5ae94a7e1fe1856f08e1bd26b8ba152bfe7a51d3277192e"
DEPENDS += "module-build-perl-native"

S = "${WORKDIR}/List-UtilsBy-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
