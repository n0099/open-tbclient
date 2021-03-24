package d.b.g0.a.t.b;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.v8engine.JsObject;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d implements d.b.g0.a.t.b.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45928c = k.f45050a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.t.b.b f45929a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f45930b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.t.e.b f45932f;

        public a(String str, d.b.g0.a.t.e.b bVar) {
            this.f45931e = str;
            this.f45932f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.p(this.f45931e, this.f45932f);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        d.b.g0.a.t.e.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    public d(@NonNull d.b.g0.a.t.b.b bVar) {
        this.f45929a = bVar;
        this.f45930b = bVar.h();
    }

    @Nullable
    public static JSONObject l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f45928c) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    @NonNull
    public static Pair<d.b.g0.a.t.e.a, JSONObject> m(JsObject jsObject) {
        if (f45928c) {
            Log.d("Api-Base", "parseParams(JsObject): JsObject");
        }
        if (jsObject == null) {
            if (!f45928c) {
                return new Pair<>(new d.b.g0.a.t.e.b(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            throw new RuntimeException("parseParams(JsObject): jsObject cannot be null");
        }
        int type = jsObject.getType();
        int length = jsObject.length();
        if (type != 9) {
            String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
            if (!f45928c) {
                jsObject.release();
                return new Pair<>(new d.b.g0.a.t.e.b(202, str), null);
            }
            throw new RuntimeException(str);
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < length; i++) {
            try {
                int propertyType = jsObject.getPropertyType(i);
                String propertyName = jsObject.getPropertyName(i);
                switch (propertyType) {
                    case 1:
                        jSONObject.put(propertyName, jsObject.toBoolean(i));
                        break;
                    case 2:
                        jSONObject.put(propertyName, jsObject.toInteger(i));
                        break;
                    case 3:
                        jSONObject.put(propertyName, jsObject.toLong(i));
                        break;
                    case 5:
                        try {
                            jSONObject.put(propertyName, jsObject.toDouble(i));
                            break;
                        } catch (JSONException e2) {
                            if (f45928c) {
                                e2.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject) JDOUBLE : with json exception ", e2);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(i);
                        if (objectArray == null) {
                            if (f45928c) {
                                throw new RuntimeException("parseParams(JsObject): jsObjects cannot be null");
                            }
                            break;
                        } else {
                            jSONObject.put(propertyName, o(objectArray));
                            break;
                        }
                    case 7:
                        jSONObject.put(propertyName, jsObject.toString(i));
                        break;
                    case 8:
                        jSONObject.put(propertyName, jsObject.toJsFunction(i));
                        break;
                    case 9:
                        jSONObject.put(propertyName, m(jsObject.toJsObject(i)).second);
                        break;
                    case 10:
                        jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i));
                        break;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                String str2 = "parseParams(JsObject): with exception " + e3.getMessage();
                if (!f45928c) {
                    jsObject.release();
                    return new Pair<>(new d.b.g0.a.t.e.b(202, str2), null);
                }
                throw new RuntimeException(str2, e3);
            }
        }
        jsObject.release();
        return new Pair<>(new d.b.g0.a.t.e.b(0), jSONObject);
    }

    @NonNull
    public static Pair<d.b.g0.a.t.e.a, JSONObject> n(String str) {
        if (f45928c) {
            Log.d("Api-Base", "parseParams(String): String");
        }
        if (TextUtils.isEmpty(str)) {
            if (f45928c) {
                Log.e("Api-Base", "parseParams(String): json string cannot be empty");
            }
            return new Pair<>(new d.b.g0.a.t.e.b(202, "parseParams(String): json string cannot be empty"), null);
        }
        try {
            return new Pair<>(new d.b.g0.a.t.e.b(0), new JSONObject(str));
        } catch (JSONException e2) {
            if (f45928c) {
                e2.printStackTrace();
                Log.e("Api-Base", "parseParams(String): with json exception ", e2);
            }
            return new Pair<>(new d.b.g0.a.t.e.b(202, "parseParams(String): with json exception "), null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
        continue;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray o(@NonNull JsObject[] jsObjectArr) {
        if (f45928c) {
            Log.d("Api-Base", "parseParams(JsObject[]): JsObject[]");
        }
        JSONArray jSONArray = new JSONArray();
        for (JsObject jsObject : jsObjectArr) {
            if (jsObject == null) {
                if (!f45928c) {
                    jSONArray.put((Object) null);
                } else {
                    throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be null");
                }
            } else {
                switch (jsObject.getType()) {
                    case 0:
                        if (!f45928c) {
                            jSONArray.put((Object) null);
                            continue;
                        } else {
                            throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be JNONSUPPORT");
                        }
                    case 1:
                        jSONArray.put(jsObject.toBoolean(0));
                        continue;
                    case 2:
                        jSONArray.put(jsObject.toInteger(0));
                        continue;
                    case 3:
                        jSONArray.put(jsObject.toLong(0));
                        continue;
                    case 5:
                        try {
                            jSONArray.put(jsObject.toDouble(0));
                            continue;
                        } catch (JSONException e2) {
                            if (f45928c) {
                                e2.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject[]) JDOUBLE : with json exception ", e2);
                            }
                            jSONArray.put((Object) null);
                            break;
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(0);
                        if (objectArray == null) {
                            if (!f45928c) {
                                jSONArray.put((Object) null);
                                continue;
                            } else {
                                throw new RuntimeException("parseParams(JsObject[]): objects is null");
                            }
                        } else {
                            jSONArray.put(o(objectArray));
                            break;
                        }
                    case 7:
                        jSONArray.put(jsObject.toString(0));
                        continue;
                    case 8:
                        jSONArray.put(jsObject.toJsFunction(0));
                        continue;
                    case 9:
                        jSONArray.put(m(jsObject).second);
                        continue;
                    case 10:
                        jSONArray.put(jsObject.toJsArrayBuffer(0));
                        continue;
                    case 11:
                        jSONArray.put((Object) null);
                        continue;
                    case 12:
                        jSONArray.put((Object) null);
                        continue;
                }
            }
        }
        return jSONArray;
    }

    @Override // d.b.g0.a.t.b.a
    @NonNull
    public final d.b.g0.a.t.b.b a() {
        return this.f45929a;
    }

    @Override // d.b.g0.a.t.b.a
    public final void c(String str, d.b.g0.a.t.e.b bVar) {
        if (f45928c) {
            Log.d("Api-Base", "invokeCallback: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (f45928c) {
                Log.e("Api-Base", "invokeCallback: do callback with a empty callback");
                throw new RuntimeException("invokeCallback: do callback with a empty callback");
            }
        } else if (bVar == null) {
            if (f45928c) {
                Log.e("Api-Base", "invokeCallback: do callback with a null result");
                throw new RuntimeException("invokeCallback: do callback with a null result");
            }
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            p(str, bVar);
        } else {
            if (f45928c) {
                Log.d("Api-Base", "invokeCallback: other thread " + Thread.currentThread().getName());
            }
            k0.T(new a(str, bVar));
        }
    }

    @NonNull
    public final Context h() {
        return this.f45929a.getContext();
    }

    public d.b.g0.a.t.e.b i(String str, boolean z, b bVar) {
        e y = e.y();
        if (y == null) {
            return new d.b.g0.a.t.e.b(1001, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar2 = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar2.b()) {
            d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            return bVar2;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String str2 = null;
        if (z) {
            str2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(str2)) {
                d.b.g0.a.c0.c.b("Api-Base", "callback is null");
                return new d.b.g0.a.t.e.b(202, "callback is null");
            }
        }
        return bVar.a(y, jSONObject, str2);
    }

    public d.b.g0.a.t.e.b j(@Nullable String str, @NonNull c cVar) {
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (f45928c) {
                d.b.g0.a.c0.c.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("Api-Base", "cb is required");
            return new d.b.g0.a.t.e.b(202, "cb is required");
        }
        return cVar.f(jSONObject, optString, this);
    }

    public final boolean k() {
        e O = e.O();
        if (O == null) {
            return true;
        }
        return O.Z();
    }

    @UiThread
    public final void p(@NonNull String str, @NonNull d.b.g0.a.t.e.b bVar) {
        if (TextUtils.isEmpty(str) && !(this.f45930b instanceof NullableCallbackHandler)) {
            if (f45928c) {
                Log.e("Api-Base", "realInvokeCallback: callback check fail: " + str);
                return;
            }
            return;
        }
        if (f45928c) {
            Log.d("Api-Base", "realInvokeCallback: invoke 【" + str + "】 with 【" + bVar + "】");
        }
        this.f45930b.handleSchemeDispatchCallback(str, bVar.a());
    }
}
