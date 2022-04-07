package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@TargetApi(16)
/* loaded from: classes4.dex */
public class SimpleExoPlayer implements ExoPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SimpleExoPlayer";
    public transient /* synthetic */ FieldHolder $fh;
    public AudioAttributes audioAttributes;
    public AudioRendererEventListener audioDebugListener;
    public DecoderCounters audioDecoderCounters;
    public Format audioFormat;
    public final int audioRendererCount;
    public int audioSessionId;
    public float audioVolume;
    public final ComponentListener componentListener;
    public final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    public boolean ownsSurface;
    public final ExoPlayer player;
    public final Renderer[] renderers;
    public Surface surface;
    public SurfaceHolder surfaceHolder;
    public final CopyOnWriteArraySet<TextOutput> textOutputs;
    public TextureView textureView;
    public VideoRendererEventListener videoDebugListener;
    public DecoderCounters videoDecoderCounters;
    public Format videoFormat;
    public final CopyOnWriteArraySet<VideoListener> videoListeners;
    public final int videoRendererCount;
    public int videoScalingMode;

    /* renamed from: com.google.android.exoplayer2.SimpleExoPlayer$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleExoPlayer this$0;

        public ComponentListener(SimpleExoPlayer simpleExoPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleExoPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = simpleExoPlayer;
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.this$0.audioDebugListener == null) {
                return;
            }
            this.this$0.audioDebugListener.onAudioDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, decoderCounters) == null) {
                if (this.this$0.audioDebugListener != null) {
                    this.this$0.audioDebugListener.onAudioDisabled(decoderCounters);
                }
                this.this$0.audioFormat = null;
                this.this$0.audioDecoderCounters = null;
                this.this$0.audioSessionId = 0;
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, decoderCounters) == null) {
                this.this$0.audioDecoderCounters = decoderCounters;
                if (this.this$0.audioDebugListener != null) {
                    this.this$0.audioDebugListener.onAudioEnabled(decoderCounters);
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, format) == null) {
                this.this$0.audioFormat = format;
                if (this.this$0.audioDebugListener != null) {
                    this.this$0.audioDebugListener.onAudioInputFormatChanged(format);
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.this$0.audioSessionId = i;
                if (this.this$0.audioDebugListener != null) {
                    this.this$0.audioDebugListener.onAudioSessionId(i);
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) || this.this$0.audioDebugListener == null) {
                return;
            }
            this.this$0.audioDebugListener.onAudioSinkUnderrun(i, j, j2);
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                Iterator it = this.this$0.textOutputs.iterator();
                while (it.hasNext()) {
                    ((TextOutput) it.next()).onCues(list);
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) || this.this$0.videoDebugListener == null) {
                return;
            }
            this.this$0.videoDebugListener.onDroppedFrames(i, j);
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, metadata) == null) {
                Iterator it = this.this$0.metadataOutputs.iterator();
                while (it.hasNext()) {
                    ((MetadataOutput) it.next()).onMetadata(metadata);
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, surface) == null) {
                if (this.this$0.surface == surface) {
                    Iterator it = this.this$0.videoListeners.iterator();
                    while (it.hasNext()) {
                        ((VideoListener) it.next()).onRenderedFirstFrame();
                    }
                }
                if (this.this$0.videoDebugListener != null) {
                    this.this$0.videoDebugListener.onRenderedFirstFrame(surface);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048586, this, surfaceTexture, i, i2) == null) {
                this.this$0.setVideoSurfaceInternal(new Surface(surfaceTexture), true);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, surfaceTexture)) == null) {
                this.this$0.setVideoSurfaceInternal(null, true);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048588, this, surfaceTexture, i, i2) == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, surfaceTexture) == null) {
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.this$0.videoDebugListener == null) {
                return;
            }
            this.this$0.videoDebugListener.onVideoDecoderInitialized(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, decoderCounters) == null) {
                if (this.this$0.videoDebugListener != null) {
                    this.this$0.videoDebugListener.onVideoDisabled(decoderCounters);
                }
                this.this$0.videoFormat = null;
                this.this$0.videoDecoderCounters = null;
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, decoderCounters) == null) {
                this.this$0.videoDecoderCounters = decoderCounters;
                if (this.this$0.videoDebugListener != null) {
                    this.this$0.videoDebugListener.onVideoEnabled(decoderCounters);
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, format) == null) {
                this.this$0.videoFormat = format;
                if (this.this$0.videoDebugListener != null) {
                    this.this$0.videoDebugListener.onVideoInputFormatChanged(format);
                }
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)}) == null) {
                Iterator it = this.this$0.videoListeners.iterator();
                while (it.hasNext()) {
                    ((VideoListener) it.next()).onVideoSizeChanged(i, i2, i3, f);
                }
                if (this.this$0.videoDebugListener != null) {
                    this.this$0.videoDebugListener.onVideoSizeChanged(i, i2, i3, f);
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048595, this, surfaceHolder, i, i2, i3) == null) {
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) {
                this.this$0.setVideoSurfaceInternal(surfaceHolder.getSurface(), false);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, surfaceHolder) == null) {
                this.this$0.setVideoSurfaceInternal(null, false);
            }
        }

        public /* synthetic */ ComponentListener(SimpleExoPlayer simpleExoPlayer, AnonymousClass1 anonymousClass1) {
            this(simpleExoPlayer);
        }
    }

    /* loaded from: classes4.dex */
    public interface VideoListener {
        void onRenderedFirstFrame();

        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

    public SimpleExoPlayer(RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderersFactory, trackSelector, loadControl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.componentListener = new ComponentListener(this, null);
        this.videoListeners = new CopyOnWriteArraySet<>();
        this.textOutputs = new CopyOnWriteArraySet<>();
        this.metadataOutputs = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        ComponentListener componentListener = this.componentListener;
        Renderer[] createRenderers = renderersFactory.createRenderers(handler, componentListener, componentListener, componentListener, componentListener);
        this.renderers = createRenderers;
        int i3 = 0;
        int i4 = 0;
        for (Renderer renderer : createRenderers) {
            int trackType = renderer.getTrackType();
            if (trackType == 1) {
                i4++;
            } else if (trackType == 2) {
                i3++;
            }
        }
        this.videoRendererCount = i3;
        this.audioRendererCount = i4;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.player = createExoPlayerImpl(this.renderers, trackSelector, loadControl);
    }

    private void removeSurfaceCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            TextureView textureView = this.textureView;
            if (textureView != null) {
                if (textureView.getSurfaceTextureListener() != this.componentListener) {
                    Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
                } else {
                    this.textureView.setSurfaceTextureListener(null);
                }
                this.textureView = null;
            }
            SurfaceHolder surfaceHolder = this.surfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.componentListener);
                this.surfaceHolder = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoSurfaceInternal(Surface surface, boolean z) {
        Renderer[] rendererArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, this, surface, z) == null) {
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.videoRendererCount];
            int i = 0;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 2) {
                    exoPlayerMessageArr[i] = new ExoPlayer.ExoPlayerMessage(renderer, 1, surface);
                    i++;
                }
            }
            Surface surface2 = this.surface;
            if (surface2 != null && surface2 != surface) {
                this.player.blockingSendMessages(exoPlayerMessageArr);
                if (this.ownsSurface) {
                    this.surface.release();
                }
            } else {
                this.player.sendMessages(exoPlayerMessageArr);
            }
            this.surface = surface;
            this.ownsSurface = z;
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eventListener) == null) {
            this.player.addListener(eventListener);
        }
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metadataOutput) == null) {
            this.metadataOutputs.add(metadataOutput);
        }
    }

    public void addTextOutput(TextOutput textOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, textOutput) == null) {
            this.textOutputs.add(textOutput);
        }
    }

    public void addVideoListener(VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoListener) == null) {
            this.videoListeners.add(videoListener);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exoPlayerMessageArr) == null) {
            this.player.blockingSendMessages(exoPlayerMessageArr);
        }
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metadataOutput) == null) {
            removeMetadataOutput(metadataOutput);
        }
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, textOutput) == null) {
            removeTextOutput(textOutput);
        }
    }

    @Deprecated
    public void clearVideoListener(VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoListener) == null) {
            removeVideoListener(videoListener);
        }
    }

    public void clearVideoSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVideoSurface(null);
        }
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, surfaceHolder) == null) && surfaceHolder != null && surfaceHolder == this.surfaceHolder) {
            setVideoSurfaceHolder(null);
        }
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, surfaceView) == null) {
            clearVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    public void clearVideoTextureView(TextureView textureView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, textureView) == null) && textureView != null && textureView == this.textureView) {
            setVideoTextureView(null);
        }
    }

    public ExoPlayer createExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, rendererArr, trackSelector, loadControl)) == null) ? new ExoPlayerImpl(rendererArr, trackSelector, loadControl) : (ExoPlayer) invokeLLL.objValue;
    }

    public AudioAttributes getAudioAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.audioAttributes : (AudioAttributes) invokeV.objValue;
    }

    public DecoderCounters getAudioDecoderCounters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.audioDecoderCounters : (DecoderCounters) invokeV.objValue;
    }

    public Format getAudioFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.audioFormat : (Format) invokeV.objValue;
    }

    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.audioSessionId : invokeV.intValue;
    }

    @Deprecated
    public int getAudioStreamType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Util.getStreamTypeForAudioUsage(this.audioAttributes.usage) : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.player.getBufferedPercentage() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.player.getBufferedPosition() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.player.getContentPosition() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.player.getCurrentAdGroupIndex() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.player.getCurrentAdIndexInAdGroup() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public Object getCurrentManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.player.getCurrentManifest() : invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.player.getCurrentPeriodIndex() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.player.getCurrentPosition() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.player.getCurrentTimeline() : (Timeline) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.player.getCurrentTrackGroups() : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.player.getCurrentTrackSelections() : (TrackSelectionArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.player.getCurrentWindowIndex() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.player.getDuration() : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.player.getNextWindowIndex() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.player.getPlayWhenReady() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.player.getPlaybackLooper() : (Looper) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.player.getPlaybackParameters() : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.player.getPlaybackState() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.player.getPreviousWindowIndex() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.player.getRendererCount() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) ? this.player.getRendererType(i) : invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.player.getRepeatMode() : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.player.getShuffleModeEnabled() : invokeV.booleanValue;
    }

    public DecoderCounters getVideoDecoderCounters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.videoDecoderCounters : (DecoderCounters) invokeV.objValue;
    }

    public Format getVideoFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.videoFormat : (Format) invokeV.objValue;
    }

    public int getVideoScalingMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.videoScalingMode : invokeV.intValue;
    }

    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.audioVolume : invokeV.floatValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.player.isCurrentWindowDynamic() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.player.isCurrentWindowSeekable() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.player.isLoading() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.player.isPlayingAd() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, mediaSource) == null) {
            this.player.prepare(mediaSource);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.player.release();
            removeSurfaceCallbacks();
            Surface surface = this.surface;
            if (surface != null) {
                if (this.ownsSurface) {
                    surface.release();
                }
                this.surface = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, eventListener) == null) {
            this.player.removeListener(eventListener);
        }
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, metadataOutput) == null) {
            this.metadataOutputs.remove(metadataOutput);
        }
    }

    public void removeTextOutput(TextOutput textOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, textOutput) == null) {
            this.textOutputs.remove(textOutput);
        }
    }

    public void removeVideoListener(VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, videoListener) == null) {
            this.videoListeners.remove(videoListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048634, this, j) == null) {
            this.player.seekTo(j);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.player.seekToDefaultPosition();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, exoPlayerMessageArr) == null) {
            this.player.sendMessages(exoPlayerMessageArr);
        }
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        Renderer[] rendererArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, audioAttributes) == null) {
            this.audioAttributes = audioAttributes;
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.audioRendererCount];
            int i = 0;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 1) {
                    exoPlayerMessageArr[i] = new ExoPlayer.ExoPlayerMessage(renderer, 3, audioAttributes);
                    i++;
                }
            }
            this.player.sendMessages(exoPlayerMessageArr);
        }
    }

    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, audioRendererEventListener) == null) {
            this.audioDebugListener = audioRendererEventListener;
        }
    }

    @Deprecated
    public void setAudioStreamType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            int audioUsageForStreamType = Util.getAudioUsageForStreamType(i);
            setAudioAttributes(new AudioAttributes.Builder().setUsage(audioUsageForStreamType).setContentType(Util.getAudioContentTypeForStreamType(i)).build());
        }
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, metadataOutput) == null) {
            this.metadataOutputs.clear();
            if (metadataOutput != null) {
                addMetadataOutput(metadataOutput);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.player.setPlayWhenReady(z);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, playbackParameters) == null) {
            this.player.setPlaybackParameters(playbackParameters);
        }
    }

    @TargetApi(23)
    @Deprecated
    public void setPlaybackParams(@Nullable PlaybackParams playbackParams) {
        PlaybackParameters playbackParameters;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, playbackParams) == null) {
            if (playbackParams != null) {
                playbackParams.allowDefaults();
                playbackParameters = new PlaybackParameters(playbackParams.getSpeed(), playbackParams.getPitch());
            } else {
                playbackParameters = null;
            }
            setPlaybackParameters(playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.player.setRepeatMode(i);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.player.setShuffleModeEnabled(z);
        }
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, textOutput) == null) {
            this.textOutputs.clear();
            if (textOutput != null) {
                addTextOutput(textOutput);
            }
        }
    }

    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, videoRendererEventListener) == null) {
            this.videoDebugListener = videoRendererEventListener;
        }
    }

    @Deprecated
    public void setVideoListener(VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, videoListener) == null) {
            this.videoListeners.clear();
            if (videoListener != null) {
                addVideoListener(videoListener);
            }
        }
    }

    public void setVideoScalingMode(int i) {
        Renderer[] rendererArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            this.videoScalingMode = i;
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.videoRendererCount];
            int i2 = 0;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 2) {
                    exoPlayerMessageArr[i2] = new ExoPlayer.ExoPlayerMessage(renderer, 4, Integer.valueOf(i));
                    i2++;
                }
            }
            this.player.sendMessages(exoPlayerMessageArr);
        }
    }

    public void setVideoSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, surface) == null) {
            removeSurfaceCallbacks();
            setVideoSurfaceInternal(surface, false);
        }
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, surfaceHolder) == null) {
            removeSurfaceCallbacks();
            this.surfaceHolder = surfaceHolder;
            Surface surface = null;
            if (surfaceHolder == null) {
                setVideoSurfaceInternal(null, false);
                return;
            }
            surfaceHolder.addCallback(this.componentListener);
            Surface surface2 = surfaceHolder.getSurface();
            if (surface2 != null && surface2.isValid()) {
                surface = surface2;
            }
            setVideoSurfaceInternal(surface, false);
        }
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, surfaceView) == null) {
            setVideoSurfaceHolder(surfaceView == null ? null : surfaceView.getHolder());
        }
    }

    public void setVideoTextureView(TextureView textureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, textureView) == null) {
            removeSurfaceCallbacks();
            this.textureView = textureView;
            if (textureView == null) {
                setVideoSurfaceInternal(null, true);
                return;
            }
            if (textureView.getSurfaceTextureListener() != null) {
                Log.w(TAG, "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.componentListener);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            setVideoSurfaceInternal(surfaceTexture != null ? new Surface(surfaceTexture) : null, true);
        }
    }

    public void setVolume(float f) {
        Renderer[] rendererArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048655, this, f) == null) {
            this.audioVolume = f;
            ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr = new ExoPlayer.ExoPlayerMessage[this.audioRendererCount];
            int i = 0;
            for (Renderer renderer : this.renderers) {
                if (renderer.getTrackType() == 1) {
                    exoPlayerMessageArr[i] = new ExoPlayer.ExoPlayerMessage(renderer, 2, Float.valueOf(f));
                    i++;
                }
            }
            this.player.sendMessages(exoPlayerMessageArr);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.player.stop();
        }
    }

    public void clearVideoSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, surface) == null) && surface != null && surface == this.surface) {
            setVideoSurface(null);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{mediaSource, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.player.prepare(mediaSource, z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048633, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.player.seekTo(i, j);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.player.seekToDefaultPosition(i);
        }
    }
}
