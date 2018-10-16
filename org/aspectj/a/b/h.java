package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iqH = new h();
    static h iqI;
    static h iqJ;
    int iqG;
    boolean iqy = true;
    boolean iqz = true;
    boolean iqA = false;
    boolean iqB = false;
    boolean iqC = false;
    boolean iqD = true;
    boolean iqE = true;
    boolean iqF = true;

    h() {
    }

    static {
        iqH.iqy = true;
        iqH.iqz = false;
        iqH.iqA = false;
        iqH.iqB = false;
        iqH.iqC = true;
        iqH.iqD = false;
        iqH.iqE = false;
        iqH.iqG = 0;
        iqI = new h();
        iqI.iqy = true;
        iqI.iqz = true;
        iqI.iqA = false;
        iqI.iqB = false;
        iqI.iqC = false;
        iqH.iqG = 1;
        iqJ = new h();
        iqJ.iqy = false;
        iqJ.iqz = true;
        iqJ.iqA = false;
        iqJ.iqB = true;
        iqJ.iqC = false;
        iqJ.iqF = false;
        iqJ.iqG = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yX(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yu(int i) {
        if (this.iqB) {
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
        return b(cls, cls.getName(), this.iqy);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.iqC);
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
            if (!this.iqz) {
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
        if (this.iqA && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
