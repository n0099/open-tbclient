package d.b.g0.a.k0.b;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f45454b;

    /* renamed from: c  reason: collision with root package name */
    public String f45455c;

    /* renamed from: d  reason: collision with root package name */
    public String f45456d;

    /* renamed from: e  reason: collision with root package name */
    public String f45457e;

    /* renamed from: f  reason: collision with root package name */
    public String f45458f;

    public e() {
        this.f45448a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        String str2 = (d.b.g0.a.k0.a.e(str, "fromId", this.f45454b) + d.b.g0.a.k0.a.e(str, "toId", this.f45455c)) + d.b.g0.a.k0.a.e(str, "toTabIndex", this.f45458f);
        if (!TextUtils.isEmpty(this.f45456d)) {
            str2 = str2 + d.b.g0.a.k0.a.e(str, "routeType", this.f45456d);
        }
        if (TextUtils.isEmpty(this.f45457e)) {
            return str2;
        }
        return str2 + d.b.g0.a.k0.a.e(str, "toPage", this.f45457e);
    }
}
