package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hzp = new h();
    static h hzq;
    static h hzr;
    boolean hzg = true;
    boolean hzh = true;
    boolean hzi = false;
    boolean hzj = false;
    boolean hzk = false;
    boolean hzl = true;
    boolean hzm = true;
    boolean hzn = true;
    int hzo;

    h() {
    }

    static {
        hzp.hzg = true;
        hzp.hzh = false;
        hzp.hzi = false;
        hzp.hzj = false;
        hzp.hzk = true;
        hzp.hzl = false;
        hzp.hzm = false;
        hzp.hzo = 0;
        hzq = new h();
        hzq.hzg = true;
        hzq.hzh = true;
        hzq.hzi = false;
        hzq.hzj = false;
        hzq.hzk = false;
        hzp.hzo = 1;
        hzr = new h();
        hzr.hzg = false;
        hzr.hzh = true;
        hzr.hzi = false;
        hzr.hzj = true;
        hzr.hzk = false;
        hzr.hzn = false;
        hzr.hzo = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wn(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xt(int i) {
        if (this.hzj) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wo(String str) {
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
            return wo(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hzg);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hzk);
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
            if (!this.hzh) {
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
        if (this.hzi && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
