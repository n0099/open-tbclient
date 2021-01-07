package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes4.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pMx;
    ClassLoader qoS = null;
    String qpb;
    Class qpc;
    a qpd;
    private String qpe;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.pMx = -1;
        this.pMx = i;
        this.name = str;
        this.qpc = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qpd == null) {
                try {
                    this.qpd = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qpd.get(hVar.qpp);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qpd.set(hVar.qpp, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qpr);
    }

    public int eNl() {
        if (this.pMx == -1) {
            this.pMx = TK(0);
        }
        return this.pMx;
    }

    public String getName() {
        if (this.name == null) {
            this.name = TJ(1);
        }
        return this.name;
    }

    public Class eNm() {
        if (this.qpc == null) {
            this.qpc = TL(2);
        }
        return this.qpc;
    }

    public String eNn() {
        if (this.qpb == null) {
            this.qpb = eNm().getName();
        }
        return this.qpb;
    }

    private ClassLoader eNo() {
        if (this.qoS == null) {
            this.qoS = getClass().getClassLoader();
        }
        return this.qoS;
    }

    String TJ(int i) {
        int i2 = 0;
        int indexOf = this.qpe.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qpe.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qpe.length();
        }
        return this.qpe.substring(i2, indexOf);
    }

    int TK(int i) {
        return Integer.parseInt(TJ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class TL(int i) {
        return org.aspectj.a.b.b.b(TJ(i), eNo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] TM(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(TJ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eNo());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements a {
        private SoftReference qpf;

        public b() {
            eNq();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eNp = eNp();
            if (eNp == null) {
                return null;
            }
            return eNp[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eNp = eNp();
            if (eNp == null) {
                eNp = eNq();
            }
            eNp[i] = str;
        }

        private String[] eNp() {
            return (String[]) this.qpf.get();
        }

        private String[] eNq() {
            String[] strArr = new String[3];
            this.qpf = new SoftReference(strArr);
            return strArr;
        }
    }
}
