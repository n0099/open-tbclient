package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mKr;
    ClassLoader nJP = null;
    String nJY;
    Class nJZ;
    a nKa;
    private String nKb;
    String name;
    private static boolean fQH = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nKc = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mKr = -1;
        this.mKr = i;
        this.name = str;
        this.nJZ = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fQH) {
            if (this.nKa == null) {
                try {
                    this.nKa = new b();
                } catch (Throwable th) {
                    fQH = false;
                }
            } else {
                str = this.nKa.get(hVar.nKn);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fQH) {
            this.nKa.set(hVar.nKn, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nKp);
    }

    public int dNc() {
        if (this.mKr == -1) {
            this.mKr = NR(0);
        }
        return this.mKr;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NQ(1);
        }
        return this.name;
    }

    public Class dNd() {
        if (this.nJZ == null) {
            this.nJZ = NS(2);
        }
        return this.nJZ;
    }

    public String dNe() {
        if (this.nJY == null) {
            this.nJY = dNd().getName();
        }
        return this.nJY;
    }

    private ClassLoader dNf() {
        if (this.nJP == null) {
            this.nJP = getClass().getClassLoader();
        }
        return this.nJP;
    }

    String NQ(int i) {
        int i2 = 0;
        int indexOf = this.nKb.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nKb.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nKb.length();
        }
        return this.nKb.substring(i2, indexOf);
    }

    int NR(int i) {
        return Integer.parseInt(NQ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NS(int i) {
        return org.aspectj.a.b.b.b(NQ(i), dNf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NT(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NQ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dNf());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nKd;

        public b() {
            dNh();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dNg = dNg();
            if (dNg == null) {
                return null;
            }
            return dNg[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dNg = dNg();
            if (dNg == null) {
                dNg = dNh();
            }
            dNg[i] = str;
        }

        private String[] dNg() {
            return (String[]) this.nKd.get();
        }

        private String[] dNh() {
            String[] strArr = new String[3];
            this.nKd = new SoftReference(strArr);
            return strArr;
        }
    }
}
