package d.a.m0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f49524b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49525c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49526d;

    public int b() {
        a aVar = this.f49524b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f49526d || (aVar = this.f49524b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f49538a)) == null) {
            return;
        }
        mVar.e(this);
        this.f49526d = true;
    }

    public void d() {
        if (this.f49525c || !k.d().g()) {
            return;
        }
        this.f49525c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f49524b == null) {
                this.f49524b = new a();
            }
            this.f49524b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f49524b) == null) {
            return;
        }
        aVar.d();
    }
}
