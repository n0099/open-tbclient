package d.b.g0.h.a.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.mapapi.model.LatLng;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48835a;

    /* renamed from: b  reason: collision with root package name */
    public String f48836b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48837c = false;

    public c(String str, String str2, String str3) {
        this.f48835a = str2;
        this.f48836b = str3;
    }

    public String a() {
        return this.f48835a;
    }

    public boolean b() {
        return this.f48837c;
    }

    public boolean c(Context context) {
        return k0.s(context.getApplicationContext(), this.f48836b) != null;
    }

    public void d(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!c(context) && this.f48837c) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f48836b));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        e(context, latLng, latLng2, str, str2);
    }

    public abstract void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2);
}
