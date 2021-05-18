package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.RequiresParseDetailAspect;
import g.a.a.a;
import g.a.b.b.b;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AppleTrackNumberBox extends AppleDataBox {
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_0 = null;
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_1 = null;
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_2 = null;
    public static final /* synthetic */ a.InterfaceC1909a ajc$tjp_3 = null;

    /* renamed from: a  reason: collision with root package name */
    public int f31562a;

    /* renamed from: b  reason: collision with root package name */
    public int f31563b;

    static {
        ajc$preClinit();
    }

    public AppleTrackNumberBox() {
        super("tkrn", 0);
    }

    public static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleTrackNumberBox.java", AppleTrackNumberBox.class);
        ajc$tjp_0 = bVar.g("method-execution", bVar.f("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 16);
        ajc$tjp_1 = bVar.g("method-execution", bVar.f("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "a", "", "void"), 20);
        ajc$tjp_2 = bVar.g("method-execution", bVar.f("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 24);
        ajc$tjp_3 = bVar.g("method-execution", bVar.f("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "b", "", "void"), 28);
    }

    public int getA() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.f31562a;
    }

    public int getB() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return this.f31563b;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getDataLength() {
        return 8;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void parseData(ByteBuffer byteBuffer) {
        this.f31562a = byteBuffer.getInt();
        this.f31563b = byteBuffer.getInt();
    }

    public void setA(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, g.a.b.a.a.e(i2)));
        this.f31562a = i2;
    }

    public void setB(int i2) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_3, this, this, g.a.b.a.a.e(i2)));
        this.f31563b = i2;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(this.f31562a);
        allocate.putInt(this.f31563b);
        return allocate.array();
    }
}
