package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class DataEntryUrlBox extends AbstractFullBox {
    public static final String TYPE = "url ";
    public static final /* synthetic */ a.InterfaceC1962a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    public DataEntryUrlBox() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("DataEntryUrlBox.java", DataEntryUrlBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "toString", "com.coremedia.iso.boxes.DataEntryUrlBox", "", "", "", "java.lang.String"), 51);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 4L;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return "DataEntryUrlBox[]";
    }
}
