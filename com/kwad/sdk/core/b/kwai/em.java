package com.kwad.sdk.core.b.kwai;

import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class em implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.m> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.timestamp = jSONObject.optLong("timestamp");
        mVar.sessionId = jSONObject.optString("sessionId");
        if (jSONObject.opt("sessionId") == JSONObject.NULL) {
            mVar.sessionId = "";
        }
        mVar.aag = jSONObject.optLong("seq");
        mVar.aah = jSONObject.optLong("listId");
        mVar.aai = jSONObject.optLong("actionType");
        mVar.Mn = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            mVar.Mn = "";
        }
        mVar.llsid = jSONObject.optLong("llsid");
        mVar.aaj = jSONObject.optJSONObject("extra");
        mVar.aak = jSONObject.optJSONObject("impAdExtra");
        mVar.posId = jSONObject.optLong("posId");
        mVar.contentType = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE);
        mVar.realShowType = jSONObject.optInt("realShowType");
        mVar.photoId = jSONObject.optLong("photoId");
        mVar.position = jSONObject.optLong(CriusAttrConstants.POSITION);
        mVar.aal = jSONObject.optLong("serverPosition");
        mVar.aam = jSONObject.optLong("photoDuration");
        mVar.aan = jSONObject.optLong("effectivePlayDuration");
        mVar.aao = jSONObject.optLong("playDuration");
        mVar.blockDuration = jSONObject.optLong("blockDuration");
        mVar.aap = jSONObject.optLong("intervalDuration");
        mVar.aaq = jSONObject.optLong("allIntervalDuration");
        mVar.aar = jSONObject.optLong("flowSdk");
        mVar.aas = jSONObject.optLong("blockTimes");
        mVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        mVar.aat = jSONObject.optInt("adAggPageSource");
        mVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (jSONObject.opt("entryPageSource") == JSONObject.NULL) {
            mVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        mVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        mVar.aau = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        mVar.Iw = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        mVar.aav = jSONObject.optString("photoSize");
        if (jSONObject.opt("photoSize") == JSONObject.NULL) {
            mVar.aav = "";
        }
        mVar.aaw = jSONObject.optJSONArray("appInstalled");
        mVar.aax = jSONObject.optJSONArray("appUninstalled");
        m.a aVar = new m.a();
        mVar.aay = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        mVar.aaz = jSONObject.optInt("playerType");
        mVar.aaA = jSONObject.optInt(TaskResponseData.keyUiType);
        mVar.aaB = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        mVar.Mo = jSONObject.optInt("refreshType");
        mVar.aaC = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        mVar.failUrl = jSONObject.optString("failUrl");
        if (jSONObject.opt("failUrl") == JSONObject.NULL) {
            mVar.failUrl = "";
        }
        mVar.errorMsg = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            mVar.errorMsg = "";
        }
        mVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        mVar.creativeId = jSONObject.optLong("creativeId");
        mVar.aaF = jSONObject.optString("cacheFailedReason");
        if (jSONObject.opt("cacheFailedReason") == JSONObject.NULL) {
            mVar.aaF = "";
        }
        mVar.aaG = jSONObject.optJSONObject("appExt");
        mVar.aaH = jSONObject.optJSONArray("appRunningInfoList");
        mVar.downloadDuration = jSONObject.optLong("downloadDuration");
        mVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        mVar.aaI = jSONObject.optInt("speedLimitStatus");
        mVar.aaJ = jSONObject.optInt("speedLimitThreshold");
        mVar.aaK = jSONObject.optInt("currentRealDownloadSpeed");
        mVar.aaM = jSONObject.optJSONArray("sdkPlatform");
        mVar.aaN = jSONObject.optBoolean("isKsUnion");
        mVar.aaO = jSONObject.optString("trackMethodName");
        if (jSONObject.opt("trackMethodName") == JSONObject.NULL) {
            mVar.aaO = "";
        }
        mVar.aaP = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        mVar.clickTime = jSONObject.optLong("clickTime");
        mVar.aaR = jSONObject.optLong("frameRenderTime");
        mVar.aaS = jSONObject.optInt("playerEnterAction");
        mVar.aaT = jSONObject.optString("requestUrl");
        if (jSONObject.opt("requestUrl") == JSONObject.NULL) {
            mVar.aaT = "";
        }
        mVar.aaU = jSONObject.optLong("requestTotalTime");
        mVar.aaV = jSONObject.optLong("requestResponseTime");
        mVar.aaW = jSONObject.optLong("requestParseDataTime");
        mVar.aaX = jSONObject.optLong("requestCallbackTime");
        mVar.aaY = jSONObject.optString("requestFailReason");
        if (jSONObject.opt("requestFailReason") == JSONObject.NULL) {
            mVar.aaY = "";
        }
        mVar.Hx = jSONObject.optString("pageName");
        if (jSONObject.opt("pageName") == JSONObject.NULL) {
            mVar.Hx = "";
        }
        mVar.HE = jSONObject.optLong("pageCreateTime");
        mVar.HF = jSONObject.optLong("pageResumeTime");
        mVar.aaZ = jSONObject.optInt("trackUrlType");
        mVar.aba = jSONObject.optJSONArray("trackUrlList");
        mVar.HD = jSONObject.optLong("pageLaunchTime");
        mVar.abd = jSONObject.optJSONArray("appAuthorityInfoList");
        mVar.abe = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            mVar.abe = "";
        }
        mVar.abf = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            mVar.abf = "";
        }
        mVar.abg = jSONObject.optString("jsFileName");
        if (jSONObject.opt("jsFileName") == JSONObject.NULL) {
            mVar.abg = "";
        }
        mVar.abh = jSONObject.optString("jsErrorMsg");
        if (jSONObject.opt("jsErrorMsg") == JSONObject.NULL) {
            mVar.abh = "";
        }
        mVar.abi = jSONObject.optString("jsConfig");
        if (jSONObject.opt("jsConfig") == JSONObject.NULL) {
            mVar.abi = "";
        }
        mVar.abj = jSONObject.optInt("adBizType");
        mVar.abk = jSONObject.optString("customKey");
        if (jSONObject.opt("customKey") == JSONObject.NULL) {
            mVar.abk = "";
        }
        mVar.abl = jSONObject.optString("customValue");
        if (jSONObject.opt("customValue") == JSONObject.NULL) {
            mVar.abl = "";
        }
        mVar.trace = jSONObject.optString(Config.TRACE_PART);
        if (jSONObject.opt(Config.TRACE_PART) == JSONObject.NULL) {
            mVar.trace = "";
        }
        mVar.abm = jSONObject.optInt("filterCode");
        mVar.abn = jSONObject.optInt("sdkVersionCode");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = mVar.timestamp;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "timestamp", j);
        }
        String str = mVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sessionId", mVar.sessionId);
        }
        long j2 = mVar.aag;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "seq", j2);
        }
        long j3 = mVar.aah;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "listId", j3);
        }
        long j4 = mVar.aai;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "actionType", j4);
        }
        String str2 = mVar.Mn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "payload", mVar.Mn);
        }
        long j5 = mVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "llsid", j5);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "extra", mVar.aaj);
        com.kwad.sdk.utils.r.putValue(jSONObject, "impAdExtra", mVar.aak);
        long j6 = mVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posId", j6);
        }
        int i = mVar.contentType;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, i);
        }
        int i2 = mVar.realShowType;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "realShowType", i2);
        }
        long j7 = mVar.photoId;
        if (j7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoId", j7);
        }
        long j8 = mVar.position;
        if (j8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, CriusAttrConstants.POSITION, j8);
        }
        long j9 = mVar.aal;
        if (j9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "serverPosition", j9);
        }
        long j10 = mVar.aam;
        if (j10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoDuration", j10);
        }
        long j11 = mVar.aan;
        if (j11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "effectivePlayDuration", j11);
        }
        long j12 = mVar.aao;
        if (j12 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playDuration", j12);
        }
        long j13 = mVar.blockDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "blockDuration", j13);
        }
        long j14 = mVar.aap;
        if (j14 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "intervalDuration", j14);
        }
        long j15 = mVar.aaq;
        if (j15 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "allIntervalDuration", j15);
        }
        long j16 = mVar.aar;
        if (j16 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "flowSdk", j16);
        }
        long j17 = mVar.aas;
        if (j17 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "blockTimes", j17);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "contentSourceType", mVar.contentSourceType);
        int i3 = mVar.aat;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adAggPageSource", i3);
        }
        String str3 = mVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "entryPageSource", mVar.entryPageSource);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "urlPackage", mVar.urlPackage);
        com.kwad.sdk.utils.r.a(jSONObject, "referURLPackage", mVar.aau);
        long j18 = mVar.Iw;
        if (j18 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j18);
        }
        String str4 = mVar.aav;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "photoSize", mVar.aav);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "appInstalled", mVar.aaw);
        com.kwad.sdk.utils.r.putValue(jSONObject, "appUninstalled", mVar.aax);
        com.kwad.sdk.utils.r.a(jSONObject, "clientExt", mVar.aay);
        int i4 = mVar.aaz;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playerType", i4);
        }
        int i5 = mVar.aaA;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, TaskResponseData.keyUiType, i5);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "isLeftSlipStatus", mVar.aaB);
        int i6 = mVar.Mo;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "refreshType", i6);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "photoResponseType", mVar.aaC);
        String str5 = mVar.failUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "failUrl", mVar.failUrl);
        }
        String str6 = mVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "errorMsg", mVar.errorMsg);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "errorCode", mVar.errorCode);
        long j19 = mVar.creativeId;
        if (j19 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", j19);
        }
        String str7 = mVar.aaF;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "cacheFailedReason", mVar.aaF);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "appExt", mVar.aaG);
        com.kwad.sdk.utils.r.putValue(jSONObject, "appRunningInfoList", mVar.aaH);
        long j20 = mVar.downloadDuration;
        if (j20 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadDuration", j20);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "pageType", mVar.pageType);
        int i7 = mVar.aaI;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "speedLimitStatus", i7);
        }
        int i8 = mVar.aaJ;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "speedLimitThreshold", i8);
        }
        int i9 = mVar.aaK;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "currentRealDownloadSpeed", i9);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "sdkPlatform", mVar.aaM);
        boolean z = mVar.aaN;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = mVar.aaO;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "trackMethodName", mVar.aaO);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "viewModeType", mVar.aaP);
        long j21 = mVar.clickTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "clickTime", j21);
        }
        long j22 = mVar.aaR;
        if (j22 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "frameRenderTime", j22);
        }
        int i10 = mVar.aaS;
        if (i10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "playerEnterAction", i10);
        }
        String str9 = mVar.aaT;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestUrl", mVar.aaT);
        }
        long j23 = mVar.aaU;
        if (j23 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestTotalTime", j23);
        }
        long j24 = mVar.aaV;
        if (j24 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestResponseTime", j24);
        }
        long j25 = mVar.aaW;
        if (j25 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestParseDataTime", j25);
        }
        long j26 = mVar.aaX;
        if (j26 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestCallbackTime", j26);
        }
        String str10 = mVar.aaY;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "requestFailReason", mVar.aaY);
        }
        String str11 = mVar.Hx;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "pageName", mVar.Hx);
        }
        long j27 = mVar.HE;
        if (j27 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "pageCreateTime", j27);
        }
        long j28 = mVar.HF;
        if (j28 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "pageResumeTime", j28);
        }
        int i11 = mVar.aaZ;
        if (i11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "trackUrlType", i11);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "trackUrlList", mVar.aba);
        long j29 = mVar.HD;
        if (j29 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "pageLaunchTime", j29);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "appAuthorityInfoList", mVar.abd);
        String str12 = mVar.abe;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "tkVersion", mVar.abe);
        }
        String str13 = mVar.abf;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "jsVersion", mVar.abf);
        }
        String str14 = mVar.abg;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "jsFileName", mVar.abg);
        }
        String str15 = mVar.abh;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "jsErrorMsg", mVar.abh);
        }
        String str16 = mVar.abi;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "jsConfig", mVar.abi);
        }
        int i12 = mVar.abj;
        if (i12 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adBizType", i12);
        }
        String str17 = mVar.abk;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "customKey", mVar.abk);
        }
        String str18 = mVar.abl;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "customValue", mVar.abl);
        }
        String str19 = mVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, Config.TRACE_PART, mVar.trace);
        }
        int i13 = mVar.abm;
        if (i13 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "filterCode", i13);
        }
        int i14 = mVar.abn;
        if (i14 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "sdkVersionCode", i14);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }
}
