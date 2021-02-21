package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes6.dex */
public class PixelAspectRationAtom extends AbstractBox {
    public static final String TYPE = "pasp";
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1310a ajc$tjp_3 = null;
    private int hSpacing;
    private int vSpacing;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PixelAspectRationAtom.java", PixelAspectRationAtom.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "gethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 35);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "sethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "hSpacing", "", "void"), 39);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 43);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "vSpacing", "", "void"), 47);
    }

    public PixelAspectRationAtom() {
        super(TYPE);
    }

    public int gethSpacing() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.hSpacing;
    }

    public void sethSpacing(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Sx(i)));
        this.hSpacing = i;
    }

    public int getvSpacing() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.vSpacing;
    }

    public void setvSpacing(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.Sx(i)));
        this.vSpacing = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 8L;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.hSpacing);
        byteBuffer.putInt(this.vSpacing);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.hSpacing = byteBuffer.getInt();
        this.vSpacing = byteBuffer.getInt();
    }
}
