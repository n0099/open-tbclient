package d.a.m0.a.l0.k;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import d.a.m0.a.p.d.m0;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes3.dex */
public class b implements V8Engine.V8EngineConsole {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f47097a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47098b = true;

    public b(d.a.m0.a.l0.a aVar) {
        this.f47097a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.f47098b) {
            Log.d("V8Console", this.f47097a.m0() + str);
        }
        d.a.m0.a.c1.b.h().e(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        d.a.m0.a.c1.b.h().e(4, str);
        Log.e("V8Console", this.f47097a.m0() + str);
        m0 g0 = d.a.m0.a.c1.a.g0();
        g0.e("V8Console", this.f47097a.m0() + str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.f47098b) {
            Log.i("V8Console", this.f47097a.m0() + str);
        }
        d.a.m0.a.c1.b.h().e(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.f47098b) {
            Log.v("V8Console", this.f47097a.m0() + str);
        }
        d.a.m0.a.c1.b.h().e(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.f47098b) {
            Log.d("V8Console", this.f47097a.m0() + str);
        }
        d.a.m0.a.c1.b.h().e(6, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        d.a.m0.a.c1.b.h().e(5, str);
        Log.w("V8Console", this.f47097a.m0() + str);
        m0 g0 = d.a.m0.a.c1.a.g0();
        g0.w("V8Console", this.f47097a.m0() + str);
    }
}
