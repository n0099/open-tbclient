package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h klD = new h();
    static h klE;
    static h klF;
    int klC;
    boolean klu = true;
    boolean klv = true;
    boolean klw = false;
    boolean klx = false;
    boolean kly = false;
    boolean klz = true;
    boolean klA = true;
    boolean klB = true;

    h() {
    }

    static {
        klD.klu = true;
        klD.klv = false;
        klD.klw = false;
        klD.klx = false;
        klD.kly = true;
        klD.klz = false;
        klD.klA = false;
        klD.klC = 0;
        klE = new h();
        klE.klu = true;
        klE.klv = true;
        klE.klw = false;
        klE.klx = false;
        klE.kly = false;
        klD.klC = 1;
        klF = new h();
        klF.klu = false;
        klF.klv = true;
        klF.klw = false;
        klF.klx = true;
        klF.kly = false;
        klF.klB = false;
        klF.klC = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Hl(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ee(int i) {
        if (this.klx) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Hm(String str) {
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
            return Hm(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.klu);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.kly);
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
            if (!this.klv) {
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
        if (this.klw && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
