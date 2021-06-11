package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.kwai.video.player.KsMediaMeta;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class DescriptionBox extends AbstractFullBox {
    public static final String TYPE = "dscp";
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_4 = null;
    public String description;
    public String language;

    static {
        ajc$preClinit();
    }

    public DescriptionBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DescriptionBox.java", DescriptionBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getLanguage", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 40);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getDescription", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", "java.lang.String"), 67);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setLanguage", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", KsMediaMeta.KSM_KEY_LANGUAGE, "", "void"), 71);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "setDescription", "com.coremedia.iso.boxes.DescriptionBox", "java.lang.String", "description", "", "void"), 75);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.description = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.description));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.description) + 7;
    }

    public String getDescription() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.description;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.language;
    }

    public void setDescription(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, str));
        this.description = str;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.language = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "DescriptionBox[language=" + getLanguage() + ";description=" + getDescription() + "]";
    }
}
