package org.apache.commons.codec.digest4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.base.Charsets;
/* loaded from: classes2.dex */
public class Sha2Crypt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ROUNDS_DEFAULT = 5000;
    public static final int ROUNDS_MAX = 999999999;
    public static final int ROUNDS_MIN = 1000;
    public static final String ROUNDS_PREFIX = "rounds=";
    public static final Pattern SALT_PATTERN;
    public static final int SHA256_BLOCKSIZE = 32;
    public static final String SHA256_PREFIX = "$5$";
    public static final int SHA512_BLOCKSIZE = 64;
    public static final String SHA512_PREFIX = "$6$";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1797999846, "Lorg/apache/commons/codec/digest4util/Sha2Crypt;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1797999846, "Lorg/apache/commons/codec/digest4util/Sha2Crypt;");
                return;
            }
        }
        SALT_PATTERN = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");
    }

    public Sha2Crypt() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String sha256Crypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? sha256Crypt(bArr, null) : (String) invokeL.objValue;
    }

    public static String sha2Crypt(byte[] bArr, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        int i3;
        boolean z;
        byte b2;
        byte[] bArr2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bArr, str, str2, Integer.valueOf(i2), str3})) == null) {
            int length = bArr.length;
            if (str != null) {
                Matcher matcher = SALT_PATTERN.matcher(str);
                if (matcher.find()) {
                    if (matcher.group(3) != null) {
                        i3 = Math.max(1000, Math.min((int) ROUNDS_MAX, Integer.parseInt(matcher.group(3))));
                        z = true;
                    } else {
                        i3 = 5000;
                        z = false;
                    }
                    String group = matcher.group(4);
                    byte[] bytes = group.getBytes(Charsets.UTF_8);
                    int length2 = bytes.length;
                    MessageDigest digest = DigestUtils.getDigest(str3);
                    digest.update(bArr);
                    digest.update(bytes);
                    MessageDigest digest2 = DigestUtils.getDigest(str3);
                    digest2.update(bArr);
                    digest2.update(bytes);
                    digest2.update(bArr);
                    byte[] digest3 = digest2.digest();
                    int length3 = bArr.length;
                    while (length3 > i2) {
                        digest.update(digest3, 0, i2);
                        length3 -= i2;
                    }
                    digest.update(digest3, 0, length3);
                    for (int length4 = bArr.length; length4 > 0; length4 >>= 1) {
                        if ((length4 & 1) != 0) {
                            digest.update(digest3, 0, i2);
                        } else {
                            digest.update(bArr);
                        }
                    }
                    byte[] digest4 = digest.digest();
                    MessageDigest digest5 = DigestUtils.getDigest(str3);
                    for (int i5 = 1; i5 <= length; i5++) {
                        digest5.update(bArr);
                    }
                    byte[] digest6 = digest5.digest();
                    byte[] bArr3 = new byte[length];
                    int i6 = 0;
                    while (i6 < length - i2) {
                        System.arraycopy(digest6, 0, bArr3, i6, i2);
                        i6 += i2;
                    }
                    System.arraycopy(digest6, 0, bArr3, i6, length - i6);
                    MessageDigest digest7 = DigestUtils.getDigest(str3);
                    for (int i7 = 1; i7 <= (digest4[0] & 255) + 16; i7++) {
                        digest7.update(bytes);
                    }
                    byte[] digest8 = digest7.digest();
                    byte[] bArr4 = new byte[length2];
                    int i8 = 0;
                    while (i8 < length2 - i2) {
                        System.arraycopy(digest8, 0, bArr4, i8, i2);
                        i8 += i2;
                    }
                    System.arraycopy(digest8, 0, bArr4, i8, length2 - i8);
                    MessageDigest messageDigest = digest;
                    int i9 = 0;
                    while (i9 <= i3 - 1) {
                        messageDigest = DigestUtils.getDigest(str3);
                        int i10 = i9 & 1;
                        if (i10 != 0) {
                            bArr2 = bytes;
                            i4 = 0;
                            messageDigest.update(bArr3, 0, length);
                        } else {
                            bArr2 = bytes;
                            i4 = 0;
                            messageDigest.update(digest4, 0, i2);
                        }
                        if (i9 % 3 != 0) {
                            messageDigest.update(bArr4, i4, length2);
                        }
                        if (i9 % 7 != 0) {
                            messageDigest.update(bArr3, i4, length);
                        }
                        if (i10 != 0) {
                            messageDigest.update(digest4, i4, i2);
                        } else {
                            messageDigest.update(bArr3, i4, length);
                        }
                        digest4 = messageDigest.digest();
                        i9++;
                        bytes = bArr2;
                    }
                    byte[] bArr5 = bytes;
                    StringBuilder sb = new StringBuilder(str2);
                    if (z) {
                        sb.append(ROUNDS_PREFIX);
                        sb.append(i3);
                        sb.append("$");
                    }
                    sb.append(group);
                    sb.append("$");
                    if (i2 == 32) {
                        B64.b64from24bit(digest4[0], digest4[10], digest4[20], 4, sb);
                        B64.b64from24bit(digest4[21], digest4[1], digest4[11], 4, sb);
                        B64.b64from24bit(digest4[12], digest4[22], digest4[2], 4, sb);
                        B64.b64from24bit(digest4[3], digest4[13], digest4[23], 4, sb);
                        B64.b64from24bit(digest4[24], digest4[4], digest4[14], 4, sb);
                        B64.b64from24bit(digest4[15], digest4[25], digest4[5], 4, sb);
                        B64.b64from24bit(digest4[6], digest4[16], digest4[26], 4, sb);
                        B64.b64from24bit(digest4[27], digest4[7], digest4[17], 4, sb);
                        B64.b64from24bit(digest4[18], digest4[28], digest4[8], 4, sb);
                        B64.b64from24bit(digest4[9], digest4[19], digest4[29], 4, sb);
                        B64.b64from24bit((byte) 0, digest4[31], digest4[30], 3, sb);
                        b2 = 0;
                    } else {
                        B64.b64from24bit(digest4[0], digest4[21], digest4[42], 4, sb);
                        B64.b64from24bit(digest4[22], digest4[43], digest4[1], 4, sb);
                        B64.b64from24bit(digest4[44], digest4[2], digest4[23], 4, sb);
                        B64.b64from24bit(digest4[3], digest4[24], digest4[45], 4, sb);
                        B64.b64from24bit(digest4[25], digest4[46], digest4[4], 4, sb);
                        B64.b64from24bit(digest4[47], digest4[5], digest4[26], 4, sb);
                        B64.b64from24bit(digest4[6], digest4[27], digest4[48], 4, sb);
                        B64.b64from24bit(digest4[28], digest4[49], digest4[7], 4, sb);
                        B64.b64from24bit(digest4[50], digest4[8], digest4[29], 4, sb);
                        B64.b64from24bit(digest4[9], digest4[30], digest4[51], 4, sb);
                        B64.b64from24bit(digest4[31], digest4[52], digest4[10], 4, sb);
                        B64.b64from24bit(digest4[53], digest4[11], digest4[32], 4, sb);
                        B64.b64from24bit(digest4[12], digest4[33], digest4[54], 4, sb);
                        B64.b64from24bit(digest4[34], digest4[55], digest4[13], 4, sb);
                        B64.b64from24bit(digest4[56], digest4[14], digest4[35], 4, sb);
                        B64.b64from24bit(digest4[15], digest4[36], digest4[57], 4, sb);
                        B64.b64from24bit(digest4[37], digest4[58], digest4[16], 4, sb);
                        B64.b64from24bit(digest4[59], digest4[17], digest4[38], 4, sb);
                        B64.b64from24bit(digest4[18], digest4[39], digest4[60], 4, sb);
                        B64.b64from24bit(digest4[40], digest4[61], digest4[19], 4, sb);
                        B64.b64from24bit(digest4[62], digest4[20], digest4[41], 4, sb);
                        b2 = 0;
                        B64.b64from24bit((byte) 0, (byte) 0, digest4[63], 2, sb);
                    }
                    Arrays.fill(digest8, b2);
                    Arrays.fill(bArr3, b2);
                    Arrays.fill(bArr4, b2);
                    messageDigest.reset();
                    digest7.reset();
                    Arrays.fill(bArr, b2);
                    Arrays.fill(bArr5, b2);
                    return sb.toString();
                }
                throw new IllegalArgumentException("Invalid salt value: " + str);
            }
            throw new IllegalArgumentException("Salt must not be null");
        }
        return (String) invokeCommon.objValue;
    }

    public static String sha512Crypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? sha512Crypt(bArr, null) : (String) invokeL.objValue;
    }

    public static String sha256Crypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, str)) == null) {
            if (str == null) {
                str = SHA256_PREFIX + B64.getRandomSalt(8);
            }
            return sha2Crypt(bArr, str, SHA256_PREFIX, 32, "SHA-256");
        }
        return (String) invokeLL.objValue;
    }

    public static String sha512Crypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, str)) == null) {
            if (str == null) {
                str = SHA512_PREFIX + B64.getRandomSalt(8);
            }
            return sha2Crypt(bArr, str, SHA512_PREFIX, 64, "SHA-512");
        }
        return (String) invokeLL.objValue;
    }
}
