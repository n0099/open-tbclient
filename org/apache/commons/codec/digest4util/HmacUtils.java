package org.apache.commons.codec.digest4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.base.binary4util.CodecStringUtils;
import org.apache.commons.base.binary4util.Hex;
/* loaded from: classes8.dex */
public final class HmacUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STREAM_BUFFER_LENGTH = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public final Mac mac;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public HmacUtils() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Mac) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HmacUtils(String str, String str2) {
        this(str, CodecStringUtils.getBytesUtf8(str2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static Mac getInitializedMac(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, bArr)) == null) {
            if (bArr != null) {
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, str);
                    Mac mac = Mac.getInstance(str);
                    mac.init(secretKeySpec);
                    return mac;
                } catch (InvalidKeyException e) {
                    throw new IllegalArgumentException(e);
                } catch (NoSuchAlgorithmException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
            throw new IllegalArgumentException("Null key");
        }
        return (Mac) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HmacUtils(String str, byte[] bArr) {
        this(getInitializedMac(str, bArr));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Mac) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public HmacUtils(Mac mac) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mac};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mac = mac;
    }

    @Deprecated
    public static Mac getHmacMd5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            return getInitializedMac(HmacAlgorithms.HMAC_MD5, bArr);
        }
        return (Mac) invokeL.objValue;
    }

    @Deprecated
    public static Mac getHmacSha1(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            return getInitializedMac(HmacAlgorithms.HMAC_SHA_1, bArr);
        }
        return (Mac) invokeL.objValue;
    }

    @Deprecated
    public static Mac getHmacSha256(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            return getInitializedMac(HmacAlgorithms.HMAC_SHA_256, bArr);
        }
        return (Mac) invokeL.objValue;
    }

    @Deprecated
    public static Mac getHmacSha384(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            return getInitializedMac(HmacAlgorithms.HMAC_SHA_384, bArr);
        }
        return (Mac) invokeL.objValue;
    }

    @Deprecated
    public static Mac getHmacSha512(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            return getInitializedMac(HmacAlgorithms.HMAC_SHA_512, bArr);
        }
        return (Mac) invokeL.objValue;
    }

    public static boolean isAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            try {
                Mac.getInstance(str);
                return true;
            } catch (NoSuchAlgorithmException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public byte[] hmac(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                return hmac(bufferedInputStream);
            } finally {
                bufferedInputStream.close();
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public String hmacHex(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, file)) == null) {
            return Hex.encodeHexString(hmac(file));
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HmacUtils(HmacAlgorithms hmacAlgorithms, String str) {
        this(hmacAlgorithms.getName(), CodecStringUtils.getBytesUtf8(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hmacAlgorithms, str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HmacUtils(HmacAlgorithms hmacAlgorithms, byte[] bArr) {
        this(hmacAlgorithms.getName(), bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hmacAlgorithms, bArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
    }

    public static Mac getInitializedMac(HmacAlgorithms hmacAlgorithms, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, hmacAlgorithms, bArr)) == null) {
            return getInitializedMac(hmacAlgorithms.getName(), bArr);
        }
        return (Mac) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacMd5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, str).hmac(str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacMd5Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, str).hmacHex(str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha1(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, str).hmac(str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha1Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, str).hmacHex(str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha256(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, str).hmac(str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha256Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, str).hmacHex(str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha384(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, str).hmac(str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha384Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, str).hmacHex(str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha512(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, str).hmac(str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha512Hex(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, str, str2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, str).hmacHex(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static Mac updateHmac(Mac mac, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, mac, inputStream)) == null) {
            mac.reset();
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr, 0, 1024);
            while (read > -1) {
                mac.update(bArr, 0, read);
                read = inputStream.read(bArr, 0, 1024);
            }
            return mac;
        }
        return (Mac) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacMd5(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, bArr).hmac(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacMd5Hex(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, bArr).hmacHex(inputStream);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha1(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, bArr).hmac(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha1Hex(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, bArr).hmacHex(inputStream);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha256(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, bArr).hmac(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha256Hex(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, bArr).hmacHex(inputStream);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha384(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, bArr).hmac(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha384Hex(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, bArr).hmacHex(inputStream);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha512(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, bArr).hmac(inputStream);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha512Hex(byte[] bArr, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, bArr, inputStream)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, bArr).hmacHex(inputStream);
        }
        return (String) invokeLL.objValue;
    }

    public static Mac updateHmac(Mac mac, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, mac, str)) == null) {
            mac.reset();
            mac.update(CodecStringUtils.getBytesUtf8(str));
            return mac;
        }
        return (Mac) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacMd5(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, bArr).hmac(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacMd5Hex(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_MD5, bArr).hmacHex(bArr2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha1(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, bArr).hmac(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha1Hex(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_1, bArr).hmacHex(bArr2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha256(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, bArr).hmac(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha256Hex(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_256, bArr).hmacHex(bArr2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha384(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, bArr).hmac(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha384Hex(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_384, bArr).hmacHex(bArr2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] hmacSha512(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, bArr).hmac(bArr2);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Deprecated
    public static String hmacSha512Hex(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, bArr, bArr2)) == null) {
            return new HmacUtils(HmacAlgorithms.HMAC_SHA_512, bArr).hmacHex(bArr2);
        }
        return (String) invokeLL.objValue;
    }

    public static Mac updateHmac(Mac mac, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, null, mac, bArr)) == null) {
            mac.reset();
            mac.update(bArr);
            return mac;
        }
        return (Mac) invokeLL.objValue;
    }

    public static boolean isAvailable(HmacAlgorithms hmacAlgorithms) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, hmacAlgorithms)) == null) {
            try {
                Mac.getInstance(hmacAlgorithms.getName());
                return true;
            } catch (NoSuchAlgorithmException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public byte[] hmac(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read > -1) {
                    this.mac.update(bArr, 0, read);
                } else {
                    return this.mac.doFinal();
                }
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public String hmacHex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, inputStream)) == null) {
            return Hex.encodeHexString(hmac(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public byte[] hmac(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.mac.doFinal(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public String hmacHex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return Hex.encodeHexString(hmac(str));
        }
        return (String) invokeL.objValue;
    }

    public byte[] hmac(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            this.mac.update(byteBuffer);
            return this.mac.doFinal();
        }
        return (byte[]) invokeL.objValue;
    }

    public String hmacHex(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            return Hex.encodeHexString(hmac(byteBuffer));
        }
        return (String) invokeL.objValue;
    }

    public byte[] hmac(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            return this.mac.doFinal(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public String hmacHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            return Hex.encodeHexString(hmac(bArr));
        }
        return (String) invokeL.objValue;
    }
}
