package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int ikv;
    ClassLoader iqh = null;
    String iqr;
    Class iqs;
    a iqt;
    private String iqu;
    String name;
    private static boolean dde = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iqv = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String yt(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ikv = -1;
        this.ikv = i;
        this.name = str;
        this.iqs = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dde) {
            if (this.iqt == null) {
                try {
                    this.iqt = new b();
                } catch (Throwable th) {
                    dde = false;
                }
            } else {
                str = this.iqt.yt(hVar.iqG);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dde) {
            this.iqt.set(hVar.iqG, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.iqI);
    }

    public int getModifiers() {
        if (this.ikv == -1) {
            this.ikv = yq(0);
        }
        return this.ikv;
    }

    public String getName() {
        if (this.name == null) {
            this.name = yp(1);
        }
        return this.name;
    }

    public Class caA() {
        if (this.iqs == null) {
            this.iqs = yr(2);
        }
        return this.iqs;
    }

    public String caB() {
        if (this.iqr == null) {
            this.iqr = caA().getName();
        }
        return this.iqr;
    }

    private ClassLoader caC() {
        if (this.iqh == null) {
            this.iqh = getClass().getClassLoader();
        }
        return this.iqh;
    }

    String yp(int i) {
        int i2 = 0;
        int indexOf = this.iqu.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.iqu.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.iqu.length();
        }
        return this.iqu.substring(i2, indexOf);
    }

    int yq(int i) {
        return Integer.parseInt(yp(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class yr(int i) {
        return org.aspectj.a.b.b.b(yp(i), caC());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] ys(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(yp(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), caC());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference iqw;

        public b() {
            caE();
        }

        @Override // org.aspectj.a.b.f.a
        public String yt(int i) {
            String[] caD = caD();
            if (caD == null) {
                return null;
            }
            return caD[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] caD = caD();
            if (caD == null) {
                caD = caE();
            }
            caD[i] = str;
        }

        private String[] caD() {
            return (String[]) this.iqw.get();
        }

        private String[] caE() {
            String[] strArr = new String[3];
            this.iqw = new SoftReference(strArr);
            return strArr;
        }
    }
}
