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
/* loaded from: classes5.dex */
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
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.checkDataTime = jSONObject.optLong("checkDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
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
        com.kwad.sdk.utils.r.a(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        com.kwad.sdk.utils.r.a(jSONObject, "posId", adTemplate.posId);
        com.kwad.sdk.utils.r.a(jSONObject, "adStyle", adTemplate.adStyle);
        com.kwad.sdk.utils.r.a(jSONObject, "type", adTemplate.type);
        com.kwad.sdk.utils.r.a(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, adTemplate.contentType);
        com.kwad.sdk.utils.r.a(jSONObject, "adInfo", adTemplate.adInfoList);
        com.kwad.sdk.utils.r.a(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        com.kwad.sdk.utils.r.a(jSONObject, "llsid", adTemplate.llsid);
        com.kwad.sdk.utils.r.a(jSONObject, "mIsFromContent", adTemplate.mIsFromContent);
        com.kwad.sdk.utils.r.a(jSONObject, "extra", adTemplate.extra);
        com.kwad.sdk.utils.r.a(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        com.kwad.sdk.utils.r.a(jSONObject, "mBidEcpm", adTemplate.mBidEcpm);
        com.kwad.sdk.utils.r.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        com.kwad.sdk.utils.r.a(jSONObject, "realShowType", adTemplate.realShowType);
        com.kwad.sdk.utils.r.a(jSONObject, "mInitVoiceStatus", adTemplate.mInitVoiceStatus);
        com.kwad.sdk.utils.r.a(jSONObject, "mMediaPlayerType", adTemplate.mMediaPlayerType);
        com.kwad.sdk.utils.r.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.r.a(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.r.a(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        com.kwad.sdk.utils.r.a(jSONObject, "mIsLeftSlipStatus", adTemplate.mIsLeftSlipStatus);
        com.kwad.sdk.utils.r.a(jSONObject, "mPhotoResponseType", adTemplate.mPhotoResponseType);
        com.kwad.sdk.utils.r.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "mRewardVerifyCalled", adTemplate.mRewardVerifyCalled);
        com.kwad.sdk.utils.r.a(jSONObject, "isWebViewDownload", adTemplate.isWebViewDownload);
        com.kwad.sdk.utils.r.a(jSONObject, "isPlayAgainData", adTemplate.isPlayAgainData);
        com.kwad.sdk.utils.r.a(jSONObject, "inPlayAgain", adTemplate.inPlayAgain);
        com.kwad.sdk.utils.r.a(jSONObject, "watched", adTemplate.watched);
        com.kwad.sdk.utils.r.a(jSONObject, "fromCache", adTemplate.fromCache);
        com.kwad.sdk.utils.r.a(jSONObject, "loadDataTime", adTemplate.loadDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "checkDataTime", adTemplate.checkDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "showStartTime", adTemplate.showStartTime);
        com.kwad.sdk.utils.r.a(jSONObject, "notNetworkRequest", adTemplate.notNetworkRequest);
        com.kwad.sdk.utils.r.a(jSONObject, "mLoadFromCache", adTemplate.mLoadFromCache);
        com.kwad.sdk.utils.r.a(jSONObject, "mLoadDataTime", adTemplate.mLoadDataTime);
        com.kwad.sdk.utils.r.a(jSONObject, "mDownloadFinishTime", adTemplate.mDownloadFinishTime);
        com.kwad.sdk.utils.r.a(jSONObject, "mDownloadType", adTemplate.mDownloadType);
        com.kwad.sdk.utils.r.a(jSONObject, "mDownloadSize", adTemplate.mDownloadSize);
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
