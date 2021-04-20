package d.b.c.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f42652a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c.j.d.a f42653b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42654c = true;

    public int a() {
        if (e()) {
            return this.f42652a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f42653b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f42652a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f42653b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.b.c.j.d.a aVar = this.f42653b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f42652a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f42652a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f42653b = null;
        this.f42652a = null;
    }
}
