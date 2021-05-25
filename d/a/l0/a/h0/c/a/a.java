package d.a.l0.a.h0.c.a;

import android.util.Log;
import d.a.l0.a.h0.c.a.b;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public class a implements b.InterfaceC0644b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41949a = k.f43199a;

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0644b
    public void a() {
        if (f41949a) {
            Log.d("SimplePreDownloadCallback", "pre download success");
        }
    }

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0644b
    public void b(int i2) {
        if (f41949a) {
            Log.w("SimplePreDownloadCallback", "pre download fail error code - " + i2);
        }
    }

    @Override // d.a.l0.a.h0.c.a.b.InterfaceC0644b
    public void c() {
        if (f41949a) {
            Log.w("SimplePreDownloadCallback", "pre download has invalid app id");
        }
    }
}
