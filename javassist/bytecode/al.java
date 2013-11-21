package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class al extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2746a;
    int c;

    protected abstract int a(y yVar, int i, int i2);

    public abstract String b();

    public al(int i, int i2, int i3) {
        super(i3);
        this.f2746a = i;
        this.c = i2;
    }

    public al(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2746a = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return (this.f2746a << 16) ^ this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof al) {
            al alVar = (al) obj;
            return alVar.f2746a == this.f2746a && alVar.c == this.c && alVar.getClass() == getClass();
        }
        return false;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return a(yVar2, yVar.b(this.f2746a).a(yVar, yVar2, map), yVar.b(this.c).a(yVar, yVar2, map));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(a());
        dataOutputStream.writeShort(this.f2746a);
        dataOutputStream.writeShort(this.c);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print(b() + " #");
        printWriter.print(this.f2746a);
        printWriter.print(", name&type #");
        printWriter.println(this.c);
    }
}
