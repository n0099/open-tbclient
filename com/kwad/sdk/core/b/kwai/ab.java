package com.kwad.sdk.core.b.kwai;

import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class ab implements com.kwad.sdk.core.d<AdTemplate> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (jSONObject.opt("mOriginJString") == JSONObject.NULL) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE);
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (jSONObject.opt("impAdExtra") == JSONObject.NULL) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (jSONObject.opt("extra") == JSONObject.NULL) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (jSONObject.opt("mUniqueId") == JSONObject.NULL) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optInt("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.isPlayAgainData = jSONObject.optBoolean("isPlayAgainData");
        adTemplate.inPlayAgain = jSONObject.optBoolean("inPlayAgain");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.checkDataTime = jSONObject.optLong("checkDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        adTemplate.mLoadFromCache = jSONObject.optBoolean("mLoadFromCache");
        adTemplate.mLoadDataTime = jSONObject.optLong("mLoadDataTime");
        adTemplate.mDownloadFinishTime = jSONObject.optLong("mDownloadFinishTime");
        adTemplate.mDownloadType = jSONObject.optInt("mDownloadType");
        adTemplate.mDownloadSize = jSONObject.optLong("mDownloadSize");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j = adTemplate.posId;
        if (j != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "posId", j);
        }
        int i = adTemplate.adStyle;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adStyle", i);
        }
        int i2 = adTemplate.type;
        if (i2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i2);
        }
        int i3 = adTemplate.contentType;
        if (i3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, i3);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j2 = adTemplate.llsid;
        if (j2 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "llsid", j2);
        }
        boolean z = adTemplate.mIsFromContent;
        if (z) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mIsFromContent", z);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        int i4 = adTemplate.mBidEcpm;
        if (i4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mBidEcpm", i4);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i5 = adTemplate.realShowType;
        if (i5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "realShowType", i5);
        }
        int i6 = adTemplate.mInitVoiceStatus;
        if (i6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mInitVoiceStatus", i6);
        }
        int i7 = adTemplate.mMediaPlayerType;
        if (i7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mMediaPlayerType", i7);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.r.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.r.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i8 = adTemplate.mIsLeftSlipStatus;
        if (i8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mIsLeftSlipStatus", i8);
        }
        int i9 = adTemplate.mPhotoResponseType;
        if (i9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mPhotoResponseType", i9);
        }
        com.kwad.sdk.utils.r.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        boolean z2 = adTemplate.mRewardVerifyCalled;
        if (z2) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mRewardVerifyCalled", z2);
        }
        boolean z3 = adTemplate.isWebViewDownload;
        if (z3) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isWebViewDownload", z3);
        }
        boolean z4 = adTemplate.isPlayAgainData;
        if (z4) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "isPlayAgainData", z4);
        }
        boolean z5 = adTemplate.inPlayAgain;
        if (z5) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "inPlayAgain", z5);
        }
        boolean z6 = adTemplate.watched;
        if (z6) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "watched", z6);
        }
        boolean z7 = adTemplate.converted;
        if (z7) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "converted", z7);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j3 = adTemplate.loadDataTime;
        if (j3 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "loadDataTime", j3);
        }
        long j4 = adTemplate.checkDataTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "checkDataTime", j4);
        }
        long j5 = adTemplate.showStartTime;
        if (j5 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "showStartTime", j5);
        }
        boolean z8 = adTemplate.notNetworkRequest;
        if (z8) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "notNetworkRequest", z8);
        }
        long j6 = adTemplate.downloadDuration;
        if (j6 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "downloadDuration", j6);
        }
        long j7 = adTemplate.adLoadTotalTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adLoadTotalTime", j7);
        }
        long j8 = adTemplate.adShowStartTimeStamp;
        if (j8 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "adShowStartTimeStamp", j8);
        }
        boolean z9 = adTemplate.mLoadFromCache;
        if (z9) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mLoadFromCache", z9);
        }
        long j9 = adTemplate.mLoadDataTime;
        if (j9 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mLoadDataTime", j9);
        }
        long j10 = adTemplate.mDownloadFinishTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mDownloadFinishTime", j10);
        }
        int i10 = adTemplate.mDownloadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mDownloadType", i10);
        }
        long j11 = adTemplate.mDownloadSize;
        if (j11 != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "mDownloadSize", j11);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        a2(adTemplate, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return b2(adTemplate, jSONObject);
    }
}
