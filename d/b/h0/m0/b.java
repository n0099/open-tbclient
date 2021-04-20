package d.b.h0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f50715b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50716c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50717d;

    public int b() {
        a aVar = this.f50715b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f50717d || (aVar = this.f50715b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f50728a)) == null) {
            return;
        }
        mVar.e(this);
        this.f50717d = true;
    }

    public void d() {
        if (this.f50716c || !k.d().g()) {
            return;
        }
        this.f50716c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f50715b == null) {
                this.f50715b = new a();
            }
            this.f50715b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f50715b) == null) {
            return;
        }
        aVar.d();
    }
}
