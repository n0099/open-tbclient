package d.a.m0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f52701a;

    /* renamed from: b  reason: collision with root package name */
    public final C1164a f52702b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f52703c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f52704d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f52705e;

    /* renamed from: f  reason: collision with root package name */
    public int f52706f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f52707g;

    /* renamed from: d.a.m0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1164a {

        /* renamed from: a  reason: collision with root package name */
        public int f52708a;

        /* renamed from: b  reason: collision with root package name */
        public int f52709b;

        /* renamed from: c  reason: collision with root package name */
        public int f52710c;

        public C1164a() {
        }

        public int a() {
            return this.f52709b;
        }

        public int b() {
            return this.f52708a;
        }

        public int c() {
            return this.f52710c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1164a) {
                C1164a c1164a = (C1164a) obj;
                if (this.f52708a == c1164a.b() && this.f52709b == c1164a.a() && this.f52710c == c1164a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f52708a) * 17) + this.f52709b) * 17) + (this.f52710c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f52708a + ", column=" + this.f52709b + ", sampleScale=" + this.f52710c + '}';
        }

        public C1164a(int i2, int i3, int i4) {
            this.f52708a = i2;
            this.f52709b = i3;
            this.f52710c = i4;
        }
    }

    public a(int i2) {
        this.f52702b = new C1164a();
        this.f52703c = new Rect();
        this.f52704d = new Rect();
        this.f52705e = new Rect();
        this.f52701a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f52706f = i2;
        this.f52707g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f52701a;
        if (bitmap == null || bitmap.isRecycled() || !this.f52701a.isMutable()) {
            return;
        }
        this.f52707g.setBitmap(this.f52701a);
        this.f52707g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f52701a;
    }

    public Rect c() {
        return this.f52704d;
    }

    public C1164a d() {
        return this.f52702b;
    }

    public Rect e() {
        int i2 = this.f52706f;
        C1164a c1164a = this.f52702b;
        int i3 = c1164a.f52710c;
        int i4 = c1164a.f52709b * i2 * i3;
        int i5 = c1164a.f52708a * i2 * i3;
        this.f52705e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
        return this.f52705e;
    }

    public Rect f() {
        return this.f52703c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i2 = rect.right - rect.left;
        int i3 = this.f52706f;
        return i2 == i3 && rect.bottom - rect.top == i3;
    }

    public void h(Bitmap bitmap) {
        this.f52701a = bitmap;
    }

    public void i(int i2, int i3, int i4, int i5) {
        this.f52704d.set(i2, i3, i4, i5);
    }

    public void j(int i2, int i3, int i4) {
        C1164a c1164a = this.f52702b;
        c1164a.f52708a = i2;
        c1164a.f52709b = i3;
        c1164a.f52710c = i4;
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f52703c.set(i2, i3, i4, i5);
    }

    public a(Bitmap bitmap) {
        this.f52702b = new C1164a();
        this.f52703c = new Rect();
        this.f52704d = new Rect();
        this.f52705e = new Rect();
        if (bitmap != null) {
            this.f52701a = bitmap;
            this.f52703c.set(0, 0, bitmap.getWidth(), this.f52701a.getHeight());
        }
        this.f52707g = new Canvas();
    }
}
