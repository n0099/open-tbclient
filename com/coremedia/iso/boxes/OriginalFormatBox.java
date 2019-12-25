package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes4.dex */
public class OriginalFormatBox extends AbstractBox {
    static final /* synthetic */ boolean $assertionsDisabled;
    public static final String TYPE = "frma";
    private static final /* synthetic */ a.InterfaceC0719a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0719a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0719a ajc$tjp_2 = null;
    private String dataFormat;

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("OriginalFormatBox.java", OriginalFormatBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", FieldUtil.TYPE_STRING), 42);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", FieldUtil.TYPE_STRING, "dataFormat", "", "void"), 47);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", FieldUtil.TYPE_STRING), 67);
    }

    static {
        ajc$preClinit();
        $assertionsDisabled = !OriginalFormatBox.class.desiredAssertionStatus();
    }

    public OriginalFormatBox() {
        super(TYPE);
        this.dataFormat = "    ";
    }

    public String getDataFormat() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.dataFormat;
    }

    public void setDataFormat(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, str));
        if (!$assertionsDisabled && str.length() != 4) {
            throw new AssertionError();
        }
        this.dataFormat = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 4L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.dataFormat = IsoTypeReader.read4cc(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.fourCCtoBytes(this.dataFormat));
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "OriginalFormatBox[dataFormat=" + getDataFormat() + "]";
    }
}
