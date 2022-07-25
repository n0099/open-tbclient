package com.kwad.components.offline.api.core.video.mdoel;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
/* loaded from: classes5.dex */
public class PlayVideoInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isNoCache;
    public final KsPlayerLogParams ksplayerLogParams;
    public final String manifest;
    public final VideoPlayerStatus videoPlayerStatus;
    public final String videoUrl;

    /* renamed from: com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isNoCache;
        public KsPlayerLogParams ksplayerLogParams;
        public String manifest;
        public VideoPlayerStatus videoPlayerStatus;
        public String videoUrl;

        public Builder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.isNoCache = false;
            this.videoUrl = str;
        }

        public PlayVideoInfo build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PlayVideoInfo(this, null) : (PlayVideoInfo) invokeV.objValue;
        }

        public Builder ksplayerLogParams(@NonNull KsPlayerLogParams ksPlayerLogParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksPlayerLogParams)) == null) {
                this.ksplayerLogParams = ksPlayerLogParams;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder manifest(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.manifest = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder noCache(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.isNoCache = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder videoPlayerStatus(VideoPlayerStatus videoPlayerStatus) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, videoPlayerStatus)) == null) {
                this.videoPlayerStatus = videoPlayerStatus;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder videoUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.videoUrl = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    public PlayVideoInfo(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ksplayerLogParams = new KsPlayerLogParams();
        this.videoUrl = builder.videoUrl;
        this.manifest = builder.manifest;
        this.videoPlayerStatus = builder.videoPlayerStatus;
        if (builder.ksplayerLogParams != null) {
            this.ksplayerLogParams.photoId = builder.ksplayerLogParams.photoId;
            this.ksplayerLogParams.clickTime = builder.ksplayerLogParams.clickTime;
            this.ksplayerLogParams.adStyle = builder.ksplayerLogParams.adStyle;
            this.ksplayerLogParams.contentType = builder.ksplayerLogParams.contentType;
        }
        this.isNoCache = builder.isNoCache;
    }

    public /* synthetic */ PlayVideoInfo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
