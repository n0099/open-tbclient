package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes20.dex */
class h {
    static h ogE = new h();
    static h ogF;
    static h ogG;
    int ogD;
    boolean ogv = true;
    boolean ogw = true;
    boolean ogx = false;
    boolean ogy = false;
    boolean ogz = false;
    boolean ogA = true;
    boolean ogB = true;
    boolean ogC = true;

    h() {
    }

    static {
        ogE.ogv = true;
        ogE.ogw = false;
        ogE.ogx = false;
        ogE.ogy = false;
        ogE.ogz = true;
        ogE.ogA = false;
        ogE.ogB = false;
        ogE.ogD = 0;
        ogF = new h();
        ogF.ogv = true;
        ogF.ogw = true;
        ogF.ogx = false;
        ogF.ogy = false;
        ogF.ogz = false;
        ogE.ogD = 1;
        ogG = new h();
        ogG.ogv = false;
        ogG.ogw = true;
        ogG.ogx = false;
        ogG.ogy = true;
        ogG.ogz = false;
        ogG.ogC = false;
        ogG.ogD = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Tm(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String LI(int i) {
        if (this.ogy) {
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
        return b(cls, cls.getName(), this.ogv);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.ogz);
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
            if (!this.ogw) {
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
        if (this.ogx && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
