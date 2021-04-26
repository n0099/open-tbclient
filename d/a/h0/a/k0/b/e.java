package d.a.h0.a.k0.b;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f43112b;

    /* renamed from: c  reason: collision with root package name */
    public String f43113c;

    /* renamed from: d  reason: collision with root package name */
    public String f43114d;

    /* renamed from: e  reason: collision with root package name */
    public String f43115e;

    /* renamed from: f  reason: collision with root package name */
    public String f43116f;

    public e() {
        this.f43106a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.h0.a.k0.b.a
    public String a(String str) {
        String str2 = (d.a.h0.a.k0.a.e(str, "fromId", this.f43112b) + d.a.h0.a.k0.a.e(str, "toId", this.f43113c)) + d.a.h0.a.k0.a.e(str, "toTabIndex", this.f43116f);
        if (!TextUtils.isEmpty(this.f43114d)) {
            str2 = str2 + d.a.h0.a.k0.a.e(str, "routeType", this.f43114d);
        }
        if (TextUtils.isEmpty(this.f43115e)) {
            return str2;
        }
        return str2 + d.a.h0.a.k0.a.e(str, "toPage", this.f43115e);
    }
}
