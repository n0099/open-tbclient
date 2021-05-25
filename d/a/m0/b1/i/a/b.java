package d.a.m0.b1.i.a;

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
    public final RectF f49039c;

    /* renamed from: d  reason: collision with root package name */
    public final int f49040d;

    /* renamed from: e  reason: collision with root package name */
    public final int f49041e;

    /* renamed from: h  reason: collision with root package name */
    public final int f49044h;

    /* renamed from: i  reason: collision with root package name */
    public a f49045i;
    public final Rect j;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f49037a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f49038b = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public float f49042f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f49043g = new ArrayList();
    public final Matrix k = new Matrix();

    public b(int i2, int i3, int[] iArr) {
        this.f49041e = i3;
        this.f49040d = i2;
        this.f49039c = new RectF(0.0f, 0.0f, i2, i3);
        this.j = new Rect(0, 0, iArr[0], iArr[1]);
        this.f49044h = i2 / 2;
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
            return j(i2, i3, i4).intersect(this.f49038b);
        }
        return false;
    }

    public a c() {
        return new a(this.f49044h);
    }

    public List<a> d() {
        return this.f49043g;
    }

    public int e() {
        return this.f49044h;
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
        return this.f49041e;
    }

    public int i() {
        return this.f49040d;
    }

    public Rect j(int i2, int i3, int i4) {
        int i5 = this.f49044h;
        int i6 = i5 * i4 * i3;
        int i7 = i5 * i4 * i2;
        return new Rect(i6, i7, (i4 * i5) + i6, (i4 * i5) + i7);
    }

    public int k() {
        int i2 = 1;
        while (i2 < Math.round(this.f49042f)) {
            i2 *= 2;
        }
        return i2;
    }

    public float l() {
        return this.f49042f;
    }

    public Point[] m() {
        o();
        int k = k();
        Rect rect = this.f49038b;
        int i2 = this.f49044h;
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
        return this.f49045i;
    }

    public Rect o() {
        this.k.mapRect(this.f49037a, this.f49039c);
        u(this.f49038b, this.f49037a);
        return this.f49038b;
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
        this.f49042f = f2;
    }

    public void t(Bitmap bitmap) {
        if (bitmap != null) {
            a aVar = new a(bitmap);
            this.f49045i = aVar;
            aVar.i(0, 0, this.f49040d, this.f49041e);
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }
}
