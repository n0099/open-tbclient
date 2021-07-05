package com.kwai.video.player.kwai_player;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class AspectKFlv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final KwaiMediaPlayer mPlayer;

    public AspectKFlv(KwaiMediaPlayer kwaiMediaPlayer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kwaiMediaPlayer, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayer = kwaiMediaPlayer;
        kwaiMediaPlayer.setOption(4, "enable-live-manifest", z ? 1L : 0L);
    }

    public boolean isLiveManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPlayer._isLiveManifest() : invokeV.booleanValue;
    }

    public void setLiveAdaptiveConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            KwaiMediaPlayer kwaiMediaPlayer = this.mPlayer;
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            kwaiMediaPlayer.setOption(1, "liveAdaptConfig", str);
        }
    }
}
