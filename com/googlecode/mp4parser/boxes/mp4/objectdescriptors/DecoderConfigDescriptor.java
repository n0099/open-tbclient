package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.android.common.others.lang.StringUtil;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
@Descriptor(tags = {4})
/* loaded from: classes6.dex */
public class DecoderConfigDescriptor extends BaseDescriptor {
    public static Logger log = Logger.getLogger(DecoderConfigDescriptor.class.getName());
    public AudioSpecificConfig audioSpecificInfo;
    public long avgBitRate;
    public int bufferSizeDB;
    public byte[] configDescriptorDeadBytes;
    public DecoderSpecificInfo decoderSpecificInfo;
    public long maxBitRate;
    public int objectTypeIndication;
    public List<ProfileLevelIndicationDescriptor> profileLevelIndicationDescriptors = new ArrayList();
    public int streamType;
    public int upStream;

    public AudioSpecificConfig getAudioSpecificInfo() {
        return this.audioSpecificInfo;
    }

    public long getAvgBitRate() {
        return this.avgBitRate;
    }

    public int getBufferSizeDB() {
        return this.bufferSizeDB;
    }

    public DecoderSpecificInfo getDecoderSpecificInfo() {
        return this.decoderSpecificInfo;
    }

    public long getMaxBitRate() {
        return this.maxBitRate;
    }

    public int getObjectTypeIndication() {
        return this.objectTypeIndication;
    }

    public List<ProfileLevelIndicationDescriptor> getProfileLevelIndicationDescriptors() {
        return this.profileLevelIndicationDescriptors;
    }

    public int getStreamType() {
        return this.streamType;
    }

    public int getUpStream() {
        return this.upStream;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int size;
        this.objectTypeIndication = IsoTypeReader.readUInt8(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.streamType = readUInt8 >>> 2;
        this.upStream = (readUInt8 >> 1) & 1;
        this.bufferSizeDB = IsoTypeReader.readUInt24(byteBuffer);
        this.maxBitRate = IsoTypeReader.readUInt32(byteBuffer);
        this.avgBitRate = IsoTypeReader.readUInt32(byteBuffer);
        if (byteBuffer.remaining() > 2) {
            int position = byteBuffer.position();
            BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(this.objectTypeIndication, byteBuffer);
            int position2 = byteBuffer.position() - position;
            Logger logger = log;
            StringBuilder sb = new StringBuilder();
            sb.append(createFrom);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(position2);
            sb.append(", size: ");
            sb.append(createFrom != null ? Integer.valueOf(createFrom.getSize()) : null);
            logger.finer(sb.toString());
            if (createFrom != null && position2 < (size = createFrom.getSize())) {
                byte[] bArr = new byte[size - position2];
                this.configDescriptorDeadBytes = bArr;
                byteBuffer.get(bArr);
            }
            if (createFrom instanceof DecoderSpecificInfo) {
                this.decoderSpecificInfo = (DecoderSpecificInfo) createFrom;
            }
            if (createFrom instanceof AudioSpecificConfig) {
                this.audioSpecificInfo = (AudioSpecificConfig) createFrom;
            }
        }
        while (byteBuffer.remaining() > 2) {
            long position3 = byteBuffer.position();
            BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(this.objectTypeIndication, byteBuffer);
            long position4 = byteBuffer.position() - position3;
            Logger logger2 = log;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(createFrom2);
            sb2.append(" - DecoderConfigDescr2 read: ");
            sb2.append(position4);
            sb2.append(", size: ");
            sb2.append(createFrom2 != null ? Integer.valueOf(createFrom2.getSize()) : null);
            logger2.finer(sb2.toString());
            if (createFrom2 instanceof ProfileLevelIndicationDescriptor) {
                this.profileLevelIndicationDescriptors.add((ProfileLevelIndicationDescriptor) createFrom2);
            }
        }
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
        IsoTypeWriter.writeUInt8(allocate, 4);
        IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
        IsoTypeWriter.writeUInt8(allocate, this.objectTypeIndication);
        IsoTypeWriter.writeUInt8(allocate, (this.streamType << 2) | (this.upStream << 1) | 1);
        IsoTypeWriter.writeUInt24(allocate, this.bufferSizeDB);
        IsoTypeWriter.writeUInt32(allocate, this.maxBitRate);
        IsoTypeWriter.writeUInt32(allocate, this.avgBitRate);
        AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
        if (audioSpecificConfig != null) {
            allocate.put(audioSpecificConfig.serialize().array());
        }
        return allocate;
    }

    public int serializedSize() {
        AudioSpecificConfig audioSpecificConfig = this.audioSpecificInfo;
        return (audioSpecificConfig == null ? 0 : audioSpecificConfig.serializedSize()) + 15;
    }

    public void setAudioSpecificInfo(AudioSpecificConfig audioSpecificConfig) {
        this.audioSpecificInfo = audioSpecificConfig;
    }

    public void setAvgBitRate(long j) {
        this.avgBitRate = j;
    }

    public void setBufferSizeDB(int i2) {
        this.bufferSizeDB = i2;
    }

    public void setMaxBitRate(long j) {
        this.maxBitRate = j;
    }

    public void setObjectTypeIndication(int i2) {
        this.objectTypeIndication = i2;
    }

    public void setStreamType(int i2) {
        this.streamType = i2;
    }

    public void setUpStream(int i2) {
        this.upStream = i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.objectTypeIndication);
        sb.append(", streamType=");
        sb.append(this.streamType);
        sb.append(", upStream=");
        sb.append(this.upStream);
        sb.append(", bufferSizeDB=");
        sb.append(this.bufferSizeDB);
        sb.append(", maxBitRate=");
        sb.append(this.maxBitRate);
        sb.append(", avgBitRate=");
        sb.append(this.avgBitRate);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.decoderSpecificInfo);
        sb.append(", audioSpecificInfo=");
        sb.append(this.audioSpecificInfo);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.configDescriptorDeadBytes;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(Hex.encodeHex(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List<ProfileLevelIndicationDescriptor> list = this.profileLevelIndicationDescriptors;
        sb.append(list == null ? StringUtil.NULL_STRING : Arrays.asList(list).toString());
        sb.append('}');
        return sb.toString();
    }
}
