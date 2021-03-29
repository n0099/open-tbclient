package d.b.b.f.a;

import android.graphics.drawable.BitmapDrawable;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BitmapDrawable f42155a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.j.d.a f42156b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f42157c = true;

    public int a() {
        if (e()) {
            return this.f42155a.getIntrinsicHeight();
        }
        if (d()) {
            return this.f42156b.m();
        }
        return 0;
    }

    public int b() {
        if (e()) {
            return this.f42155a.getIntrinsicWidth();
        }
        if (d()) {
            return this.f42156b.r();
        }
        return 0;
    }

    public boolean c() {
        return e() || d();
    }

    public boolean d() {
        d.b.b.j.d.a aVar = this.f42156b;
        return aVar != null && aVar.w();
    }

    public boolean e() {
        BitmapDrawable bitmapDrawable = this.f42155a;
        return (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.f42155a.getBitmap().isRecycled()) ? false : true;
    }

    public void f() {
        this.f42156b = null;
        this.f42155a = null;
    }
}
