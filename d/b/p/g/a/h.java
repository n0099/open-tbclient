package d.b.p.g.a;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes2.dex */
public final class h {
    public static byte[] a() {
        return new byte[]{ExifInterface.MARKER_SOF7, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 76, 41, 108, -30, -14, -12, 38, 20, -35, -89, -20, 114, -66, 34, ExifInterface.MARKER_SOF10, 104, 14, -117, 75};
    }

    public static byte[] b() {
        return new byte[]{ExifInterface.MARKER_SOF7, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 83, 56, 126, -30, -88, -28};
    }

    public static byte[] c() {
        return new byte[]{ExifInterface.MARKER_SOF7, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 76, 90, 52, -92, 15, ExifInterface.START_CODE, 26, 37, 0, -124, 65, UtilsBlink.VER_TYPE_SEPARATOR, 110, -43, -67, -19, 39, 24};
    }
}
