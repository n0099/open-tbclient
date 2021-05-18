package d.a.j0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f49002a;

    /* renamed from: b  reason: collision with root package name */
    public final C1101a f49003b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f49004c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f49005d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f49006e;

    /* renamed from: f  reason: collision with root package name */
    public int f49007f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f49008g;

    /* renamed from: d.a.j0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1101a {

        /* renamed from: a  reason: collision with root package name */
        public int f49009a;

        /* renamed from: b  reason: collision with root package name */
        public int f49010b;

        /* renamed from: c  reason: collision with root package name */
        public int f49011c;

        public C1101a() {
        }

        public int a() {
            return this.f49010b;
        }

        public int b() {
            return this.f49009a;
        }

        public int c() {
            return this.f49011c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1101a) {
                C1101a c1101a = (C1101a) obj;
                if (this.f49009a == c1101a.b() && this.f49010b == c1101a.a() && this.f49011c == c1101a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f49009a) * 17) + this.f49010b) * 17) + (this.f49011c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f49009a + ", column=" + this.f49010b + ", sampleScale=" + this.f49011c + '}';
        }

        public C1101a(int i2, int i3, int i4) {
            this.f49009a = i2;
            this.f49010b = i3;
            this.f49011c = i4;
        }
    }

    public a(int i2) {
        this.f49003b = new C1101a();
        this.f49004c = new Rect();
        this.f49005d = new Rect();
        this.f49006e = new Rect();
        this.f49002a = Bitmap.createBitmap(i2, i2, TbConfig.BitmapConfig);
        this.f49007f = i2;
        this.f49008g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f49002a;
        if (bitmap == null || bitmap.isRecycled() || !this.f49002a.isMutable()) {
            return;
        }
        this.f49008g.setBitmap(this.f49002a);
        this.f49008g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f49002a;
    }

    public Rect c() {
        return this.f49005d;
    }

    public C1101a d() {
        return this.f49003b;
    }

    public Rect e() {
        int i2 = this.f49007f;
        C1101a c1101a = this.f49003b;
        int i3 = c1101a.f49011c;
        int i4 = c1101a.f49010b * i2 * i3;
        int i5 = c1101a.f49009a * i2 * i3;
        this.f49006e.set(i4, i5, (i2 * i3) + i4, (i2 * i3) + i5);
        return this.f49006e;
    }

    public Rect f() {
        return this.f49004c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i2 = rect.right - rect.left;
        int i3 = this.f49007f;
        return i2 == i3 && rect.bottom - rect.top == i3;
    }

    public void h(Bitmap bitmap) {
        this.f49002a = bitmap;
    }

    public void i(int i2, int i3, int i4, int i5) {
        this.f49005d.set(i2, i3, i4, i5);
    }

    public void j(int i2, int i3, int i4) {
        C1101a c1101a = this.f49003b;
        c1101a.f49009a = i2;
        c1101a.f49010b = i3;
        c1101a.f49011c = i4;
    }

    public void k(int i2, int i3, int i4, int i5) {
        this.f49004c.set(i2, i3, i4, i5);
    }

    public a(Bitmap bitmap) {
        this.f49003b = new C1101a();
        this.f49004c = new Rect();
        this.f49005d = new Rect();
        this.f49006e = new Rect();
        if (bitmap != null) {
            this.f49002a = bitmap;
            this.f49004c.set(0, 0, bitmap.getWidth(), this.f49002a.getHeight());
        }
        this.f49008g = new Canvas();
    }
}
