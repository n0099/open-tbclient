package d.b.l0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f64851b = AppConfig.isDebug();

    /* renamed from: c  reason: collision with root package name */
    public static volatile a0 f64852c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64853a = d.b.c0.b.a.a.g();

    public static a0 a() {
        if (f64852c == null) {
            synchronized (e.class) {
                if (f64852c == null) {
                    f64852c = new a0();
                }
            }
        }
        return f64852c;
    }

    public void b(String str, int i, String str2) {
        if (!this.f64853a || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("dbOverNum", i);
            jSONObject.put("tableName", str2);
            c("logDiscard", "database", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str, String str2, JSONObject jSONObject) {
        d0 d0Var = (d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (f64851b) {
            String jSONObject2 = jSONObject != null ? jSONObject.toString() : "";
            Log.d("UBCQualityStatics", "Quality event: type=" + str + ", value=" + str2 + ",ext=" + jSONObject2);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject3.put("type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject3.put("value", str2);
            }
            if (jSONObject != null) {
                jSONObject3.put("ext", jSONObject);
            }
            d0Var.onEvent("1876", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void d(String str, int i) {
        if (!this.f64853a || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("fileNum", i);
            c("logDiscard", "fileNum", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str, int i, int i2, int i3) {
        if (this.f64853a && !TextUtils.isEmpty(str)) {
            if (i == 0 && i2 == 0 && i3 == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                if (i != 0) {
                    jSONObject.put("flowExpired", i);
                }
                if (i2 != 0) {
                    jSONObject.put("eventExpired", i2);
                }
                if (i3 != 0) {
                    jSONObject.put("flowInterrupt", i3);
                }
                c("logDiscard", "timeExpired", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(String str) {
        if (this.f64853a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                c("logDiscard", "realLog", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g(String str) {
        if (this.f64853a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                c("sqlError", null, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void h(String str, String str2) {
        if (this.f64853a) {
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("msg", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("exception", str2);
                }
                c("sendFail", "requestError", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void i(String str) {
        if (this.f64853a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                c("sendFail", "bodyError", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(int i) {
        if (this.f64853a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", i);
                c("sendFail", "backend", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
