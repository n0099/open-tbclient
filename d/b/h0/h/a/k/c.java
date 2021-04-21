package d.b.h0.h.a.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.model.LatLng;
import d.b.h0.a.i2.k0;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public String f49557a;

    /* renamed from: b  reason: collision with root package name */
    public String f49558b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f49559c = false;

    public c(String str, String str2, String str3) {
        this.f49557a = str2;
        this.f49558b = str3;
    }

    public String a() {
        return this.f49557a;
    }

    public boolean b() {
        return this.f49559c;
    }

    public boolean c(Context context) {
        return k0.s(context.getApplicationContext(), this.f49558b) != null;
    }

    public void d(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!c(context) && this.f49559c) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f49558b));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
            return;
        }
        e(context, latLng, latLng2, str, str2);
    }

    public abstract void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2);
}
