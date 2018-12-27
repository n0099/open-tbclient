package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iCM = new h();
    static h iCN;
    static h iCO;
    boolean iCD = true;
    boolean iCE = true;
    boolean iCF = false;
    boolean iCG = false;
    boolean iCH = false;
    boolean iCI = true;
    boolean iCJ = true;
    boolean iCK = true;
    int iCL;

    h() {
    }

    static {
        iCM.iCD = true;
        iCM.iCE = false;
        iCM.iCF = false;
        iCM.iCG = false;
        iCM.iCH = true;
        iCM.iCI = false;
        iCM.iCJ = false;
        iCM.iCL = 0;
        iCN = new h();
        iCN.iCD = true;
        iCN.iCE = true;
        iCN.iCF = false;
        iCN.iCG = false;
        iCN.iCH = false;
        iCM.iCL = 1;
        iCO = new h();
        iCO.iCD = false;
        iCO.iCE = true;
        iCO.iCF = false;
        iCO.iCG = true;
        iCO.iCH = false;
        iCO.iCK = false;
        iCO.iCL = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zI(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zx(int i) {
        if (this.iCG) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String zJ(String str) {
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
            return zJ(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.iCD);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.iCH);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(E(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.iCE) {
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
        if (this.iCF && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
