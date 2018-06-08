package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hPp = new h();
    static h hPq;
    static h hPr;
    boolean hPg = true;
    boolean hPh = true;
    boolean hPi = false;
    boolean hPj = false;
    boolean hPk = false;
    boolean hPl = true;
    boolean hPm = true;
    boolean hPn = true;
    int hPo;

    h() {
    }

    static {
        hPp.hPg = true;
        hPp.hPh = false;
        hPp.hPi = false;
        hPp.hPj = false;
        hPp.hPk = true;
        hPp.hPl = false;
        hPp.hPm = false;
        hPp.hPo = 0;
        hPq = new h();
        hPq.hPg = true;
        hPq.hPh = true;
        hPq.hPi = false;
        hPq.hPj = false;
        hPq.hPk = false;
        hPp.hPo = 1;
        hPr = new h();
        hPr.hPg = false;
        hPr.hPh = true;
        hPr.hPi = false;
        hPr.hPj = true;
        hPr.hPk = false;
        hPr.hPn = false;
        hPr.hPo = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xL(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wI(int i) {
        if (this.hPj) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xM(String str) {
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
            return xM(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String v(Class cls) {
        return b(cls, cls.getName(), this.hPg);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hPk);
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
            if (!this.hPh) {
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
        if (this.hPi && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
