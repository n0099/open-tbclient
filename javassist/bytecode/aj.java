package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends w {

    /* renamed from: a  reason: collision with root package name */
    long f2744a;

    public aj(long j, int i) {
        super(i);
        this.f2744a = j;
    }

    public aj(DataInputStream dataInputStream, int i) {
        super(i);
        this.f2744a = dataInputStream.readLong();
    }

    public int hashCode() {
        return (int) (this.f2744a ^ (this.f2744a >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof aj) && ((aj) obj).f2744a == this.f2744a;
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 5;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.a(this.f2744a);
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(5);
        dataOutputStream.writeLong(this.f2744a);
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.print("Long ");
        printWriter.println(this.f2744a);
    }
}
