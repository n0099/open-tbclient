package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h pRg = new h();
    static h pRh;
    static h pRi;
    boolean pQX = true;
    boolean pQY = true;
    boolean pQZ = false;
    boolean pRa = false;
    boolean pRb = false;
    boolean pRc = true;
    boolean pRd = true;
    boolean pRe = true;
    int pRf;

    h() {
    }

    static {
        pRg.pQX = true;
        pRg.pQY = false;
        pRg.pQZ = false;
        pRg.pRa = false;
        pRg.pRb = true;
        pRg.pRc = false;
        pRg.pRd = false;
        pRg.pRf = 0;
        pRh = new h();
        pRh.pQX = true;
        pRh.pQY = true;
        pRh.pQZ = false;
        pRh.pRa = false;
        pRh.pRb = false;
        pRg.pRf = 1;
        pRi = new h();
        pRi.pQX = false;
        pRi.pQY = true;
        pRi.pQZ = false;
        pRi.pRa = true;
        pRi.pRb = false;
        pRi.pRe = false;
        pRi.pRf = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Zt(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Rn(int i) {
        if (this.pRa) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Zu(String str) {
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
            return Zu(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.pQX);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.pRb);
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
            if (!this.pQY) {
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
        if (this.pQZ && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
