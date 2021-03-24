package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SubSampleInformationBox extends AbstractFullBox {
    public static final String TYPE = "subs";
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_2 = null;
    public List<SampleEntry> entries;
    public long entryCount;

    /* loaded from: classes6.dex */
    public static class SampleEntry {
        public long sampleDelta;
        public int subsampleCount;
        public List<SubsampleEntry> subsampleEntries = new ArrayList();

        /* loaded from: classes6.dex */
        public static class SubsampleEntry {
            public int discardable;
            public long reserved;
            public int subsamplePriority;
            public long subsampleSize;

            public int getDiscardable() {
                return this.discardable;
            }

            public long getReserved() {
                return this.reserved;
            }

            public int getSubsamplePriority() {
                return this.subsamplePriority;
            }

            public long getSubsampleSize() {
                return this.subsampleSize;
            }

            public void setDiscardable(int i) {
                this.discardable = i;
            }

            public void setReserved(long j) {
                this.reserved = j;
            }

            public void setSubsamplePriority(int i) {
                this.subsamplePriority = i;
            }

            public void setSubsampleSize(long j) {
                this.subsampleSize = j;
            }

            public String toString() {
                return "SubsampleEntry{subsampleSize=" + this.subsampleSize + ", subsamplePriority=" + this.subsamplePriority + ", discardable=" + this.discardable + ", reserved=" + this.reserved + '}';
            }
        }

        public void addSubsampleEntry(SubsampleEntry subsampleEntry) {
            this.subsampleEntries.add(subsampleEntry);
            this.subsampleCount++;
        }

        public long getSampleDelta() {
            return this.sampleDelta;
        }

        public int getSubsampleCount() {
            return this.subsampleCount;
        }

        public List<SubsampleEntry> getSubsampleEntries() {
            return this.subsampleEntries;
        }

        public void setSampleDelta(long j) {
            this.sampleDelta = j;
        }

        public void setSubsampleCount(int i) {
            this.subsampleCount = i;
        }

        public String toString() {
            return "SampleEntry{sampleDelta=" + this.sampleDelta + ", subsampleCount=" + this.subsampleCount + ", subsampleEntries=" + this.subsampleEntries + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public SubSampleInformationBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SubSampleInformationBox.java", SubSampleInformationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 51);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 55);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 115);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.entryCount = IsoTypeReader.readUInt32(byteBuffer);
        for (int i = 0; i < this.entryCount; i++) {
            SampleEntry sampleEntry = new SampleEntry();
            sampleEntry.setSampleDelta(IsoTypeReader.readUInt32(byteBuffer));
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i2 = 0; i2 < readUInt16; i2++) {
                SampleEntry.SubsampleEntry subsampleEntry = new SampleEntry.SubsampleEntry();
                subsampleEntry.setSubsampleSize(getVersion() == 1 ? IsoTypeReader.readUInt32(byteBuffer) : IsoTypeReader.readUInt16(byteBuffer));
                subsampleEntry.setSubsamplePriority(IsoTypeReader.readUInt8(byteBuffer));
                subsampleEntry.setDiscardable(IsoTypeReader.readUInt8(byteBuffer));
                subsampleEntry.setReserved(IsoTypeReader.readUInt32(byteBuffer));
                sampleEntry.addSubsampleEntry(subsampleEntry);
            }
            this.entries.add(sampleEntry);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (SampleEntry sampleEntry : this.entries) {
            IsoTypeWriter.writeUInt32(byteBuffer, sampleEntry.getSampleDelta());
            IsoTypeWriter.writeUInt16(byteBuffer, sampleEntry.getSubsampleCount());
            for (SampleEntry.SubsampleEntry subsampleEntry : sampleEntry.getSubsampleEntries()) {
                if (getVersion() == 1) {
                    IsoTypeWriter.writeUInt32(byteBuffer, subsampleEntry.getSubsampleSize());
                } else {
                    IsoTypeWriter.writeUInt16(byteBuffer, CastUtils.l2i(subsampleEntry.getSubsampleSize()));
                }
                IsoTypeWriter.writeUInt8(byteBuffer, subsampleEntry.getSubsamplePriority());
                IsoTypeWriter.writeUInt8(byteBuffer, subsampleEntry.getDiscardable());
                IsoTypeWriter.writeUInt32(byteBuffer, subsampleEntry.getReserved());
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        long j = (this.entryCount * 6) + 8;
        int i = 0;
        for (SampleEntry sampleEntry : this.entries) {
            i += sampleEntry.getSubsampleCount() * ((getVersion() == 1 ? 4 : 2) + 1 + 1 + 4);
        }
        return j + i;
    }

    public List<SampleEntry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<SampleEntry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
        this.entryCount = list.size();
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "SubSampleInformationBox{entryCount=" + this.entryCount + ", entries=" + this.entries + '}';
    }
}
