package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nXS = new h();
    static h nXT;
    static h nXU;
    boolean nXJ = true;
    boolean nXK = true;
    boolean nXL = false;
    boolean nXM = false;
    boolean nXN = false;
    boolean nXO = true;
    boolean nXP = true;
    boolean nXQ = true;
    int nXR;

    h() {
    }

    static {
        nXS.nXJ = true;
        nXS.nXK = false;
        nXS.nXL = false;
        nXS.nXM = false;
        nXS.nXN = true;
        nXS.nXO = false;
        nXS.nXP = false;
        nXS.nXR = 0;
        nXT = new h();
        nXT.nXJ = true;
        nXT.nXK = true;
        nXT.nXL = false;
        nXT.nXM = false;
        nXT.nXN = false;
        nXS.nXR = 1;
        nXU = new h();
        nXU.nXJ = false;
        nXU.nXK = true;
        nXU.nXL = false;
        nXU.nXM = true;
        nXU.nXN = false;
        nXU.nXQ = false;
        nXU.nXR = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String SB(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Lo(int i) {
        if (this.nXM) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String SC(String str) {
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
            return SC(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nXJ);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nXN);
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
            if (!this.nXK) {
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
        if (this.nXL && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
