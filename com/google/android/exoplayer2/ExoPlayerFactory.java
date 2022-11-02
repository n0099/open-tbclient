package com.google.android.exoplayer2;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.trackselection.TrackSelector;
/* loaded from: classes7.dex */
public final class ExoPlayerFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ExoPlayerFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector trackSelector) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, rendererArr, trackSelector)) == null) {
            return newInstance(rendererArr, trackSelector, new DefaultLoadControl());
        }
        return (ExoPlayer) invokeLL.objValue;
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, trackSelector)) == null) {
            return newSimpleInstance(new DefaultRenderersFactory(context), trackSelector);
        }
        return (SimpleExoPlayer) invokeLL.objValue;
    }

    public static ExoPlayer newInstance(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, rendererArr, trackSelector, loadControl)) == null) {
            return new ExoPlayerImpl(rendererArr, trackSelector, loadControl);
        }
        return (ExoPlayer) invokeLLL.objValue;
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, trackSelector, loadControl)) == null) {
            return newSimpleInstance(new DefaultRenderersFactory(context), trackSelector, loadControl);
        }
        return (SimpleExoPlayer) invokeLLL.objValue;
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, trackSelector, loadControl, drmSessionManager)) == null) {
            return newSimpleInstance(new DefaultRenderersFactory(context, drmSessionManager), trackSelector, loadControl);
        }
        return (SimpleExoPlayer) invokeLLLL.objValue;
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, trackSelector, loadControl, drmSessionManager, Integer.valueOf(i)})) == null) {
            return newSimpleInstance(new DefaultRenderersFactory(context, drmSessionManager, i), trackSelector, loadControl);
        }
        return (SimpleExoPlayer) invokeCommon.objValue;
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, trackSelector, loadControl, drmSessionManager, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return newSimpleInstance(new DefaultRenderersFactory(context, drmSessionManager, i, j), trackSelector, loadControl);
        }
        return (SimpleExoPlayer) invokeCommon.objValue;
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, renderersFactory, trackSelector)) == null) {
            return newSimpleInstance(renderersFactory, trackSelector, new DefaultLoadControl());
        }
        return (SimpleExoPlayer) invokeLL.objValue;
    }

    public static SimpleExoPlayer newSimpleInstance(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, renderersFactory, trackSelector, loadControl)) == null) {
            return new SimpleExoPlayer(renderersFactory, trackSelector, loadControl);
        }
        return (SimpleExoPlayer) invokeLLL.objValue;
    }
}
