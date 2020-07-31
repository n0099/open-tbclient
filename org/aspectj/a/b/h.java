package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes20.dex */
class h {
    static h ogC = new h();
    static h ogD;
    static h ogE;
    int ogB;
    boolean ogt = true;
    boolean ogu = true;
    boolean ogv = false;
    boolean ogw = false;
    boolean ogx = false;
    boolean ogy = true;
    boolean ogz = true;
    boolean ogA = true;

    h() {
    }

    static {
        ogC.ogt = true;
        ogC.ogu = false;
        ogC.ogv = false;
        ogC.ogw = false;
        ogC.ogx = true;
        ogC.ogy = false;
        ogC.ogz = false;
        ogC.ogB = 0;
        ogD = new h();
        ogD.ogt = true;
        ogD.ogu = true;
        ogD.ogv = false;
        ogD.ogw = false;
        ogD.ogx = false;
        ogC.ogB = 1;
        ogE = new h();
        ogE.ogt = false;
        ogE.ogu = true;
        ogE.ogv = false;
        ogE.ogw = true;
        ogE.ogx = false;
        ogE.ogA = false;
        ogE.ogB = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Tm(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String LI(int i) {
        if (this.ogw) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Tn(String str) {
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
            return Tn(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.ogt);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.ogx);
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
            if (!this.ogu) {
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
        if (this.ogv && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
