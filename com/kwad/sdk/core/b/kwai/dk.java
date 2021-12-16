package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.core.report.ReportAction;
import com.kwad.sdk.core.scene.URLPackage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dk implements com.kwad.sdk.core.d<ReportAction> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public dk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(ReportAction reportAction, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, reportAction, jSONObject) == null) || jSONObject == null) {
            return;
        }
        reportAction.f58219d = jSONObject.optLong("timestamp");
        reportAction.f58220e = jSONObject.optString("sessionId");
        if (jSONObject.opt("sessionId") == JSONObject.NULL) {
            reportAction.f58220e = "";
        }
        reportAction.f58221f = jSONObject.optLong("seq");
        reportAction.f58223h = jSONObject.optLong("listId");
        reportAction.f58224i = jSONObject.optLong(LightInvokerImpl.VOICE_ACTIONTYPE);
        reportAction.f58225j = jSONObject.optLong("llsid");
        reportAction.f58226k = jSONObject.optJSONObject("extra");
        reportAction.l = jSONObject.optJSONObject("impAdExtra");
        reportAction.m = jSONObject.optLong("posId");
        reportAction.n = jSONObject.optInt("contentType");
        reportAction.o = jSONObject.optInt("realShowType");
        reportAction.p = jSONObject.optLong("photoId");
        reportAction.q = jSONObject.optLong("position");
        reportAction.r = jSONObject.optLong("serverPosition");
        reportAction.s = jSONObject.optLong("photoDuration");
        reportAction.t = jSONObject.optLong("effectivePlayDuration");
        reportAction.u = jSONObject.optLong("playDuration");
        reportAction.v = jSONObject.optLong("startDuration");
        reportAction.w = jSONObject.optLong("stayDuration");
        reportAction.x = jSONObject.optLong("stayLength");
        reportAction.y = jSONObject.optLong("blockDuration");
        reportAction.z = jSONObject.optLong("intervalDuration");
        reportAction.A = jSONObject.optLong("allIntervalDuration");
        reportAction.B = jSONObject.optLong("flowSdk");
        reportAction.C = jSONObject.optLong("blockTimes");
        reportAction.D = jSONObject.optString("tabName");
        if (jSONObject.opt("tabName") == JSONObject.NULL) {
            reportAction.D = "";
        }
        reportAction.E = jSONObject.optInt("nextPageType");
        reportAction.F = jSONObject.optInt("contentSourceType");
        reportAction.G = jSONObject.optInt("enterType");
        reportAction.H = jSONObject.optInt("leaveType");
        reportAction.J = jSONObject.optInt("adAggPageSource");
        reportAction.K = jSONObject.optString("entryPageSource");
        if (jSONObject.opt("entryPageSource") == JSONObject.NULL) {
            reportAction.K = "";
        }
        URLPackage uRLPackage = new URLPackage();
        reportAction.L = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        reportAction.M = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        reportAction.N = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        reportAction.O = jSONObject.optInt("likeStatus");
        reportAction.P = jSONObject.optString("photoSize");
        if (jSONObject.opt("photoSize") == JSONObject.NULL) {
            reportAction.P = "";
        }
        reportAction.Q = jSONObject.optInt("playEnd");
        reportAction.R = jSONObject.optInt("dragProgressType");
        reportAction.S = jSONObject.optLong("dragProgressPhotoDuration");
        reportAction.T = jSONObject.optLong("dragProgressVideoTime");
        reportAction.U = jSONObject.optInt("likeType");
        reportAction.W = jSONObject.optInt("shareResult");
        reportAction.X = jSONObject.optJSONArray("appInstalled");
        reportAction.Y = jSONObject.optJSONArray("appUninstalled");
        reportAction.Z = jSONObject.optString("coverUrl");
        if (jSONObject.opt("coverUrl") == JSONObject.NULL) {
            reportAction.Z = "";
        }
        reportAction.aa = jSONObject.optString("videoCurrentUrl");
        if (jSONObject.opt("videoCurrentUrl") == JSONObject.NULL) {
            reportAction.aa = "";
        }
        reportAction.ab = jSONObject.optString("entryId");
        if (jSONObject.opt("entryId") == JSONObject.NULL) {
            reportAction.ab = "";
        }
        reportAction.ac = jSONObject.optString("pushUrl");
        if (jSONObject.opt("pushUrl") == JSONObject.NULL) {
            reportAction.ac = "";
        }
        reportAction.ad = jSONObject.optLong("commentId");
        reportAction.ae = jSONObject.optLong("seenCount");
        reportAction.af = jSONObject.optInt(PushConstants.CLICK_TYPE);
        reportAction.ag = jSONObject.optInt("buttonPictureClick");
        reportAction.ah = jSONObject.optString("recoExt");
        if (jSONObject.opt("recoExt") == JSONObject.NULL) {
            reportAction.ah = "";
        }
        ReportAction.a aVar = new ReportAction.a();
        reportAction.ai = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        reportAction.aj = jSONObject.optInt("playerType");
        reportAction.ak = jSONObject.optInt(TaskResponseData.keyUiType);
        reportAction.al = jSONObject.optString("tubeName");
        if (jSONObject.opt("tubeName") == JSONObject.NULL) {
            reportAction.al = "";
        }
        reportAction.am = jSONObject.optLong(URLPackage.KEY_TUBE_ID);
        reportAction.an = jSONObject.optString("episodeName");
        if (jSONObject.opt("episodeName") == JSONObject.NULL) {
            reportAction.an = "";
        }
        reportAction.ao = jSONObject.optString("trendName");
        if (jSONObject.opt("trendName") == JSONObject.NULL) {
            reportAction.ao = "";
        }
        reportAction.ap = jSONObject.optLong(URLPackage.KEY_TREND_ID);
        reportAction.ar = jSONObject.optLong("relatedContentSourceType");
        reportAction.as = jSONObject.optInt("adHorizontalFeedType");
        reportAction.at = jSONObject.optInt("videoPlayMode");
        reportAction.au = jSONObject.optInt("autoReplayTimes");
        reportAction.aw = jSONObject.optInt("closeType");
        reportAction.ax = jSONObject.optInt("isLeftSlipStatus");
        reportAction.ay = jSONObject.optInt("preloadType");
        reportAction.az = jSONObject.optJSONArray("preloadPhotoList");
        reportAction.aA = jSONObject.optInt("refreshType");
        reportAction.aB = jSONObject.optInt("photoResponseType");
        reportAction.aC = jSONObject.optString("failUrl");
        if (jSONObject.opt("failUrl") == JSONObject.NULL) {
            reportAction.aC = "";
        }
        reportAction.aD = jSONObject.optString("errorMsg");
        if (jSONObject.opt("errorMsg") == JSONObject.NULL) {
            reportAction.aD = "";
        }
        reportAction.aE = jSONObject.optInt("errorCode");
        reportAction.aF = jSONObject.optLong("creativeId");
        ReportAction.LiveLogInfo liveLogInfo = new ReportAction.LiveLogInfo();
        reportAction.aG = liveLogInfo;
        liveLogInfo.parseJson(jSONObject.optJSONObject("liveLogInfo"));
        reportAction.aH = jSONObject.optString("moduleName");
        if (jSONObject.opt("moduleName") == JSONObject.NULL) {
            reportAction.aH = "";
        }
        reportAction.aK = jSONObject.optString("cacheFailedReason");
        if (jSONObject.opt("cacheFailedReason") == JSONObject.NULL) {
            reportAction.aK = "";
        }
        reportAction.aL = jSONObject.optString("componentPosition");
        if (jSONObject.opt("componentPosition") == JSONObject.NULL) {
            reportAction.aL = "";
        }
        reportAction.aM = jSONObject.optJSONObject("appExt");
        reportAction.aN = jSONObject.optJSONArray("appRunningInfoList");
        reportAction.aO = jSONObject.optLong(com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION);
        reportAction.aP = jSONObject.optInt("pageType");
        reportAction.aQ = jSONObject.optInt("guideTimes");
        reportAction.aR = jSONObject.optInt("speedLimitStatus");
        reportAction.aS = jSONObject.optInt("speedLimitThreshold");
        reportAction.aT = jSONObject.optInt("currentRealDownloadSpeed");
        reportAction.aV = jSONObject.optJSONArray("sdkPlatform");
        reportAction.aW = jSONObject.optBoolean("isKsUnion");
        reportAction.aX = jSONObject.optString("trackMethodName");
        if (jSONObject.opt("trackMethodName") == JSONObject.NULL) {
            reportAction.aX = "";
        }
        reportAction.aY = jSONObject.optInt("viewModeType");
        reportAction.ba = jSONObject.optInt("playAgainControlledType");
        reportAction.bb = jSONObject.optString("mediaShareStr");
        if (jSONObject.opt("mediaShareStr") == JSONObject.NULL) {
            reportAction.bb = "";
        }
        reportAction.bc = jSONObject.optLong("clickTime");
        reportAction.bd = jSONObject.optLong("frameRenderTime");
        reportAction.be = jSONObject.optInt("playerEnterAction");
        reportAction.bf = jSONObject.optString("requestUrl");
        if (jSONObject.opt("requestUrl") == JSONObject.NULL) {
            reportAction.bf = "";
        }
        reportAction.bg = jSONObject.optLong("requestTotalTime");
        reportAction.bh = jSONObject.optLong("requestResponseTime");
        reportAction.bi = jSONObject.optLong("requestParseDataTime");
        reportAction.bj = jSONObject.optLong("requestCallbackTime");
        reportAction.bk = jSONObject.optString("requestFailReason");
        if (jSONObject.opt("requestFailReason") == JSONObject.NULL) {
            reportAction.bk = "";
        }
        reportAction.bl = jSONObject.optString("pageName");
        if (jSONObject.opt("pageName") == JSONObject.NULL) {
            reportAction.bl = "";
        }
        reportAction.bm = jSONObject.optLong("pageCreateTime");
        reportAction.bn = jSONObject.optLong("pageResumeTime");
        reportAction.bo = jSONObject.optJSONArray("trackUrlList");
        reportAction.bp = jSONObject.optLong("pageLaunchTime");
        reportAction.bs = jSONObject.optJSONArray("appAuthorityInfoList");
        reportAction.bt = jSONObject.optInt("entryRealRefresh");
        reportAction.bu = jSONObject.optString("tkVersion");
        if (jSONObject.opt("tkVersion") == JSONObject.NULL) {
            reportAction.bu = "";
        }
        reportAction.bv = jSONObject.optString("jsVersion");
        if (jSONObject.opt("jsVersion") == JSONObject.NULL) {
            reportAction.bv = "";
        }
        reportAction.bw = jSONObject.optString("jsFileName");
        if (jSONObject.opt("jsFileName") == JSONObject.NULL) {
            reportAction.bw = "";
        }
        reportAction.bx = jSONObject.optString("jsErrorMsg");
        if (jSONObject.opt("jsErrorMsg") == JSONObject.NULL) {
            reportAction.bx = "";
        }
        reportAction.by = jSONObject.optString("jsConfig");
        if (jSONObject.opt("jsConfig") == JSONObject.NULL) {
            reportAction.by = "";
        }
        reportAction.bz = jSONObject.optString("sceneId");
        if (jSONObject.opt("sceneId") == JSONObject.NULL) {
            reportAction.bz = "";
        }
        reportAction.bA = jSONObject.optString("h5Version");
        if (jSONObject.opt("h5Version") == JSONObject.NULL) {
            reportAction.bA = "";
        }
        reportAction.bB = jSONObject.optInt("loadType");
        reportAction.bC = jSONObject.optInt(ShaderParams.VALUE_TYPE_STEP);
        reportAction.bD = jSONObject.optLong("interval");
        reportAction.bE = jSONObject.optInt("failStep");
        reportAction.bF = jSONObject.optString("failReason");
        if (jSONObject.opt("failReason") == JSONObject.NULL) {
            reportAction.bF = "";
        }
        reportAction.bG = jSONObject.optInt("couponStatus");
        reportAction.bH = jSONObject.optDouble("readPct");
        reportAction.bI = jSONObject.optString("lostReason");
        if (jSONObject.opt("lostReason") == JSONObject.NULL) {
            reportAction.bI = "";
        }
        reportAction.bJ = jSONObject.optInt("photoType");
        reportAction.bK = jSONObject.optInt("adBizType");
        reportAction.bL = jSONObject.optString("customKey");
        if (jSONObject.opt("customKey") == JSONObject.NULL) {
            reportAction.bL = "";
        }
        reportAction.bM = jSONObject.optString("customValue");
        if (jSONObject.opt("customValue") == JSONObject.NULL) {
            reportAction.bM = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(ReportAction reportAction, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, reportAction, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "timestamp", reportAction.f58219d);
            com.kwad.sdk.utils.t.a(jSONObject, "sessionId", reportAction.f58220e);
            com.kwad.sdk.utils.t.a(jSONObject, "seq", reportAction.f58221f);
            com.kwad.sdk.utils.t.a(jSONObject, "listId", reportAction.f58223h);
            com.kwad.sdk.utils.t.a(jSONObject, LightInvokerImpl.VOICE_ACTIONTYPE, reportAction.f58224i);
            com.kwad.sdk.utils.t.a(jSONObject, "llsid", reportAction.f58225j);
            com.kwad.sdk.utils.t.a(jSONObject, "extra", reportAction.f58226k);
            com.kwad.sdk.utils.t.a(jSONObject, "impAdExtra", reportAction.l);
            com.kwad.sdk.utils.t.a(jSONObject, "posId", reportAction.m);
            com.kwad.sdk.utils.t.a(jSONObject, "contentType", reportAction.n);
            com.kwad.sdk.utils.t.a(jSONObject, "realShowType", reportAction.o);
            com.kwad.sdk.utils.t.a(jSONObject, "photoId", reportAction.p);
            com.kwad.sdk.utils.t.a(jSONObject, "position", reportAction.q);
            com.kwad.sdk.utils.t.a(jSONObject, "serverPosition", reportAction.r);
            com.kwad.sdk.utils.t.a(jSONObject, "photoDuration", reportAction.s);
            com.kwad.sdk.utils.t.a(jSONObject, "effectivePlayDuration", reportAction.t);
            com.kwad.sdk.utils.t.a(jSONObject, "playDuration", reportAction.u);
            com.kwad.sdk.utils.t.a(jSONObject, "startDuration", reportAction.v);
            com.kwad.sdk.utils.t.a(jSONObject, "stayDuration", reportAction.w);
            com.kwad.sdk.utils.t.a(jSONObject, "stayLength", reportAction.x);
            com.kwad.sdk.utils.t.a(jSONObject, "blockDuration", reportAction.y);
            com.kwad.sdk.utils.t.a(jSONObject, "intervalDuration", reportAction.z);
            com.kwad.sdk.utils.t.a(jSONObject, "allIntervalDuration", reportAction.A);
            com.kwad.sdk.utils.t.a(jSONObject, "flowSdk", reportAction.B);
            com.kwad.sdk.utils.t.a(jSONObject, "blockTimes", reportAction.C);
            com.kwad.sdk.utils.t.a(jSONObject, "tabName", reportAction.D);
            com.kwad.sdk.utils.t.a(jSONObject, "nextPageType", reportAction.E);
            com.kwad.sdk.utils.t.a(jSONObject, "contentSourceType", reportAction.F);
            com.kwad.sdk.utils.t.a(jSONObject, "enterType", reportAction.G);
            com.kwad.sdk.utils.t.a(jSONObject, "leaveType", reportAction.H);
            com.kwad.sdk.utils.t.a(jSONObject, "adAggPageSource", reportAction.J);
            com.kwad.sdk.utils.t.a(jSONObject, "entryPageSource", reportAction.K);
            com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", reportAction.L);
            com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", reportAction.M);
            com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_AUTHOR_ID, reportAction.N);
            com.kwad.sdk.utils.t.a(jSONObject, "likeStatus", reportAction.O);
            com.kwad.sdk.utils.t.a(jSONObject, "photoSize", reportAction.P);
            com.kwad.sdk.utils.t.a(jSONObject, "playEnd", reportAction.Q);
            com.kwad.sdk.utils.t.a(jSONObject, "dragProgressType", reportAction.R);
            com.kwad.sdk.utils.t.a(jSONObject, "dragProgressPhotoDuration", reportAction.S);
            com.kwad.sdk.utils.t.a(jSONObject, "dragProgressVideoTime", reportAction.T);
            com.kwad.sdk.utils.t.a(jSONObject, "likeType", reportAction.U);
            com.kwad.sdk.utils.t.a(jSONObject, "shareResult", reportAction.W);
            com.kwad.sdk.utils.t.a(jSONObject, "appInstalled", reportAction.X);
            com.kwad.sdk.utils.t.a(jSONObject, "appUninstalled", reportAction.Y);
            com.kwad.sdk.utils.t.a(jSONObject, "coverUrl", reportAction.Z);
            com.kwad.sdk.utils.t.a(jSONObject, "videoCurrentUrl", reportAction.aa);
            com.kwad.sdk.utils.t.a(jSONObject, "entryId", reportAction.ab);
            com.kwad.sdk.utils.t.a(jSONObject, "pushUrl", reportAction.ac);
            com.kwad.sdk.utils.t.a(jSONObject, "commentId", reportAction.ad);
            com.kwad.sdk.utils.t.a(jSONObject, "seenCount", reportAction.ae);
            com.kwad.sdk.utils.t.a(jSONObject, PushConstants.CLICK_TYPE, reportAction.af);
            com.kwad.sdk.utils.t.a(jSONObject, "buttonPictureClick", reportAction.ag);
            com.kwad.sdk.utils.t.a(jSONObject, "recoExt", reportAction.ah);
            com.kwad.sdk.utils.t.a(jSONObject, "clientExt", reportAction.ai);
            com.kwad.sdk.utils.t.a(jSONObject, "playerType", reportAction.aj);
            com.kwad.sdk.utils.t.a(jSONObject, TaskResponseData.keyUiType, reportAction.ak);
            com.kwad.sdk.utils.t.a(jSONObject, "tubeName", reportAction.al);
            com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_TUBE_ID, reportAction.am);
            com.kwad.sdk.utils.t.a(jSONObject, "episodeName", reportAction.an);
            com.kwad.sdk.utils.t.a(jSONObject, "trendName", reportAction.ao);
            com.kwad.sdk.utils.t.a(jSONObject, URLPackage.KEY_TREND_ID, reportAction.ap);
            com.kwad.sdk.utils.t.a(jSONObject, "relatedContentSourceType", reportAction.ar);
            com.kwad.sdk.utils.t.a(jSONObject, "adHorizontalFeedType", reportAction.as);
            com.kwad.sdk.utils.t.a(jSONObject, "videoPlayMode", reportAction.at);
            com.kwad.sdk.utils.t.a(jSONObject, "autoReplayTimes", reportAction.au);
            com.kwad.sdk.utils.t.a(jSONObject, "closeType", reportAction.aw);
            com.kwad.sdk.utils.t.a(jSONObject, "isLeftSlipStatus", reportAction.ax);
            com.kwad.sdk.utils.t.a(jSONObject, "preloadType", reportAction.ay);
            com.kwad.sdk.utils.t.a(jSONObject, "preloadPhotoList", reportAction.az);
            com.kwad.sdk.utils.t.a(jSONObject, "refreshType", reportAction.aA);
            com.kwad.sdk.utils.t.a(jSONObject, "photoResponseType", reportAction.aB);
            com.kwad.sdk.utils.t.a(jSONObject, "failUrl", reportAction.aC);
            com.kwad.sdk.utils.t.a(jSONObject, "errorMsg", reportAction.aD);
            com.kwad.sdk.utils.t.a(jSONObject, "errorCode", reportAction.aE);
            com.kwad.sdk.utils.t.a(jSONObject, "creativeId", reportAction.aF);
            com.kwad.sdk.utils.t.a(jSONObject, "liveLogInfo", reportAction.aG);
            com.kwad.sdk.utils.t.a(jSONObject, "moduleName", reportAction.aH);
            com.kwad.sdk.utils.t.a(jSONObject, "cacheFailedReason", reportAction.aK);
            com.kwad.sdk.utils.t.a(jSONObject, "componentPosition", reportAction.aL);
            com.kwad.sdk.utils.t.a(jSONObject, "appExt", reportAction.aM);
            com.kwad.sdk.utils.t.a(jSONObject, "appRunningInfoList", reportAction.aN);
            com.kwad.sdk.utils.t.a(jSONObject, com.kwad.sdk.api.loader.ReportAction.KEY_DOWNLOAD_DURATION, reportAction.aO);
            com.kwad.sdk.utils.t.a(jSONObject, "pageType", reportAction.aP);
            com.kwad.sdk.utils.t.a(jSONObject, "guideTimes", reportAction.aQ);
            com.kwad.sdk.utils.t.a(jSONObject, "speedLimitStatus", reportAction.aR);
            com.kwad.sdk.utils.t.a(jSONObject, "speedLimitThreshold", reportAction.aS);
            com.kwad.sdk.utils.t.a(jSONObject, "currentRealDownloadSpeed", reportAction.aT);
            com.kwad.sdk.utils.t.a(jSONObject, "sdkPlatform", reportAction.aV);
            com.kwad.sdk.utils.t.a(jSONObject, "isKsUnion", reportAction.aW);
            com.kwad.sdk.utils.t.a(jSONObject, "trackMethodName", reportAction.aX);
            com.kwad.sdk.utils.t.a(jSONObject, "viewModeType", reportAction.aY);
            com.kwad.sdk.utils.t.a(jSONObject, "playAgainControlledType", reportAction.ba);
            com.kwad.sdk.utils.t.a(jSONObject, "mediaShareStr", reportAction.bb);
            com.kwad.sdk.utils.t.a(jSONObject, "clickTime", reportAction.bc);
            com.kwad.sdk.utils.t.a(jSONObject, "frameRenderTime", reportAction.bd);
            com.kwad.sdk.utils.t.a(jSONObject, "playerEnterAction", reportAction.be);
            com.kwad.sdk.utils.t.a(jSONObject, "requestUrl", reportAction.bf);
            com.kwad.sdk.utils.t.a(jSONObject, "requestTotalTime", reportAction.bg);
            com.kwad.sdk.utils.t.a(jSONObject, "requestResponseTime", reportAction.bh);
            com.kwad.sdk.utils.t.a(jSONObject, "requestParseDataTime", reportAction.bi);
            com.kwad.sdk.utils.t.a(jSONObject, "requestCallbackTime", reportAction.bj);
            com.kwad.sdk.utils.t.a(jSONObject, "requestFailReason", reportAction.bk);
            com.kwad.sdk.utils.t.a(jSONObject, "pageName", reportAction.bl);
            com.kwad.sdk.utils.t.a(jSONObject, "pageCreateTime", reportAction.bm);
            com.kwad.sdk.utils.t.a(jSONObject, "pageResumeTime", reportAction.bn);
            com.kwad.sdk.utils.t.a(jSONObject, "trackUrlList", reportAction.bo);
            com.kwad.sdk.utils.t.a(jSONObject, "pageLaunchTime", reportAction.bp);
            com.kwad.sdk.utils.t.a(jSONObject, "appAuthorityInfoList", reportAction.bs);
            com.kwad.sdk.utils.t.a(jSONObject, "entryRealRefresh", reportAction.bt);
            com.kwad.sdk.utils.t.a(jSONObject, "tkVersion", reportAction.bu);
            com.kwad.sdk.utils.t.a(jSONObject, "jsVersion", reportAction.bv);
            com.kwad.sdk.utils.t.a(jSONObject, "jsFileName", reportAction.bw);
            com.kwad.sdk.utils.t.a(jSONObject, "jsErrorMsg", reportAction.bx);
            com.kwad.sdk.utils.t.a(jSONObject, "jsConfig", reportAction.by);
            com.kwad.sdk.utils.t.a(jSONObject, "sceneId", reportAction.bz);
            com.kwad.sdk.utils.t.a(jSONObject, "h5Version", reportAction.bA);
            com.kwad.sdk.utils.t.a(jSONObject, "loadType", reportAction.bB);
            com.kwad.sdk.utils.t.a(jSONObject, ShaderParams.VALUE_TYPE_STEP, reportAction.bC);
            com.kwad.sdk.utils.t.a(jSONObject, "interval", reportAction.bD);
            com.kwad.sdk.utils.t.a(jSONObject, "failStep", reportAction.bE);
            com.kwad.sdk.utils.t.a(jSONObject, "failReason", reportAction.bF);
            com.kwad.sdk.utils.t.a(jSONObject, "couponStatus", reportAction.bG);
            com.kwad.sdk.utils.t.a(jSONObject, "readPct", reportAction.bH);
            com.kwad.sdk.utils.t.a(jSONObject, "lostReason", reportAction.bI);
            com.kwad.sdk.utils.t.a(jSONObject, "photoType", reportAction.bJ);
            com.kwad.sdk.utils.t.a(jSONObject, "adBizType", reportAction.bK);
            com.kwad.sdk.utils.t.a(jSONObject, "customKey", reportAction.bL);
            com.kwad.sdk.utils.t.a(jSONObject, "customValue", reportAction.bM);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
