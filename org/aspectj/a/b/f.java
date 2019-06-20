package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kfP;
    ClassLoader kle = null;
    String kln;
    Class klo;
    a klp;
    private String klq;
    String name;
    private static boolean eNG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] klr = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kfP = -1;
        this.kfP = i;
        this.name = str;
        this.klo = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eNG) {
            if (this.klp == null) {
                try {
                    this.klp = new b();
                } catch (Throwable th) {
                    eNG = false;
                }
            } else {
                str = this.klp.get(hVar.klC);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eNG) {
            this.klp.aP(hVar.klC, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.klE);
    }

    public int getModifiers() {
        if (this.kfP == -1) {
            this.kfP = Eb(0);
        }
        return this.kfP;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Ea(1);
        }
        return this.name;
    }

    public Class cKp() {
        if (this.klo == null) {
            this.klo = Ec(2);
        }
        return this.klo;
    }

    public String cKq() {
        if (this.kln == null) {
            this.kln = cKp().getName();
        }
        return this.kln;
    }

    private ClassLoader cKr() {
        if (this.kle == null) {
            this.kle = getClass().getClassLoader();
        }
        return this.kle;
    }

    String Ea(int i) {
        int i2 = 0;
        int indexOf = this.klq.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.klq.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.klq.length();
        }
        return this.klq.substring(i2, indexOf);
    }

    int Eb(int i) {
        return Integer.parseInt(Ea(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Ec(int i) {
        return org.aspectj.a.b.b.b(Ea(i), cKr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ed(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Ea(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cKr());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference kls;

        public b() {
            cKt();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cKs = cKs();
            if (cKs == null) {
                return null;
            }
            return cKs[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cKs = cKs();
            if (cKs == null) {
                cKs = cKt();
            }
            cKs[i] = str;
        }

        private String[] cKs() {
            return (String[]) this.kls.get();
        }

        private String[] cKt() {
            String[] strArr = new String[3];
            this.kls = new SoftReference(strArr);
            return strArr;
        }
    }
}
