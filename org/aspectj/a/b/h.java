package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nAU = new h();
    static h nAV;
    static h nAW;
    boolean nAL = true;
    boolean nAM = true;
    boolean nAN = false;
    boolean nAO = false;
    boolean nAP = false;
    boolean nAQ = true;
    boolean nAR = true;
    boolean nAS = true;
    int nAT;

    h() {
    }

    static {
        nAU.nAL = true;
        nAU.nAM = false;
        nAU.nAN = false;
        nAU.nAO = false;
        nAU.nAP = true;
        nAU.nAQ = false;
        nAU.nAR = false;
        nAU.nAT = 0;
        nAV = new h();
        nAV.nAL = true;
        nAV.nAM = true;
        nAV.nAN = false;
        nAV.nAO = false;
        nAV.nAP = false;
        nAU.nAT = 1;
        nAW = new h();
        nAW.nAL = false;
        nAW.nAM = true;
        nAW.nAN = false;
        nAW.nAO = true;
        nAW.nAP = false;
        nAW.nAS = false;
        nAW.nAT = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String RN(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Kf(int i) {
        if (this.nAO) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String RO(String str) {
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
            return RO(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nAL);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nAP);
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
            if (!this.nAM) {
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
        if (this.nAN && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
