package d.a.l0.a.o0.d;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public String f47593c;

    /* renamed from: d  reason: collision with root package name */
    public String f47594d;

    /* renamed from: e  reason: collision with root package name */
    public String f47595e;

    /* renamed from: f  reason: collision with root package name */
    public String f47596f;

    /* renamed from: g  reason: collision with root package name */
    public String f47597g;

    public e() {
        this.f47581a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        String str2 = (d.a.l0.a.o0.a.c(str, "fromId", this.f47593c) + d.a.l0.a.o0.a.c(str, "toId", this.f47594d)) + d.a.l0.a.o0.a.c(str, "toTabIndex", this.f47597g);
        if (!TextUtils.isEmpty(this.f47595e)) {
            str2 = str2 + d.a.l0.a.o0.a.c(str, "routeType", this.f47595e);
        }
        if (TextUtils.isEmpty(this.f47596f)) {
            return str2;
        }
        return str2 + d.a.l0.a.o0.a.c(str, "toPage", this.f47596f);
    }
}
