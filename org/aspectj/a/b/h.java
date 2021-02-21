package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h qvs = new h();
    static h qvt;
    static h qvu;
    boolean qvj = true;
    boolean qvk = true;
    boolean qvl = false;
    boolean qvm = false;
    boolean qvn = false;
    boolean qvo = true;
    boolean qvp = true;
    boolean qvq = true;
    int qvr;

    h() {
    }

    static {
        qvs.qvj = true;
        qvs.qvk = false;
        qvs.qvl = false;
        qvs.qvm = false;
        qvs.qvn = true;
        qvs.qvo = false;
        qvs.qvp = false;
        qvs.qvr = 0;
        qvt = new h();
        qvt.qvj = true;
        qvt.qvk = true;
        qvt.qvl = false;
        qvt.qvm = false;
        qvt.qvn = false;
        qvs.qvr = 1;
        qvu = new h();
        qvu.qvj = false;
        qvu.qvk = true;
        qvu.qvl = false;
        qvu.qvm = true;
        qvu.qvn = false;
        qvu.qvq = false;
        qvu.qvr = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String acw(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String SC(int i) {
        if (this.qvm) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String acx(String str) {
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
            return acx(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qvj);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qvn);
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
            if (!this.qvk) {
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
        if (this.qvl && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
