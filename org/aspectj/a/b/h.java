package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
class h {
    static h qvU = new h();
    static h qvV;
    static h qvW;
    boolean qvL = true;
    boolean qvM = true;
    boolean qvN = false;
    boolean qvO = false;
    boolean qvP = false;
    boolean qvQ = true;
    boolean qvR = true;
    boolean qvS = true;
    int qvT;

    h() {
    }

    static {
        qvU.qvL = true;
        qvU.qvM = false;
        qvU.qvN = false;
        qvU.qvO = false;
        qvU.qvP = true;
        qvU.qvQ = false;
        qvU.qvR = false;
        qvU.qvT = 0;
        qvV = new h();
        qvV.qvL = true;
        qvV.qvM = true;
        qvV.qvN = false;
        qvV.qvO = false;
        qvV.qvP = false;
        qvU.qvT = 1;
        qvW = new h();
        qvW.qvL = false;
        qvW.qvM = true;
        qvW.qvN = false;
        qvW.qvO = true;
        qvW.qvP = false;
        qvW.qvS = false;
        qvW.qvT = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String acv(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String SB(int i) {
        if (this.qvO) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String acw(String str) {
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
            return acw(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qvL);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qvP);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(H(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.qvM) {
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
        if (this.qvN && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
