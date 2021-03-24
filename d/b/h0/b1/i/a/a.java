package d.b.h0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f49883a;

    /* renamed from: b  reason: collision with root package name */
    public final C1051a f49884b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f49885c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f49886d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f49887e;

    /* renamed from: f  reason: collision with root package name */
    public int f49888f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f49889g;

    /* renamed from: d.b.h0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1051a {

        /* renamed from: a  reason: collision with root package name */
        public int f49890a;

        /* renamed from: b  reason: collision with root package name */
        public int f49891b;

        /* renamed from: c  reason: collision with root package name */
        public int f49892c;

        public C1051a() {
        }

        public int a() {
            return this.f49891b;
        }

        public int b() {
            return this.f49890a;
        }

        public int c() {
            return this.f49892c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1051a) {
                C1051a c1051a = (C1051a) obj;
                if (this.f49890a == c1051a.b() && this.f49891b == c1051a.a() && this.f49892c == c1051a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f49890a) * 17) + this.f49891b) * 17) + (this.f49892c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f49890a + ", column=" + this.f49891b + ", sampleScale=" + this.f49892c + '}';
        }

        public C1051a(int i, int i2, int i3) {
            this.f49890a = i;
            this.f49891b = i2;
            this.f49892c = i3;
        }
    }

    public a(int i) {
        this.f49884b = new C1051a();
        this.f49885c = new Rect();
        this.f49886d = new Rect();
        this.f49887e = new Rect();
        this.f49883a = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.f49888f = i;
        this.f49889g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f49883a;
        if (bitmap == null || bitmap.isRecycled() || !this.f49883a.isMutable()) {
            return;
        }
        this.f49889g.setBitmap(this.f49883a);
        this.f49889g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f49883a;
    }

    public Rect c() {
        return this.f49886d;
    }

    public C1051a d() {
        return this.f49884b;
    }

    public Rect e() {
        int i = this.f49888f;
        C1051a c1051a = this.f49884b;
        int i2 = c1051a.f49892c;
        int i3 = c1051a.f49891b * i * i2;
        int i4 = c1051a.f49890a * i * i2;
        this.f49887e.set(i3, i4, (i * i2) + i3, (i * i2) + i4);
        return this.f49887e;
    }

    public Rect f() {
        return this.f49885c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i = rect.right - rect.left;
        int i2 = this.f49888f;
        return i == i2 && rect.bottom - rect.top == i2;
    }

    public void h(Bitmap bitmap) {
        this.f49883a = bitmap;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.f49886d.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3) {
        C1051a c1051a = this.f49884b;
        c1051a.f49890a = i;
        c1051a.f49891b = i2;
        c1051a.f49892c = i3;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f49885c.set(i, i2, i3, i4);
    }

    public a(Bitmap bitmap) {
        this.f49884b = new C1051a();
        this.f49885c = new Rect();
        this.f49886d = new Rect();
        this.f49887e = new Rect();
        if (bitmap != null) {
            this.f49883a = bitmap;
            this.f49885c.set(0, 0, bitmap.getWidth(), this.f49883a.getHeight());
        }
        this.f49889g = new Canvas();
    }
}
