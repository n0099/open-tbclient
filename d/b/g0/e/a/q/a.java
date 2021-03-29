package d.b.g0.e.a.q;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f47679a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, UtilsBlink.VER_TYPE_SEPARATOR, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f47680b = new byte[128];

    static {
        int i = 0;
        while (true) {
            byte[] bArr = f47679a;
            if (i >= bArr.length) {
                return;
            }
            f47680b[bArr[i]] = (byte) i;
            i++;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            byte[] bArr2 = f47679a;
            bArr[i2] = bArr2[(bytes[i] & 252) >> 2];
            int i3 = i + 1;
            bArr[i2 + 1] = bArr2[((bytes[i] & 3) << 4) + ((bytes[i3] & 240) >> 4)];
            int i4 = i + 2;
            bArr[i2 + 2] = bArr2[((bytes[i3] & 15) << 2) + ((bytes[i4] & ExifInterface.MARKER_SOF0) >> 6)];
            bArr[i2 + 3] = bArr2[bytes[i4] & 63];
            i += 3;
            i2 += 4;
        }
        return new String(bArr);
    }
}
