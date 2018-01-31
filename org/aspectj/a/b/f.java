package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader inQ = null;
    int ioa;
    String iob;
    Class ioc;
    a iod;
    private String ioe;
    String name;
    private static boolean djN = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] iof = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.ioa = -1;
        this.ioa = i;
        this.name = str;
        this.ioc = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (djN) {
            if (this.iod == null) {
                try {
                    this.iod = new b();
                } catch (Throwable th) {
                    djN = false;
                }
            } else {
                str = this.iod.zy(hVar.ioq);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (djN) {
            this.iod.au(hVar.ioq, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.ios);
    }

    public int getModifiers() {
        if (this.ioa == -1) {
            this.ioa = zv(0);
        }
        return this.ioa;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class bRM() {
        if (this.ioc == null) {
            this.ioc = zw(2);
        }
        return this.ioc;
    }

    public String bRN() {
        if (this.iob == null) {
            this.iob = bRM().getName();
        }
        return this.iob;
    }

    private ClassLoader bRO() {
        if (this.inQ == null) {
            this.inQ = getClass().getClassLoader();
        }
        return this.inQ;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.ioe.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.ioe.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.ioe.length();
        }
        return this.ioe.substring(i2, indexOf);
    }

    int zv(int i) {
        return Integer.parseInt(zu(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zw(int i) {
        return org.aspectj.a.b.b.b(zu(i), bRO());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zx(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zu(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bRO());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference iog;

        public b() {
            bRQ();
        }

        @Override // org.aspectj.a.b.f.a
        public String zy(int i) {
            String[] bRP = bRP();
            if (bRP == null) {
                return null;
            }
            return bRP[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void au(int i, String str) {
            String[] bRP = bRP();
            if (bRP == null) {
                bRP = bRQ();
            }
            bRP[i] = str;
        }

        private String[] bRP() {
            return (String[]) this.iog.get();
        }

        private String[] bRQ() {
            String[] strArr = new String[3];
            this.iog = new SoftReference(strArr);
            return strArr;
        }
    }
}
