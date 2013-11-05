package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends w {
    public x(int i) {
        super(i);
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 0;
    }

    @Override // javassist.bytecode.w
    public int a(y yVar, y yVar2, Map map) {
        return yVar2.c();
    }

    @Override // javassist.bytecode.w
    public void a(DataOutputStream dataOutputStream) {
    }

    @Override // javassist.bytecode.w
    public void a(PrintWriter printWriter) {
        printWriter.println("padding");
    }
}
