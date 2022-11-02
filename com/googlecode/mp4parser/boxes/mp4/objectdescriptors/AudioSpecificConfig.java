package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Descriptor(objectTypeIndication = 64, tags = {5})
/* loaded from: classes7.dex */
public class AudioSpecificConfig extends BaseDescriptor {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Integer, String> audioObjectTypeMap;
    public static Map<Integer, Integer> samplingFrequencyIndexMap;
    public transient /* synthetic */ FieldHolder $fh;
    public int aacScalefactorDataResilienceFlag;
    public int aacSectionDataResilienceFlag;
    public int aacSpectralDataResilienceFlag;
    public int audioObjectType;
    public int channelConfiguration;
    public byte[] configBytes;
    public int coreCoderDelay;
    public int dependsOnCoreCoder;
    public int directMapping;
    public int epConfig;
    public int erHvxcExtensionFlag;
    public int extensionAudioObjectType;
    public int extensionChannelConfiguration;
    public int extensionFlag;
    public int extensionFlag3;
    public int extensionSamplingFrequency;
    public int extensionSamplingFrequencyIndex;
    public int fillBits;
    public int frameLengthFlag;
    public boolean gaSpecificConfig;
    public int hilnContMode;
    public int hilnEnhaLayer;
    public int hilnEnhaQuantMode;
    public int hilnFrameLength;
    public int hilnMaxNumLine;
    public int hilnQuantMode;
    public int hilnSampleRateCode;
    public int hvxcRateMode;
    public int hvxcVarMode;
    public int isBaseLayer;
    public int layerNr;
    public int layer_length;
    public int numOfSubFrame;
    public int paraExtensionFlag;
    public int paraMode;
    public boolean parametricSpecificConfig;
    public int psPresentFlag;
    public int sacPayloadEmbedding;
    public int samplingFrequency;
    public int samplingFrequencyIndex;
    public int sbrPresentFlag;
    public int syncExtensionType;
    public int var_ScalableFlag;

