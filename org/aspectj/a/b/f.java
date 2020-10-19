package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    ClassLoader oZn = null;
    String oZw;
    Class oZx;
    a oZy;
    private String oZz;
    int ocp;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ocp = -1;
        this.ocp = i;
        this.name = str;
        this.oZx = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.oZy == null) {
                try {
                    this.oZy = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.oZy.get(hVar.oZK);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.oZy.set(hVar.oZK, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.oZM);
    }

    public int eqL() {
        if (this.ocp == -1) {
            this.ocp = Pt(0);
        }
        return this.ocp;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Ps(1);
        }
        return this.name;
    }

    public Class eqM() {
        if (this.oZx == null) {
            this.oZx = Pu(2);
        }
        return this.oZx;
    }

    public String eqN() {
        if (this.oZw == null) {
            this.oZw = eqM().getName();
        }
        return this.oZw;
    }

    private ClassLoader eqO() {
        if (this.oZn == null) {
            this.oZn = getClass().getClassLoader();
        }
        return this.oZn;
    }

    String Ps(int i) {
        int i2 = 0;
        int indexOf = this.oZz.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.oZz.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.oZz.length();
        }
        return this.oZz.substring(i2, indexOf);
    }

    int Pt(int i) {
        return Integer.parseInt(Ps(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Pu(int i) {
        return org.aspectj.a.b.b.b(Ps(i), eqO());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Pv(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Ps(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eqO());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference oZA;

        public b() {
            eqQ();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eqP = eqP();
            if (eqP == null) {
                return null;
            }
            return eqP[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eqP = eqP();
            if (eqP == null) {
                eqP = eqQ();
            }
            eqP[i] = str;
        }

        private String[] eqP() {
            return (String[]) this.oZA.get();
        }

        private String[] eqQ() {
            String[] strArr = new String[3];
            this.oZA = new SoftReference(strArr);
            return strArr;
        }
    }
}
