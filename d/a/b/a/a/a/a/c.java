package d.a.b.a.a.a.a;

import android.content.Context;
import com.baidu.ad.magic.flute.a.a.n;
import com.baidu.ad.magic.flute.a.a.q;
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    public static final int f42018d = a.a(24);

    /* renamed from: a  reason: collision with root package name */
    public h f42019a;

    /* renamed from: b  reason: collision with root package name */
    public e f42020b = new e();

    /* renamed from: c  reason: collision with root package name */
    public Context f42021c;

    public c(Context context) {
        this.f42021c = context;
        this.f42019a = new h(context);
    }

    public final int b(Object obj, Object obj2) {
        try {
            return this.f42019a.a(obj, obj2);
        } catch (q e2) {
            throw e2;
        } catch (Throwable th) {
            throw new com.baidu.ad.magic.flute.a.a.g(th);
        }
    }

    public i c(String str) {
        int i2 = -103;
        try {
            Object b2 = this.f42019a.b(this.f42021c);
            if (b2 == null) {
                e = new NullPointerException("gpm null error");
            } else {
                try {
                    return g(b2, str) == 1 ? i.a(-108) : d(f(b2, str));
                } catch (com.baidu.ad.magic.flute.a.a.g e2) {
                    e = e2;
                    i2 = -100;
                } catch (n e3) {
                    e = e3;
                    i2 = -104;
                } catch (q e4) {
                    e = e4;
                    i2 = -2;
                }
            }
            return i.b(i2, e);
        } catch (q e5) {
            return i.b(-103, e5);
        }
    }

    public final i d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return i.b(-101, null);
        }
        com.baidu.ad.magic.flute.a.a.c a2 = com.baidu.ad.magic.flute.a.a.c.a(bArr);
        if (a2 == null) {
            return i.b(-106, null);
        }
        long[] b2 = a2.b();
        return (b2 == null || b2.length == 0) ? i.b(-107, null) : i.c(d.a.b.a.a.e.a.b(b2[0]));
    }

    public final Object e(String str, int i2) {
        try {
            Class cls = this.f42019a.f42030c;
            return k.b(cls, new Object[]{str, this.f42020b.f42022a + i2});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new com.baidu.ad.magic.flute.a.a.g("");
        }
    }

    public final byte[] f(Object obj, String str) {
        g gVar = new g();
        for (int i2 = 0; i2 < f42018d; i2++) {
            gVar.b(f.a(b(obj, e(str, i2))));
        }
        return gVar.a().b();
    }

    public final int g(Object obj, String str) {
        new g();
        return b(obj, h(str));
    }

    public final Object h(String str) {
        try {
            return k.b(this.f42019a.f42030c, new Object[]{str, this.f42020b.f42023b});
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new com.baidu.ad.magic.flute.a.a.g("");
        }
    }
}
