package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hJP = new h();
    static h hJQ;
    static h hJR;
    boolean hJG = true;
    boolean hJH = true;
    boolean hJI = false;
    boolean hJJ = false;
    boolean hJK = false;
    boolean hJL = true;
    boolean hJM = true;
    boolean hJN = true;
    int hJO;

    h() {
    }

    static {
        hJP.hJG = true;
        hJP.hJH = false;
        hJP.hJI = false;
        hJP.hJJ = false;
        hJP.hJK = true;
        hJP.hJL = false;
        hJP.hJM = false;
        hJP.hJO = 0;
        hJQ = new h();
        hJQ.hJG = true;
        hJQ.hJH = true;
        hJQ.hJI = false;
        hJQ.hJJ = false;
        hJQ.hJK = false;
        hJP.hJO = 1;
        hJR = new h();
        hJR.hJG = false;
        hJR.hJH = true;
        hJR.hJI = false;
        hJR.hJJ = true;
        hJR.hJK = false;
        hJR.hJN = false;
        hJR.hJO = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wK(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wg(int i) {
        if (this.hJJ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wL(String str) {
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
            return wL(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String v(Class cls) {
        return b(cls, cls.getName(), this.hJG);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hJK);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(v(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hJH) {
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
        if (this.hJI && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
