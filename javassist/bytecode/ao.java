package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2791a;

    public ao(int i, int i2) {
        super(i2);
        this.f2791a = i;
    }

    public ao(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2791a = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.f2791a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ao) && ((ao) obj).f2791a == this.f2791a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 16;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.z(yVar2.c(z.a(yVar.w(this.f2791a), map)));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(16);
        dataOutputStream.writeShort(this.f2791a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("MethodType #");
        printWriter.println(this.f2791a);
    }
}
