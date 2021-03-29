package com.kwai.video.ksvodplayerkit.b;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f37263a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f37264b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f37265c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f37266d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f37267e = 0;

    /* renamed from: f  reason: collision with root package name */
    public double f37268f = 0.0d;

    /* renamed from: g  reason: collision with root package name */
    public int f37269g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f37270h = 0;
    public double i = 0.0d;
    public double j = 0.0d;
    public double k = 60000.0d;
    public int l = 600000;
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
            jSONObject.put("rate_adapt_type", this.f37263a);
            jSONObject.put("bandwidth_estimation_type", this.f37264b);
            jSONObject.put("absolute_low_res_low_device", this.f37265c);
            jSONObject.put("adapt_under_4G", this.f37266d);
            jSONObject.put("adapt_under_wifi", this.f37267e);
            jSONObject.put("adapt_under_other_net", this.f37268f);
            jSONObject.put("absolute_low_rate_4G", this.f37269g);
            jSONObject.put("absolute_low_rate_wifi", this.f37270h);
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
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
