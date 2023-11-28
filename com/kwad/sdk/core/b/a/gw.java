package com.kwad.sdk.core.b.a;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.util.BaiduActiveStatistic;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class gw implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.atK = jSONObject.optLong("request_prepare_cost");
        jVar.atL = jSONObject.optLong("request_add_params_cost");
        jVar.atM = jSONObject.optLong("request_create_cost");
        jVar.atN = jSONObject.optInt("keep_alive");
        jVar.atO = jSONObject.optLong("dns_start");
        jVar.atP = jSONObject.optLong("dns_cost");
        jVar.atQ = jSONObject.optLong("connect_establish_start");
        jVar.atR = jSONObject.optLong("connect_establish_cost");
        jVar.atS = jSONObject.optLong(BaiduActiveStatistic.UBC_VALUE_REQUEST_START);
        jVar.atT = jSONObject.optLong("request_cost");
        jVar.atU = jSONObject.optLong("request_size");
        jVar.atV = jSONObject.optLong("response_start");
        jVar.atW = jSONObject.optLong("response_cost");
        jVar.atX = jSONObject.optLong("response_parse_cost");
        jVar.atY = jSONObject.optLong("response_size");
        jVar.atZ = jSONObject.optLong("waiting_response_cost");
        jVar.aua = jSONObject.optLong("total_cost");
        jVar.aub = jSONObject.optInt("proxy_used");
        jVar.auc = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
        if (JSONObject.NULL.toString().equals(jVar.auc)) {
            jVar.auc = "";
        }
        jVar.aud = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aue = jSONObject.optLong("response_done_cost");
        jVar.auf = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.auf)) {
            jVar.auf = "";
        }
        jVar.aug = jSONObject.optInt("ip_type");
        jVar.auh = jSONObject.optInt("recommend_ping_time");
        jVar.aui = jSONObject.optInt("backup_ping_time");
        jVar.auj = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = jVar.atK;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = jVar.atL;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = jVar.atM;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = jVar.atN;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = jVar.atO;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = jVar.atP;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = jVar.atQ;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = jVar.atR;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = jVar.atS;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BaiduActiveStatistic.UBC_VALUE_REQUEST_START, j8);
        }
        long j9 = jVar.atT;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = jVar.atU;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "request_size", j10);
        }
        long j11 = jVar.atV;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_start", j11);
        }
        long j12 = jVar.atW;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = jVar.atX;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = jVar.atY;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_size", j14);
        }
        long j15 = jVar.atZ;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = jVar.aua;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = jVar.aub;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "proxy_used", i2);
        }
        String str = jVar.auc;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, jVar.auc);
        }
        int i3 = jVar.aud;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = jVar.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "result", i4);
        }
        long j17 = jVar.aue;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = jVar.auf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "host_ip", jVar.auf);
        }
        int i5 = jVar.aug;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = jVar.auh;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = jVar.aui;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = jVar.auj;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "other_ping_time", i8);
        }
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