    private int gaSpecificConfigSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-405115747, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/AudioSpecificConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-405115747, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/AudioSpecificConfig;");
                return;
            }
        }
        samplingFrequencyIndexMap = new HashMap();
        audioObjectTypeMap = new HashMap();
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, 8000);
        audioObjectTypeMap.put(1, "AAC main");
        audioObjectTypeMap.put(2, "AAC LC");
        audioObjectTypeMap.put(3, "AAC SSR");
        audioObjectTypeMap.put(4, "AAC LTP");
        audioObjectTypeMap.put(5, "SBR");
        audioObjectTypeMap.put(6, "AAC Scalable");
        audioObjectTypeMap.put(7, "TwinVQ");
        audioObjectTypeMap.put(8, "CELP");
        audioObjectTypeMap.put(9, "HVXC");
        audioObjectTypeMap.put(10, "(reserved)");
        audioObjectTypeMap.put(11, "(reserved)");
        audioObjectTypeMap.put(12, "TTSI");
        audioObjectTypeMap.put(13, "Main synthetic");
        audioObjectTypeMap.put(14, "Wavetable synthesis");
        audioObjectTypeMap.put(15, "General MIDI");
        audioObjectTypeMap.put(16, "Algorithmic Synthesis and Audio FX");
        audioObjectTypeMap.put(17, "ER AAC LC");
        audioObjectTypeMap.put(18, "(reserved)");
        audioObjectTypeMap.put(19, "ER AAC LTP");
        audioObjectTypeMap.put(20, "ER AAC Scalable");
        audioObjectTypeMap.put(21, "ER TwinVQ");
        audioObjectTypeMap.put(22, "ER BSAC");
        audioObjectTypeMap.put(23, "ER AAC LD");
        audioObjectTypeMap.put(24, "ER CELP");
        audioObjectTypeMap.put(25, "ER HVXC");
        audioObjectTypeMap.put(26, "ER HILN");
        audioObjectTypeMap.put(27, "ER Parametric");
        audioObjectTypeMap.put(28, "SSC");
        audioObjectTypeMap.put(29, "PS");
        audioObjectTypeMap.put(30, "MPEG Surround");
        audioObjectTypeMap.put(31, "(escape)");
        audioObjectTypeMap.put(32, "Layer-1");
        audioObjectTypeMap.put(33, "Layer-2");
        audioObjectTypeMap.put(34, "Layer-3");
        audioObjectTypeMap.put(35, "DST");
        audioObjectTypeMap.put(36, "ALS");
        audioObjectTypeMap.put(37, "SLS");
        audioObjectTypeMap.put(38, "SLS non-core");
        audioObjectTypeMap.put(39, "ER AAC ELD");
        audioObjectTypeMap.put(40, "SMR Simple");
        audioObjectTypeMap.put(41, "SMR Main");
    }

    public AudioSpecificConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getAudioObjectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.audioObjectType;
        }
        return invokeV.intValue;
    }

    public int getChannelConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.channelConfiguration;
        }
        return invokeV.intValue;
    }

    public byte[] getConfigBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.configBytes;
        }
        return (byte[]) invokeV.objValue;
    }

    public int getExtensionAudioObjectType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.extensionAudioObjectType;
        }
        return invokeV.intValue;
    }

    public int getPsPresentFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.psPresentFlag;
        }
        return invokeV.intValue;
    }

    public int getSamplingFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.samplingFrequencyIndex;
            if (i == 15) {
                return this.samplingFrequency;
            }
            return samplingFrequencyIndexMap.get(Integer.valueOf(i)).intValue();
        }
        return invokeV.intValue;
    }

    public int getSbrPresentFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.sbrPresentFlag;
        }
        return invokeV.intValue;
    }

    public int serializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.audioObjectType == 2) {
                return gaSpecificConfigSize() + 4;
            }
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        return invokeV.intValue;
    }

    private int getAudioObjectType(BitReaderBuffer bitReaderBuffer) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bitReaderBuffer)) == null) {
            int readBits = bitReaderBuffer.readBits(5);
            if (readBits == 31) {
                return bitReaderBuffer.readBits(6) + 32;
            }
            return readBits;
        }
        return invokeL.intValue;
    }

    public void setAudioObjectType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.audioObjectType = i;
        }
    }

    public void setChannelConfiguration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.channelConfiguration = i;
        }
    }

    public void setSamplingFrequency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.samplingFrequency = i;
        }
    }

    public void setSamplingFrequencyIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.samplingFrequencyIndex = i;
        }
    }

    private void parseErHvxcConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            this.hvxcVarMode = bitReaderBuffer.readBits(1);
            this.hvxcRateMode = bitReaderBuffer.readBits(2);
            int readBits = bitReaderBuffer.readBits(1);
            this.erHvxcExtensionFlag = readBits;
            if (readBits == 1) {
                this.var_ScalableFlag = bitReaderBuffer.readBits(1);
            }
        }
    }

    private void parseHilnConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            this.hilnQuantMode = bitReaderBuffer.readBits(1);
            this.hilnMaxNumLine = bitReaderBuffer.readBits(8);
            this.hilnSampleRateCode = bitReaderBuffer.readBits(4);
            this.hilnFrameLength = bitReaderBuffer.readBits(12);
            this.hilnContMode = bitReaderBuffer.readBits(2);
        }
    }

    private void parseParaConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            int readBits = bitReaderBuffer.readBits(2);
            this.paraMode = readBits;
            if (readBits != 1) {
                parseErHvxcConfig(i, i2, i3, bitReaderBuffer);
            }
            if (this.paraMode != 0) {
                parseHilnConfig(i, i2, i3, bitReaderBuffer);
            }
            this.paraExtensionFlag = bitReaderBuffer.readBits(1);
            this.parametricSpecificConfig = true;
        }
    }

    private void parseGaSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            this.frameLengthFlag = bitReaderBuffer.readBits(1);
            int readBits = bitReaderBuffer.readBits(1);
            this.dependsOnCoreCoder = readBits;
            if (readBits == 1) {
                this.coreCoderDelay = bitReaderBuffer.readBits(14);
            }
            this.extensionFlag = bitReaderBuffer.readBits(1);
            if (i2 != 0) {
                if (i3 == 6 || i3 == 20) {
                    this.layerNr = bitReaderBuffer.readBits(3);
                }
                if (this.extensionFlag == 1) {
                    if (i3 == 22) {
                        this.numOfSubFrame = bitReaderBuffer.readBits(5);
                        this.layer_length = bitReaderBuffer.readBits(11);
                    }
                    if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                        this.aacSectionDataResilienceFlag = bitReaderBuffer.readBits(1);
                        this.aacScalefactorDataResilienceFlag = bitReaderBuffer.readBits(1);
                        this.aacSpectralDataResilienceFlag = bitReaderBuffer.readBits(1);
                    }
                    this.extensionFlag3 = bitReaderBuffer.readBits(1);
                }
                this.gaSpecificConfig = true;
                return;
            }
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
    }

    private void parseHilnEnexConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            int readBits = bitReaderBuffer.readBits(1);
            this.hilnEnhaLayer = readBits;
            if (readBits == 1) {
                this.hilnEnhaQuantMode = bitReaderBuffer.readBits(2);
            }
        }
    }

    private void parseParametricSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bitReaderBuffer}) == null) {
            int readBits = bitReaderBuffer.readBits(1);
            this.isBaseLayer = readBits;
            if (readBits == 1) {
                parseParaConfig(i, i2, i3, bitReaderBuffer);
            } else {
                parseHilnEnexConfig(i, i2, i3, bitReaderBuffer);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioSpecificConfig.class != obj.getClass()) {
                return false;
            }
            AudioSpecificConfig audioSpecificConfig = (AudioSpecificConfig) obj;
            if (this.aacScalefactorDataResilienceFlag == audioSpecificConfig.aacScalefactorDataResilienceFlag && this.aacSectionDataResilienceFlag == audioSpecificConfig.aacSectionDataResilienceFlag && this.aacSpectralDataResilienceFlag == audioSpecificConfig.aacSpectralDataResilienceFlag && this.audioObjectType == audioSpecificConfig.audioObjectType && this.channelConfiguration == audioSpecificConfig.channelConfiguration && this.coreCoderDelay == audioSpecificConfig.coreCoderDelay && this.dependsOnCoreCoder == audioSpecificConfig.dependsOnCoreCoder && this.directMapping == audioSpecificConfig.directMapping && this.epConfig == audioSpecificConfig.epConfig && this.erHvxcExtensionFlag == audioSpecificConfig.erHvxcExtensionFlag && this.extensionAudioObjectType == audioSpecificConfig.extensionAudioObjectType && this.extensionChannelConfiguration == audioSpecificConfig.extensionChannelConfiguration && this.extensionFlag == audioSpecificConfig.extensionFlag && this.extensionFlag3 == audioSpecificConfig.extensionFlag3 && this.extensionSamplingFrequency == audioSpecificConfig.extensionSamplingFrequency && this.extensionSamplingFrequencyIndex == audioSpecificConfig.extensionSamplingFrequencyIndex && this.fillBits == audioSpecificConfig.fillBits && this.frameLengthFlag == audioSpecificConfig.frameLengthFlag && this.gaSpecificConfig == audioSpecificConfig.gaSpecificConfig && this.hilnContMode == audioSpecificConfig.hilnContMode && this.hilnEnhaLayer == audioSpecificConfig.hilnEnhaLayer && this.hilnEnhaQuantMode == audioSpecificConfig.hilnEnhaQuantMode && this.hilnFrameLength == audioSpecificConfig.hilnFrameLength && this.hilnMaxNumLine == audioSpecificConfig.hilnMaxNumLine && this.hilnQuantMode == audioSpecificConfig.hilnQuantMode && this.hilnSampleRateCode == audioSpecificConfig.hilnSampleRateCode && this.hvxcRateMode == audioSpecificConfig.hvxcRateMode && this.hvxcVarMode == audioSpecificConfig.hvxcVarMode && this.isBaseLayer == audioSpecificConfig.isBaseLayer && this.layerNr == audioSpecificConfig.layerNr && this.layer_length == audioSpecificConfig.layer_length && this.numOfSubFrame == audioSpecificConfig.numOfSubFrame && this.paraExtensionFlag == audioSpecificConfig.paraExtensionFlag && this.paraMode == audioSpecificConfig.paraMode && this.parametricSpecificConfig == audioSpecificConfig.parametricSpecificConfig && this.psPresentFlag == audioSpecificConfig.psPresentFlag && this.sacPayloadEmbedding == audioSpecificConfig.sacPayloadEmbedding && this.samplingFrequency == audioSpecificConfig.samplingFrequency && this.samplingFrequencyIndex == audioSpecificConfig.samplingFrequencyIndex && this.sbrPresentFlag == audioSpecificConfig.sbrPresentFlag && this.syncExtensionType == audioSpecificConfig.syncExtensionType && this.var_ScalableFlag == audioSpecificConfig.var_ScalableFlag && Arrays.equals(this.configBytes, audioSpecificConfig.configBytes)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            byte[] bArr = this.configBytes;
            if (bArr != null) {
                i = Arrays.hashCode(bArr);
            } else {
                i = 0;
            }
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 31) + this.audioObjectType) * 31) + this.samplingFrequencyIndex) * 31) + this.samplingFrequency) * 31) + this.channelConfiguration) * 31) + this.extensionAudioObjectType) * 31) + this.sbrPresentFlag) * 31) + this.psPresentFlag) * 31) + this.extensionSamplingFrequencyIndex) * 31) + this.extensionSamplingFrequency) * 31) + this.extensionChannelConfiguration) * 31) + this.sacPayloadEmbedding) * 31) + this.fillBits) * 31) + this.epConfig) * 31) + this.directMapping) * 31) + this.syncExtensionType) * 31) + this.frameLengthFlag) * 31) + this.dependsOnCoreCoder) * 31) + this.coreCoderDelay) * 31) + this.extensionFlag) * 31) + this.layerNr) * 31) + this.numOfSubFrame) * 31) + this.layer_length) * 31) + this.aacSectionDataResilienceFlag) * 31) + this.aacScalefactorDataResilienceFlag) * 31) + this.aacSpectralDataResilienceFlag) * 31) + this.extensionFlag3) * 31) + (this.gaSpecificConfig ? 1 : 0)) * 31) + this.isBaseLayer) * 31) + this.paraMode) * 31) + this.paraExtensionFlag) * 31) + this.hvxcVarMode) * 31) + this.hvxcRateMode) * 31) + this.erHvxcExtensionFlag) * 31) + this.var_ScalableFlag) * 31) + this.hilnQuantMode) * 31) + this.hilnMaxNumLine) * 31) + this.hilnSampleRateCode) * 31) + this.hilnFrameLength) * 31) + this.hilnContMode) * 31) + this.hilnEnhaLayer) * 31) + this.hilnEnhaQuantMode) * 31) + (this.parametricSpecificConfig ? 1 : 0);
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            ByteBuffer slice = byteBuffer.slice();
            slice.limit(this.sizeOfInstance);
            byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
            byte[] bArr = new byte[this.sizeOfInstance];
            this.configBytes = bArr;
            slice.get(bArr);
            slice.rewind();
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(slice);
            this.audioObjectType = getAudioObjectType(bitReaderBuffer);
            int readBits = bitReaderBuffer.readBits(4);
            this.samplingFrequencyIndex = readBits;
            if (readBits == 15) {
                this.samplingFrequency = bitReaderBuffer.readBits(24);
            }
            this.channelConfiguration = bitReaderBuffer.readBits(4);
            int i = this.audioObjectType;
            if (i != 5 && i != 29) {
                this.extensionAudioObjectType = 0;
            } else {
                this.extensionAudioObjectType = 5;
                this.sbrPresentFlag = 1;
                if (this.audioObjectType == 29) {
                    this.psPresentFlag = 1;
                }
                int readBits2 = bitReaderBuffer.readBits(4);
                this.extensionSamplingFrequencyIndex = readBits2;
                if (readBits2 == 15) {
                    this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                }
                int audioObjectType = getAudioObjectType(bitReaderBuffer);
                this.audioObjectType = audioObjectType;
                if (audioObjectType == 22) {
                    this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
                }
            }
            int i2 = this.audioObjectType;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    parseGaSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                    break;
                case 8:
                    throw new UnsupportedOperationException("can't parse CelpSpecificConfig yet");
                case 9:
                    throw new UnsupportedOperationException("can't parse HvxcSpecificConfig yet");
                case 12:
                    throw new UnsupportedOperationException("can't parse TTSSpecificConfig yet");
                case 13:
                case 14:
                case 15:
                case 16:
                    throw new UnsupportedOperationException("can't parse StructuredAudioSpecificConfig yet");
                case 24:
                    throw new UnsupportedOperationException("can't parse ErrorResilientCelpSpecificConfig yet");
                case 25:
                    throw new UnsupportedOperationException("can't parse ErrorResilientHvxcSpecificConfig yet");
                case 26:
                case 27:
                    parseParametricSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, i2, bitReaderBuffer);
                    break;
                case 28:
                    throw new UnsupportedOperationException("can't parse SSCSpecificConfig yet");
                case 30:
                    this.sacPayloadEmbedding = bitReaderBuffer.readBits(1);
                    throw new UnsupportedOperationException("can't parse SpatialSpecificConfig yet");
                case 32:
                case 33:
                case 34:
                    throw new UnsupportedOperationException("can't parse MPEG_1_2_SpecificConfig yet");
                case 35:
                    throw new UnsupportedOperationException("can't parse DSTSpecificConfig yet");
                case 36:
                    this.fillBits = bitReaderBuffer.readBits(5);
                    throw new UnsupportedOperationException("can't parse ALSSpecificConfig yet");
                case 37:
                case 38:
                    throw new UnsupportedOperationException("can't parse SLSSpecificConfig yet");
                case 39:
                    throw new UnsupportedOperationException("can't parse ELDSpecificConfig yet");
                case 40:
                case 41:
                    throw new UnsupportedOperationException("can't parse SymbolicMusicSpecificConfig yet");
            }
            int i3 = this.audioObjectType;
            if (i3 != 17 && i3 != 39) {
                switch (i3) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                        break;
                    default:
                        if (this.extensionAudioObjectType == 5 && bitReaderBuffer.remainingBits() >= 16) {
                            int readBits3 = bitReaderBuffer.readBits(11);
                            this.syncExtensionType = readBits3;
                            if (readBits3 == 695) {
                                int audioObjectType2 = getAudioObjectType(bitReaderBuffer);
                                this.extensionAudioObjectType = audioObjectType2;
                                if (audioObjectType2 == 5) {
                                    int readBits4 = bitReaderBuffer.readBits(1);
                                    this.sbrPresentFlag = readBits4;
                                    if (readBits4 == 1) {
                                        int readBits5 = bitReaderBuffer.readBits(4);
                                        this.extensionSamplingFrequencyIndex = readBits5;
                                        if (readBits5 == 15) {
                                            this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                                        }
                                        if (bitReaderBuffer.remainingBits() >= 12) {
                                            int readBits6 = bitReaderBuffer.readBits(11);
                                            this.syncExtensionType = readBits6;
                                            if (readBits6 == 1352) {
                                                this.psPresentFlag = bitReaderBuffer.readBits(1);
                                            }
                                        }
                                    }
                                }
                                if (this.extensionAudioObjectType == 22) {
                                    int readBits7 = bitReaderBuffer.readBits(1);
                                    this.sbrPresentFlag = readBits7;
                                    if (readBits7 == 1) {
                                        int readBits8 = bitReaderBuffer.readBits(4);
                                        this.extensionSamplingFrequencyIndex = readBits8;
                                        if (readBits8 == 15) {
                                            this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                                        }
                                    }
                                    this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                }
            }
            int readBits9 = bitReaderBuffer.readBits(2);
            this.epConfig = readBits9;
            if (readBits9 != 2 && readBits9 != 3) {
                if (readBits9 == 3) {
                    int readBits10 = bitReaderBuffer.readBits(1);
                    this.directMapping = readBits10;
                    if (readBits10 == 0) {
                        throw new RuntimeException("not implemented");
                    }
                }
                if (this.extensionAudioObjectType == 5) {
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
        }
    }

    public ByteBuffer serialize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
            IsoTypeWriter.writeUInt8(allocate, 5);
            IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(allocate);
            bitWriterBuffer.writeBits(this.audioObjectType, 5);
            bitWriterBuffer.writeBits(this.samplingFrequencyIndex, 4);
            if (this.samplingFrequencyIndex != 15) {
                bitWriterBuffer.writeBits(this.channelConfiguration, 4);
                return allocate;
            }
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioSpecificConfig");
            sb.append("{configBytes=");
            sb.append(Hex.encodeHex(this.configBytes));
            sb.append(", audioObjectType=");
            sb.append(this.audioObjectType);
            sb.append(" (");
            sb.append(audioObjectTypeMap.get(Integer.valueOf(this.audioObjectType)));
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(", samplingFrequencyIndex=");
            sb.append(this.samplingFrequencyIndex);
            sb.append(" (");
            sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.samplingFrequencyIndex)));
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(", samplingFrequency=");
            sb.append(this.samplingFrequency);
            sb.append(", channelConfiguration=");
            sb.append(this.channelConfiguration);
            if (this.extensionAudioObjectType > 0) {
                sb.append(", extensionAudioObjectType=");
                sb.append(this.extensionAudioObjectType);
                sb.append(" (");
                sb.append(audioObjectTypeMap.get(Integer.valueOf(this.extensionAudioObjectType)));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(", sbrPresentFlag=");
                sb.append(this.sbrPresentFlag);
                sb.append(", psPresentFlag=");
                sb.append(this.psPresentFlag);
                sb.append(", extensionSamplingFrequencyIndex=");
                sb.append(this.extensionSamplingFrequencyIndex);
                sb.append(" (");
                sb.append(samplingFrequencyIndexMap.get(Integer.valueOf(this.extensionSamplingFrequencyIndex)));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(", extensionSamplingFrequency=");
                sb.append(this.extensionSamplingFrequency);
                sb.append(", extensionChannelConfiguration=");
                sb.append(this.extensionChannelConfiguration);
            }
            sb.append(", syncExtensionType=");
            sb.append(this.syncExtensionType);
            if (this.gaSpecificConfig) {
                sb.append(", frameLengthFlag=");
                sb.append(this.frameLengthFlag);
                sb.append(", dependsOnCoreCoder=");
                sb.append(this.dependsOnCoreCoder);
                sb.append(", coreCoderDelay=");
                sb.append(this.coreCoderDelay);
                sb.append(", extensionFlag=");
                sb.append(this.extensionFlag);
                sb.append(", layerNr=");
                sb.append(this.layerNr);
                sb.append(", numOfSubFrame=");
                sb.append(this.numOfSubFrame);
                sb.append(", layer_length=");
                sb.append(this.layer_length);
                sb.append(", aacSectionDataResilienceFlag=");
                sb.append(this.aacSectionDataResilienceFlag);
                sb.append(", aacScalefactorDataResilienceFlag=");
                sb.append(this.aacScalefactorDataResilienceFlag);
                sb.append(", aacSpectralDataResilienceFlag=");
                sb.append(this.aacSpectralDataResilienceFlag);
                sb.append(", extensionFlag3=");
                sb.append(this.extensionFlag3);
            }
            if (this.parametricSpecificConfig) {
                sb.append(", isBaseLayer=");
                sb.append(this.isBaseLayer);
                sb.append(", paraMode=");
                sb.append(this.paraMode);
                sb.append(", paraExtensionFlag=");
                sb.append(this.paraExtensionFlag);
                sb.append(", hvxcVarMode=");
                sb.append(this.hvxcVarMode);
                sb.append(", hvxcRateMode=");
                sb.append(this.hvxcRateMode);
                sb.append(", erHvxcExtensionFlag=");
                sb.append(this.erHvxcExtensionFlag);
                sb.append(", var_ScalableFlag=");
                sb.append(this.var_ScalableFlag);
                sb.append(", hilnQuantMode=");
                sb.append(this.hilnQuantMode);
                sb.append(", hilnMaxNumLine=");
                sb.append(this.hilnMaxNumLine);
                sb.append(", hilnSampleRateCode=");
                sb.append(this.hilnSampleRateCode);
                sb.append(", hilnFrameLength=");
                sb.append(this.hilnFrameLength);
                sb.append(", hilnContMode=");
                sb.append(this.hilnContMode);
                sb.append(", hilnEnhaLayer=");
                sb.append(this.hilnEnhaLayer);
                sb.append(", hilnEnhaQuantMode=");
                sb.append(this.hilnEnhaQuantMode);
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
