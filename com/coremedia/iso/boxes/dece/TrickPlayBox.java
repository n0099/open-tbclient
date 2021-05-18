package com.coremedia.iso.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TrickPlayBox extends AbstractFullBox {
    public static final String TYPE = "trik";
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_2 = null;
    public List<Entry> entries;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int value;

        public Entry() {
        }

        public int getDependencyLevel() {
            return this.value & 63;
        }

        public int getPicType() {
            return (this.value >> 6) & 3;
        }

        public void setDependencyLevel(int i2) {
            this.value = (i2 & 63) | this.value;
        }

        public void setPicType(int i2) {
            int i3 = this.value & 31;
            this.value = i3;
            this.value = ((i2 & 3) << 6) | i3;
        }

        public String toString() {
            return "Entry{picType=" + getPicType() + ",dependencyLevel=" + getDependencyLevel() + '}';
        }

        public Entry(int i2) {
            this.value = i2;
        }
    }

    static {
        ajc$preClinit();
    }

    public TrickPlayBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("TrickPlayBox.java", TrickPlayBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "java.util.List", "entries", "", "void"), 32);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 36);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 103);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() > 0) {
            this.entries.add(new Entry(IsoTypeReader.readUInt8(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt8(byteBuffer, entry.value);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return this.entries.size() + 4;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "TrickPlayBox{entries=" + this.entries + '}';
    }
}
