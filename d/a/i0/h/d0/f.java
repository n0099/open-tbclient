package d.a.i0.h.d0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.a.u.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47107h = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public int f47108e;

    /* renamed from: f  reason: collision with root package name */
    public c f47109f;

    /* renamed from: g  reason: collision with root package name */
    public String f47110g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f47108e = -1;
        this.f47109f = new c();
        g.a().b().s(this);
    }

    public void A(int i2) {
        this.f47108e = i2;
    }

    public void B(String str) {
        this.f47110g = str;
    }

    @Override // d.a.u.c.c
    public void onError(int i2) {
        if (f47107h) {
            Log.d("GameRecorderApi", "onError:" + i2);
        }
        z("error", new b("internal error"));
    }

    @Override // d.a.u.c.c
    public void onPause() {
        z("pause", this.f47109f);
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = "pause";
        d.a.i0.a.j2.k.h(eVar);
    }

    @Override // d.a.u.c.c
    public void onResume() {
        z("resume", this.f47109f);
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = "resume";
        d.a.i0.a.j2.k.h(eVar);
    }

    @Override // d.a.u.c.c
    public void onStart() {
        int i2 = this.f47108e;
        z(IntentConfig.START, i2 == -1 ? this.f47109f : new d(i2));
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = IntentConfig.START;
        d.a.i0.a.j2.k.h(eVar);
    }

    @Override // d.a.u.c.c
    public void y(int i2, String str) {
        if (f47107h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f47110g);
        }
        z(IntentConfig.STOP, new e(this.f47110g));
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43012b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i2 / 1000.0f));
        d.a.i0.a.j2.k.h(eVar);
    }

    public final void z(String str, Object obj) {
        if (f47107h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }
}
