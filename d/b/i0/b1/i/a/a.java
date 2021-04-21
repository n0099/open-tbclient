package d.b.i0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f50613a;

    /* renamed from: b  reason: collision with root package name */
    public final C1086a f50614b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f50615c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f50616d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f50617e;

    /* renamed from: f  reason: collision with root package name */
    public int f50618f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f50619g;

    /* renamed from: d.b.i0.b1.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1086a {

        /* renamed from: a  reason: collision with root package name */
        public int f50620a;

        /* renamed from: b  reason: collision with root package name */
        public int f50621b;

        /* renamed from: c  reason: collision with root package name */
        public int f50622c;

        public C1086a() {
        }

        public int a() {
            return this.f50621b;
        }

        public int b() {
            return this.f50620a;
        }

        public int c() {
            return this.f50622c;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1086a) {
                C1086a c1086a = (C1086a) obj;
                if (this.f50620a == c1086a.b() && this.f50621b == c1086a.a() && this.f50622c == c1086a.c()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((119 + this.f50620a) * 17) + this.f50621b) * 17) + (this.f50622c * 100);
        }

        public String toString() {
            return "Position{row=" + this.f50620a + ", column=" + this.f50621b + ", sampleScale=" + this.f50622c + '}';
        }

        public C1086a(int i, int i2, int i3) {
            this.f50620a = i;
            this.f50621b = i2;
            this.f50622c = i3;
        }
    }

    public a(int i) {
        this.f50614b = new C1086a();
        this.f50615c = new Rect();
        this.f50616d = new Rect();
        this.f50617e = new Rect();
        this.f50613a = Bitmap.createBitmap(i, i, TbConfig.BitmapConfig);
        this.f50618f = i;
        this.f50619g = new Canvas();
    }

    public void a() {
        Bitmap bitmap = this.f50613a;
        if (bitmap == null || bitmap.isRecycled() || !this.f50613a.isMutable()) {
            return;
        }
        this.f50619g.setBitmap(this.f50613a);
        this.f50619g.drawColor(-1, PorterDuff.Mode.CLEAR);
    }

    public Bitmap b() {
        return this.f50613a;
    }

    public Rect c() {
        return this.f50616d;
    }

    public C1086a d() {
        return this.f50614b;
    }

    public Rect e() {
        int i = this.f50618f;
        C1086a c1086a = this.f50614b;
        int i2 = c1086a.f50622c;
        int i3 = c1086a.f50621b * i * i2;
        int i4 = c1086a.f50620a * i * i2;
        this.f50617e.set(i3, i4, (i * i2) + i3, (i * i2) + i4);
        return this.f50617e;
    }

    public Rect f() {
        return this.f50615c;
    }

    public boolean g(Rect rect) {
        if (rect == null) {
            return false;
        }
        int i = rect.right - rect.left;
        int i2 = this.f50618f;
        return i == i2 && rect.bottom - rect.top == i2;
    }

    public void h(Bitmap bitmap) {
        this.f50613a = bitmap;
    }

    public void i(int i, int i2, int i3, int i4) {
        this.f50616d.set(i, i2, i3, i4);
    }

    public void j(int i, int i2, int i3) {
        C1086a c1086a = this.f50614b;
        c1086a.f50620a = i;
        c1086a.f50621b = i2;
        c1086a.f50622c = i3;
    }

    public void k(int i, int i2, int i3, int i4) {
        this.f50615c.set(i, i2, i3, i4);
    }

    public a(Bitmap bitmap) {
        this.f50614b = new C1086a();
        this.f50615c = new Rect();
        this.f50616d = new Rect();
        this.f50617e = new Rect();
        if (bitmap != null) {
            this.f50613a = bitmap;
            this.f50615c.set(0, 0, bitmap.getWidth(), this.f50613a.getHeight());
        }
        this.f50619g = new Canvas();
    }
}
