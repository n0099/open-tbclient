package javassist;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.security.ProtectionDomain;
/* loaded from: classes.dex */
public abstract class h {
    public static h e;
    public static h f;
    public static h g;
    public static h h;
    public static h i;
    public static h j;
    public static h k;
    public static h l;
    protected String b;
    public static String c = null;
    static h[] m = new h[9];
    public static h d = new CtPrimitiveType("boolean", 'Z', "java.lang.Boolean", "booleanValue", "()Z", 172, 4, 1);

    static {
        m[0] = d;
        e = new CtPrimitiveType("char", 'C', "java.lang.Character", "charValue", "()C", 172, 5, 1);
        m[1] = e;
        f = new CtPrimitiveType("byte", 'B', "java.lang.Byte", "byteValue", "()B", 172, 8, 1);
        m[2] = f;
        g = new CtPrimitiveType("short", 'S', "java.lang.Short", "shortValue", "()S", 172, 9, 1);
        m[3] = g;
        h = new CtPrimitiveType("int", 'I', "java.lang.Integer", "intValue", "()I", 172, 10, 1);
        m[4] = h;
        i = new CtPrimitiveType("long", 'J', "java.lang.Long", "longValue", "()J", 173, 11, 2);
        m[5] = i;
        j = new CtPrimitiveType("float", 'F', "java.lang.Float", "floatValue", "()F", 174, 6, 1);
        m[6] = j;
        k = new CtPrimitiveType("double", 'D', "java.lang.Double", "doubleValue", "()D", 175, 7, 2);
        m[7] = k;
        l = new CtPrimitiveType("void", 'V', "java.lang.Void", null, null, 177, 0, 0);
        m[8] = l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(String str) {
        this.b = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(Integer.toHexString(hashCode()));
        stringBuffer.append("[");
        a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(n());
    }

    public c a() {
        return null;
    }

    public javassist.bytecode.i g() {
        l();
        return h();
    }

    public javassist.bytecode.i h() {
        return null;
    }

    public javassist.compiler.a i() {
        return null;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        if (k()) {
            throw new RuntimeException(n() + " class is frozen");
        }
    }

    public boolean m() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public h e() {
        return null;
    }

    public boolean a(h hVar) {
        return this == hVar || n().equals(hVar.n());
    }

    public String n() {
        return this.b;
    }

    public final String o() {
        String str = this.b;
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public final String p() {
        String str = this.b;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public boolean q() {
        return false;
    }

    public int c() {
        return 0;
    }

    public void a(int i2) {
        l();
    }

    public boolean b(h hVar) {
        return false;
    }

    public h f() {
        return null;
    }

    public void c(h hVar) {
        l();
    }

    public h[] d() {
        return new h[0];
    }

    public void d(h hVar) {
        l();
    }

    public h r() {
        return null;
    }

    public CtField a(String str) {
        return b(str, null);
    }

    public CtField b(String str, String str2) {
        throw new NotFoundException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CtField c(String str, String str2) {
        return null;
    }

    public CtConstructor[] s() {
        return new CtConstructor[0];
    }

    public CtMethod a(String str, String str2) {
        throw new NotFoundException(str);
    }

    public CtMethod b(String str) {
        throw new NotFoundException(str);
    }

    public void a(CtConstructor ctConstructor) {
        l();
    }

    public void a(CtMethod ctMethod) {
        l();
    }

    public void a(CodeConverter codeConverter) {
        l();
    }

    public Class a(ClassLoader classLoader, ProtectionDomain protectionDomain) {
        c a2 = a();
        if (classLoader == null) {
            classLoader = a2.f();
        }
        return a2.a(this, classLoader, protectionDomain);
    }

    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }

    public void v() {
    }

    public byte[] w() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            a(dataOutputStream);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            dataOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataOutputStream c(String str) {
        String str2 = str + File.separatorChar + n().replace('.', File.separatorChar) + ".class";
        int lastIndexOf = str2.lastIndexOf(File.separatorChar);
        if (lastIndexOf > 0) {
            String substring = str2.substring(0, lastIndexOf);
            if (!substring.equals(".")) {
                new File(substring).mkdirs();
            }
        }
        return new DataOutputStream(new BufferedOutputStream(new i(str2)));
    }

    public void a(DataOutputStream dataOutputStream) {
        throw new CannotCompileException("not a class");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
    }
}
