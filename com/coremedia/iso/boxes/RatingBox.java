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
/* loaded from: classes4.dex */
public class RatingBox extends AbstractFullBox {
    public static final String TYPE = "rtng";
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0979a ajc$tjp_8 = null;
    private String language;
    private String ratingCriteria;
    private String ratingEntity;
    private String ratingInfo;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("RatingBox.java", RatingBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "setRatingEntity", "com.coremedia.iso.boxes.RatingBox", FieldUtil.TYPE_STRING, "ratingEntity", "", "void"), 46);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setRatingCriteria", "com.coremedia.iso.boxes.RatingBox", FieldUtil.TYPE_STRING, "ratingCriteria", "", "void"), 50);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "setLanguage", "com.coremedia.iso.boxes.RatingBox", FieldUtil.TYPE_STRING, "language", "", "void"), 54);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setRatingInfo", "com.coremedia.iso.boxes.RatingBox", FieldUtil.TYPE_STRING, "ratingInfo", "", "void"), 58);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "getLanguage", "com.coremedia.iso.boxes.RatingBox", "", "", "", FieldUtil.TYPE_STRING), 62);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "getRatingEntity", "com.coremedia.iso.boxes.RatingBox", "", "", "", FieldUtil.TYPE_STRING), 73);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "getRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "", "", "", FieldUtil.TYPE_STRING), 83);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "getRatingInfo", "com.coremedia.iso.boxes.RatingBox", "", "", "", FieldUtil.TYPE_STRING), 87);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.RatingBox", "", "", "", FieldUtil.TYPE_STRING), 115);
    }

    public RatingBox() {
        super(TYPE);
    }

    public void setRatingEntity(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this, str));
        this.ratingEntity = str;
    }

    public void setRatingCriteria(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.ratingCriteria = str;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public void setRatingInfo(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.ratingInfo = str;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.language;
    }

    public String getRatingEntity() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this));
        return this.ratingEntity;
    }

    public String getRatingCriteria() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.ratingCriteria;
    }

    public String getRatingInfo() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this));
        return this.ratingInfo;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.ratingInfo) + 15;
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
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.fourCCtoBytes(this.ratingEntity));
        byteBuffer.put(IsoFile.fourCCtoBytes(this.ratingCriteria));
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.ratingInfo));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("RatingBox[language=").append(getLanguage());
        sb.append("ratingEntity=").append(getRatingEntity());
        sb.append(";ratingCriteria=").append(getRatingCriteria());
        sb.append(";language=").append(getLanguage());
        sb.append(";ratingInfo=").append(getRatingInfo());
        sb.append("]");
        return sb.toString();
    }
}
