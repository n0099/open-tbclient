package d.a.l0.f.i.r;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f50501a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, UtilsBlink.VER_TYPE_SEPARATOR, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f50502b = new byte[128];

    static {
        int i2 = 0;
        while (true) {
            byte[] bArr = f50501a;
            if (i2 >= bArr.length) {
                return;
            }
            f50502b[bArr[i2]] = (byte) i2;
            i2++;
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
        int i2 = 0;
        int i3 = 0;
        while (i2 < bytes.length) {
            byte[] bArr2 = f50501a;
            bArr[i3] = bArr2[(bytes[i2] & 252) >> 2];
            int i4 = i2 + 1;
            bArr[i3 + 1] = bArr2[((bytes[i2] & 3) << 4) + ((bytes[i4] & 240) >> 4)];
            int i5 = i2 + 2;
            bArr[i3 + 2] = bArr2[((bytes[i4] & 15) << 2) + ((bytes[i5] & 192) >> 6)];
            bArr[i3 + 3] = bArr2[bytes[i5] & 63];
            i2 += 3;
            i3 += 4;
        }
        return new String(bArr);
    }
}
