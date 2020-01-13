package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int mJF;
    ClassLoader nIT = null;
    String nJc;
    Class nJd;
    a nJe;
    private String nJf;
    String name;
    private static boolean fOk = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nJg = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mJF = -1;
        this.mJF = i;
        this.name = str;
        this.nJd = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fOk) {
            if (this.nJe == null) {
                try {
                    this.nJe = new b();
                } catch (Throwable th) {
                    fOk = false;
                }
            } else {
                str = this.nJe.get(hVar.nJr);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fOk) {
            this.nJe.set(hVar.nJr, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nJt);
    }

    public int dLL() {
        if (this.mJF == -1) {
            this.mJF = NO(0);
        }
        return this.mJF;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NN(1);
        }
        return this.name;
    }

    public Class dLM() {
        if (this.nJd == null) {
            this.nJd = NP(2);
        }
        return this.nJd;
    }

    public String dLN() {
        if (this.nJc == null) {
            this.nJc = dLM().getName();
        }
        return this.nJc;
    }

    private ClassLoader dLO() {
        if (this.nIT == null) {
            this.nIT = getClass().getClassLoader();
        }
        return this.nIT;
    }

    String NN(int i) {
        int i2 = 0;
        int indexOf = this.nJf.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nJf.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nJf.length();
        }
        return this.nJf.substring(i2, indexOf);
    }

    int NO(int i) {
        return Integer.parseInt(NN(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NP(int i) {
        return org.aspectj.a.b.b.b(NN(i), dLO());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NQ(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NN(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dLO());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference nJh;

        public b() {
            dLQ();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dLP = dLP();
            if (dLP == null) {
                return null;
            }
            return dLP[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dLP = dLP();
            if (dLP == null) {
                dLP = dLQ();
            }
            dLP[i] = str;
        }

        private String[] dLP() {
            return (String[]) this.nJh.get();
        }

        private String[] dLQ() {
            String[] strArr = new String[3];
            this.nJh = new SoftReference(strArr);
            return strArr;
        }
    }
}
