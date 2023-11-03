package com.googlecode.mp4parser.boxes.cenc;

import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.boxes.cenc.CencSampleAuxiliaryDataFormat;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes10.dex */
public class CommonEncryptionSampleList extends AbstractList<Sample> {
    public static Cipher cipher;
    public List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    public List<Sample> parent;
    public SecretKey secretKey;

    /* loaded from: classes10.dex */
    public class EncryptedSampleImpl implements Sample {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat;
        public final Cipher cipher;
        public final Sample clearSample;

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.clearSample.getSize();
        }

        public EncryptedSampleImpl(Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher) {
            this.clearSample = sample;
            this.cencSampleAuxiliaryDataFormat = cencSampleAuxiliaryDataFormat;
            this.cipher = cipher;
        }

        public /* synthetic */ EncryptedSampleImpl(CommonEncryptionSampleList commonEncryptionSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, EncryptedSampleImpl encryptedSampleImpl) {
            this(sample, cencSampleAuxiliaryDataFormat, cipher);
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.cencSampleAuxiliaryDataFormat;
            CommonEncryptionSampleList.this.initCipher(cencSampleAuxiliaryDataFormat.iv);
            try {
                if (cencSampleAuxiliaryDataFormat.pairs != null) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : cencSampleAuxiliaryDataFormat.pairs) {
                        byte[] bArr = new byte[pair.clear];
                        byteBuffer.get(bArr);
                        allocate.put(bArr);
                        if (pair.encrypted > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted)];
                            byteBuffer.get(bArr2);
                            allocate.put(this.cipher.update(bArr2));
                        }
                    }
                } else {
                    byte[] bArr3 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr3);
                    allocate.put(this.cipher.doFinal(bArr3));
                }
                byteBuffer.rewind();
                allocate.rewind();
                return allocate;
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
            CommonEncryptionSampleList.this.initCipher(this.cencSampleAuxiliaryDataFormat.iv);
            try {
                if (this.cencSampleAuxiliaryDataFormat.pairs != null && this.cencSampleAuxiliaryDataFormat.pairs.size() > 0) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : this.cencSampleAuxiliaryDataFormat.pairs) {
                        byte[] bArr = new byte[pair.clear];
                        byteBuffer.get(bArr);
                        writableByteChannel.write(ByteBuffer.wrap(bArr));
                        if (pair.encrypted > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted)];
                            byteBuffer.get(bArr2);
                            writableByteChannel.write(ByteBuffer.wrap(this.cipher.update(bArr2)));
                        }
                    }
                } else {
                    byte[] bArr3 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr3);
                    writableByteChannel.write(ByteBuffer.wrap(this.cipher.doFinal(bArr3)));
                }
                byteBuffer.rewind();
            } catch (BadPaddingException e) {
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    static {
        try {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.parent.size();
    }

    public CommonEncryptionSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        this.auxiliaryDataFormats = list2;
        this.secretKey = secretKey;
        this.parent = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        return new EncryptedSampleImpl(this, this.parent.get(i), this.auxiliaryDataFormats.get(i), cipher, null);
    }

    public void initCipher(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            cipher.init(1, this.secretKey, new IvParameterSpec(bArr2));
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }
}
