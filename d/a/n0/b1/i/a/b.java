package d.a.n0.b1.i.a;

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
    public final RectF f52820c;

    /* renamed from: d  reason: collision with root package name */
    public final int f52821d;

    /* renamed from: e  reason: collision with root package name */
    public final int f52822e;

    /* renamed from: h  reason: collision with root package name */
    public final int f52825h;

    /* renamed from: i  reason: collision with root package name */
    public a f52826i;
    public final Rect j;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f52818a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f52819b = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public float f52823f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f52824g = new ArrayList();
    public final Matrix k = new Matrix();

    public b(int i2, int i3, int[] iArr) {
        this.f52822e = i3;
        this.f52821d = i2;
        this.f52820c = new RectF(0.0f, 0.0f, i2, i3);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.f52825h = i2 / 2;
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
            return j(i2, i3, i4).intersect(this.f52819b);
        }
        return false;
    }

    public a c() {
        return new a(this.f52825h);
    }

    public List<a> d() {
        return this.f52824g;
    }

    public int e() {
        return this.f52825h;
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
        return this.f52822e;
    }

    public int i() {
        return this.f52821d;
    }

    public Rect j(int i2, int i3, int i4) {
        int i5 = this.f52825h;
        int i6 = i5 * i4 * i3;
        int i7 = i5 * i4 * i2;
        return new Rect(i6, i7, (i4 * i5) + i6, (i4 * i5) + i7);
    }

    public int k() {
        int i2 = 1;
        while (i2 < Math.round(this.f52823f)) {
            i2 *= 2;
        }
        return i2;
    }

    public float l() {
        return this.f52823f;
    }

    public Point[] m() {
        o();
        int k = k();
        Rect rect = this.f52819b;
        int i2 = this.f52825h;
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
        return this.f52826i;
    }

    public Rect o() {
        this.k.mapRect(this.f52818a, this.f52820c);
        u(this.f52819b, this.f52818a);
        return this.f52819b;
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
        this.f52823f = f2;
    }

    public void t(Bitmap bitmap) {
        if (bitmap != null) {
            a aVar = new a(bitmap);
            this.f52826i = aVar;
            aVar.i(0, 0, this.f52821d, this.f52822e);
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }
}
