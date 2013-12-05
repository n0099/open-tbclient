package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends w {

    /* renamed from: a  reason: collision with root package name */
    int f2980a;

    public j(int i, int i2) {
        super(i2);
        this.f2980a = i;
    }

    public j(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2980a = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.f2980a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && ((j) obj).f2980a == this.f2980a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 7;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        String str;
        String w = yVar.w(this.f2980a);
        if (map == null || (str = (String) map.get(w)) == null) {
            str = w;
        }
        return yVar2.a(str);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(7);
        dataOutputStream.writeShort(this.f2980a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("Class #");
        printWriter.println(this.f2980a);
    }
}
