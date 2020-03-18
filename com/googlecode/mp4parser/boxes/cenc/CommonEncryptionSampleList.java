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
/* loaded from: classes7.dex */
public class CommonEncryptionSampleList extends AbstractList<Sample> {
    static Cipher cipher;
    List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    List<Sample> parent;
    SecretKey secretKey;

    static {
        try {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public CommonEncryptionSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        this.auxiliaryDataFormats = list2;
        this.secretKey = secretKey;
        this.parent = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        return new a(this, this.parent.get(i), this.auxiliaryDataFormats.get(i), cipher, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Sample {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final Cipher cipher;
        private final Sample mPZ;
        private final CencSampleAuxiliaryDataFormat mQa;

        static {
            $assertionsDisabled = !CommonEncryptionSampleList.class.desiredAssertionStatus();
        }

        /* synthetic */ a(CommonEncryptionSampleList commonEncryptionSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, a aVar) {
            this(sample, cencSampleAuxiliaryDataFormat, cipher);
        }

        private a(Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher) {
            this.mPZ = sample;
            this.mQa = cencSampleAuxiliaryDataFormat;
            this.cipher = cipher;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) this.mPZ.asByteBuffer().rewind();
            CommonEncryptionSampleList.this.initCipher(this.mQa.iv);
            try {
                if (this.mQa.pairs != null && this.mQa.pairs.size() > 0) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : this.mQa.pairs) {
                        byte[] bArr = new byte[pair.clear];
                        byteBuffer.get(bArr);
                        writableByteChannel.write(ByteBuffer.wrap(bArr));
                        if (pair.encrypted > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted)];
                            byteBuffer.get(bArr2);
                            if (!$assertionsDisabled && bArr2.length % 16 != 0) {
                                throw new AssertionError();
                            }
                            byte[] update = this.cipher.update(bArr2);
                            if (!$assertionsDisabled && update.length != bArr2.length) {
                                throw new AssertionError();
                            }
                            writableByteChannel.write(ByteBuffer.wrap(update));
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

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.mPZ.getSize();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteBuffer byteBuffer = (ByteBuffer) this.mPZ.asByteBuffer().rewind();
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.mQa;
            CommonEncryptionSampleList.this.initCipher(this.mQa.iv);
            try {
                if (cencSampleAuxiliaryDataFormat.pairs != null) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : cencSampleAuxiliaryDataFormat.pairs) {
                        byte[] bArr = new byte[pair.clear];
                        byteBuffer.get(bArr);
                        allocate.put(bArr);
                        if (pair.encrypted > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted)];
                            byteBuffer.get(bArr2);
                            if (!$assertionsDisabled && bArr2.length % 16 != 0) {
                                throw new AssertionError();
                            }
                            byte[] update = this.cipher.update(bArr2);
                            if (!$assertionsDisabled && update.length != bArr2.length) {
                                throw new AssertionError();
                            }
                            allocate.put(update);
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
    }

    protected void initCipher(byte[] bArr) {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.parent.size();
    }
}
