package com.coremedia.iso.boxes.fragment;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes11.dex */
public class TrackFragmentRandomAccessBox extends AbstractFullBox {
    public static final String TYPE = "tfra";
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_12 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_9 = null;
    private List<Entry> entries;
    private int lengthSizeOfSampleNum;
    private int lengthSizeOfTrafNum;
    private int lengthSizeOfTrunNum;
    private int reserved;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 145);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), Opcodes.FCMPL);
        ajc$tjp_10 = bVar.a("method-execution", bVar.d("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        ajc$tjp_11 = bVar.a("method-execution", bVar.d("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 189);
        ajc$tjp_12 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", FieldUtil.TYPE_STRING), 290);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), Opcodes.IFEQ);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), Opcodes.IF_ACMPEQ);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), Opcodes.RET);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), Opcodes.RETURN);
        ajc$tjp_9 = bVar.a("method-execution", bVar.d("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), Opcodes.PUTFIELD);
    }

    public TrackFragmentRandomAccessBox() {
        super(TYPE);
        this.lengthSizeOfTrafNum = 2;
        this.lengthSizeOfTrunNum = 2;
        this.lengthSizeOfSampleNum = 2;
        this.entries = Collections.emptyList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long size;
        long j = 4 + 12;
        if (getVersion() == 1) {
            size = j + (this.entries.size() * 16);
        } else {
            size = j + (this.entries.size() * 8);
        }
        return size + (this.lengthSizeOfTrafNum * this.entries.size()) + (this.lengthSizeOfTrunNum * this.entries.size()) + (this.lengthSizeOfSampleNum * this.entries.size());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.readUInt32(byteBuffer);
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved = (int) (readUInt32 >> 6);
        this.lengthSizeOfTrafNum = (((int) (63 & readUInt32)) >> 4) + 1;
        this.lengthSizeOfTrunNum = (((int) (12 & readUInt32)) >> 2) + 1;
        this.lengthSizeOfSampleNum = ((int) (readUInt32 & 3)) + 1;
        long readUInt322 = IsoTypeReader.readUInt32(byteBuffer);
        this.entries = new ArrayList();
        for (int i = 0; i < readUInt322; i++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.time = IsoTypeReader.readUInt64(byteBuffer);
                entry.moofOffset = IsoTypeReader.readUInt64(byteBuffer);
            } else {
                entry.time = IsoTypeReader.readUInt32(byteBuffer);
                entry.moofOffset = IsoTypeReader.readUInt32(byteBuffer);
            }
            entry.trafNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfTrafNum);
            entry.trunNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfTrunNum);
            entry.sampleNumber = IsoTypeReaderVariable.read(byteBuffer, this.lengthSizeOfSampleNum);
            this.entries.add(entry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.trackId);
        IsoTypeWriter.writeUInt32(byteBuffer, (this.reserved << 6) | (((this.lengthSizeOfTrafNum - 1) & 3) << 4) | (((this.lengthSizeOfTrunNum - 1) & 3) << 2) | ((this.lengthSizeOfSampleNum - 1) & 3));
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, entry.time);
                IsoTypeWriter.writeUInt64(byteBuffer, entry.moofOffset);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, entry.time);
                IsoTypeWriter.writeUInt32(byteBuffer, entry.moofOffset);
            }
            IsoTypeWriterVariable.write(entry.trafNumber, byteBuffer, this.lengthSizeOfTrafNum);
            IsoTypeWriterVariable.write(entry.trunNumber, byteBuffer, this.lengthSizeOfTrunNum);
            IsoTypeWriterVariable.write(entry.sampleNumber, byteBuffer, this.lengthSizeOfSampleNum);
        }
    }

    public void setTrackId(long j) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this, org.aspectj.a.a.a.is(j)));
        this.trackId = j;
    }

    public void setLengthSizeOfTrafNum(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.RD(i)));
        this.lengthSizeOfTrafNum = i;
    }

    public void setLengthSizeOfTrunNum(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, org.aspectj.a.a.a.RD(i)));
        this.lengthSizeOfTrunNum = i;
    }

    public void setLengthSizeOfSampleNum(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.RD(i)));
        this.lengthSizeOfSampleNum = i;
    }

    public long getTrackId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.trackId;
    }

    public int getReserved() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.reserved;
    }

    public int getLengthSizeOfTrafNum() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.lengthSizeOfTrafNum;
    }

    public int getLengthSizeOfTrunNum() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.lengthSizeOfTrunNum;
    }

    public int getLengthSizeOfSampleNum() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.lengthSizeOfSampleNum;
    }

    public long getNumberOfEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this));
        return this.entries.size();
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, this, this));
        return Collections.unmodifiableList(this.entries);
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, this, this, list));
        this.entries = list;
    }

    /* loaded from: classes11.dex */
    public static class Entry {
        private long moofOffset;
        private long sampleNumber;
        private long time;
        private long trafNumber;
        private long trunNumber;

        public Entry() {
        }

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this.moofOffset = j2;
            this.sampleNumber = j5;
            this.time = j;
            this.trafNumber = j3;
            this.trunNumber = j4;
        }

        public long getTime() {
            return this.time;
        }

        public long getMoofOffset() {
            return this.moofOffset;
        }

        public long getTrafNumber() {
            return this.trafNumber;
        }

        public long getTrunNumber() {
            return this.trunNumber;
        }

        public long getSampleNumber() {
            return this.sampleNumber;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public void setMoofOffset(long j) {
            this.moofOffset = j;
        }

        public void setTrafNumber(long j) {
            this.trafNumber = j;
        }

        public void setTrunNumber(long j) {
            this.trunNumber = j;
        }

        public void setSampleNumber(long j) {
            this.sampleNumber = j;
        }

        public String toString() {
            return "Entry{time=" + this.time + ", moofOffset=" + this.moofOffset + ", trafNumber=" + this.trafNumber + ", trunNumber=" + this.trunNumber + ", sampleNumber=" + this.sampleNumber + '}';
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.moofOffset == entry.moofOffset && this.sampleNumber == entry.sampleNumber && this.time == entry.time && this.trafNumber == entry.trafNumber && this.trunNumber == entry.trunNumber;
        }

        public int hashCode() {
            return (((((((((int) (this.time ^ (this.time >>> 32))) * 31) + ((int) (this.moofOffset ^ (this.moofOffset >>> 32)))) * 31) + ((int) (this.trafNumber ^ (this.trafNumber >>> 32)))) * 31) + ((int) (this.trunNumber ^ (this.trunNumber >>> 32)))) * 31) + ((int) (this.sampleNumber ^ (this.sampleNumber >>> 32)));
        }
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_12, this, this));
        return "TrackFragmentRandomAccessBox{trackId=" + this.trackId + ", entries=" + this.entries + '}';
    }
}
