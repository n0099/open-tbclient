package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2808a;

    public bm(int i, int i2) {
        super(i2);
        this.f2808a = i;
    }

    public bm(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2808a = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.f2808a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bm) && ((bm) obj).f2808a == this.f2808a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 8;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.b(yVar.w(this.f2808a));
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(8);
        dataOutputStream.writeShort(this.f2808a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("String #");
        printWriter.println(this.f2808a);
    }
}
