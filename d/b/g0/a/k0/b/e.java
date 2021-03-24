package d.b.g0.a.k0.b;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f45061b;

    /* renamed from: c  reason: collision with root package name */
    public String f45062c;

    /* renamed from: d  reason: collision with root package name */
    public String f45063d;

    /* renamed from: e  reason: collision with root package name */
    public String f45064e;

    /* renamed from: f  reason: collision with root package name */
    public String f45065f;

    public e() {
        this.f45055a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        String str2 = (d.b.g0.a.k0.a.e(str, "fromId", this.f45061b) + d.b.g0.a.k0.a.e(str, "toId", this.f45062c)) + d.b.g0.a.k0.a.e(str, "toTabIndex", this.f45065f);
        if (!TextUtils.isEmpty(this.f45063d)) {
            str2 = str2 + d.b.g0.a.k0.a.e(str, "routeType", this.f45063d);
        }
        if (TextUtils.isEmpty(this.f45064e)) {
            return str2;
        }
        return str2 + d.b.g0.a.k0.a.e(str, "toPage", this.f45064e);
    }
}
