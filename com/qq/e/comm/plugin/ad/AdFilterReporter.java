package com.qq.e.comm.plugin.ad;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.util.ai;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AdFilterReporter {

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f12165a = new JSONArray();

    /* renamed from: b  reason: collision with root package name */
    private String f12166b;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FilterCode {
        public static final int FILTER_INSTALLED = 2;
        public static final int FILTER_NONE = 0;
        public static final int FILTER_SPLASH = 3;
        public static final int FILTER_UNINSTALLED = 1;
    }

    public void a() {
        if (TextUtils.isEmpty(this.f12166b) || this.f12165a.length() <= 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.f12165a);
            String jSONObject2 = jSONObject.toString();
            ai.a("AdFilterReporter url:" + this.f12166b + " data:" + jSONObject2, new Object[0]);
            com.qq.e.comm.plugin.t.b.c cVar = new com.qq.e.comm.plugin.t.b.c(this.f12166b, e.a.POST, jSONObject2.getBytes(com.qq.e.comm.plugin.f.a.f12289a));
            cVar.a("Content-Type", HttpHelper.CONTENT_JSON);
            com.qq.e.comm.plugin.t.d.a().a(cVar);
        } catch (JSONException e) {
            ai.a("AdFilterReporter report error", e);
        }
        this.f12165a = new JSONArray();
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.f12166b)) {
            int indexOf = str.indexOf(63);
            if (indexOf == -1) {
                ai.a("AdFilterReporter fl is not valid:" + str, new Object[0]);
                return;
            }
            this.f12166b = str.substring(0, indexOf);
        }
        String queryParameter = Uri.parse(str).getQueryParameter("viewid");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("view_id", queryParameter);
            jSONObject.put("filter_code", i);
            this.f12165a.put(jSONObject);
        } catch (JSONException e) {
            ai.a("AdFilterReporter addData error", e);
        }
    }
}
