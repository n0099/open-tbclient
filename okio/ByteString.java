package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ByteString EMPTY;
    public static final char[] HEX_DIGITS;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1084478015, "Lokio/ByteString;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1084478015, "Lokio/ByteString;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        EMPTY = of(new byte[0]);
    }

    public ByteString(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = bArr;
    }

    public static int codePointIndexToCharIndex(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            int length = str.length();
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                if (i4 == i2) {
                    return i3;
                }
                int codePointAt = str.codePointAt(i3);
                if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                    return -1;
                }
                i4++;
                i3 += Character.charCount(codePointAt);
            }
            return str.length();
        }
        return invokeLI.intValue;
    }

    @Nullable
    public static ByteString decodeBase64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null) {
                byte[] decode = Base64.decode(str);
                if (decode != null) {
                    return new ByteString(decode);
                }
                return null;
            }
            throw new IllegalArgumentException("base64 == null");
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString decodeHex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                if (str.length() % 2 == 0) {
                    int length = str.length() / 2;
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ((decodeHexDigit(str.charAt(i3)) << 4) + decodeHexDigit(str.charAt(i3 + 1)));
                    }
                    return of(bArr);
                }
                throw new IllegalArgumentException("Unexpected hex string: " + str);
            }
            throw new IllegalArgumentException("hex == null");
        }
        return (ByteString) invokeL.objValue;
    }

    public static int decodeHexDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    private ByteString digest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            try {
                return of(MessageDigest.getInstance(str).digest(this.data));
            } catch (NoSuchAlgorithmException e2) {
                throw new AssertionError(e2);
            }
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString encodeString(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, charset)) == null) {
            if (str != null) {
                if (charset != null) {
                    return new ByteString(str.getBytes(charset));
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("s == null");
        }
        return (ByteString) invokeLL.objValue;
    }

    public static ByteString encodeUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str != null) {
                ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
                byteString.utf8 = str;
                return byteString;
            }
            throw new IllegalArgumentException("s == null");
        }
        return (ByteString) invokeL.objValue;
    }

    private ByteString hmac(String str, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, str, byteString)) == null) {
            try {
                Mac mac = Mac.getInstance(str);
                mac.init(new SecretKeySpec(byteString.toByteArray(), str));
                return of(mac.doFinal(this.data));
            } catch (InvalidKeyException e2) {
                throw new IllegalArgumentException(e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new AssertionError(e3);
            }
        }
        return (ByteString) invokeLL.objValue;
    }

    public static ByteString of(byte... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            if (bArr != null) {
                return new ByteString((byte[]) bArr.clone());
            }
            throw new IllegalArgumentException("data == null");
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString read(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, inputStream, i2)) == null) {
            if (inputStream != null) {
                if (i2 >= 0) {
                    byte[] bArr = new byte[i2];
                    int i3 = 0;
                    while (i3 < i2) {
                        int read = inputStream.read(bArr, i3, i2 - i3);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        i3 += read;
                    }
                    return new ByteString(bArr);
                }
                throw new IllegalArgumentException("byteCount < 0: " + i2);
            }
            throw new IllegalArgumentException("in == null");
        }
        return (ByteString) invokeLI.objValue;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, objectInputStream) == null) {
            ByteString read = read(objectInputStream, objectInputStream.readInt());
            try {
                Field declaredField = ByteString.class.getDeclaredField("data");
                declaredField.setAccessible(true);
                declaredField.set(this, read.data);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
                throw new AssertionError();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, objectOutputStream) == null) {
            objectOutputStream.writeInt(this.data.length);
            objectOutputStream.write(this.data);
        }
    }

    public ByteBuffer asByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ByteBuffer.wrap(this.data).asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    public String base64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Base64.encode(this.data) : (String) invokeV.objValue;
    }

    public String base64Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Base64.encodeUrl(this.data) : (String) invokeV.objValue;
    }

    public final boolean endsWith(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteString)) == null) ? rangeEquals(size() - byteString.size(), byteString, 0, byteString.size()) : invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteString) {
                ByteString byteString = (ByteString) obj;
                int size = byteString.size();
                byte[] bArr = this.data;
                if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public byte getByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.data[i2] : invokeI.byteValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.hashCode;
            if (i2 != 0) {
                return i2;
            }
            int hashCode = Arrays.hashCode(this.data);
            this.hashCode = hashCode;
            return hashCode;
        }
        return invokeV.intValue;
    }

    public String hex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            byte[] bArr = this.data;
            char[] cArr = new char[bArr.length * 2];
            int i2 = 0;
            for (byte b2 : bArr) {
                int i3 = i2 + 1;
                char[] cArr2 = HEX_DIGITS;
                cArr[i2] = cArr2[(b2 >> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeV.objValue;
    }

    public ByteString hmacSha1(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, byteString)) == null) ? hmac("HmacSHA1", byteString) : (ByteString) invokeL.objValue;
    }

    public ByteString hmacSha256(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, byteString)) == null) ? hmac("HmacSHA256", byteString) : (ByteString) invokeL.objValue;
    }

    public ByteString hmacSha512(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, byteString)) == null) ? hmac("HmacSHA512", byteString) : (ByteString) invokeL.objValue;
    }

    public final int indexOf(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, byteString)) == null) ? indexOf(byteString.internalArray(), 0) : invokeL.intValue;
    }

    public byte[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.data : (byte[]) invokeV.objValue;
    }

    public final int lastIndexOf(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, byteString)) == null) ? lastIndexOf(byteString.internalArray(), size()) : invokeL.intValue;
    }

    public ByteString md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? digest("MD5") : (ByteString) invokeV.objValue;
    }

    public boolean rangeEquals(int i2, ByteString byteString, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), byteString, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? byteString.rangeEquals(i3, this.data, i2, i4) : invokeCommon.booleanValue;
    }

    public ByteString sha1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? digest("SHA-1") : (ByteString) invokeV.objValue;
    }

    public ByteString sha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? digest("SHA-256") : (ByteString) invokeV.objValue;
    }

    public ByteString sha512() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? digest("SHA-512") : (ByteString) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.data.length : invokeV.intValue;
    }

    public final boolean startsWith(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, byteString)) == null) ? rangeEquals(0, byteString, 0, byteString.size()) : invokeL.booleanValue;
    }

    public String string(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, charset)) == null) {
            if (charset != null) {
                return new String(this.data, charset);
            }
            throw new IllegalArgumentException("charset == null");
        }
        return (String) invokeL.objValue;
    }

    public ByteString substring(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) ? substring(i2, this.data.length) : (ByteString) invokeI.objValue;
    }

    public ByteString toAsciiLowercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048611, this)) != null) {
            return (ByteString) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i2++;
        }
    }

    public ByteString toAsciiUppercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048612, this)) != null) {
            return (ByteString) invokeV.objValue;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i3] = (byte) (b3 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i2++;
        }
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (byte[]) this.data.clone() : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.data.length == 0) {
                return "[size=0]";
            }
            String utf8 = utf8();
            int codePointIndexToCharIndex = codePointIndexToCharIndex(utf8, 64);
            if (codePointIndexToCharIndex == -1) {
                if (this.data.length <= 64) {
                    return "[hex=" + hex() + PreferencesUtil.RIGHT_MOUNT;
                }
                return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
            }
            String replace = utf8.substring(0, codePointIndexToCharIndex).replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace(StringUtils.LF, "\\n").replace(StringUtils.CR, "\\r");
            if (codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + this.data.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public String utf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            String str = this.utf8;
            if (str != null) {
                return str;
            }
            String str2 = new String(this.data, Util.UTF_8);
            this.utf8 = str2;
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void write(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, outputStream) == null) {
            if (outputStream != null) {
                outputStream.write(this.data);
                return;
            }
            throw new IllegalArgumentException("out == null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
            int size = size();
            int size2 = byteString.size();
            int min = Math.min(size, size2);
            for (int i2 = 0; i2 < min; i2++) {
                int i3 = getByte(i2) & 255;
                int i4 = byteString.getByte(i2) & 255;
                if (i3 != i4) {
                    return i3 < i4 ? -1 : 1;
                }
            }
            if (size == size2) {
                return 0;
            }
            return size < size2 ? -1 : 1;
        }
        return invokeL.intValue;
    }

    public final boolean endsWith(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) ? rangeEquals(size() - bArr.length, bArr, 0, bArr.length) : invokeL.booleanValue;
    }

    public final int indexOf(ByteString byteString, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, byteString, i2)) == null) ? indexOf(byteString.internalArray(), i2) : invokeLI.intValue;
    }

    public final int lastIndexOf(ByteString byteString, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, byteString, i2)) == null) ? lastIndexOf(byteString.internalArray(), i2) : invokeLI.intValue;
    }

    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 >= 0) {
                byte[] bArr2 = this.data;
                if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && Util.arrayRangeEquals(bArr2, i2, bArr, i3, i4)) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean startsWith(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bArr)) == null) ? rangeEquals(0, bArr, 0, bArr.length) : invokeL.booleanValue;
    }

    public ByteString substring(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048610, this, i2, i3)) == null) {
            if (i2 >= 0) {
                byte[] bArr = this.data;
                if (i3 > bArr.length) {
                    throw new IllegalArgumentException("endIndex > length(" + this.data.length + SmallTailInfo.EMOTION_SUFFIX);
                }
                int i4 = i3 - i2;
                if (i4 >= 0) {
                    if (i2 == 0 && i3 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.data, i2, bArr2, 0, i4);
                    return new ByteString(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException("beginIndex < 0");
        }
        return (ByteString) invokeII.objValue;
    }

    public static ByteString of(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65548, null, bArr, i2, i3)) == null) {
            if (bArr != null) {
                Util.checkOffsetAndCount(bArr.length, i2, i3);
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i2, bArr2, 0, i3);
                return new ByteString(bArr2);
            }
            throw new IllegalArgumentException("data == null");
        }
        return (ByteString) invokeLII.objValue;
    }

    public final int indexOf(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, bArr)) == null) ? indexOf(bArr, 0) : invokeL.intValue;
    }

    public final int lastIndexOf(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bArr)) == null) ? lastIndexOf(bArr, size()) : invokeL.intValue;
    }

    public void write(Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, buffer) == null) {
            byte[] bArr = this.data;
            buffer.write(bArr, 0, bArr.length);
        }
    }

    public int indexOf(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, bArr, i2)) == null) {
            int length = this.data.length - bArr.length;
            for (int max = Math.max(i2, 0); max <= length; max++) {
                if (Util.arrayRangeEquals(this.data, max, bArr, 0, bArr.length)) {
                    return max;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public int lastIndexOf(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, bArr, i2)) == null) {
            for (int min = Math.min(i2, this.data.length - bArr.length); min >= 0; min--) {
                if (Util.arrayRangeEquals(this.data, min, bArr, 0, bArr.length)) {
                    return min;
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, byteBuffer)) == null) {
            if (byteBuffer != null) {
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException("data == null");
        }
        return (ByteString) invokeL.objValue;
    }
}
