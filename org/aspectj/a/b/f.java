package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes10.dex */
abstract class f implements org.aspectj.lang.c {
    int nDc;
    String name;
    String oAD;
    Class oAE;
    a oAF;
    private String oAG;
    ClassLoader oAu = null;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.nDc = -1;
        this.nDc = i;
        this.name = str;
        this.oAE = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.oAF == null) {
                try {
                    this.oAF = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.oAF.get(hVar.oAR);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.oAF.set(hVar.oAR, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.oAT);
    }

    public int ejb() {
        if (this.nDc == -1) {
            this.nDc = Oi(0);
        }
        return this.nDc;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Oh(1);
        }
        return this.name;
    }

    public Class ejc() {
        if (this.oAE == null) {
            this.oAE = Oj(2);
        }
        return this.oAE;
    }

    public String ejd() {
        if (this.oAD == null) {
            this.oAD = ejc().getName();
        }
        return this.oAD;
    }

    private ClassLoader eje() {
        if (this.oAu == null) {
            this.oAu = getClass().getClassLoader();
        }
        return this.oAu;
    }

    String Oh(int i) {
        int i2 = 0;
        int indexOf = this.oAG.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.oAG.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.oAG.length();
        }
        return this.oAG.substring(i2, indexOf);
    }

    int Oi(int i) {
        return Integer.parseInt(Oh(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Oj(int i) {
        return org.aspectj.a.b.b.b(Oh(i), eje());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ok(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Oh(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eje());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b implements a {
        private SoftReference oAH;

        public b() {
            ejg();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] ejf = ejf();
            if (ejf == null) {
                return null;
            }
            return ejf[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] ejf = ejf();
            if (ejf == null) {
                ejf = ejg();
            }
            ejf[i] = str;
        }

        private String[] ejf() {
            return (String[]) this.oAH.get();
        }

        private String[] ejg() {
            String[] strArr = new String[3];
            this.oAH = new SoftReference(strArr);
            return strArr;
        }
    }
}
