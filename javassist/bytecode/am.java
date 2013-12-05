package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2928a;
    int c;

    public am(int i, int i2, int i3) {
        super(i3);
        this.f2928a = i;
        this.c = i2;
    }

    public am(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2928a = dataInputStream.readUnsignedByte();
        this.c = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return (this.f2928a << 16) ^ this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof am) {
            am amVar = (am) obj;
            return amVar.f2928a == this.f2928a && amVar.c == this.c;
        }
        return false;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 15;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.e(this.f2928a, yVar.b(this.c).a(yVar, yVar2, map));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(15);
        dataOutputStream.writeByte(this.f2928a);
        dataOutputStream.writeShort(this.c);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("MethodHandle #");
        printWriter.print(this.f2928a);
        printWriter.print(", index #");
        printWriter.println(this.c);
    }
}
