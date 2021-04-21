package d.b.h0.g.a0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.k;
import d.b.h0.a.z1.h;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.b.u.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48577h = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public int f48578e;

    /* renamed from: f  reason: collision with root package name */
    public c f48579f;

    /* renamed from: g  reason: collision with root package name */
    public String f48580g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f48578e = -1;
        this.f48579f = new c();
        g.a().b().s(this);
    }

    public final void A(String str, Object obj) {
        if (f48577h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public void B(int i) {
        this.f48578e = i;
    }

    public void C(String str) {
        this.f48580g = str;
    }

    @Override // d.b.u.c.c
    public void onError(int i) {
        if (f48577h) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        A("error", new b("internal error"));
    }

    @Override // d.b.u.c.c
    public void onPause() {
        A("pause", this.f48579f);
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = "pause";
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void onResume() {
        A("resume", this.f48579f);
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = "resume";
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void onStart() {
        int i = this.f48578e;
        A(IntentConfig.START, i == -1 ? this.f48579f : new d(i));
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = IntentConfig.START;
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void w(int i, String str) {
        if (f48577h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f48580g);
        }
        A(IntentConfig.STOP, new e(this.f48580g));
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47973b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i / 1000.0f));
        h.j(eVar);
    }
}
