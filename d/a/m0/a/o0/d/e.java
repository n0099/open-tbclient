package d.a.m0.a.o0.d;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public String f47701c;

    /* renamed from: d  reason: collision with root package name */
    public String f47702d;

    /* renamed from: e  reason: collision with root package name */
    public String f47703e;

    /* renamed from: f  reason: collision with root package name */
    public String f47704f;

    /* renamed from: g  reason: collision with root package name */
    public String f47705g;

    public e() {
        this.f47689a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.m0.a.o0.d.a
    public String f(String str) {
        String str2 = (d.a.m0.a.o0.a.c(str, "fromId", this.f47701c) + d.a.m0.a.o0.a.c(str, "toId", this.f47702d)) + d.a.m0.a.o0.a.c(str, "toTabIndex", this.f47705g);
        if (!TextUtils.isEmpty(this.f47703e)) {
            str2 = str2 + d.a.m0.a.o0.a.c(str, "routeType", this.f47703e);
        }
        if (TextUtils.isEmpty(this.f47704f)) {
            return str2;
        }
        return str2 + d.a.m0.a.o0.a.c(str, "toPage", this.f47704f);
    }
}
