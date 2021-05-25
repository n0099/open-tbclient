package d.a.c.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f39018a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.d.a f39019b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39020c = true;

    public int a() {
        if (e()) {
            return this.f39018a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f39019b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f39018a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f39019b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.a.c.j.d.a aVar = this.f39019b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f39018a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f39018a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f39019b = null;
        this.f39018a = null;
    }
}
