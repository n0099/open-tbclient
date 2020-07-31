package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes20.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int niR;
    ClassLoader oge = null;
    String ogn;
    Class ogo;
    a ogp;
    private String ogq;
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
        this.niR = -1;
        this.niR = i;
        this.name = str;
        this.ogo = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (aqU) {
            if (this.ogp == null) {
                try {
                    this.ogp = new b();
                } catch (Throwable th) {
                    aqU = false;
                }
            } else {
                str = this.ogp.get(hVar.ogB);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (aqU) {
            this.ogp.set(hVar.ogB, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.ogD);
    }

    public int dWO() {
        if (this.niR == -1) {
            this.niR = LF(0);
        }
        return this.niR;
    }

    public String getName() {
        if (this.name == null) {
            this.name = LE(1);
        }
        return this.name;
    }

    public Class dWP() {
        if (this.ogo == null) {
            this.ogo = LG(2);
        }
        return this.ogo;
    }

    public String dWQ() {
        if (this.ogn == null) {
            this.ogn = dWP().getName();
        }
        return this.ogn;
    }

    private ClassLoader dWR() {
        if (this.oge == null) {
            this.oge = getClass().getClassLoader();
        }
        return this.oge;
    }

    String LE(int i) {
        int i2 = 0;
        int indexOf = this.ogq.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.ogq.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.ogq.length();
        }
        return this.ogq.substring(i2, indexOf);
    }

    int LF(int i) {
        return Integer.parseInt(LE(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class LG(int i) {
        return org.aspectj.a.b.b.b(LE(i), dWR());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] LH(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(LE(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dWR());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static final class b implements a {
        private SoftReference ogr;

        public b() {
            dWT();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dWS = dWS();
            if (dWS == null) {
                return null;
            }
            return dWS[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dWS = dWS();
            if (dWS == null) {
                dWS = dWT();
            }
            dWS[i] = str;
        }

        private String[] dWS() {
            return (String[]) this.ogr.get();
        }

        private String[] dWT() {
            String[] strArr = new String[3];
            this.ogr = new SoftReference(strArr);
            return strArr;
        }
    }
}
