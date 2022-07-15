package com.kwad.sdk.core.b.kwai;

import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.api.loader.ReportAction;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class eg implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.m> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.d = jSONObject.optLong("timestamp");
        mVar.e = jSONObject.optString("sessionId");
        if (jSONObject.opt("sessionId") == JSONObject.NULL) {
            mVar.e = "";
        }
        mVar.f = jSONObject.optLong("seq");
        mVar.h = jSONObject.optLong("listId");
        mVar.i = jSONObject.optLong("actionType");
        mVar.j = jSONObject.optString("payload");
        if (jSONObject.opt("payload") == JSONObject.NULL) {
            mVar.j = "";
        }
        mVar.k = jSONObject.optLong("llsid");
        mVar.l = jSONObject.optJSONObject("extra");
        mVar.m = jSONObject.optJSONObject("impAdExtra");
        mVar.n = jSONObject.optLong("posId");
        mVar.o = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE);
        mVar.p = jSONObject.optInt("realShowType");
        mVar.q = jSONObject.optLong("photoId");
        mVar.r = jSONObject.optLong(CriusAttrConstants.POSITION);
        mVar.s = jSONObject.optLong("serverPosition");
        mVar.t = jSONObject.optLong("photoDuration");
        mVar.u = jSONObject.optLong("effectivePlayDuration");
        mVar.v = jSONObject.optLong("playDuration");
        mVar.w = jSONObject.optLong("blockDuration");
        mVar.x = jSONObject.optLong("intervalDuration");
        mVar.y = jSONObject.optLong("allIntervalDuration");
        mVar.z = jSONObject.optLong("flowSdk");
        mVar.A = jSONObject.optLong("blockTimes");
        mVar.B = jSONObject.optInt("contentSourceType");
        mVar.C = jSONObject.optInt("adAggPageSource");
        mVar.D = jSONObject.optString("entryPageSource");
        if (jSONObject.opt("entryPageSource") == JSONObject.NULL) {
            mVar.D = "";
        }
        URLPackage uRLPackage = new URLPackage();
        mVar.E = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        mVar.F = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        mVar.G = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        mVar.H = jSONObject.optString("photoSize");
        if (jSONObject.opt("photoSize") == JSONObject.NULL) {
            mVar.H = "";
        }
        mVar.I = jSONObject.optJSONArray("appInstalled");
        mVar.J = jSONObject.optJSONArray("appUninstalled");
        m.a aVar = new m.a();
        mVar.K = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        mVar.L = jSONObject.optInt("playerType");
        mVar.M = jSONObject.optInt(TaskResponseData.keyUiType);
        mVar.N = jSONObject.optInt("isLeftSlipStatus");
        mVar.O = jSONObject.optInt("refreshType");
        mVar.P = jSONObject.optInt("photoResponseType");
        mVar.Q = jSONObject.optString("failUrl");
        if (jSONObject.opt("failUrl") == JSONObject.NULL) {
            mVar.Q = "";
        }
        mVar.R = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            mVar.R = "";
        }
        mVar.S = jSONObject.optInt("errorCode");
        mVar.T = jSONObject.optLong("creativeId");
        mVar.W = jSONObject.optString("cacheFailedReason");
        if (jSONObject.opt("cacheFailedReason") == JSONObject.NULL) {
            mVar.W = "";
        }
        mVar.X = jSONObject.optJSONObject("appExt");
        mVar.Y = jSONObject.optJSONArray("appRunningInfoList");
        mVar.Z = jSONObject.optLong(ReportAction.KEY_DOWNLOAD_DURATION);
        mVar.aa = jSONObject.optInt("pageType");
        mVar.ab = jSONObject.optInt("speedLimitStatus");
        mVar.ac = jSONObject.optInt("speedLimitThreshold");
        mVar.ad = jSONObject.optInt("currentRealDownloadSpeed");
        mVar.af = jSONObject.optJSONArray("sdkPlatform");
        mVar.ag = jSONObject.optBoolean("isKsUnion");
        mVar.ah = jSONObject.optString("trackMethodName");
        if (jSONObject.opt("trackMethodName") == JSONObject.NULL) {
            mVar.ah = "";
        }
        mVar.ai = jSONObject.optInt("viewModeType");
        mVar.ak = jSONObject.optLong("clickTime");
        mVar.al = jSONObject.optLong("frameRenderTime");
        mVar.am = jSONObject.optInt("playerEnterAction");
        mVar.an = jSONObject.optString("requestUrl");
        if (jSONObject.opt("requestUrl") == JSONObject.NULL) {
            mVar.an = "";
        }
        mVar.ao = jSONObject.optLong("requestTotalTime");
        mVar.ap = jSONObject.optLong("requestResponseTime");
        mVar.aq = jSONObject.optLong("requestParseDataTime");
        mVar.ar = jSONObject.optLong("requestCallbackTime");
        mVar.as = jSONObject.optString("requestFailReason");
        if (jSONObject.opt("requestFailReason") == JSONObject.NULL) {
            mVar.as = "";
        }
        mVar.at = jSONObject.optString("pageName");
        if (jSONObject.opt("pageName") == JSONObject.NULL) {
            mVar.at = "";
        }
        mVar.au = jSONObject.optLong("pageCreateTime");
        mVar.av = jSONObject.optLong("pageResumeTime");
        mVar.aw = jSONObject.optJSONArray("trackUrlList");
        mVar.ax = jSONObject.optLong("pageLaunchTime");
        mVar.aA = jSONObject.optJSONArray("appAuthorityInfoList");
        mVar.aB = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            mVar.aB = "";
        }
        mVar.aC = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            mVar.aC = "";
        }
        mVar.aD = jSONObject.optString("jsFileName");
        if (jSONObject.opt("jsFileName") == JSONObject.NULL) {
            mVar.aD = "";
        }
        mVar.aE = jSONObject.optString("jsErrorMsg");
        if (jSONObject.opt("jsErrorMsg") == JSONObject.NULL) {
            mVar.aE = "";
        }
        mVar.aF = jSONObject.optString("jsConfig");
        if (jSONObject.opt("jsConfig") == JSONObject.NULL) {
            mVar.aF = "";
        }
        mVar.aG = jSONObject.optInt("adBizType");
        mVar.aH = jSONObject.optString("customKey");
        if (jSONObject.opt("customKey") == JSONObject.NULL) {
            mVar.aH = "";
        }
        mVar.aI = jSONObject.optString("customValue");
        if (jSONObject.opt("customValue") == JSONObject.NULL) {
            mVar.aI = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "timestamp", mVar.d);
        com.kwad.sdk.utils.r.a(jSONObject, "sessionId", mVar.e);
        com.kwad.sdk.utils.r.a(jSONObject, "seq", mVar.f);
        com.kwad.sdk.utils.r.a(jSONObject, "listId", mVar.h);
        com.kwad.sdk.utils.r.a(jSONObject, "actionType", mVar.i);
        com.kwad.sdk.utils.r.a(jSONObject, "payload", mVar.j);
        com.kwad.sdk.utils.r.a(jSONObject, "llsid", mVar.k);
        com.kwad.sdk.utils.r.a(jSONObject, "extra", mVar.l);
        com.kwad.sdk.utils.r.a(jSONObject, "impAdExtra", mVar.m);
        com.kwad.sdk.utils.r.a(jSONObject, "posId", mVar.n);
        com.kwad.sdk.utils.r.a(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, mVar.o);
        com.kwad.sdk.utils.r.a(jSONObject, "realShowType", mVar.p);
        com.kwad.sdk.utils.r.a(jSONObject, "photoId", mVar.q);
        com.kwad.sdk.utils.r.a(jSONObject, CriusAttrConstants.POSITION, mVar.r);
        com.kwad.sdk.utils.r.a(jSONObject, "serverPosition", mVar.s);
        com.kwad.sdk.utils.r.a(jSONObject, "photoDuration", mVar.t);
        com.kwad.sdk.utils.r.a(jSONObject, "effectivePlayDuration", mVar.u);
        com.kwad.sdk.utils.r.a(jSONObject, "playDuration", mVar.v);
        com.kwad.sdk.utils.r.a(jSONObject, "blockDuration", mVar.w);
        com.kwad.sdk.utils.r.a(jSONObject, "intervalDuration", mVar.x);
        com.kwad.sdk.utils.r.a(jSONObject, "allIntervalDuration", mVar.y);
        com.kwad.sdk.utils.r.a(jSONObject, "flowSdk", mVar.z);
        com.kwad.sdk.utils.r.a(jSONObject, "blockTimes", mVar.A);
        com.kwad.sdk.utils.r.a(jSONObject, "contentSourceType", mVar.B);
        com.kwad.sdk.utils.r.a(jSONObject, "adAggPageSource", mVar.C);
        com.kwad.sdk.utils.r.a(jSONObject, "entryPageSource", mVar.D);
        com.kwad.sdk.utils.r.a(jSONObject, "urlPackage", mVar.E);
        com.kwad.sdk.utils.r.a(jSONObject, "referURLPackage", mVar.F);
        com.kwad.sdk.utils.r.a(jSONObject, URLPackage.KEY_AUTHOR_ID, mVar.G);
        com.kwad.sdk.utils.r.a(jSONObject, "photoSize", mVar.H);
        com.kwad.sdk.utils.r.a(jSONObject, "appInstalled", mVar.I);
        com.kwad.sdk.utils.r.a(jSONObject, "appUninstalled", mVar.J);
        com.kwad.sdk.utils.r.a(jSONObject, "clientExt", mVar.K);
        com.kwad.sdk.utils.r.a(jSONObject, "playerType", mVar.L);
        com.kwad.sdk.utils.r.a(jSONObject, TaskResponseData.keyUiType, mVar.M);
        com.kwad.sdk.utils.r.a(jSONObject, "isLeftSlipStatus", mVar.N);
        com.kwad.sdk.utils.r.a(jSONObject, "refreshType", mVar.O);
        com.kwad.sdk.utils.r.a(jSONObject, "photoResponseType", mVar.P);
        com.kwad.sdk.utils.r.a(jSONObject, "failUrl", mVar.Q);
        com.kwad.sdk.utils.r.a(jSONObject, "errorMsg", mVar.R);
        com.kwad.sdk.utils.r.a(jSONObject, "errorCode", mVar.S);
        com.kwad.sdk.utils.r.a(jSONObject, "creativeId", mVar.T);
        com.kwad.sdk.utils.r.a(jSONObject, "cacheFailedReason", mVar.W);
        com.kwad.sdk.utils.r.a(jSONObject, "appExt", mVar.X);
        com.kwad.sdk.utils.r.a(jSONObject, "appRunningInfoList", mVar.Y);
        com.kwad.sdk.utils.r.a(jSONObject, ReportAction.KEY_DOWNLOAD_DURATION, mVar.Z);
        com.kwad.sdk.utils.r.a(jSONObject, "pageType", mVar.aa);
        com.kwad.sdk.utils.r.a(jSONObject, "speedLimitStatus", mVar.ab);
        com.kwad.sdk.utils.r.a(jSONObject, "speedLimitThreshold", mVar.ac);
        com.kwad.sdk.utils.r.a(jSONObject, "currentRealDownloadSpeed", mVar.ad);
        com.kwad.sdk.utils.r.a(jSONObject, "sdkPlatform", mVar.af);
        com.kwad.sdk.utils.r.a(jSONObject, "isKsUnion", mVar.ag);
        com.kwad.sdk.utils.r.a(jSONObject, "trackMethodName", mVar.ah);
        com.kwad.sdk.utils.r.a(jSONObject, "viewModeType", mVar.ai);
        com.kwad.sdk.utils.r.a(jSONObject, "clickTime", mVar.ak);
        com.kwad.sdk.utils.r.a(jSONObject, "frameRenderTime", mVar.al);
        com.kwad.sdk.utils.r.a(jSONObject, "playerEnterAction", mVar.am);
        com.kwad.sdk.utils.r.a(jSONObject, "requestUrl", mVar.an);
        com.kwad.sdk.utils.r.a(jSONObject, "requestTotalTime", mVar.ao);
        com.kwad.sdk.utils.r.a(jSONObject, "requestResponseTime", mVar.ap);
        com.kwad.sdk.utils.r.a(jSONObject, "requestParseDataTime", mVar.aq);
        com.kwad.sdk.utils.r.a(jSONObject, "requestCallbackTime", mVar.ar);
        com.kwad.sdk.utils.r.a(jSONObject, "requestFailReason", mVar.as);
        com.kwad.sdk.utils.r.a(jSONObject, "pageName", mVar.at);
        com.kwad.sdk.utils.r.a(jSONObject, "pageCreateTime", mVar.au);
        com.kwad.sdk.utils.r.a(jSONObject, "pageResumeTime", mVar.av);
        com.kwad.sdk.utils.r.a(jSONObject, "trackUrlList", mVar.aw);
        com.kwad.sdk.utils.r.a(jSONObject, "pageLaunchTime", mVar.ax);
        com.kwad.sdk.utils.r.a(jSONObject, "appAuthorityInfoList", mVar.aA);
        com.kwad.sdk.utils.r.a(jSONObject, "tkVersion", mVar.aB);
        com.kwad.sdk.utils.r.a(jSONObject, "jsVersion", mVar.aC);
        com.kwad.sdk.utils.r.a(jSONObject, "jsFileName", mVar.aD);
        com.kwad.sdk.utils.r.a(jSONObject, "jsErrorMsg", mVar.aE);
        com.kwad.sdk.utils.r.a(jSONObject, "jsConfig", mVar.aF);
        com.kwad.sdk.utils.r.a(jSONObject, "adBizType", mVar.aG);
        com.kwad.sdk.utils.r.a(jSONObject, "customKey", mVar.aH);
        com.kwad.sdk.utils.r.a(jSONObject, "customValue", mVar.aI);
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
