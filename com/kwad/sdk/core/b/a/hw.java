package com.kwad.sdk.core.b.a;

import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.q> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.timestamp = jSONObject.optLong("timestamp");
        qVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(qVar.sessionId)) {
            qVar.sessionId = "";
        }
        qVar.ID = jSONObject.optLong("seq");
        qVar.avG = jSONObject.optLong("listId");
        qVar.actionType = jSONObject.optLong("actionType");
        qVar.Xd = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(qVar.Xd)) {
            qVar.Xd = "";
        }
        qVar.llsid = jSONObject.optLong("llsid");
        qVar.avH = jSONObject.optJSONObject("extra");
        qVar.avI = jSONObject.optJSONObject("impAdExtra");
        qVar.posId = jSONObject.optLong("posId");
        qVar.contentType = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE);
        qVar.realShowType = jSONObject.optInt("realShowType");
        qVar.photoId = jSONObject.optLong("photoId");
        qVar.position = jSONObject.optLong(CriusAttrConstants.POSITION);
        qVar.avJ = jSONObject.optLong("serverPosition");
        qVar.avK = jSONObject.optLong("photoDuration");
        qVar.avL = jSONObject.optLong("effectivePlayDuration");
        qVar.aaf = jSONObject.optLong("playDuration");
        qVar.blockDuration = jSONObject.optLong("blockDuration");
        qVar.avM = jSONObject.optLong("intervalDuration");
        qVar.avN = jSONObject.optLong("allIntervalDuration");
        qVar.avO = jSONObject.optLong("flowSdk");
        qVar.avP = jSONObject.optLong("blockTimes");
        qVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        qVar.avQ = jSONObject.optInt("adAggPageSource");
        qVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(qVar.entryPageSource)) {
            qVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        qVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        qVar.avR = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        qVar.RT = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        qVar.avS = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(qVar.avS)) {
            qVar.avS = "";
        }
        qVar.avT = jSONObject.optJSONArray("appInstalled");
        qVar.avU = jSONObject.optJSONArray("appUninstalled");
        q.a aVar = new q.a();
        qVar.avV = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        qVar.avW = jSONObject.optInt("playerType");
        qVar.avX = jSONObject.optInt(TaskResponseData.keyUiType);
        qVar.avY = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        qVar.Xe = jSONObject.optInt("refreshType");
        qVar.avZ = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        qVar.awa = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(qVar.awa)) {
            qVar.awa = "";
        }
        qVar.errorMsg = jSONObject.optString("errorMsg");
        if (JSONObject.NULL.toString().equals(qVar.errorMsg)) {
            qVar.errorMsg = "";
        }
        qVar.errorCode = jSONObject.optInt(CloudStabilityUBCUtils.KEY_ERROR_CODE, new Integer("0").intValue());
        qVar.creativeId = jSONObject.optLong("creativeId");
        qVar.awd = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(qVar.awd)) {
            qVar.awd = "";
        }
        qVar.awe = jSONObject.optJSONObject("appExt");
        qVar.awf = jSONObject.optJSONArray("appRunningInfoList");
        qVar.downloadDuration = jSONObject.optLong("downloadDuration");
        qVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        qVar.awg = jSONObject.optInt("speedLimitStatus");
        qVar.awh = jSONObject.optInt("speedLimitThreshold");
        qVar.awi = jSONObject.optInt("currentRealDownloadSpeed");
        qVar.awk = jSONObject.optJSONArray("sdkPlatform");
        qVar.awl = jSONObject.optBoolean("isKsUnion");
        qVar.awm = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(qVar.awm)) {
            qVar.awm = "";
        }
        qVar.awn = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        qVar.clickTime = jSONObject.optLong("clickTime");
        qVar.awp = jSONObject.optLong("frameRenderTime");
        qVar.awq = jSONObject.optInt("playerEnterAction");
        qVar.awr = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(qVar.awr)) {
            qVar.awr = "";
        }
        qVar.aws = jSONObject.optLong("requestTotalTime");
        qVar.awt = jSONObject.optLong("requestResponseTime");
        qVar.awu = jSONObject.optLong("requestParseDataTime");
        qVar.awv = jSONObject.optLong("requestCallbackTime");
        qVar.aww = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(qVar.aww)) {
            qVar.aww = "";
        }
        qVar.QQ = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(qVar.QQ)) {
            qVar.QQ = "";
        }
        qVar.QY = jSONObject.optLong("pageCreateTime");
        qVar.QZ = jSONObject.optLong("pageResumeTime");
        qVar.awx = jSONObject.optInt("trackUrlType");
        qVar.awy = jSONObject.optJSONArray("trackUrlList");
        qVar.QX = jSONObject.optLong("pageLaunchTime");
        qVar.awB = jSONObject.optJSONArray("appAuthorityInfoList");
        qVar.awC = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(qVar.awC)) {
            qVar.awC = "";
        }
        qVar.awD = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(qVar.awD)) {
            qVar.awD = "";
        }
        qVar.awE = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(qVar.awE)) {
            qVar.awE = "";
        }
        qVar.awF = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(qVar.awF)) {
            qVar.awF = "";
        }
        qVar.awG = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(qVar.awG)) {
            qVar.awG = "";
        }
        qVar.awH = jSONObject.optInt("adBizType");
        qVar.awI = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(qVar.awI)) {
            qVar.awI = "";
        }
        qVar.awJ = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(qVar.awJ)) {
            qVar.awJ = "";
        }
        qVar.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(qVar.trace)) {
            qVar.trace = "";
        }
        qVar.awK = jSONObject.optInt("filterCode");
        qVar.awL = jSONObject.optInt("sdkVersionCode");
        qVar.sdkVersion = jSONObject.optString(com.heytap.mcssdk.constant.b.C);
        if (JSONObject.NULL.toString().equals(qVar.sdkVersion)) {
            qVar.sdkVersion = "";
        }
        qVar.awM = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(qVar.awM)) {
            qVar.awM = "";
        }
        qVar.WA = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(qVar.WA)) {
            qVar.WA = "";
        }
        qVar.sdkType = jSONObject.optInt("sdkType");
        qVar.awN = jSONObject.optLong("appUseDuration");
        qVar.awO = jSONObject.optLong("appStartType");
        qVar.arX = jSONObject.optLong("sequenceNumber");
        qVar.IA = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(qVar.IA)) {
            qVar.IA = "";
        }
        qVar.IB = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(qVar.IB)) {
            qVar.IB = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = qVar.timestamp;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j);
        }
        String str = qVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sessionId", qVar.sessionId);
        }
        long j2 = qVar.ID;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "seq", j2);
        }
        long j3 = qVar.avG;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listId", j3);
        }
        long j4 = qVar.actionType;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionType", j4);
        }
        String str2 = qVar.Xd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", qVar.Xd);
        }
        long j5 = qVar.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extra", qVar.avH);
        com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", qVar.avI);
        long j6 = qVar.posId;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j6);
        }
        int i = qVar.contentType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, i);
        }
        int i2 = qVar.realShowType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i2);
        }
        long j7 = qVar.photoId;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j7);
        }
        long j8 = qVar.position;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CriusAttrConstants.POSITION, j8);
        }
        long j9 = qVar.avJ;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPosition", j9);
        }
        long j10 = qVar.avK;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDuration", j10);
        }
        long j11 = qVar.avL;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "effectivePlayDuration", j11);
        }
        long j12 = qVar.aaf;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j12);
        }
        long j13 = qVar.blockDuration;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j13);
        }
        long j14 = qVar.avM;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intervalDuration", j14);
        }
        long j15 = qVar.avN;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "allIntervalDuration", j15);
        }
        long j16 = qVar.avO;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "flowSdk", j16);
        }
        long j17 = qVar.avP;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimes", j17);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", qVar.contentSourceType);
        int i3 = qVar.avQ;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i3);
        }
        String str3 = qVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryPageSource", qVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", qVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", qVar.avR);
        long j18 = qVar.RT;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j18);
        }
        String str4 = qVar.avS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSize", qVar.avS);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appInstalled", qVar.avT);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appUninstalled", qVar.avU);
        com.kwad.sdk.utils.t.a(jSONObject, "clientExt", qVar.avV);
        int i4 = qVar.avW;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerType", i4);
        }
        int i5 = qVar.avX;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, TaskResponseData.keyUiType, i5);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "isLeftSlipStatus", qVar.avY);
        int i6 = qVar.Xe;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", i6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "photoResponseType", qVar.avZ);
        String str5 = qVar.awa;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failUrl", qVar.awa);
        }
        String str6 = qVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", qVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, CloudStabilityUBCUtils.KEY_ERROR_CODE, qVar.errorCode);
        long j19 = qVar.creativeId;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j19);
        }
        String str7 = qVar.awd;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheFailedReason", qVar.awd);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appExt", qVar.awe);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appRunningInfoList", qVar.awf);
        long j20 = qVar.downloadDuration;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j20);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "pageType", qVar.pageType);
        int i7 = qVar.awg;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitStatus", i7);
        }
        int i8 = qVar.awh;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitThreshold", i8);
        }
        int i9 = qVar.awi;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentRealDownloadSpeed", i9);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkPlatform", qVar.awk);
        boolean z = qVar.awl;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = qVar.awm;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackMethodName", qVar.awm);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "viewModeType", qVar.awn);
        long j21 = qVar.clickTime;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickTime", j21);
        }
        long j22 = qVar.awp;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "frameRenderTime", j22);
        }
        int i10 = qVar.awq;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerEnterAction", i10);
        }
        String str9 = qVar.awr;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestUrl", qVar.awr);
        }
        long j23 = qVar.aws;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestTotalTime", j23);
        }
        long j24 = qVar.awt;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestResponseTime", j24);
        }
        long j25 = qVar.awu;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestParseDataTime", j25);
        }
        long j26 = qVar.awv;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestCallbackTime", j26);
        }
        String str10 = qVar.aww;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestFailReason", qVar.aww);
        }
        String str11 = qVar.QQ;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageName", qVar.QQ);
        }
        long j27 = qVar.QY;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageCreateTime", j27);
        }
        long j28 = qVar.QZ;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageResumeTime", j28);
        }
        int i11 = qVar.awx;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlType", i11);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlList", qVar.awy);
        long j29 = qVar.QX;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageLaunchTime", j29);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appAuthorityInfoList", qVar.awB);
        String str12 = qVar.awC;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", qVar.awC);
        }
        String str13 = qVar.awD;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsVersion", qVar.awD);
        }
        String str14 = qVar.awE;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsFileName", qVar.awE);
        }
        String str15 = qVar.awF;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsErrorMsg", qVar.awF);
        }
        String str16 = qVar.awG;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsConfig", qVar.awG);
        }
        int i12 = qVar.awH;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBizType", i12);
        }
        String str17 = qVar.awI;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customKey", qVar.awI);
        }
        String str18 = qVar.awJ;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customValue", qVar.awJ);
        }
        String str19 = qVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trace", qVar.trace);
        }
        int i13 = qVar.awK;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filterCode", i13);
        }
        int i14 = qVar.awL;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionCode", i14);
        }
        String str20 = qVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.heytap.mcssdk.constant.b.C, qVar.sdkVersion);
        }
        String str21 = qVar.awM;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSdkVersion", qVar.awM);
        }
        String str22 = qVar.WA;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", qVar.WA);
        }
        int i15 = qVar.sdkType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i15);
        }
        long j30 = qVar.awN;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appUseDuration", j30);
        }
        long j31 = qVar.awO;
        if (j31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStartType", j31);
        }
        long j32 = qVar.arX;
        if (j32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sequenceNumber", j32);
        }
        String str23 = qVar.IA;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appColdStart", qVar.IA);
        }
        String str24 = qVar.IB;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStart", qVar.IB);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
