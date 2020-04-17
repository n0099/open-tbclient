package com.coremedia.iso.boxes.fragment;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class SegmentTypeBox extends AbstractBox {
    public static final String TYPE = "styp";
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0805a ajc$tjp_5 = null;
    private List<String> compatibleBrands;
    private String majorBrand;
    private long minorVersion;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SegmentTypeBox.java", SegmentTypeBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", FieldUtil.TYPE_STRING), 85);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", FieldUtil.TYPE_STRING, "majorBrand", "", "void"), 94);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "int", "minorVersion", "", "void"), 103);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), Opcodes.IAND);
    }

    public SegmentTypeBox() {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
    }

    public SegmentTypeBox(String str, long j, List<String> list) {
        super(TYPE);
        this.compatibleBrands = Collections.emptyList();
        this.majorBrand = str;
        this.minorVersion = j;
        this.compatibleBrands = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (this.compatibleBrands.size() * 4) + 8;
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

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.majorBrand));
        IsoTypeWriter.writeUInt32(byteBuffer, this.minorVersion);
        for (String str : this.compatibleBrands) {
            byteBuffer.put(IsoFile.fourCCtoBytes(str));
        }
    }

    public String getMajorBrand() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.majorBrand;
    }

    public void setMajorBrand(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.majorBrand = str;
    }

    public void setMinorVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, org.aspectj.a.a.a.Jp(i)));
        this.minorVersion = i;
    }

    public long getMinorVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.minorVersion;
    }

    public List<String> getCompatibleBrands() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.compatibleBrands;
    }

    public void setCompatibleBrands(List<String> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, list));
        this.compatibleBrands = list;
    }

    @DoNotParseDetail
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SegmentTypeBox[");
        sb.append("majorBrand=").append(getMajorBrand());
        sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append("minorVersion=").append(getMinorVersion());
        for (String str : this.compatibleBrands) {
            sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sb.append("compatibleBrand=").append(str);
        }
        sb.append("]");
        return sb.toString();
    }
}
