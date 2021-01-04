package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes6.dex */
class h {
    static h qnI = new h();
    static h qnJ;
    static h qnK;
    int qnH;
    boolean qnz = true;
    boolean qnA = true;
    boolean qnB = false;
    boolean qnC = false;
    boolean qnD = false;
    boolean qnE = true;
    boolean qnF = true;
    boolean qnG = true;

    h() {
    }

    static {
        qnI.qnz = true;
        qnI.qnA = false;
        qnI.qnB = false;
        qnI.qnC = false;
        qnI.qnD = true;
        qnI.qnE = false;
        qnI.qnF = false;
        qnI.qnH = 0;
        qnJ = new h();
        qnJ.qnz = true;
        qnJ.qnA = true;
        qnJ.qnB = false;
        qnJ.qnC = false;
        qnJ.qnD = false;
        qnI.qnH = 1;
        qnK = new h();
        qnK.qnz = false;
        qnK.qnA = true;
        qnK.qnB = false;
        qnK.qnC = true;
        qnK.qnD = false;
        qnK.qnG = false;
        qnK.qnH = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String acp(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Tx(int i) {
        if (this.qnC) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String acq(String str) {
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
            return acq(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qnz);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qnD);
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
            if (!this.qnA) {
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
        if (this.qnB && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
