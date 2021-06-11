package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoFile;
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
public class RatingBox extends AbstractFullBox {
    public static final String TYPE = "rtng";
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_8 = null;
    public String language;
    public String ratingCriteria;
    public String ratingEntity;
    public String ratingInfo;

    static {
        ajc$preClinit();
    }

    public RatingBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("RatingBox.java", RatingBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "setRatingEntity", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingEntity", "", "void"), 46);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingCriteria", "", "void"), 50);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "setLanguage", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", KsMediaMeta.KSM_KEY_LANGUAGE, "", "void"), 54);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setRatingInfo", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingInfo", "", "void"), 58);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "getLanguage", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 62);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "getRatingEntity", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 73);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "getRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 83);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "getRatingInfo", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 87);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 115);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.ratingEntity = IsoTypeReader.read4cc(byteBuffer);
        this.ratingCriteria = IsoTypeReader.read4cc(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.ratingInfo = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.ratingEntity));
        byteBuffer.put(IsoFile.fourCCtoBytes(this.ratingCriteria));
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.ratingInfo));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.ratingInfo) + 15;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_4, this, this));
        return this.language;
    }

    public String getRatingCriteria() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_6, this, this));
        return this.ratingCriteria;
    }

    public String getRatingEntity() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_5, this, this));
        return this.ratingEntity;
    }

    public String getRatingInfo() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_7, this, this));
        return this.ratingInfo;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public void setRatingCriteria(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.ratingCriteria = str;
    }

    public void setRatingEntity(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_0, this, this, str));
        this.ratingEntity = str;
    }

    public void setRatingInfo(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, str));
        this.ratingInfo = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return "RatingBox[language=" + getLanguage() + "ratingEntity=" + getRatingEntity() + ";ratingCriteria=" + getRatingCriteria() + ";language=" + getLanguage() + ";ratingInfo=" + getRatingInfo() + "]";
    }
}
