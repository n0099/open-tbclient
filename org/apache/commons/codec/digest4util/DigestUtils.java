package org.apache.commons.codec.digest4util;

import android.annotation.SuppressLint;
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.base.binary4util.CodecStringUtils;
import org.apache.commons.base.binary4util.Hex;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes8.dex */
public class DigestUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STREAM_BUFFER_LENGTH = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public final MessageDigest messageDigest;

    @Deprecated
    public DigestUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.messageDigest = null;
    }

    public static MessageDigest getMd2Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return getDigest(MessageDigestAlgorithms.MD2);
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static MessageDigest getMd5Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return getDigest("MD5");
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static MessageDigest getSha1Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return getDigest("SHA-1");
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static MessageDigest getSha256Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return getDigest("SHA-256");
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static MessageDigest getSha384Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return getDigest("SHA-384");
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static MessageDigest getSha512Digest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return getDigest("SHA-512");
        }
        return (MessageDigest) invokeV.objValue;
    }

    @Deprecated
    public static MessageDigest getShaDigest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return getSha1Digest();
        }
        return (MessageDigest) invokeV.objValue;
    }

    public MessageDigest getMessageDigest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.messageDigest;
        }
        return (MessageDigest) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DigestUtils(String str) {
        this(getDigest(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((MessageDigest) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DigestUtils(MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageDigest};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.messageDigest = messageDigest;
    }

    public static MessageDigest getDigest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            try {
                return MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return (MessageDigest) invokeL.objValue;
    }

    public static boolean isAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (getDigest(str, null) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] md2(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) {
            return digest(getMd2Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md2Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, inputStream)) == null) {
            return Hex.encodeHexString(md2(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] md5(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, inputStream)) == null) {
            return digest(getMd5Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md5Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, inputStream)) == null) {
            return Hex.encodeHexString(md5(inputStream));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static byte[] sha(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, inputStream)) == null) {
            return sha1(inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] sha1(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, inputStream)) == null) {
            return digest(getSha1Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha1Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, inputStream)) == null) {
            return Hex.encodeHexString(sha1(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha256(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, inputStream)) == null) {
            return digest(getSha256Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha256Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, inputStream)) == null) {
            return Hex.encodeHexString(sha256(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha384(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, inputStream)) == null) {
            return digest(getSha384Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha384Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, inputStream)) == null) {
            return Hex.encodeHexString(sha384(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha512(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, inputStream)) == null) {
            return digest(getSha512Digest(), inputStream);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha512Hex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, inputStream)) == null) {
            return Hex.encodeHexString(sha512(inputStream));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String shaHex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, inputStream)) == null) {
            return sha1Hex(inputStream);
        }
        return (String) invokeL.objValue;
    }

    public byte[] digest(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            return updateDigest(this.messageDigest, file).digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public String digestAsHex(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, file)) == null) {
            return Hex.encodeHexString(digest(file));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] digest(MessageDigest messageDigest, File file) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, messageDigest, file)) == null) {
            return updateDigest(messageDigest, file).digest();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static MessageDigest getDigest(String str, MessageDigest messageDigest) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, messageDigest)) == null) {
            try {
                return MessageDigest.getInstance(str);
            } catch (Exception unused) {
                return messageDigest;
            }
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, File file) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, messageDigest, file)) == null) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                return updateDigest(messageDigest, bufferedInputStream);
            } finally {
                bufferedInputStream.close();
            }
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public static byte[] digest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, messageDigest, inputStream)) == null) {
            return updateDigest(messageDigest, inputStream).digest();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, InputStream inputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65596, null, messageDigest, inputStream)) == null) {
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr, 0, 1024);
            while (read > -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr, 0, 1024);
            }
            return messageDigest;
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public static byte[] digest(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, messageDigest, byteBuffer)) == null) {
            messageDigest.update(byteBuffer);
            return messageDigest.digest();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65597, null, messageDigest, str)) == null) {
            messageDigest.update(CodecStringUtils.getBytesUtf8(str));
            return messageDigest;
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public static byte[] digest(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, messageDigest, bArr)) == null) {
            return messageDigest.digest(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, messageDigest, byteBuffer)) == null) {
            messageDigest.update(byteBuffer);
            return messageDigest;
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public static byte[] md2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            return md2(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md2Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            return Hex.encodeHexString(md2(str));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            return md5(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md5Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            return Hex.encodeHexString(md5(str));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static byte[] sha(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return sha1(str);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] sha1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            return sha1(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha1Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            return Hex.encodeHexString(sha1(str));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha256(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            return sha256(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha256Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            return Hex.encodeHexString(sha256(str));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha384(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            return sha384(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha384Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            return Hex.encodeHexString(sha384(str));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha512(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, str)) == null) {
            return sha512(CodecStringUtils.getBytesUtf8(str));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha512Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, str)) == null) {
            return Hex.encodeHexString(sha512(str));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String shaHex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            return sha1Hex(str);
        }
        return (String) invokeL.objValue;
    }

    public byte[] digest(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream)) == null) {
            return updateDigest(this.messageDigest, inputStream).digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public String digestAsHex(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, inputStream)) == null) {
            return Hex.encodeHexString(digest(inputStream));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] md2(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bArr)) == null) {
            return getMd2Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md2Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) {
            return Hex.encodeHexString(md2(bArr));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] md5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) {
            return getMd5Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String md5Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bArr)) == null) {
            return Hex.encodeHexString(md5(bArr));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static byte[] sha(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, bArr)) == null) {
            return sha1(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] sha1(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, bArr)) == null) {
            return getSha1Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha1Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, bArr)) == null) {
            return Hex.encodeHexString(sha1(bArr));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha256(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, bArr)) == null) {
            return getSha256Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha256Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, bArr)) == null) {
            return Hex.encodeHexString(sha256(bArr));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha384(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, bArr)) == null) {
            return getSha384Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha384Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, bArr)) == null) {
            return Hex.encodeHexString(sha384(bArr));
        }
        return (String) invokeL.objValue;
    }

    public static byte[] sha512(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, bArr)) == null) {
            return getSha512Digest().digest(bArr);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String sha512Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, bArr)) == null) {
            return Hex.encodeHexString(sha512(bArr));
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String shaHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, bArr)) == null) {
            return sha1Hex(bArr);
        }
        return (String) invokeL.objValue;
    }

    public byte[] digest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return updateDigest(this.messageDigest, str).digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public String digestAsHex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return Hex.encodeHexString(digest(str));
        }
        return (String) invokeL.objValue;
    }

    public static MessageDigest updateDigest(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65599, null, messageDigest, bArr)) == null) {
            messageDigest.update(bArr);
            return messageDigest;
        }
        return (MessageDigest) invokeLL.objValue;
    }

    public byte[] digest(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            return updateDigest(this.messageDigest, byteBuffer).digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public String digestAsHex(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            return Hex.encodeHexString(digest(byteBuffer));
        }
        return (String) invokeL.objValue;
    }

    public byte[] digest(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            return updateDigest(this.messageDigest, bArr).digest();
        }
        return (byte[]) invokeL.objValue;
    }

    public String digestAsHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            return Hex.encodeHexString(digest(bArr));
        }
        return (String) invokeL.objValue;
    }
}
