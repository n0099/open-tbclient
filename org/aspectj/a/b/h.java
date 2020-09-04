package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes10.dex */
class h {
    static h oAS = new h();
    static h oAT;
    static h oAU;
    boolean oAJ = true;
    boolean oAK = true;
    boolean oAL = false;
    boolean oAM = false;
    boolean oAN = false;
    boolean oAO = true;
    boolean oAP = true;
    boolean oAQ = true;
    int oAR;

    h() {
    }

    static {
        oAS.oAJ = true;
        oAS.oAK = false;
        oAS.oAL = false;
        oAS.oAM = false;
        oAS.oAN = true;
        oAS.oAO = false;
        oAS.oAP = false;
        oAS.oAR = 0;
        oAT = new h();
        oAT.oAJ = true;
        oAT.oAK = true;
        oAT.oAL = false;
        oAT.oAM = false;
        oAT.oAN = false;
        oAS.oAR = 1;
        oAU = new h();
        oAU.oAJ = false;
        oAU.oAK = true;
        oAU.oAL = false;
        oAU.oAM = true;
        oAU.oAN = false;
        oAU.oAQ = false;
        oAU.oAR = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Wq(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ol(int i) {
        if (this.oAM) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Wr(String str) {
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
            return Wr(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.oAJ);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.oAN);
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
            if (!this.oAK) {
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
        if (this.oAL && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
