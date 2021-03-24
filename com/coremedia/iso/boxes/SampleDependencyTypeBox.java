package com.coremedia.iso.boxes;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
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
public class SampleDependencyTypeBox extends AbstractFullBox {
    public static final String TYPE = "sdtp";
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_2 = null;
    public List<Entry> entries;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int value;

        public Entry(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && Entry.class == obj.getClass() && this.value == ((Entry) obj).value;
        }

        public int getReserved() {
            return (this.value >> 6) & 3;
        }

        public int getSampleDependsOn() {
            return (this.value >> 4) & 3;
        }

        public int getSampleHasRedundancy() {
            return this.value & 3;
        }

        public int getSampleIsDependentOn() {
            return (this.value >> 2) & 3;
        }

        public int hashCode() {
            return this.value;
        }

        public void setReserved(int i) {
            this.value = ((i & 3) << 6) | (this.value & 63);
        }

        public void setSampleDependsOn(int i) {
            this.value = ((i & 3) << 4) | (this.value & 207);
        }

        public void setSampleHasRedundancy(int i) {
            this.value = (i & 3) | (this.value & GDiffPatcher.COPY_INT_UBYTE);
        }

        public void setSampleIsDependentOn(int i) {
            this.value = ((i & 3) << 2) | (this.value & LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK);
        }

        public String toString() {
            return "Entry{reserved=" + getReserved() + ", sampleDependsOn=" + getSampleDependsOn() + ", sampleIsDependentOn=" + getSampleIsDependentOn() + ", sampleHasRedundancy=" + getSampleHasRedundancy() + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public SampleDependencyTypeBox() {
        super(TYPE);
        this.entries = new ArrayList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), 139);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 143);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), Opcodes.LCMP);
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
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "SampleDependencyTypeBox{entries=" + this.entries + '}';
    }
}
