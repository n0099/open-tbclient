package d.b.i0.r.y;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {
    public static final AtomicLong i = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);

    /* renamed from: a  reason: collision with root package name */
    public final String f51846a;

    /* renamed from: b  reason: collision with root package name */
    public final String f51847b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f51848c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f51849d;

    /* renamed from: e  reason: collision with root package name */
    public final int f51850e;

    /* renamed from: f  reason: collision with root package name */
    public final String f51851f;

    /* renamed from: g  reason: collision with root package name */
    public final long f51852g;

    /* renamed from: h  reason: collision with root package name */
    public final long f51853h;

    /* loaded from: classes3.dex */
    public static final class b extends m {
        public final k j;

        @Override // d.b.i0.r.y.m
        public void g(int i, Throwable th) {
            this.j.a(i, th);
        }

        @Override // d.b.i0.r.y.m
        public void h(JSONObject jSONObject) {
            this.j.b(this, jSONObject);
        }

        public b(int i, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i, str, str2, map, map2, str3, j);
            this.j = kVar;
        }
    }

    public static m a(int i2, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i2, str, str2, map, null, z ? d() : null, j);
    }

    public static String d() {
        long andIncrement = i.getAndIncrement();
        return "TBCWebViewJsBridge_callback_ID_" + andIncrement;
    }

    public static m i(Map<String, Object> map, long j, k kVar) {
        return new b(1, null, null, map, null, d(), kVar, j);
    }

    public static m j(String str, String str2, Map<String, Object> map, long j, boolean z) {
        return a(2, str, str2, map, j, z);
    }

    public static m k(String str, Map<String, Object> map) {
        return new m(3, null, null, null, map, str, -1L);
    }

    public String b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f51846a)) {
            jSONObject.put("cmd", this.f51846a);
        }
        if (!TextUtils.isEmpty(this.f51847b)) {
            jSONObject.put("method", this.f51847b);
        }
        Map<String, Object> map = this.f51848c;
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            e(this.f51848c, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        Map<String, Object> map2 = this.f51849d;
        if (map2 != null && !map2.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            e(this.f51849d, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", f());
        if (!TextUtils.isEmpty(this.f51851f)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.f51851f);
        }
        return c(jSONObject.toString());
    }

    public final String c(String str) {
        String replace = str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\u2028", "\\u2028").replace("\u2029", "\\u2029");
        return "javascript:__tb_js_bridge.send('" + replace + "');";
    }

    public final void e(Map<String, Object> map, JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    public final String f() {
        int i2 = this.f51850e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return "response";
                }
                throw new IllegalArgumentException("Unsupported request type");
            }
            return "request";
        }
        return "ping";
    }

    public void g(int i2, Throwable th) {
    }

    public void h(JSONObject jSONObject) {
    }

    public m(int i2, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, long j) {
        this.f51846a = str;
        this.f51847b = str2;
        this.f51848c = map;
        this.f51849d = map2;
        this.f51850e = i2;
        this.f51851f = str3;
        this.f51852g = j;
        this.f51853h = System.currentTimeMillis();
    }
}
