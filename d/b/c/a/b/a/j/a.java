package d.b.c.a.b.a.j;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.b.c.a.a.i;
import d.b.c.a.a.k;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f69308e = {42};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f69309f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f69310g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    public static final a f69311h = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f69312a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f69313b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public byte[] f69314c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f69315d;

    public static a a() {
        return f69311h;
    }

    public static String c(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z2 = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z2) {
                    i4 = 46;
                    z = false;
                } else {
                    z = z2;
                    i4 = bArr2[i11][i12] & 255;
                }
                i5 = i4 - (bArr[i8 + i13] & 255);
                if (i5 == 0) {
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    } else if (bArr2[i11].length != i12) {
                        z2 = z;
                    } else if (i11 == bArr2.length - 1) {
                        break;
                    } else {
                        i11++;
                        z2 = true;
                        i12 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i14 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    while (true) {
                        i11++;
                        if (i11 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i11].length;
                    }
                    if (length2 >= i14) {
                        if (length2 <= i14) {
                            return new String(bArr, i8, i10, e.j);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i8 - 1;
        }
        return null;
    }

    public String b(String str) {
        int length;
        int length2;
        if (str != null) {
            String[] split = IDN.toUnicode(str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            String[] d2 = d(split);
            if (split.length != d2.length || d2[0].charAt(0) == '!') {
                if (d2[0].charAt(0) == '!') {
                    length = split.length;
                    length2 = d2.length;
                } else {
                    length = split.length;
                    length2 = d2.length + 1;
                }
                StringBuilder sb = new StringBuilder();
                String[] split2 = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                for (int i2 = length - length2; i2 < split2.length; i2++) {
                    sb.append(split2[i2]);
                    sb.append(IStringUtil.EXTENSION_SEPARATOR);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
            return null;
        }
        throw new NullPointerException("domain == null");
    }

    public final String[] d(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i2 = 0;
        if (!this.f69312a.get() && this.f69312a.compareAndSet(false, true)) {
            e();
        } else {
            try {
                this.f69313b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f69314c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(e.j);
        }
        int i4 = 0;
        while (true) {
            str = null;
            if (i4 >= length) {
                str2 = null;
                break;
            }
            str2 = c(this.f69314c, bArr, i4);
            if (str2 != null) {
                break;
            }
            i4++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                bArr2[i5] = f69308e;
                str3 = c(this.f69314c, bArr2, i5);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i2 >= length - 1) {
                    break;
                }
                String c2 = c(this.f69315d, bArr, i2);
                if (c2 != null) {
                    str = c2;
                    break;
                }
                i2++;
            }
        }
        if (str != null) {
            return ("!" + str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        } else if (str2 == null && str3 == null) {
            return f69310g;
        } else {
            String[] split = str2 != null ? str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f69309f;
            String[] split2 = str3 != null ? str3.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f69309f;
            return split.length > split2.length ? split : split2;
        }
    }

    public final void e() {
        boolean z = false;
        while (true) {
            try {
                try {
                    f();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e2) {
                    d.b.c.a.b.a.i.e.j().f(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final void f() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        d.b.c.a.a.e b2 = k.b(new i(k.e(resourceAsStream)));
        try {
            byte[] bArr = new byte[b2.j()];
            b2.a(bArr);
            byte[] bArr2 = new byte[b2.j()];
            b2.a(bArr2);
            synchronized (this) {
                this.f69314c = bArr;
                this.f69315d = bArr2;
            }
            this.f69313b.countDown();
        } finally {
            e.q(b2);
        }
    }
}
