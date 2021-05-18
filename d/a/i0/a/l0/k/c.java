package d.a.i0.a.l0.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.i0.a.j2.l;
import d.a.i0.a.k;
import d.a.i0.a.p.b.a.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.l0.a f43141a;

    /* renamed from: b  reason: collision with root package name */
    public String f43142b = "";

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f43143d = k.f43025a;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f43144a = new JSEvent("error");

        /* renamed from: b  reason: collision with root package name */
        public String f43145b;

        /* renamed from: c  reason: collision with root package name */
        public String f43146c;

        public JSEvent a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.f43145b);
                jSONObject.put("stack", this.f43146c);
            } catch (JSONException e2) {
                if (f43143d) {
                    Log.e("V8Exception", Log.getStackTraceString(e2));
                }
            }
            if (jSONObject.length() > 0) {
                this.f43144a.data = jSONObject;
            }
            return this.f43144a;
        }

        public a b(String str) {
            this.f43145b = str;
            return this;
        }

        public a c(String str) {
            this.f43146c = str;
            return this;
        }
    }

    static {
        boolean z = k.f43025a;
    }

    public c(d.a.i0.a.l0.a aVar) {
        this.f43141a = aVar;
    }

    public final void a(String str, String str2) {
        if (this.f43141a.p() == null) {
            return;
        }
        EventTarget p = this.f43141a.p();
        a aVar = new a();
        aVar.b(str + "\n" + str2);
        aVar.c("");
        p.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            return;
        }
        String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
        String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
        Log.e("V8Exception", this.f43141a.m0() + "msg: " + str + " ,stack: " + str2);
        this.f43141a.A().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f43142b.equals(str)) {
            return;
        }
        this.f43142b = str;
        a(str, str2);
        h j = d.a.i0.a.c1.b.j();
        j.e(str + ";" + str2);
        l.b(v8ExceptionInfo);
        d.a.i0.a.c1.b.i().s(v8ExceptionInfo);
    }
}
