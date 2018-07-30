package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hFX;
    ClassLoader hJH = null;
    String hJS;
    Class hJT;
    a hJU;
    private String hJV;
    String name;
    private static boolean cOZ = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hJW = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String wg(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hFX = -1;
        this.hFX = i;
        this.name = str;
        this.hJT = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cOZ) {
            if (this.hJU == null) {
                try {
                    this.hJU = new b();
                } catch (Throwable th) {
                    cOZ = false;
                }
            } else {
                str = this.hJU.wg(hVar.hKh);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cOZ) {
            this.hJU.au(hVar.hKh, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hKj);
    }

    public int getModifiers() {
        if (this.hFX == -1) {
            this.hFX = wd(0);
        }
        return this.hFX;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wc(1);
        }
        return this.name;
    }

    public Class bKY() {
        if (this.hJT == null) {
            this.hJT = we(2);
        }
        return this.hJT;
    }

    public String bKZ() {
        if (this.hJS == null) {
            this.hJS = bKY().getName();
        }
        return this.hJS;
    }

    private ClassLoader bLa() {
        if (this.hJH == null) {
            this.hJH = getClass().getClassLoader();
        }
        return this.hJH;
    }

    String wc(int i) {
        int i2 = 0;
        int indexOf = this.hJV.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hJV.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hJV.length();
        }
        return this.hJV.substring(i2, indexOf);
    }

    int wd(int i) {
        return Integer.parseInt(wc(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class we(int i) {
        return org.aspectj.a.b.b.b(wc(i), bLa());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wf(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wc(i), SystemInfoUtil.COLON);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bLa());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hJX;

        public b() {
            bLc();
        }

        @Override // org.aspectj.a.b.f.a
        public String wg(int i) {
            String[] bLb = bLb();
            if (bLb == null) {
                return null;
            }
            return bLb[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void au(int i, String str) {
            String[] bLb = bLb();
            if (bLb == null) {
                bLb = bLc();
            }
            bLb[i] = str;
        }

        private String[] bLb() {
            return (String[]) this.hJX.get();
        }

        private String[] bLc() {
            String[] strArr = new String[3];
            this.hJX = new SoftReference(strArr);
            return strArr;
        }
    }
}
