package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes9.dex */
public class bs {
    public static RSAPublicKey a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f950a = {48, -127, -97, 48, 13, 6, 9, ExifInterface.START_CODE, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, ExifInterface.MARKER_SOS, -114, 26, -72, 78, 16, 70, -90, 113, -30, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -27, 59, -123, 72, -73, -48, 49, 13, 16, 50, -27, -82, 18, -28, 84, 0, -41, 16, 69, ExifInterface.MARKER_EOI, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, ExifInterface.MARKER_SOF15, 111, -11, 49, 28, 117, -74, 114, -122, -29, -84, 82, 22, -122, ExifInterface.START_CODE, ExifInterface.MARKER_SOI, -79, 18, -116, -42, Constants.SHORT_PING_CMD_TYPE, -70, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, Constants.GZIP_CAST_TYPE, 62, ExifInterface.MARKER_SOF15, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, ExifInterface.MARKER_SOF7, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, 16, -125, -91, -43, -103, 67, -20, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 117, -37, -11, 2, 3, 1, 0, 1};

    static {
        try {
            a = (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(f950a));
        } catch (Throwable unused) {
            com.xiaomi.channel.commonutils.logger.b.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, a);
            return Base64.encodeToString(a(cipher, 1, str.getBytes("UTF-8"), a.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(Cipher cipher, int i, byte[] bArr, int i2) {
        if (cipher == null || bArr == null) {
            return null;
        }
        int i3 = i2 / 8;
        if (i != 2) {
            i3 -= 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i4 = 0;
            int i5 = 0;
            while (bArr.length > i4) {
                byte[] doFinal = bArr.length - i4 > i3 ? cipher.doFinal(bArr, i4, i3) : cipher.doFinal(bArr, i4, bArr.length - i4);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i5++;
                i4 = i5 * i3;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
