package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class EnclosingMethodAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EnclosingMethodAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public EnclosingMethodAttribute(y yVar, String str, String str2, String str3) {
        super(yVar, "EnclosingMethod");
        int a2 = yVar.a(str);
        int a3 = yVar.a(str2, str3);
        a(new byte[]{(byte) (a2 >>> 8), (byte) a2, (byte) (a3 >>> 8), (byte) a3});
    }

    public EnclosingMethodAttribute(y yVar, String str) {
        super(yVar, "EnclosingMethod");
        int a2 = yVar.a(str);
        a(new byte[]{(byte) (a2 >>> 8), (byte) a2, (byte) 0, (byte) 0});
    }

    public int a() {
        return g.a(e(), 0);
    }

    public int f() {
        return g.a(e(), 2);
    }

    public String g() {
        return c().d(a());
    }

    public String h() {
        y c = c();
        return c.w(c.f(f()));
    }

    public String i() {
        y c = c();
        return c.w(c.g(f()));
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return f() == 0 ? new EnclosingMethodAttribute(yVar, g()) : new EnclosingMethodAttribute(yVar, g(), h(), i());
    }
}
