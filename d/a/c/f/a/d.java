package d.a.c.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f42774a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.k.d.a f42775b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42776c = true;

    public int a() {
        if (e()) {
            return this.f42774a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f42775b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f42774a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f42775b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.a.c.k.d.a aVar = this.f42775b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f42774a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f42774a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f42775b = null;
        this.f42774a = null;
    }
}
