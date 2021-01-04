package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes6.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pKP;
    ClassLoader qnk = null;
    String qnt;
    Class qnu;
    a qnv;
    private String qnw;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.pKP = -1;
        this.pKP = i;
        this.name = str;
        this.qnu = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qnv == null) {
                try {
                    this.qnv = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qnv.get(hVar.qnH);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qnv.set(hVar.qnH, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qnJ);
    }

    public int eMH() {
        if (this.pKP == -1) {
            this.pKP = Tu(0);
        }
        return this.pKP;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Tt(1);
        }
        return this.name;
    }

    public Class eMI() {
        if (this.qnu == null) {
            this.qnu = Tv(2);
        }
        return this.qnu;
    }

    public String eMJ() {
        if (this.qnt == null) {
            this.qnt = eMI().getName();
        }
        return this.qnt;
    }

    private ClassLoader eMK() {
        if (this.qnk == null) {
            this.qnk = getClass().getClassLoader();
        }
        return this.qnk;
    }

    String Tt(int i) {
        int i2 = 0;
        int indexOf = this.qnw.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qnw.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qnw.length();
        }
        return this.qnw.substring(i2, indexOf);
    }

    int Tu(int i) {
        return Integer.parseInt(Tt(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Tv(int i) {
        return org.aspectj.a.b.b.b(Tt(i), eMK());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Tw(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Tt(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eMK());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements a {
        private SoftReference qnx;

        public b() {
            eMM();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eML = eML();
            if (eML == null) {
                return null;
            }
            return eML[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eML = eML();
            if (eML == null) {
                eML = eMM();
            }
            eML[i] = str;
        }

        private String[] eML() {
            return (String[]) this.qnx.get();
        }

        private String[] eMM() {
            String[] strArr = new String[3];
            this.qnx = new SoftReference(strArr);
            return strArr;
        }
    }
}
