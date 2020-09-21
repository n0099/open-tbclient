package org.conscrypt;

import com.baidu.sapi2.utils.e;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.InvocationTargetException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.NativeRef;
/* loaded from: classes8.dex */
public abstract class OpenSSLCipher extends CipherSpi {
    private int blockSize;
    byte[] encodedKey;
    private boolean encrypting;
    byte[] iv;
    Mode mode;
    private Padding padding;

    /* loaded from: classes8.dex */
    enum Mode {
        NONE,
        CBC,
        CTR,
        ECB,
        GCM,
        POLY1305
    }

    abstract void checkSupportedKeySize(int i) throws InvalidKeyException;

    abstract void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException;

    abstract void checkSupportedPadding(Padding padding) throws NoSuchPaddingException;

    abstract int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException;

    abstract void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    abstract String getBaseCipherName();

    abstract int getCipherBlockSize();

    abstract int getOutputSizeForFinal(int i);

    abstract int getOutputSizeForUpdate(int i);

    abstract int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public enum Padding {
        NOPADDING,
        PKCS5PADDING,
        PKCS7PADDING;

        public static Padding getNormalized(String str) {
            Padding valueOf = valueOf(str);
            if (valueOf == PKCS7PADDING) {
                return PKCS5PADDING;
            }
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLCipher() {
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
    }

    OpenSSLCipher(Mode mode, Padding padding) {
        this.mode = Mode.ECB;
        this.padding = Padding.PKCS5PADDING;
        this.mode = mode;
        this.padding = padding;
        this.blockSize = getCipherBlockSize();
    }

    boolean supportsVariableSizeKey() {
        return false;
    }

    boolean supportsVariableSizeIv() {
        return false;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetMode(String str) throws NoSuchAlgorithmException {
        try {
            Mode valueOf = Mode.valueOf(str.toUpperCase(Locale.US));
            checkSupportedMode(valueOf);
            this.mode = valueOf;
        } catch (IllegalArgumentException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException("No such mode: " + str);
            noSuchAlgorithmException.initCause(e);
            throw noSuchAlgorithmException;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineSetPadding(String str) throws NoSuchPaddingException {
        try {
            Padding normalized = Padding.getNormalized(str.toUpperCase(Locale.US));
            checkSupportedPadding(normalized);
            this.padding = normalized;
        } catch (IllegalArgumentException e) {
            NoSuchPaddingException noSuchPaddingException = new NoSuchPaddingException("No such padding: " + str);
            noSuchPaddingException.initCause(e);
            throw noSuchPaddingException;
        }
    }

    Padding getPadding() {
        return this.padding;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetBlockSize() {
        return this.blockSize;
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetOutputSize(int i) {
        return Math.max(getOutputSizeForUpdate(i), getOutputSizeForFinal(i));
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineGetIV() {
        return this.iv;
    }

    @Override // javax.crypto.CipherSpi
    protected AlgorithmParameters engineGetParameters() {
        if (this.iv == null || this.iv.length <= 0) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(getBaseCipherName());
            algorithmParameters.init(new IvParameterSpec(this.iv));
            return algorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (InvalidParameterSpecException e2) {
            return null;
        }
    }

    protected AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        if (algorithmParameters != null) {
            try {
                return algorithmParameters.getParameterSpec(IvParameterSpec.class);
            } catch (InvalidParameterSpecException e) {
                throw new InvalidAlgorithmParameterException("Params must be convertible to IvParameterSpec", e);
            }
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        checkAndSetEncodedKey(i, key);
        try {
            engineInitInternal(this.encodedKey, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        checkAndSetEncodedKey(i, key);
        engineInitInternal(this.encodedKey, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        engineInit(i, key, getParameterSpec(algorithmParameters), secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int outputSizeForUpdate = getOutputSizeForUpdate(i2);
        if (outputSizeForUpdate > 0) {
            bArr2 = new byte[outputSizeForUpdate];
        } else {
            bArr2 = EmptyArray.BYTE;
        }
        try {
            int updateInternal = updateInternal(bArr, i, i2, bArr2, 0, outputSizeForUpdate);
            if (bArr2.length != updateInternal) {
                if (updateInternal == 0) {
                    return EmptyArray.BYTE;
                }
                return Arrays.copyOfRange(bArr2, 0, updateInternal);
            }
            return bArr2;
        } catch (ShortBufferException e) {
            throw new RuntimeException("calculated buffer size was wrong: " + outputSizeForUpdate);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        return updateInternal(bArr, i, i2, bArr2, i3, getOutputSizeForUpdate(i2));
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        int i3;
        int outputSizeForFinal = getOutputSizeForFinal(i2);
        byte[] bArr2 = new byte[outputSizeForFinal];
        if (i2 > 0) {
            try {
                i3 = updateInternal(bArr, i, i2, bArr2, 0, outputSizeForFinal);
            } catch (ShortBufferException e) {
                throw new RuntimeException("our calculated buffer was too small", e);
            }
        } else {
            i3 = 0;
        }
        try {
            int doFinalInternal = i3 + doFinalInternal(bArr2, i3, outputSizeForFinal - i3);
            if (doFinalInternal != bArr2.length) {
                if (doFinalInternal == 0) {
                    return EmptyArray.BYTE;
                }
                return Arrays.copyOfRange(bArr2, 0, doFinalInternal);
            }
            return bArr2;
        } catch (ShortBufferException e2) {
            throw new RuntimeException("our calculated buffer was too small", e2);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        int i4;
        if (bArr2 == null) {
            throw new NullPointerException("output == null");
        }
        int outputSizeForFinal = getOutputSizeForFinal(i2);
        if (i2 > 0) {
            i4 = updateInternal(bArr, i, i2, bArr2, i3, outputSizeForFinal);
            i3 += i4;
            outputSizeForFinal -= i4;
        } else {
            i4 = 0;
        }
        return i4 + doFinalInternal(bArr2, i3, outputSizeForFinal);
    }

    @Override // javax.crypto.CipherSpi
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e);
            throw illegalBlockSizeException;
        }
    }

    @Override // javax.crypto.CipherSpi
    protected Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        try {
            byte[] engineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(engineDoFinal));
            }
            if (i == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(engineDoFinal));
            }
            if (i == 3) {
                return new SecretKeySpec(engineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i);
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeyException(e);
        } catch (BadPaddingException e2) {
            throw new InvalidKeyException(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new InvalidKeyException(e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Only SecretKey is supported");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        checkSupportedKeySize(encoded.length);
        return encoded.length * 8;
    }

    private byte[] checkAndSetEncodedKey(int i, Key key) throws InvalidKeyException {
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else if (i == 2 || i == 4) {
            this.encrypting = false;
        } else {
            throw new InvalidParameterException("Unsupported opmode " + i);
        }
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Only SecretKey is supported");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("key.getEncoded() == null");
        }
        checkSupportedKeySize(encoded.length);
        this.encodedKey = encoded;
        return encoded;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEncrypting() {
        return this.encrypting;
    }

    /* loaded from: classes8.dex */
    public static abstract class EVP_CIPHER extends OpenSSLCipher {
        boolean calledUpdate;
        private final NativeRef.EVP_CIPHER_CTX cipherCtx;
        private int modeBlockSize;

        abstract String getCipherName(int i, Mode mode);

        public EVP_CIPHER(Mode mode, Padding padding) {
            super(mode, padding);
            this.cipherCtx = new NativeRef.EVP_CIPHER_CTX(NativeCrypto.EVP_CIPHER_CTX_new());
        }

        @Override // org.conscrypt.OpenSSLCipher
        void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            byte[] iv = algorithmParameterSpec instanceof IvParameterSpec ? ((IvParameterSpec) algorithmParameterSpec).getIV() : null;
            long EVP_get_cipherbyname = NativeCrypto.EVP_get_cipherbyname(getCipherName(bArr.length, this.mode));
            if (EVP_get_cipherbyname == 0) {
                throw new InvalidAlgorithmParameterException("Cannot find name for key length = " + (bArr.length * 8) + " and mode = " + this.mode);
            }
            boolean isEncrypting = isEncrypting();
            int EVP_CIPHER_iv_length = NativeCrypto.EVP_CIPHER_iv_length(EVP_get_cipherbyname);
            if (iv == null && EVP_CIPHER_iv_length != 0) {
                if (!isEncrypting) {
                    throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
                }
                iv = new byte[EVP_CIPHER_iv_length];
                if (secureRandom != null) {
                    secureRandom.nextBytes(iv);
                } else {
                    NativeCrypto.RAND_bytes(iv);
                }
            } else if (EVP_CIPHER_iv_length == 0 && iv != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            } else {
                if (iv != null && iv.length != EVP_CIPHER_iv_length) {
                    throw new InvalidAlgorithmParameterException("expected IV length of " + EVP_CIPHER_iv_length + " but was " + iv.length);
                }
            }
            this.iv = iv;
            if (supportsVariableSizeKey()) {
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, null, null, isEncrypting);
                NativeCrypto.EVP_CIPHER_CTX_set_key_length(this.cipherCtx, bArr.length);
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, bArr, iv, isEncrypting());
            } else {
                NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, EVP_get_cipherbyname, bArr, iv, isEncrypting);
            }
            NativeCrypto.EVP_CIPHER_CTX_set_padding(this.cipherCtx, getPadding() == Padding.PKCS5PADDING);
            this.modeBlockSize = NativeCrypto.EVP_CIPHER_CTX_block_size(this.cipherCtx);
            this.calledUpdate = false;
        }

        @Override // org.conscrypt.OpenSSLCipher
        int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
            int length = bArr2.length - i3;
            if (length < i4) {
                throw new ShortBufferException("output buffer too small during update: " + length + " < " + i4);
            }
            this.calledUpdate = true;
            return (NativeCrypto.EVP_CipherUpdate(this.cipherCtx, bArr2, i3, bArr, i, i2) + i3) - i3;
        }

        @Override // org.conscrypt.OpenSSLCipher
        int doFinalInternal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
            int EVP_CipherFinal_ex;
            if (isEncrypting() || this.calledUpdate) {
                int length = bArr.length - i;
                if (length >= i2) {
                    EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr, i);
                } else {
                    byte[] bArr2 = new byte[i2];
                    EVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr2, 0);
                    if (EVP_CipherFinal_ex > length) {
                        throw new ShortBufferException("buffer is too short: " + EVP_CipherFinal_ex + " > " + length);
                    }
                    if (EVP_CipherFinal_ex > 0) {
                        System.arraycopy(bArr2, 0, bArr, i, EVP_CipherFinal_ex);
                    }
                }
                reset();
                return (EVP_CipherFinal_ex + i) - i;
            }
            return 0;
        }

        @Override // org.conscrypt.OpenSSLCipher
        int getOutputSizeForFinal(int i) {
            int i2 = 0;
            if (this.modeBlockSize != 1) {
                int i3 = NativeCrypto.get_EVP_CIPHER_CTX_buf_len(this.cipherCtx);
                if (getPadding() == Padding.NOPADDING) {
                    return i + i3;
                }
                int i4 = (NativeCrypto.get_EVP_CIPHER_CTX_final_used(this.cipherCtx) ? this.modeBlockSize : 0) + i + i3;
                if (i4 % this.modeBlockSize != 0 || isEncrypting()) {
                    i2 = this.modeBlockSize;
                }
                int i5 = i4 + i2;
                return i5 - (i5 % this.modeBlockSize);
            }
            return i;
        }

        @Override // org.conscrypt.OpenSSLCipher
        int getOutputSizeForUpdate(int i) {
            return getOutputSizeForFinal(i);
        }

        private void reset() {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, this.encodedKey, this.iv, isEncrypting());
            this.calledUpdate = false;
        }

        /* loaded from: classes8.dex */
        static abstract class AES_BASE extends EVP_CIPHER {
            private static final int AES_BLOCK_SIZE = 16;

            AES_BASE(Mode mode, Padding padding) {
                super(mode, padding);
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
                switch (mode) {
                    case CBC:
                    case CTR:
                    case ECB:
                        return;
                    default:
                        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
                switch (padding) {
                    case NOPADDING:
                    case PKCS5PADDING:
                        return;
                    default:
                        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            String getBaseCipherName() {
                return e.q;
            }

            @Override // org.conscrypt.OpenSSLCipher.EVP_CIPHER
            String getCipherName(int i, Mode mode) {
                return "aes-" + (i * 8) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mode.toString().toLowerCase(Locale.US);
            }

            @Override // org.conscrypt.OpenSSLCipher
            int getCipherBlockSize() {
                return 16;
            }
        }

        /* loaded from: classes8.dex */
        public static class AES extends AES_BASE {
            AES(Mode mode, Padding padding) {
                super(mode, padding);
            }

            /* loaded from: classes8.dex */
            public static class CBC extends AES {
                public CBC(Padding padding) {
                    super(Mode.CBC, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends CBC {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends CBC {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            /* loaded from: classes8.dex */
            public static class CTR extends AES {
                public CTR() {
                    super(Mode.CTR, Padding.NOPADDING);
                }
            }

            /* loaded from: classes8.dex */
            public static class ECB extends AES {
                public ECB(Padding padding) {
                    super(Mode.ECB, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends ECB {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends ECB {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                switch (i) {
                    case 16:
                    case 24:
                    case 32:
                        return;
                    default:
                        throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class AES_128 extends AES_BASE {
            AES_128(Mode mode, Padding padding) {
                super(mode, padding);
            }

            /* loaded from: classes8.dex */
            public static class CBC extends AES_128 {
                public CBC(Padding padding) {
                    super(Mode.CBC, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends CBC {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends CBC {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            /* loaded from: classes8.dex */
            public static class CTR extends AES_128 {
                public CTR() {
                    super(Mode.CTR, Padding.NOPADDING);
                }
            }

            /* loaded from: classes8.dex */
            public static class ECB extends AES_128 {
                public ECB(Padding padding) {
                    super(Mode.ECB, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends ECB {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends ECB {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 16) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class AES_256 extends AES_BASE {
            AES_256(Mode mode, Padding padding) {
                super(mode, padding);
            }

            /* loaded from: classes8.dex */
            public static class CBC extends AES_256 {
                public CBC(Padding padding) {
                    super(Mode.CBC, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends CBC {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends CBC {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            /* loaded from: classes8.dex */
            public static class CTR extends AES_256 {
                public CTR() {
                    super(Mode.CTR, Padding.NOPADDING);
                }
            }

            /* loaded from: classes8.dex */
            public static class ECB extends AES_256 {
                public ECB(Padding padding) {
                    super(Mode.ECB, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends ECB {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends ECB {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 32) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes");
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class DESEDE extends EVP_CIPHER {
            private static final int DES_BLOCK_SIZE = 8;

            public DESEDE(Mode mode, Padding padding) {
                super(mode, padding);
            }

            /* loaded from: classes8.dex */
            public static class CBC extends DESEDE {
                public CBC(Padding padding) {
                    super(Mode.CBC, padding);
                }

                /* loaded from: classes8.dex */
                public static class NoPadding extends CBC {
                    public NoPadding() {
                        super(Padding.NOPADDING);
                    }
                }

                /* loaded from: classes8.dex */
                public static class PKCS5Padding extends CBC {
                    public PKCS5Padding() {
                        super(Padding.PKCS5PADDING);
                    }
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            String getBaseCipherName() {
                return "DESede";
            }

            @Override // org.conscrypt.OpenSSLCipher.EVP_CIPHER
            String getCipherName(int i, Mode mode) {
                String str;
                if (i == 16) {
                    str = "des-ede";
                } else {
                    str = "des-ede3";
                }
                return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + mode.toString().toLowerCase(Locale.US);
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 16 && i != 24) {
                    throw new InvalidKeyException("key size must be 128 or 192 bits");
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
                if (mode != Mode.CBC) {
                    throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
                switch (padding) {
                    case NOPADDING:
                    case PKCS5PADDING:
                        return;
                    default:
                        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            int getCipherBlockSize() {
                return 8;
            }
        }

        /* loaded from: classes8.dex */
        public static class ARC4 extends EVP_CIPHER {
            public ARC4() {
                super(Mode.ECB, Padding.NOPADDING);
            }

            @Override // org.conscrypt.OpenSSLCipher
            String getBaseCipherName() {
                return "ARCFOUR";
            }

            @Override // org.conscrypt.OpenSSLCipher.EVP_CIPHER
            String getCipherName(int i, Mode mode) {
                return "rc4";
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
                if (mode != Mode.NONE && mode != Mode.ECB) {
                    throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
                if (padding != Padding.NOPADDING) {
                    throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            int getCipherBlockSize() {
                return 0;
            }

            @Override // org.conscrypt.OpenSSLCipher
            boolean supportsVariableSizeKey() {
                return true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class EVP_AEAD extends OpenSSLCipher {
        private static final int DEFAULT_TAG_SIZE_BITS = 128;
        private static int lastGlobalMessageSize = 32;
        private byte[] aad;
        byte[] buf;
        int bufCount;
        long evpAead;
        private boolean mustInitialize;
        private byte[] previousIv;
        private byte[] previousKey;
        int tagLengthInBytes;

        abstract long getEVP_AEAD(int i) throws InvalidKeyException;

        public EVP_AEAD(Mode mode) {
            super(mode, Padding.NOPADDING);
        }

        private void checkInitialization() {
            if (this.mustInitialize) {
                throw new IllegalStateException("Cannot re-use same key and IV for multiple encryptions");
            }
        }

        private boolean arraysAreEqual(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                i |= bArr[i2] ^ bArr2[i2];
            }
            return i == 0;
        }

        private void expand(int i) {
            if (this.bufCount + i > this.buf.length) {
                byte[] bArr = new byte[(this.bufCount + i) * 2];
                System.arraycopy(this.buf, 0, bArr, 0, this.bufCount);
                this.buf = bArr;
            }
        }

        private void reset() {
            this.aad = null;
            int i = lastGlobalMessageSize;
            if (this.buf == null) {
                this.buf = new byte[i];
            } else if (this.bufCount > 0 && this.bufCount != i) {
                lastGlobalMessageSize = this.bufCount;
                if (this.buf.length != this.bufCount) {
                    this.buf = new byte[this.bufCount];
                }
            }
            this.bufCount = 0;
        }

        @Override // org.conscrypt.OpenSSLCipher
        void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            byte[] bArr2 = null;
            int i = 128;
            if (algorithmParameterSpec != null) {
                GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
                if (fromGCMParameterSpec != null) {
                    bArr2 = fromGCMParameterSpec.getIV();
                    i = fromGCMParameterSpec.getTLen();
                } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                    bArr2 = ((IvParameterSpec) algorithmParameterSpec).getIV();
                }
            }
            if (i % 8 != 0) {
                throw new InvalidAlgorithmParameterException("Tag length must be a multiple of 8; was " + this.tagLengthInBytes);
            }
            this.tagLengthInBytes = i / 8;
            boolean isEncrypting = isEncrypting();
            this.evpAead = getEVP_AEAD(bArr.length);
            int EVP_AEAD_nonce_length = NativeCrypto.EVP_AEAD_nonce_length(this.evpAead);
            if (bArr2 == null && EVP_AEAD_nonce_length != 0) {
                if (!isEncrypting) {
                    throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
                }
                bArr2 = new byte[EVP_AEAD_nonce_length];
                if (secureRandom != null) {
                    secureRandom.nextBytes(bArr2);
                } else {
                    NativeCrypto.RAND_bytes(bArr2);
                }
            } else if (EVP_AEAD_nonce_length == 0 && bArr2 != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            } else {
                if (bArr2 != null && bArr2.length != EVP_AEAD_nonce_length) {
                    throw new InvalidAlgorithmParameterException("Expected IV length of " + EVP_AEAD_nonce_length + " but was " + bArr2.length);
                }
            }
            if (isEncrypting() && bArr2 != null) {
                if (this.previousKey != null && this.previousIv != null && arraysAreEqual(this.previousKey, bArr) && arraysAreEqual(this.previousIv, bArr2)) {
                    this.mustInitialize = true;
                    throw new InvalidAlgorithmParameterException("When using AEAD key and IV must not be re-used");
                } else {
                    this.previousKey = bArr;
                    this.previousIv = bArr2;
                }
            }
            this.mustInitialize = false;
            this.iv = bArr2;
            reset();
        }

        @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
        protected int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
            if (bArr2 != null && getOutputSizeForFinal(i2) > bArr2.length - i3) {
                throw new ShortBufferException("Insufficient output space");
            }
            return super.engineDoFinal(bArr, i, i2, bArr2, i3);
        }

        @Override // org.conscrypt.OpenSSLCipher
        int updateInternal(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) throws ShortBufferException {
            checkInitialization();
            if (this.buf == null) {
                throw new IllegalStateException("Cipher not initialized");
            }
            ArrayUtils.checkOffsetAndCount(bArr.length, i, i2);
            if (i2 > 0) {
                expand(i2);
                System.arraycopy(bArr, i, this.buf, this.bufCount, i2);
                this.bufCount += i2;
                return 0;
            }
            return 0;
        }

        private void throwAEADBadTagExceptionIfAvailable(String str, Throwable th) throws BadPaddingException {
            BadPaddingException badPaddingException;
            try {
                BadPaddingException badPaddingException2 = null;
                try {
                    try {
                        badPaddingException = (BadPaddingException) Class.forName("javax.crypto.AEADBadTagException").getConstructor(String.class).newInstance(str);
                        try {
                            badPaddingException.initCause(th);
                        } catch (IllegalAccessException e) {
                        } catch (InstantiationException e2) {
                            badPaddingException2 = badPaddingException;
                            badPaddingException = badPaddingException2;
                        }
                    } catch (InvocationTargetException e3) {
                        throw ((BadPaddingException) new BadPaddingException().initCause(e3.getTargetException()));
                    }
                } catch (IllegalAccessException e4) {
                    badPaddingException = null;
                } catch (InstantiationException e5) {
                }
                if (badPaddingException != null) {
                    throw badPaddingException;
                }
            } catch (Exception e6) {
            }
        }

        @Override // org.conscrypt.OpenSSLCipher
        int doFinalInternal(byte[] bArr, int i, int i2) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
            int EVP_AEAD_CTX_open;
            checkInitialization();
            try {
                if (isEncrypting()) {
                    EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_seal(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i, this.iv, this.buf, 0, this.bufCount, this.aad);
                } else {
                    EVP_AEAD_CTX_open = NativeCrypto.EVP_AEAD_CTX_open(this.evpAead, this.encodedKey, this.tagLengthInBytes, bArr, i, this.iv, this.buf, 0, this.bufCount, this.aad);
                }
                if (isEncrypting()) {
                    this.mustInitialize = true;
                }
                reset();
                return EVP_AEAD_CTX_open;
            } catch (BadPaddingException e) {
                throwAEADBadTagExceptionIfAvailable(e.getMessage(), e.getCause());
                throw e;
            }
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedPadding(Padding padding) throws NoSuchPaddingException {
            if (padding != Padding.NOPADDING) {
                throw new NoSuchPaddingException("Must be NoPadding for AEAD ciphers");
            }
        }

        @Override // org.conscrypt.OpenSSLCipher
        int getOutputSizeForUpdate(int i) {
            return 0;
        }

        @Override // org.conscrypt.OpenSSLCipher
        int getOutputSizeForFinal(int i) {
            return (isEncrypting() ? NativeCrypto.EVP_AEAD_max_overhead(this.evpAead) : 0) + this.bufCount + i;
        }

        @Override // javax.crypto.CipherSpi
        protected void engineUpdateAAD(byte[] bArr, int i, int i2) {
            checkInitialization();
            if (this.aad == null) {
                this.aad = Arrays.copyOfRange(bArr, i, i + i2);
                return;
            }
            byte[] bArr2 = new byte[this.aad.length + i2];
            System.arraycopy(this.aad, 0, bArr2, 0, this.aad.length);
            System.arraycopy(bArr, i, bArr2, this.aad.length, i2);
            this.aad = bArr2;
        }

        /* loaded from: classes8.dex */
        public static abstract class AES extends EVP_AEAD {
            private static final int AES_BLOCK_SIZE = 16;

            AES(Mode mode) {
                super(mode);
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                switch (i) {
                    case 16:
                    case 32:
                        return;
                    default:
                        throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16 or 32)");
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            String getBaseCipherName() {
                return e.q;
            }

            @Override // org.conscrypt.OpenSSLCipher
            int getCipherBlockSize() {
                return 16;
            }

            /* loaded from: classes8.dex */
            public static class GCM extends AES {
                public GCM() {
                    super(Mode.GCM);
                }

                @Override // org.conscrypt.OpenSSLCipher
                void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
                    if (mode != Mode.GCM) {
                        throw new NoSuchAlgorithmException("Mode must be GCM");
                    }
                }

                @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
                protected AlgorithmParameters engineGetParameters() {
                    if (this.iv == null) {
                        return null;
                    }
                    AlgorithmParameterSpec gCMParameterSpec = Platform.toGCMParameterSpec(this.tagLengthInBytes * 8, this.iv);
                    if (gCMParameterSpec == null) {
                        return super.engineGetParameters();
                    }
                    try {
                        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("GCM");
                        algorithmParameters.init(gCMParameterSpec);
                        return algorithmParameters;
                    } catch (NoSuchAlgorithmException e) {
                        throw ((Error) new AssertionError("GCM not supported").initCause(e));
                    } catch (InvalidParameterSpecException e2) {
                        return null;
                    }
                }

                @Override // org.conscrypt.OpenSSLCipher
                protected AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
                    if (algorithmParameters != null) {
                        AlgorithmParameterSpec fromGCMParameters = Platform.fromGCMParameters(algorithmParameters);
                        if (fromGCMParameters == null) {
                            return super.getParameterSpec(algorithmParameters);
                        }
                        return fromGCMParameters;
                    }
                    return null;
                }

                @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD
                long getEVP_AEAD(int i) throws InvalidKeyException {
                    if (i == 16) {
                        return NativeCrypto.EVP_aead_aes_128_gcm();
                    }
                    if (i == 32) {
                        return NativeCrypto.EVP_aead_aes_256_gcm();
                    }
                    throw new RuntimeException("Unexpected key length: " + i);
                }

                @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD, org.conscrypt.OpenSSLCipher
                int getOutputSizeForFinal(int i) {
                    return isEncrypting() ? this.bufCount + i + this.tagLengthInBytes : Math.max(0, (this.bufCount + i) - this.tagLengthInBytes);
                }

                /* loaded from: classes8.dex */
                public static class AES_128 extends GCM {
                    @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD.AES, org.conscrypt.OpenSSLCipher
                    void checkSupportedKeySize(int i) throws InvalidKeyException {
                        if (i != 16) {
                            throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16)");
                        }
                    }
                }

                /* loaded from: classes8.dex */
                public static class AES_256 extends GCM {
                    @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD.AES, org.conscrypt.OpenSSLCipher
                    void checkSupportedKeySize(int i) throws InvalidKeyException {
                        if (i != 32) {
                            throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
                        }
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class ChaCha20 extends EVP_AEAD {
            public ChaCha20() {
                super(Mode.POLY1305);
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i != 32) {
                    throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
                }
            }

            @Override // org.conscrypt.OpenSSLCipher
            String getBaseCipherName() {
                return "ChaCha20";
            }

            @Override // org.conscrypt.OpenSSLCipher
            int getCipherBlockSize() {
                return 0;
            }

            @Override // org.conscrypt.OpenSSLCipher
            void checkSupportedMode(Mode mode) throws NoSuchAlgorithmException {
                if (mode != Mode.POLY1305) {
                    throw new NoSuchAlgorithmException("Mode must be Poly1305");
                }
            }

            @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD
            long getEVP_AEAD(int i) throws InvalidKeyException {
                if (i == 32) {
                    return NativeCrypto.EVP_aead_chacha20_poly1305();
                }
                throw new RuntimeException("Unexpected key length: " + i);
            }

            @Override // org.conscrypt.OpenSSLCipher.EVP_AEAD, org.conscrypt.OpenSSLCipher
            int getOutputSizeForFinal(int i) {
                return isEncrypting() ? this.bufCount + i + 16 : Math.max(0, (this.bufCount + i) - 16);
            }
        }
    }
}
