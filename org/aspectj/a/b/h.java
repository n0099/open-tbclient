package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iqI = new h();
    static h iqJ;
    static h iqK;
    int iqH;
    boolean iqz = true;
    boolean iqA = true;
    boolean iqB = false;
    boolean iqC = false;
    boolean iqD = false;
    boolean iqE = true;
    boolean iqF = true;
    boolean iqG = true;

    h() {
    }

    static {
        iqI.iqz = true;
        iqI.iqA = false;
        iqI.iqB = false;
        iqI.iqC = false;
        iqI.iqD = true;
        iqI.iqE = false;
        iqI.iqF = false;
        iqI.iqH = 0;
        iqJ = new h();
        iqJ.iqz = true;
        iqJ.iqA = true;
        iqJ.iqB = false;
        iqJ.iqC = false;
        iqJ.iqD = false;
        iqI.iqH = 1;
        iqK = new h();
        iqK.iqz = false;
        iqK.iqA = true;
        iqK.iqB = false;
        iqK.iqC = true;
        iqK.iqD = false;
        iqK.iqG = false;
        iqK.iqH = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yX(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yu(int i) {
        if (this.iqC) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String yY(String str) {
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
            return yY(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String D(Class cls) {
        return b(cls, cls.getName(), this.iqz);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.iqD);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(D(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.iqA) {
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
        if (this.iqB && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
