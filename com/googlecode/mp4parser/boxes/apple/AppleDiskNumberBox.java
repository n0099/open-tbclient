package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes6.dex */
public class AppleDiskNumberBox extends AppleDataBox {
    private static final /* synthetic */ a.InterfaceC1274a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC1274a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC1274a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC1274a ajc$tjp_3 = null;

    /* renamed from: a  reason: collision with root package name */
    int f8188a;

    /* renamed from: b  reason: collision with root package name */
    short f8189b;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("AppleDiskNumberBox.java", AppleDiskNumberBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.d("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "int"), 16);
        ajc$tjp_1 = bVar.a("method-execution", bVar.d("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "int", "a", "", "void"), 20);
        ajc$tjp_2 = bVar.a("method-execution", bVar.d("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "short"), 24);
        ajc$tjp_3 = bVar.a("method-execution", bVar.d("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "short", com.baidu.pass.biometrics.face.liveness.d.b.f4080a, "", "void"), 28);
    }

    public AppleDiskNumberBox() {
        super("disk", 0);
    }

    public int getA() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.f8188a;
    }

    public void setA(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.Ts(i)));
        this.f8188a = i;
    }

    public short getB() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.f8189b;
    }

    public void setB(short s) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.m(s)));
        this.f8189b = s;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putInt(this.f8188a);
        allocate.putShort(this.f8189b);
        return allocate.array();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.f8188a = byteBuffer.getInt();
        this.f8189b = byteBuffer.getShort();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return 6;
    }
}
