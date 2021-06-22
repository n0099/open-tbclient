package d.a.m0.h.d0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.a.w.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51065h = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public int f51066e;

    /* renamed from: f  reason: collision with root package name */
    public c f51067f;

    /* renamed from: g  reason: collision with root package name */
    public String f51068g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f51066e = -1;
        this.f51067f = new c();
        g.a().b().s(this);
    }

    public void A(int i2) {
        this.f51066e = i2;
    }

    public void B(String str) {
        this.f51068g = str;
    }

    @Override // d.a.w.c.c
    public void onError(int i2) {
        if (f51065h) {
            Log.d("GameRecorderApi", "onError:" + i2);
        }
        z("error", new b("internal error"));
    }

    @Override // d.a.w.c.c
    public void onPause() {
        z("pause", this.f51067f);
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46970b = "pause";
        d.a.m0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void onResume() {
        z("resume", this.f51067f);
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46970b = "resume";
        d.a.m0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void onStart() {
        int i2 = this.f51066e;
        z(IntentConfig.START, i2 == -1 ? this.f51067f : new d(i2));
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46970b = IntentConfig.START;
        d.a.m0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void y(int i2, String str) {
        if (f51065h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f51068g);
        }
        z(IntentConfig.STOP, new e(this.f51068g));
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46970b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i2 / 1000.0f));
        d.a.m0.a.j2.k.h(eVar);
    }

    public final void z(String str, Object obj) {
        if (f51065h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }
}
