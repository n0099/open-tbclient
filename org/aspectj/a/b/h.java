package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h nJx = new h();
    static h nJy;
    static h nJz;
    boolean nJo = true;
    boolean nJp = true;
    boolean nJq = false;
    boolean nJr = false;
    boolean nJs = false;
    boolean nJt = true;
    boolean nJu = true;
    boolean nJv = true;
    int nJw;

    h() {
    }

    static {
        nJx.nJo = true;
        nJx.nJp = false;
        nJx.nJq = false;
        nJx.nJr = false;
        nJx.nJs = true;
        nJx.nJt = false;
        nJx.nJu = false;
        nJx.nJw = 0;
        nJy = new h();
        nJy.nJo = true;
        nJy.nJp = true;
        nJy.nJq = false;
        nJy.nJr = false;
        nJy.nJs = false;
        nJx.nJw = 1;
        nJz = new h();
        nJz.nJo = false;
        nJz.nJp = true;
        nJz.nJq = false;
        nJz.nJr = true;
        nJz.nJs = false;
        nJz.nJv = false;
        nJz.nJw = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sd(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String NR(int i) {
        if (this.nJr) {
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
        return b(cls, cls.getName(), this.nJo);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nJs);
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
            if (!this.nJp) {
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
        if (this.nJq && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
