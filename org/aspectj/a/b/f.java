package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes4.dex */
abstract class f implements org.aspectj.lang.c {
    int mFN;
    ClassLoader mZT = null;
    String nac;
    Class nad;
    a nae;
    private String naf;
    String name;
    private static boolean fLb = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nag = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mFN = -1;
        this.mFN = i;
        this.name = str;
        this.nad = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fLb) {
            if (this.nae == null) {
                try {
                    this.nae = new b();
                } catch (Throwable th) {
                    fLb = false;
                }
            } else {
                str = this.nae.get(hVar.nar);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fLb) {
            this.nae.set(hVar.nar, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nat);
    }

    public int dFk() {
        if (this.mFN == -1) {
            this.mFN = MU(0);
        }
        return this.mFN;
    }

    public String getName() {
        if (this.name == null) {
            this.name = MT(1);
        }
        return this.name;
    }

    public Class dFl() {
        if (this.nad == null) {
            this.nad = MV(2);
        }
        return this.nad;
    }

    public String dFm() {
        if (this.nac == null) {
            this.nac = dFl().getName();
        }
        return this.nac;
    }

    private ClassLoader dFn() {
        if (this.mZT == null) {
            this.mZT = getClass().getClassLoader();
        }
        return this.mZT;
    }

    String MT(int i) {
        int i2 = 0;
        int indexOf = this.naf.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.naf.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.naf.length();
        }
        return this.naf.substring(i2, indexOf);
    }

    int MU(int i) {
        return Integer.parseInt(MT(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class MV(int i) {
        return org.aspectj.a.b.b.b(MT(i), dFn());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] MW(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(MT(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dFn());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements a {
        private SoftReference nah;

        public b() {
            dFp();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dFo = dFo();
            if (dFo == null) {
                return null;
            }
            return dFo[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dFo = dFo();
            if (dFo == null) {
                dFo = dFp();
            }
            dFo[i] = str;
        }

        private String[] dFo() {
            return (String[]) this.nah.get();
        }

        private String[] dFp() {
            String[] strArr = new String[3];
            this.nah = new SoftReference(strArr);
            return strArr;
        }
    }
}
