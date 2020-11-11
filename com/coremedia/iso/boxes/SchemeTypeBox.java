package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes11.dex */
public class SchemeTypeBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "schm";
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1089a ajc$tjp_6 = null;
    String schemeType;
    String schemeUri;
    long schemeVersion;

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SchemeTypeBox.java", SchemeTypeBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", FieldUtil.TYPE_STRING), 44);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "long"), 48);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", FieldUtil.TYPE_STRING), 52);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", FieldUtil.TYPE_STRING, "schemeType", "", "void"), 56);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "setSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "int", "schemeVersion", "", "void"), 61);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "setSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", FieldUtil.TYPE_STRING, "schemeUri", "", "void"), 65);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", FieldUtil.TYPE_STRING), 93);
    }

    static {
        ajc$preClinit();
        $assertionsDisabled = !SchemeTypeBox.class.desiredAssertionStatus();
    }

    public SchemeTypeBox() {
        super(TYPE);
        this.schemeType = "    ";
        this.schemeUri = null;
    }

    public String getSchemeType() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.schemeType;
    }

    public long getSchemeVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.schemeVersion;
    }

    public String getSchemeUri() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.schemeUri;
    }

    public void setSchemeType(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        if (!$assertionsDisabled && (str == null || str.length() != 4)) {
            throw new AssertionError("SchemeType may not be null or not 4 bytes long");
        }
        this.schemeType = str;
    }

    public void setSchemeVersion(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, org.aspectj.a.a.a.RD(i)));
        this.schemeVersion = i;
    }

    public void setSchemeUri(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, str));
        this.schemeUri = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return ((getFlags() & 1) == 1 ? Utf8.utf8StringLengthInBytes(this.schemeUri) + 1 : 0) + 12;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeType = IsoTypeReader.read4cc(byteBuffer);
        this.schemeVersion = IsoTypeReader.readUInt32(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.schemeUri = IsoTypeReader.readString(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.schemeType));
        IsoTypeWriter.writeUInt32(byteBuffer, this.schemeVersion);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(Utf8.convert(this.schemeUri));
        }
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("Schema Type Box[");
        sb.append("schemeUri=").append(this.schemeUri).append("; ");
        sb.append("schemeType=").append(this.schemeType).append("; ");
        sb.append("schemeVersion=").append(this.schemeUri).append("; ");
        sb.append("]");
        return sb.toString();
    }
}
