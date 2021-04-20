package com.googlecode.mp4parser.boxes.ultraviolet;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AssetInformationBox extends AbstractFullBox {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ainf";
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1894a ajc$tjp_3 = null;
    public String apid;
    public String profileVersion;

    static {
        ajc$preClinit();
    }

    public AssetInformationBox() {
        super(TYPE);
        this.apid = "";
        this.profileVersion = "0000";
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AssetInformationBox.java", AssetInformationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getApid", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "", "", "", "java.lang.String"), 62);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setApid", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "java.lang.String", "apid", "", "void"), 66);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getProfileVersion", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "", "", "", "java.lang.String"), 70);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setProfileVersion", "com.googlecode.mp4parser.boxes.ultraviolet.AssetInformationBox", "java.lang.String", "profileVersion", "", "void"), 74);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.profileVersion = IsoTypeReader.readString(byteBuffer, 4);
        this.apid = IsoTypeReader.readString(byteBuffer);
    }

    public String getApid() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.apid;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.profileVersion), 0, 4);
        byteBuffer.put(Utf8.convert(this.apid));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.apid) + 9;
    }

    public String getProfileVersion() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.profileVersion;
    }

    public void setApid(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.apid = str;
    }

    public void setProfileVersion(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.profileVersion = str;
    }
}
