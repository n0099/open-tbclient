package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
class h {
    static h qkP = new h();
    static h qkQ;
    static h qkR;
    boolean qkG = true;
    boolean qkH = true;
    boolean qkI = false;
    boolean qkJ = false;
    boolean qkK = false;
    boolean qkL = true;
    boolean qkM = true;
    boolean qkN = true;
    int qkO;

    h() {
    }

    static {
        qkP.qkG = true;
        qkP.qkH = false;
        qkP.qkI = false;
        qkP.qkJ = false;
        qkP.qkK = true;
        qkP.qkL = false;
        qkP.qkM = false;
        qkP.qkO = 0;
        qkQ = new h();
        qkQ.qkG = true;
        qkQ.qkH = true;
        qkQ.qkI = false;
        qkQ.qkJ = false;
        qkQ.qkK = false;
        qkP.qkO = 1;
        qkR = new h();
        qkR.qkG = false;
        qkR.qkH = true;
        qkR.qkI = false;
        qkR.qkJ = true;
        qkR.qkK = false;
        qkR.qkN = false;
        qkR.qkO = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String abj(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sg(int i) {
        if (this.qkJ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String abk(String str) {
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
            return abk(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qkG);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qkK);
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
            if (!this.qkH) {
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
        if (this.qkI && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
