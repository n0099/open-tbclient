package d.c.c.a.b.a.j;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.c.c.a.a.i;
import d.c.c.a.a.k;
import d.c.c.a.b.a.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f65418e = {ExifInterface.START_CODE};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f65419f = new String[0];

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f65420g = {"*"};

    /* renamed from: h  reason: collision with root package name */
    public static final a f65421h = new a();

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f65422a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final CountDownLatch f65423b = new CountDownLatch(1);

    /* renamed from: c  reason: collision with root package name */
    public byte[] f65424c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f65425d;

    public static a a() {
        return f65421h;
    }

    public static String c(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else if (i10 == bArr2.length - 1) {
                        break;
                    } else {
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, e.j);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
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
                for (int i = length - length2; i < split2.length; i++) {
                    sb.append(split2[i]);
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
        int i = 0;
        if (!this.f65422a.get() && this.f65422a.compareAndSet(false, true)) {
            e();
        } else {
            try {
                this.f65423b.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.f65424c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(e.j);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = c(this.f65424c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f65418e;
                str3 = c(this.f65424c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String c2 = c(this.f65425d, bArr, i);
                if (c2 != null) {
                    str = c2;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        } else if (str2 == null && str3 == null) {
            return f65420g;
        } else {
            String[] split = str2 != null ? str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f65419f;
            String[] split2 = str3 != null ? str3.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX) : f65419f;
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
                    d.c.c.a.b.a.i.e.j().f(5, "Failed to read public suffix list", e2);
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
        d.c.c.a.a.e b2 = k.b(new i(k.e(resourceAsStream)));
        try {
            byte[] bArr = new byte[b2.j()];
            b2.a(bArr);
            byte[] bArr2 = new byte[b2.j()];
            b2.a(bArr2);
            synchronized (this) {
                this.f65424c = bArr;
                this.f65425d = bArr2;
            }
            this.f65423b.countDown();
        } finally {
            e.q(b2);
        }
    }
}
