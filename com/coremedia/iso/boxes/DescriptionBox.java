package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes20.dex */
public class DescriptionBox extends AbstractFullBox {
    public static final String TYPE = "dscp";
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0924a ajc$tjp_4 = null;
    private String description;
    private String language;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DescriptionBox.java", DescriptionBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getLanguage", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", FieldUtil.TYPE_STRING), 40);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getDescription", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", FieldUtil.TYPE_STRING), 44);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.DescriptionBox", "", "", "", FieldUtil.TYPE_STRING), 67);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setLanguage", "com.coremedia.iso.boxes.DescriptionBox", FieldUtil.TYPE_STRING, "language", "", "void"), 71);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "setDescription", "com.coremedia.iso.boxes.DescriptionBox", FieldUtil.TYPE_STRING, "description", "", "void"), 75);
    }

    public DescriptionBox() {
        super(TYPE);
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getDescription() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.description;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.description) + 7;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.description = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.description));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "DescriptionBox[language=" + getLanguage() + ";description=" + getDescription() + "]";
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.language = str;
    }

    public void setDescription(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this, str));
        this.description = str;
    }
}
