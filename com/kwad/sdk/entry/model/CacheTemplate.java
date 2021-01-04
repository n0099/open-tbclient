package com.kwad.sdk.entry.model;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.UUID;
/* loaded from: classes5.dex */
public class CacheTemplate extends AdTemplate {
    public CacheTemplate(AdTemplate adTemplate, SceneImpl sceneImpl) {
        this.posId = adTemplate.posId;
        this.type = adTemplate.type;
        this.contentType = adTemplate.contentType;
        this.realShowType = adTemplate.realShowType;
        this.adInfoList = adTemplate.adInfoList;
        this.photoInfo = adTemplate.photoInfo;
        this.needHide = adTemplate.needHide;
        this.llsid = adTemplate.llsid;
        setShowPosition(adTemplate.getShowPosition());
        this.extra = adTemplate.extra;
        this.impAdExtra = adTemplate.impAdExtra;
        this.mUniqueId = String.valueOf(UUID.randomUUID());
        this.mPvReported = adTemplate.mPvReported;
        this.mContentPvReported = adTemplate.mContentPvReported;
        this.mDownloadFinishReported = adTemplate.mDownloadFinishReported;
        this.mAdScene = sceneImpl;
        this.mIsTubeEpisodeList = adTemplate.mIsTubeEpisodeList;
        this.mPcursor = adTemplate.mPcursor;
        this.mOriginJString = adTemplate.mOriginJString;
        if (this.mOriginJString == null) {
            this.mOriginJString = adTemplate.toJson().toString();
        }
    }
}
