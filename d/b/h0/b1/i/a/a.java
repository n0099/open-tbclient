package d.b.h0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f50277a;

    /* renamed from: b  reason: collision with root package name */
    public final C1064a f50278b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f50279c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f50280d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f50281e;

    /* renamed from: f  reason: collision with root package name */
    public int f50282f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f50283g;

    /* renamed from: d.b.h0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1064a {

        /* renamed from: a  reason: collision with root package name */
        public int f50284a;

        /* renamed from: b  reason: collision with root package name */
        public int f50285b;

        /* renamed from: c  reason: collision with root package name */
        public int f50286c;

        public C1064a() {
        }

        public int a() {
            return this.f50285b;
        }

        public int b() {
            return this.f50284a;
        }

        public int c() {
            return this.f50286c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1064a) {
                C1064a c1064a = (C1064a) obj;
                if (this.f50284a == c1064a.b() && this.f50285b == c1064a.a() && this.f50286c == c1064a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f50284a) * 17) + this.f50285b) * 17) + (this.f50286c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f50284a + ", column=" + this.f50285b + ", sampleScale=" + this.f50286c + '}';
        }

        public C1064a(int i, int i2, int i3) {
            this.f50284a = i;
            this.f50285b = i2;
            this.f50286c = i3;
        }
    }

    public a(int i) {
        this.f50278b = new C1064a();
        this.f50279c = new Rect();
        this.f50280d = new Rect();
        this.f50281e = new Rect();
        this.f50277a = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.f50282f = i;
        this.f50283g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f50277a;
        if (bitmap == null || bitmap.isRecycled() || !this.f50277a.isMutable()) {
            return;
        }
        this.f50283g.setBitmap(this.f50277a);
        this.f50283g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f50277a;
    }

    public Rect c() {
        return this.f50280d;
    }

    public C1064a d() {
        return this.f50278b;
    }

    public Rect e() {
        int i = this.f50282f;
        C1064a c1064a = this.f50278b;
        int i2 = c1064a.f50286c;
        int i3 = c1064a.f50285b * i * i2;
        int i4 = c1064a.f50284a * i * i2;
        this.f50281e.set(i3, i4, (i * i2) + i3, (i * i2) + i4);
        return this.f50281e;
    }

    public Rect f() {
        return this.f50279c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i = rect.right - rect.left;
        int i2 = this.f50282f;
        return i == i2 && rect.bottom - rect.top == i2;
    }

    public void h(Bitmap bitmap) {
        this.f50277a = bitmap;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.f50280d.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3) {
        C1064a c1064a = this.f50278b;
        c1064a.f50284a = i;
        c1064a.f50285b = i2;
        c1064a.f50286c = i3;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f50279c.set(i, i2, i3, i4);
    }

    public a(Bitmap bitmap) {
        this.f50278b = new C1064a();
        this.f50279c = new Rect();
        this.f50280d = new Rect();
        this.f50281e = new Rect();
        if (bitmap != null) {
            this.f50277a = bitmap;
            this.f50279c.set(0, 0, bitmap.getWidth(), this.f50277a.getHeight());
        }
        this.f50283g = new Canvas();
    }
}
