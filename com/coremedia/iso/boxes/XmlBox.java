package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public class XmlBox extends AbstractFullBox {
    public static final String TYPE = "xml ";
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_2 = null;
    String xml;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("XmlBox.java", XmlBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getXml", "com.coremedia.iso.boxes.XmlBox", "", "", "", FieldUtil.TYPE_STRING), 20);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setXml", "com.coremedia.iso.boxes.XmlBox", FieldUtil.TYPE_STRING, "xml", "", "void"), 24);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.XmlBox", "", "", "", FieldUtil.TYPE_STRING), 46);
    }

    public XmlBox() {
        super(TYPE);
        this.xml = "";
    }

    public String getXml() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.xml;
    }

    public void setXml(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        this.xml = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.xml) + 4;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.xml = IsoTypeReader.readString(byteBuffer, byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.xml));
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "XmlBox{xml='" + this.xml + "'}";
    }
}
