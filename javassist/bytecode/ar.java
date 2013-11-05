package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2745a;
    int c;

    public ar(int i, int i2, int i3) {
        super(i3);
        this.f2745a = i;
        this.c = i2;
    }

    public ar(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2745a = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return (this.f2745a << 16) ^ this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ar) {
            ar arVar = (ar) obj;
            return arVar.f2745a == this.f2745a && arVar.c == this.c;
        }
        return false;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 12;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.a(yVar2.c(yVar.w(this.f2745a)), yVar2.c(z.a(yVar.w(this.c), map)));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(12);
        dataOutputStream.writeShort(this.f2745a);
        dataOutputStream.writeShort(this.c);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("NameAndType #");
        printWriter.print(this.f2745a);
        printWriter.print(", type #");
        printWriter.println(this.c);
    }
}
