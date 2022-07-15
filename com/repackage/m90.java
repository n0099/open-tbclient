package com.repackage;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feedplayer.base.LivePlayerProvider;
import com.baidu.searchbox.live.interfaces.player.LivePlayer;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class m90 implements LivePlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LivePlayer a;

    public m90(o90 mediaSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mediaSource, "mediaSource");
        String a = mediaSource.a();
        this.a = LivePlayerProvider.b.a(a == null ? "0000" : a);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onInfoListener) == null) {
            Intrinsics.checkNotNullParameter(onInfoListener, "onInfoListener");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.addOnInfoListener(onInfoListener);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void addProgressListener(LivePlayer.OnProgressChangeListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.addProgressListener(listener);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachKernelLayer(BaseKernelLayer kernelLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kernelLayer) == null) {
            Intrinsics.checkNotNullParameter(kernelLayer, "kernelLayer");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.attachKernelLayer(kernelLayer);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void attachToContainer(ViewGroup holder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, holder) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.attachToContainer(holder);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean checkMode(String mode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mode)) == null) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.checkMode(mode);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void detachFromContainer() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.detachFromContainer();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public BaseKernelLayer detachKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.detachKernelLayer();
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void disableOrientationEventHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.disableOrientationEventHelper();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void enableOrientationEventHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.enableOrientationEventHelper();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getCurrentMode();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getDuration();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public Object getInfo(Object key, Object obj, LivePlayer.InfoCallback infoCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, key, obj, infoCallback)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getInfo(key, obj, infoCallback);
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LivePlayer livePlayer = this.a;
            Intrinsics.checkNotNull(livePlayer);
            return livePlayer.getPlayerCallbackManager();
        }
        return (UniversalPlayerCallbackManager) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, cls)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return (T) livePlayer.getPlayerContext(cls);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public BaseKernelLayer getPlayerKernelLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getPlayerKernelLayer();
            }
            return null;
        }
        return (BaseKernelLayer) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getPosition();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getServerIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getServerIpInfo();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.getVideoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void goBackOrForeground(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.goBackOrForeground(z);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void imCloseTimeStatistics() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.imCloseTimeStatistics();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isComplete();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isError();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isFloatingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isFloatingMode();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isPause();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public boolean isReverseLandscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                return livePlayer.isReverseLandscape();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void mute(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.mute(z);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void pause() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.pause();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void pauseInternal(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.pauseInternal(z);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void play(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.play(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void prePlay() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.prePlay();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void prepare() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.prepare();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void registerContext(Class<? extends IPlayerContext> cls, IPlayerContext context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, cls, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.registerContext(cls, context);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void release() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.release();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeOnInfoListener(LivePlayer.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onInfoListener) == null) {
            Intrinsics.checkNotNullParameter(onInfoListener, "onInfoListener");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.removeOnInfoListener(onInfoListener);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removePlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, iVideoPlayerCallback) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.removePlayerListener(iVideoPlayerCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void removeProgressListener(LivePlayer.OnProgressChangeListener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.removeProgressListener(listener);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resetDefaultSwitchHelper() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.resetDefaultSwitchHelper();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resume(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.resume(z);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumeFromError() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.resumeFromError();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void resumePlayer(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.resumePlayer(z);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void saveProgressToDb() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.saveProgressToDb();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void seekTo(int i, int i2) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048620, this, i, i2) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.seekTo(i, i2);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void sendEvent(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.sendEvent(event);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setAcceptVolumeChange(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048622, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setAcceptVolumeChange(z);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setExtInfoStatistics(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, hashMap) == null) {
            LivePlayer.DefaultImpls.setExtInfoStatistics(this, hashMap);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setMode(String mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, mode) == null) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.setMode(mode);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setOrientationLock(boolean z) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setOrientationLock(z);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, iVideoPlayerCallback) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setPlayerListener(iVideoPlayerCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setSpeed(float f) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048627, this, f) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setSpeed(f);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setStyleSwitchHelper(IPlayerStyleSwitchHelper helper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, helper) == null) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            LivePlayer livePlayer = this.a;
            if (livePlayer != null) {
                livePlayer.setStyleSwitchHelper(helper);
            }
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setUserAgent(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, str) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setUserAgent(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoBackground(Drawable drawable) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, drawable) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setVideoBackground(drawable);
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void setVideoInfo(HashMap<Integer, String> hashMap) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, hashMap) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setVideoInfo(hashMap);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoRotation(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048632, this, i) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setVideoRotation(i);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoScalingMode(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setVideoScalingMode(i);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void setVideoUrl(String str) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, str) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.setVideoUrl(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void start() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.start();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void stop() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.stop();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void stopTimeStatistics() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.stopTimeStatistics();
    }

    @Override // com.baidu.searchbox.live.interfaces.player.LivePlayer
    public void switchToHalf() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.switchToHalf();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void resume() {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.resume();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    public void seekTo(int i) {
        LivePlayer livePlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i) == null) || (livePlayer = this.a) == null) {
            return;
        }
        livePlayer.seekTo(i);
    }
}
