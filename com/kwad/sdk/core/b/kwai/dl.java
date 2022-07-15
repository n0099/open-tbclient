package com.kwad.sdk.core.b.kwai;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dl implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.i = jSONObject.optLong("request_prepare_cost");
        jVar.j = jSONObject.optLong("request_add_params_cost");
        jVar.k = jSONObject.optLong("request_create_cost");
        jVar.l = jSONObject.optInt("keep_alive");
        jVar.m = jSONObject.optLong("dns_start");
        jVar.n = jSONObject.optLong("dns_cost");
        jVar.o = jSONObject.optLong("connect_establish_start");
        jVar.p = jSONObject.optLong("connect_establish_cost");
        jVar.q = jSONObject.optLong("request_start");
        jVar.r = jSONObject.optLong("request_cost");
        jVar.s = jSONObject.optLong("request_size");
        jVar.t = jSONObject.optLong("response_start");
        jVar.u = jSONObject.optLong("response_cost");
        jVar.v = jSONObject.optLong("response_parse_cost");
        jVar.w = jSONObject.optLong("response_size");
        jVar.x = jSONObject.optLong("waiting_response_cost");
        jVar.y = jSONObject.optLong("total_cost");
        jVar.z = jSONObject.optInt("proxy_used");
        jVar.A = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
        if (jSONObject.opt(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID) == JSONObject.NULL) {
            jVar.A = "";
        }
        jVar.B = jSONObject.optInt("has_data_v2");
        jVar.C = jSONObject.optInt("result");
        jVar.D = jSONObject.optLong("response_done_cost");
        jVar.E = jSONObject.optString("host_ip");
        if (jSONObject.opt("host_ip") == JSONObject.NULL) {
            jVar.E = "";
        }
        jVar.F = jSONObject.optInt("ip_type");
        jVar.G = jSONObject.optInt("recommend_ping_time");
        jVar.H = jSONObject.optInt("backup_ping_time");
        jVar.I = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "request_prepare_cost", jVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, "request_add_params_cost", jVar.j);
        com.kwad.sdk.utils.r.a(jSONObject, "request_create_cost", jVar.k);
        com.kwad.sdk.utils.r.a(jSONObject, "keep_alive", jVar.l);
        com.kwad.sdk.utils.r.a(jSONObject, "dns_start", jVar.m);
        com.kwad.sdk.utils.r.a(jSONObject, "dns_cost", jVar.n);
        com.kwad.sdk.utils.r.a(jSONObject, "connect_establish_start", jVar.o);
        com.kwad.sdk.utils.r.a(jSONObject, "connect_establish_cost", jVar.p);
        com.kwad.sdk.utils.r.a(jSONObject, "request_start", jVar.q);
        com.kwad.sdk.utils.r.a(jSONObject, "request_cost", jVar.r);
        com.kwad.sdk.utils.r.a(jSONObject, "request_size", jVar.s);
        com.kwad.sdk.utils.r.a(jSONObject, "response_start", jVar.t);
        com.kwad.sdk.utils.r.a(jSONObject, "response_cost", jVar.u);
        com.kwad.sdk.utils.r.a(jSONObject, "response_parse_cost", jVar.v);
        com.kwad.sdk.utils.r.a(jSONObject, "response_size", jVar.w);
        com.kwad.sdk.utils.r.a(jSONObject, "waiting_response_cost", jVar.x);
        com.kwad.sdk.utils.r.a(jSONObject, "total_cost", jVar.y);
        com.kwad.sdk.utils.r.a(jSONObject, "proxy_used", jVar.z);
        com.kwad.sdk.utils.r.a(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, jVar.A);
        com.kwad.sdk.utils.r.a(jSONObject, "has_data_v2", jVar.B);
        com.kwad.sdk.utils.r.a(jSONObject, "result", jVar.C);
        com.kwad.sdk.utils.r.a(jSONObject, "response_done_cost", jVar.D);
        com.kwad.sdk.utils.r.a(jSONObject, "host_ip", jVar.E);
        com.kwad.sdk.utils.r.a(jSONObject, "ip_type", jVar.F);
        com.kwad.sdk.utils.r.a(jSONObject, "recommend_ping_time", jVar.G);
        com.kwad.sdk.utils.r.a(jSONObject, "backup_ping_time", jVar.H);
        com.kwad.sdk.utils.r.a(jSONObject, "other_ping_time", jVar.I);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
