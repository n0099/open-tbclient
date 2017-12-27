package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Descriptor(objectTypeIndication = 64, tags = {5})
/* loaded from: classes2.dex */
public class AudioSpecificConfig extends BaseDescriptor {
    int aacScalefactorDataResilienceFlag;
    int aacSectionDataResilienceFlag;
    int aacSpectralDataResilienceFlag;
    int audioObjectType;
    int channelConfiguration;
    byte[] configBytes;
    int coreCoderDelay;
    int dependsOnCoreCoder;
    int directMapping;
    int epConfig;
    int erHvxcExtensionFlag;
    int extensionAudioObjectType;
    int extensionChannelConfiguration;
    int extensionFlag;
    int extensionFlag3;
    int extensionSamplingFrequency;
    int extensionSamplingFrequencyIndex;
    int fillBits;
    int frameLengthFlag;
    boolean gaSpecificConfig;
    int hilnContMode;
    int hilnEnhaLayer;
    int hilnEnhaQuantMode;
    int hilnFrameLength;
    int hilnMaxNumLine;
    int hilnQuantMode;
    int hilnSampleRateCode;
    int hvxcRateMode;
    int hvxcVarMode;
    int isBaseLayer;
    int layerNr;
    int layer_length;
    int numOfSubFrame;
    int paraExtensionFlag;
    int paraMode;
    boolean parametricSpecificConfig;
    int psPresentFlag;
    int sacPayloadEmbedding;
    int samplingFrequency;
    int samplingFrequencyIndex;
    int sbrPresentFlag;
    int syncExtensionType;
    int var_ScalableFlag;
    public static Map<Integer, Integer> samplingFrequencyIndexMap = new HashMap();
    public static Map<Integer, String> audioObjectTypeMap = new HashMap();

