package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int ikw;
    ClassLoader iqi = null;
    String iqs;
    Class iqt;
    a iqu;
    private String iqv;
    String name;
    private static boolean dde = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iqw = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String yt(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ikw = -1;
        this.ikw = i;
        this.name = str;
        this.iqt = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dde) {
            if (this.iqu == null) {
                try {
                    this.iqu = new b();
                } catch (Throwable th) {
                    dde = false;
                }
            } else {
                str = this.iqu.yt(hVar.iqH);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dde) {
            this.iqu.set(hVar.iqH, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.iqJ);
    }

    public int getModifiers() {
        if (this.ikw == -1) {
            this.ikw = yq(0);
        }
        return this.ikw;
    }

    public String getName() {
        if (this.name == null) {
            this.name = yp(1);
        }
        return this.name;
    }

    public Class caA() {
        if (this.iqt == null) {
            this.iqt = yr(2);
        }
        return this.iqt;
    }

    public String caB() {
        if (this.iqs == null) {
            this.iqs = caA().getName();
        }
        return this.iqs;
    }

    private ClassLoader caC() {
        if (this.iqi == null) {
            this.iqi = getClass().getClassLoader();
        }
        return this.iqi;
    }

    String yp(int i) {
        int i2 = 0;
        int indexOf = this.iqv.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.iqv.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.iqv.length();
        }
        return this.iqv.substring(i2, indexOf);
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
        private SoftReference iqx;

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
            return (String[]) this.iqx.get();
        }

        private String[] caE() {
            String[] strArr = new String[3];
            this.iqx = new SoftReference(strArr);
            return strArr;
        }
    }
}
