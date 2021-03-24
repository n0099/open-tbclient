package d.b.g0.m.a.c;

import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes3.dex */
public class g<E> implements Cloneable {
    public static final Object i = new Object();

    /* renamed from: e  reason: collision with root package name */
    public boolean f49167e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f49168f;

    /* renamed from: g  reason: collision with root package name */
    public Object[] f49169g;

    /* renamed from: h  reason: collision with root package name */
    public int f49170h;

    public g() {
        this(10);
    }

    public void b() {
        int i2 = this.f49170h;
        Object[] objArr = this.f49169g;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f49170h = 0;
        this.f49167e = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public g<E> clone() {
        g<E> gVar = null;
        try {
            g<E> gVar2 = (g) super.clone();
            try {
                gVar2.f49168f = (int[]) this.f49168f.clone();
                gVar2.f49169g = (Object[]) this.f49169g.clone();
                return gVar2;
            } catch (CloneNotSupportedException unused) {
                gVar = gVar2;
                return gVar;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public final void d() {
        int i2 = this.f49170h;
        int[] iArr = this.f49168f;
        Object[] objArr = this.f49169g;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != i) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f49167e = false;
        this.f49170h = i3;
    }

    public int e(int i2) {
        if (this.f49167e) {
            d();
        }
        return this.f49168f[i2];
    }

    public int f() {
        if (this.f49167e) {
            d();
        }
        return this.f49170h;
    }

    public E g(int i2) {
        if (this.f49167e) {
            d();
        }
        return (E) this.f49169g[i2];
    }

    public String toString() {
        if (f() <= 0) {
            return StringUtil.EMPTY_ARRAY;
        }
        StringBuilder sb = new StringBuilder(this.f49170h * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f49170h; i2++) {
            if (i2 > 0) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            sb.append(e(i2));
            sb.append(com.alipay.sdk.encrypt.a.f1897h);
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
        this.f49167e = false;
        if (i2 == 0) {
            this.f49168f = b.f49145a;
            this.f49169g = b.f49146b;
        } else {
            int d2 = b.d(i2);
            this.f49168f = new int[d2];
            this.f49169g = new Object[d2];
        }
        this.f49170h = 0;
    }
}
