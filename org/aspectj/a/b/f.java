package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes20.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int niT;
    ClassLoader ogg = null;
    String ogp;
    Class ogq;
    a ogr;
    private String ogs;
    private static boolean aqU = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.niT = -1;
        this.niT = i;
        this.name = str;
        this.ogq = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (aqU) {
            if (this.ogr == null) {
                try {
                    this.ogr = new b();
                } catch (Throwable th) {
                    aqU = false;
                }
            } else {
                str = this.ogr.get(hVar.ogD);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (aqU) {
            this.ogr.set(hVar.ogD, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.ogF);
    }

    public int dWP() {
        if (this.niT == -1) {
            this.niT = LF(0);
        }
        return this.niT;
    }

    public String getName() {
        if (this.name == null) {
            this.name = LE(1);
        }
        return this.name;
    }

    public Class dWQ() {
        if (this.ogq == null) {
            this.ogq = LG(2);
        }
        return this.ogq;
    }

    public String dWR() {
        if (this.ogp == null) {
            this.ogp = dWQ().getName();
        }
        return this.ogp;
    }

    private ClassLoader dWS() {
        if (this.ogg == null) {
            this.ogg = getClass().getClassLoader();
        }
        return this.ogg;
    }

    String LE(int i) {
        int i2 = 0;
        int indexOf = this.ogs.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.ogs.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.ogs.length();
        }
        return this.ogs.substring(i2, indexOf);
    }

    int LF(int i) {
        return Integer.parseInt(LE(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class LG(int i) {
        return org.aspectj.a.b.b.b(LE(i), dWS());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] LH(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(LE(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dWS());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class b implements a {
        private SoftReference ogt;

        public b() {
            dWU();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dWT = dWT();
            if (dWT == null) {
                return null;
            }
            return dWT[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dWT = dWT();
            if (dWT == null) {
                dWT = dWU();
            }
            dWT[i] = str;
        }

        private String[] dWT() {
            return (String[]) this.ogt.get();
        }

        private String[] dWU() {
            String[] strArr = new String[3];
            this.ogt = new SoftReference(strArr);
            return strArr;
        }
    }
}
