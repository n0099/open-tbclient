package com.coremedia.iso.boxes.vodafone;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class ContentDistributorIdBox extends AbstractFullBox {
    public static final String TYPE = "cdis";
    private static final /* synthetic */ a.InterfaceC0596a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0596a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0596a ajc$tjp_2 = null;
    private String contentDistributorId;
    private String language;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ContentDistributorIdBox.java", ContentDistributorIdBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getLanguage", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", FieldUtil.TYPE_STRING), 40);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "getContentDistributorId", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", FieldUtil.TYPE_STRING), 44);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.vodafone.ContentDistributorIdBox", "", "", "", FieldUtil.TYPE_STRING), 68);
    }

    public ContentDistributorIdBox() {
        super(TYPE);
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getContentDistributorId() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.contentDistributorId;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.contentDistributorId) + 2 + 5;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.contentDistributorId = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.contentDistributorId));
        byteBuffer.put((byte) 0);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "ContentDistributorIdBox[language=" + getLanguage() + ";contentDistributorId=" + getContentDistributorId() + "]";
    }
}
