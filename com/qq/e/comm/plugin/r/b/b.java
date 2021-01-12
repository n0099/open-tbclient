package com.qq.e.comm.plugin.r.b;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f12377a;

    /* renamed from: b  reason: collision with root package name */
    private String f12378b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private List<a> h;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f12377a = jSONObject.optInt("ret_code");
            this.f12378b = jSONObject.optString("config_version");
            this.c = jSONObject.optString("country");
            this.d = jSONObject.optInt(TimeDisplaySetting.TIME_DISPLAY_SETTING);
            this.e = jSONObject.optInt("update_interval");
            this.f = jSONObject.optString("report_url");
            this.g = jSONObject.optString("app_view_id");
            this.h = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("layer_config");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.h.add(new a(optJSONArray.optJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String a() {
        return this.f12378b;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public List<a> e() {
        return this.h;
    }
}
