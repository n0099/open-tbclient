package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class SegmentTypeBox extends AbstractBox {
    public static final String TYPE = "styp";
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1898a ajc$tjp_5 = null;
    public List<String> compatibleBrands;
    public String majorBrand;
    public long minorVersion;

    static {
        ajc$preClinit();
    }

    public SegmentTypeBox() {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SegmentTypeBox.java", SegmentTypeBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "int", "minorVersion", "", "void"), 103);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.majorBrand = IsoTypeReader.read4cc(byteBuffer);
        this.minorVersion = IsoTypeReader.readUInt32(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.compatibleBrands = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.compatibleBrands.add(IsoTypeReader.read4cc(byteBuffer));
        }
    }

    public List<String> getCompatibleBrands() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.compatibleBrands;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.majorBrand));
        IsoTypeWriter.writeUInt32(byteBuffer, this.minorVersion);
        for (String str : this.compatibleBrands) {
            byteBuffer.put(IsoFile.fourCCtoBytes(str));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return (this.compatibleBrands.size() * 4) + 8;
    }

    public String getMajorBrand() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.majorBrand;
    }

    public long getMinorVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.minorVersion;
    }

    public void setCompatibleBrands(List<String> list) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, list));
        this.compatibleBrands = list;
    }

    public void setMajorBrand(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.majorBrand = str;
    }

    public void setMinorVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, g.a.b.a.a.e(i)));
        this.minorVersion = i;
    }

    @DoNotParseDetail
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentTypeBox[");
        sb.append("majorBrand=");
        sb.append(getMajorBrand());
        sb.append(";");
        sb.append("minorVersion=");
        sb.append(getMinorVersion());
        for (String str : this.compatibleBrands) {
            sb.append(";");
            sb.append("compatibleBrand=");
            sb.append(str);
        }
        sb.append("]");
        return sb.toString();
    }

    public SegmentTypeBox(String str, long j, List<String> list) {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
        this.majorBrand = str;
        this.minorVersion = j;
        this.compatibleBrands = list;
    }
}
