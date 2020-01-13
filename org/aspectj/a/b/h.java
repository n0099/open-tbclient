package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h nJs = new h();
    static h nJt;
    static h nJu;
    boolean nJj = true;
    boolean nJk = true;
    boolean nJl = false;
    boolean nJm = false;
    boolean nJn = false;
    boolean nJo = true;
    boolean nJp = true;
    boolean nJq = true;
    int nJr;

    h() {
    }

    static {
        nJs.nJj = true;
        nJs.nJk = false;
        nJs.nJl = false;
        nJs.nJm = false;
        nJs.nJn = true;
        nJs.nJo = false;
        nJs.nJp = false;
        nJs.nJr = 0;
        nJt = new h();
        nJt.nJj = true;
        nJt.nJk = true;
        nJt.nJl = false;
        nJt.nJm = false;
        nJt.nJn = false;
        nJs.nJr = 1;
        nJu = new h();
        nJu.nJj = false;
        nJu.nJk = true;
        nJu.nJl = false;
        nJu.nJm = true;
        nJu.nJn = false;
        nJu.nJq = false;
        nJu.nJr = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sd(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String NR(int i) {
        if (this.nJm) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String Se(String str) {
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
            return Se(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String O(Class cls) {
        return b(cls, cls.getName(), this.nJj);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nJn);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(O(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.nJk) {
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
        if (this.nJl && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
