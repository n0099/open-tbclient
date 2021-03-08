package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class AppleTrackNumberBox extends AppleDataBox {
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1292a ajc$tjp_3 = null;

    /* renamed from: a  reason: collision with root package name */
    int f5284a;
    int b;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleTrackNumberBox.java", AppleTrackNumberBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 16);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "a", "", "void"), 20);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 24);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", com.baidu.pass.biometrics.face.liveness.d.b.f2804a, "", "void"), 28);
    }

    public AppleTrackNumberBox() {
        super("tkrn", 0);
    }

    public int getA() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.f5284a;
    }

    public void setA(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Sw(i)));
        this.f5284a = i;
    }

    public int getB() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.b;
    }

    public void setB(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.Sw(i)));
        this.b = i;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(this.f5284a);
        allocate.putInt(this.b);
        return allocate.array();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.f5284a = byteBuffer.getInt();
        this.b = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return 8;
    }
}
