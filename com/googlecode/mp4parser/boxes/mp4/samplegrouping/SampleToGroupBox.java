package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class SampleToGroupBox extends AbstractFullBox {
    public static final String TYPE = "sbgp";
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_5 = null;
    public List<Entry> entries;
    public String groupingType;
    public String groupingTypeParameter;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int groupDescriptionIndex;
        public long sampleCount;

        public Entry(long j, int i2) {
            this.sampleCount = j;
            this.groupDescriptionIndex = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Entry.class != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.groupDescriptionIndex == entry.groupDescriptionIndex && this.sampleCount == entry.sampleCount;
        }

        public int getGroupDescriptionIndex() {
            return this.groupDescriptionIndex;
        }

        public long getSampleCount() {
            return this.sampleCount;
        }

        public int hashCode() {
            long j = this.sampleCount;
            return (((int) (j ^ (j >>> 32))) * 31) + this.groupDescriptionIndex;
        }

        public void setGroupDescriptionIndex(int i2) {
            this.groupDescriptionIndex = i2;
        }

        public void setSampleCount(long j) {
            this.sampleCount = j;
        }

        public String toString() {
            return "Entry{sampleCount=" + this.sampleCount + ", groupDescriptionIndex=" + this.groupDescriptionIndex + '}';
        }
    }

    static {
        ajc$preClinit();
    }

    public SampleToGroupBox() {
        super(TYPE);
        this.entries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleToGroupBox.java", SampleToGroupBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 150);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), Opcodes.IFNE);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 158);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 162);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 166);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.groupingType = IsoTypeReader.read4cc(byteBuffer);
        if (getVersion() == 1) {
            this.groupingTypeParameter = IsoTypeReader.read4cc(byteBuffer);
        }
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        while (true) {
            long j = readUInt32 - 1;
            if (readUInt32 <= 0) {
                return;
            }
            this.entries.add(new Entry(CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer)), CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer))));
            readUInt32 = j;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.groupingType.getBytes());
        if (getVersion() == 1) {
            byteBuffer.put(this.groupingTypeParameter.getBytes());
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getSampleCount());
            IsoTypeWriter.writeUInt32(byteBuffer, entry.getGroupDescriptionIndex());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return getVersion() == 1 ? (this.entries.size() * 8) + 16 : (this.entries.size() * 8) + 12;
    }

    public List<Entry> getEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.entries;
    }

    public String getGroupingType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.groupingType;
    }

    public String getGroupingTypeParameter() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.groupingTypeParameter;
    }

    public void setEntries(List<Entry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, list));
        this.entries = list;
    }

    public void setGroupingType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    public void setGroupingTypeParameter(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.groupingTypeParameter = str;
    }
}
