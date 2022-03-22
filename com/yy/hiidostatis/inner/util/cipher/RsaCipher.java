package com.yy.hiidostatis.inner.util.cipher;

import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes7.dex */
public class RsaCipher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RSA_PADDING = "RSA/ECB/PKCS1Padding";
    public transient /* synthetic */ FieldHolder $fh;
    public PrivateKey privateKey;
    public int private_m_flen;
    public int private_m_tail;
    public PublicKey publicKey;
    public int public_m_flen;
    public int public_m_tail;
    public final ThreadLocal<Cipher> rsaCipher;

    public RsaCipher() {
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
        this.private_m_flen = 16;
        this.private_m_tail = 5;
        this.public_m_flen = 16;
        this.public_m_tail = 5;
        this.rsaCipher = new ThreadLocal<Cipher>(this) { // from class: com.yy.hiidostatis.inner.util.cipher.RsaCipher.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RsaCipher this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public Cipher initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    try {
                        return Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(e2);
                    } catch (NoSuchPaddingException e3) {
                        throw new RuntimeException(e3);
                    }
                }
                return (Cipher) invokeV.objValue;
            }
        };
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            ArrayList arrayList = new ArrayList(512);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            while (true) {
                int read = dataInputStream.read();
                if (read == -1) {
                    break;
                }
                arrayList.add(Byte.valueOf((byte) read));
            }
            int size = arrayList.size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = ((Byte) arrayList.get(i)).byteValue();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] decrypt(byte[] bArr, int i) throws Exception {
        InterceptResult invokeLI;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bArr, i)) == null) {
            byte[] bArr2 = new byte[(bArr.length / this.private_m_flen) * this.private_m_tail];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < bArr.length) {
                try {
                    byte[] decrypt = decrypt(bArr, i2, this.private_m_flen, this.privateKey);
                    if (decrypt != null) {
                        if (decrypt.length == this.private_m_tail) {
                            System.arraycopy(decrypt, 0, bArr2, i4, decrypt.length);
                            if (bArr.length - i2 > this.private_m_flen) {
                                length = decrypt.length;
                            } else if (i % this.private_m_tail != 0) {
                                byte b2 = decrypt[this.private_m_tail - 1];
                                int i5 = this.private_m_tail - b2;
                                while (i5 < this.private_m_tail && decrypt[i5] == 0) {
                                    i5++;
                                }
                                if (i5 == this.private_m_tail - 1) {
                                    length = decrypt.length - b2;
                                } else {
                                    length = decrypt.length;
                                }
                            } else {
                                length = decrypt.length;
                            }
                            i3 += length;
                            i4 += this.private_m_tail;
                            i2 += this.private_m_flen;
                        } else {
                            throw new Exception(String.format("Wrong rsa block, expect tail length [ %d ], get tail length [ %d ]", Integer.valueOf(this.private_m_tail), Integer.valueOf(decrypt.length)));
                        }
                    } else {
                        throw new Exception("Wrong rsa block ,decrypt result is null.");
                    }
                } catch (InvalidKeyException e2) {
                    throw new Exception(e2);
                }
            }
            byte[] bArr3 = new byte[i3];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            return bArr3;
        }
        return (byte[]) invokeLI.objValue;
    }

    public byte[] decryptTlogAesKey(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int decimalCharLength = TextUtils.getDecimalCharLength(str);
            byte[] hex2Bytes = TextUtils.hex2Bytes(str, 8);
            if (hex2Bytes == null || hex2Bytes.length == 0) {
                return null;
            }
            byte[] decrypt = decrypt(hex2Bytes, decimalCharLength);
            if (decrypt.length == decimalCharLength) {
                return decrypt;
            }
            throw new Exception(String.format("Head length [ %d ] != decrypt length [ %d ]", Integer.valueOf(decimalCharLength), Integer.valueOf(decrypt.length)));
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int length = bArr.length;
            int i = this.public_m_tail;
            int i2 = length % i;
            if (i2 != 0) {
                length = (length + i) - i2;
            }
            int length2 = bArr.length;
            if (i2 != 0) {
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
            }
            byte[] bArr3 = new byte[(length / this.public_m_tail) * this.public_m_flen];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < bArr.length && (i4 = length2 - i3) >= this.public_m_tail) {
                try {
                    byte[] encrypt = encrypt(bArr, i3, this.public_m_tail, this.publicKey);
                    System.arraycopy(encrypt, 0, bArr3, i5, encrypt.length);
                    i3 += this.public_m_tail;
                    i5 += this.public_m_flen;
                } catch (Throwable th) {
                    throw new Exception(th);
                }
            }
            if (i4 > 0 && i3 < bArr.length) {
                bArr[(this.public_m_tail + i3) - 1] = (byte) (this.public_m_tail - i4);
                byte[] encrypt2 = encrypt(bArr, i3, this.public_m_tail, this.publicKey);
                System.arraycopy(encrypt2, 0, bArr3, i5, encrypt2.length);
            }
            return bArr3;
        }
        return (byte[]) invokeL.objValue;
    }

    public String encryptTlogAesKey(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            byte[] encrypt = encrypt(bArr);
            StringBuilder sb = new StringBuilder((encrypt.length * 2) + 8);
            sb.append(TextUtils.length2DecimalChar(bArr.length));
            sb.append(TextUtils.bytes2hex(encrypt));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void loadPrivateKey(InputStream inputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, inputStream) == null) {
            try {
                this.privateKey = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(readAllBytes(inputStream)));
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
    }

    public void loadPublicKey(InputStream inputStream) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inputStream) == null) {
            try {
                this.publicKey = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(readAllBytes(inputStream)));
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
    }

    public void loadPublicKey(String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            loadPublicKey(new ByteArrayInputStream(TextUtils.decodeBase64(str)));
        }
    }

    public void loadPrivateKey(File file) throws Exception {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, file) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                loadPrivateKey(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    L.debug(this, e2.getMessage(), new Object[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                        L.debug(this, e3.getMessage(), new Object[0]);
                    }
                }
                throw th;
            }
        }
    }

    private byte[] encrypt(byte[] bArr, int i, int i2, Key key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), key})) == null) {
            Cipher cipher = this.rsaCipher.get();
            cipher.init(1, key);
            return cipher.doFinal(bArr, i, i2);
        }
        return (byte[]) invokeCommon.objValue;
    }

    private byte[] decrypt(byte[] bArr, int i, int i2, Key key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), key})) == null) {
            Cipher cipher = this.rsaCipher.get();
            cipher.init(2, key);
            return cipher.doFinal(bArr, i, i2);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