    static {
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

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.sizeOfInstance);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
        this.configBytes = new byte[this.sizeOfInstance];
        slice.get(this.configBytes);
        slice.rewind();
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(slice);
        this.audioObjectType = getAudioObjectType(bitReaderBuffer);
        this.samplingFrequencyIndex = bitReaderBuffer.readBits(4);
        if (this.samplingFrequencyIndex == 15) {
            this.samplingFrequency = bitReaderBuffer.readBits(24);
        }
        this.channelConfiguration = bitReaderBuffer.readBits(4);
        if (this.audioObjectType == 5 || this.audioObjectType == 29) {
            this.extensionAudioObjectType = 5;
            this.sbrPresentFlag = 1;
            if (this.audioObjectType == 29) {
                this.psPresentFlag = 1;
            }
            this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
            if (this.extensionSamplingFrequencyIndex == 15) {
                this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
            }
            this.audioObjectType = getAudioObjectType(bitReaderBuffer);
            if (this.audioObjectType == 22) {
                this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
            }
        } else {
            this.extensionAudioObjectType = 0;
        }
        switch (this.audioObjectType) {
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
                parseGaSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, this.audioObjectType, bitReaderBuffer);
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
                parseParametricSpecificConfig(this.samplingFrequencyIndex, this.channelConfiguration, this.audioObjectType, bitReaderBuffer);
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
        switch (this.audioObjectType) {
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 39:
                this.epConfig = bitReaderBuffer.readBits(2);
                if (this.epConfig == 2 || this.epConfig == 3) {
                    throw new UnsupportedOperationException("can't parse ErrorProtectionSpecificConfig yet");
                }
                if (this.epConfig == 3) {
                    this.directMapping = bitReaderBuffer.readBits(1);
                    if (this.directMapping == 0) {
                        throw new RuntimeException("not implemented");
                    }
                }
                break;
        }
        if (this.extensionAudioObjectType != 5 && bitReaderBuffer.remainingBits() >= 16) {
            this.syncExtensionType = bitReaderBuffer.readBits(11);
            if (this.syncExtensionType == 695) {
                this.extensionAudioObjectType = getAudioObjectType(bitReaderBuffer);
                if (this.extensionAudioObjectType == 5) {
                    this.sbrPresentFlag = bitReaderBuffer.readBits(1);
                    if (this.sbrPresentFlag == 1) {
                        this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                        }
                        if (bitReaderBuffer.remainingBits() >= 12) {
                            this.syncExtensionType = bitReaderBuffer.readBits(11);
                            if (this.syncExtensionType == 1352) {
                                this.psPresentFlag = bitReaderBuffer.readBits(1);
                            }
                        }
                    }
                }
                if (this.extensionAudioObjectType == 22) {
                    this.sbrPresentFlag = bitReaderBuffer.readBits(1);
                    if (this.sbrPresentFlag == 1) {
                        this.extensionSamplingFrequencyIndex = bitReaderBuffer.readBits(4);
                        if (this.extensionSamplingFrequencyIndex == 15) {
                            this.extensionSamplingFrequency = bitReaderBuffer.readBits(24);
                        }
                    }
                    this.extensionChannelConfiguration = bitReaderBuffer.readBits(4);
                }
            }
        }
    }

    private int gaSpecificConfigSize() {
        return 0;
    }

    public int serializedSize() {
        if (this.audioObjectType == 2) {
            return 4 + gaSpecificConfigSize();
        }
        throw new UnsupportedOperationException("can't serialize that yet");
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
        IsoTypeWriter.writeUInt8(allocate, 5);
        IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(allocate);
        bitWriterBuffer.writeBits(this.audioObjectType, 5);
        bitWriterBuffer.writeBits(this.samplingFrequencyIndex, 4);
        if (this.samplingFrequencyIndex == 15) {
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        bitWriterBuffer.writeBits(this.channelConfiguration, 4);
        return allocate;
    }

    private int getAudioObjectType(BitReaderBuffer bitReaderBuffer) throws IOException {
        int readBits = bitReaderBuffer.readBits(5);
        if (readBits == 31) {
            return bitReaderBuffer.readBits(6) + 32;
        }
        return readBits;
    }

    private void parseGaSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.frameLengthFlag = bitReaderBuffer.readBits(1);
        this.dependsOnCoreCoder = bitReaderBuffer.readBits(1);
        if (this.dependsOnCoreCoder == 1) {
            this.coreCoderDelay = bitReaderBuffer.readBits(14);
        }
        this.extensionFlag = bitReaderBuffer.readBits(1);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
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
    }

    private void parseParametricSpecificConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.isBaseLayer = bitReaderBuffer.readBits(1);
        if (this.isBaseLayer == 1) {
            parseParaConfig(i, i2, i3, bitReaderBuffer);
        } else {
            parseHilnEnexConfig(i, i2, i3, bitReaderBuffer);
        }
    }

    private void parseParaConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.paraMode = bitReaderBuffer.readBits(2);
        if (this.paraMode != 1) {
            parseErHvxcConfig(i, i2, i3, bitReaderBuffer);
        }
        if (this.paraMode != 0) {
            parseHilnConfig(i, i2, i3, bitReaderBuffer);
        }
        this.paraExtensionFlag = bitReaderBuffer.readBits(1);
        this.parametricSpecificConfig = true;
    }

    private void parseErHvxcConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hvxcVarMode = bitReaderBuffer.readBits(1);
        this.hvxcRateMode = bitReaderBuffer.readBits(2);
        this.erHvxcExtensionFlag = bitReaderBuffer.readBits(1);
        if (this.erHvxcExtensionFlag == 1) {
            this.var_ScalableFlag = bitReaderBuffer.readBits(1);
        }
    }

    private void parseHilnConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hilnQuantMode = bitReaderBuffer.readBits(1);
        this.hilnMaxNumLine = bitReaderBuffer.readBits(8);
        this.hilnSampleRateCode = bitReaderBuffer.readBits(4);
        this.hilnFrameLength = bitReaderBuffer.readBits(12);
        this.hilnContMode = bitReaderBuffer.readBits(2);
    }

    private void parseHilnEnexConfig(int i, int i2, int i3, BitReaderBuffer bitReaderBuffer) throws IOException {
        this.hilnEnhaLayer = bitReaderBuffer.readBits(1);
        if (this.hilnEnhaLayer == 1) {
            this.hilnEnhaQuantMode = bitReaderBuffer.readBits(2);
        }
    }

    public byte[] getConfigBytes() {
        return this.configBytes;
    }

    public int getAudioObjectType() {
        return this.audioObjectType;
    }

    public int getExtensionAudioObjectType() {
        return this.extensionAudioObjectType;
    }

    public int getSbrPresentFlag() {
        return this.sbrPresentFlag;
    }

    public int getPsPresentFlag() {
        return this.psPresentFlag;
    }

    public void setAudioObjectType(int i) {
        this.audioObjectType = i;
    }

    public void setSamplingFrequencyIndex(int i) {
        this.samplingFrequencyIndex = i;
    }

    public void setSamplingFrequency(int i) {
        this.samplingFrequency = i;
    }

    public void setChannelConfiguration(int i) {
        this.channelConfiguration = i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=").append(Hex.encodeHex(this.configBytes));
        sb.append(", audioObjectType=").append(this.audioObjectType).append(" (").append(audioObjectTypeMap.get(Integer.valueOf(this.audioObjectType))).append(")");
        sb.append(", samplingFrequencyIndex=").append(this.samplingFrequencyIndex).append(" (").append(samplingFrequencyIndexMap.get(Integer.valueOf(this.samplingFrequencyIndex))).append(")");
        sb.append(", samplingFrequency=").append(this.samplingFrequency);
        sb.append(", channelConfiguration=").append(this.channelConfiguration);
        if (this.extensionAudioObjectType > 0) {
            sb.append(", extensionAudioObjectType=").append(this.extensionAudioObjectType).append(" (").append(audioObjectTypeMap.get(Integer.valueOf(this.extensionAudioObjectType))).append(")");
            sb.append(", sbrPresentFlag=").append(this.sbrPresentFlag);
            sb.append(", psPresentFlag=").append(this.psPresentFlag);
            sb.append(", extensionSamplingFrequencyIndex=").append(this.extensionSamplingFrequencyIndex).append(" (").append(samplingFrequencyIndexMap.get(Integer.valueOf(this.extensionSamplingFrequencyIndex))).append(")");
            sb.append(", extensionSamplingFrequency=").append(this.extensionSamplingFrequency);
            sb.append(", extensionChannelConfiguration=").append(this.extensionChannelConfiguration);
        }
        sb.append(", syncExtensionType=").append(this.syncExtensionType);
        if (this.gaSpecificConfig) {
            sb.append(", frameLengthFlag=").append(this.frameLengthFlag);
            sb.append(", dependsOnCoreCoder=").append(this.dependsOnCoreCoder);
            sb.append(", coreCoderDelay=").append(this.coreCoderDelay);
            sb.append(", extensionFlag=").append(this.extensionFlag);
            sb.append(", layerNr=").append(this.layerNr);
            sb.append(", numOfSubFrame=").append(this.numOfSubFrame);
            sb.append(", layer_length=").append(this.layer_length);
            sb.append(", aacSectionDataResilienceFlag=").append(this.aacSectionDataResilienceFlag);
            sb.append(", aacScalefactorDataResilienceFlag=").append(this.aacScalefactorDataResilienceFlag);
            sb.append(", aacSpectralDataResilienceFlag=").append(this.aacSpectralDataResilienceFlag);
            sb.append(", extensionFlag3=").append(this.extensionFlag3);
        }
        if (this.parametricSpecificConfig) {
            sb.append(", isBaseLayer=").append(this.isBaseLayer);
            sb.append(", paraMode=").append(this.paraMode);
            sb.append(", paraExtensionFlag=").append(this.paraExtensionFlag);
            sb.append(", hvxcVarMode=").append(this.hvxcVarMode);
            sb.append(", hvxcRateMode=").append(this.hvxcRateMode);
            sb.append(", erHvxcExtensionFlag=").append(this.erHvxcExtensionFlag);
            sb.append(", var_ScalableFlag=").append(this.var_ScalableFlag);
            sb.append(", hilnQuantMode=").append(this.hilnQuantMode);
            sb.append(", hilnMaxNumLine=").append(this.hilnMaxNumLine);
            sb.append(", hilnSampleRateCode=").append(this.hilnSampleRateCode);
            sb.append(", hilnFrameLength=").append(this.hilnFrameLength);
            sb.append(", hilnContMode=").append(this.hilnContMode);
            sb.append(", hilnEnhaLayer=").append(this.hilnEnhaLayer);
            sb.append(", hilnEnhaQuantMode=").append(this.hilnEnhaQuantMode);
        }
        sb.append('}');
        return sb.toString();
    }

    public int getSamplingFrequency() {
        return this.samplingFrequencyIndex == 15 ? this.samplingFrequency : samplingFrequencyIndexMap.get(Integer.valueOf(this.samplingFrequencyIndex)).intValue();
    }

    public int getChannelConfiguration() {
        return this.channelConfiguration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioSpecificConfig audioSpecificConfig = (AudioSpecificConfig) obj;
        return this.aacScalefactorDataResilienceFlag == audioSpecificConfig.aacScalefactorDataResilienceFlag && this.aacSectionDataResilienceFlag == audioSpecificConfig.aacSectionDataResilienceFlag && this.aacSpectralDataResilienceFlag == audioSpecificConfig.aacSpectralDataResilienceFlag && this.audioObjectType == audioSpecificConfig.audioObjectType && this.channelConfiguration == audioSpecificConfig.channelConfiguration && this.coreCoderDelay == audioSpecificConfig.coreCoderDelay && this.dependsOnCoreCoder == audioSpecificConfig.dependsOnCoreCoder && this.directMapping == audioSpecificConfig.directMapping && this.epConfig == audioSpecificConfig.epConfig && this.erHvxcExtensionFlag == audioSpecificConfig.erHvxcExtensionFlag && this.extensionAudioObjectType == audioSpecificConfig.extensionAudioObjectType && this.extensionChannelConfiguration == audioSpecificConfig.extensionChannelConfiguration && this.extensionFlag == audioSpecificConfig.extensionFlag && this.extensionFlag3 == audioSpecificConfig.extensionFlag3 && this.extensionSamplingFrequency == audioSpecificConfig.extensionSamplingFrequency && this.extensionSamplingFrequencyIndex == audioSpecificConfig.extensionSamplingFrequencyIndex && this.fillBits == audioSpecificConfig.fillBits && this.frameLengthFlag == audioSpecificConfig.frameLengthFlag && this.gaSpecificConfig == audioSpecificConfig.gaSpecificConfig && this.hilnContMode == audioSpecificConfig.hilnContMode && this.hilnEnhaLayer == audioSpecificConfig.hilnEnhaLayer && this.hilnEnhaQuantMode == audioSpecificConfig.hilnEnhaQuantMode && this.hilnFrameLength == audioSpecificConfig.hilnFrameLength && this.hilnMaxNumLine == audioSpecificConfig.hilnMaxNumLine && this.hilnQuantMode == audioSpecificConfig.hilnQuantMode && this.hilnSampleRateCode == audioSpecificConfig.hilnSampleRateCode && this.hvxcRateMode == audioSpecificConfig.hvxcRateMode && this.hvxcVarMode == audioSpecificConfig.hvxcVarMode && this.isBaseLayer == audioSpecificConfig.isBaseLayer && this.layerNr == audioSpecificConfig.layerNr && this.layer_length == audioSpecificConfig.layer_length && this.numOfSubFrame == audioSpecificConfig.numOfSubFrame && this.paraExtensionFlag == audioSpecificConfig.paraExtensionFlag && this.paraMode == audioSpecificConfig.paraMode && this.parametricSpecificConfig == audioSpecificConfig.parametricSpecificConfig && this.psPresentFlag == audioSpecificConfig.psPresentFlag && this.sacPayloadEmbedding == audioSpecificConfig.sacPayloadEmbedding && this.samplingFrequency == audioSpecificConfig.samplingFrequency && this.samplingFrequencyIndex == audioSpecificConfig.samplingFrequencyIndex && this.sbrPresentFlag == audioSpecificConfig.sbrPresentFlag && this.syncExtensionType == audioSpecificConfig.syncExtensionType && this.var_ScalableFlag == audioSpecificConfig.var_ScalableFlag && Arrays.equals(this.configBytes, audioSpecificConfig.configBytes);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.gaSpecificConfig ? 1 : 0) + ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.configBytes != null ? Arrays.hashCode(this.configBytes) : 0) * 31) + this.audioObjectType) * 31) + this.samplingFrequencyIndex) * 31) + this.samplingFrequency) * 31) + this.channelConfiguration) * 31) + this.extensionAudioObjectType) * 31) + this.sbrPresentFlag) * 31) + this.psPresentFlag) * 31) + this.extensionSamplingFrequencyIndex) * 31) + this.extensionSamplingFrequency) * 31) + this.extensionChannelConfiguration) * 31) + this.sacPayloadEmbedding) * 31) + this.fillBits) * 31) + this.epConfig) * 31) + this.directMapping) * 31) + this.syncExtensionType) * 31) + this.frameLengthFlag) * 31) + this.dependsOnCoreCoder) * 31) + this.coreCoderDelay) * 31) + this.extensionFlag) * 31) + this.layerNr) * 31) + this.numOfSubFrame) * 31) + this.layer_length) * 31) + this.aacSectionDataResilienceFlag) * 31) + this.aacScalefactorDataResilienceFlag) * 31) + this.aacSpectralDataResilienceFlag) * 31) + this.extensionFlag3) * 31)) * 31) + this.isBaseLayer) * 31) + this.paraMode) * 31) + this.paraExtensionFlag) * 31) + this.hvxcVarMode) * 31) + this.hvxcRateMode) * 31) + this.erHvxcExtensionFlag) * 31) + this.var_ScalableFlag) * 31) + this.hilnQuantMode) * 31) + this.hilnMaxNumLine) * 31) + this.hilnSampleRateCode) * 31) + this.hilnFrameLength) * 31) + this.hilnContMode) * 31) + this.hilnEnhaLayer) * 31) + this.hilnEnhaQuantMode) * 31) + (this.parametricSpecificConfig ? 1 : 0);
    }
}
