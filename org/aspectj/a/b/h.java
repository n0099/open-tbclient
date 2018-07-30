package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hKi = new h();
    static h hKj;
    static h hKk;
    boolean hJZ = true;
    boolean hKa = true;
    boolean hKb = false;
    boolean hKc = false;
    boolean hKd = false;
    boolean hKe = true;
    boolean hKf = true;
    boolean hKg = true;
    int hKh;

    h() {
    }

    static {
        hKi.hJZ = true;
        hKi.hKa = false;
        hKi.hKb = false;
        hKi.hKc = false;
        hKi.hKd = true;
        hKi.hKe = false;
        hKi.hKf = false;
        hKi.hKh = 0;
        hKj = new h();
        hKj.hJZ = true;
        hKj.hKa = true;
        hKj.hKb = false;
        hKj.hKc = false;
        hKj.hKd = false;
        hKi.hKh = 1;
        hKk = new h();
        hKk.hJZ = false;
        hKk.hKa = true;
        hKk.hKb = false;
        hKk.hKc = true;
        hKk.hKd = false;
        hKk.hKg = false;
        hKk.hKh = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wJ(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wh(int i) {
        if (this.hKc) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wK(String str) {
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
            return wK(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String v(Class cls) {
        return b(cls, cls.getName(), this.hJZ);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hKd);
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
            if (!this.hKa) {
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
        if (this.hKb && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
