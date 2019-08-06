package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h kui = new h();
    static h kuj;
    static h kuk;
    boolean ktZ = true;
    boolean kua = true;
    boolean kub = false;
    boolean kuc = false;
    boolean kud = false;
    boolean kue = true;
    boolean kuf = true;
    boolean kug = true;
    int kuh;

    h() {
    }

    static {
        kui.ktZ = true;
        kui.kua = false;
        kui.kub = false;
        kui.kuc = false;
        kui.kud = true;
        kui.kue = false;
        kui.kuf = false;
        kui.kuh = 0;
        kuj = new h();
        kuj.ktZ = true;
        kuj.kua = true;
        kuj.kub = false;
        kuj.kuc = false;
        kuj.kud = false;
        kui.kuh = 1;
        kuk = new h();
        kuk.ktZ = false;
        kuk.kua = true;
        kuk.kub = false;
        kuk.kuc = true;
        kuk.kud = false;
        kuk.kug = false;
        kuk.kuh = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Io(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String EP(int i) {
        if (this.kuc) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Ip(String str) {
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
            return Ip(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String G(Class cls) {
        return b(cls, cls.getName(), this.ktZ);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.kud);
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
            if (!this.kua) {
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
        if (this.kub && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
