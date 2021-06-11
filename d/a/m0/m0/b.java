package d.a.m0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f53199b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53200c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53201d;

    public int b() {
        a aVar = this.f53199b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f53201d || (aVar = this.f53199b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f53213a)) == null) {
            return;
        }
        mVar.e(this);
        this.f53201d = true;
    }

    public void d() {
        if (this.f53200c || !k.d().g()) {
            return;
        }
        this.f53200c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f53199b == null) {
                this.f53199b = new a();
            }
            this.f53199b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f53199b) == null) {
            return;
        }
        aVar.d();
    }
}
