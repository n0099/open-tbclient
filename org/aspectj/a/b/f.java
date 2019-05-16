package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kfL;
    ClassLoader kla = null;
    String klj;
    Class klk;
    a kll;
    private String klm;
    String name;
    private static boolean eNF = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] kln = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kfL = -1;
        this.kfL = i;
        this.name = str;
        this.klk = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eNF) {
            if (this.kll == null) {
                try {
                    this.kll = new b();
                } catch (Throwable th) {
                    eNF = false;
                }
            } else {
                str = this.kll.get(hVar.kly);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eNF) {
            this.kll.aP(hVar.kly, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.klA);
    }

    public int getModifiers() {
        if (this.kfL == -1) {
            this.kfL = Eb(0);
        }
        return this.kfL;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Ea(1);
        }
        return this.name;
    }

    public Class cKo() {
        if (this.klk == null) {
            this.klk = Ec(2);
        }
        return this.klk;
    }

    public String cKp() {
        if (this.klj == null) {
            this.klj = cKo().getName();
        }
        return this.klj;
    }

    private ClassLoader cKq() {
        if (this.kla == null) {
            this.kla = getClass().getClassLoader();
        }
        return this.kla;
    }

    String Ea(int i) {
        int i2 = 0;
        int indexOf = this.klm.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.klm.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.klm.length();
        }
        return this.klm.substring(i2, indexOf);
    }

    int Eb(int i) {
        return Integer.parseInt(Ea(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Ec(int i) {
        return org.aspectj.a.b.b.b(Ea(i), cKq());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ed(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Ea(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cKq());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference klo;

        public b() {
            cKs();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cKr = cKr();
            if (cKr == null) {
                return null;
            }
            return cKr[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cKr = cKr();
            if (cKr == null) {
                cKr = cKs();
            }
            cKr[i] = str;
        }

        private String[] cKr() {
            return (String[]) this.klo.get();
        }

        private String[] cKs() {
            String[] strArr = new String[3];
            this.klo = new SoftReference(strArr);
            return strArr;
        }
    }
}
