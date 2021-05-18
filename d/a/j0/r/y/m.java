package d.a.j0.r.y;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicLong f50314i = new AtomicLong((System.currentTimeMillis() / 1000) * 1000);

    /* renamed from: a  reason: collision with root package name */
    public final String f50315a;

    /* renamed from: b  reason: collision with root package name */
    public final String f50316b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f50317c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f50318d;

    /* renamed from: e  reason: collision with root package name */
    public final int f50319e;

    /* renamed from: f  reason: collision with root package name */
    public final String f50320f;

    /* renamed from: g  reason: collision with root package name */
    public final long f50321g;

    /* renamed from: h  reason: collision with root package name */
    public final long f50322h;

    /* loaded from: classes3.dex */
    public static final class b extends m {
        public final k j;

        @Override // d.a.j0.r.y.m
        public void g(int i2, Throwable th) {
            this.j.b(i2, th);
        }

        @Override // d.a.j0.r.y.m
        public void h(JSONObject jSONObject) {
            this.j.a(this, jSONObject);
        }

        public b(int i2, String str, String str2, Map<String, Object> map, Map<String, Object> map2, String str3, k kVar, long j) {
            super(i2, str, str2, map, map2, str3, j);
            this.j = kVar;
        }
    }

    public static m a(int i2, String str, String str2, Map<String, Object> map, long j, boolean z) {
        return new m(i2, str, str2, map, null, z ? d() : null, j);
    }

    public static String d() {
        long andIncrement = f50314i.getAndIncrement();
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
        if (!TextUtils.isEmpty(this.f50315a)) {
            jSONObject.put("cmd", this.f50315a);
        }
        if (!TextUtils.isEmpty(this.f50316b)) {
            jSONObject.put("method", this.f50316b);
        }
        Map<String, Object> map = this.f50317c;
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            e(this.f50317c, jSONObject2);
            jSONObject.put("inputData", jSONObject2);
        }
        Map<String, Object> map2 = this.f50318d;
        if (map2 != null && !map2.isEmpty()) {
            JSONObject jSONObject3 = new JSONObject();
            e(this.f50318d, jSONObject3);
            jSONObject.put("outputData", jSONObject3);
        }
        jSONObject.put("messageType", f());
        if (!TextUtils.isEmpty(this.f50320f)) {
            jSONObject.put(WBConstants.SHARE_CALLBACK_ID, this.f50320f);
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
        int i2 = this.f50319e;
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
        this.f50315a = str;
        this.f50316b = str2;
        this.f50317c = map;
        this.f50318d = map2;
        this.f50319e = i2;
        this.f50320f = str3;
        this.f50321g = j;
        this.f50322h = System.currentTimeMillis();
    }
}
