package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@Descriptor(tags = {3})
/* loaded from: classes8.dex */
public class ESDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(ESDescriptor.class.getName());
    int URLFlag;
    String URLString;
    DecoderConfigDescriptor decoderConfigDescriptor;
    int dependsOnEsId;
    int esId;
    int oCREsId;
    int oCRstreamFlag;
    int remoteODFlag;
    SLConfigDescriptor slConfigDescriptor;
    int streamDependenceFlag;
    int streamPriority;
    int URLLength = 0;
    List<BaseDescriptor> otherDescriptors = new ArrayList();

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        int i;
        this.esId = IsoTypeReader.readUInt16(byteBuffer);
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.streamDependenceFlag = readUInt8 >>> 7;
        this.URLFlag = (readUInt8 >>> 6) & 1;
        this.oCRstreamFlag = (readUInt8 >>> 5) & 1;
        this.streamPriority = readUInt8 & 31;
        if (this.streamDependenceFlag == 1) {
            this.dependsOnEsId = IsoTypeReader.readUInt16(byteBuffer);
        }
        if (this.URLFlag == 1) {
            this.URLLength = IsoTypeReader.readUInt8(byteBuffer);
            this.URLString = IsoTypeReader.readString(byteBuffer, this.URLLength);
        }
        if (this.oCRstreamFlag == 1) {
            this.oCREsId = IsoTypeReader.readUInt16(byteBuffer);
        }
        int sizeBytes = (this.URLFlag == 1 ? this.URLLength + 1 : 0) + getSizeBytes() + 1 + 2 + 1 + (this.streamDependenceFlag == 1 ? 2 : 0) + (this.oCRstreamFlag == 1 ? 2 : 0);
        int position = byteBuffer.position();
        if (getSize() > sizeBytes + 2) {
            BaseDescriptor createFrom = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            long position2 = byteBuffer.position() - position;
            log.finer(createFrom + " - ESDescriptor1 read: " + position2 + ", size: " + (createFrom != null ? Integer.valueOf(createFrom.getSize()) : null));
            if (createFrom != null) {
                int size = createFrom.getSize();
                byteBuffer.position(position + size);
                i = size + sizeBytes;
            } else {
                i = (int) (sizeBytes + position2);
            }
            if (createFrom instanceof DecoderConfigDescriptor) {
                this.decoderConfigDescriptor = (DecoderConfigDescriptor) createFrom;
            }
        } else {
            i = sizeBytes;
        }
        int position3 = byteBuffer.position();
        if (getSize() > i + 2) {
            BaseDescriptor createFrom2 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            long position4 = byteBuffer.position() - position3;
            log.finer(createFrom2 + " - ESDescriptor2 read: " + position4 + ", size: " + (createFrom2 != null ? Integer.valueOf(createFrom2.getSize()) : null));
            if (createFrom2 != null) {
                int size2 = createFrom2.getSize();
                byteBuffer.position(position3 + size2);
                i += size2;
            } else {
                i = (int) (i + position4);
            }
            if (createFrom2 instanceof SLConfigDescriptor) {
                this.slConfigDescriptor = (SLConfigDescriptor) createFrom2;
            }
        } else {
            log.warning("SLConfigDescriptor is missing!");
        }
        while (getSize() - i > 2) {
            int position5 = byteBuffer.position();
            BaseDescriptor createFrom3 = ObjectDescriptorFactory.createFrom(-1, byteBuffer);
            long position6 = byteBuffer.position() - position5;
            log.finer(createFrom3 + " - ESDescriptor3 read: " + position6 + ", size: " + (createFrom3 != null ? Integer.valueOf(createFrom3.getSize()) : null));
            if (createFrom3 != null) {
                int size3 = createFrom3.getSize();
                byteBuffer.position(position5 + size3);
                i += size3;
            } else {
                i = (int) (position6 + i);
            }
            this.otherDescriptors.add(createFrom3);
        }
    }

    public int serializedSize() {
        int i = 5;
        if (this.streamDependenceFlag > 0) {
            i = 7;
        }
        if (this.URLFlag > 0) {
            i += this.URLLength + 1;
        }
        if (this.oCRstreamFlag > 0) {
            i += 2;
        }
        return i + this.decoderConfigDescriptor.serializedSize() + this.slConfigDescriptor.serializedSize();
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(serializedSize());
        IsoTypeWriter.writeUInt8(allocate, 3);
        IsoTypeWriter.writeUInt8(allocate, serializedSize() - 2);
        IsoTypeWriter.writeUInt16(allocate, this.esId);
        IsoTypeWriter.writeUInt8(allocate, (this.streamDependenceFlag << 7) | (this.URLFlag << 6) | (this.oCRstreamFlag << 5) | (this.streamPriority & 31));
        if (this.streamDependenceFlag > 0) {
            IsoTypeWriter.writeUInt16(allocate, this.dependsOnEsId);
        }
        if (this.URLFlag > 0) {
            IsoTypeWriter.writeUInt8(allocate, this.URLLength);
            IsoTypeWriter.writeUtf8String(allocate, this.URLString);
        }
        if (this.oCRstreamFlag > 0) {
            IsoTypeWriter.writeUInt16(allocate, this.oCREsId);
        }
        ByteBuffer serialize = this.decoderConfigDescriptor.serialize();
        ByteBuffer serialize2 = this.slConfigDescriptor.serialize();
        allocate.put(serialize.array());
        allocate.put(serialize2.array());
        return allocate;
    }

    public DecoderConfigDescriptor getDecoderConfigDescriptor() {
        return this.decoderConfigDescriptor;
    }

    public SLConfigDescriptor getSlConfigDescriptor() {
        return this.slConfigDescriptor;
    }

    public void setDecoderConfigDescriptor(DecoderConfigDescriptor decoderConfigDescriptor) {
        this.decoderConfigDescriptor = decoderConfigDescriptor;
    }

    public void setSlConfigDescriptor(SLConfigDescriptor sLConfigDescriptor) {
        this.slConfigDescriptor = sLConfigDescriptor;
    }

    public List<BaseDescriptor> getOtherDescriptors() {
        return this.otherDescriptors;
    }

    public int getoCREsId() {
        return this.oCREsId;
    }

    public void setoCREsId(int i) {
        this.oCREsId = i;
    }

    public int getEsId() {
        return this.esId;
    }

    public void setEsId(int i) {
        this.esId = i;
    }

    public int getStreamDependenceFlag() {
        return this.streamDependenceFlag;
    }

    public void setStreamDependenceFlag(int i) {
        this.streamDependenceFlag = i;
    }

    public int getURLFlag() {
        return this.URLFlag;
    }

    public void setURLFlag(int i) {
        this.URLFlag = i;
    }

    public int getoCRstreamFlag() {
        return this.oCRstreamFlag;
    }

    public void setoCRstreamFlag(int i) {
        this.oCRstreamFlag = i;
    }

    public int getStreamPriority() {
        return this.streamPriority;
    }

    public void setStreamPriority(int i) {
        this.streamPriority = i;
    }

    public int getURLLength() {
        return this.URLLength;
    }

    public void setURLLength(int i) {
        this.URLLength = i;
    }

    public String getURLString() {
        return this.URLString;
    }

    public void setURLString(String str) {
        this.URLString = str;
    }

    public int getRemoteODFlag() {
        return this.remoteODFlag;
    }

    public void setRemoteODFlag(int i) {
        this.remoteODFlag = i;
    }

    public int getDependsOnEsId() {
        return this.dependsOnEsId;
    }

    public void setDependsOnEsId(int i) {
        this.dependsOnEsId = i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ESDescriptor");
        sb.append("{esId=").append(this.esId);
        sb.append(", streamDependenceFlag=").append(this.streamDependenceFlag);
        sb.append(", URLFlag=").append(this.URLFlag);
        sb.append(", oCRstreamFlag=").append(this.oCRstreamFlag);
        sb.append(", streamPriority=").append(this.streamPriority);
        sb.append(", URLLength=").append(this.URLLength);
        sb.append(", URLString='").append(this.URLString).append('\'');
        sb.append(", remoteODFlag=").append(this.remoteODFlag);
        sb.append(", dependsOnEsId=").append(this.dependsOnEsId);
        sb.append(", oCREsId=").append(this.oCREsId);
        sb.append(", decoderConfigDescriptor=").append(this.decoderConfigDescriptor);
        sb.append(", slConfigDescriptor=").append(this.slConfigDescriptor);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ESDescriptor eSDescriptor = (ESDescriptor) obj;
        if (this.URLFlag == eSDescriptor.URLFlag && this.URLLength == eSDescriptor.URLLength && this.dependsOnEsId == eSDescriptor.dependsOnEsId && this.esId == eSDescriptor.esId && this.oCREsId == eSDescriptor.oCREsId && this.oCRstreamFlag == eSDescriptor.oCRstreamFlag && this.remoteODFlag == eSDescriptor.remoteODFlag && this.streamDependenceFlag == eSDescriptor.streamDependenceFlag && this.streamPriority == eSDescriptor.streamPriority) {
            if (this.URLString == null ? eSDescriptor.URLString != null : !this.URLString.equals(eSDescriptor.URLString)) {
                return false;
            }
            if (this.decoderConfigDescriptor == null ? eSDescriptor.decoderConfigDescriptor != null : !this.decoderConfigDescriptor.equals(eSDescriptor.decoderConfigDescriptor)) {
                return false;
            }
            if (this.otherDescriptors == null ? eSDescriptor.otherDescriptors != null : !this.otherDescriptors.equals(eSDescriptor.otherDescriptors)) {
                return false;
            }
            if (this.slConfigDescriptor != null) {
                if (this.slConfigDescriptor.equals(eSDescriptor.slConfigDescriptor)) {
                    return true;
                }
            } else if (eSDescriptor.slConfigDescriptor == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.slConfigDescriptor != null ? this.slConfigDescriptor.hashCode() : 0) + (((this.decoderConfigDescriptor != null ? this.decoderConfigDescriptor.hashCode() : 0) + (((((((((this.URLString != null ? this.URLString.hashCode() : 0) + (((((((((((this.esId * 31) + this.streamDependenceFlag) * 31) + this.URLFlag) * 31) + this.oCRstreamFlag) * 31) + this.streamPriority) * 31) + this.URLLength) * 31)) * 31) + this.remoteODFlag) * 31) + this.dependsOnEsId) * 31) + this.oCREsId) * 31)) * 31)) * 31) + (this.otherDescriptors != null ? this.otherDescriptors.hashCode() : 0);
    }
}
