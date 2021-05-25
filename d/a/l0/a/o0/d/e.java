package d.a.l0.a.o0.d;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public String f43917c;

    /* renamed from: d  reason: collision with root package name */
    public String f43918d;

    /* renamed from: e  reason: collision with root package name */
    public String f43919e;

    /* renamed from: f  reason: collision with root package name */
    public String f43920f;

    /* renamed from: g  reason: collision with root package name */
    public String f43921g;

    public e() {
        this.f43905a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.l0.a.o0.d.a
    public String f(String str) {
        String str2 = (d.a.l0.a.o0.a.c(str, "fromId", this.f43917c) + d.a.l0.a.o0.a.c(str, "toId", this.f43918d)) + d.a.l0.a.o0.a.c(str, "toTabIndex", this.f43921g);
        if (!TextUtils.isEmpty(this.f43919e)) {
            str2 = str2 + d.a.l0.a.o0.a.c(str, "routeType", this.f43919e);
        }
        if (TextUtils.isEmpty(this.f43920f)) {
            return str2;
        }
        return str2 + d.a.l0.a.o0.a.c(str, "toPage", this.f43920f);
    }
}
