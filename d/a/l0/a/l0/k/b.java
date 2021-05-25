package d.a.l0.a.l0.k;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import d.a.l0.a.p.d.m0;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes2.dex */
public class b implements V8Engine.V8EngineConsole {

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.l0.a f43313a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43314b = true;

    public b(d.a.l0.a.l0.a aVar) {
        this.f43313a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.f43314b) {
            Log.d("V8Console", this.f43313a.m0() + str);
        }
        d.a.l0.a.c1.b.h().e(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        d.a.l0.a.c1.b.h().e(4, str);
        Log.e("V8Console", this.f43313a.m0() + str);
        m0 g0 = d.a.l0.a.c1.a.g0();
        g0.e("V8Console", this.f43313a.m0() + str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.f43314b) {
            Log.i("V8Console", this.f43313a.m0() + str);
        }
        d.a.l0.a.c1.b.h().e(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.f43314b) {
            Log.v("V8Console", this.f43313a.m0() + str);
        }
        d.a.l0.a.c1.b.h().e(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.f43314b) {
            Log.d("V8Console", this.f43313a.m0() + str);
        }
        d.a.l0.a.c1.b.h().e(6, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        d.a.l0.a.c1.b.h().e(5, str);
        Log.w("V8Console", this.f43313a.m0() + str);
        m0 g0 = d.a.l0.a.c1.a.g0();
        g0.w("V8Console", this.f43313a.m0() + str);
    }
}
