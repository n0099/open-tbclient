package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h quS = new h();
    static h quT;
    static h quU;
    boolean quJ = true;
    boolean quK = true;
    boolean quL = false;
    boolean quM = false;
    boolean quN = false;
    boolean quO = true;
    boolean quP = true;
    boolean quQ = true;
    int quR;

    h() {
    }

    static {
        quS.quJ = true;
        quS.quK = false;
        quS.quL = false;
        quS.quM = false;
        quS.quN = true;
        quS.quO = false;
        quS.quP = false;
        quS.quR = 0;
        quT = new h();
        quT.quJ = true;
        quT.quK = true;
        quT.quL = false;
        quT.quM = false;
        quT.quN = false;
        quS.quR = 1;
        quU = new h();
        quU.quJ = false;
        quU.quK = true;
        quU.quL = false;
        quU.quM = true;
        quU.quN = false;
        quU.quQ = false;
        quU.quR = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ack(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String SB(int i) {
        if (this.quM) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String acl(String str) {
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
            return acl(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.quJ);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.quN);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(H(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.quK) {
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
        if (this.quL && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
