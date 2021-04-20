package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class EC3SpecificBox extends AbstractBox {
    public static final String TYPE = "dec3";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_8 = null;
    public int dataRate;
    public List<Entry> entries;
    public int numIndSub;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int acmod;
        public int bsid;
        public int bsmod;
        public int chan_loc;
        public int fscod;
        public int lfeon;
        public int num_dep_sub;
        public int reserved;
        public int reserved2;

        public String toString() {
            return "Entry{fscod=" + this.fscod + ", bsid=" + this.bsid + ", bsmod=" + this.bsmod + ", acmod=" + this.acmod + ", lfeon=" + this.lfeon + ", reserved=" + this.reserved + ", num_dep_sub=" + this.num_dep_sub + ", chan_loc=" + this.chan_loc + ", reserved2=" + this.reserved2 + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public EC3SpecificBox() {
        super(TYPE);
        this.entries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("EC3SpecificBox.java", EC3SpecificBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getContentSize", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "long"), 25);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getContent", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "addEntry", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "com.googlecode.mp4parser.boxes.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 98);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "setDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "getNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 106);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "setNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.dataRate = bitReaderBuffer.readBits(13);
        this.numIndSub = bitReaderBuffer.readBits(3) + 1;
        for (int i = 0; i < this.numIndSub; i++) {
            Entry entry = new Entry();
            entry.fscod = bitReaderBuffer.readBits(2);
            entry.bsid = bitReaderBuffer.readBits(5);
            entry.bsmod = bitReaderBuffer.readBits(5);
            entry.acmod = bitReaderBuffer.readBits(3);
            entry.lfeon = bitReaderBuffer.readBits(1);
            entry.reserved = bitReaderBuffer.readBits(3);
            int readBits = bitReaderBuffer.readBits(4);
            entry.num_dep_sub = readBits;
            if (readBits > 0) {
                entry.chan_loc = bitReaderBuffer.readBits(9);
            } else {
                entry.reserved2 = bitReaderBuffer.readBits(1);
            }
            this.entries.add(entry);
        }
    }

    public void addEntry(Entry entry) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, entry));
        this.entries.add(entry);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, byteBuffer));
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.writeBits(this.dataRate, 13);
        bitWriterBuffer.writeBits(this.entries.size() - 1, 3);
        for (Entry entry : this.entries) {
            bitWriterBuffer.writeBits(entry.fscod, 2);
            bitWriterBuffer.writeBits(entry.bsid, 5);
            bitWriterBuffer.writeBits(entry.bsmod, 5);
            bitWriterBuffer.writeBits(entry.acmod, 3);
            bitWriterBuffer.writeBits(entry.lfeon, 1);
            bitWriterBuffer.writeBits(entry.reserved, 3);
            bitWriterBuffer.writeBits(entry.num_dep_sub, 4);
            if (entry.num_dep_sub > 0) {
                bitWriterBuffer.writeBits(entry.chan_loc, 9);
            } else {
                bitWriterBuffer.writeBits(entry.reserved2, 1);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        long j = 2;
        for (Entry entry : this.entries) {
            j += entry.num_dep_sub > 0 ? 4L : 3L;
        }
        return j;
    }

    public int getDataRate() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.dataRate;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.entries;
    }

    public int getNumIndSub() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.numIndSub;
    }

    public void setDataRate(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, g.a.b.a.a.e(i)));
        this.dataRate = i;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, list));
        this.entries = list;
    }

    public void setNumIndSub(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_8, this, this, g.a.b.a.a.e(i)));
        this.numIndSub = i;
    }
}
