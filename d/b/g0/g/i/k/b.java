package d.b.g0.g.i.k;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import d.b.g0.g.f.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes3.dex */
public class b implements V8Engine.V8EngineConsole {

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.i.a f48180a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48181b = true;

    public b(d.b.g0.g.i.a aVar) {
        this.f48180a = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.f48181b) {
            Log.d("V8Console", this.f48180a.i0() + str);
        }
        i.d(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.f48180a.i0() + str);
        i.d(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.f48181b) {
            Log.i("V8Console", this.f48180a.i0() + str);
        }
        i.d(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.f48181b) {
            Log.v("V8Console", this.f48180a.i0() + str);
        }
        i.d(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.f48181b) {
            Log.d("V8Console", this.f48180a.i0() + str);
        }
        i.d(6, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.f48180a.i0() + str);
        i.d(5, str);
    }
}
