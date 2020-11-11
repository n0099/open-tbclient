package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h qaA = new h();
    static h qaB;
    static h qaC;
    boolean qar = true;
    boolean qas = true;
    boolean qat = false;
    boolean qau = false;
    boolean qav = false;
    boolean qaw = true;
    boolean qax = true;
    boolean qay = true;
    int qaz;

    h() {
    }

    static {
        qaA.qar = true;
        qaA.qas = false;
        qaA.qat = false;
        qaA.qau = false;
        qaA.qav = true;
        qaA.qaw = false;
        qaA.qax = false;
        qaA.qaz = 0;
        qaB = new h();
        qaB.qar = true;
        qaB.qas = true;
        qaB.qat = false;
        qaB.qau = false;
        qaB.qav = false;
        qaA.qaz = 1;
        qaC = new h();
        qaC.qar = false;
        qaC.qas = true;
        qaC.qat = false;
        qaC.qau = true;
        qaC.qav = false;
        qaC.qay = false;
        qaC.qaz = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ZX(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String RI(int i) {
        if (this.qau) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String ZY(String str) {
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
            return ZY(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.qar);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.qav);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(N(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.qas) {
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
        if (this.qat && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
