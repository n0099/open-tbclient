package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AggregatePageEntranceInfo;
import com.kwad.sdk.core.response.model.NewsInfo;
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
public class n implements com.kwad.sdk.core.d<AdTemplate> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
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
    public void a(AdTemplate adTemplate, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject) == null) || jSONObject == null) {
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
        NewsInfo newsInfo = new NewsInfo();
        adTemplate.newsInfo = newsInfo;
        newsInfo.parseJson(jSONObject.optJSONObject("newsInfo"));
        AggregatePageEntranceInfo aggregatePageEntranceInfo = new AggregatePageEntranceInfo();
        adTemplate.aggregatePageEntranceInfo = aggregatePageEntranceInfo;
        aggregatePageEntranceInfo.parseJson(jSONObject.optJSONObject("aggregatePageEntranceInfo"));
        adTemplate.needHide = jSONObject.optBoolean("needHide");
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        LiveInfo liveInfo = new LiveInfo();
        adTemplate.mLiveInfo = liveInfo;
        liveInfo.parseJson(jSONObject.optJSONObject("mLiveInfo"));
        adTemplate.llsid = jSONObject.optLong("llsid");
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
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mPcursor = jSONObject.optString("mPcursor");
        adTemplate.mHasEntryAdClick = jSONObject.optBoolean("mHasEntryAdClick");
        adTemplate.mIsNotNeedAvatarGuider = jSONObject.optBoolean("mIsNotNeedAvatarGuider");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, adTemplate, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.q.a(jSONObject, "mOriginJString", adTemplate.mOriginJString);
            com.kwad.sdk.utils.q.a(jSONObject, "posId", adTemplate.posId);
            com.kwad.sdk.utils.q.a(jSONObject, "type", adTemplate.type);
            com.kwad.sdk.utils.q.a(jSONObject, "contentType", adTemplate.contentType);
            com.kwad.sdk.utils.q.a(jSONObject, "adInfo", adTemplate.adInfoList);
            com.kwad.sdk.utils.q.a(jSONObject, "photoInfo", adTemplate.photoInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "newsInfo", adTemplate.newsInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "aggregatePageEntranceInfo", adTemplate.aggregatePageEntranceInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "needHide", adTemplate.needHide);
            com.kwad.sdk.utils.q.a(jSONObject, "impAdExtra", adTemplate.impAdExtra);
            com.kwad.sdk.utils.q.a(jSONObject, "mLiveInfo", adTemplate.mLiveInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "llsid", adTemplate.llsid);
            com.kwad.sdk.utils.q.a(jSONObject, "mIsFromContent", adTemplate.mIsFromContent);
            com.kwad.sdk.utils.q.a(jSONObject, "extra", adTemplate.extra);
            com.kwad.sdk.utils.q.a(jSONObject, "mUniqueId", adTemplate.mUniqueId);
            com.kwad.sdk.utils.q.a(jSONObject, "mBidEcpm", adTemplate.mBidEcpm);
            com.kwad.sdk.utils.q.a(jSONObject, "mAdScene", adTemplate.mAdScene);
            com.kwad.sdk.utils.q.a(jSONObject, "realShowType", adTemplate.realShowType);
            com.kwad.sdk.utils.q.a(jSONObject, "mInitVoiceStatus", adTemplate.mInitVoiceStatus);
            com.kwad.sdk.utils.q.a(jSONObject, "mPreloadData", adTemplate.mPreloadData);
            com.kwad.sdk.utils.q.a(jSONObject, "mMediaPlayerType", adTemplate.mMediaPlayerType);
            com.kwad.sdk.utils.q.a(jSONObject, "mIsTubeEpisodeList", adTemplate.mIsTubeEpisodeList);
            com.kwad.sdk.utils.q.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
            com.kwad.sdk.utils.q.a(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
            com.kwad.sdk.utils.q.a(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
            com.kwad.sdk.utils.q.a(jSONObject, "mIsLeftSlipStatus", adTemplate.mIsLeftSlipStatus);
            com.kwad.sdk.utils.q.a(jSONObject, "mPhotoResponseType", adTemplate.mPhotoResponseType);
            com.kwad.sdk.utils.q.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
            com.kwad.sdk.utils.q.a(jSONObject, "mPcursor", adTemplate.mPcursor);
            com.kwad.sdk.utils.q.a(jSONObject, "mHasEntryAdClick", adTemplate.mHasEntryAdClick);
            com.kwad.sdk.utils.q.a(jSONObject, "mIsNotNeedAvatarGuider", adTemplate.mIsNotNeedAvatarGuider);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
