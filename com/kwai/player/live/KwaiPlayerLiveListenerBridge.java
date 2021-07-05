package com.kwai.player.live;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.annotations.CalledByNative;
import java.lang.ref.WeakReference;
@Keep
/* loaded from: classes7.dex */
public class KwaiPlayerLiveListenerBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public KwaiPlayerLiveListenerBridge() {
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

    public static IKwaiMediaPlayer.OnLiveInterActiveListener getListener(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return (IKwaiMediaPlayer.OnLiveInterActiveListener) ((WeakReference) obj).get();
        }
        return (IKwaiMediaPlayer.OnLiveInterActiveListener) invokeL.objValue;
    }

    @CalledByNative
    public static void onParseAdSei(Object obj, long j, int i2, String str) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{obj, Long.valueOf(j), Integer.valueOf(i2), str}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onParseAdSei(j, i2, str);
    }

    @CalledByNative
    public static void onTsptInfo(Object obj, byte[] bArr, int i2) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65539, null, obj, bArr, i2) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onTsptInfo(bArr, i2);
    }

    @CalledByNative
    public static void onVideoFrameRender(Object obj, long j) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65540, null, obj, j) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onVideoFrameRender(j);
    }
}
