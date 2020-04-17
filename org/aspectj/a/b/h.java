package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nfQ = new h();
    static h nfR;
    static h nfS;
    boolean nfH = true;
    boolean nfI = true;
    boolean nfJ = false;
    boolean nfK = false;
    boolean nfL = false;
    boolean nfM = true;
    boolean nfN = true;
    boolean nfO = true;
    int nfP;

    h() {
    }

    static {
        nfQ.nfH = true;
        nfQ.nfI = false;
        nfQ.nfJ = false;
        nfQ.nfK = false;
        nfQ.nfL = true;
        nfQ.nfM = false;
        nfQ.nfN = false;
        nfQ.nfP = 0;
        nfR = new h();
        nfR.nfH = true;
        nfR.nfI = true;
        nfR.nfJ = false;
        nfR.nfK = false;
        nfR.nfL = false;
        nfQ.nfP = 1;
        nfS = new h();
        nfS.nfH = false;
        nfS.nfI = true;
        nfS.nfJ = false;
        nfS.nfK = true;
        nfS.nfL = false;
        nfS.nfO = false;
        nfS.nfP = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String PE(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ju(int i) {
        if (this.nfK) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String PF(String str) {
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
            return PF(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nfH);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nfL);
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
            if (!this.nfI) {
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
        if (this.nfJ && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
