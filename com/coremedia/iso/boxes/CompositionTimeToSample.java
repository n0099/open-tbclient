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
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class CompositionTimeToSample extends AbstractFullBox {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ctts";
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1845a ajc$tjp_1 = null;
    public List<Entry> entries;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int count;
        public int offset;

        public Entry(int i2, int i3) {
            this.count = i2;
            this.offset = i3;
        }

        public int getCount() {
            return this.count;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setCount(int i2) {
            this.count = i2;
        }

        public void setOffset(int i2) {
            this.offset = i2;
        }

        public String toString() {
            return "Entry{count=" + this.count + ", offset=" + this.offset + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public CompositionTimeToSample() {
        super(TYPE);
        this.entries = Collections.emptyList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("CompositionTimeToSample.java", CompositionTimeToSample.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    public static int[] blowupCompositionTimes(List<Entry> list) {
        long j = 0;
        for (Entry entry : list) {
            j += entry.getCount();
        }
        int[] iArr = new int[(int) j];
        int i2 = 0;
        for (Entry entry2 : list) {
            int i3 = 0;
            while (i3 < entry2.getCount()) {
                iArr[i2] = entry2.getOffset();
                i3++;
                i2++;
            }
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int l2i = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        this.entries = new ArrayList(l2i);
        for (int i2 = 0; i2 < l2i; i2++) {
            this.entries.add(new Entry(CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer)), byteBuffer.getInt()));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getCount());
            byteBuffer.putInt(entry.getOffset());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (this.entries.size() * 8) + 8;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }
}
