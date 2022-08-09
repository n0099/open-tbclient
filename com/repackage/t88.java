package com.repackage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberVideoView;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.UniversalPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.interfaces.OnSnapShotFrameListener;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.searchbox.player.ubc.CoreStatPlugin;
import com.baidu.searchbox.player.ubc.DurationStatPlugin;
import com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl0;
/* loaded from: classes7.dex */
public class t88 extends UniversalPlayer implements k88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public IUbcPlayerStatusFetcher b;

    /* loaded from: classes7.dex */
    public class a implements IUbcPlayerStatusFetcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t88 a;

        public a(t88 t88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t88Var;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getPosition() : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getKernelLogId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.mKernelLayer != null ? this.a.mKernelLayer.getKernelLogId() : "" : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getLaunchSpeedScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? bl0.a.a().getLaunchSpeedScore() : invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public int getPlayType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.a : invokeV.intValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getPlayUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getVideoUrl() : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getSessionId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.mVideoTask.sessionId : (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public float getStaticDeviceScore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? bl0.a.a().getStaticDeviceScore() : invokeV.floatValue;
        }

        @Override // com.baidu.searchbox.player.ubc.IUbcPlayerStatusFetcher
        public String getTraceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.mVideoTask.traceId : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t88(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, baseKernelLayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BaseKernelLayer) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.mLayerContainer.setClickable(false);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void doPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.doPlay();
            this.mProgressHelper.start();
        }
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            BaseKernelLayer playerKernelLayer = getPlayerKernelLayer();
            return pi.isEquals(str, playerKernelLayer != null ? playerKernelLayer.getVideoUrl() : null) && PlayerStatus.isActiveStatus(playerKernelLayer.getStatus());
        }
        return invokeL.booleanValue;
    }

    public final BaseKernelLayer g(BDVideoPlayer bDVideoPlayer, BaseKernelLayer baseKernelLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bDVideoPlayer, baseKernelLayer)) == null) {
            if (baseKernelLayer == null) {
                baseKernelLayer = getReuseHelper().getValidCache(bDVideoPlayer, bDVideoPlayer.getKLayerCacheKey());
            }
            return baseKernelLayer == null ? new BaseKernelLayer(AbsVideoKernel.CYBER_PLAYER) : baseKernelLayer;
        }
        return (BaseKernelLayer) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public int getPlayerStageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 24;
        }
        return invokeV.intValue;
    }

    public void h() {
        PlayerEventTrigger playerEventTrigger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (playerEventTrigger = getPlayerEventTrigger()) == null) {
            return;
        }
        playerEventTrigger.ignoreInfoEventFilter(true);
    }

    public void i(x88 x88Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x88Var) == null) || x88Var == null) {
            return;
        }
        this.a = x88Var.f;
        updateStatisticsContent(new BDVideoPlayerUbcContent.Builder().extLog(x88Var.a).url(x88Var.b).id(x88Var.c).from(x88Var.d).page(x88Var.e).playerStatusFetcher(this.b).build());
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer
    public void initHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mProgressHelper = new u88(this);
            OrientationHelper orientationHelper = new OrientationHelper(BDPlayerConfig.getAppContext(), 3);
            this.mOrientationHelper = orientationHelper;
            if (orientationHelper.canDetectOrientation()) {
                this.mIsEnableOrientation = true;
                this.mOrientationHelper.disable();
                this.mOrientationHelper.setListener(new UniversalPlayer.OrientationChangeCallBack(this));
            }
            this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView)) {
                return ((CyberVideoView) this.mKernelLayer.getContentView()).isPlaying();
            }
            return super.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void j(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            boolean z = true;
            int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            setGlobalMuteMode(i == 0 && f2 == 0.0f);
            if (i == 0 && f2 == 0.0f) {
                abandonAudioFocus();
            } else {
                requestAudioFocus();
            }
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null && (baseKernelLayer.getContentView() instanceof CyberVideoView) && ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer() != null) {
                ((CyberVideoView) this.mKernelLayer.getContentView()).getCyberPlayer().setVolume(f, f2);
            } else {
                mute((i == 0 && f2 == 0.0f) ? false : false);
            }
        }
    }

    public boolean k(OnSnapShotFrameListener onSnapShotFrameListener, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048585, this, onSnapShotFrameListener, f)) == null) {
            BaseKernelLayer baseKernelLayer = this.mKernelLayer;
            if (baseKernelLayer != null) {
                return baseKernelLayer.takeSnapshotAsync(onSnapShotFrameListener, f);
            }
            return false;
        }
        return invokeLF.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onAudioFocusChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onCompletion();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048588, this, i, i2, obj)) == null) {
            this.mProgressHelper.cancel();
            return super.onError(i, i2, obj);
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onSeekComplete();
            this.mProgressHelper.start();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.pause();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.release();
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.resume();
            this.mProgressHelper.start();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupKernelLayer(@Nullable BaseKernelLayer baseKernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, baseKernelLayer) == null) {
            super.setupKernelLayer(g(this, baseKernelLayer));
        }
    }

    @Override // com.baidu.searchbox.player.UniversalPlayer, com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            this.mKernelLayer.setAcceptVolumeChange(Boolean.FALSE);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlugin(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            super.setupPlugin(context);
            addPlugin(new CoreStatPlugin());
            addPlugin(new DurationStatPlugin());
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (isPause()) {
                resume();
            } else {
                super.start();
            }
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer, com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.stop();
            this.mProgressHelper.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t88(@Nullable Context context, @Nullable String str) {
        super(context, "", str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.mLayerContainer.setClickable(false);
    }
}
