package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes16.dex */
class h {
    static h pMf = new h();
    static h pMg;
    static h pMh;
    boolean pLW = true;
    boolean pLX = true;
    boolean pLY = false;
    boolean pLZ = false;
    boolean pMa = false;
    boolean pMb = true;
    boolean pMc = true;
    boolean pMd = true;
    int pMe;

    h() {
    }

    static {
        pMf.pLW = true;
        pMf.pLX = false;
        pMf.pLY = false;
        pMf.pLZ = false;
        pMf.pMa = true;
        pMf.pMb = false;
        pMf.pMc = false;
        pMf.pMe = 0;
        pMg = new h();
        pMg.pLW = true;
        pMg.pLX = true;
        pMg.pLY = false;
        pMg.pLZ = false;
        pMg.pMa = false;
        pMf.pMe = 1;
        pMh = new h();
        pMh.pLW = false;
        pMh.pLX = true;
        pMh.pLY = false;
        pMh.pLZ = true;
        pMh.pMa = false;
        pMh.pMd = false;
        pMh.pMe = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String aav(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Se(int i) {
        if (this.pLZ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String aaw(String str) {
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
            return aaw(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.pLW);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.pMa);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(N(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.pLX) {
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
        if (this.pLY && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
