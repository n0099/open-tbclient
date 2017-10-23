package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hnW = new h();
    static h hnX;
    static h hnY;
    boolean hnN = true;
    boolean hnO = true;
    boolean hnP = false;
    boolean hnQ = false;
    boolean hnR = false;
    boolean hnS = true;
    boolean hnT = true;
    boolean hnU = true;
    int hnV;

    h() {
    }

    static {
        hnW.hnN = true;
        hnW.hnO = false;
        hnW.hnP = false;
        hnW.hnQ = false;
        hnW.hnR = true;
        hnW.hnS = false;
        hnW.hnT = false;
        hnW.hnV = 0;
        hnX = new h();
        hnX.hnN = true;
        hnX.hnO = true;
        hnX.hnP = false;
        hnX.hnQ = false;
        hnX.hnR = false;
        hnW.hnV = 1;
        hnY = new h();
        hnY.hnN = false;
        hnY.hnO = true;
        hnY.hnP = false;
        hnY.hnQ = true;
        hnY.hnR = false;
        hnY.hnU = false;
        hnY.hnV = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String vv(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wS(int i) {
        if (this.hnQ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String vw(String str) {
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
            return vw(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hnN);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hnR);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(o(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hnO) {
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
        if (this.hnP && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
