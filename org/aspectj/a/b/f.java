package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes16.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    ClassLoader pLF = null;
    String pLO;
    Class pLP;
    a pLQ;
    private String pLR;
    int ptN;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ptN = -1;
        this.ptN = i;
        this.name = str;
        this.pLP = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.pLQ == null) {
                try {
                    this.pLQ = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.pLQ.get(hVar.pMc);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.pLQ.set(hVar.pMc, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.pMe);
    }

    public int eEy() {
        if (this.ptN == -1) {
            this.ptN = Sb(0);
        }
        return this.ptN;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sa(1);
        }
        return this.name;
    }

    public Class eEz() {
        if (this.pLP == null) {
            this.pLP = Sc(2);
        }
        return this.pLP;
    }

    public String eEA() {
        if (this.pLO == null) {
            this.pLO = eEz().getName();
        }
        return this.pLO;
    }

    private ClassLoader eEB() {
        if (this.pLF == null) {
            this.pLF = getClass().getClassLoader();
        }
        return this.pLF;
    }

    String Sa(int i) {
        int i2 = 0;
        int indexOf = this.pLR.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.pLR.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.pLR.length();
        }
        return this.pLR.substring(i2, indexOf);
    }

    int Sb(int i) {
        return Integer.parseInt(Sa(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Sc(int i) {
        return org.aspectj.a.b.b.b(Sa(i), eEB());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Sd(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sa(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eEB());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static final class b implements a {
        private SoftReference pLS;

        public b() {
            eED();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eEC = eEC();
            if (eEC == null) {
                return null;
            }
            return eEC[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eEC = eEC();
            if (eEC == null) {
                eEC = eED();
            }
            eEC[i] = str;
        }

        private String[] eEC() {
            return (String[]) this.pLS.get();
        }

        private String[] eED() {
            String[] strArr = new String[3];
            this.pLS = new SoftReference(strArr);
            return strArr;
        }
    }
}
