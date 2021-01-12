package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
class h {
    static h qkO = new h();
    static h qkP;
    static h qkQ;
    boolean qkF = true;
    boolean qkG = true;
    boolean qkH = false;
    boolean qkI = false;
    boolean qkJ = false;
    boolean qkK = true;
    boolean qkL = true;
    boolean qkM = true;
    int qkN;

    h() {
    }

    static {
        qkO.qkF = true;
        qkO.qkG = false;
        qkO.qkH = false;
        qkO.qkI = false;
        qkO.qkJ = true;
        qkO.qkK = false;
        qkO.qkL = false;
        qkO.qkN = 0;
        qkP = new h();
        qkP.qkF = true;
        qkP.qkG = true;
        qkP.qkH = false;
        qkP.qkI = false;
        qkP.qkJ = false;
        qkO.qkN = 1;
        qkQ = new h();
        qkQ.qkF = false;
        qkQ.qkG = true;
        qkQ.qkH = false;
        qkQ.qkI = true;
        qkQ.qkJ = false;
        qkQ.qkM = false;
        qkQ.qkN = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String abi(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sg(int i) {
        if (this.qkI) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String abj(String str) {
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
            return abj(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qkF);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qkJ);
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
            if (!this.qkG) {
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
        if (this.qkH && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
