package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h ktc = new h();
    static h ktd;
    static h kte;
    boolean ksT = true;
    boolean ksU = true;
    boolean ksV = false;
    boolean ksW = false;
    boolean ksX = false;
    boolean ksY = true;
    boolean ksZ = true;
    boolean kta = true;
    int ktb;

    h() {
    }

    static {
        ktc.ksT = true;
        ktc.ksU = false;
        ktc.ksV = false;
        ktc.ksW = false;
        ktc.ksX = true;
        ktc.ksY = false;
        ktc.ksZ = false;
        ktc.ktb = 0;
        ktd = new h();
        ktd.ksT = true;
        ktd.ksU = true;
        ktd.ksV = false;
        ktd.ksW = false;
        ktd.ksX = false;
        ktc.ktb = 1;
        kte = new h();
        kte.ksT = false;
        kte.ksU = true;
        kte.ksV = false;
        kte.ksW = true;
        kte.ksX = false;
        kte.kta = false;
        kte.ktb = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String In(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String EN(int i) {
        if (this.ksW) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Io(String str) {
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
            return Io(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String G(Class cls) {
        return b(cls, cls.getName(), this.ksT);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.ksX);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(G(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.ksU) {
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
        if (this.ksV && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
