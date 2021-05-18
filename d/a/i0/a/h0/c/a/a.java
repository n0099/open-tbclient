package d.a.i0.a.h0.c.a;

import android.util.Log;
import d.a.i0.a.h0.c.a.b;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class a implements b.InterfaceC0633b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41775a = k.f43025a;

    @Override // d.a.i0.a.h0.c.a.b.InterfaceC0633b
    public void a() {
        if (f41775a) {
            Log.d("SimplePreDownloadCallback", "pre download success");
        }
    }

    @Override // d.a.i0.a.h0.c.a.b.InterfaceC0633b
    public void b(int i2) {
        if (f41775a) {
            Log.w("SimplePreDownloadCallback", "pre download fail error code - " + i2);
        }
    }

    @Override // d.a.i0.a.h0.c.a.b.InterfaceC0633b
    public void c() {
        if (f41775a) {
            Log.w("SimplePreDownloadCallback", "pre download has invalid app id");
        }
    }
}
