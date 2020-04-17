package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int miT;
    String name;
    String nfA;
    Class nfB;
    a nfC;
    private String nfD;
    ClassLoader nfr = null;
    private static boolean gwl = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nfE = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.miT = -1;
        this.miT = i;
        this.name = str;
        this.nfB = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (gwl) {
            if (this.nfC == null) {
                try {
                    this.nfC = new b();
                } catch (Throwable th) {
                    gwl = false;
                }
            } else {
                str = this.nfC.get(hVar.nfP);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (gwl) {
            this.nfC.set(hVar.nfP, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nfR);
    }

    public int dGD() {
        if (this.miT == -1) {
            this.miT = Jr(0);
        }
        return this.miT;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Jq(1);
        }
        return this.name;
    }

    public Class dGE() {
        if (this.nfB == null) {
            this.nfB = Js(2);
        }
        return this.nfB;
    }

    public String dGF() {
        if (this.nfA == null) {
            this.nfA = dGE().getName();
        }
        return this.nfA;
    }

    private ClassLoader dGG() {
        if (this.nfr == null) {
            this.nfr = getClass().getClassLoader();
        }
        return this.nfr;
    }

    String Jq(int i) {
        int i2 = 0;
        int indexOf = this.nfD.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nfD.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nfD.length();
        }
        return this.nfD.substring(i2, indexOf);
    }

    int Jr(int i) {
        return Integer.parseInt(Jq(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Js(int i) {
        return org.aspectj.a.b.b.b(Jq(i), dGG());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Jt(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Jq(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dGG());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nfF;

        public b() {
            dGI();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dGH = dGH();
            if (dGH == null) {
                return null;
            }
            return dGH[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dGH = dGH();
            if (dGH == null) {
                dGH = dGI();
            }
            dGH[i] = str;
        }

        private String[] dGH() {
            return (String[]) this.nfF.get();
        }

        private String[] dGI() {
            String[] strArr = new String[3];
            this.nfF = new SoftReference(strArr);
            return strArr;
        }
    }
}
