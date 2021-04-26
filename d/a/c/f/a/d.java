package d.a.c.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f40109a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.d.a f40110b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f40111c = true;

    public int a() {
        if (e()) {
            return this.f40109a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f40110b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f40109a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f40110b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.a.c.j.d.a aVar = this.f40110b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f40109a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f40109a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f40110b = null;
        this.f40109a = null;
    }
}
