package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nXP = new h();
    static h nXQ;
    static h nXR;
    boolean nXG = true;
    boolean nXH = true;
    boolean nXI = false;
    boolean nXJ = false;
    boolean nXK = false;
    boolean nXL = true;
    boolean nXM = true;
    boolean nXN = true;
    int nXO;

    h() {
    }

    static {
        nXP.nXG = true;
        nXP.nXH = false;
        nXP.nXI = false;
        nXP.nXJ = false;
        nXP.nXK = true;
        nXP.nXL = false;
        nXP.nXM = false;
        nXP.nXO = 0;
        nXQ = new h();
        nXQ.nXG = true;
        nXQ.nXH = true;
        nXQ.nXI = false;
        nXQ.nXJ = false;
        nXQ.nXK = false;
        nXP.nXO = 1;
        nXR = new h();
        nXR.nXG = false;
        nXR.nXH = true;
        nXR.nXI = false;
        nXR.nXJ = true;
        nXR.nXK = false;
        nXR.nXN = false;
        nXR.nXO = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String SA(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Lo(int i) {
        if (this.nXJ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String SB(String str) {
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
            return SB(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nXG);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nXK);
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
            if (!this.nXH) {
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
        if (this.nXI && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
