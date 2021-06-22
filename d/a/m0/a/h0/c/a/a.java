package d.a.m0.a.h0.c.a;

import android.util.Log;
import d.a.m0.a.h0.c.a.b;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0703b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45733a = k.f46983a;

    @Override // d.a.m0.a.h0.c.a.b.InterfaceC0703b
    public void a() {
        if (f45733a) {
            Log.d("SimplePreDownloadCallback", "pre download success");
        }
    }

    @Override // d.a.m0.a.h0.c.a.b.InterfaceC0703b
    public void b(int i2) {
        if (f45733a) {
            Log.w("SimplePreDownloadCallback", "pre download fail error code - " + i2);
        }
    }

    @Override // d.a.m0.a.h0.c.a.b.InterfaceC0703b
    public void c() {
        if (f45733a) {
            Log.w("SimplePreDownloadCallback", "pre download has invalid app id");
        }
    }
}
