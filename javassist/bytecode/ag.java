package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2742a;

    public ag(int i, int i2) {
        super(i2);
        this.f2742a = i;
    }

    public ag(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2742a = dataInputStream.readInt();
    }

    public int hashCode() {
        return this.f2742a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ag) && ((ag) obj).f2742a == this.f2742a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 3;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.y(this.f2742a);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(3);
        dataOutputStream.writeInt(this.f2742a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("Integer ");
        printWriter.println(this.f2742a);
    }
}
