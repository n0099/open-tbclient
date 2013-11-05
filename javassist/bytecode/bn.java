package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends w {

    /* renamed from: a  reason: collision with root package name */
    String f2761a;

    public bn(String str, int i) {
        super(i);
        this.f2761a = str;
    }

    public bn(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2761a = dataInputStream.readUTF();
    }

    public int hashCode() {
        return this.f2761a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof bn) && ((bn) obj).f2761a.equals(this.f2761a);
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 1;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.c(this.f2761a);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(1);
        dataOutputStream.writeUTF(this.f2761a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("UTF8 \"");
        printWriter.print(this.f2761a);
        printWriter.println("\"");
    }
}
