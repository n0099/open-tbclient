package d.a.i0.a.o0.d;

import android.text.TextUtils;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public String f43743c;

    /* renamed from: d  reason: collision with root package name */
    public String f43744d;

    /* renamed from: e  reason: collision with root package name */
    public String f43745e;

    /* renamed from: f  reason: collision with root package name */
    public String f43746f;

    /* renamed from: g  reason: collision with root package name */
    public String f43747g;

    public e() {
        this.f43731a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.i0.a.o0.d.a
    public String f(String str) {
        String str2 = (d.a.i0.a.o0.a.c(str, "fromId", this.f43743c) + d.a.i0.a.o0.a.c(str, "toId", this.f43744d)) + d.a.i0.a.o0.a.c(str, "toTabIndex", this.f43747g);
        if (!TextUtils.isEmpty(this.f43745e)) {
            str2 = str2 + d.a.i0.a.o0.a.c(str, "routeType", this.f43745e);
        }
        if (TextUtils.isEmpty(this.f43746f)) {
            return str2;
        }
        return str2 + d.a.i0.a.o0.a.c(str, "toPage", this.f43746f);
    }
}
