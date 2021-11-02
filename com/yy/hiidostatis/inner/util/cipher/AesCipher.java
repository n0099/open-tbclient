package com.yy.hiidostatis.inner.util.cipher;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class AesCipher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_CBC_NOPADDING = "AES/CBC/NoPadding";
    public static final int BLOCK_SIZE = 16;
    public static final ThreadLocal<Cipher> Cipher_AES_CBC_NOPADDING;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] m_key;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2013108956, "Lcom/yy/hiidostatis/inner/util/cipher/AesCipher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2013108956, "Lcom/yy/hiidostatis/inner/util/cipher/AesCipher;");
                return;
            }
        }
        Cipher_AES_CBC_NOPADDING = new ThreadLocal<Cipher>() { // from class: com.yy.hiidostatis.inner.util.cipher.AesCipher.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public Cipher initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    try {
                        return Cipher.getInstance("AES/CBC/NoPadding");
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
                return (Cipher) invokeV.objValue;
            }
        };
    }

    public AesCipher(byte[] bArr) {
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
        if (bArr != null) {
            this.m_key = TextUtils.md5byte(bArr);
            return;
        }
        throw new IllegalArgumentException("Key is null");
    }

    private IvParameterSpec createIv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            byte[] bArr = this.m_key;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return new IvParameterSpec(bArr2);
        }
        return (IvParameterSpec) invokeV.objValue;
    }

    private byte[] fillBlock(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bArr)) == null) {
            int length = bArr.length % 16;
            if (length == 0) {
                return bArr;
            }
            byte[] bArr2 = new byte[length == 0 ? bArr.length : (bArr.length + 16) - length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            try {
                Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
                cipher.init(2, new SecretKeySpec(this.m_key, "AES"), createIv());
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] decryptTlogBase64(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int decimalCharLength = TextUtils.getDecimalCharLength(str);
            byte[] decode = Base64Util.decode(str.substring(8));
            if (decode == null || decode.length == 0) {
                return decode;
            }
            byte[] decrypt = decrypt(decode);
            if (decimalCharLength <= decrypt.length) {
                byte[] bArr = new byte[decimalCharLength];
                System.arraycopy(decrypt, 0, bArr, 0, decimalCharLength);
                return bArr;
            }
            throw new Exception(String.format("Expect data length [ %d ] ,but get [ %d ].", Integer.valueOf(decimalCharLength), Integer.valueOf(decrypt.length)));
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] decryptTlogHex(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int decimalCharLength = TextUtils.getDecimalCharLength(str);
            byte[] hex2Bytes = TextUtils.hex2Bytes(str, 8);
            if (hex2Bytes == null || hex2Bytes.length == 0) {
                return hex2Bytes;
            }
            byte[] decrypt = decrypt(hex2Bytes);
            if (decimalCharLength <= decrypt.length) {
                byte[] bArr = new byte[decimalCharLength];
                System.arraycopy(decrypt, 0, bArr, 0, decimalCharLength);
                return bArr;
            }
            throw new Exception(String.format("Expect data length [ %d ] ,but get [ %d ].", Integer.valueOf(decimalCharLength), Integer.valueOf(decrypt.length)));
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            try {
                Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
                cipher.init(1, new SecretKeySpec(this.m_key, "AES"), createIv());
                return cipher.doFinal(fillBlock(bArr));
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public String encryptTlogBytes(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            byte[] encrypt = encrypt(bArr);
            if (encrypt != null) {
                StringBuilder sb = new StringBuilder(bArr.length + (encrypt.length * 2));
                sb.append(TextUtils.length2DecimalChar(bArr.length));
                sb.append(TextUtils.bytes2hex(encrypt));
                return sb.toString();
            }
            throw new Exception("EncryptData is null");
        }
        return (String) invokeL.objValue;
    }

    public String encryptTlogBytesBase64(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            byte[] encrypt = encrypt(bArr);
            if (encrypt != null) {
                StringBuilder sb = new StringBuilder(bArr.length + (encrypt.length * 2));
                sb.append(TextUtils.length2DecimalChar(bArr.length));
                sb.append(Base64Util.encode(encrypt));
                return sb.toString();
            }
            throw new Exception("EncryptData is null");
        }
        return (String) invokeL.objValue;
    }

    public byte[] decrypt(byte[] bArr, int i2, int i3) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
            try {
                Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
                cipher.init(2, new SecretKeySpec(this.m_key, "AES"), createIv());
                return cipher.doFinal(bArr, i2, i3);
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
        return (byte[]) invokeLII.objValue;
    }
}
