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
/* loaded from: classes6.dex */
public class CommonEncryptionSampleList extends AbstractList<Sample> {
    public static Cipher cipher;
    public List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    public List<Sample> parent;
    public SecretKey secretKey;

    /* loaded from: classes6.dex */
    public class a implements Sample {

        /* renamed from: a  reason: collision with root package name */
        public final Sample f31355a;

        /* renamed from: b  reason: collision with root package name */
        public final CencSampleAuxiliaryDataFormat f31356b;

        /* renamed from: c  reason: collision with root package name */
        public final Cipher f31357c;

        public /* synthetic */ a(CommonEncryptionSampleList commonEncryptionSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, a aVar) {
            this(sample, cencSampleAuxiliaryDataFormat, cipher);
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f31355a.asByteBuffer().rewind();
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
            CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.f31356b;
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
                            allocate.put(this.f31357c.update(bArr2));
                        }
                    }
                } else {
                    byte[] bArr3 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr3);
                    allocate.put(this.f31357c.doFinal(bArr3));
                }
                byteBuffer.rewind();
                allocate.rewind();
                return allocate;
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalBlockSizeException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.f31355a.getSize();
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBuffer = (ByteBuffer) this.f31355a.asByteBuffer().rewind();
            CommonEncryptionSampleList.this.initCipher(this.f31356b.iv);
            try {
                if (this.f31356b.pairs != null && this.f31356b.pairs.size() > 0) {
                    for (CencSampleAuxiliaryDataFormat.Pair pair : this.f31356b.pairs) {
                        byte[] bArr = new byte[pair.clear];
                        byteBuffer.get(bArr);
                        writableByteChannel.write(ByteBuffer.wrap(bArr));
                        if (pair.encrypted > 0) {
                            byte[] bArr2 = new byte[CastUtils.l2i(pair.encrypted)];
                            byteBuffer.get(bArr2);
                            writableByteChannel.write(ByteBuffer.wrap(this.f31357c.update(bArr2)));
                        }
                    }
                } else {
                    byte[] bArr3 = new byte[byteBuffer.limit()];
                    byteBuffer.get(bArr3);
                    writableByteChannel.write(ByteBuffer.wrap(this.f31357c.doFinal(bArr3)));
                }
                byteBuffer.rewind();
            } catch (BadPaddingException e2) {
                throw new RuntimeException(e2);
            } catch (IllegalBlockSizeException e3) {
                throw new RuntimeException(e3);
            }
        }

        public a(Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher) {
            this.f31355a = sample;
            this.f31356b = cencSampleAuxiliaryDataFormat;
            this.f31357c = cipher;
        }
    }

    static {
        try {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public CommonEncryptionSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        this.auxiliaryDataFormats = list2;
        this.secretKey = secretKey;
        this.parent = list;
    }

    public void initCipher(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            cipher.init(1, this.secretKey, new IvParameterSpec(bArr2));
        } catch (InvalidAlgorithmParameterException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeyException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.parent.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i) {
        return new a(this, this.parent.get(i), this.auxiliaryDataFormats.get(i), cipher, null);
    }
}
