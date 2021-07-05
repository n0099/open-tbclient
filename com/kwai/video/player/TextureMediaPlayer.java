package com.kwai.video.player;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(14)
/* loaded from: classes7.dex */
public class TextureMediaPlayer extends MediaPlayerProxy implements IMediaPlayer, ISurfaceTextureHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SurfaceTexture mSurfaceTexture;
    public ISurfaceTextureHost mSurfaceTextureHost;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureMediaPlayer(IMediaPlayer iMediaPlayer) {
        super(iMediaPlayer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMediaPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((IMediaPlayer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwai.video.player.ISurfaceTextureHolder
    public SurfaceTexture getSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mSurfaceTexture : (SurfaceTexture) invokeV.objValue;
    }

    @Override // com.kwai.video.player.MediaPlayerProxy, com.kwai.video.player.IMediaPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.release();
            releaseSurfaceTexture();
        }
    }

    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (surfaceTexture = this.mSurfaceTexture) == null) {
            return;
        }
        ISurfaceTextureHost iSurfaceTextureHost = this.mSurfaceTextureHost;
        if (iSurfaceTextureHost != null) {
            iSurfaceTextureHost.releaseSurfaceTexture(surfaceTexture);
        } else {
            surfaceTexture.release();
        }
        this.mSurfaceTexture = null;
    }

    @Override // com.kwai.video.player.MediaPlayerProxy, com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.reset();
            releaseSurfaceTexture();
        }
    }

    @Override // com.kwai.video.player.MediaPlayerProxy, com.kwai.video.player.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) && this.mSurfaceTexture == null) {
            super.setDisplay(surfaceHolder);
        }
    }

    @Override // com.kwai.video.player.MediaPlayerProxy, com.kwai.video.player.IMediaPlayer
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, surface) == null) && this.mSurfaceTexture == null) {
            super.setSurface(surface);
        }
    }

    @Override // com.kwai.video.player.ISurfaceTextureHolder
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) || this.mSurfaceTexture == surfaceTexture) {
            return;
        }
        releaseSurfaceTexture();
        this.mSurfaceTexture = surfaceTexture;
        if (surfaceTexture == null) {
            super.setSurface(null);
        } else {
            super.setSurface(new Surface(surfaceTexture));
        }
    }

    @Override // com.kwai.video.player.ISurfaceTextureHolder
    public void setSurfaceTextureHost(ISurfaceTextureHost iSurfaceTextureHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iSurfaceTextureHost) == null) {
            this.mSurfaceTextureHost = iSurfaceTextureHost;
        }
    }
}
