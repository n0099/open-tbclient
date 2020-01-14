package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int mJK;
    ClassLoader nIY = null;
    String nJh;
    Class nJi;
    a nJj;
    private String nJk;
    String name;
    private static boolean fOk = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nJl = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mJK = -1;
        this.mJK = i;
        this.name = str;
        this.nJi = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fOk) {
            if (this.nJj == null) {
                try {
                    this.nJj = new b();
                } catch (Throwable th) {
                    fOk = false;
                }
            } else {
                str = this.nJj.get(hVar.nJw);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fOk) {
            this.nJj.set(hVar.nJw, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nJy);
    }

    public int dLN() {
        if (this.mJK == -1) {
            this.mJK = NO(0);
        }
        return this.mJK;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NN(1);
        }
        return this.name;
    }

    public Class dLO() {
        if (this.nJi == null) {
            this.nJi = NP(2);
        }
        return this.nJi;
    }

    public String dLP() {
        if (this.nJh == null) {
            this.nJh = dLO().getName();
        }
        return this.nJh;
    }

    private ClassLoader dLQ() {
        if (this.nIY == null) {
            this.nIY = getClass().getClassLoader();
        }
        return this.nIY;
    }

    String NN(int i) {
        int i2 = 0;
        int indexOf = this.nJk.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nJk.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nJk.length();
        }
        return this.nJk.substring(i2, indexOf);
    }

    int NO(int i) {
        return Integer.parseInt(NN(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NP(int i) {
        return org.aspectj.a.b.b.b(NN(i), dLQ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NQ(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NN(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dLQ());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference nJm;

        public b() {
            dLS();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dLR = dLR();
            if (dLR == null) {
                return null;
            }
            return dLR[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dLR = dLR();
            if (dLR == null) {
                dLR = dLS();
            }
            dLR[i] = str;
        }

        private String[] dLR() {
            return (String[]) this.nJm.get();
        }

        private String[] dLS() {
            String[] strArr = new String[3];
            this.nJm = new SoftReference(strArr);
            return strArr;
        }
    }
}
