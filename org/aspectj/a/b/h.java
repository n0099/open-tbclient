package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h idW = new h();
    static h idX;
    static h idY;
    boolean idN = true;
    boolean idO = true;
    boolean idP = false;
    boolean idQ = false;
    boolean idR = false;
    boolean idS = true;
    boolean idT = true;
    boolean idU = true;
    int idV;

    h() {
    }

    static {
        idW.idN = true;
        idW.idO = false;
        idW.idP = false;
        idW.idQ = false;
        idW.idR = true;
        idW.idS = false;
        idW.idT = false;
        idW.idV = 0;
        idX = new h();
        idX.idN = true;
        idX.idO = true;
        idX.idP = false;
        idX.idQ = false;
        idX.idR = false;
        idW.idV = 1;
        idY = new h();
        idY.idN = false;
        idY.idO = true;
        idY.idP = false;
        idY.idQ = true;
        idY.idR = false;
        idY.idU = false;
        idY.idV = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String vz(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zI(int i) {
        if (this.idQ) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String vA(String str) {
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
            return vA(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String n(Class cls) {
        return b(cls, cls.getName(), this.idN);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.idR);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(n(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.idO) {
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
        if (this.idP && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
