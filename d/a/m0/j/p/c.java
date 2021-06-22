package d.a.m0.j.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.model.LatLng;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public String f51705a;

    /* renamed from: b  reason: collision with root package name */
    public String f51706b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51707c = false;

    public c(String str, String str2, String str3) {
        this.f51705a = str2;
        this.f51706b = str3;
    }

    public String a() {
        return this.f51705a;
    }

    public boolean b() {
        return this.f51707c;
    }

    public boolean c(Context context) {
        return q0.t(context.getApplicationContext(), this.f51706b) != null;
    }

    public void d(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!c(context) && this.f51707c) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f51706b));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
            return;
        }
        e(context, latLng, latLng2, str, str2);
    }

    public abstract void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2);
}
