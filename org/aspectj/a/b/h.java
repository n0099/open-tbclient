package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes16.dex */
class h {
    static h pMd = new h();
    static h pMe;
    static h pMf;
    boolean pLU = true;
    boolean pLV = true;
    boolean pLW = false;
    boolean pLX = false;
    boolean pLY = false;
    boolean pLZ = true;
    boolean pMa = true;
    boolean pMb = true;
    int pMc;

    h() {
    }

    static {
        pMd.pLU = true;
        pMd.pLV = false;
        pMd.pLW = false;
        pMd.pLX = false;
        pMd.pLY = true;
        pMd.pLZ = false;
        pMd.pMa = false;
        pMd.pMc = 0;
        pMe = new h();
        pMe.pLU = true;
        pMe.pLV = true;
        pMe.pLW = false;
        pMe.pLX = false;
        pMe.pLY = false;
        pMd.pMc = 1;
        pMf = new h();
        pMf.pLU = false;
        pMf.pLV = true;
        pMf.pLW = false;
        pMf.pLX = true;
        pMf.pLY = false;
        pMf.pMb = false;
        pMf.pMc = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aav(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Se(int i) {
        if (this.pLX) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String aaw(String str) {
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
            return aaw(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.pLU);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.pLY);
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
            if (!this.pLV) {
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
        if (this.pLW && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
