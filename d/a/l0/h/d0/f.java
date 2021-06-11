package d.a.l0.h.d0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.a.w.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50957h = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public int f50958e;

    /* renamed from: f  reason: collision with root package name */
    public c f50959f;

    /* renamed from: g  reason: collision with root package name */
    public String f50960g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f50958e = -1;
        this.f50959f = new c();
        g.a().b().s(this);
    }

    public void A(int i2) {
        this.f50958e = i2;
    }

    public void B(String str) {
        this.f50960g = str;
    }

    @Override // d.a.w.c.c
    public void onError(int i2) {
        if (f50957h) {
            Log.d("GameRecorderApi", "onError:" + i2);
        }
        z("error", new b("internal error"));
    }

    @Override // d.a.w.c.c
    public void onPause() {
        z("pause", this.f50959f);
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46862b = "pause";
        d.a.l0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void onResume() {
        z("resume", this.f50959f);
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46862b = "resume";
        d.a.l0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void onStart() {
        int i2 = this.f50958e;
        z(IntentConfig.START, i2 == -1 ? this.f50959f : new d(i2));
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46862b = IntentConfig.START;
        d.a.l0.a.j2.k.h(eVar);
    }

    @Override // d.a.w.c.c
    public void y(int i2, String str) {
        if (f50957h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f50960g);
        }
        z(IntentConfig.STOP, new e(this.f50960g));
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46862b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i2 / 1000.0f));
        d.a.l0.a.j2.k.h(eVar);
    }

    public final void z(String str, Object obj) {
        if (f50957h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }
}
