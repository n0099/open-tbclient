package com.coremedia.iso.boxes;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
public class PerformerBox extends AbstractFullBox {
    public static final String TYPE = "perf";
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_4 = null;
    public String language;
    public String performer;

    static {
        ajc$preClinit();
    }

    public PerformerBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PerformerBox.java", PerformerBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getLanguage", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 41);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getPerformer", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 45);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setLanguage", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", KsMediaMeta.KSM_KEY_LANGUAGE, "", "void"), 49);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setPerformer", "com.coremedia.iso.boxes.PerformerBox", "java.lang.String", "performer", "", "void"), 53);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.PerformerBox", "", "", "", "java.lang.String"), 76);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.performer = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.performer));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.performer) + 6 + 1;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getPerformer() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.performer;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public void setPerformer(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.performer = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return "PerformerBox[language=" + getLanguage() + ";performer=" + getPerformer() + PreferencesUtil.RIGHT_MOUNT;
    }
}
