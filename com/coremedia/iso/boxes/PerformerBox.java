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
/* loaded from: classes7.dex */
public class PerformerBox extends AbstractFullBox {
    public static final String TYPE = "perf";
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC1056a ajc$tjp_4 = null;
    private String language;
    private String performer;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PerformerBox.java", PerformerBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getLanguage", "com.coremedia.iso.boxes.PerformerBox", "", "", "", FieldUtil.TYPE_STRING), 41);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getPerformer", "com.coremedia.iso.boxes.PerformerBox", "", "", "", FieldUtil.TYPE_STRING), 45);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "setLanguage", "com.coremedia.iso.boxes.PerformerBox", FieldUtil.TYPE_STRING, "language", "", "void"), 49);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setPerformer", "com.coremedia.iso.boxes.PerformerBox", FieldUtil.TYPE_STRING, "performer", "", "void"), 53);
        ajc$tjp_4 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.PerformerBox", "", "", "", FieldUtil.TYPE_STRING), 76);
    }

    public PerformerBox() {
        super("perf");
    }

    public String getLanguage() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.language;
    }

    public String getPerformer() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.performer;
    }

    public void setLanguage(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this, str));
        this.language = str;
    }

    public void setPerformer(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, str));
        this.performer = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.performer) + 6 + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeIso639(byteBuffer, this.language);
        byteBuffer.put(Utf8.convert(this.performer));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = IsoTypeReader.readIso639(byteBuffer);
        this.performer = IsoTypeReader.readString(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return "PerformerBox[language=" + getLanguage() + ";performer=" + getPerformer() + "]";
    }
}
