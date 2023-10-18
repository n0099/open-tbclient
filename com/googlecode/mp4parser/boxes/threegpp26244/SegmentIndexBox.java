package com.googlecode.mp4parser.boxes.threegpp26244;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes9.dex */
public class SegmentIndexBox extends AbstractFullBox {
    public static final String TYPE = "sidx";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public long earliestPresentationTime;
    public List<Entry> entries;
    public long firstOffset;
    public long referenceId;
    public int reserved;
    public long timeScale;

    /* loaded from: classes9.dex */
    public static class Entry {
        public byte referenceType;
        public int referencedSize;
        public int sapDeltaTime;
        public byte sapType;
        public byte startsWithSap;
        public long subsegmentDuration;

        public Entry() {
        }

        public byte getReferenceType() {
            return this.referenceType;
        }

        public int getReferencedSize() {
            return this.referencedSize;
        }

        public int getSapDeltaTime() {
            return this.sapDeltaTime;
        }

        public byte getSapType() {
            return this.sapType;
        }

        public byte getStartsWithSap() {
            return this.startsWithSap;
        }

        public long getSubsegmentDuration() {
            return this.subsegmentDuration;
        }

        public int hashCode() {
            long j = this.subsegmentDuration;
            return (((((((((this.referenceType * 31) + this.referencedSize) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.startsWithSap) * 31) + this.sapType) * 31) + this.sapDeltaTime;
        }

        public Entry(byte b, int i, long j, byte b2, byte b3, int i2) {
            this.referenceType = b;
            this.referencedSize = i;
            this.subsegmentDuration = j;
            this.startsWithSap = b2;
            this.sapType = b3;
            this.sapDeltaTime = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Entry.class != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.referenceType == entry.referenceType && this.referencedSize == entry.referencedSize && this.sapDeltaTime == entry.sapDeltaTime && this.sapType == entry.sapType && this.startsWithSap == entry.startsWithSap && this.subsegmentDuration == entry.subsegmentDuration) {
                return true;
            }
            return false;
        }

        public void setReferenceType(byte b) {
            this.referenceType = b;
        }

        public void setReferencedSize(int i) {
            this.referencedSize = i;
        }

        public void setSapDeltaTime(int i) {
            this.sapDeltaTime = i;
        }

        public void setSapType(byte b) {
            this.sapType = b;
        }

        public void setStartsWithSap(byte b) {
            this.startsWithSap = b;
        }

        public void setSubsegmentDuration(long j) {
            this.subsegmentDuration = j;
        }

        public String toString() {
            return "Entry{referenceType=" + ((int) this.referenceType) + ", referencedSize=" + this.referencedSize + ", subsegmentDuration=" + this.subsegmentDuration + ", startsWithSap=" + ((int) this.startsWithSap) + ", sapType=" + ((int) this.sapType) + ", sapDeltaTime=" + this.sapDeltaTime + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public SegmentIndexBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        int i;
        if (getVersion() == 0) {
            i = 8;
        } else {
            i = 16;
        }
        return 12 + i + 2 + 2 + (this.entries.size() * 12);
    }

    public long getEarliestPresentationTime() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
        return this.earliestPresentationTime;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.entries;
    }

    public long getFirstOffset() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
        return this.firstOffset;
    }

    public long getReferenceId() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.referenceId;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, this, this));
        return this.reserved;
    }

    public long getTimeScale() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
        return this.timeScale;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SegmentIndexBox.java", SegmentIndexBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL), 168);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "", "void"), 172);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 136);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "referenceId", "", "void"), Cea708Decoder.COMMAND_DLW);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), Cea708Decoder.COMMAND_SPA);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "timeScale", "", "void"), 148);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), Cea708Decoder.COMMAND_DF0);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), Cea708Decoder.COMMAND_DS4);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 160);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "firstOffset", "", "void"), 164);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.referenceId = IsoTypeReader.readUInt32(byteBuffer);
        this.timeScale = IsoTypeReader.readUInt32(byteBuffer);
        if (getVersion() == 0) {
            this.earliestPresentationTime = IsoTypeReader.readUInt32(byteBuffer);
            this.firstOffset = IsoTypeReader.readUInt32(byteBuffer);
        } else {
            this.earliestPresentationTime = IsoTypeReader.readUInt64(byteBuffer);
            this.firstOffset = IsoTypeReader.readUInt64(byteBuffer);
        }
        this.reserved = IsoTypeReader.readUInt16(byteBuffer);
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        for (int i = 0; i < readUInt16; i++) {
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            Entry entry = new Entry();
            entry.setReferenceType((byte) bitReaderBuffer.readBits(1));
            entry.setReferencedSize(bitReaderBuffer.readBits(31));
            entry.setSubsegmentDuration(IsoTypeReader.readUInt32(byteBuffer));
            BitReaderBuffer bitReaderBuffer2 = new BitReaderBuffer(byteBuffer);
            entry.setStartsWithSap((byte) bitReaderBuffer2.readBits(1));
            entry.setSapType((byte) bitReaderBuffer2.readBits(3));
            entry.setSapDeltaTime(bitReaderBuffer2.readBits(28));
            this.entries.add(entry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.referenceId);
        IsoTypeWriter.writeUInt32(byteBuffer, this.timeScale);
        if (getVersion() == 0) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.writeUInt32(byteBuffer, this.firstOffset);
        } else {
            IsoTypeWriter.writeUInt64(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.writeUInt64(byteBuffer, this.firstOffset);
        }
        IsoTypeWriter.writeUInt16(byteBuffer, this.reserved);
        IsoTypeWriter.writeUInt16(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.writeBits(entry.getReferenceType(), 1);
            bitWriterBuffer.writeBits(entry.getReferencedSize(), 31);
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getSubsegmentDuration());
            BitWriterBuffer bitWriterBuffer2 = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer2.writeBits(entry.getStartsWithSap(), 1);
            bitWriterBuffer2.writeBits(entry.getSapType(), 3);
            bitWriterBuffer2.writeBits(entry.getSapDeltaTime(), 28);
        }
    }

    public void setEarliestPresentationTime(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.longObject(j)));
        this.earliestPresentationTime = j;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public void setFirstOffset(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, Conversions.longObject(j)));
        this.firstOffset = j;
    }

    public void setReferenceId(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.longObject(j)));
        this.referenceId = j;
    }

    public void setReserved(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, this, this, Conversions.intObject(i)));
        this.reserved = i;
    }

    public void setTimeScale(long j) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.longObject(j)));
        this.timeScale = j;
    }
}
