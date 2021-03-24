package d.b.g0.g.a0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.k;
import d.b.g0.a.z1.h;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.b.u.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47855h = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public int f47856e;

    /* renamed from: f  reason: collision with root package name */
    public c f47857f;

    /* renamed from: g  reason: collision with root package name */
    public String f47858g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f47856e = -1;
        this.f47857f = new c();
        g.a().b().s(this);
    }

    public final void A(String str, Object obj) {
        if (f47855h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public void B(int i) {
        this.f47856e = i;
    }

    public void C(String str) {
        this.f47858g = str;
    }

    @Override // d.b.u.c.c
    public void onError(int i) {
        if (f47855h) {
            Log.d("GameRecorderApi", "onError:" + i);
        }
        A("error", new b("internal error"));
    }

    @Override // d.b.u.c.c
    public void onPause() {
        A("pause", this.f47857f);
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = "pause";
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void onResume() {
        A("resume", this.f47857f);
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = "resume";
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void onStart() {
        int i = this.f47856e;
        A(IntentConfig.START, i == -1 ? this.f47857f : new d(i));
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = IntentConfig.START;
        h.j(eVar);
    }

    @Override // d.b.u.c.c
    public void w(int i, String str) {
        if (f47855h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f47858g);
        }
        A(IntentConfig.STOP, new e(this.f47858g));
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i / 1000.0f));
        h.j(eVar);
    }
}
