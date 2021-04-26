package d.a.h0.g.i.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import d.a.h0.a.k;
import d.a.h0.a.z1.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.i.a f46378a;

    /* renamed from: b  reason: collision with root package name */
    public String f46379b = "";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f46380d = k.f43101a;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f46381a = new JSEvent("error");

        /* renamed from: b  reason: collision with root package name */
        public String f46382b;

        /* renamed from: c  reason: collision with root package name */
        public String f46383c;

        public JSEvent a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.f46382b);
                jSONObject.put("stack", this.f46383c);
            } catch (JSONException e2) {
                if (f46380d) {
                    Log.e("V8Exception", Log.getStackTraceString(e2));
                }
            }
            if (jSONObject.length() > 0) {
                this.f46381a.data = jSONObject;
            }
            return this.f46381a;
        }

        public a b(String str) {
            this.f46382b = str;
            return this;
        }

        public a c(String str) {
            this.f46383c = str;
            return this;
        }
    }

    static {
        boolean z = k.f43101a;
    }

    public c(d.a.h0.g.i.a aVar) {
        this.f46378a = aVar;
    }

    public final void a(String str, String str2) {
        if (this.f46378a.o() == null) {
            return;
        }
        EventTarget o = this.f46378a.o();
        a aVar = new a();
        aVar.b(str + "\n" + str2);
        aVar.c("");
        o.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            return;
        }
        String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
        String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
        Log.e("V8Exception", this.f46378a.j0() + "msg: " + str + " ,stack: " + str2);
        this.f46378a.y().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f46379b.equals(str)) {
            return;
        }
        this.f46379b = str;
        a(str, str2);
        d.a.h0.g.c0.c.f(str + ";" + str2);
        i.b(v8ExceptionInfo);
        DuMixGameSurfaceView r = d.a.h0.g.m.a.m().r();
        if (r != null) {
            r.q(v8ExceptionInfo);
        }
    }
}
