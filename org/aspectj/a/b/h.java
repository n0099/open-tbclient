package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h klA;
    static h klB;
    static h klz = new h();
    boolean klq = true;
    boolean klr = true;
    boolean kls = false;
    boolean klt = false;
    boolean klu = false;
    boolean klv = true;
    boolean klw = true;
    boolean klx = true;
    int kly;

    h() {
    }

    static {
        klz.klq = true;
        klz.klr = false;
        klz.kls = false;
        klz.klt = false;
        klz.klu = true;
        klz.klv = false;
        klz.klw = false;
        klz.kly = 0;
        klA = new h();
        klA.klq = true;
        klA.klr = true;
        klA.kls = false;
        klA.klt = false;
        klA.klu = false;
        klz.kly = 1;
        klB = new h();
        klB.klq = false;
        klB.klr = true;
        klB.kls = false;
        klB.klt = true;
        klB.klu = false;
        klB.klx = false;
        klB.kly = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Hj(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ee(int i) {
        if (this.klt) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Hk(String str) {
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
            return Hk(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.klq);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.klu);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(E(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.klr) {
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
        if (this.kls && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
