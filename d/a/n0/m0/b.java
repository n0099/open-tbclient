package d.a.n0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f53306b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53307c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53308d;

    public int b() {
        a aVar = this.f53306b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f53308d || (aVar = this.f53306b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f53320a)) == null) {
            return;
        }
        mVar.e(this);
        this.f53308d = true;
    }

    public void d() {
        if (this.f53307c || !k.d().g()) {
            return;
        }
        this.f53307c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f53306b == null) {
                this.f53306b = new a();
            }
            this.f53306b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f53306b) == null) {
            return;
        }
        aVar.d();
    }
}
