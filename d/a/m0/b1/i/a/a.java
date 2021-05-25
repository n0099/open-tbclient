package d.a.m0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f49027a;

    /* renamed from: b  reason: collision with root package name */
    public final C1108a f49028b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f49029c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f49030d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f49031e;

    /* renamed from: f  reason: collision with root package name */
    public int f49032f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f49033g;

    /* renamed from: d.a.m0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1108a {

        /* renamed from: a  reason: collision with root package name */
        public int f49034a;

        /* renamed from: b  reason: collision with root package name */
        public int f49035b;

        /* renamed from: c  reason: collision with root package name */
        public int f49036c;

        public C1108a() {
        }

        public int a() {
            return this.f49035b;
        }

        public int b() {
            return this.f49034a;
        }

        public int c() {
            return this.f49036c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1108a) {
                C1108a c1108a = (C1108a) obj;
                if (this.f49034a == c1108a.b() && this.f49035b == c1108a.a() && this.f49036c == c1108a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f49034a) * 17) + this.f49035b) * 17) + (this.f49036c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f49034a + ", column=" + this.f49035b + ", sampleScale=" + this.f49036c + '}';
        }

        public C1108a(int i2, int i3, int i4) {
            this.f49034a = i2;
            this.f49035b = i3;
            this.f49036c = i4;
        }
    }

    public a(int i2) {
        this.f49028b = new C1108a();
        this.f49029c = new Rect();
        this.f49030d = new Rect();
        this.f49031e = new Rect();
        this.f49027a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f49032f = i2;
        this.f49033g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f49027a;
        if (bitmap == null || bitmap.isRecycled() || !this.f49027a.isMutable()) {
            return;
        }
        this.f49033g.setBitmap(this.f49027a);
        this.f49033g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f49027a;
    }

    public Rect c() {
        return this.f49030d;
    }

    public C1108a d() {
        return this.f49028b;
    }

    public Rect e() {
        int i2 = this.f49032f;
        C1108a c1108a = this.f49028b;
        int i3 = c1108a.f49036c;
        int i4 = c1108a.f49035b * i2 * i3;
        int i5 = c1108a.f49034a * i2 * i3;
        this.f49031e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
        return this.f49031e;
    }

    public Rect f() {
        return this.f49029c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i2 = rect.right - rect.left;
        int i3 = this.f49032f;
        return i2 == i3 && rect.bottom - rect.top == i3;
    }

    public void h(Bitmap bitmap) {
        this.f49027a = bitmap;
    }

    public void i(int i2, int i3, int i4, int i5) {
        this.f49030d.set(i2, i3, i4, i5);
    }

    public void j(int i2, int i3, int i4) {
        C1108a c1108a = this.f49028b;
        c1108a.f49034a = i2;
        c1108a.f49035b = i3;
        c1108a.f49036c = i4;
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f49029c.set(i2, i3, i4, i5);
    }

    public a(Bitmap bitmap) {
        this.f49028b = new C1108a();
        this.f49029c = new Rect();
        this.f49030d = new Rect();
        this.f49031e = new Rect();
        if (bitmap != null) {
            this.f49027a = bitmap;
            this.f49029c.set(0, 0, bitmap.getWidth(), this.f49027a.getHeight());
        }
        this.f49033g = new Canvas();
    }
}
