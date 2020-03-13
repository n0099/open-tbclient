package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mKC;
    ClassLoader nKa = null;
    String nKj;
    Class nKk;
    a nKl;
    private String nKm;
    String name;
    private static boolean fQU = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nKn = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mKC = -1;
        this.mKC = i;
        this.name = str;
        this.nKk = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fQU) {
            if (this.nKl == null) {
                try {
                    this.nKl = new b();
                } catch (Throwable th) {
                    fQU = false;
                }
            } else {
                str = this.nKl.get(hVar.nKy);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fQU) {
            this.nKl.set(hVar.nKy, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nKA);
    }

    public int dNd() {
        if (this.mKC == -1) {
            this.mKC = NR(0);
        }
        return this.mKC;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NQ(1);
        }
        return this.name;
    }

    public Class dNe() {
        if (this.nKk == null) {
            this.nKk = NS(2);
        }
        return this.nKk;
    }

    public String dNf() {
        if (this.nKj == null) {
            this.nKj = dNe().getName();
        }
        return this.nKj;
    }

    private ClassLoader dNg() {
        if (this.nKa == null) {
            this.nKa = getClass().getClassLoader();
        }
        return this.nKa;
    }

    String NQ(int i) {
        int i2 = 0;
        int indexOf = this.nKm.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nKm.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nKm.length();
        }
        return this.nKm.substring(i2, indexOf);
    }

    int NR(int i) {
        return Integer.parseInt(NQ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NS(int i) {
        return org.aspectj.a.b.b.b(NQ(i), dNg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NT(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NQ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dNg());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nKo;

        public b() {
            dNi();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dNh = dNh();
            if (dNh == null) {
                return null;
            }
            return dNh[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dNh = dNh();
            if (dNh == null) {
                dNh = dNi();
            }
            dNh[i] = str;
        }

        private String[] dNh() {
            return (String[]) this.nKo.get();
        }

        private String[] dNi() {
            String[] strArr = new String[3];
            this.nKo = new SoftReference(strArr);
            return strArr;
        }
    }
}
