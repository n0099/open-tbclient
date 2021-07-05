package com.googlecode.mp4parser.boxes.cenc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public static Cipher cipher;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CencSampleAuxiliaryDataFormat> auxiliaryDataFormats;
    public List<Sample> parent;
    public SecretKey secretKey;

    /* renamed from: com.googlecode.mp4parser.boxes.cenc.CommonEncryptionSampleList$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class EncryptedSampleImpl implements Sample {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat;
        public final Cipher cipher;
        public final Sample clearSample;
        public final /* synthetic */ CommonEncryptionSampleList this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1925688857, "Lcom/googlecode/mp4parser/boxes/cenc/CommonEncryptionSampleList$EncryptedSampleImpl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1925688857, "Lcom/googlecode/mp4parser/boxes/cenc/CommonEncryptionSampleList$EncryptedSampleImpl;");
                }
            }
        }

        public /* synthetic */ EncryptedSampleImpl(CommonEncryptionSampleList commonEncryptionSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher, EncryptedSampleImpl encryptedSampleImpl) {
            this(commonEncryptionSampleList, sample, cencSampleAuxiliaryDataFormat, cipher);
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
                ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.limit());
                CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = this.cencSampleAuxiliaryDataFormat;
                this.this$0.initCipher(cencSampleAuxiliaryDataFormat.iv);
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
                } catch (BadPaddingException e2) {
                    throw new RuntimeException(e2);
                } catch (IllegalBlockSizeException e3) {
                    throw new RuntimeException(e3);
                }
            }
            return (ByteBuffer) invokeV.objValue;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.clearSample.getSize() : invokeV.longValue;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writableByteChannel) == null) {
                ByteBuffer byteBuffer = (ByteBuffer) this.clearSample.asByteBuffer().rewind();
                this.this$0.initCipher(this.cencSampleAuxiliaryDataFormat.iv);
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
                } catch (BadPaddingException e2) {
                    throw new RuntimeException(e2);
                } catch (IllegalBlockSizeException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }

        public EncryptedSampleImpl(CommonEncryptionSampleList commonEncryptionSampleList, Sample sample, CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, Cipher cipher) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonEncryptionSampleList, sample, cencSampleAuxiliaryDataFormat, cipher};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = commonEncryptionSampleList;
            this.clearSample = sample;
            this.cencSampleAuxiliaryDataFormat = cencSampleAuxiliaryDataFormat;
            this.cipher = cipher;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(884313265, "Lcom/googlecode/mp4parser/boxes/cenc/CommonEncryptionSampleList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(884313265, "Lcom/googlecode/mp4parser/boxes/cenc/CommonEncryptionSampleList;");
                return;
            }
        }
        try {
            cipher = Cipher.getInstance("AES/CTR/NoPadding");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public CommonEncryptionSampleList(SecretKey secretKey, List<Sample> list, List<CencSampleAuxiliaryDataFormat> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretKey, list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.auxiliaryDataFormats = list2;
        this.secretKey = secretKey;
        this.parent = list;
    }

    public void initCipher(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
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
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.parent.size() : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new EncryptedSampleImpl(this, this.parent.get(i2), this.auxiliaryDataFormats.get(i2), cipher, null) : (Sample) invokeI.objValue;
    }
}
