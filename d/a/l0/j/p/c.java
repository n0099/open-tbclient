package d.a.l0.j.p;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mapapi.model.LatLng;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public String f47923a;

    /* renamed from: b  reason: collision with root package name */
    public String f47924b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47925c = false;

    public c(String str, String str2, String str3) {
        this.f47923a = str2;
        this.f47924b = str3;
    }

    public String a() {
        return this.f47923a;
    }

    public boolean b() {
        return this.f47925c;
    }

    public boolean c(Context context) {
        return q0.t(context.getApplicationContext(), this.f47924b) != null;
    }

    public void d(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (!c(context) && this.f47925c) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f47924b));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            context.startActivity(intent);
            return;
        }
        e(context, latLng, latLng2, str, str2);
    }

    public abstract void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2);
}
