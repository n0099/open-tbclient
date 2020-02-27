package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mKp;
    ClassLoader nJN = null;
    String nJW;
    Class nJX;
    a nJY;
    private String nJZ;
    String name;
    private static boolean fQF = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nKa = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mKp = -1;
        this.mKp = i;
        this.name = str;
        this.nJX = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fQF) {
            if (this.nJY == null) {
                try {
                    this.nJY = new b();
                } catch (Throwable th) {
                    fQF = false;
                }
            } else {
                str = this.nJY.get(hVar.nKl);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fQF) {
            this.nJY.set(hVar.nKl, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nKn);
    }

    public int dNa() {
        if (this.mKp == -1) {
            this.mKp = NR(0);
        }
        return this.mKp;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NQ(1);
        }
        return this.name;
    }

    public Class dNb() {
        if (this.nJX == null) {
            this.nJX = NS(2);
        }
        return this.nJX;
    }

    public String dNc() {
        if (this.nJW == null) {
            this.nJW = dNb().getName();
        }
        return this.nJW;
    }

    private ClassLoader dNd() {
        if (this.nJN == null) {
            this.nJN = getClass().getClassLoader();
        }
        return this.nJN;
    }

    String NQ(int i) {
        int i2 = 0;
        int indexOf = this.nJZ.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nJZ.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nJZ.length();
        }
        return this.nJZ.substring(i2, indexOf);
    }

    int NR(int i) {
        return Integer.parseInt(NQ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NS(int i) {
        return org.aspectj.a.b.b.b(NQ(i), dNd());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NT(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NQ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dNd());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nKb;

        public b() {
            dNf();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dNe = dNe();
            if (dNe == null) {
                return null;
            }
            return dNe[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dNe = dNe();
            if (dNe == null) {
                dNe = dNf();
            }
            dNe[i] = str;
        }

        private String[] dNe() {
            return (String[]) this.nKb.get();
        }

        private String[] dNf() {
            String[] strArr = new String[3];
            this.nKb = new SoftReference(strArr);
            return strArr;
        }
    }
}
