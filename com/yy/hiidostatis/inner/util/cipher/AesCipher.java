package com.yy.hiidostatis.inner.util.cipher;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class AesCipher {
    public static final String AES_CBC_NOPADDING = "AES/CBC/NoPadding";
    public static final int BLOCK_SIZE = 16;
    public static final ThreadLocal<Cipher> Cipher_AES_CBC_NOPADDING = new ThreadLocal<Cipher>() { // from class: com.yy.hiidostatis.inner.util.cipher.AesCipher.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() {
            try {
                return Cipher.getInstance("AES/CBC/NoPadding");
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    };
    public final byte[] m_key;

    public AesCipher(byte[] bArr) {
        if (bArr != null) {
            this.m_key = TextUtils.md5byte(bArr);
            return;
        }
        throw new IllegalArgumentException("Key is null");
    }

    private IvParameterSpec createIv() {
        byte[] bArr = this.m_key;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return new IvParameterSpec(bArr2);
    }

    private byte[] fillBlock(byte[] bArr) {
        int length = bArr.length % 16;
        if (length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[length == 0 ? bArr.length : (bArr.length + 16) - length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        try {
            Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
            cipher.init(2, new SecretKeySpec(this.m_key, "AES"), createIv());
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }

    public byte[] decryptTlogBase64(String str) throws Exception {
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

    public byte[] decryptTlogHex(String str) throws Exception {
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

    public byte[] encrypt(byte[] bArr) throws Exception {
        try {
            Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
            cipher.init(1, new SecretKeySpec(this.m_key, "AES"), createIv());
            return cipher.doFinal(fillBlock(bArr));
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }

    public String encryptTlogBytes(byte[] bArr) throws Exception {
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

    public String encryptTlogBytesBase64(byte[] bArr) throws Exception {
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

    public byte[] decrypt(byte[] bArr, int i2, int i3) throws Exception {
        try {
            Cipher cipher = Cipher_AES_CBC_NOPADDING.get();
            cipher.init(2, new SecretKeySpec(this.m_key, "AES"), createIv());
            return cipher.doFinal(bArr, i2, i3);
        } catch (Throwable th) {
            throw new Exception(th);
        }
    }
}
