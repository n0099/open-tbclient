package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int kfM;
    ClassLoader klb = null;
    String klk;
    Class kll;
    a klm;
    private String kln;
    String name;
    private static boolean eNG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] klo = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.kfM = -1;
        this.kfM = i;
        this.name = str;
        this.kll = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eNG) {
            if (this.klm == null) {
                try {
                    this.klm = new b();
                } catch (Throwable th) {
                    eNG = false;
                }
            } else {
                str = this.klm.get(hVar.klz);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eNG) {
            this.klm.aP(hVar.klz, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.klB);
    }

    public int getModifiers() {
        if (this.kfM == -1) {
            this.kfM = Eb(0);
        }
        return this.kfM;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Ea(1);
        }
        return this.name;
    }

    public Class cKq() {
        if (this.kll == null) {
            this.kll = Ec(2);
        }
        return this.kll;
    }

    public String cKr() {
        if (this.klk == null) {
            this.klk = cKq().getName();
        }
        return this.klk;
    }

    private ClassLoader cKs() {
        if (this.klb == null) {
            this.klb = getClass().getClassLoader();
        }
        return this.klb;
    }

    String Ea(int i) {
        int i2 = 0;
        int indexOf = this.kln.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.kln.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.kln.length();
        }
        return this.kln.substring(i2, indexOf);
    }

    int Eb(int i) {
        return Integer.parseInt(Ea(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Ec(int i) {
        return org.aspectj.a.b.b.b(Ea(i), cKs());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ed(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Ea(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cKs());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference klp;

        public b() {
            cKu();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cKt = cKt();
            if (cKt == null) {
                return null;
            }
            return cKt[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cKt = cKt();
            if (cKt == null) {
                cKt = cKu();
            }
            cKt[i] = str;
        }

        private String[] cKt() {
            return (String[]) this.klp.get();
        }

        private String[] cKu() {
            String[] strArr = new String[3];
            this.klp = new SoftReference(strArr);
            return strArr;
        }
    }
}
