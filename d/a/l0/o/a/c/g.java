package d.a.l0.o.a.c;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes3.dex */
public class g<E> implements Cloneable {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f48307i = new Object();

    /* renamed from: e  reason: collision with root package name */
    public boolean f48308e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f48309f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f48310g;

    /* renamed from: h  reason: collision with root package name */
    public int f48311h;

    public g() {
        this(10);
    }

    public void b() {
        int i2 = this.f48311h;
        Object[] objArr = this.f48310g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f48311h = 0;
        this.f48308e = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public g<E> clone() {
        g<E> gVar = null;
        try {
            g<E> gVar2 = (g) super.clone();
            try {
                gVar2.f48309f = (int[]) this.f48309f.clone();
                gVar2.f48310g = (Object[]) this.f48310g.clone();
                return gVar2;
            } catch (CloneNotSupportedException unused) {
                gVar = gVar2;
                return gVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public final void d() {
        int i2 = this.f48311h;
        int[] iArr = this.f48309f;
        Object[] objArr = this.f48310g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f48307i) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f48308e = false;
        this.f48311h = i3;
    }

    public int e(int i2) {
        if (this.f48308e) {
            d();
        }
        return this.f48309f[i2];
    }

    public int f() {
        if (this.f48308e) {
            d();
        }
        return this.f48311h;
    }

    public E g(int i2) {
        if (this.f48308e) {
            d();
        }
        return (E) this.f48310g[i2];
    }

    public String toString() {
        if (f() <= 0) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(this.f48311h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f48311h; i2++) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(e(i2));
            sb.append(com.alipay.sdk.encrypt.a.f1873h);
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
        this.f48308e = false;
        if (i2 == 0) {
            this.f48309f = b.f48283a;
            this.f48310g = b.f48284b;
        } else {
            int d2 = b.d(i2);
            this.f48309f = new int[d2];
            this.f48310g = new Object[d2];
        }
        this.f48311h = 0;
    }
}
