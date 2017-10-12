package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hom = new h();
    static h hon;
    static h hoo;
    boolean hod = true;
    boolean hoe = true;
    boolean hof = false;
    boolean hog = false;
    boolean hoh = false;
    boolean hoi = true;
    boolean hoj = true;
    boolean hok = true;
    int hol;

    h() {
    }

    static {
        hom.hod = true;
        hom.hoe = false;
        hom.hof = false;
        hom.hog = false;
        hom.hoh = true;
        hom.hoi = false;
        hom.hoj = false;
        hom.hol = 0;
        hon = new h();
        hon.hod = true;
        hon.hoe = true;
        hon.hof = false;
        hon.hog = false;
        hon.hoh = false;
        hom.hol = 1;
        hoo = new h();
        hoo.hod = false;
        hoo.hoe = true;
        hoo.hof = false;
        hoo.hog = true;
        hoo.hoh = false;
        hoo.hok = false;
        hoo.hol = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String vw(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wT(int i) {
        if (this.hog) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String vx(String str) {
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
            return vx(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.hod);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.hoh);
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
            if (!this.hoe) {
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
        if (this.hof && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
