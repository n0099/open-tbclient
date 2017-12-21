package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hNx = new h();
    static h hNy;
    static h hNz;
    boolean hNo = true;
    boolean hNp = true;
    boolean hNq = false;
    boolean hNr = false;
    boolean hNs = false;
    boolean hNt = true;
    boolean hNu = true;
    boolean hNv = true;
    int hNw;

    h() {
    }

    static {
        hNx.hNo = true;
        hNx.hNp = false;
        hNx.hNq = false;
        hNx.hNr = false;
        hNx.hNs = true;
        hNx.hNt = false;
        hNx.hNu = false;
        hNx.hNw = 0;
        hNy = new h();
        hNy.hNo = true;
        hNy.hNp = true;
        hNy.hNq = false;
        hNy.hNr = false;
        hNy.hNs = false;
        hNx.hNw = 1;
        hNz = new h();
        hNz.hNo = false;
        hNz.hNp = true;
        hNz.hNq = false;
        hNz.hNr = true;
        hNz.hNs = false;
        hNz.hNv = false;
        hNz.hNw = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xb(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ye(int i) {
        if (this.hNr) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xc(String str) {
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
            return xc(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hNo);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hNs);
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
            if (!this.hNp) {
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
        if (this.hNq && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
