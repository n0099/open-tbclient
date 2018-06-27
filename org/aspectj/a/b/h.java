package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hTv = new h();
    static h hTw;
    static h hTx;
    boolean hTm = true;
    boolean hTn = true;
    boolean hTo = false;
    boolean hTp = false;
    boolean hTq = false;
    boolean hTr = true;
    boolean hTs = true;
    boolean hTt = true;
    int hTu;

    h() {
    }

    static {
        hTv.hTm = true;
        hTv.hTn = false;
        hTv.hTo = false;
        hTv.hTp = false;
        hTv.hTq = true;
        hTv.hTr = false;
        hTv.hTs = false;
        hTv.hTu = 0;
        hTw = new h();
        hTw.hTm = true;
        hTw.hTn = true;
        hTw.hTo = false;
        hTw.hTp = false;
        hTw.hTq = false;
        hTv.hTu = 1;
        hTx = new h();
        hTx.hTm = false;
        hTx.hTn = true;
        hTx.hTo = false;
        hTx.hTp = true;
        hTx.hTq = false;
        hTx.hTt = false;
        hTx.hTu = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String xJ(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wR(int i) {
        if (this.hTp) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xK(String str) {
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
            return xK(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String v(Class cls) {
        return b(cls, cls.getName(), this.hTm);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hTq);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(v(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hTn) {
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
        if (this.hTo && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
