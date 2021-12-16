package org.apache.commons.codec.digest4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.base.Charsets;
/* loaded from: classes4.dex */
public class Md5Crypt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APR1_PREFIX = "$apr1$";
    public static final int BLOCKSIZE = 16;
    public static final String MD5_PREFIX = "$1$";
    public static final int ROUNDS = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    public Md5Crypt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String apr1Crypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            return apr1Crypt(bArr, APR1_PREFIX + B64.getRandomSalt(8));
        }
        return (String) invokeL.objValue;
    }

    public static String md5Crypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            return md5Crypt(bArr, MD5_PREFIX + B64.getRandomSalt(8));
        }
        return (String) invokeL.objValue;
    }

    public static String apr1Crypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) {
            if (str != null && !str.startsWith(APR1_PREFIX)) {
                str = APR1_PREFIX + str;
            }
            return md5Crypt(bArr, str, APR1_PREFIX);
        }
        return (String) invokeLL.objValue;
    }

    public static String md5Crypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, str)) == null) ? md5Crypt(bArr, str, MD5_PREFIX) : (String) invokeLL.objValue;
    }

    public static String md5Crypt(byte[] bArr, String str, String str2) {
        InterceptResult invokeLLL;
        String group;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, bArr, str, str2)) == null) {
            int length = bArr.length;
            if (str == null) {
                group = B64.getRandomSalt(8);
            } else {
                Matcher matcher = Pattern.compile(PayTypeItemView.PayTypeItemViewData.MASK_FLAG + str2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*").matcher(str);
                if (matcher.find()) {
                    group = matcher.group(1);
                } else {
                    throw new IllegalArgumentException("Invalid salt value: " + str);
                }
            }
            byte[] bytes = group.getBytes(Charsets.UTF_8);
            MessageDigest md5Digest = DigestUtils.getMd5Digest();
            md5Digest.update(bArr);
            md5Digest.update(str2.getBytes(Charsets.UTF_8));
            md5Digest.update(bytes);
            MessageDigest md5Digest2 = DigestUtils.getMd5Digest();
            md5Digest2.update(bArr);
            md5Digest2.update(bytes);
            md5Digest2.update(bArr);
            byte[] digest = md5Digest2.digest();
            int i2 = length;
            while (true) {
                int i3 = 16;
                if (i2 <= 0) {
                    break;
                }
                if (i2 <= 16) {
                    i3 = i2;
                }
                md5Digest.update(digest, 0, i3);
                i2 -= 16;
            }
            Arrays.fill(digest, (byte) 0);
            while (length > 0) {
                if ((length & 1) == 1) {
                    md5Digest.update(digest[0]);
                } else {
                    md5Digest.update(bArr[0]);
                }
                length >>= 1;
            }
            StringBuilder sb = new StringBuilder(str2 + group + "$");
            byte[] digest2 = md5Digest.digest();
            for (int i4 = 0; i4 < 1000; i4++) {
                md5Digest2 = DigestUtils.getMd5Digest();
                int i5 = i4 & 1;
                if (i5 != 0) {
                    md5Digest2.update(bArr);
                } else {
                    md5Digest2.update(digest2, 0, 16);
                }
                if (i4 % 3 != 0) {
                    md5Digest2.update(bytes);
                }
                if (i4 % 7 != 0) {
                    md5Digest2.update(bArr);
                }
                if (i5 != 0) {
                    md5Digest2.update(digest2, 0, 16);
                } else {
                    md5Digest2.update(bArr);
                }
                digest2 = md5Digest2.digest();
            }
            B64.b64from24bit(digest2[0], digest2[6], digest2[12], 4, sb);
            B64.b64from24bit(digest2[1], digest2[7], digest2[13], 4, sb);
            B64.b64from24bit(digest2[2], digest2[8], digest2[14], 4, sb);
            B64.b64from24bit(digest2[3], digest2[9], digest2[15], 4, sb);
            B64.b64from24bit(digest2[4], digest2[10], digest2[5], 4, sb);
            B64.b64from24bit((byte) 0, (byte) 0, digest2[11], 2, sb);
            md5Digest.reset();
            md5Digest2.reset();
            Arrays.fill(bArr, (byte) 0);
            Arrays.fill(bytes, (byte) 0);
            Arrays.fill(digest2, (byte) 0);
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static String apr1Crypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? apr1Crypt(str.getBytes(Charsets.UTF_8)) : (String) invokeL.objValue;
    }

    public static String apr1Crypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? apr1Crypt(str.getBytes(Charsets.UTF_8), str2) : (String) invokeLL.objValue;
    }
}
