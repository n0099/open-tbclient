package d.b.i0.b1.i.a;

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
    public final RectF f50625c;

    /* renamed from: d  reason: collision with root package name */
    public final int f50626d;

    /* renamed from: e  reason: collision with root package name */
    public final int f50627e;

    /* renamed from: h  reason: collision with root package name */
    public final int f50630h;
    public a i;
    public final Rect j;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f50623a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f50624b = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public float f50628f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f50629g = new ArrayList();
    public final Matrix k = new Matrix();

    public b(int i, int i2, int[] iArr) {
        this.f50627e = i2;
        this.f50626d = i;
        this.f50625c = new RectF(0.0f, 0.0f, i, i2);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.f50630h = i / 2;
    }

    public void a(Rect rect) {
        if (rect.left < 0) {
            rect.left = 0;
        }
        if (rect.top < 0) {
            rect.top = 0;
        }
        int i = rect.right;
        int i2 = this.j.right;
        if (i > i2) {
            rect.right = i2;
        }
        int i3 = rect.bottom;
        int i4 = this.j.bottom;
        if (i3 > i4) {
            rect.bottom = i4;
        }
    }

    public boolean b(int i, int i2, int i3) {
        if (i3 == k()) {
            return j(i, i2, i3).intersect(this.f50624b);
        }
        return false;
    }

    public a c() {
        return new a(this.f50630h);
    }

    public List<a> d() {
        return this.f50629g;
    }

    public int e() {
        return this.f50630h;
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
        return this.f50627e;
    }

    public int i() {
        return this.f50626d;
    }

    public Rect j(int i, int i2, int i3) {
        int i4 = this.f50630h;
        int i5 = i4 * i3 * i2;
        int i6 = i4 * i3 * i;
        return new Rect(i5, i6, (i3 * i4) + i5, (i3 * i4) + i6);
    }

    public int k() {
        int i = 1;
        while (i < Math.round(this.f50628f)) {
            i *= 2;
        }
        return i;
    }

    public float l() {
        return this.f50628f;
    }

    public Point[] m() {
        o();
        int k = k();
        Rect rect = this.f50624b;
        int i = this.f50630h;
        int i2 = (rect.top / k) / i;
        int i3 = (rect.left / k) / i;
        Point point = new Point();
        point.y = i2;
        point.x = i3;
        Point point2 = new Point();
        point2.y = (((rect.bottom / k) / i) * k) + 1;
        point2.x = (((rect.right / k) / i) * k) + 1;
        return new Point[]{point, point2};
    }

    public a n() {
        return this.i;
    }

    public Rect o() {
        this.k.mapRect(this.f50623a, this.f50625c);
        u(this.f50624b, this.f50623a);
        return this.f50624b;
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
        this.f50628f = f2;
    }

    public void t(Bitmap bitmap) {
        if (bitmap != null) {
            a aVar = new a(bitmap);
            this.i = aVar;
            aVar.i(0, 0, this.f50626d, this.f50627e);
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }
}
