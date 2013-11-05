package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2715a;
    int c;

    public am(int i, int i2, int i3) {
        super(i3);
        this.f2715a = i;
        this.c = i2;
    }

    public am(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2715a = dataInputStream.readUnsignedByte();
        this.c = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return (this.f2715a << 16) ^ this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof am) {
            am amVar = (am) obj;
            return amVar.f2715a == this.f2715a && amVar.c == this.c;
        }
        return false;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 15;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.e(this.f2715a, yVar.b(this.c).a(yVar, yVar2, map));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(15);
        dataOutputStream.writeByte(this.f2715a);
        dataOutputStream.writeShort(this.c);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("MethodHandle #");
        printWriter.print(this.f2715a);
        printWriter.print(", index #");
        printWriter.println(this.c);
    }
}
