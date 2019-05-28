package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h klA = new h();
    static h klB;
    static h klC;
    boolean klr = true;
    boolean kls = true;
    boolean klt = false;
    boolean klu = false;
    boolean klv = false;
    boolean klw = true;
    boolean klx = true;
    boolean kly = true;
    int klz;

    h() {
    }

    static {
        klA.klr = true;
        klA.kls = false;
        klA.klt = false;
        klA.klu = false;
        klA.klv = true;
        klA.klw = false;
        klA.klx = false;
        klA.klz = 0;
        klB = new h();
        klB.klr = true;
        klB.kls = true;
        klB.klt = false;
        klB.klu = false;
        klB.klv = false;
        klA.klz = 1;
        klC = new h();
        klC.klr = false;
        klC.kls = true;
        klC.klt = false;
        klC.klu = true;
        klC.klv = false;
        klC.kly = false;
        klC.klz = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Hj(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ee(int i) {
        if (this.klu) {
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
        return b(cls, cls.getName(), this.klr);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.klv);
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
            if (!this.kls) {
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
        if (this.klt && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
