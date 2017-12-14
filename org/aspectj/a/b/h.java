package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hNs = new h();
    static h hNt;
    static h hNu;
    boolean hNj = true;
    boolean hNk = true;
    boolean hNl = false;
    boolean hNm = false;
    boolean hNn = false;
    boolean hNo = true;
    boolean hNp = true;
    boolean hNq = true;
    int hNr;

    h() {
    }

    static {
        hNs.hNj = true;
        hNs.hNk = false;
        hNs.hNl = false;
        hNs.hNm = false;
        hNs.hNn = true;
        hNs.hNo = false;
        hNs.hNp = false;
        hNs.hNr = 0;
        hNt = new h();
        hNt.hNj = true;
        hNt.hNk = true;
        hNt.hNl = false;
        hNt.hNm = false;
        hNt.hNn = false;
        hNs.hNr = 1;
        hNu = new h();
        hNu.hNj = false;
        hNu.hNk = true;
        hNu.hNl = false;
        hNu.hNm = true;
        hNu.hNn = false;
        hNu.hNq = false;
        hNu.hNr = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xb(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ye(int i) {
        if (this.hNm) {
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
        return b(cls, cls.getName(), this.hNj);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hNn);
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
            if (!this.hNk) {
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
        if (this.hNl && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
