package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h izC = new h();
    static h izD;
    static h izE;
    int izB;
    boolean izt = true;
    boolean izu = true;
    boolean izv = false;
    boolean izw = false;
    boolean izx = false;
    boolean izy = true;
    boolean izz = true;
    boolean izA = true;

    h() {
    }

    static {
        izC.izt = true;
        izC.izu = false;
        izC.izv = false;
        izC.izw = false;
        izC.izx = true;
        izC.izy = false;
        izC.izz = false;
        izC.izB = 0;
        izD = new h();
        izD.izt = true;
        izD.izu = true;
        izD.izv = false;
        izD.izw = false;
        izD.izx = false;
        izC.izB = 1;
        izE = new h();
        izE.izt = false;
        izE.izu = true;
        izE.izv = false;
        izE.izw = true;
        izE.izx = false;
        izE.izA = false;
        izE.izB = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zF(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zk(int i) {
        if (this.izw) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String zG(String str) {
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
            return zG(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.izt);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.izx);
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
            if (!this.izu) {
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
        if (this.izv && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
