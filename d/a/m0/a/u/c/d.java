package d.a.m0.a.u.c;

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
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d implements d.a.m0.a.u.c.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48594c = k.f46983a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.u.c.b f48595a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f48596b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.u.h.b f48598f;

        public a(String str, d.a.m0.a.u.h.b bVar) {
            this.f48597e = str;
            this.f48598f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.q(this.f48597e, this.f48598f);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        d.a.m0.a.u.h.b a(e eVar, JSONObject jSONObject, @Nullable String str);
    }

    public d(@NonNull d.a.m0.a.u.c.b bVar) {
        this.f48595a = bVar;
        this.f48596b = bVar.h();
    }

    @Nullable
    public static JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (f48594c) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    @NonNull
    public static Pair<d.a.m0.a.u.h.a, JSONObject> n(JsObject jsObject) {
        if (f48594c) {
            Log.d("Api-Base", "parseParams(JsObject): JsObject");
        }
        if (jsObject == null) {
            if (!f48594c) {
                return new Pair<>(new d.a.m0.a.u.h.b(202, "parseParams(JsObject): jsObject cannot be null"), null);
            }
            throw new RuntimeException("parseParams(JsObject): jsObject cannot be null");
        }
        int type = jsObject.getType();
        int length = jsObject.length();
        if (type != 9) {
            String str = "parseParams(JsObject): jsObject cannot be " + JsObject.typeToString(type) + " ,length " + length;
            if (!f48594c) {
                jsObject.release();
                return new Pair<>(new d.a.m0.a.u.h.b(202, str), null);
            }
            throw new RuntimeException(str);
        }
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                int propertyType = jsObject.getPropertyType(i2);
                String propertyName = jsObject.getPropertyName(i2);
                switch (propertyType) {
                    case 1:
                        jSONObject.put(propertyName, jsObject.toBoolean(i2));
                        break;
                    case 2:
                        jSONObject.put(propertyName, jsObject.toInteger(i2));
                        break;
                    case 3:
                        jSONObject.put(propertyName, jsObject.toLong(i2));
                        break;
                    case 5:
                        try {
                            jSONObject.put(propertyName, jsObject.toDouble(i2));
                            break;
                        } catch (JSONException e2) {
                            if (f48594c) {
                                e2.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject) JDOUBLE : with json exception ", e2);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(i2);
                        if (objectArray == null) {
                            if (f48594c) {
                                throw new RuntimeException("parseParams(JsObject): jsObjects cannot be null");
                            }
                            break;
                        } else {
                            jSONObject.put(propertyName, p(objectArray));
                            break;
                        }
                    case 7:
                        jSONObject.put(propertyName, jsObject.toString(i2));
                        break;
                    case 8:
                        jSONObject.put(propertyName, jsObject.toJsFunction(i2));
                        break;
                    case 9:
                        jSONObject.put(propertyName, n(jsObject.toJsObject(i2)).second);
                        break;
                    case 10:
                        jSONObject.put(propertyName, jsObject.toJsArrayBuffer(i2));
                        break;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                String str2 = "parseParams(JsObject): with exception " + e3.getMessage();
                if (!f48594c) {
                    jsObject.release();
                    return new Pair<>(new d.a.m0.a.u.h.b(202, str2), null);
                }
                throw new RuntimeException(str2, e3);
            }
        }
        jsObject.release();
        return new Pair<>(new d.a.m0.a.u.h.b(0), jSONObject);
    }

    @NonNull
    public static Pair<d.a.m0.a.u.h.a, JSONObject> o(String str) {
        if (f48594c) {
            Log.d("Api-Base", "parseParams(String): String");
        }
        if (TextUtils.isEmpty(str)) {
            if (f48594c) {
                Log.e("Api-Base", "parseParams(String): json string cannot be empty");
            }
            return new Pair<>(new d.a.m0.a.u.h.b(202, "parseParams(String): json string cannot be empty"), null);
        }
        try {
            return new Pair<>(new d.a.m0.a.u.h.b(0), new JSONObject(str));
        } catch (JSONException e2) {
            if (f48594c) {
                e2.printStackTrace();
                Log.e("Api-Base", "parseParams(String): with json exception ", e2);
            }
            return new Pair<>(new d.a.m0.a.u.h.b(202, "parseParams(String): with json exception "), null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
        continue;
     */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray p(@NonNull JsObject[] jsObjectArr) {
        if (f48594c) {
            Log.d("Api-Base", "parseParams(JsObject[]): JsObject[]");
        }
        JSONArray jSONArray = new JSONArray();
        for (JsObject jsObject : jsObjectArr) {
            if (jsObject == null) {
                if (!f48594c) {
                    jSONArray.put((Object) null);
                } else {
                    throw new RuntimeException("parseParams(JsObject[]): jsObject cannot be null");
                }
            } else {
                switch (jsObject.getType()) {
                    case 0:
                        if (!f48594c) {
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
                            if (f48594c) {
                                e2.printStackTrace();
                                Log.e("Api-Base", "parseParams(JsObject[]) JDOUBLE : with json exception ", e2);
                            }
                            jSONArray.put((Object) null);
                            break;
                        }
                    case 6:
                        JsObject[] objectArray = jsObject.toObjectArray(0);
                        if (objectArray == null) {
                            if (!f48594c) {
                                jSONArray.put((Object) null);
                                continue;
                            } else {
                                throw new RuntimeException("parseParams(JsObject[]): objects is null");
                            }
                        } else {
                            jSONArray.put(p(objectArray));
                            break;
                        }
                    case 7:
                        jSONArray.put(jsObject.toString(0));
                        continue;
                    case 8:
                        jSONArray.put(jsObject.toJsFunction(0));
                        continue;
                    case 9:
                        jSONArray.put(n(jsObject).second);
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

    @Override // d.a.m0.a.u.c.a
    @NonNull
    public final d.a.m0.a.u.c.b a() {
        return this.f48595a;
    }

    @Override // d.a.m0.a.u.c.a
    public final void d(String str, d.a.m0.a.u.h.b bVar) {
        if (f48594c) {
            Log.d("Api-Base", "invokeCallback: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (f48594c) {
                Log.e("Api-Base", "invokeCallback: do callback with a empty callback");
                throw new RuntimeException("invokeCallback: do callback with a empty callback");
            }
        } else if (bVar == null) {
            if (f48594c) {
                Log.e("Api-Base", "invokeCallback: do callback with a null result");
                throw new RuntimeException("invokeCallback: do callback with a null result");
            }
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            q(str, bVar);
        } else {
            if (f48594c) {
                Log.d("Api-Base", "invokeCallback: other thread " + Thread.currentThread().getName());
            }
            if (d.a.m0.a.r1.l.e.a()) {
                q(str, bVar);
            } else {
                q0.X(new a(str, bVar));
            }
        }
    }

    @NonNull
    public final Context i() {
        return this.f48595a.getContext();
    }

    public d.a.m0.a.u.h.b j(String str, boolean z, b bVar) {
        e i2 = e.i();
        if (i2 == null) {
            return new d.a.m0.a.u.h.b(1001, "swan app is null");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-Base", str);
        d.a.m0.a.u.h.b bVar2 = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar2.isSuccess()) {
            d.a.m0.a.e0.d.b("Api-Base", "parse fail");
            return bVar2;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String str2 = null;
        if (z) {
            str2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(str2)) {
                d.a.m0.a.e0.d.b("Api-Base", "callback is null");
                return new d.a.m0.a.u.h.b(202, "callback is null");
            }
        }
        return bVar.a(i2, jSONObject, str2);
    }

    public d.a.m0.a.u.h.b k(@Nullable String str, @NonNull c cVar) {
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-Base", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (f48594c) {
                d.a.m0.a.e0.d.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.m0.a.e0.d.b("Api-Base", "cb is required");
            return new d.a.m0.a.u.h.b(202, "cb is required");
        }
        return cVar.f(jSONObject, optString, this);
    }

    public final boolean l() {
        e Q = e.Q();
        if (Q == null) {
            return true;
        }
        return Q.d0();
    }

    @UiThread
    public final void q(@NonNull String str, @NonNull d.a.m0.a.u.h.b bVar) {
        if (TextUtils.isEmpty(str) && !(this.f48596b instanceof NullableCallbackHandler)) {
            if (f48594c) {
                Log.e("Api-Base", "realInvokeCallback: callback check fail: " + str);
                return;
            }
            return;
        }
        if (f48594c) {
            Log.d("Api-Base", "realInvokeCallback: invoke 【" + str + "】 with 【" + bVar + "】");
        }
        this.f48596b.handleSchemeDispatchCallback(str, bVar.a());
    }
}
