package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h inX = new h();
    static h inY;
    static h inZ;
    boolean inO = true;
    boolean inP = true;
    boolean inQ = false;
    boolean inR = false;
    boolean inS = false;
    boolean inT = true;
    boolean inU = true;
    boolean inV = true;
    int inW;

    h() {
    }

    static {
        inX.inO = true;
        inX.inP = false;
        inX.inQ = false;
        inX.inR = false;
        inX.inS = true;
        inX.inT = false;
        inX.inU = false;
        inX.inW = 0;
        inY = new h();
        inY.inO = true;
        inY.inP = true;
        inY.inQ = false;
        inY.inR = false;
        inY.inS = false;
        inX.inW = 1;
        inZ = new h();
        inZ.inO = false;
        inZ.inP = true;
        inZ.inQ = false;
        inZ.inR = true;
        inZ.inS = false;
        inZ.inV = false;
        inZ.inW = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wM(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.inR) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wN(String str) {
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
            return wN(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.inO);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.inS);
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
            if (!this.inP) {
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
        if (this.inQ && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
