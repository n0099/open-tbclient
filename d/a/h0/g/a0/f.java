package d.a.h0.g.a0;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.k;
import d.a.h0.a.z1.h;
/* loaded from: classes3.dex */
public class f extends EventTargetImpl implements d.a.u.c.c {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46039h = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public int f46040e;

    /* renamed from: f  reason: collision with root package name */
    public c f46041f;

    /* renamed from: g  reason: collision with root package name */
    public String f46042g;

    public f(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f46040e = -1;
        this.f46041f = new c();
        g.a().b().s(this);
    }

    public final void A(String str, Object obj) {
        if (f46039h) {
            Log.i("GameRecorderApi", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public void B(int i2) {
        this.f46040e = i2;
    }

    public void C(String str) {
        this.f46042g = str;
    }

    @Override // d.a.u.c.c
    public void onError(int i2) {
        if (f46039h) {
            Log.d("GameRecorderApi", "onError:" + i2);
        }
        A("error", new b("internal error"));
    }

    @Override // d.a.u.c.c
    public void onPause() {
        A("pause", this.f46041f);
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "pause";
        h.j(eVar);
    }

    @Override // d.a.u.c.c
    public void onResume() {
        A("resume", this.f46041f);
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "resume";
        h.j(eVar);
    }

    @Override // d.a.u.c.c
    public void onStart() {
        int i2 = this.f46040e;
        A(IntentConfig.START, i2 == -1 ? this.f46041f : new d(i2));
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = IntentConfig.START;
        h.j(eVar);
    }

    @Override // d.a.u.c.c
    public void z(int i2, String str) {
        if (f46039h) {
            Log.d("GameRecorderApi", "schemeVideoPath:" + this.f46042g);
        }
        A(IntentConfig.STOP, new e(this.f46042g));
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = IntentConfig.STOP;
        eVar.a("dura", String.valueOf(i2 / 1000.0f));
        h.j(eVar);
    }
}
