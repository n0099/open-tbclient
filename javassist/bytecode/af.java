package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends w {

    /* renamed from: a  reason: collision with root package name */
    float f2757a;

    public af(float f, int i) {
        super(i);
        this.f2757a = f;
    }

    public af(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2757a = dataInputStream.readFloat();
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2757a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof af) && ((af) obj).f2757a == this.f2757a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 4;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.a(this.f2757a);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(4);
        dataOutputStream.writeFloat(this.f2757a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("Float ");
        printWriter.println(this.f2757a);
    }
}
