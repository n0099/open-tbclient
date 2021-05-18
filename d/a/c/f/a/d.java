package d.a.c.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f39354a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.d.a f39355b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39356c = true;

    public int a() {
        if (e()) {
            return this.f39354a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f39355b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f39354a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f39355b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.a.c.j.d.a aVar = this.f39355b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f39354a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f39354a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f39355b = null;
        this.f39354a = null;
    }
}
