package com.kwai.video.ksvodplayerkit.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39896a;

    /* renamed from: b  reason: collision with root package name */
    public int f39897b;

    /* renamed from: c  reason: collision with root package name */
    public int f39898c;

    /* renamed from: d  reason: collision with root package name */
    public int f39899d;

    /* renamed from: e  reason: collision with root package name */
    public int f39900e;

    /* renamed from: f  reason: collision with root package name */
    public double f39901f;

    /* renamed from: g  reason: collision with root package name */
    public int f39902g;

    /* renamed from: h  reason: collision with root package name */
    public int f39903h;

    /* renamed from: i  reason: collision with root package name */
    public double f39904i;
    public double j;
    public double k;
    public int l;
    public int m;
    public double n;
    public double o;
    public double p;
    public double q;
    public double r;
    public double s;
    public int t;
    public int u;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39896a = 0;
        this.f39897b = 0;
        this.f39898c = 0;
        this.f39899d = 0;
        this.f39900e = 0;
        this.f39901f = 0.0d;
        this.f39902g = 0;
        this.f39903h = 0;
        this.f39904i = 0.0d;
        this.j = 0.0d;
        this.k = 60000.0d;
        this.l = 600000;
        this.m = 0;
        this.n = 1.0d;
        this.o = 10000.0d;
        this.p = 0.7d;
        this.q = 0.3d;
        this.r = 0.6d;
        this.s = 720.0d;
        this.t = 1280;
        this.u = 1;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("rate_adapt_type", this.f39896a);
                jSONObject.put("bandwidth_estimation_type", this.f39897b);
                jSONObject.put("absolute_low_res_low_device", this.f39898c);
                jSONObject.put("adapt_under_4G", this.f39899d);
                jSONObject.put("adapt_under_wifi", this.f39900e);
                jSONObject.put("adapt_under_other_net", this.f39901f);
                jSONObject.put("absolute_low_rate_4G", this.f39902g);
                jSONObject.put("absolute_low_rate_wifi", this.f39903h);
                jSONObject.put("absolute_low_res_4G", this.f39904i);
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
        return (String) invokeV.objValue;
    }
}
