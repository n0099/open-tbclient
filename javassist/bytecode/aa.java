package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends w {

    /* renamed from: a  reason: collision with root package name */
    double f2705a;

    public aa(double d, int i) {
        super(i);
        this.f2705a = d;
    }

    public aa(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2705a = dataInputStream.readDouble();
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f2705a);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof aa) && ((aa) obj).f2705a == this.f2705a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 6;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.a(this.f2705a);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(6);
        dataOutputStream.writeDouble(this.f2705a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("Double ");
        printWriter.println(this.f2705a);
    }
}
