package d.a.i0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f48174a;

    /* renamed from: b  reason: collision with root package name */
    public final C1025a f48175b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f48176c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f48177d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f48178e;

    /* renamed from: f  reason: collision with root package name */
    public int f48179f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f48180g;

    /* renamed from: d.a.i0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1025a {

        /* renamed from: a  reason: collision with root package name */
        public int f48181a;

        /* renamed from: b  reason: collision with root package name */
        public int f48182b;

        /* renamed from: c  reason: collision with root package name */
        public int f48183c;

        public C1025a() {
        }

        public int a() {
            return this.f48182b;
        }

        public int b() {
            return this.f48181a;
        }

        public int c() {
            return this.f48183c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1025a) {
                C1025a c1025a = (C1025a) obj;
                if (this.f48181a == c1025a.b() && this.f48182b == c1025a.a() && this.f48183c == c1025a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f48181a) * 17) + this.f48182b) * 17) + (this.f48183c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f48181a + ", column=" + this.f48182b + ", sampleScale=" + this.f48183c + '}';
        }

        public C1025a(int i2, int i3, int i4) {
            this.f48181a = i2;
            this.f48182b = i3;
            this.f48183c = i4;
        }
    }

    public a(int i2) {
        this.f48175b = new C1025a();
        this.f48176c = new Rect();
        this.f48177d = new Rect();
        this.f48178e = new Rect();
        this.f48174a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f48179f = i2;
        this.f48180g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f48174a;
        if (bitmap == null || bitmap.isRecycled() || !this.f48174a.isMutable()) {
            return;
        }
        this.f48180g.setBitmap(this.f48174a);
        this.f48180g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f48174a;
    }

    public Rect c() {
        return this.f48177d;
    }

    public C1025a d() {
        return this.f48175b;
    }

    public Rect e() {
        int i2 = this.f48179f;
        C1025a c1025a = this.f48175b;
        int i3 = c1025a.f48183c;
        int i4 = c1025a.f48182b * i2 * i3;
        int i5 = c1025a.f48181a * i2 * i3;
        this.f48178e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
        return this.f48178e;
    }

    public Rect f() {
        return this.f48176c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i2 = rect.right - rect.left;
        int i3 = this.f48179f;
        return i2 == i3 && rect.bottom - rect.top == i3;
    }

    public void h(Bitmap bitmap) {
        this.f48174a = bitmap;
    }

    public void i(int i2, int i3, int i4, int i5) {
        this.f48177d.set(i2, i3, i4, i5);
    }

    public void j(int i2, int i3, int i4) {
        C1025a c1025a = this.f48175b;
        c1025a.f48181a = i2;
        c1025a.f48182b = i3;
        c1025a.f48183c = i4;
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f48176c.set(i2, i3, i4, i5);
    }

    public a(Bitmap bitmap) {
        this.f48175b = new C1025a();
        this.f48176c = new Rect();
        this.f48177d = new Rect();
        this.f48178e = new Rect();
        if (bitmap != null) {
            this.f48174a = bitmap;
            this.f48176c.set(0, 0, bitmap.getWidth(), this.f48174a.getHeight());
        }
        this.f48180g = new Canvas();
    }
}
