package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.mobstat.Config;
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
public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static final String TYPE = "sgpd";
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1913a ajc$tjp_8 = null;
    public int defaultLength;
    public int descriptionLength;
    public List<GroupEntry> groupEntries;
    public String groupingType;

    static {
        ajc$preClinit();
    }

    public SampleGroupDescriptionBox() {
        super(TYPE);
        this.groupEntries = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 135);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 139);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 143);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 147);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), Opcodes.DCMPL);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 155);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", Config.OS, "", "boolean"), 160);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), Opcodes.INVOKESTATIC);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 192);
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        GroupEntry unknownEntry;
        if ("roll".equals(str)) {
            unknownEntry = new RollRecoveryEntry();
        } else if (RateShareEntry.TYPE.equals(str)) {
            unknownEntry = new RateShareEntry();
        } else if (CencSampleEncryptionInformationGroupEntry.TYPE.equals(str)) {
            unknownEntry = new CencSampleEncryptionInformationGroupEntry();
        } else if (VisualRandomAccessEntry.TYPE.equals(str)) {
            unknownEntry = new VisualRandomAccessEntry();
        } else if (TemporalLevelEntry.TYPE.equals(str)) {
            unknownEntry = new TemporalLevelEntry();
        } else {
            unknownEntry = new UnknownEntry();
        }
        unknownEntry.parse(byteBuffer);
        return unknownEntry;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.groupingType = IsoTypeReader.read4cc(byteBuffer);
            if (getVersion() == 1) {
                this.defaultLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            }
            long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
            while (true) {
                long j = readUInt32 - 1;
                if (readUInt32 <= 0) {
                    return;
                }
                int i2 = this.defaultLength;
                if (getVersion() == 1) {
                    if (this.defaultLength == 0) {
                        i2 = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
                        this.descriptionLength = i2;
                    }
                    int position = byteBuffer.position() + i2;
                    ByteBuffer slice = byteBuffer.slice();
                    slice.limit(i2);
                    this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                    byteBuffer.position(position);
                    readUInt32 = j;
                } else {
                    throw new RuntimeException("This should be implemented");
                }
            }
        } else {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || SampleGroupDescriptionBox.class != obj.getClass()) {
            return false;
        }
        SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
        if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
            return false;
        }
        List<GroupEntry> list = this.groupEntries;
        if (list == null ? sampleGroupDescriptionBox.groupEntries == null : list.equals(sampleGroupDescriptionBox.groupEntries)) {
            String str = this.groupingType;
            String str2 = sampleGroupDescriptionBox.groupingType;
            return str == null ? str2 == null : str.equals(str2);
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.groupingType.getBytes());
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt32(byteBuffer, this.defaultLength);
        }
        IsoTypeWriter.writeUInt32(byteBuffer, this.groupEntries.size());
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                IsoTypeWriter.writeUInt32(byteBuffer, groupEntry.get().limit());
            }
            byteBuffer.put(groupEntry.get());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        long j = (getVersion() == 1 ? 12L : 8L) + 4;
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                j += 4;
            }
            j += groupEntry.size();
        }
        return j;
    }

    public int getDefaultLength() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.defaultLength;
    }

    public List<GroupEntry> getGroupEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.groupEntries;
    }

    public String getGroupingType() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.groupingType;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        String str = this.groupingType;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.defaultLength) * 31;
        List<GroupEntry> list = this.groupEntries;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public void setDefaultLength(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.e(i2)));
        this.defaultLength = i2;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, list));
        this.groupEntries = list;
    }

    public void setGroupingType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return "SampleGroupDescriptionBox{groupingType='" + this.groupingType + "', defaultLength=" + this.defaultLength + ", groupEntries=" + this.groupEntries + '}';
    }
}
