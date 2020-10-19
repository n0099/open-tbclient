package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h oZL = new h();
    static h oZM;
    static h oZN;
    boolean oZC = true;
    boolean oZD = true;
    boolean oZE = false;
    boolean oZF = false;
    boolean oZG = false;
    boolean oZH = true;
    boolean oZI = true;
    boolean oZJ = true;
    int oZK;

    h() {
    }

    static {
        oZL.oZC = true;
        oZL.oZD = false;
        oZL.oZE = false;
        oZL.oZF = false;
        oZL.oZG = true;
        oZL.oZH = false;
        oZL.oZI = false;
        oZL.oZK = 0;
        oZM = new h();
        oZM.oZC = true;
        oZM.oZD = true;
        oZM.oZE = false;
        oZM.oZF = false;
        oZM.oZG = false;
        oZL.oZK = 1;
        oZN = new h();
        oZN.oZC = false;
        oZN.oZD = true;
        oZN.oZE = false;
        oZN.oZF = true;
        oZN.oZG = false;
        oZN.oZJ = false;
        oZN.oZK = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String XG(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Pw(int i) {
        if (this.oZF) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String XH(String str) {
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
            return XH(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.oZC);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.oZG);
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
            if (!this.oZD) {
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
        if (this.oZE && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
