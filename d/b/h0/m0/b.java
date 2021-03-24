package d.b.h0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f50307b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50308c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50309d;

    public int b() {
        a aVar = this.f50307b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f50309d || (aVar = this.f50307b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f50320a)) == null) {
            return;
        }
        mVar.e(this);
        this.f50309d = true;
    }

    public void d() {
        if (this.f50308c || !k.d().g()) {
            return;
        }
        this.f50308c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f50307b == null) {
                this.f50307b = new a();
            }
            this.f50307b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f50307b) == null) {
            return;
        }
        aVar.d();
    }
}
