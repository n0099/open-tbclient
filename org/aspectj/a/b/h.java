package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes11.dex */
class h {
    static h qcd = new h();
    static h qce;
    static h qcf;
    boolean qbU = true;
    boolean qbV = true;
    boolean qbW = false;
    boolean qbX = false;
    boolean qbY = false;
    boolean qbZ = true;
    boolean qca = true;
    boolean qcb = true;
    int qcc;

    h() {
    }

    static {
        qcd.qbU = true;
        qcd.qbV = false;
        qcd.qbW = false;
        qcd.qbX = false;
        qcd.qbY = true;
        qcd.qbZ = false;
        qcd.qca = false;
        qcd.qcc = 0;
        qce = new h();
        qce.qbU = true;
        qce.qbV = true;
        qce.qbW = false;
        qce.qbX = false;
        qce.qbY = false;
        qcd.qcc = 1;
        qcf = new h();
        qcf.qbU = false;
        qcf.qbV = true;
        qcf.qbW = false;
        qcf.qbX = true;
        qcf.qbY = false;
        qcf.qcb = false;
        qcf.qcc = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ZI(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sl(int i) {
        if (this.qbX) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String ZJ(String str) {
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
            return ZJ(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.qbU);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.qbY);
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
            if (!this.qbV) {
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
        if (this.qbW && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
