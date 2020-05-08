package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nfT = new h();
    static h nfU;
    static h nfV;
    boolean nfK = true;
    boolean nfL = true;
    boolean nfM = false;
    boolean nfN = false;
    boolean nfO = false;
    boolean nfP = true;
    boolean nfQ = true;
    boolean nfR = true;
    int nfS;

    h() {
    }

    static {
        nfT.nfK = true;
        nfT.nfL = false;
        nfT.nfM = false;
        nfT.nfN = false;
        nfT.nfO = true;
        nfT.nfP = false;
        nfT.nfQ = false;
        nfT.nfS = 0;
        nfU = new h();
        nfU.nfK = true;
        nfU.nfL = true;
        nfU.nfM = false;
        nfU.nfN = false;
        nfU.nfO = false;
        nfT.nfS = 1;
        nfV = new h();
        nfV.nfK = false;
        nfV.nfL = true;
        nfV.nfM = false;
        nfV.nfN = true;
        nfV.nfO = false;
        nfV.nfR = false;
        nfV.nfS = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String PH(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ju(int i) {
        if (this.nfN) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String PI(String str) {
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
            return PI(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nfK);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nfO);
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
            if (!this.nfL) {
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
        if (this.nfM && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
