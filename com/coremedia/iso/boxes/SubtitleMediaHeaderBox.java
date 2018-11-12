package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class SubtitleMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "sthd";
    private static final /* synthetic */ a.InterfaceC0388a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("SubtitleMediaHeaderBox.java", SubtitleMediaHeaderBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "toString", "com.coremedia.iso.boxes.SubtitleMediaHeaderBox", "", "", "", "java.lang.String"), 30);
    }

    public SubtitleMediaHeaderBox() {
        super(TYPE);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 4L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return "SubtitleMediaHeaderBox";
    }
}
