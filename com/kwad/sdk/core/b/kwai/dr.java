package com.kwad.sdk.core.b.kwai;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.util.BaiduActiveStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class dr implements com.kwad.sdk.core.d {
    public static void a(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.Yt = jSONObject.optLong("request_prepare_cost");
        kVar.Yu = jSONObject.optLong("request_add_params_cost");
        kVar.Yv = jSONObject.optLong("request_create_cost");
        kVar.Yw = jSONObject.optInt("keep_alive");
        kVar.Yx = jSONObject.optLong("dns_start");
        kVar.Yy = jSONObject.optLong("dns_cost");
        kVar.Yz = jSONObject.optLong("connect_establish_start");
        kVar.YA = jSONObject.optLong("connect_establish_cost");
        kVar.YB = jSONObject.optLong(BaiduActiveStatistic.UBC_VALUE_REQUEST_START);
        kVar.YC = jSONObject.optLong("request_cost");
        kVar.YD = jSONObject.optLong("request_size");
        kVar.YE = jSONObject.optLong("response_start");
        kVar.YF = jSONObject.optLong("response_cost");
        kVar.YG = jSONObject.optLong("response_parse_cost");
        kVar.YH = jSONObject.optLong("response_size");
        kVar.YI = jSONObject.optLong("waiting_response_cost");
        kVar.YJ = jSONObject.optLong("total_cost");
        kVar.YK = jSONObject.optInt("proxy_used");
        kVar.YL = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
        if (jSONObject.opt(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID) == JSONObject.NULL) {
            kVar.YL = "";
        }
        kVar.YM = jSONObject.optInt("has_data_v2");
        kVar.result = jSONObject.optInt(TiebaStatic.LogFields.RESULT);
        kVar.YN = jSONObject.optLong("response_done_cost");
        kVar.YO = jSONObject.optString("host_ip");
        if (jSONObject.opt("host_ip") == JSONObject.NULL) {
            kVar.YO = "";
        }
        kVar.YP = jSONObject.optInt("ip_type");
        kVar.YQ = jSONObject.optInt("recommend_ping_time");
        kVar.YR = jSONObject.optInt("backup_ping_time");
        kVar.YS = jSONObject.optInt("other_ping_time");
    }

    public static JSONObject b(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = kVar.Yt;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = kVar.Yu;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = kVar.Yv;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = kVar.Yw;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = kVar.Yx;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = kVar.Yy;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = kVar.Yz;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = kVar.YA;
        if (j7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = kVar.YB;
        if (j8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, BaiduActiveStatistic.UBC_VALUE_REQUEST_START, j8);
        }
        long j9 = kVar.YC;
        if (j9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = kVar.YD;
        if (j10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "request_size", j10);
        }
        long j11 = kVar.YE;
        if (j11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "response_start", j11);
        }
        long j12 = kVar.YF;
        if (j12 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = kVar.YG;
        if (j13 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = kVar.YH;
        if (j14 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "response_size", j14);
        }
        long j15 = kVar.YI;
        if (j15 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = kVar.YJ;
        if (j16 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = kVar.YK;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "proxy_used", i2);
        }
        String str = kVar.YL;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, kVar.YL);
        }
        int i3 = kVar.YM;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = kVar.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, TiebaStatic.LogFields.RESULT, i4);
        }
        long j17 = kVar.YN;
        if (j17 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = kVar.YO;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "host_ip", kVar.YO);
        }
        int i5 = kVar.YP;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = kVar.YQ;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = kVar.YR;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = kVar.YS;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "other_ping_time", i8);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.k) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.k) bVar, jSONObject);
    }
}
