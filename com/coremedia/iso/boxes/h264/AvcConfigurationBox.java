package com.coremedia.iso.boxes.h264;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes9.dex */
public final class AvcConfigurationBox extends AbstractBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "avcC";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_12 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_13 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_14 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_15 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_16 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_17 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_18 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_19 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_20 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_21 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_22 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_23 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_24 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_25 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_26 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_27 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_28 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public AVCDecoderConfigurationRecord avcDecoderConfigurationRecord;

    /* loaded from: classes9.dex */
    public static class AVCDecoderConfigurationRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int avcLevelIndication;
        public int avcProfileIndication;
        public int bitDepthChromaMinus8;
        public int bitDepthChromaMinus8PaddingBits;
        public int bitDepthLumaMinus8;
        public int bitDepthLumaMinus8PaddingBits;
        public int chromaFormat;
        public int chromaFormatPaddingBits;
        public int configurationVersion;
        public boolean hasExts;
        public int lengthSizeMinusOne;
        public int lengthSizeMinusOnePaddingBits;
        public int numberOfSequenceParameterSetsPaddingBits;
        public List<byte[]> pictureParameterSets;
        public int profileCompatibility;
        public List<byte[]> sequenceParameterSetExts;
        public List<byte[]> sequenceParameterSets;

        public AVCDecoderConfigurationRecord() {
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
            this.sequenceParameterSets = new ArrayList();
            this.pictureParameterSets = new ArrayList();
            this.hasExts = true;
            this.chromaFormat = 1;
            this.bitDepthLumaMinus8 = 0;
            this.bitDepthChromaMinus8 = 0;
            this.sequenceParameterSetExts = new ArrayList();
            this.lengthSizeMinusOnePaddingBits = 63;
            this.numberOfSequenceParameterSetsPaddingBits = 7;
            this.chromaFormatPaddingBits = 31;
            this.bitDepthLumaMinus8PaddingBits = 31;
            this.bitDepthChromaMinus8PaddingBits = 31;
        }

        public String[] getPPS() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList();
                for (byte[] bArr : this.pictureParameterSets) {
                    try {
                        arrayList.add(PictureParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return (String[]) invokeV.objValue;
        }

        public String[] getSPS() {
            InterceptResult invokeV;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ArrayList arrayList = new ArrayList();
                for (byte[] bArr : this.sequenceParameterSets) {
                    try {
                        str = SeqParameterSet.read(new ByteArrayInputStream(bArr, 1, bArr.length - 1)).toString();
                    } catch (IOException unused) {
                        str = "not parsable";
                    }
                    arrayList.add(str);
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return (String[]) invokeV.objValue;
        }

        public AVCDecoderConfigurationRecord(ByteBuffer byteBuffer) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {byteBuffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.sequenceParameterSets = new ArrayList();
            this.pictureParameterSets = new ArrayList();
            this.hasExts = true;
            this.chromaFormat = 1;
            this.bitDepthLumaMinus8 = 0;
            this.bitDepthChromaMinus8 = 0;
            this.sequenceParameterSetExts = new ArrayList();
            this.lengthSizeMinusOnePaddingBits = 63;
            this.numberOfSequenceParameterSetsPaddingBits = 7;
            this.chromaFormatPaddingBits = 31;
            this.bitDepthLumaMinus8PaddingBits = 31;
            this.bitDepthChromaMinus8PaddingBits = 31;
            this.configurationVersion = IsoTypeReader.readUInt8(byteBuffer);
            this.avcProfileIndication = IsoTypeReader.readUInt8(byteBuffer);
            this.profileCompatibility = IsoTypeReader.readUInt8(byteBuffer);
            this.avcLevelIndication = IsoTypeReader.readUInt8(byteBuffer);
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            this.lengthSizeMinusOnePaddingBits = bitReaderBuffer.readBits(6);
            this.lengthSizeMinusOne = bitReaderBuffer.readBits(2);
            this.numberOfSequenceParameterSetsPaddingBits = bitReaderBuffer.readBits(3);
            int readBits = bitReaderBuffer.readBits(5);
            for (int i4 = 0; i4 < readBits; i4++) {
                byte[] bArr = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr);
                this.sequenceParameterSets.add(bArr);
            }
            long readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            for (int i5 = 0; i5 < readUInt8; i5++) {
                byte[] bArr2 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                byteBuffer.get(bArr2);
                this.pictureParameterSets.add(bArr2);
            }
            if (byteBuffer.remaining() < 4) {
                this.hasExts = false;
            }
            if (this.hasExts && ((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
                BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
                this.chromaFormatPaddingBits = bitReaderBuffer2.readBits(6);
                this.chromaFormat = bitReaderBuffer2.readBits(2);
                this.bitDepthLumaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthLumaMinus8 = bitReaderBuffer2.readBits(3);
                this.bitDepthChromaMinus8PaddingBits = bitReaderBuffer2.readBits(5);
                this.bitDepthChromaMinus8 = bitReaderBuffer2.readBits(3);
                long readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
                for (int i6 = 0; i6 < readUInt82; i6++) {
                    byte[] bArr3 = new byte[IsoTypeReader.readUInt16(byteBuffer)];
                    byteBuffer.get(bArr3);
                    this.sequenceParameterSetExts.add(bArr3);
                }
                return;
            }
            this.chromaFormat = -1;
            this.bitDepthLumaMinus8 = -1;
            this.bitDepthChromaMinus8 = -1;
        }

        public void getContent(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
                IsoTypeWriter.writeUInt8(byteBuffer, this.configurationVersion);
                IsoTypeWriter.writeUInt8(byteBuffer, this.avcProfileIndication);
                IsoTypeWriter.writeUInt8(byteBuffer, this.profileCompatibility);
                IsoTypeWriter.writeUInt8(byteBuffer, this.avcLevelIndication);
                BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
                bitWriterBuffer.writeBits(this.lengthSizeMinusOnePaddingBits, 6);
                bitWriterBuffer.writeBits(this.lengthSizeMinusOne, 2);
                bitWriterBuffer.writeBits(this.numberOfSequenceParameterSetsPaddingBits, 3);
                bitWriterBuffer.writeBits(this.pictureParameterSets.size(), 5);
                for (byte[] bArr : this.sequenceParameterSets) {
                    IsoTypeWriter.writeUInt16(byteBuffer, bArr.length);
                    byteBuffer.put(bArr);
                }
                IsoTypeWriter.writeUInt8(byteBuffer, this.pictureParameterSets.size());
                for (byte[] bArr2 : this.pictureParameterSets) {
                    IsoTypeWriter.writeUInt16(byteBuffer, bArr2.length);
                    byteBuffer.put(bArr2);
                }
                if (this.hasExts) {
                    int i = this.avcProfileIndication;
                    if (i == 100 || i == 110 || i == 122 || i == 144) {
                        BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
                        bitWriterBuffer2.writeBits(this.chromaFormatPaddingBits, 6);
                        bitWriterBuffer2.writeBits(this.chromaFormat, 2);
                        bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8PaddingBits, 5);
                        bitWriterBuffer2.writeBits(this.bitDepthLumaMinus8, 3);
                        bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8PaddingBits, 5);
                        bitWriterBuffer2.writeBits(this.bitDepthChromaMinus8, 3);
                        for (byte[] bArr3 : this.sequenceParameterSetExts) {
                            IsoTypeWriter.writeUInt16(byteBuffer, bArr3.length);
                            byteBuffer.put(bArr3);
                        }
                    }
                }
            }
        }

        public long getContentSize() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long j = 6;
                for (byte[] bArr : this.sequenceParameterSets) {
                    j = j + 2 + bArr.length;
                }
                long j2 = j + 1;
                for (byte[] bArr2 : this.pictureParameterSets) {
                    j2 = j2 + 2 + bArr2.length;
                }
                if (this.hasExts && ((i = this.avcProfileIndication) == 100 || i == 110 || i == 122 || i == 144)) {
                    j2 += 4;
                    for (byte[] bArr3 : this.sequenceParameterSetExts) {
                        j2 = j2 + 2 + bArr3.length;
                    }
                }
                return j2;
            }
            return invokeV.longValue;
        }

        public List<String> getPictureParameterSetsAsStrings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ArrayList arrayList = new ArrayList(this.pictureParameterSets.size());
                for (byte[] bArr : this.pictureParameterSets) {
                    arrayList.add(Hex.encodeHex(bArr));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public List<String> getSequenceParameterSetExtsAsStrings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                ArrayList arrayList = new ArrayList(this.sequenceParameterSetExts.size());
                for (byte[] bArr : this.sequenceParameterSetExts) {
                    arrayList.add(Hex.encodeHex(bArr));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public List<String> getSequenceParameterSetsAsStrings() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ArrayList arrayList = new ArrayList(this.sequenceParameterSets.size());
                for (byte[] bArr : this.sequenceParameterSets) {
                    arrayList.add(Hex.encodeHex(bArr));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1205434075, "Lcom/coremedia/iso/boxes/h264/AvcConfigurationBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1205434075, "Lcom/coremedia/iso/boxes/h264/AvcConfigurationBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    public int getAvcLevelIndication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this));
            return this.avcDecoderConfigurationRecord.avcLevelIndication;
        }
        return invokeV.intValue;
    }

    public int getAvcProfileIndication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this));
            return this.avcDecoderConfigurationRecord.avcProfileIndication;
        }
        return invokeV.intValue;
    }

    public int getBitDepthChromaMinus8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this));
            return this.avcDecoderConfigurationRecord.bitDepthChromaMinus8;
        }
        return invokeV.intValue;
    }

    public int getBitDepthLumaMinus8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
            return this.avcDecoderConfigurationRecord.bitDepthLumaMinus8;
        }
        return invokeV.intValue;
    }

    public int getChromaFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this));
            return this.avcDecoderConfigurationRecord.chromaFormat;
        }
        return invokeV.intValue;
    }

    public int getConfigurationVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.avcDecoderConfigurationRecord.configurationVersion;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_24, this, this));
            return this.avcDecoderConfigurationRecord.getContentSize();
        }
        return invokeV.longValue;
    }

    public int getLengthSizeMinusOne() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.avcDecoderConfigurationRecord.lengthSizeMinusOne;
        }
        return invokeV.intValue;
    }

    public String[] getPPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_27, this, this));
            return this.avcDecoderConfigurationRecord.getPPS();
        }
        return (String[]) invokeV.objValue;
    }

    public List<byte[]> getPictureParameterSets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.pictureParameterSets);
        }
        return (List) invokeV.objValue;
    }

    public int getProfileCompatibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.avcDecoderConfigurationRecord.profileCompatibility;
        }
        return invokeV.intValue;
    }

    public String[] getSPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_26, this, this));
            return this.avcDecoderConfigurationRecord.getSPS();
        }
        return (String[]) invokeV.objValue;
    }

    public List<byte[]> getSequenceParameterSetExts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this));
            return this.avcDecoderConfigurationRecord.sequenceParameterSetExts;
        }
        return (List) invokeV.objValue;
    }

    public List<byte[]> getSequenceParameterSets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this));
            return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.sequenceParameterSets);
        }
        return (List) invokeV.objValue;
    }

    public AVCDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_28, this, this));
            return this.avcDecoderConfigurationRecord;
        }
        return (AVCDecoderConfigurationRecord) invokeV.objValue;
    }

    public boolean hasExts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_22, this, this));
            return this.avcDecoderConfigurationRecord.hasExts;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvcConfigurationBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 54);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 58);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 94);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 98);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 102);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 106);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 110);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setChromaFormat", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 114);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 118);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBitDepthLumaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 122);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 126);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBitDepthChromaMinus8", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 130);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 62);
        ajc$tjp_20 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 134);
        ajc$tjp_21 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setSequenceParameterSetExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 138);
        ajc$tjp_22 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "hasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "boolean"), Cea708Decoder.COMMAND_DLC);
        ajc$tjp_23 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setHasExts", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "boolean", "hasExts", "", "void"), Cea708Decoder.COMMAND_SPL);
        ajc$tjp_24 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContentSize", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "long"), Cea708Decoder.COMMAND_DF5);
        ajc$tjp_25 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getContent", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), MatroskaExtractor.ID_SIMPLE_BLOCK);
        ajc$tjp_26 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 168);
        ajc$tjp_27 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPPS", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 172);
        ajc$tjp_28 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getavcDecoderConfigurationRecord", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "com.coremedia.iso.boxes.h264.AvcConfigurationBox$AVCDecoderConfigurationRecord"), 177);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAvcLevelIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 66);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLengthSizeMinusOne", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "int"), 70);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getSequenceParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 74);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPictureParameterSets", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "", "", "", "java.util.List"), 78);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setConfigurationVersion", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 82);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAvcProfileIndication", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 86);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setProfileCompatibility", "com.coremedia.iso.boxes.h264.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 90);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            this.avcDecoderConfigurationRecord = new AVCDecoderConfigurationRecord(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, byteBuffer) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_25, this, this, byteBuffer));
            this.avcDecoderConfigurationRecord.getContent(byteBuffer);
        }
    }

    public void setAvcLevelIndication(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.avcLevelIndication = i;
        }
    }

    public void setAvcProfileIndication(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.avcProfileIndication = i;
        }
    }

    public void setBitDepthChromaMinus8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.bitDepthChromaMinus8 = i;
        }
    }

    public void setBitDepthLumaMinus8(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.bitDepthLumaMinus8 = i;
        }
    }

    public void setChromaFormat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.chromaFormat = i;
        }
    }

    public void setConfigurationVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.configurationVersion = i;
        }
    }

    public void setHasExts(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_23, this, this, Conversions.booleanObject(z)));
            this.avcDecoderConfigurationRecord.hasExts = z;
        }
    }

    public void setLengthSizeMinusOne(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.lengthSizeMinusOne = i;
        }
    }

    public void setPictureParameterSets(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, list));
            this.avcDecoderConfigurationRecord.pictureParameterSets = list;
        }
    }

    public void setProfileCompatibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.intObject(i)));
            this.avcDecoderConfigurationRecord.profileCompatibility = i;
        }
    }

    public void setSequenceParameterSetExts(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this, list));
            this.avcDecoderConfigurationRecord.sequenceParameterSetExts = list;
        }
    }

    public void setSequenceParameterSets(List<byte[]> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this, list));
            this.avcDecoderConfigurationRecord.sequenceParameterSets = list;
        }
    }
}
