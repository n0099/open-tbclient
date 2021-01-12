package com.qq.e.comm.plugin.splash.a;

import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.qq.e.comm.util.Md5Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static String f12456a = "uoid";

    /* renamed from: b  reason: collision with root package name */
    static String f12457b = "date";
    static String c = "exposureUrl";
    static String d = "customUrls";
    static String e = "c2sSdkUrls";
    public String f;
    public String g;
    public String h;
    public List<String> i;
    public List<String> j;

    public a() {
    }

    public a(String str) {
        a(str);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f = jSONObject.optString(f12456a, "");
            this.g = jSONObject.optString(f12457b, "");
            this.h = jSONObject.optString(c, "");
            JSONArray jSONArray = jSONObject.getJSONArray(d);
            if (jSONArray != null && jSONArray.length() > 0) {
                this.i = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.i.add(jSONArray.getString(i));
                }
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(e);
            if (jSONArray2 == null || jSONArray2.length() <= 0) {
                return;
            }
            this.j = new ArrayList();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.j.add(jSONArray2.getString(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put(f12456a, this.f);
            }
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put(f12457b, this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put(c, this.h);
            }
            if (this.i != null && this.i.size() > 0) {
                jSONObject.put(d, new JSONArray((Collection) this.i));
            }
            if (this.j != null && this.j.size() > 0) {
                jSONObject.put(e, new JSONArray((Collection) this.j));
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String b() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) ? "" : Md5Util.encode(this.f + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.g);
    }
}
