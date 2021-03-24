package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class PixelAspectRationAtom extends AbstractBox {
    public static final String TYPE = "pasp";
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1858a ajc$tjp_3 = null;
    public int hSpacing;
    public int vSpacing;

    static {
        ajc$preClinit();
    }

    public PixelAspectRationAtom() {
        super(TYPE);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("PixelAspectRationAtom.java", PixelAspectRationAtom.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "gethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 35);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "sethSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "hSpacing", "", "void"), 39);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "", "", "", "int"), 43);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setvSpacing", "com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom", "int", "vSpacing", "", "void"), 47);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.hSpacing = byteBuffer.getInt();
        this.vSpacing = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.hSpacing);
        byteBuffer.putInt(this.vSpacing);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        return 8L;
    }

    public int gethSpacing() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.hSpacing;
    }

    public int getvSpacing() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.vSpacing;
    }

    public void sethSpacing(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.e(i)));
        this.hSpacing = i;
    }

    public void setvSpacing(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.e(i)));
        this.vSpacing = i;
    }
}
