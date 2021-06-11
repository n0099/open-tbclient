package com.yy.hiidostatis.inner.util.cipher;

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
    public static final String RSA_PADDING = "RSA/ECB/PKCS1Padding";
    public PrivateKey privateKey;
    public PublicKey publicKey;
    public int private_m_flen = 16;
    public int private_m_tail = 5;
    public int public_m_flen = 16;
    public int public_m_tail = 5;
    public final ThreadLocal<Cipher> rsaCipher = new ThreadLocal<Cipher>() { // from class: com.yy.hiidostatis.inner.util.cipher.RsaCipher.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return Cipher.getInstance(RsaCipher.RSA_PADDING);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            } catch (NoSuchPaddingException e3) {
                throw new RuntimeException(e3);
            }
        }
    };

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
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
        for (int i2 = 0; i2 < size; i2++) {
            bArr[i2] = ((Byte) arrayList.get(i2)).byteValue();
        }
        return bArr;
    }

    public byte[] decrypt(byte[] bArr, int i2) throws Exception {
        int length;
        byte[] bArr2 = new byte[(bArr.length / this.private_m_flen) * this.private_m_tail];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < bArr.length) {
            try {
                byte[] decrypt = decrypt(bArr, i3, this.private_m_flen, this.privateKey);
                if (decrypt != null) {
                    if (decrypt.length == this.private_m_tail) {
                        System.arraycopy(decrypt, 0, bArr2, i5, decrypt.length);
                        if (bArr.length - i3 > this.private_m_flen) {
                            length = decrypt.length;
                        } else if (i2 % this.private_m_tail != 0) {
                            byte b2 = decrypt[this.private_m_tail - 1];
                            int i6 = this.private_m_tail - b2;
                            while (i6 < this.private_m_tail && decrypt[i6] == 0) {
                                i6++;
                            }
                            if (i6 == this.private_m_tail - 1) {
                                length = decrypt.length - b2;
                            } else {
                                length = decrypt.length;
                            }
                        } else {
                            length = decrypt.length;
                        }
                        i4 += length;
                        i5 += this.private_m_tail;
                        i3 += this.private_m_flen;
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
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public byte[] decryptTlogAesKey(String str) throws Exception {
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

    public byte[] encrypt(byte[] bArr) throws Exception {
        int length = bArr.length;
        int i2 = this.public_m_tail;
        int i3 = length % i2;
        if (i3 != 0) {
            length = (length + i2) - i3;
        }
        int length2 = bArr.length;
        if (i3 != 0) {
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr = bArr2;
        }
        byte[] bArr3 = new byte[(length / this.public_m_tail) * this.public_m_flen];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < bArr.length && (i5 = length2 - i4) >= this.public_m_tail) {
            try {
                byte[] encrypt = encrypt(bArr, i4, this.public_m_tail, this.publicKey);
                System.arraycopy(encrypt, 0, bArr3, i6, encrypt.length);
                i4 += this.public_m_tail;
                i6 += this.public_m_flen;
            } catch (Throwable th) {
                throw new Exception(th);
            }
        }
        if (i5 > 0 && i4 < bArr.length) {
            bArr[(this.public_m_tail + i4) - 1] = (byte) (this.public_m_tail - i5);
            byte[] encrypt2 = encrypt(bArr, i4, this.public_m_tail, this.publicKey);
            System.arraycopy(encrypt2, 0, bArr3, i6, encrypt2.length);
        }
        return bArr3;
    }

    public String encryptTlogAesKey(byte[] bArr) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] encrypt = encrypt(bArr);
        StringBuilder sb = new StringBuilder((encrypt.length * 2) + 8);
        sb.append(TextUtils.length2DecimalChar(bArr.length));
        sb.append(TextUtils.bytes2hex(encrypt));
        return sb.toString();
    }

    public void loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            this.privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(readAllBytes(inputStream)));
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }

    public void loadPublicKey(InputStream inputStream) throws Exception {
        try {
            this.publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(readAllBytes(inputStream)));
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }

    public void loadPublicKey(String str) throws Exception {
        loadPublicKey(new ByteArrayInputStream(TextUtils.decodeBase64(str)));
    }

    public void loadPrivateKey(File file) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                loadPrivateKey(fileInputStream2);
                try {
                    fileInputStream2.close();
                } catch (Exception e2) {
                    L.debug(this, e2.getMessage(), new Object[0]);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        L.debug(this, e3.getMessage(), new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private byte[] encrypt(byte[] bArr, int i2, int i3, Key key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = this.rsaCipher.get();
        cipher.init(1, key);
        return cipher.doFinal(bArr, i2, i3);
    }

    private byte[] decrypt(byte[] bArr, int i2, int i3, Key key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher = this.rsaCipher.get();
        cipher.init(2, key);
        return cipher.doFinal(bArr, i2, i3);
    }
}
