package com.kwad.sdk.entry.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.UUID;
/* loaded from: classes7.dex */
public class CacheTemplate extends AdTemplate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheTemplate(AdTemplate adTemplate, SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, sceneImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        String str = adTemplate.mOriginJString;
        this.mOriginJString = str;
        if (str == null) {
            this.mOriginJString = adTemplate.toJson().toString();
        }
    }
}
