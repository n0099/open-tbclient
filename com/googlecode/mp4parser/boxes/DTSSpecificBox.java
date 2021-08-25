package com.googlecode.mp4parser.boxes;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes10.dex */
public class DTSSpecificBox extends AbstractBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "ddts";
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
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_29 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_30 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_31 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public long DTSSamplingFrequency;
    public int LBRDurationMod;
    public long avgBitRate;
    public int channelLayout;
    public int coreLFEPresent;
    public int coreLayout;
    public int coreSize;
    public int frameDuration;
    public long maxBitRate;
    public int multiAssetFlag;
    public int pcmSampleDepth;
    public int representationType;
    public int reserved;
    public int reservedBoxPresent;
    public int stereoDownmix;
    public int streamConstruction;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767906529, "Lcom/googlecode/mp4parser/boxes/DTSSpecificBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(767906529, "Lcom/googlecode/mp4parser/boxes/DTSSpecificBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DTSSpecificBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("DTSSpecificBox.java", DTSSpecificBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 88);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setAvgBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "avgBitRate", "", "void"), 92);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 128);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setStreamConstruction", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "streamConstruction", "", "void"), 132);
        ajc$tjp_12 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 136);
        ajc$tjp_13 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCoreLFEPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLFEPresent", "", "void"), 140);
        ajc$tjp_14 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 144);
        ajc$tjp_15 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCoreLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreLayout", "", "void"), Opcodes.LCMP);
        ajc$tjp_16 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), a.f37632e);
        ajc$tjp_17 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setCoreSize", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "coreSize", "", "void"), 156);
        ajc$tjp_18 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 160);
        ajc$tjp_19 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setStereoDownmix", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "stereoDownmix", "", "void"), IChannelPay.ID_IPAY_PAY_GAME);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 96);
        ajc$tjp_20 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 168);
        ajc$tjp_21 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setRepresentationType", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "representationType", "", "void"), 172);
        ajc$tjp_22 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), Opcodes.ARETURN);
        ajc$tjp_23 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setChannelLayout", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "channelLayout", "", "void"), 180);
        ajc$tjp_24 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), Opcodes.INVOKESTATIC);
        ajc$tjp_25 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMultiAssetFlag", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "multiAssetFlag", "", "void"), Opcodes.NEWARRAY);
        ajc$tjp_26 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 192);
        ajc$tjp_27 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLBRDurationMod", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "LBRDurationMod", "", "void"), 196);
        ajc$tjp_28 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 200);
        ajc$tjp_29 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReserved", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "", "void"), 204);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setDTSSamplingFrequency", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "DTSSamplingFrequency", "", "void"), 100);
        ajc$tjp_30 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 208);
        ajc$tjp_31 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReservedBoxPresent", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "reservedBoxPresent", "", "void"), 212);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "long"), 104);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setMaxBitRate", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "long", "maxBitRate", "", "void"), 108);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 112);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setPcmSampleDepth", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "pcmSampleDepth", "", "void"), 116);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "", "", "", "int"), 120);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.DTSSpecificBox", "int", "frameDuration", "", "void"), 124);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            this.DTSSamplingFrequency = IsoTypeReader.readUInt32(byteBuffer);
            this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
            this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
            this.pcmSampleDepth = IsoTypeReader.readUInt8(byteBuffer);
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            this.frameDuration = bitReaderBuffer.readBits(2);
            this.streamConstruction = bitReaderBuffer.readBits(5);
            this.coreLFEPresent = bitReaderBuffer.readBits(1);
            this.coreLayout = bitReaderBuffer.readBits(6);
            this.coreSize = bitReaderBuffer.readBits(14);
            this.stereoDownmix = bitReaderBuffer.readBits(1);
            this.representationType = bitReaderBuffer.readBits(3);
            this.channelLayout = bitReaderBuffer.readBits(16);
            this.multiAssetFlag = bitReaderBuffer.readBits(1);
            this.LBRDurationMod = bitReaderBuffer.readBits(1);
            this.reservedBoxPresent = bitReaderBuffer.readBits(1);
            this.reserved = bitReaderBuffer.readBits(5);
        }
    }

    public long getAvgBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.avgBitRate;
        }
        return invokeV.longValue;
    }

    public int getChannelLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_22, this, this));
            return this.channelLayout;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.DTSSamplingFrequency);
            IsoTypeWriter.writeUInt32(byteBuffer, this.maxBitRate);
            IsoTypeWriter.writeUInt32(byteBuffer, this.avgBitRate);
            IsoTypeWriter.writeUInt8(byteBuffer, this.pcmSampleDepth);
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(this.frameDuration, 2);
            bitWriterBuffer.writeBits(this.streamConstruction, 5);
            bitWriterBuffer.writeBits(this.coreLFEPresent, 1);
            bitWriterBuffer.writeBits(this.coreLayout, 6);
            bitWriterBuffer.writeBits(this.coreSize, 14);
            bitWriterBuffer.writeBits(this.stereoDownmix, 1);
            bitWriterBuffer.writeBits(this.representationType, 3);
            bitWriterBuffer.writeBits(this.channelLayout, 16);
            bitWriterBuffer.writeBits(this.multiAssetFlag, 1);
            bitWriterBuffer.writeBits(this.LBRDurationMod, 1);
            bitWriterBuffer.writeBits(this.reservedBoxPresent, 1);
            bitWriterBuffer.writeBits(this.reserved, 5);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 20L;
        }
        return invokeV.longValue;
    }

    public int getCoreLFEPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_12, this, this));
            return this.coreLFEPresent;
        }
        return invokeV.intValue;
    }

    public int getCoreLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_14, this, this));
            return this.coreLayout;
        }
        return invokeV.intValue;
    }

    public int getCoreSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_16, this, this));
            return this.coreSize;
        }
        return invokeV.intValue;
    }

    public long getDTSSamplingFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.DTSSamplingFrequency;
        }
        return invokeV.longValue;
    }

    public int getFrameDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return this.frameDuration;
        }
        return invokeV.intValue;
    }

    public int getLBRDurationMod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_26, this, this));
            return this.LBRDurationMod;
        }
        return invokeV.intValue;
    }

    public long getMaxBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.maxBitRate;
        }
        return invokeV.longValue;
    }

    public int getMultiAssetFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_24, this, this));
            return this.multiAssetFlag;
        }
        return invokeV.intValue;
    }

    public int getPcmSampleDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.pcmSampleDepth;
        }
        return invokeV.intValue;
    }

    public int getRepresentationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_20, this, this));
            return this.representationType;
        }
        return invokeV.intValue;
    }

    public int getReserved() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_28, this, this));
            return this.reserved;
        }
        return invokeV.intValue;
    }

    public int getReservedBoxPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_30, this, this));
            return this.reservedBoxPresent;
        }
        return invokeV.intValue;
    }

    public int getStereoDownmix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_18, this, this));
            return this.stereoDownmix;
        }
        return invokeV.intValue;
    }

    public int getStreamConstruction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
            return this.streamConstruction;
        }
        return invokeV.intValue;
    }

    public void setAvgBitRate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.longObject(j2)));
            this.avgBitRate = j2;
        }
    }

    public void setChannelLayout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_23, this, this, Conversions.intObject(i2)));
            this.channelLayout = i2;
        }
    }

    public void setCoreLFEPresent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_13, this, this, Conversions.intObject(i2)));
            this.coreLFEPresent = i2;
        }
    }

    public void setCoreLayout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_15, this, this, Conversions.intObject(i2)));
            this.coreLayout = i2;
        }
    }

    public void setCoreSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_17, this, this, Conversions.intObject(i2)));
            this.coreSize = i2;
        }
    }

    public void setDTSSamplingFrequency(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.longObject(j2)));
            this.DTSSamplingFrequency = j2;
        }
    }

    public void setFrameDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.intObject(i2)));
            this.frameDuration = i2;
        }
    }

    public void setLBRDurationMod(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_27, this, this, Conversions.intObject(i2)));
            this.LBRDurationMod = i2;
        }
    }

    public void setMaxBitRate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.longObject(j2)));
            this.maxBitRate = j2;
        }
    }

    public void setMultiAssetFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_25, this, this, Conversions.intObject(i2)));
            this.multiAssetFlag = i2;
        }
    }

    public void setPcmSampleDepth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i2)));
            this.pcmSampleDepth = i2;
        }
    }

    public void setRepresentationType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_21, this, this, Conversions.intObject(i2)));
            this.representationType = i2;
        }
    }

    public void setReserved(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_29, this, this, Conversions.intObject(i2)));
            this.reserved = i2;
        }
    }

    public void setReservedBoxPresent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_31, this, this, Conversions.intObject(i2)));
            this.reservedBoxPresent = i2;
        }
    }

    public void setStereoDownmix(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_19, this, this, Conversions.intObject(i2)));
            this.stereoDownmix = i2;
        }
    }

    public void setStreamConstruction(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i2)));
            this.streamConstruction = i2;
        }
    }
}
