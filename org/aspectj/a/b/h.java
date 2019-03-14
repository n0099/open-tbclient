package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h jTQ = new h();
    static h jTR;
    static h jTS;
    boolean jTH = true;
    boolean jTI = true;
    boolean jTJ = false;
    boolean jTK = false;
    boolean jTL = false;
    boolean jTM = true;
    boolean jTN = true;
    boolean jTO = true;
    int jTP;

    h() {
    }

    static {
        jTQ.jTH = true;
        jTQ.jTI = false;
        jTQ.jTJ = false;
        jTQ.jTK = false;
        jTQ.jTL = true;
        jTQ.jTM = false;
        jTQ.jTN = false;
        jTQ.jTP = 0;
        jTR = new h();
        jTR.jTH = true;
        jTR.jTI = true;
        jTR.jTJ = false;
        jTR.jTK = false;
        jTR.jTL = false;
        jTQ.jTP = 1;
        jTS = new h();
        jTS.jTH = false;
        jTS.jTI = true;
        jTS.jTJ = false;
        jTS.jTK = true;
        jTS.jTL = false;
        jTS.jTO = false;
        jTS.jTP = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Gc(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Dm(int i) {
        if (this.jTK) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Gd(String str) {
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
            return Gd(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.jTH);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.jTL);
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
            if (!this.jTI) {
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
        if (this.jTJ && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
