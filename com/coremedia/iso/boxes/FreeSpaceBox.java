package com.coremedia.iso.boxes;

import com.baidu.live.adp.lib.util.FieldUtil;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes3.dex */
public class FreeSpaceBox extends AbstractBox {
    public static final String TYPE = "skip";
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1298a ajc$tjp_2 = null;
    byte[] data;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("FreeSpaceBox.java", FreeSpaceBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "setData", "com.coremedia.iso.boxes.FreeSpaceBox", "[B", "data", "", "void"), 42);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "getData", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "[B"), 46);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "toString", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", FieldUtil.TYPE_STRING), 61);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return this.data.length;
    }

    public FreeSpaceBox() {
        super(TYPE);
    }

    public void setData(byte[] bArr) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this, bArr));
        this.data = bArr;
    }

    public byte[] getData() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return "FreeSpaceBox[size=" + this.data.length + ";type=" + getType() + "]";
    }
}
