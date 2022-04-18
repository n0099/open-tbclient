package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.utils.Utils;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.sapi2.SapiWebView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.MimeTypes;
import com.kwad.v8.debug.ExecutionState;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public final class ck5 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Integer> a;
    public static HashMap<String, Integer> b;
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static final Pattern e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755794300, "Lcom/repackage/ck5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755794300, "Lcom/repackage/ck5;");
                return;
            }
        }
        um4.e();
        a = new HashMap<>();
        b = new HashMap<>();
        c = new HashMap<>();
        d = new HashMap<>();
        a("application/andrew-inset", "ez", 5);
        a("application/dsptype", "tsp", 5);
        a("application/futuresplash", "spl", 5);
        a("application/hta", "hta", 5);
        a("application/mac-binhex40", "hqx", 5);
        a("application/mac-compactpro", "cpt", 5);
        a("application/mathematica", BaseContentUploader.NB, 5);
        a("application/msaccess", "mdb", 5);
        a("application/oda", "oda", 5);
        a("application/ogg", "ogg", 1);
        a(DocumentOpenUtil.PDF_TYPE, DocumentOpenUtil.PDF, 4);
        a("application/pgp-keys", "key", 5);
        a("application/pgp-signature", "pgp", 5);
        a("application/pics-rules", "prf", 5);
        a("application/rar", "rar", 8);
        a("application/rdf+xml", "rdf", 5);
        a("application/rss+xml", "rss", 5);
        a("application/zip", StatConstants.VALUE_TYPE_ZIP, 8);
        a("application/vnd.android.package-archive", D.COLUMU_PLUGIN_DEX_PATH, 3);
        a("application/vnd.cinderella", "cdy", 5);
        a("application/vnd.ms-pki.stl", "stl", 5);
        a("application/vnd.oasis.opendocument.database", "odb", 5);
        a("application/vnd.oasis.opendocument.formula", "odf", 5);
        a("application/vnd.oasis.opendocument.graphics", "odg", 5);
        a("application/vnd.oasis.opendocument.graphics-template", "otg", 5);
        a("application/vnd.oasis.opendocument.image", "odi", 5);
        a("application/vnd.oasis.opendocument.spreadsheet", "ods", 5);
        a("application/vnd.oasis.opendocument.spreadsheet-template", "ots", 5);
        a("application/vnd.oasis.opendocument.text", "odt", 5);
        a("application/vnd.oasis.opendocument.text-master", "odm", 5);
        a("application/vnd.oasis.opendocument.text-template", "ott", 5);
        a("application/vnd.oasis.opendocument.text-web", "oth", 5);
        a("application/vnd.google-earth.kml+xml", "kml", 5);
        a("application/vnd.google-earth.kmz", "kmz", 5);
        a(DocumentOpenUtil.WORD_TYPE, DocumentOpenUtil.DOC, 4);
        a(DocumentOpenUtil.WORD_TYPE, "dot", 4);
        a(DocumentOpenUtil.DOCUMENT_TYPE, DocumentOpenUtil.DOCX, 4);
        a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx", 4);
        a(DocumentOpenUtil.EXCEL_TYPE, DocumentOpenUtil.XLS, 4);
        a(DocumentOpenUtil.EXCEL_TYPE, "xlt", 4);
        a(DocumentOpenUtil.SHEET_TYPE, DocumentOpenUtil.XLSX, 4);
        a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx", 4);
        a(DocumentOpenUtil.PPT_TYPE, DocumentOpenUtil.PPT, 4);
        a(DocumentOpenUtil.PPT_TYPE, "pot", 4);
        a(DocumentOpenUtil.PPT_TYPE, "pps", 4);
        a(DocumentOpenUtil.PRESENT_TYPE, DocumentOpenUtil.PPTX, 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx", 4);
        a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx", 4);
        a("application/vnd.rim.cod", "cod", 5);
        a("application/vnd.smaf", "mmf", 5);
        a("application/vnd.stardivision.calc", "sdc", 5);
        a("application/vnd.stardivision.draw", "sda", 5);
        a("application/vnd.stardivision.impress", "sdd", 5);
        a("application/vnd.stardivision.impress", "sdp", 5);
        a("application/vnd.stardivision.math", "smf", 5);
        a("application/vnd.stardivision.writer", "sdw", 5);
        a("application/vnd.stardivision.writer", "vor", 5);
        a("application/vnd.stardivision.writer-global", "sgl", 5);
        a("application/vnd.sun.xml.calc", "sxc", 5);
        a("application/vnd.sun.xml.calc.template", "stc", 5);
        a("application/vnd.sun.xml.draw", "sxd", 5);
        a("application/vnd.sun.xml.draw.template", "std", 5);
        a("application/vnd.sun.xml.impress", "sxi", 5);
        a("application/vnd.sun.xml.impress.template", "sti", 5);
        a("application/vnd.sun.xml.math", "sxm", 5);
        a("application/vnd.sun.xml.writer", "sxw", 5);
        a("application/vnd.sun.xml.writer.global", "sxg", 5);
        a("application/vnd.sun.xml.writer.template", "stw", 5);
        a("application/vnd.visio", "vsd", 5);
        a("application/x-abiword", "abw", 5);
        a("application/x-apple-diskimage", "dmg", 5);
        a("application/x-bcpio", "bcpio", 5);
        a("application/x-bittorrent", "torrent", 5);
        a("application/x-cdf", "cdf", 5);
        a("application/x-cdlink", "vcd", 5);
        a("application/x-chess-pgn", "pgn", 5);
        a("application/x-cpio", "cpio", 5);
        a("application/x-debian-package", "deb", 5);
        a("application/x-debian-package", "udeb", 5);
        a("application/x-director", "dcr", 5);
        a("application/x-director", "dir", 5);
        a("application/x-director", "dxr", 5);
        a("application/x-dms", "dms", 5);
        a("application/x-doom", "wad", 5);
        a("application/x-dvi", "dvi", 5);
        a("application/x-flac", "flac", 1);
        a("application/x-font", "pfa", 5);
        a("application/x-font", "pfb", 5);
        a("application/x-font", "gsf", 5);
        a("application/x-font", "pcf", 5);
        a("application/x-font", "pcf.Z", 5);
        a("application/x-freemind", "mm", 5);
        a("application/x-futuresplash", "spl", 5);
        a("application/x-gnumeric", "gnumeric", 5);
        a("application/x-go-sgf", "sgf", 5);
        a("application/x-graphing-calculator", "gcf", 5);
        a("application/x-gtar", "gtar", 5);
        a("application/x-gtar", "tgz", 5);
        a("application/x-gtar", "taz", 5);
        a("application/x-hdf", "hdf", 5);
        a("application/x-ica", "ica", 5);
        a("application/x-internet-signup", "ins", 5);
        a("application/x-internet-signup", "isp", 5);
        a("application/x-iphone", "iii", 5);
        a("application/x-iso9660-image", "iso", 5);
        a("application/x-jmol", "jmz", 5);
        a("application/x-kchart", "chrt", 5);
        a("application/x-killustrator", "kil", 5);
        a("application/x-koan", "skp", 5);
        a("application/x-koan", "skd", 5);
        a("application/x-koan", "skt", 5);
        a("application/x-koan", "skm", 5);
        a("application/x-kpresenter", "kpr", 5);
        a("application/x-kpresenter", "kpt", 5);
        a("application/x-kspread", "ksp", 5);
        a("application/x-kword", "kwd", 5);
        a("application/x-kword", "kwt", 5);
        a("application/x-latex", "latex", 5);
        a("application/x-lha", "lha", 5);
        a("application/x-lzh", "lzh", 5);
        a("application/x-lzx", "lzx", 5);
        a("application/x-maker", "frm", 5);
        a("application/x-maker", "maker", 5);
        a("application/x-maker", ExecutionState.FRAME, 5);
        a("application/x-maker", "fb", 5);
        a("application/x-maker", "book", 5);
        a("application/x-maker", "fbdoc", 5);
        a("application/x-mif", "mif", 5);
        a("application/x-ms-wmd", "wmd", 5);
        a("application/x-ms-wmz", "wmz", 5);
        a("application/x-msi", "msi", 5);
        a("application/x-ns-proxy-autoconfig", "pac", 5);
        a("application/x-nwc", "nwc", 5);
        a("application/x-object", "o", 5);
        a("application/x-oz-application", "oza", 5);
        a("application/x-pkcs12", "p12", 5);
        a("application/x-pkcs12", "pfx", 5);
        a("application/x-pkcs7-certreqresp", "p7r", 5);
        a("application/x-pkcs7-crl", "crl", 5);
        a("application/x-quicktimeplayer", "qtl", 5);
        a("application/x-shar", "shar", 5);
        a("application/x-shockwave-flash", "swf", 5);
        a("application/x-stuffit", "sit", 5);
        a("application/x-sv4cpio", "sv4cpio", 5);
        a("application/x-sv4crc", "sv4crc", 5);
        a("application/x-tar", "tar", 8);
        a("application/x-texinfo", "texinfo", 5);
        a("application/x-texinfo", "texi", 5);
        a("application/x-troff", "t", 5);
        a("application/x-troff", "roff", 5);
        a("application/x-troff-man", "man", 5);
        a("application/x-ustar", "ustar", 5);
        a("application/x-wais-source", "src", 5);
        a("application/x-wingz", "wz", 5);
        a("application/x-webarchive", "webarchive", 5);
        a("application/x-webarchive-xml", "webarchivexml", 5);
        a("application/x-x509-ca-cert", "crt", 5);
        a("application/x-x509-user-cert", "crt", 5);
        a("application/x-xcf", "xcf", 5);
        a("application/x-xfig", "fig", 5);
        a("application/xhtml+xml", "xhtml", 5);
        a("application/font-sfnt", "ttf", 5);
        a(MimeTypes.AUDIO_AMR_NB, "3gpp", 1);
        a("audio/amr", "amr", 1);
        a("audio/basic", "snd", 1);
        a("audio/midi", "mid", 1);
        a("audio/midi", "midi", 1);
        a("audio/midi", "kar", 1);
        a("audio/midi", "xmf", 1);
        a("audio/mobile-xmf", "mxmf", 1);
        a(MimeTypes.AUDIO_MPEG, "mp3", 1);
        a(MimeTypes.AUDIO_MPEG, "mpga", 1);
        a(MimeTypes.AUDIO_MPEG, "mpega", 1);
        a(MimeTypes.AUDIO_MPEG, "mp2", 1);
        a(MimeTypes.AUDIO_MPEG, "m4a", 1);
        a("audio/mpegurl", "m3u", 1);
        a("audio/prs.sid", "sid", 1);
        a("audio/x-aiff", "aif", 1);
        a("audio/x-aiff", "aiff", 1);
        a("audio/x-aiff", "aifc", 1);
        a("audio/x-gsm", "gsm", 1);
        a("audio/x-mpegurl", "m3u", 1);
        a("audio/x-ms-wma", "wma", 1);
        a("audio/x-ms-wax", "wax", 1);
        a("audio/x-pn-realaudio", "ra", 1);
        a("audio/x-pn-realaudio", com.kuaishou.weapon.un.x.C, 1);
        a("audio/x-pn-realaudio", "ram", 1);
        a("audio/x-realaudio", "ra", 1);
        a("audio/x-scpls", "pls", 1);
        a("audio/x-sd2", "sd2", 1);
        a("audio/x-wav", "wav", 1);
        a("image/bmp", "bmp", 2);
        a("image/gif", NativeConstants.TYPE_GIF, 2);
        a("image/ico", "cur", 5);
        a("image/ico", "ico", 2);
        a("image/ief", "ief", 5);
        a("image/jpeg", "jpeg", 2);
        a("image/jpeg", "jpg", 2);
        a("image/jpeg", "jpe", 2);
        a("image/pcx", "pcx", 5);
        a("image/png", "png", 2);
        a("image/svg+xml", "svg", 5);
        a("image/svg+xml", "svgz", 5);
        a("image/tiff", "tiff", 5);
        a("image/tiff", "tif", 5);
        a("image/vnd.djvu", "djvu", 5);
        a("image/vnd.djvu", "djv", 5);
        a(Downsampler.WBMP_MIME_TYPE, "wbmp", 2);
        a("image/x-cmu-raster", "ras", 5);
        a("image/x-coreldraw", "cdr", 5);
        a("image/x-coreldrawpattern", "pat", 5);
        a("image/x-coreldrawtemplate", "cdt", 5);
        a("image/x-corelphotopaint", "cpt", 5);
        a("image/x-icon", "ico", 2);
        a("image/x-jg", "art", 5);
        a("image/x-jng", "jng", 5);
        a("image/x-ms-bmp", "bmp", 2);
        a("image/x-photoshop", "psd", 5);
        a("image/x-portable-anymap", "pnm", 5);
        a("image/x-portable-bitmap", "pbm", 5);
        a("image/x-portable-graymap", "pgm", 5);
        a("image/x-portable-pixmap", "ppm", 5);
        a("image/x-rgb", ColorParser.RGB, 5);
        a("image/x-xbitmap", "xbm", 5);
        a("image/x-xpixmap", "xpm", 5);
        a("image/x-xwindowdump", "xwd", 5);
        a("model/iges", "igs", 5);
        a("model/iges", "iges", 5);
        a("model/mesh", "msh", 5);
        a("model/mesh", "mesh", 5);
        a("model/mesh", "silo", 5);
        a("text/calendar", "ics", 5);
        a("text/calendar", "icz", 5);
        a("text/comma-separated-values", "csv", 5);
        a("text/css", "css", 5);
        a(SapiWebView.DATA_MIME_TYPE, "htm", 11);
        a(SapiWebView.DATA_MIME_TYPE, "html", 11);
        a("text/h323", "323", 5);
        a("text/iuls", "uls", 5);
        a("text/mathml", "mml", 5);
        a("text/plain-story", "txt", 6);
        a("text/plain", "dat", 5);
        a("text/plain", "txt", 4);
        a("text/plain", "asc", 4);
        a("text/plain", "text", 4);
        a("text/plain", "diff", 4);
        a("text/plain", "po", 4);
        a("text/richtext", "rtx", 4);
        a("text/rtf", "rtf", 4);
        a("text/texmacs", TimeDisplaySetting.TIME_DISPLAY_SETTING, 5);
        a("text/text", "phps", 5);
        a("text/tab-separated-values", "tsv", 5);
        a("text/xml", "xml", 4);
        a("text/x-bibtex", "bib", 5);
        a("text/x-boo", "boo", 5);
        a("text/x-c++hdr", "h++", 5);
        a("text/x-c++hdr", "hpp", 5);
        a("text/x-c++hdr", "hxx", 5);
        a("text/x-c++hdr", "hh", 5);
        a("text/x-c++src", "c++", 5);
        a("text/x-c++src", "cpp", 5);
        a("text/x-c++src", "cxx", 5);
        a("text/x-chdr", "h", 5);
        a("text/x-component", "htc", 5);
        a("text/x-csh", "csh", 5);
        a("text/x-csrc", "c", 5);
        a("text/x-dsrc", "d", 5);
        a("text/x-haskell", "hs", 5);
        a("text/x-java", ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA, 5);
        a("text/x-literate-haskell", "lhs", 5);
        a("text/x-moc", "moc", 5);
        a("text/x-pascal", "p", 5);
        a("text/x-pascal", "pas", 5);
        a("text/x-pcs-gcd", "gcd", 5);
        a("text/x-setext", "etx", 5);
        a("text/x-tcl", "tcl", 5);
        a("text/x-tex", "tex", 5);
        a("text/x-tex", "ltx", 5);
        a("text/x-tex", "sty", 5);
        a("text/x-tex", "cls", 5);
        a("text/x-vcalendar", "vcs", 5);
        a("text/x-vcard", "vcf", 5);
        a("video/mkv", "mkv", 0);
        a(MimeTypes.VIDEO_H263, "3gpp", 0);
        a(MimeTypes.VIDEO_H263, "3gp", 0);
        a(MimeTypes.VIDEO_H263, "3g2", 0);
        a("video/dl", "dl", 0);
        a("video/dv", "dif", 0);
        a("video/dv", "dv", 0);
        a("video/fli", "fli", 0);
        a("video/m4v", "m4v", 0);
        a("video/mpeg", "mpeg", 0);
        a("video/mpeg", "mpg", 0);
        a("video/mpeg", "mpe", 0);
        a(MimeTypes.VIDEO_MP4, "mp4", 0);
        a("video/mpeg", "vob", 0);
        a("video/quicktime", "qt", 0);
        a("video/quicktime", "mov", 0);
        a("video/vnd.mpegurl", "mxu", 0);
        a("video/x-la-asf", "lsf", 0);
        a("video/x-la-asf", "lsx", 0);
        a("video/x-mng", "mng", 0);
        a("video/x-ms-asf", "asf", 0);
        a("video/x-ms-asf", "asx", 0);
        a("video/x-ms-wm", "wm", 0);
        a("video/x-ms-wmv", "wmv", 0);
        a("video/x-ms-wmx", "wmx", 0);
        a("video/x-ms-wvx", "wvx", 0);
        a("video/x-msvideo", "avi", 0);
        a("video/x-sgi-movie", "movie", 0);
        a("video/x-webex", "wrf", 0);
        a("x-conference/x-cooltalk", "ice", 5);
        a("x-epoc/x-sisx-app", "sisx", 5);
        a("video/vnd.rn-realvideo", "rmvb", 0);
        a("video/x-flv", BdVideoSeries.FORMAT_FLV, 0);
        a("audio/aac", "aac", 1);
        a("application/vnd.rn-realmedia", com.kuaishou.weapon.un.x.C, 0);
        a("message/rfc822", "mht", 11);
        e = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);
    }

    public static void a(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, str, str2, i) == null) {
            a.put(str2, Integer.valueOf(i));
            b.put(str, Integer.valueOf(i));
            c.put(str2, str);
            if (d.containsKey(str)) {
                return;
            }
            d.put(str, str2);
        }
    }

    public static int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return c(!TextUtils.isEmpty(str) ? str.toLowerCase() : "", str2, true);
        }
        return invokeLL.intValue;
    }

    public static int c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, str, str2, z)) == null) {
            Integer num = b.get(str2);
            if (num != null ? !(!z || num.intValue() != 8) : !((num = a.get(str)) != null && (!z || num.intValue() != 8))) {
                num = 5;
            }
            return num.intValue();
        }
        return invokeLLZ.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String decode = Uri.decode(str);
            if (decode != null) {
                int indexOf = decode.indexOf(63);
                if (indexOf > 0) {
                    decode = decode.substring(0, indexOf);
                }
                if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                    return decode.substring(lastIndexOf);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length()) ? "" : str.substring(lastIndexOf + 1) : (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        String substring;
        String str5;
        int lastIndexOf;
        int lastIndexOf2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            String str6 = null;
            if (str2 != null) {
                str4 = i(str2);
                if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(File.separator) + 1) > 0) {
                    str4 = str4.substring(lastIndexOf2);
                }
            } else {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = d(str);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = Utils.DEFAULT_DL_FILENAME;
            }
            int lastIndexOf3 = str4.lastIndexOf(".");
            if (lastIndexOf3 >= 0) {
                if (str3 != null) {
                    String substring2 = str4.substring(str4.lastIndexOf(".") + 1);
                    String f = f(str3);
                    String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    String lowerCase = !TextUtils.isEmpty(substring2) ? substring2.toLowerCase() : "";
                    String lowerCase2 = !TextUtils.isEmpty(f) ? f.toLowerCase() : "";
                    String lowerCase3 = !TextUtils.isEmpty(extensionFromMimeType) ? extensionFromMimeType.toLowerCase() : "";
                    String h = h(lowerCase);
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
                    String lowerCase4 = !TextUtils.isEmpty(h) ? h.toLowerCase() : "";
                    String lowerCase5 = TextUtils.isEmpty(mimeTypeFromExtension) ? "" : mimeTypeFromExtension.toLowerCase();
                    if (TextUtils.equals(lowerCase4, lowerCase5)) {
                        if (!TextUtils.isEmpty(lowerCase2) && TextUtils.equals(lowerCase2, lowerCase3)) {
                            str6 = "." + lowerCase2;
                        }
                    } else if (TextUtils.isEmpty(lowerCase4)) {
                        if (!TextUtils.isEmpty(lowerCase3)) {
                            str6 = "." + lowerCase3;
                        }
                    } else if (TextUtils.isEmpty(lowerCase5)) {
                        if (!TextUtils.isEmpty(lowerCase4)) {
                            str6 = "." + lowerCase;
                        } else if (!TextUtils.isEmpty(lowerCase2)) {
                            str6 = "." + lowerCase2;
                        }
                    }
                }
                substring = str6 == null ? str4.substring(lastIndexOf3) : str6;
                str4 = str4.substring(0, lastIndexOf3);
            } else {
                if (str3 != null) {
                    str5 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3);
                    if (TextUtils.isEmpty(str5)) {
                        if (str3.toLowerCase().startsWith(FileUtils.IMAGE_FILE_START)) {
                            str5 = ".jpg";
                        }
                    } else {
                        str5 = "." + str5;
                    }
                } else {
                    str5 = null;
                }
                if (str5 == null) {
                    if (str3 != null && str3.toLowerCase().startsWith("text/")) {
                        str5 = str3.equalsIgnoreCase(SapiWebView.DATA_MIME_TYPE) ? DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION;
                    } else {
                        String d2 = d(str);
                        if (!TextUtils.isEmpty(d2) && (lastIndexOf = d2.lastIndexOf(".")) != -1) {
                            str6 = d2.substring(lastIndexOf + 1);
                        }
                        if (TextUtils.isEmpty(str6)) {
                            substring = DownloadDataConstants.DEFAULT_DL_BINARY_EXTENSION;
                        } else {
                            substring = "." + str6;
                        }
                    }
                }
                if (str4 != null && str4.length() > 50) {
                    str4 = str4.substring(0, 50);
                }
                return str4 + str5;
            }
            str5 = substring;
            if (str4 != null) {
                str4 = str4.substring(0, 50);
            }
            return str4 + str5;
        }
        return (String) invokeLLL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.get(str);
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                Matcher matcher = e.matcher(str);
                if (matcher.find()) {
                    return matcher.group(2);
                }
                return null;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
