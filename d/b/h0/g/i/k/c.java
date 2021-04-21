package d.b.h0.g.i.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.b.h0.a.k;
import d.b.h0.a.z1.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.i.a f48904a;

    /* renamed from: b  reason: collision with root package name */
    public String f48905b = "";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f48906d = k.f45772a;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f48907a = new JSEvent("error");

        /* renamed from: b  reason: collision with root package name */
        public String f48908b;

        /* renamed from: c  reason: collision with root package name */
        public String f48909c;

        public JSEvent a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.f48908b);
                jSONObject.put("stack", this.f48909c);
            } catch (JSONException e2) {
                if (f48906d) {
                    Log.e("V8Exception", Log.getStackTraceString(e2));
                }
            }
            if (jSONObject.length() > 0) {
                this.f48907a.data = jSONObject;
            }
            return this.f48907a;
        }

        public a b(String str) {
            this.f48908b = str;
            return this;
        }

        public a c(String str) {
            this.f48909c = str;
            return this;
        }
    }

    static {
        boolean z = k.f45772a;
    }

    public c(d.b.h0.g.i.a aVar) {
        this.f48904a = aVar;
    }

    public final void a(String str, String str2) {
        if (this.f48904a.t() == null) {
            return;
        }
        EventTarget t = this.f48904a.t();
        a aVar = new a();
        aVar.b(str + "\n" + str2);
        aVar.c("");
        t.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            return;
        }
        String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
        String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
        Log.e("V8Exception", this.f48904a.j0() + "msg: " + str + " ,stack: " + str2);
        this.f48904a.a0().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f48905b.equals(str)) {
            return;
        }
        this.f48905b = str;
        a(str, str2);
        d.b.h0.g.c0.c.f(str + ";" + str2);
        i.b(v8ExceptionInfo);
        DuMixGameSurfaceView r = d.b.h0.g.m.a.m().r();
        if (r != null) {
            r.q(v8ExceptionInfo);
        }
    }
}
