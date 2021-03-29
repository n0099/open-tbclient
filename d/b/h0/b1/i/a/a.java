package d.b.h0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f49884a;

    /* renamed from: b  reason: collision with root package name */
    public final C1052a f49885b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f49886c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f49887d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f49888e;

    /* renamed from: f  reason: collision with root package name */
    public int f49889f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f49890g;

    /* renamed from: d.b.h0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1052a {

        /* renamed from: a  reason: collision with root package name */
        public int f49891a;

        /* renamed from: b  reason: collision with root package name */
        public int f49892b;

        /* renamed from: c  reason: collision with root package name */
        public int f49893c;

        public C1052a() {
        }

        public int a() {
            return this.f49892b;
        }

        public int b() {
            return this.f49891a;
        }

        public int c() {
            return this.f49893c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1052a) {
                C1052a c1052a = (C1052a) obj;
                if (this.f49891a == c1052a.b() && this.f49892b == c1052a.a() && this.f49893c == c1052a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f49891a) * 17) + this.f49892b) * 17) + (this.f49893c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f49891a + ", column=" + this.f49892b + ", sampleScale=" + this.f49893c + '}';
        }

        public C1052a(int i, int i2, int i3) {
            this.f49891a = i;
            this.f49892b = i2;
            this.f49893c = i3;
        }
    }

    public a(int i) {
        this.f49885b = new C1052a();
        this.f49886c = new Rect();
        this.f49887d = new Rect();
        this.f49888e = new Rect();
        this.f49884a = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.f49889f = i;
        this.f49890g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f49884a;
        if (bitmap == null || bitmap.isRecycled() || !this.f49884a.isMutable()) {
            return;
        }
        this.f49890g.setBitmap(this.f49884a);
        this.f49890g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f49884a;
    }

    public Rect c() {
        return this.f49887d;
    }

    public C1052a d() {
        return this.f49885b;
    }

    public Rect e() {
        int i = this.f49889f;
        C1052a c1052a = this.f49885b;
        int i2 = c1052a.f49893c;
        int i3 = c1052a.f49892b * i * i2;
        int i4 = c1052a.f49891a * i * i2;
        this.f49888e.set(i3, i4, (i * i2) + i3, (i * i2) + i4);
        return this.f49888e;
    }

    public Rect f() {
        return this.f49886c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i = rect.right - rect.left;
        int i2 = this.f49889f;
        return i == i2 && rect.bottom - rect.top == i2;
    }

    public void h(Bitmap bitmap) {
        this.f49884a = bitmap;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.f49887d.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3) {
        C1052a c1052a = this.f49885b;
        c1052a.f49891a = i;
        c1052a.f49892b = i2;
        c1052a.f49893c = i3;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f49886c.set(i, i2, i3, i4);
    }

    public a(Bitmap bitmap) {
        this.f49885b = new C1052a();
        this.f49886c = new Rect();
        this.f49887d = new Rect();
        this.f49888e = new Rect();
        if (bitmap != null) {
            this.f49884a = bitmap;
            this.f49886c.set(0, 0, bitmap.getWidth(), this.f49884a.getHeight());
        }
        this.f49890g = new Canvas();
    }
}
