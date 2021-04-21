package d.b.i0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f51051b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51052c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51053d;

    public int b() {
        a aVar = this.f51051b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f51053d || (aVar = this.f51051b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f51064a)) == null) {
            return;
        }
        mVar.e(this);
        this.f51053d = true;
    }

    public void d() {
        if (this.f51052c || !k.d().g()) {
            return;
        }
        this.f51052c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f51051b == null) {
                this.f51051b = new a();
            }
            this.f51051b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f51051b) == null) {
            return;
        }
        aVar.d();
    }
}
