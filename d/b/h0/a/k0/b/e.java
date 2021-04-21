package d.b.h0.a.k0.b;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f45783b;

    /* renamed from: c  reason: collision with root package name */
    public String f45784c;

    /* renamed from: d  reason: collision with root package name */
    public String f45785d;

    /* renamed from: e  reason: collision with root package name */
    public String f45786e;

    /* renamed from: f  reason: collision with root package name */
    public String f45787f;

    public e() {
        this.f45777a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.b.h0.a.k0.b.a
    public String a(String str) {
        String str2 = (d.b.h0.a.k0.a.e(str, "fromId", this.f45783b) + d.b.h0.a.k0.a.e(str, "toId", this.f45784c)) + d.b.h0.a.k0.a.e(str, "toTabIndex", this.f45787f);
        if (!TextUtils.isEmpty(this.f45785d)) {
            str2 = str2 + d.b.h0.a.k0.a.e(str, "routeType", this.f45785d);
        }
        if (TextUtils.isEmpty(this.f45786e)) {
            return str2;
        }
        return str2 + d.b.h0.a.k0.a.e(str, "toPage", this.f45786e);
    }
}
