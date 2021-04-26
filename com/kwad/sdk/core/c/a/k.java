package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.PreloadData;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements com.kwad.sdk.core.c<AdTemplate> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i2));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        PhotoInfo photoInfo = new PhotoInfo();
        adTemplate.photoInfo = photoInfo;
        photoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
        adTemplate.needHide = jSONObject.optBoolean("needHide");
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        LiveInfo liveInfo = new LiveInfo();
        adTemplate.mLiveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("mLiveInfo"));
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.positionShow = jSONObject.optInt("positionShow");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        adTemplate.mBidEcpm = jSONObject.optInt("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        PreloadData preloadData = new PreloadData();
        adTemplate.mPreloadData = preloadData;
        preloadData.parseJson(jSONObject.optJSONObject("mPreloadData"));
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        adTemplate.mIsTubeEpisodeList = jSONObject.optBoolean("mIsTubeEpisodeList");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mKsPlayerClickTimeParam = jSONObject.optLong("mKsPlayerClickTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mPcursor = jSONObject.optString("mPcursor");
        adTemplate.mHasEntryAdClick = jSONObject.optBoolean("mHasEntryAdClick");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        com.kwad.sdk.utils.o.a(jSONObject, "posId", adTemplate.posId);
        com.kwad.sdk.utils.o.a(jSONObject, "type", adTemplate.type);
        com.kwad.sdk.utils.o.a(jSONObject, "contentType", adTemplate.contentType);
        com.kwad.sdk.utils.o.a(jSONObject, "adInfo", adTemplate.adInfoList);
        com.kwad.sdk.utils.o.a(jSONObject, "photoInfo", adTemplate.photoInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "needHide", adTemplate.needHide);
        com.kwad.sdk.utils.o.a(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        com.kwad.sdk.utils.o.a(jSONObject, "mLiveInfo", adTemplate.mLiveInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "llsid", adTemplate.llsid);
        com.kwad.sdk.utils.o.a(jSONObject, "positionShow", adTemplate.positionShow);
        com.kwad.sdk.utils.o.a(jSONObject, "mIsFromContent", adTemplate.mIsFromContent);
        com.kwad.sdk.utils.o.a(jSONObject, "extra", adTemplate.extra);
        com.kwad.sdk.utils.o.a(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        com.kwad.sdk.utils.o.a(jSONObject, "mBidEcpm", adTemplate.mBidEcpm);
        com.kwad.sdk.utils.o.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        com.kwad.sdk.utils.o.a(jSONObject, "realShowType", adTemplate.realShowType);
        com.kwad.sdk.utils.o.a(jSONObject, "mInitVoiceStatus", adTemplate.mInitVoiceStatus);
        com.kwad.sdk.utils.o.a(jSONObject, "mPreloadData", adTemplate.mPreloadData);
        com.kwad.sdk.utils.o.a(jSONObject, "mMediaPlayerType", adTemplate.mMediaPlayerType);
        com.kwad.sdk.utils.o.a(jSONObject, "mIsTubeEpisodeList", adTemplate.mIsTubeEpisodeList);
        com.kwad.sdk.utils.o.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.o.a(jSONObject, "mKsPlayerClickTimeParam", adTemplate.mKsPlayerClickTimeParam);
        com.kwad.sdk.utils.o.a(jSONObject, "mIsLeftSlipStatus", adTemplate.mIsLeftSlipStatus);
        com.kwad.sdk.utils.o.a(jSONObject, "mPhotoResponseType", adTemplate.mPhotoResponseType);
        com.kwad.sdk.utils.o.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.o.a(jSONObject, "mPcursor", adTemplate.mPcursor);
        com.kwad.sdk.utils.o.a(jSONObject, "mHasEntryAdClick", adTemplate.mHasEntryAdClick);
        return jSONObject;
    }
}
