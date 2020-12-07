package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.baidu.mobstat.Config;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static final String TYPE = "sgpd";
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_8 = null;
    private int defaultLength;
    private int descriptionLength;
    private List<GroupEntry> groupEntries;
    private String groupingType;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", FieldUtil.TYPE_STRING), 135);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", FieldUtil.TYPE_STRING, "groupingType", "", "void"), 139);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 143);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 147);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), Opcodes.DCMPL);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 155);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", Config.OS, "", "boolean"), 160);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), Opcodes.INVOKESTATIC);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", FieldUtil.TYPE_STRING), 192);
    }

    public SampleGroupDescriptionBox() {
        super(TYPE);
        this.groupEntries = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j = 8;
        if (getVersion() == 1) {
            j = 8 + 4;
        }
        long j2 = j + 4;
        Iterator<GroupEntry> it = this.groupEntries.iterator();
        while (true) {
            long j3 = j2;
            if (it.hasNext()) {
                GroupEntry next = it.next();
                if (getVersion() == 1 && this.defaultLength == 0) {
                    j3 += 4;
                }
                j2 = next.size() + j3;
            } else {
                return j3;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
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
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() != 1) {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
        this.groupingType = IsoTypeReader.read4cc(byteBuffer);
        if (getVersion() == 1) {
            this.defaultLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
        }
        long readUInt32 = IsoTypeReader.readUInt32(byteBuffer);
        while (true) {
            long j = readUInt32 - 1;
            if (readUInt32 > 0) {
                int i = this.defaultLength;
                if (getVersion() == 1) {
                    if (this.defaultLength == 0) {
                        this.descriptionLength = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
                        i = this.descriptionLength;
                    }
                    int position = byteBuffer.position() + i;
                    ByteBuffer slice = byteBuffer.slice();
                    slice.limit(i);
                    this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                    byteBuffer.position(position);
                    readUInt32 = j;
                } else {
                    throw new RuntimeException("This should be implemented");
                }
            } else {
                return;
            }
        }
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        GroupEntry unknownEntry;
        if (RollRecoveryEntry.TYPE.equals(str)) {
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

    public String getGroupingType() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.groupingType;
    }

    public void setGroupingType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    public int getDefaultLength() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.defaultLength;
    }

    public void setDefaultLength(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.RZ(i)));
        this.defaultLength = i;
    }

    public List<GroupEntry> getGroupEntries() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.groupEntries;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, list));
        this.groupEntries = list;
    }

    public boolean equals(Object obj) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this, obj));
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
        if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
            return false;
        }
        if (this.groupEntries == null ? sampleGroupDescriptionBox.groupEntries != null : !this.groupEntries.equals(sampleGroupDescriptionBox.groupEntries)) {
            return false;
        }
        if (this.groupingType != null) {
            if (this.groupingType.equals(sampleGroupDescriptionBox.groupingType)) {
                return true;
            }
        } else if (sampleGroupDescriptionBox.groupingType == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return ((((this.groupingType != null ? this.groupingType.hashCode() : 0) * 31) + this.defaultLength) * 31) + (this.groupEntries != null ? this.groupEntries.hashCode() : 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return "SampleGroupDescriptionBox{groupingType='" + this.groupingType + "', defaultLength=" + this.defaultLength + ", groupEntries=" + this.groupEntries + '}';
    }
}
