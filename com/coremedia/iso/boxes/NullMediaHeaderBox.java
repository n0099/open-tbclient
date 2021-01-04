package com.coremedia.iso.boxes;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class NullMediaHeaderBox extends AbstractMediaHeaderBox {
    public static String TYPE = "nmhd";

    public NullMediaHeaderBox() {
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
}
