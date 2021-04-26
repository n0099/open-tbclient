package d.a.l0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f63151b = AppConfig.isDebug();

    /* renamed from: c  reason: collision with root package name */
    public static volatile b0 f63152c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63153a = d.a.c0.b.a.a.g();

    public static b0 a() {
        if (f63152c == null) {
            synchronized (e.class) {
                if (f63152c == null) {
                    f63152c = new b0();
                }
            }
        }
        return f63152c;
    }

    public void b(String str, int i2, String str2) {
        if (!this.f63153a || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("dbOverNum", i2);
            jSONObject.put("tableName", str2);
            c("logDiscard", "database", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(String str, String str2, JSONObject jSONObject) {
        e0 e0Var = (e0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (f63151b) {
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
            e0Var.onEvent("1876", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void d(String str, int i2) {
        if (!this.f63153a || TextUtils.isEmpty(str) || i2 == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
            jSONObject.put("fileNum", i2);
            c("logDiscard", "fileNum", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str, int i2, int i3, int i4) {
        if (this.f63153a && !TextUtils.isEmpty(str)) {
            if (i2 == 0 && i3 == 0 && i4 == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                if (i2 != 0) {
                    jSONObject.put("flowExpired", i2);
                }
                if (i3 != 0) {
                    jSONObject.put("eventExpired", i3);
                }
                if (i4 != 0) {
                    jSONObject.put("flowInterrupt", i4);
                }
                c("logDiscard", "timeExpired", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f(String str) {
        if (this.f63153a && !TextUtils.isEmpty(str)) {
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
        if (this.f63153a && !TextUtils.isEmpty(str)) {
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
        if (this.f63153a) {
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
        if (this.f63153a && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                c("sendFail", "bodyError", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void j(int i2) {
        if (this.f63153a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", i2);
                c("sendFail", "backend", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
