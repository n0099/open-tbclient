package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2743a;
    int c;

    public ai(int i, int i2, int i3) {
        super(i3);
        this.f2743a = i;
        this.c = i2;
    }

    public ai(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2743a = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return (this.f2743a << 16) ^ this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ai) {
            ai aiVar = (ai) obj;
            return aiVar.f2743a == this.f2743a && aiVar.c == this.c;
        }
        return false;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 18;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.f(this.f2743a, yVar.b(this.c).a(yVar, yVar2, map));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(18);
        dataOutputStream.writeShort(this.f2743a);
        dataOutputStream.writeShort(this.c);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("InvokeDynamic #");
        printWriter.print(this.f2743a);
        printWriter.print(", name&type #");
        printWriter.println(this.c);
    }
}
