package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class DebugTextViewHelper extends Player.DefaultEventListener implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REFRESH_INTERVAL_MS = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleExoPlayer player;
    public boolean started;
    public final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleExoPlayer, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.player = simpleExoPlayer;
        this.textView = textView;
    }

    private String getAudioString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Format audioFormat = this.player.getAudioFormat();
            if (audioFormat == null) {
                return "";
            }
            return StringUtils.LF + audioFormat.sampleMimeType + "(id:" + audioFormat.id + " hz:" + audioFormat.sampleRate + " ch:" + audioFormat.channelCount + getDecoderCountersBufferCountString(this.player.getAudioDecoderCounters()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, decoderCounters)) == null) {
            if (decoderCounters == null) {
                return "";
            }
            decoderCounters.ensureUpdated();
            return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
        }
        return (String) invokeL.objValue;
    }

    public static String getPixelAspectRatioString(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) {
            if (f2 == -1.0f || f2 == 1.0f) {
                return "";
            }
            return " par:" + String.format(Locale.US, "%.02f", Float.valueOf(f2));
        }
        return (String) invokeF.objValue;
    }

    private String getPlayerStateString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            String str = "playWhenReady:" + this.player.getPlayWhenReady() + " playbackState:";
            int playbackState = this.player.getPlaybackState();
            if (playbackState == 1) {
                return str + "idle";
            } else if (playbackState == 2) {
                return str + "buffering";
            } else if (playbackState == 3) {
                return str + "ready";
            } else if (playbackState != 4) {
                return str + "unknown";
            } else {
                return str + "ended";
            }
        }
        return (String) invokeV.objValue;
    }

    private String getPlayerWindowIndexString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return " window:" + this.player.getCurrentWindowIndex();
        }
        return (String) invokeV.objValue;
    }

    private String getVideoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            Format videoFormat = this.player.getVideoFormat();
            if (videoFormat == null) {
                return "";
            }
            return StringUtils.LF + videoFormat.sampleMimeType + "(id:" + videoFormat.id + " r:" + videoFormat.width + "x" + videoFormat.height + getPixelAspectRatioString(videoFormat.pixelWidthHeightRatio) + getDecoderCountersBufferCountString(this.player.getVideoDecoderCounters()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"SetTextI18n"})
    private void updateAndPost() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TextView textView = this.textView;
            textView.setText(getPlayerStateString() + getPlayerWindowIndexString() + getVideoString() + getAudioString());
            this.textView.removeCallbacks(this);
            this.textView.postDelayed(this, 1000L);
        }
    }

    @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            updateAndPost();
        }
    }

    @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            updateAndPost();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            updateAndPost();
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.started) {
            return;
        }
        this.started = true;
        this.player.addListener(this);
        updateAndPost();
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.started) {
            this.started = false;
            this.player.removeListener(this);
            this.textView.removeCallbacks(this);
        }
    }
}
