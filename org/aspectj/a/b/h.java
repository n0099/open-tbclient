package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h imN = new h();
    static h imO;
    static h imP;
    boolean imE = true;
    boolean imF = true;
    boolean imG = false;
    boolean imH = false;
    boolean imI = false;
    boolean imJ = true;
    boolean imK = true;
    boolean imL = true;
    int imM;

    h() {
    }

    static {
        imN.imE = true;
        imN.imF = false;
        imN.imG = false;
        imN.imH = false;
        imN.imI = true;
        imN.imJ = false;
        imN.imK = false;
        imN.imM = 0;
        imO = new h();
        imO.imE = true;
        imO.imF = true;
        imO.imG = false;
        imO.imH = false;
        imO.imI = false;
        imN.imM = 1;
        imP = new h();
        imP.imE = false;
        imP.imF = true;
        imP.imG = false;
        imP.imH = true;
        imP.imI = false;
        imP.imL = false;
        imP.imM = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wZ(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zy(int i) {
        if (this.imH) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xa(String str) {
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
            return xa(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.imE);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.imI);
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
            if (!this.imF) {
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
        if (this.imG && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
