package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hSj = new h();
    static h hSk;
    static h hSl;
    boolean hSa = true;
    boolean hSb = true;
    boolean hSc = false;
    boolean hSd = false;
    boolean hSe = false;
    boolean hSf = true;
    boolean hSg = true;
    boolean hSh = true;
    int hSi;

    h() {
    }

    static {
        hSj.hSa = true;
        hSj.hSb = false;
        hSj.hSc = false;
        hSj.hSd = false;
        hSj.hSe = true;
        hSj.hSf = false;
        hSj.hSg = false;
        hSj.hSi = 0;
        hSk = new h();
        hSk.hSa = true;
        hSk.hSb = true;
        hSk.hSc = false;
        hSk.hSd = false;
        hSk.hSe = false;
        hSj.hSi = 1;
        hSl = new h();
        hSl.hSa = false;
        hSl.hSb = true;
        hSl.hSc = false;
        hSl.hSd = true;
        hSl.hSe = false;
        hSl.hSh = false;
        hSl.hSi = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xv(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wF(int i) {
        if (this.hSd) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xw(String str) {
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
            return xw(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String y(Class cls) {
        return b(cls, cls.getName(), this.hSa);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hSe);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(y(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hSb) {
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
        if (this.hSc && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
