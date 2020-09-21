package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int nMY;
    String name;
    ClassLoader oJZ = null;
    String oKi;
    Class oKj;
    a oKk;
    private String oKl;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.nMY = -1;
        this.nMY = i;
        this.name = str;
        this.oKj = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.oKk == null) {
                try {
                    this.oKk = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.oKk.get(hVar.oKw);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.oKk.set(hVar.oKw, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.oKy);
    }

    public int emY() {
        if (this.nMY == -1) {
            this.nMY = ON(0);
        }
        return this.nMY;
    }

    public String getName() {
        if (this.name == null) {
            this.name = OM(1);
        }
        return this.name;
    }

    public Class emZ() {
        if (this.oKj == null) {
            this.oKj = OO(2);
        }
        return this.oKj;
    }

    public String ena() {
        if (this.oKi == null) {
            this.oKi = emZ().getName();
        }
        return this.oKi;
    }

    private ClassLoader enb() {
        if (this.oJZ == null) {
            this.oJZ = getClass().getClassLoader();
        }
        return this.oJZ;
    }

    String OM(int i) {
        int i2 = 0;
        int indexOf = this.oKl.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.oKl.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.oKl.length();
        }
        return this.oKl.substring(i2, indexOf);
    }

    int ON(int i) {
        return Integer.parseInt(OM(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class OO(int i) {
        return org.aspectj.a.b.b.b(OM(i), enb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] OP(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(OM(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), enb());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference oKm;

        public b() {
            ene();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] enc = enc();
            if (enc == null) {
                return null;
            }
            return enc[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] enc = enc();
            if (enc == null) {
                enc = ene();
            }
            enc[i] = str;
        }

        private String[] enc() {
            return (String[]) this.oKm.get();
        }

        private String[] ene() {
            String[] strArr = new String[3];
            this.oKm = new SoftReference(strArr);
            return strArr;
        }
    }
}
