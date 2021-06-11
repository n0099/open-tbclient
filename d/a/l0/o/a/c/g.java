package d.a.l0.o.a.c;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes3.dex */
public class g<E> implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f51981i = new Object();

    /* renamed from: e  reason: collision with root package name */
    public boolean f51982e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f51983f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f51984g;

    /* renamed from: h  reason: collision with root package name */
    public int f51985h;

    public g() {
        this(10);
    }

    public void b() {
        int i2 = this.f51985h;
        Object[] objArr = this.f51984g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f51985h = 0;
        this.f51982e = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public g<E> clone() {
        g<E> gVar = null;
        try {
            g<E> gVar2 = (g) super.clone();
            try {
                gVar2.f51983f = (int[]) this.f51983f.clone();
                gVar2.f51984g = (Object[]) this.f51984g.clone();
                return gVar2;
            } catch (CloneNotSupportedException unused) {
                gVar = gVar2;
                return gVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public final void d() {
        int i2 = this.f51985h;
        int[] iArr = this.f51983f;
        Object[] objArr = this.f51984g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f51981i) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f51982e = false;
        this.f51985h = i3;
    }

    public int e(int i2) {
        if (this.f51982e) {
            d();
        }
        return this.f51983f[i2];
    }

    public int f() {
        if (this.f51982e) {
            d();
        }
        return this.f51985h;
    }

    public E g(int i2) {
        if (this.f51982e) {
            d();
        }
        return (E) this.f51984g[i2];
    }

    public String toString() {
        if (f() <= 0) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(this.f51985h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f51985h; i2++) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(e(i2));
            sb.append(com.alipay.sdk.encrypt.a.f1886h);
            E g2 = g(i2);
            if (g2 != this) {
                sb.append(g2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public g(int i2) {
        this.f51982e = false;
        if (i2 == 0) {
            this.f51983f = b.f51957a;
            this.f51984g = b.f51958b;
        } else {
            int d2 = b.d(i2);
            this.f51983f = new int[d2];
            this.f51984g = new Object[d2];
        }
        this.f51985h = 0;
    }
}
