package d.a.j0.m0;

import android.os.Build;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: b  reason: collision with root package name */
    public a f49480b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49481c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49482d;

    public int b() {
        a aVar = this.f49480b;
        if (aVar != null) {
            return aVar.b();
        }
        return -1;
    }

    public void c() {
        a aVar;
        m mVar;
        if (this.f49482d || (aVar = this.f49480b) == null || aVar.b() < 0 || (mVar = (m) k.d().e(this.f49494a)) == null) {
            return;
        }
        mVar.e(this);
        this.f49482d = true;
    }

    public void d() {
        if (this.f49481c || !k.d().g()) {
            return;
        }
        this.f49481c = true;
        if (Build.VERSION.SDK_INT >= 16) {
            if (this.f49480b == null) {
                this.f49480b = new a();
            }
            this.f49480b.c();
        }
    }

    public void e() {
        a aVar;
        if (Build.VERSION.SDK_INT < 16 || (aVar = this.f49480b) == null) {
            return;
        }
        aVar.d();
    }
}
