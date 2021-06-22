package d.a.n0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f52808a;

    /* renamed from: b  reason: collision with root package name */
    public final C1167a f52809b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f52810c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f52811d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f52812e;

    /* renamed from: f  reason: collision with root package name */
    public int f52813f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f52814g;

    /* renamed from: d.a.n0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1167a {

        /* renamed from: a  reason: collision with root package name */
        public int f52815a;

        /* renamed from: b  reason: collision with root package name */
        public int f52816b;

        /* renamed from: c  reason: collision with root package name */
        public int f52817c;

        public C1167a() {
        }

        public int a() {
            return this.f52816b;
        }

        public int b() {
            return this.f52815a;
        }

        public int c() {
            return this.f52817c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1167a) {
                C1167a c1167a = (C1167a) obj;
                if (this.f52815a == c1167a.b() && this.f52816b == c1167a.a() && this.f52817c == c1167a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f52815a) * 17) + this.f52816b) * 17) + (this.f52817c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f52815a + ", column=" + this.f52816b + ", sampleScale=" + this.f52817c + '}';
        }

        public C1167a(int i2, int i3, int i4) {
            this.f52815a = i2;
            this.f52816b = i3;
            this.f52817c = i4;
        }
    }

    public a(int i2) {
        this.f52809b = new C1167a();
        this.f52810c = new Rect();
        this.f52811d = new Rect();
        this.f52812e = new Rect();
        this.f52808a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f52813f = i2;
        this.f52814g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f52808a;
        if (bitmap == null || bitmap.isRecycled() || !this.f52808a.isMutable()) {
            return;
        }
        this.f52814g.setBitmap(this.f52808a);
        this.f52814g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f52808a;
    }

    public Rect c() {
        return this.f52811d;
    }

    public C1167a d() {
        return this.f52809b;
    }

    public Rect e() {
        int i2 = this.f52813f;
        C1167a c1167a = this.f52809b;
        int i3 = c1167a.f52817c;
        int i4 = c1167a.f52816b * i2 * i3;
        int i5 = c1167a.f52815a * i2 * i3;
        this.f52812e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
        return this.f52812e;
    }

    public Rect f() {
        return this.f52810c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i2 = rect.right - rect.left;
        int i3 = this.f52813f;
        return i2 == i3 && rect.bottom - rect.top == i3;
    }

    public void h(Bitmap bitmap) {
        this.f52808a = bitmap;
    }

    public void i(int i2, int i3, int i4, int i5) {
        this.f52811d.set(i2, i3, i4, i5);
    }

    public void j(int i2, int i3, int i4) {
        C1167a c1167a = this.f52809b;
        c1167a.f52815a = i2;
        c1167a.f52816b = i3;
        c1167a.f52817c = i4;
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f52810c.set(i2, i3, i4, i5);
    }

    public a(Bitmap bitmap) {
        this.f52809b = new C1167a();
        this.f52810c = new Rect();
        this.f52811d = new Rect();
        this.f52812e = new Rect();
        if (bitmap != null) {
            this.f52808a = bitmap;
            this.f52810c.set(0, 0, bitmap.getWidth(), this.f52808a.getHeight());
        }
        this.f52814g = new Canvas();
    }
}
