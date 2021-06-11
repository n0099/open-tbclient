package d.a.l0.a.h0.c.a;

import android.util.Log;
import d.a.l0.a.h0.c.a.b;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class a implements b.InterfaceC0700b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45625a = k.f46875a;

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0700b
    public void a() {
        if (f45625a) {
            Log.d("SimplePreDownloadCallback", "pre download success");
        }
    }

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0700b
    public void b(int i2) {
        if (f45625a) {
            Log.w("SimplePreDownloadCallback", "pre download fail error code - " + i2);
        }
    }

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0700b
    public void c() {
        if (f45625a) {
            Log.w("SimplePreDownloadCallback", "pre download has invalid app id");
        }
    }
}
