package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditListBox extends AbstractFullBox {
    public static final String TYPE = "elst";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public List<Entry> entries;

    static {
        ajc$preClinit();
    }

    public EditListBox() {
        super(TYPE);
        this.entries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("EditListBox.java", EditListBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", "entries", "", "void"), 72);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.entries = new LinkedList();
        for (int i = 0; i < l2i; i++) {
            this.entries.add(new Entry(this, byteBuffer));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            entry.getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        int size;
        if (getVersion() == 1) {
            size = this.entries.size() * 20;
        } else {
            size = this.entries.size() * 12;
        }
        return size + 8;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "EditListBox{entries=" + this.entries + '}';
    }

    /* loaded from: classes5.dex */
    public static class Entry {
        public EditListBox editListBox;
        public double mediaRate;
        public long mediaTime;
        public long segmentDuration;

        public Entry(EditListBox editListBox, long j, long j2, double d2) {
            this.segmentDuration = j;
            this.mediaTime = j2;
            this.mediaRate = d2;
            this.editListBox = editListBox;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Entry.class != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.mediaTime == entry.mediaTime && this.segmentDuration == entry.segmentDuration;
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (this.editListBox.getVersion() == 1) {
                IsoTypeWriter.writeUInt64(byteBuffer, this.segmentDuration);
                IsoTypeWriter.writeUInt64(byteBuffer, this.mediaTime);
            } else {
                IsoTypeWriter.writeUInt32(byteBuffer, CastUtils.l2i(this.segmentDuration));
                byteBuffer.putInt(CastUtils.l2i(this.mediaTime));
            }
            IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.mediaRate);
        }

        public double getMediaRate() {
            return this.mediaRate;
        }

        public long getMediaTime() {
            return this.mediaTime;
        }

        public long getSegmentDuration() {
            return this.segmentDuration;
        }

        public int hashCode() {
            long j = this.segmentDuration;
            long j2 = this.mediaTime;
            return (((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public void setMediaRate(double d2) {
            this.mediaRate = d2;
        }

        public void setMediaTime(long j) {
            this.mediaTime = j;
        }

        public void setSegmentDuration(long j) {
            this.segmentDuration = j;
        }

        public String toString() {
            return "Entry{segmentDuration=" + this.segmentDuration + ", mediaTime=" + this.mediaTime + ", mediaRate=" + this.mediaRate + '}';
        }

        public Entry(EditListBox editListBox, ByteBuffer byteBuffer) {
            if (editListBox.getVersion() == 1) {
                this.segmentDuration = IsoTypeReader.readUInt64(byteBuffer);
                this.mediaTime = byteBuffer.getLong();
                this.mediaRate = IsoTypeReader.readFixedPoint1616(byteBuffer);
            } else {
                this.segmentDuration = IsoTypeReader.readUInt32(byteBuffer);
                this.mediaTime = byteBuffer.getInt();
                this.mediaRate = IsoTypeReader.readFixedPoint1616(byteBuffer);
            }
            this.editListBox = editListBox;
        }
    }
}
