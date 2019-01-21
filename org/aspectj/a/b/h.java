package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iDU = new h();
    static h iDV;
    static h iDW;
    boolean iDL = true;
    boolean iDM = true;
    boolean iDN = false;
    boolean iDO = false;
    boolean iDP = false;
    boolean iDQ = true;
    boolean iDR = true;
    boolean iDS = true;
    int iDT;

    h() {
    }

    static {
        iDU.iDL = true;
        iDU.iDM = false;
        iDU.iDN = false;
        iDU.iDO = false;
        iDU.iDP = true;
        iDU.iDQ = false;
        iDU.iDR = false;
        iDU.iDT = 0;
        iDV = new h();
        iDV.iDL = true;
        iDV.iDM = true;
        iDV.iDN = false;
        iDV.iDO = false;
        iDV.iDP = false;
        iDU.iDT = 1;
        iDW = new h();
        iDW.iDL = false;
        iDW.iDM = true;
        iDW.iDN = false;
        iDW.iDO = true;
        iDW.iDP = false;
        iDW.iDS = false;
        iDW.iDT = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zY(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.iDO) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String zZ(String str) {
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
            return zZ(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.iDL);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.iDP);
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
            if (!this.iDM) {
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
        if (this.iDN && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
