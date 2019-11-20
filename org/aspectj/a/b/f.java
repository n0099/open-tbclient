package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int knT;
    ClassLoader kvT = null;
    String kwc;
    Class kwd;
    a kwe;
    private String kwf;
    String name;
    private static boolean eWs = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] kwg = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aP(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.knT = -1;
        this.knT = i;
        this.name = str;
        this.kwd = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eWs) {
            if (this.kwe == null) {
                try {
                    this.kwe = new b();
                } catch (Throwable th) {
                    eWs = false;
                }
            } else {
                str = this.kwe.get(hVar.kwr);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eWs) {
            this.kwe.aP(hVar.kwr, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.kwt);
    }

    public int cNo() {
        if (this.knT == -1) {
            this.knT = Dm(0);
        }
        return this.knT;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Dl(1);
        }
        return this.name;
    }

    public Class cNp() {
        if (this.kwd == null) {
            this.kwd = Dn(2);
        }
        return this.kwd;
    }

    public String cNq() {
        if (this.kwc == null) {
            this.kwc = cNp().getName();
        }
        return this.kwc;
    }

    private ClassLoader cNr() {
        if (this.kvT == null) {
            this.kvT = getClass().getClassLoader();
        }
        return this.kvT;
    }

    String Dl(int i) {
        int i2 = 0;
        int indexOf = this.kwf.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.kwf.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.kwf.length();
        }
        return this.kwf.substring(i2, indexOf);
    }

    int Dm(int i) {
        return Integer.parseInt(Dl(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Dn(int i) {
        return org.aspectj.a.b.b.b(Dl(i), cNr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Do(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Dl(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cNr());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference kwh;

        public b() {
            cNt();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cNs = cNs();
            if (cNs == null) {
                return null;
            }
            return cNs[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aP(int i, String str) {
            String[] cNs = cNs();
            if (cNs == null) {
                cNs = cNt();
            }
            cNs[i] = str;
        }

        private String[] cNs() {
            return (String[]) this.kwh.get();
        }

        private String[] cNt() {
            String[] strArr = new String[3];
            this.kwh = new SoftReference(strArr);
            return strArr;
        }
    }
}
