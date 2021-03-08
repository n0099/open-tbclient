package com.kwai.video.ksvodplayerkit.b;

import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f7281a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public double f = 0.0d;
    public int g = 0;
    public int h = 0;
    public double i = 0.0d;
    public double j = 0.0d;
    public double k = 60000.0d;
    public int l = UnitedSchemeMainDispatcher.SCHEME_TIME_LIMIT;
    public int m = 0;
    public double n = 1.0d;
    public double o = 10000.0d;
    public double p = 0.7d;
    public double q = 0.3d;
    public double r = 0.6d;
    public double s = 720.0d;
    public int t = 1280;
    public int u = 1;

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate_adapt_type", this.f7281a);
            jSONObject.put("bandwidth_estimation_type", this.b);
            jSONObject.put("absolute_low_res_low_device", this.c);
            jSONObject.put("adapt_under_4G", this.d);
            jSONObject.put("adapt_under_wifi", this.e);
            jSONObject.put("adapt_under_other_net", this.f);
            jSONObject.put("absolute_low_rate_4G", this.g);
            jSONObject.put("absolute_low_rate_wifi", this.h);
            jSONObject.put("absolute_low_res_4G", this.i);
            jSONObject.put("absolute_low_res_wifi", this.j);
            jSONObject.put("short_keep_interval", this.k);
            jSONObject.put("long_keep_interval", this.l);
            jSONObject.put("bitrate_init_level", this.m);
            jSONObject.put("default_weight", this.n);
            jSONObject.put("block_affected_interval", this.o);
            jSONObject.put("wifi_amend", this.p);
            jSONObject.put("fourG_amend", this.q);
            jSONObject.put("resolution_amend", this.r);
            jSONObject.put("device_width_threshold", this.s);
            jSONObject.put("device_hight_threshold", this.t);
            jSONObject.put("priority_policy", this.u);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
