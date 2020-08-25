package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes10.dex */
abstract class f implements org.aspectj.lang.c {
    int nCK;
    String name;
    ClassLoader oAc = null;
    String oAl;
    Class oAm;
    a oAn;
    private String oAo;
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
        this.nCK = -1;
        this.nCK = i;
        this.name = str;
        this.oAm = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.oAn == null) {
                try {
                    this.oAn = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.oAn.get(hVar.oAz);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.oAn.set(hVar.oAz, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.oAB);
    }

    public int eiS() {
        if (this.nCK == -1) {
            this.nCK = Oi(0);
        }
        return this.nCK;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Oh(1);
        }
        return this.name;
    }

    public Class eiT() {
        if (this.oAm == null) {
            this.oAm = Oj(2);
        }
        return this.oAm;
    }

    public String eiU() {
        if (this.oAl == null) {
            this.oAl = eiT().getName();
        }
        return this.oAl;
    }

    private ClassLoader eiV() {
        if (this.oAc == null) {
            this.oAc = getClass().getClassLoader();
        }
        return this.oAc;
    }

    String Oh(int i) {
        int i2 = 0;
        int indexOf = this.oAo.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.oAo.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.oAo.length();
        }
        return this.oAo.substring(i2, indexOf);
    }

    int Oi(int i) {
        return Integer.parseInt(Oh(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Oj(int i) {
        return org.aspectj.a.b.b.b(Oh(i), eiV());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ok(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Oh(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eiV());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b implements a {
        private SoftReference oAp;

        public b() {
            eiX();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eiW = eiW();
            if (eiW == null) {
                return null;
            }
            return eiW[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eiW = eiW();
            if (eiW == null) {
                eiW = eiX();
            }
            eiW[i] = str;
        }

        private String[] eiW() {
            return (String[]) this.oAp.get();
        }

        private String[] eiX() {
            String[] strArr = new String[3];
            this.oAp = new SoftReference(strArr);
            return strArr;
        }
    }
}
