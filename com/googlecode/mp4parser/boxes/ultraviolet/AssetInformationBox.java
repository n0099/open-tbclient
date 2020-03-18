package com.googlecode.mp4parser.boxes.ultraviolet;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes7.dex */
public class AssetInformationBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "ainf";
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0782a ajc$tjp_3 = null;
    String apid;
    String profileVersion;

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AssetInformationBox.java", AssetInformationBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getApid", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "", "", "", FieldUtil.TYPE_STRING), 62);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setApid", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", FieldUtil.TYPE_STRING, "apid", "", "void"), 66);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "", "", "", FieldUtil.TYPE_STRING), 70);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", FieldUtil.TYPE_STRING, "profileVersion", "", "void"), 74);
    }

    static {
        ajc$preClinit();
        $assertionsDisabled = !AssetInformationBox.class.desiredAssertionStatus();
    }

    public AssetInformationBox() {
        super(TYPE);
        this.apid = "";
        this.profileVersion = "0000";
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.apid) + 9;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.profileVersion), 0, 4);
        byteBuffer.put(Utf8.convert(this.apid));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.profileVersion = IsoTypeReader.readString(byteBuffer, 4);
        this.apid = IsoTypeReader.readString(byteBuffer);
    }

    public String getApid() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.apid;
    }

    public void setApid(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.apid = str;
    }

    public String getProfileVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.profileVersion;
    }

    public void setProfileVersion(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        if (!$assertionsDisabled && (str == null || str.length() != 4)) {
            throw new AssertionError();
        }
        this.profileVersion = str;
    }
}
