package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iDT = new h();
    static h iDU;
    static h iDV;
    boolean iDK = true;
    boolean iDL = true;
    boolean iDM = false;
    boolean iDN = false;
    boolean iDO = false;
    boolean iDP = true;
    boolean iDQ = true;
    boolean iDR = true;
    int iDS;

    h() {
    }

    static {
        iDT.iDK = true;
        iDT.iDL = false;
        iDT.iDM = false;
        iDT.iDN = false;
        iDT.iDO = true;
        iDT.iDP = false;
        iDT.iDQ = false;
        iDT.iDS = 0;
        iDU = new h();
        iDU.iDK = true;
        iDU.iDL = true;
        iDU.iDM = false;
        iDU.iDN = false;
        iDU.iDO = false;
        iDT.iDS = 1;
        iDV = new h();
        iDV.iDK = false;
        iDV.iDL = true;
        iDV.iDM = false;
        iDV.iDN = true;
        iDV.iDO = false;
        iDV.iDR = false;
        iDV.iDS = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zY(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.iDN) {
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
        return b(cls, cls.getName(), this.iDK);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.iDO);
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
            if (!this.iDL) {
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
        if (this.iDM && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
