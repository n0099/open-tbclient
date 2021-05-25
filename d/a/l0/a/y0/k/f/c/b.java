package d.a.l0.a.y0.k.f.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public String f45897b;

    public b(String str) {
        super(str);
    }

    @Override // d.a.l0.a.y0.k.f.c.f, d.a.l0.a.y0.k.f.c.e
    public void a(String str, String str2) {
        if (e(str)) {
            boolean equals = TextUtils.equals(str2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            boolean equals2 = TextUtils.equals(str2, RetrieveTaskManager.KEY);
            this.f45896a.g("autoPlay", equals ? "1" : "0");
            this.f45896a.g("playMethod", equals2 ? "1" : "0");
        }
    }

    @Override // d.a.l0.a.y0.k.f.c.a, d.a.l0.a.y0.k.f.c.f, d.a.l0.a.y0.k.f.c.e
    public void b(boolean z, HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2 = hybridUbcFlow.f("fe_slave_dispatch_start");
        UbcFlowEvent f3 = hybridUbcFlow.f("fe_master_page_oninit_start");
        UbcFlowEvent f4 = hybridUbcFlow.f("master_page_onload_start");
        UbcFlowEvent f5 = hybridUbcFlow.f("video_fe_init");
        UbcFlowEvent f6 = hybridUbcFlow.f("video_fe_init_end");
        if (f2 != null) {
            this.f45896a.i("fe_slave_dispatch_start", z ? f2.g() : 0L);
        }
        if (f3 != null) {
            this.f45896a.i("fe_master_page_oninit_start", z ? f3.g() : 0L);
        }
        if (f4 != null) {
            this.f45896a.i("master_page_onload_start", z ? f4.g() : 0L);
        }
        if (f5 != null) {
            this.f45896a.i("video_fe_init", z ? f5.g() : 0L);
        }
        if (f6 != null) {
            this.f45896a.i("video_fe_init_end", z ? f6.g() : 0L);
        }
        this.f45896a.g("fmpArrived", z ? "1" : "0");
        if (this.f45896a.f()) {
            this.f45896a.k();
            d.a.l0.a.y0.k.f.b.f();
        }
    }

    @Override // d.a.l0.a.y0.k.f.c.f, d.a.l0.a.y0.k.f.c.e
    public void c() {
        if (this.f45896a.d("video_will_play")) {
            this.f45896a.h("video_play_cancel");
        }
        d();
    }

    public final boolean e(String str) {
        return TextUtils.equals(this.f45897b, str);
    }

    public void f(String str) {
    }
}
