package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.kwad.yoga.YogaNodeJNIBase;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes8.dex */
public class bs {
    public static /* synthetic */ Interceptable $ic;
    public static RSAPublicKey a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f941a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071163573, "Lcom/xiaomi/push/service/bs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071163573, "Lcom/xiaomi/push/service/bs;");
                return;
            }
        }
        f941a = new byte[]{48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, YogaNodeJNIBase.HAS_NEW_LAYOUT, 70, -90, 113, -30, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 85, -3, -43, ContentUtil.GZIP_HEAD_2, BaseNCodec.PAD_DEFAULT, -98, 4, -16, 67, 19, -90, -73, -5, -89, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, -27, 59, -123, 72, -73, -48, 49, 13, YogaNodeJNIBase.HAS_NEW_LAYOUT, 50, -27, -82, 18, -28, 84, 0, -41, YogaNodeJNIBase.HAS_NEW_LAYOUT, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, ContentUtil.GZIP_HEAD_2, -34, -49, 111, -11, 49, 28, ContentUtil.GZIP_HEAD_1, -74, 114, -122, -29, -84, 82, 22, -122, 42, -40, -79, 18, -116, -42, Constants.SHORT_PING_CMD_TYPE, -70, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, Constants.GZIP_CAST_TYPE, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, Cea608Decoder.CTRL_END_OF_CAPTION, -24, 110, -66, -7, 87, YogaNodeJNIBase.HAS_NEW_LAYOUT, -125, -91, -43, -103, 67, -20, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ContentUtil.GZIP_HEAD_1, -37, -11, 2, 3, 1, 0, 1};
        try {
            a = (RSAPublicKey) KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(f941a));
        } catch (Throwable unused) {
            com.xiaomi.channel.commonutils.logger.b.d("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static byte[] a(Cipher cipher, int i, byte[] bArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{cipher, Integer.valueOf(i), bArr, Integer.valueOf(i2)})) == null) {
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
        return (byte[]) invokeCommon.objValue;
    }
}
