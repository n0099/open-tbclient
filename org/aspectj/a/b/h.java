package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hKA;
    static h hKB;
    static h hKz = new h();
    boolean hKq = true;
    boolean hKr = true;
    boolean hKs = false;
    boolean hKt = false;
    boolean hKu = false;
    boolean hKv = true;
    boolean hKw = true;
    boolean hKx = true;
    int hKy;

    h() {
    }

    static {
        hKz.hKq = true;
        hKz.hKr = false;
        hKz.hKs = false;
        hKz.hKt = false;
        hKz.hKu = true;
        hKz.hKv = false;
        hKz.hKw = false;
        hKz.hKy = 0;
        hKA = new h();
        hKA.hKq = true;
        hKA.hKr = true;
        hKA.hKs = false;
        hKA.hKt = false;
        hKA.hKu = false;
        hKz.hKy = 1;
        hKB = new h();
        hKB.hKq = false;
        hKB.hKr = true;
        hKB.hKs = false;
        hKB.hKt = true;
        hKB.hKu = false;
        hKB.hKx = false;
        hKB.hKy = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wW(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xR(int i) {
        if (this.hKt) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wX(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    String b(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            return new StringBuffer().append(b(componentType, componentType.getName(), z)).append("[]").toString();
        } else if (z) {
            return wX(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hKq);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hKu);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(o(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hKr) {
                if (clsArr.length == 0) {
                    stringBuffer.append("()");
                    return;
                } else {
                    stringBuffer.append("(..)");
                    return;
                }
            }
            stringBuffer.append("(");
            a(stringBuffer, clsArr);
            stringBuffer.append(")");
        }
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.hKs && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
