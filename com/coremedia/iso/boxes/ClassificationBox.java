package com.coremedia.iso.boxes;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
public class ClassificationBox extends AbstractFullBox {
    public static final String TYPE = "clsf";
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_3 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_4 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_5 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_6 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_7 = null;
    public static final /* synthetic */ a.InterfaceC1965a ajc$tjp_8 = null;
    public String classificationEntity;
    public String classificationInfo;
    public int classificationTableIndex;
    public String language;

    static {
        ajc$preClinit();
    }

    public ClassificationBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ClassificationBox.java", ClassificationBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 44);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 48);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 56);
        ajc$tjp_4 = bVar.g("method-execution", bVar.f("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 60);
        ajc$tjp_5 = bVar.g("method-execution", bVar.f("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ajc$tjp_6 = bVar.g("method-execution", bVar.f("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", KsMediaMeta.KSM_KEY_LANGUAGE, "", "void"), 68);
        ajc$tjp_7 = bVar.g("method-execution", bVar.f("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        ajc$tjp_8 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 101);
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

    public String getClassificationEntity() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_1, this, this));
        return this.classificationEntity;
    }

    public String getClassificationInfo() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_3, this, this));
        return this.classificationInfo;
    }

    public int getClassificationTableIndex() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.classificationTableIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.classificationEntity));
        IsoTypeWriter.writeUInt16(byteBuffer, this.classificationTableIndex);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.classificationInfo));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.classificationInfo) + 8 + 1;
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.language;
    }

    public void setClassificationEntity(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_4, this, this, str));
        this.classificationEntity = str;
    }

    public void setClassificationInfo(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_7, this, this, str));
        this.classificationInfo = str;
    }

    public void setClassificationTableIndex(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_5, this, this, g.a.b.a.a.e(i2)));
        this.classificationTableIndex = i2;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_6, this, this, str));
        this.language = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_8, this, this));
        return "ClassificationBox[language=" + getLanguage() + "classificationEntity=" + getClassificationEntity() + ";classificationTableIndex=" + getClassificationTableIndex() + ";language=" + getLanguage() + ";classificationInfo=" + getClassificationInfo() + PreferencesUtil.RIGHT_MOUNT;
    }
}
