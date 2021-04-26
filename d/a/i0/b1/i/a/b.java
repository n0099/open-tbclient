package d.a.i0.b1.i.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public final RectF f48186c;

    /* renamed from: d  reason: collision with root package name */
    public final int f48187d;

    /* renamed from: e  reason: collision with root package name */
    public final int f48188e;

    /* renamed from: h  reason: collision with root package name */
    public final int f48191h;

    /* renamed from: i  reason: collision with root package name */
    public a f48192i;
    public final Rect j;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f48184a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f48185b = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public float f48189f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f48190g = new ArrayList();
    public final Matrix k = new Matrix();

    public b(int i2, int i3, int[] iArr) {
        this.f48188e = i3;
        this.f48187d = i2;
        this.f48186c = new RectF(0.0f, 0.0f, i2, i3);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.f48191h = i2 / 2;
    }

    public void a(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        int i2 = rect.right;
        int i3 = this.j.right;
        if (i2 > i3) {
            rect.right = i3;
        }
        int i4 = rect.bottom;
        int i5 = this.j.bottom;
        if (i4 > i5) {
            rect.bottom = i5;
        }
    }

    public boolean b(int i2, int i3, int i4) {
        if (i4 == k()) {
            return j(i2, i3, i4).intersect(this.f48185b);
        }
        return false;
    }

    public a c() {
        return new a(this.f48191h);
    }

    public List<a> d() {
        return this.f48190g;
    }

    public int e() {
        return this.f48191h;
    }

    public Rect f() {
        return this.j;
    }

    public Rect g(a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    public int h() {
        return this.f48188e;
    }

    public int i() {
        return this.f48187d;
    }

    public Rect j(int i2, int i3, int i4) {
        int i5 = this.f48191h;
        int i6 = i5 * i4 * i3;
        int i7 = i5 * i4 * i2;
        return new Rect(i6, i7, (i4 * i5) + i6, (i4 * i5) + i7);
    }

    public int k() {
        int i2 = 1;
        while (i2 < Math.round(this.f48189f)) {
            i2 *= 2;
        }
        return i2;
    }

    public float l() {
        return this.f48189f;
    }

    public Point[] m() {
        o();
        int k = k();
        Rect rect = this.f48185b;
        int i2 = this.f48191h;
        int i3 = (rect.top / k) / i2;
        int i4 = (rect.left / k) / i2;
        Point point = new Point();
        point.y = i3;
        point.x = i4;
        Point point2 = new Point();
        point2.y = (((rect.bottom / k) / i2) * k) + 1;
        point2.x = (((rect.right / k) / i2) * k) + 1;
        return new Point[]{point, point2};
    }

    public a n() {
        return this.f48192i;
    }

    public Rect o() {
        this.k.mapRect(this.f48184a, this.f48186c);
        u(this.f48185b, this.f48184a);
        return this.f48185b;
    }

    public void p(float f2, float f3) {
        this.k.postTranslate(f2, f3);
    }

    public void q(float f2) {
        this.k.postScale(f2, f2);
    }

    public void r(float f2, float f3, float f4) {
        this.k.postScale(f2, f2, f3, f4);
    }

    public void s(float f2) {
        this.f48189f = f2;
    }

    public void t(Bitmap bitmap) {
        if (bitmap != null) {
            a aVar = new a(bitmap);
            this.f48192i = aVar;
            aVar.i(0, 0, this.f48187d, this.f48188e);
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }
}
