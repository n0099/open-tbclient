package d.a.m0.a.l0.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import d.a.m0.a.j2.l;
import d.a.m0.a.k;
import d.a.m0.a.p.b.a.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.l0.a f47099a;

    /* renamed from: b  reason: collision with root package name */
    public String f47100b = "";

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f47101d = k.f46983a;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f47102a = new JSEvent("error");

        /* renamed from: b  reason: collision with root package name */
        public String f47103b;

        /* renamed from: c  reason: collision with root package name */
        public String f47104c;

        public JSEvent a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", this.f47103b);
                jSONObject.put("stack", this.f47104c);
            } catch (JSONException e2) {
                if (f47101d) {
                    Log.e("V8Exception", Log.getStackTraceString(e2));
                }
            }
            if (jSONObject.length() > 0) {
                this.f47102a.data = jSONObject;
            }
            return this.f47102a;
        }

        public a b(String str) {
            this.f47103b = str;
            return this;
        }

        public a c(String str) {
            this.f47104c = str;
            return this;
        }
    }

    static {
        boolean z = k.f46983a;
    }

    public c(d.a.m0.a.l0.a aVar) {
        this.f47099a = aVar;
    }

    public final void a(String str, String str2) {
        if (this.f47099a.p() == null) {
            return;
        }
        EventTarget p = this.f47099a.p();
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
        Log.e("V8Exception", this.f47099a.m0() + "msg: " + str + " ,stack: " + str2);
        this.f47099a.A().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f47100b.equals(str)) {
            return;
        }
        this.f47100b = str;
        a(str, str2);
        h j = d.a.m0.a.c1.b.j();
        j.e(str + ";" + str2);
        l.b(v8ExceptionInfo);
        d.a.m0.a.c1.b.i().s(v8ExceptionInfo);
    }
}
