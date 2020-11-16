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
/* loaded from: classes12.dex */
public class ClassificationBox extends AbstractFullBox {
    public static final String TYPE = "clsf";
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC1092a ajc$tjp_8 = null;
    private String classificationEntity;
    private String classificationInfo;
    private int classificationTableIndex;
    private String language;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ClassificationBox.java", ClassificationBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", FieldUtil.TYPE_STRING), 44);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", FieldUtil.TYPE_STRING), 48);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", FieldUtil.TYPE_STRING), 56);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", FieldUtil.TYPE_STRING, "classificationEntity", "", "void"), 60);
        ajc$tjp_5 = bVar.a("method-execution", bVar.d("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ajc$tjp_6 = bVar.a("method-execution", bVar.d("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", FieldUtil.TYPE_STRING, "language", "", "void"), 68);
        ajc$tjp_7 = bVar.a("method-execution", bVar.d("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", FieldUtil.TYPE_STRING, "classificationInfo", "", "void"), 72);
        ajc$tjp_8 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", FieldUtil.TYPE_STRING), 101);
    }

    public ClassificationBox() {
        super(TYPE);
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getClassificationEntity() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.classificationEntity;
    }

    public int getClassificationTableIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.classificationTableIndex;
    }

    public String getClassificationInfo() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this));
        return this.classificationInfo;
    }

    public void setClassificationEntity(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, str));
        this.classificationEntity = str;
    }

    public void setClassificationTableIndex(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.Sg(i)));
        this.classificationTableIndex = i;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this, str));
        this.language = str;
    }

    public void setClassificationInfo(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, str));
        this.classificationInfo = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.classificationInfo) + 8 + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.classificationEntity = IsoFile.bytesToFourCC(bArr);
        this.classificationTableIndex = IsoTypeReader.readUInt16(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.classificationInfo = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.classificationEntity));
        IsoTypeWriter.writeUInt16(byteBuffer, this.classificationTableIndex);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.classificationInfo));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        StringBuilder sb = new StringBuilder();
        sb.append("ClassificationBox[language=").append(getLanguage());
        sb.append("classificationEntity=").append(getClassificationEntity());
        sb.append(";classificationTableIndex=").append(getClassificationTableIndex());
        sb.append(";language=").append(getLanguage());
        sb.append(";classificationInfo=").append(getClassificationInfo());
        sb.append("]");
        return sb.toString();
    }
}
