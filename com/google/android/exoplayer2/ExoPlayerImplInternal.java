package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaPeriodInfoSequence;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;
import com.google.android.exoplayer2.util.TraceUtil;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSource.Listener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IDLE_INTERVAL_MS = 1000;
    public static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    public static final int MSG_CUSTOM = 11;
    public static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 7;
    public static final int MSG_LOADING_CHANGED = 1;
    public static final int MSG_PERIOD_PREPARED = 8;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 6;
    public static final int MSG_POSITION_DISCONTINUITY = 4;
    public static final int MSG_PREPARE = 0;
    public static final int MSG_REFRESH_SOURCE_INFO = 7;
    public static final int MSG_RELEASE = 6;
    public static final int MSG_SEEK_ACK = 3;
    public static final int MSG_SEEK_TO = 3;
    public static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    public static final int MSG_SET_PLAY_WHEN_READY = 1;
    public static final int MSG_SET_REPEAT_MODE = 12;
    public static final int MSG_SET_SHUFFLE_ENABLED = 13;
    public static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    public static final int MSG_SOURCE_INFO_REFRESHED = 5;
    public static final int MSG_STATE_CHANGED = 0;
    public static final int MSG_STOP = 5;
    public static final int MSG_TRACKS_CHANGED = 2;
    public static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    public static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    public static final int RENDERER_TIMESTAMP_OFFSET_US = 60000000;
    public static final int RENDERING_INTERVAL_MS = 10;
    public static final String TAG = "ExoPlayerImplInternal";
    public transient /* synthetic */ FieldHolder $fh;
    public int customMessagesProcessed;
    public int customMessagesSent;
    public long elapsedRealtimeUs;
    public Renderer[] enabledRenderers;
    public final Handler eventHandler;
    public final Handler handler;
    public final HandlerThread internalPlaybackThread;
    public boolean isLoading;
    public final LoadControl loadControl;
    public MediaPeriodHolder loadingPeriodHolder;
    public final MediaPeriodInfoSequence mediaPeriodInfoSequence;
    public MediaSource mediaSource;
    public int pendingInitialSeekCount;
    public int pendingPrepareCount;
    public SeekPosition pendingSeekPosition;
    public final Timeline.Period period;
    public boolean playWhenReady;
    public PlaybackInfo playbackInfo;
    public PlaybackParameters playbackParameters;
    public final ExoPlayer player;
    public MediaPeriodHolder playingPeriodHolder;
    public MediaPeriodHolder readingPeriodHolder;
    public boolean rebuffering;
    public boolean released;
    public final RendererCapabilities[] rendererCapabilities;
    public MediaClock rendererMediaClock;
    public Renderer rendererMediaClockSource;
    public long rendererPositionUs;
    public final Renderer[] renderers;
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public final StandaloneMediaClock standaloneMediaClock;
    public int state;
    public final TrackSelector trackSelector;
    public final Timeline.Window window;

    /* loaded from: classes7.dex */
    public static final class MediaPeriodHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean hasEnabledTracks;
        public final int index;
        public MediaPeriodInfoSequence.MediaPeriodInfo info;
        public final LoadControl loadControl;
        public final boolean[] mayRetainStreamFlags;
        public final MediaPeriod mediaPeriod;
        public final MediaSource mediaSource;
        public MediaPeriodHolder next;
        public TrackSelectorResult periodTrackSelectorResult;
        public boolean prepared;
        public final RendererCapabilities[] rendererCapabilities;
        public final long rendererPositionOffsetUs;
        public final Renderer[] renderers;
        public final SampleStream[] sampleStreams;
        public final TrackSelector trackSelector;
        public TrackSelectorResult trackSelectorResult;
        public final Object uid;

        public MediaPeriodHolder(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, LoadControl loadControl, MediaSource mediaSource, Object obj, int i2, MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rendererArr, rendererCapabilitiesArr, Long.valueOf(j2), trackSelector, loadControl, mediaSource, obj, Integer.valueOf(i2), mediaPeriodInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.renderers = rendererArr;
            this.rendererCapabilities = rendererCapabilitiesArr;
            this.rendererPositionOffsetUs = j2;
            this.trackSelector = trackSelector;
            this.loadControl = loadControl;
            this.mediaSource = mediaSource;
            this.uid = Assertions.checkNotNull(obj);
            this.index = i2;
            this.info = mediaPeriodInfo;
            this.sampleStreams = new SampleStream[rendererArr.length];
            this.mayRetainStreamFlags = new boolean[rendererArr.length];
            MediaPeriod createPeriod = mediaSource.createPeriod(mediaPeriodInfo.id, loadControl.getAllocator());
            if (mediaPeriodInfo.endPositionUs != Long.MIN_VALUE) {
                ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(createPeriod, true);
                clippingMediaPeriod.setClipping(0L, mediaPeriodInfo.endPositionUs);
                createPeriod = clippingMediaPeriod;
            }
            this.mediaPeriod = createPeriod;
        }

        private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65537, this, sampleStreamArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
                if (i2 >= rendererCapabilitiesArr.length) {
                    return;
                }
                if (rendererCapabilitiesArr[i2].getTrackType() == 5 && this.trackSelectorResult.renderersEnabled[i2]) {
                    sampleStreamArr[i2] = new EmptySampleStream();
                }
                i2++;
            }
        }

        private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(65538, this, sampleStreamArr) != null) {
                return;
            }
            int i2 = 0;
            while (true) {
                RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
                if (i2 >= rendererCapabilitiesArr.length) {
                    return;
                }
                if (rendererCapabilitiesArr[i2].getTrackType() == 5) {
                    sampleStreamArr[i2] = null;
                }
                i2++;
            }
        }

        public void continueLoading(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                this.mediaPeriod.continueLoading(toPeriodTime(j2));
            }
        }

        public long getRendererOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.index == 0 ? this.rendererPositionOffsetUs : this.rendererPositionOffsetUs - this.info.startPositionUs : invokeV.longValue;
        }

        public void handlePrepared() throws ExoPlaybackException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.prepared = true;
                selectTracks();
                this.info = this.info.copyWithStartPositionUs(updatePeriodTrackSelection(this.info.startPositionUs, false));
            }
        }

        public boolean haveSufficientBuffer(boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                long bufferedPositionUs = !this.prepared ? this.info.startPositionUs : this.mediaPeriod.getBufferedPositionUs();
                if (bufferedPositionUs == Long.MIN_VALUE) {
                    MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo = this.info;
                    if (mediaPeriodInfo.isFinal) {
                        return true;
                    }
                    bufferedPositionUs = mediaPeriodInfo.durationUs;
                }
                return this.loadControl.shouldStartPlayback(bufferedPositionUs - toPeriodTime(j2), z);
            }
            return invokeCommon.booleanValue;
        }

        public boolean isFullyBuffered() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE) : invokeV.booleanValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                try {
                    if (this.info.endPositionUs != Long.MIN_VALUE) {
                        this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
                    } else {
                        this.mediaSource.releasePeriod(this.mediaPeriod);
                    }
                } catch (RuntimeException unused) {
                }
            }
        }

        public boolean selectTracks() throws ExoPlaybackException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.mediaPeriod.getTrackGroups());
                if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
                    return false;
                }
                this.trackSelectorResult = selectTracks;
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean shouldContinueLoading(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
                long nextLoadPositionUs = !this.prepared ? 0L : this.mediaPeriod.getNextLoadPositionUs();
                if (nextLoadPositionUs == Long.MIN_VALUE) {
                    return false;
                }
                return this.loadControl.shouldContinueLoading(nextLoadPositionUs - toPeriodTime(j2));
            }
            return invokeJ.booleanValue;
        }

        public long toPeriodTime(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? j2 - getRendererOffset() : invokeJ.longValue;
        }

        public long toRendererTime(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) ? j2 + getRendererOffset() : invokeJ.longValue;
        }

        public long updatePeriodTrackSelection(long j2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) ? updatePeriodTrackSelection(j2, z, new boolean[this.renderers.length]) : invokeCommon.longValue;
        }

        public long updatePeriodTrackSelection(long j2, boolean z, boolean[] zArr) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), zArr})) != null) {
                return invokeCommon.longValue;
            }
            TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= trackSelectionArray.length) {
                    break;
                }
                boolean[] zArr2 = this.mayRetainStreamFlags;
                if (z || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i2)) {
                    z2 = false;
                }
                zArr2[i2] = z2;
                i2++;
            }
            disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
            long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j2);
            associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
            this.periodTrackSelectorResult = this.trackSelectorResult;
            this.hasEnabledTracks = false;
            int i3 = 0;
            while (true) {
                SampleStream[] sampleStreamArr = this.sampleStreams;
                if (i3 < sampleStreamArr.length) {
                    if (sampleStreamArr[i3] != null) {
                        Assertions.checkState(this.trackSelectorResult.renderersEnabled[i3]);
                        if (this.rendererCapabilities[i3].getTrackType() != 5) {
                            this.hasEnabledTracks = true;
                        }
                    } else {
                        Assertions.checkState(trackSelectionArray.get(i3) == null);
                    }
                    i3++;
                } else {
                    this.loadControl.onTracksSelected(this.renderers, this.trackSelectorResult.groups, trackSelectionArray);
                    return selectTracks;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class MediaSourceRefreshInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object manifest;
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource, Timeline timeline, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSource, timeline, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.source = mediaSource;
            this.timeline = timeline;
            this.manifest = obj;
        }
    }

    /* loaded from: classes7.dex */
    public static final class SeekPosition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeline, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timeline = timeline;
            this.windowIndex = i2;
            this.windowPositionUs = j2;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, boolean z, int i2, boolean z2, Handler handler, ExoPlayer exoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rendererArr, trackSelector, loadControl, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), handler, exoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.loadControl = loadControl;
        this.playWhenReady = z;
        this.repeatMode = i2;
        this.shuffleModeEnabled = z2;
        this.eventHandler = handler;
        this.state = 1;
        this.player = exoPlayer;
        this.playbackInfo = new PlaybackInfo(null, null, 0, C.TIME_UNSET);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i5 = 0; i5 < rendererArr.length; i5++) {
            rendererArr[i5].setIndex(i5);
            this.rendererCapabilities[i5] = rendererArr[i5].getCapabilities();
        }
        this.standaloneMediaClock = new StandaloneMediaClock();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.mediaPeriodInfoSequence = new MediaPeriodInfoSequence();
        trackSelector.init(this);
        this.playbackParameters = PlaybackParameters.DEFAULT;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.internalPlaybackThread.getLooper(), this);
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, renderer) == null) {
            if (renderer == this.rendererMediaClockSource) {
                this.rendererMediaClock = null;
                this.rendererMediaClockSource = null;
            }
            ensureStopped(renderer);
            renderer.disable();
        }
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        Renderer[] rendererArr;
        boolean isTimelineReady;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            updatePeriods();
            if (this.playingPeriodHolder == null) {
                maybeThrowPeriodPrepareError();
                scheduleNextWork(elapsedRealtime, 10L);
                return;
            }
            TraceUtil.beginSection("doSomeWork");
            updatePlaybackPositions();
            this.playingPeriodHolder.mediaPeriod.discardBuffer(this.playbackInfo.positionUs);
            boolean z = true;
            boolean z2 = true;
            for (Renderer renderer : this.enabledRenderers) {
                renderer.render(this.rendererPositionUs, this.elapsedRealtimeUs);
                z2 = z2 && renderer.isEnded();
                boolean z3 = renderer.isReady() || renderer.isEnded() || rendererWaitingForNextStream(renderer);
                if (!z3) {
                    renderer.maybeThrowStreamError();
                }
                z = z && z3;
            }
            if (!z) {
                maybeThrowPeriodPrepareError();
            }
            MediaClock mediaClock = this.rendererMediaClock;
            if (mediaClock != null) {
                PlaybackParameters playbackParameters = mediaClock.getPlaybackParameters();
                if (!playbackParameters.equals(this.playbackParameters)) {
                    this.playbackParameters = playbackParameters;
                    this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
                    this.eventHandler.obtainMessage(6, playbackParameters).sendToTarget();
                }
            }
            long j2 = this.playingPeriodHolder.info.durationUs;
            if (z2 && ((j2 == C.TIME_UNSET || j2 <= this.playbackInfo.positionUs) && this.playingPeriodHolder.info.isFinal)) {
                setState(4);
                stopRenderers();
            } else {
                int i3 = this.state;
                if (i3 == 2) {
                    if (this.enabledRenderers.length > 0) {
                        isTimelineReady = z && this.loadingPeriodHolder.haveSufficientBuffer(this.rebuffering, this.rendererPositionUs);
                    } else {
                        isTimelineReady = isTimelineReady(j2);
                    }
                    if (isTimelineReady) {
                        setState(3);
                        if (this.playWhenReady) {
                            startRenderers();
                        }
                    }
                } else if (i3 == 3) {
                    if (this.enabledRenderers.length <= 0) {
                        z = isTimelineReady(j2);
                    }
                    if (!z) {
                        this.rebuffering = this.playWhenReady;
                        setState(2);
                        stopRenderers();
                    }
                }
            }
            if (this.state == 2) {
                for (Renderer renderer2 : this.enabledRenderers) {
                    renderer2.maybeThrowStreamError();
                }
            }
            if ((this.playWhenReady && this.state == 3) || (i2 = this.state) == 2) {
                scheduleNextWork(elapsedRealtime, 10L);
            } else if (this.enabledRenderers.length != 0 && i2 != 4) {
                scheduleNextWork(elapsedRealtime, 1000L);
            } else {
                this.handler.removeMessages(2);
            }
            TraceUtil.endSection();
        }
    }

    private void enableRenderer(int i2, boolean z, int i3) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            Renderer renderer = this.renderers[i2];
            this.enabledRenderers[i3] = renderer;
            if (renderer.getState() == 0) {
                TrackSelectorResult trackSelectorResult = this.playingPeriodHolder.trackSelectorResult;
                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i2];
                Format[] formats = getFormats(trackSelectorResult.selections.get(i2));
                boolean z2 = this.playWhenReady && this.state == 3;
                boolean z3 = !z && z2;
                MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
                renderer.enable(rendererConfiguration, formats, mediaPeriodHolder.sampleStreams[i2], this.rendererPositionUs, z3, mediaPeriodHolder.getRendererOffset());
                MediaClock mediaClock = renderer.getMediaClock();
                if (mediaClock != null) {
                    if (this.rendererMediaClock == null) {
                        this.rendererMediaClock = mediaClock;
                        this.rendererMediaClockSource = renderer;
                        mediaClock.setPlaybackParameters(this.playbackParameters);
                    } else {
                        throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
                    }
                }
                if (z2) {
                    renderer.start();
                }
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, zArr, i2) == null) {
            this.enabledRenderers = new Renderer[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < this.renderers.length; i4++) {
                if (this.playingPeriodHolder.trackSelectorResult.renderersEnabled[i4]) {
                    enableRenderer(i4, zArr[i4], i3);
                    i3++;
                }
            }
        }
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, renderer) == null) && renderer.getState() == 2) {
            renderer.stop();
        }
    }

    @NonNull
    public static Format[] getFormats(TrackSelection trackSelection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, trackSelection)) == null) {
            int length = trackSelection != null ? trackSelection.length() : 0;
            Format[] formatArr = new Format[length];
            for (int i2 = 0; i2 < length; i2++) {
                formatArr[i2] = trackSelection.getFormat(i2);
            }
            return formatArr;
        }
        return (Format[]) invokeL.objValue;
    }

    private Pair<Integer, Long> getPeriodPosition(Timeline timeline, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{timeline, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? timeline.getPeriodPosition(this.window, this.period, i2, j2) : (Pair) invokeCommon.objValue;
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, mediaPeriod) == null) && (mediaPeriodHolder = this.loadingPeriodHolder) != null && mediaPeriodHolder.mediaPeriod == mediaPeriod) {
            maybeContinueLoading();
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, mediaPeriod) == null) && (mediaPeriodHolder = this.loadingPeriodHolder) != null && mediaPeriodHolder.mediaPeriod == mediaPeriod) {
            mediaPeriodHolder.handlePrepared();
            if (this.playingPeriodHolder == null) {
                MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder;
                this.readingPeriodHolder = mediaPeriodHolder2;
                resetRendererPosition(mediaPeriodHolder2.info.startPositionUs);
                setPlayingPeriodHolder(this.readingPeriodHolder);
            }
            maybeContinueLoading();
        }
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            handleSourceInfoRefreshEndedPlayback(0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e0, code lost:
        r3 = r20.readingPeriodHolder;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01e2, code lost:
        if (r3 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e8, code lost:
        if (r3.index >= r2.index) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ea, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01eb, code lost:
        if (r11 != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01ed, code lost:
        r6 = seekToPeriodPosition(r20.playingPeriodHolder.info.id, r20.playbackInfo.positionUs);
        r4 = r20.playbackInfo;
        r20.playbackInfo = r4.fromNewPosition(r20.playingPeriodHolder.info.id, r6, r4.contentPositionUs);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020c, code lost:
        r20.loadingPeriodHolder = r1;
        r1.next = null;
        releasePeriodHoldersFrom(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleSourceInfoRefreshed(MediaSourceRefreshInfo mediaSourceRefreshInfo) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, mediaSourceRefreshInfo) == null) && mediaSourceRefreshInfo.source == this.mediaSource) {
            Timeline timeline = this.playbackInfo.timeline;
            Timeline timeline2 = mediaSourceRefreshInfo.timeline;
            Object obj = mediaSourceRefreshInfo.manifest;
            this.mediaPeriodInfoSequence.setTimeline(timeline2);
            PlaybackInfo copyWithTimeline = this.playbackInfo.copyWithTimeline(timeline2, obj);
            this.playbackInfo = copyWithTimeline;
            long j2 = C.TIME_UNSET;
            boolean z = false;
            if (timeline == null) {
                int i2 = this.pendingPrepareCount;
                this.pendingPrepareCount = 0;
                if (this.pendingInitialSeekCount > 0) {
                    Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(this.pendingSeekPosition);
                    int i3 = this.pendingInitialSeekCount;
                    this.pendingInitialSeekCount = 0;
                    this.pendingSeekPosition = null;
                    if (resolveSeekPosition == null) {
                        handleSourceInfoRefreshEndedPlayback(i2, i3);
                        return;
                    }
                    int intValue = ((Integer) resolveSeekPosition.first).intValue();
                    long longValue = ((Long) resolveSeekPosition.second).longValue();
                    MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue, longValue);
                    this.playbackInfo = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds, resolvePeriodPositionForAds.isAd() ? 0L : longValue, longValue);
                    notifySourceInfoRefresh(i2, i3);
                    return;
                } else if (copyWithTimeline.startPositionUs == C.TIME_UNSET) {
                    if (timeline2.isEmpty()) {
                        handleSourceInfoRefreshEndedPlayback(i2, 0);
                        return;
                    }
                    Pair<Integer, Long> periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), C.TIME_UNSET);
                    int intValue2 = ((Integer) periodPosition.first).intValue();
                    long longValue2 = ((Long) periodPosition.second).longValue();
                    MediaSource.MediaPeriodId resolvePeriodPositionForAds2 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue2, longValue2);
                    this.playbackInfo = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds2, resolvePeriodPositionForAds2.isAd() ? 0L : longValue2, longValue2);
                    notifySourceInfoRefresh(i2, 0);
                    return;
                } else {
                    notifySourceInfoRefresh(i2, 0);
                    return;
                }
            }
            int i4 = copyWithTimeline.periodId.periodIndex;
            MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
            if (mediaPeriodHolder == null) {
                mediaPeriodHolder = this.loadingPeriodHolder;
            }
            if (mediaPeriodHolder == null && i4 >= timeline.getPeriodCount()) {
                notifySourceInfoRefresh();
                return;
            }
            int indexOfPeriod = timeline2.getIndexOfPeriod(mediaPeriodHolder == null ? timeline.getPeriod(i4, this.period, true).uid : mediaPeriodHolder.uid);
            if (indexOfPeriod == -1) {
                int resolveSubsequentPeriod = resolveSubsequentPeriod(i4, timeline, timeline2);
                if (resolveSubsequentPeriod == -1) {
                    handleSourceInfoRefreshEndedPlayback();
                    return;
                }
                Pair<Integer, Long> periodPosition2 = getPeriodPosition(timeline2, timeline2.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, C.TIME_UNSET);
                int intValue3 = ((Integer) periodPosition2.first).intValue();
                long longValue3 = ((Long) periodPosition2.second).longValue();
                timeline2.getPeriod(intValue3, this.period, true);
                if (mediaPeriodHolder != null) {
                    Object obj2 = this.period.uid;
                    mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithPeriodIndex(-1);
                    while (true) {
                        mediaPeriodHolder = mediaPeriodHolder.next;
                        if (mediaPeriodHolder == null) {
                            break;
                        } else if (mediaPeriodHolder.uid.equals(obj2)) {
                            mediaPeriodHolder.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder.info, intValue3);
                        } else {
                            mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithPeriodIndex(-1);
                        }
                    }
                }
                MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(intValue3);
                this.playbackInfo = this.playbackInfo.fromNewPosition(mediaPeriodId, seekToPeriodPosition(mediaPeriodId, longValue3), C.TIME_UNSET);
                notifySourceInfoRefresh();
                return;
            }
            if (indexOfPeriod != i4) {
                this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(indexOfPeriod);
            }
            if (this.playbackInfo.periodId.isAd()) {
                MediaSource.MediaPeriodId resolvePeriodPositionForAds3 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(indexOfPeriod, this.playbackInfo.contentPositionUs);
                if (!resolvePeriodPositionForAds3.isAd() || resolvePeriodPositionForAds3.adIndexInAdGroup != this.playbackInfo.periodId.adIndexInAdGroup) {
                    long seekToPeriodPosition = seekToPeriodPosition(resolvePeriodPositionForAds3, this.playbackInfo.contentPositionUs);
                    if (resolvePeriodPositionForAds3.isAd()) {
                        j2 = this.playbackInfo.contentPositionUs;
                    }
                    this.playbackInfo = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds3, seekToPeriodPosition, j2);
                    notifySourceInfoRefresh();
                    return;
                }
            }
            if (mediaPeriodHolder == null) {
                notifySourceInfoRefresh();
                return;
            }
            MediaPeriodHolder updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder, indexOfPeriod);
            int i5 = indexOfPeriod;
            while (true) {
                MediaPeriodHolder mediaPeriodHolder2 = updatePeriodInfo.next;
                if (mediaPeriodHolder2 == null) {
                    break;
                }
                i5 = timeline2.getNextPeriodIndex(i5, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                if (i5 == -1 || !mediaPeriodHolder2.uid.equals(timeline2.getPeriod(i5, this.period, true).uid)) {
                    break;
                }
                updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder2, i5);
            }
            notifySourceInfoRefresh();
        }
    }

    private boolean isTimelineReady(long j2) {
        InterceptResult invokeJ;
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65549, this, j2)) == null) ? j2 == C.TIME_UNSET || this.playbackInfo.positionUs < j2 || ((mediaPeriodHolder = this.playingPeriodHolder.next) != null && (mediaPeriodHolder.prepared || mediaPeriodHolder.info.id.isAd())) : invokeJ.booleanValue;
    }

    private void maybeContinueLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            boolean shouldContinueLoading = this.loadingPeriodHolder.shouldContinueLoading(this.rendererPositionUs);
            setIsLoading(shouldContinueLoading);
            if (shouldContinueLoading) {
                this.loadingPeriodHolder.continueLoading(this.rendererPositionUs);
            }
        }
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (mediaPeriodHolder = this.loadingPeriodHolder) == null || mediaPeriodHolder.prepared) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.readingPeriodHolder;
        if (mediaPeriodHolder2 == null || mediaPeriodHolder2.next == mediaPeriodHolder) {
            for (Renderer renderer : this.enabledRenderers) {
                if (!renderer.hasReadStreamToEnd()) {
                    return;
                }
            }
            this.loadingPeriodHolder.mediaPeriod.maybeThrowPrepareError();
        }
    }

    private void maybeUpdateLoadingPeriod() throws IOException {
        MediaPeriodInfoSequence.MediaPeriodInfo nextMediaPeriodInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            MediaPeriodHolder mediaPeriodHolder = this.loadingPeriodHolder;
            if (mediaPeriodHolder == null) {
                nextMediaPeriodInfo = this.mediaPeriodInfoSequence.getFirstMediaPeriodInfo(this.playbackInfo);
            } else if (mediaPeriodHolder.info.isFinal || !mediaPeriodHolder.isFullyBuffered()) {
                return;
            } else {
                MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder;
                if (mediaPeriodHolder2.info.durationUs == C.TIME_UNSET) {
                    return;
                }
                MediaPeriodHolder mediaPeriodHolder3 = this.playingPeriodHolder;
                if (mediaPeriodHolder3 != null && mediaPeriodHolder2.index - mediaPeriodHolder3.index == 100) {
                    return;
                }
                MediaPeriodInfoSequence mediaPeriodInfoSequence = this.mediaPeriodInfoSequence;
                MediaPeriodHolder mediaPeriodHolder4 = this.loadingPeriodHolder;
                nextMediaPeriodInfo = mediaPeriodInfoSequence.getNextMediaPeriodInfo(mediaPeriodHolder4.info, mediaPeriodHolder4.getRendererOffset(), this.rendererPositionUs);
            }
            if (nextMediaPeriodInfo == null) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
                return;
            }
            MediaPeriodHolder mediaPeriodHolder5 = this.loadingPeriodHolder;
            long rendererOffset = mediaPeriodHolder5 == null ? 60000000L : mediaPeriodHolder5.getRendererOffset() + this.loadingPeriodHolder.info.durationUs;
            MediaPeriodHolder mediaPeriodHolder6 = this.loadingPeriodHolder;
            MediaPeriodHolder mediaPeriodHolder7 = new MediaPeriodHolder(this.renderers, this.rendererCapabilities, rendererOffset, this.trackSelector, this.loadControl, this.mediaSource, this.playbackInfo.timeline.getPeriod(nextMediaPeriodInfo.id.periodIndex, this.period, true).uid, mediaPeriodHolder6 == null ? 0 : mediaPeriodHolder6.index + 1, nextMediaPeriodInfo);
            MediaPeriodHolder mediaPeriodHolder8 = this.loadingPeriodHolder;
            if (mediaPeriodHolder8 != null) {
                mediaPeriodHolder8.next = mediaPeriodHolder7;
            }
            this.loadingPeriodHolder = mediaPeriodHolder7;
            mediaPeriodHolder7.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
        }
    }

    private void notifySourceInfoRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            notifySourceInfoRefresh(0, 0);
        }
    }

    private void prepareInternal(MediaSource mediaSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65556, this, mediaSource, z) == null) {
            this.pendingPrepareCount++;
            resetInternal(true);
            this.loadControl.onPrepared();
            if (z) {
                this.playbackInfo = new PlaybackInfo(null, null, 0, C.TIME_UNSET);
            } else {
                PlaybackInfo playbackInfo = this.playbackInfo;
                this.playbackInfo = new PlaybackInfo(null, null, playbackInfo.periodId, playbackInfo.positionUs, this.playbackInfo.contentPositionUs);
            }
            this.mediaSource = mediaSource;
            mediaSource.prepareSource(this.player, true, this);
            setState(2);
            this.handler.sendEmptyMessage(2);
        }
    }

    private void releaseInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            resetInternal(true);
            this.loadControl.onReleased();
            setState(1);
            this.internalPlaybackThread.quit();
            synchronized (this) {
                this.released = true;
                notifyAll();
            }
        }
    }

    private void releasePeriodHoldersFrom(MediaPeriodHolder mediaPeriodHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, mediaPeriodHolder) == null) {
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.release();
                mediaPeriodHolder = mediaPeriodHolder.next;
            }
        }
    }

    private boolean rendererWaitingForNextStream(Renderer renderer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, this, renderer)) == null) {
            MediaPeriodHolder mediaPeriodHolder = this.readingPeriodHolder.next;
            return mediaPeriodHolder != null && mediaPeriodHolder.prepared && renderer.hasReadStreamToEnd();
        }
        return invokeL.booleanValue;
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65560, this) == null) || (mediaPeriodHolder = this.playingPeriodHolder) == null) {
            return;
        }
        boolean z = true;
        for (mediaPeriodHolder = this.playingPeriodHolder; mediaPeriodHolder != null && mediaPeriodHolder.prepared; mediaPeriodHolder = mediaPeriodHolder.next) {
            if (mediaPeriodHolder.selectTracks()) {
                if (z) {
                    boolean z2 = this.readingPeriodHolder != this.playingPeriodHolder;
                    releasePeriodHoldersFrom(this.playingPeriodHolder.next);
                    MediaPeriodHolder mediaPeriodHolder2 = this.playingPeriodHolder;
                    mediaPeriodHolder2.next = null;
                    this.loadingPeriodHolder = mediaPeriodHolder2;
                    this.readingPeriodHolder = mediaPeriodHolder2;
                    boolean[] zArr = new boolean[this.renderers.length];
                    long updatePeriodTrackSelection = mediaPeriodHolder2.updatePeriodTrackSelection(this.playbackInfo.positionUs, z2, zArr);
                    if (this.state != 4 && updatePeriodTrackSelection != this.playbackInfo.positionUs) {
                        PlaybackInfo playbackInfo = this.playbackInfo;
                        PlaybackInfo fromNewPosition = playbackInfo.fromNewPosition(playbackInfo.periodId, updatePeriodTrackSelection, playbackInfo.contentPositionUs);
                        this.playbackInfo = fromNewPosition;
                        this.eventHandler.obtainMessage(4, 3, 0, fromNewPosition).sendToTarget();
                        resetRendererPosition(updatePeriodTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        zArr2[i2] = renderer.getState() != 0;
                        SampleStream sampleStream = this.playingPeriodHolder.sampleStreams[i2];
                        if (sampleStream != null) {
                            i3++;
                        }
                        if (zArr2[i2]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i2]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i2++;
                    }
                    this.eventHandler.obtainMessage(2, mediaPeriodHolder.trackSelectorResult).sendToTarget();
                    enableRenderers(zArr2, i3);
                } else {
                    this.loadingPeriodHolder = mediaPeriodHolder;
                    for (MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder.next; mediaPeriodHolder3 != null; mediaPeriodHolder3 = mediaPeriodHolder3.next) {
                        mediaPeriodHolder3.release();
                    }
                    MediaPeriodHolder mediaPeriodHolder4 = this.loadingPeriodHolder;
                    mediaPeriodHolder4.next = null;
                    if (mediaPeriodHolder4.prepared) {
                        this.loadingPeriodHolder.updatePeriodTrackSelection(Math.max(mediaPeriodHolder4.info.startPositionUs, mediaPeriodHolder4.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                if (this.state != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (mediaPeriodHolder == this.readingPeriodHolder) {
                z = false;
            }
        }
    }

    private void resetInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            this.handler.removeMessages(2);
            this.rebuffering = false;
            this.standaloneMediaClock.stop();
            this.rendererPositionUs = 60000000L;
            for (Renderer renderer : this.enabledRenderers) {
                try {
                    disableRenderer(renderer);
                } catch (ExoPlaybackException | RuntimeException unused) {
                }
            }
            this.enabledRenderers = new Renderer[0];
            MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
            if (mediaPeriodHolder == null) {
                mediaPeriodHolder = this.loadingPeriodHolder;
            }
            releasePeriodHoldersFrom(mediaPeriodHolder);
            this.loadingPeriodHolder = null;
            this.readingPeriodHolder = null;
            this.playingPeriodHolder = null;
            setIsLoading(false);
            if (z) {
                MediaSource mediaSource = this.mediaSource;
                if (mediaSource != null) {
                    mediaSource.releaseSource();
                    this.mediaSource = null;
                }
                this.mediaPeriodInfoSequence.setTimeline(null);
                this.playbackInfo = this.playbackInfo.copyWithTimeline(null, null);
            }
        }
    }

    private void resetRendererPosition(long j2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65562, this, j2) == null) {
            MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
            long rendererTime = mediaPeriodHolder == null ? j2 + 60000000 : mediaPeriodHolder.toRendererTime(j2);
            this.rendererPositionUs = rendererTime;
            this.standaloneMediaClock.setPositionUs(rendererTime);
            for (Renderer renderer : this.enabledRenderers) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
    }

    private Pair<Integer, Long> resolveSeekPosition(SeekPosition seekPosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, seekPosition)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            Timeline timeline2 = seekPosition.timeline;
            if (timeline2.isEmpty()) {
                timeline2 = timeline;
            }
            try {
                Pair<Integer, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
                if (timeline == timeline2) {
                    return periodPosition;
                }
                int indexOfPeriod = timeline.getIndexOfPeriod(timeline2.getPeriod(((Integer) periodPosition.first).intValue(), this.period, true).uid);
                if (indexOfPeriod != -1) {
                    return Pair.create(Integer.valueOf(indexOfPeriod), periodPosition.second);
                }
                int resolveSubsequentPeriod = resolveSubsequentPeriod(((Integer) periodPosition.first).intValue(), timeline2, timeline);
                if (resolveSubsequentPeriod != -1) {
                    return getPeriodPosition(timeline, timeline.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, C.TIME_UNSET);
                }
                return null;
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalSeekPositionException(timeline, seekPosition.windowIndex, seekPosition.windowPositionUs);
            }
        }
        return (Pair) invokeL.objValue;
    }

    private int resolveSubsequentPeriod(int i2, Timeline timeline, Timeline timeline2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65564, this, i2, timeline, timeline2)) == null) {
            int periodCount = timeline.getPeriodCount();
            int i3 = i2;
            int i4 = -1;
            for (int i5 = 0; i5 < periodCount && i4 == -1; i5++) {
                i3 = timeline.getNextPeriodIndex(i3, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                if (i3 == -1) {
                    break;
                }
                i4 = timeline2.getIndexOfPeriod(timeline.getPeriod(i3, this.period, true).uid);
            }
            return i4;
        }
        return invokeILL.intValue;
    }

    private void scheduleNextWork(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.handler.removeMessages(2);
            long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.handler.sendEmptyMessage(2);
            } else {
                this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }

    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, seekPosition) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline == null) {
                this.pendingInitialSeekCount++;
                this.pendingSeekPosition = seekPosition;
                return;
            }
            Pair<Integer, Long> resolveSeekPosition = resolveSeekPosition(seekPosition);
            if (resolveSeekPosition == null) {
                int i3 = timeline.isEmpty() ? 0 : timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
                this.playbackInfo = this.playbackInfo.fromNewPosition(i3, C.TIME_UNSET, C.TIME_UNSET);
                setState(4);
                this.eventHandler.obtainMessage(3, 1, 0, this.playbackInfo.fromNewPosition(i3, 0L, C.TIME_UNSET)).sendToTarget();
                resetInternal(false);
                return;
            }
            int i4 = seekPosition.windowPositionUs == C.TIME_UNSET ? 1 : 0;
            int intValue = ((Integer) resolveSeekPosition.first).intValue();
            long longValue = ((Long) resolveSeekPosition.second).longValue();
            MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue, longValue);
            if (resolvePeriodPositionForAds.isAd()) {
                j2 = 0;
                i2 = 1;
            } else {
                i2 = i4;
                j2 = longValue;
            }
            try {
                if (resolvePeriodPositionForAds.equals(this.playbackInfo.periodId) && j2 / 1000 == this.playbackInfo.positionUs / 1000) {
                    return;
                }
                long seekToPeriodPosition = seekToPeriodPosition(resolvePeriodPositionForAds, j2);
                int i5 = i2 | (j2 != seekToPeriodPosition ? 1 : 0);
                PlaybackInfo fromNewPosition = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds, seekToPeriodPosition, longValue);
                this.playbackInfo = fromNewPosition;
                this.eventHandler.obtainMessage(3, i5, 0, fromNewPosition).sendToTarget();
            } finally {
                PlaybackInfo fromNewPosition2 = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds, j2, longValue);
                this.playbackInfo = fromNewPosition2;
                this.eventHandler.obtainMessage(3, i2, 0, fromNewPosition2).sendToTarget();
            }
        }
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j2) throws ExoPlaybackException {
        InterceptResult invokeLJ;
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65567, this, mediaPeriodId, j2)) == null) {
            stopRenderers();
            this.rebuffering = false;
            setState(2);
            MediaPeriodHolder mediaPeriodHolder2 = this.playingPeriodHolder;
            if (mediaPeriodHolder2 == null) {
                MediaPeriodHolder mediaPeriodHolder3 = this.loadingPeriodHolder;
                if (mediaPeriodHolder3 != null) {
                    mediaPeriodHolder3.release();
                }
                mediaPeriodHolder = null;
            } else {
                mediaPeriodHolder = null;
                while (mediaPeriodHolder2 != null) {
                    if (mediaPeriodHolder == null && shouldKeepPeriodHolder(mediaPeriodId, j2, mediaPeriodHolder2)) {
                        mediaPeriodHolder = mediaPeriodHolder2;
                    } else {
                        mediaPeriodHolder2.release();
                    }
                    mediaPeriodHolder2 = mediaPeriodHolder2.next;
                }
            }
            MediaPeriodHolder mediaPeriodHolder4 = this.playingPeriodHolder;
            if (mediaPeriodHolder4 != mediaPeriodHolder || mediaPeriodHolder4 != this.readingPeriodHolder) {
                for (Renderer renderer : this.enabledRenderers) {
                    disableRenderer(renderer);
                }
                this.enabledRenderers = new Renderer[0];
                this.playingPeriodHolder = null;
            }
            if (mediaPeriodHolder != null) {
                mediaPeriodHolder.next = null;
                this.loadingPeriodHolder = mediaPeriodHolder;
                this.readingPeriodHolder = mediaPeriodHolder;
                setPlayingPeriodHolder(mediaPeriodHolder);
                MediaPeriodHolder mediaPeriodHolder5 = this.playingPeriodHolder;
                if (mediaPeriodHolder5.hasEnabledTracks) {
                    j2 = mediaPeriodHolder5.mediaPeriod.seekToUs(j2);
                }
                resetRendererPosition(j2);
                maybeContinueLoading();
            } else {
                this.loadingPeriodHolder = null;
                this.readingPeriodHolder = null;
                this.playingPeriodHolder = null;
                resetRendererPosition(j2);
            }
            this.handler.sendEmptyMessage(2);
            return j2;
        }
        return invokeLJ.longValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private void sendMessagesInternal(ExoPlayer.ExoPlayerMessage[] exoPlayerMessageArr) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, exoPlayerMessageArr) == null) {
            try {
                for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
                    exoPlayerMessage.target.handleMessage(exoPlayerMessage.messageType, exoPlayerMessage.message);
                }
                if (this.state == 3 || this.state == 2) {
                    this.handler.sendEmptyMessage(2);
                }
                synchronized (this) {
                    this.customMessagesProcessed++;
                    notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this) {
                    this.customMessagesProcessed++;
                    notifyAll();
                    throw th;
                }
            }
        }
    }

    private void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65569, this, z) == null) || this.isLoading == z) {
            return;
        }
        this.isLoading = z;
        this.eventHandler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    private void setPlayWhenReadyInternal(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, this, z) == null) {
            this.rebuffering = false;
            this.playWhenReady = z;
            if (!z) {
                stopRenderers();
                updatePlaybackPositions();
                return;
            }
            int i2 = this.state;
            if (i2 == 3) {
                startRenderers();
                this.handler.sendEmptyMessage(2);
            } else if (i2 == 2) {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, playbackParameters) == null) {
            MediaClock mediaClock = this.rendererMediaClock;
            if (mediaClock != null) {
                playbackParameters = mediaClock.setPlaybackParameters(playbackParameters);
            }
            this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
            this.playbackParameters = playbackParameters;
            this.eventHandler.obtainMessage(6, playbackParameters).sendToTarget();
        }
    }

    private void setPlayingPeriodHolder(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65572, this, mediaPeriodHolder) == null) || this.playingPeriodHolder == mediaPeriodHolder) {
            return;
        }
        boolean[] zArr = new boolean[this.renderers.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i2 < rendererArr.length) {
                Renderer renderer = rendererArr[i2];
                zArr[i2] = renderer.getState() != 0;
                if (mediaPeriodHolder.trackSelectorResult.renderersEnabled[i2]) {
                    i3++;
                }
                if (zArr[i2] && (!mediaPeriodHolder.trackSelectorResult.renderersEnabled[i2] || (renderer.isCurrentStreamFinal() && renderer.getStream() == this.playingPeriodHolder.sampleStreams[i2]))) {
                    disableRenderer(renderer);
                }
                i2++;
            } else {
                this.playingPeriodHolder = mediaPeriodHolder;
                this.eventHandler.obtainMessage(2, mediaPeriodHolder.trackSelectorResult).sendToTarget();
                enableRenderers(zArr, i3);
                return;
            }
        }
    }

    private void setRepeatModeInternal(int i2) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65573, this, i2) == null) {
            this.repeatMode = i2;
            this.mediaPeriodInfoSequence.setRepeatMode(i2);
            validateExistingPeriodHolders();
        }
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65574, this, z) == null) {
            this.shuffleModeEnabled = z;
            this.mediaPeriodInfoSequence.setShuffleModeEnabled(z);
            validateExistingPeriodHolders();
        }
    }

    private void setState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65575, this, i2) == null) || this.state == i2) {
            return;
        }
        this.state = i2;
        this.eventHandler.obtainMessage(0, i2, 0).sendToTarget();
    }

    private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId mediaPeriodId, long j2, MediaPeriodHolder mediaPeriodHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, this, new Object[]{mediaPeriodId, Long.valueOf(j2), mediaPeriodHolder})) == null) {
            if (mediaPeriodId.equals(mediaPeriodHolder.info.id) && mediaPeriodHolder.prepared) {
                this.playbackInfo.timeline.getPeriod(mediaPeriodHolder.info.id.periodIndex, this.period);
                int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j2);
                return adGroupIndexAfterPositionUs == -1 || this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == mediaPeriodHolder.info.endPositionUs;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private void startRenderers() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            this.rebuffering = false;
            this.standaloneMediaClock.start();
            for (Renderer renderer : this.enabledRenderers) {
                renderer.start();
            }
        }
    }

    private void stopInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            resetInternal(true);
            this.loadControl.onStopped();
            setState(1);
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.standaloneMediaClock.stop();
            for (Renderer renderer : this.enabledRenderers) {
                ensureStopped(renderer);
            }
        }
    }

    private MediaPeriodHolder updatePeriodInfo(MediaPeriodHolder mediaPeriodHolder, int i2) {
        MediaPeriodHolder mediaPeriodHolder2;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65580, this, mediaPeriodHolder, i2)) == null) {
            while (true) {
                MediaPeriodInfoSequence.MediaPeriodInfo updatedMediaPeriodInfo = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder.info, i2);
                mediaPeriodHolder.info = updatedMediaPeriodInfo;
                if (updatedMediaPeriodInfo.isLastInTimelinePeriod || (mediaPeriodHolder2 = mediaPeriodHolder.next) == null) {
                    break;
                }
                mediaPeriodHolder = mediaPeriodHolder2;
            }
            return mediaPeriodHolder;
        }
        return (MediaPeriodHolder) invokeLI.objValue;
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65581, this) != null) {
            return;
        }
        if (this.playbackInfo.timeline == null) {
            this.mediaSource.maybeThrowSourceInfoRefreshError();
            return;
        }
        maybeUpdateLoadingPeriod();
        MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder;
        int i2 = 0;
        if (mediaPeriodHolder2 != null && !mediaPeriodHolder2.isFullyBuffered()) {
            if (this.loadingPeriodHolder != null && !this.isLoading) {
                maybeContinueLoading();
            }
        } else {
            setIsLoading(false);
        }
        if (this.playingPeriodHolder == null) {
            return;
        }
        while (this.playWhenReady && (mediaPeriodHolder = this.playingPeriodHolder) != this.readingPeriodHolder && this.rendererPositionUs >= mediaPeriodHolder.next.rendererPositionOffsetUs) {
            mediaPeriodHolder.release();
            setPlayingPeriodHolder(this.playingPeriodHolder.next);
            PlaybackInfo playbackInfo = this.playbackInfo;
            MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo = this.playingPeriodHolder.info;
            this.playbackInfo = playbackInfo.fromNewPosition(mediaPeriodInfo.id, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.contentPositionUs);
            updatePlaybackPositions();
            this.eventHandler.obtainMessage(4, 0, 0, this.playbackInfo).sendToTarget();
        }
        MediaPeriodHolder mediaPeriodHolder3 = this.readingPeriodHolder;
        if (mediaPeriodHolder3.info.isFinal) {
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i2 >= rendererArr.length) {
                    return;
                }
                Renderer renderer = rendererArr[i2];
                SampleStream sampleStream = this.readingPeriodHolder.sampleStreams[i2];
                if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                    renderer.setCurrentStreamFinal();
                }
                i2++;
            }
        } else {
            MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodHolder3.next;
            if (mediaPeriodHolder4 == null || !mediaPeriodHolder4.prepared) {
                return;
            }
            int i3 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.renderers;
                if (i3 < rendererArr2.length) {
                    Renderer renderer2 = rendererArr2[i3];
                    SampleStream sampleStream2 = this.readingPeriodHolder.sampleStreams[i3];
                    if (renderer2.getStream() != sampleStream2) {
                        return;
                    }
                    if (sampleStream2 != null && !renderer2.hasReadStreamToEnd()) {
                        return;
                    }
                    i3++;
                } else {
                    MediaPeriodHolder mediaPeriodHolder5 = this.readingPeriodHolder;
                    TrackSelectorResult trackSelectorResult = mediaPeriodHolder5.trackSelectorResult;
                    MediaPeriodHolder mediaPeriodHolder6 = mediaPeriodHolder5.next;
                    this.readingPeriodHolder = mediaPeriodHolder6;
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder6.trackSelectorResult;
                    boolean z = mediaPeriodHolder6.mediaPeriod.readDiscontinuity() != C.TIME_UNSET;
                    int i4 = 0;
                    while (true) {
                        Renderer[] rendererArr3 = this.renderers;
                        if (i4 >= rendererArr3.length) {
                            return;
                        }
                        Renderer renderer3 = rendererArr3[i4];
                        if (trackSelectorResult.renderersEnabled[i4]) {
                            if (z) {
                                renderer3.setCurrentStreamFinal();
                            } else if (!renderer3.isCurrentStreamFinal()) {
                                TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
                                boolean z2 = trackSelectorResult2.renderersEnabled[i4];
                                boolean z3 = this.rendererCapabilities[i4].getTrackType() == 5;
                                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i4];
                                RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i4];
                                if (z2 && rendererConfiguration2.equals(rendererConfiguration) && !z3) {
                                    Format[] formats = getFormats(trackSelection);
                                    MediaPeriodHolder mediaPeriodHolder7 = this.readingPeriodHolder;
                                    renderer3.replaceStream(formats, mediaPeriodHolder7.sampleStreams[i4], mediaPeriodHolder7.getRendererOffset());
                                } else {
                                    renderer3.setCurrentStreamFinal();
                                }
                            }
                        }
                        i4++;
                    }
                }
            }
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65582, this) == null) || (mediaPeriodHolder = this.playingPeriodHolder) == null) {
            return;
        }
        long readDiscontinuity = mediaPeriodHolder.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity != C.TIME_UNSET) {
            resetRendererPosition(readDiscontinuity);
            PlaybackInfo playbackInfo = this.playbackInfo;
            PlaybackInfo fromNewPosition = playbackInfo.fromNewPosition(playbackInfo.periodId, readDiscontinuity, playbackInfo.contentPositionUs);
            this.playbackInfo = fromNewPosition;
            this.eventHandler.obtainMessage(4, 3, 0, fromNewPosition).sendToTarget();
        } else {
            Renderer renderer = this.rendererMediaClockSource;
            if (renderer != null && !renderer.isEnded() && (this.rendererMediaClockSource.isReady() || !rendererWaitingForNextStream(this.rendererMediaClockSource))) {
                long positionUs = this.rendererMediaClock.getPositionUs();
                this.rendererPositionUs = positionUs;
                this.standaloneMediaClock.setPositionUs(positionUs);
            } else {
                this.rendererPositionUs = this.standaloneMediaClock.getPositionUs();
            }
            readDiscontinuity = this.playingPeriodHolder.toPeriodTime(this.rendererPositionUs);
        }
        this.playbackInfo.positionUs = readDiscontinuity;
        this.elapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        long bufferedPositionUs = this.enabledRenderers.length == 0 ? Long.MIN_VALUE : this.playingPeriodHolder.mediaPeriod.getBufferedPositionUs();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (bufferedPositionUs == Long.MIN_VALUE) {
            bufferedPositionUs = this.playingPeriodHolder.info.durationUs;
        }
        playbackInfo2.bufferedPositionUs = bufferedPositionUs;
    }

    private void validateExistingPeriodHolders() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            MediaPeriodHolder mediaPeriodHolder3 = this.playingPeriodHolder;
            if (mediaPeriodHolder3 == null) {
                mediaPeriodHolder3 = this.loadingPeriodHolder;
            }
            if (mediaPeriodHolder3 == null) {
                return;
            }
            while (true) {
                int nextPeriodIndex = this.playbackInfo.timeline.getNextPeriodIndex(mediaPeriodHolder3.info.id.periodIndex, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                while (true) {
                    MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodHolder3.next;
                    if (mediaPeriodHolder4 == null || mediaPeriodHolder3.info.isLastInTimelinePeriod) {
                        break;
                    }
                    mediaPeriodHolder3 = mediaPeriodHolder4;
                }
                if (nextPeriodIndex == -1 || (mediaPeriodHolder2 = mediaPeriodHolder3.next) == null || mediaPeriodHolder2.info.id.periodIndex != nextPeriodIndex) {
                    break;
                }
                mediaPeriodHolder3 = mediaPeriodHolder2;
            }
            int i2 = this.loadingPeriodHolder.index;
            MediaPeriodHolder mediaPeriodHolder5 = this.readingPeriodHolder;
            int i3 = mediaPeriodHolder5 != null ? mediaPeriodHolder5.index : -1;
            MediaPeriodHolder mediaPeriodHolder6 = mediaPeriodHolder3.next;
            if (mediaPeriodHolder6 != null) {
                releasePeriodHoldersFrom(mediaPeriodHolder6);
                mediaPeriodHolder3.next = null;
            }
            mediaPeriodHolder3.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder3.info);
            boolean z = true;
            if (!(i2 <= mediaPeriodHolder3.index)) {
                this.loadingPeriodHolder = mediaPeriodHolder3;
            }
            if (((i3 == -1 || i3 > mediaPeriodHolder3.index) ? false : false) || (mediaPeriodHolder = this.playingPeriodHolder) == null) {
                return;
            }
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodHolder.info.id;
            long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs);
            if (seekToPeriodPosition != this.playbackInfo.positionUs) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                PlaybackInfo fromNewPosition = playbackInfo.fromNewPosition(mediaPeriodId, seekToPeriodPosition, playbackInfo.contentPositionUs);
                this.playbackInfo = fromNewPosition;
                this.eventHandler.obtainMessage(4, 3, 0, fromNewPosition).sendToTarget();
            }
        }
    }

    public synchronized void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exoPlayerMessageArr) == null) {
            synchronized (this) {
                if (this.released) {
                    return;
                }
                int i2 = this.customMessagesSent;
                this.customMessagesSent = i2 + 1;
                this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
                boolean z = false;
                while (this.customMessagesProcessed <= i2) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public Looper getPlaybackLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.internalPlaybackThread.getLooper() : (Looper) invokeV.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
            try {
                switch (message.what) {
                    case 0:
                        prepareInternal((MediaSource) message.obj, message.arg1 != 0);
                        return true;
                    case 1:
                        setPlayWhenReadyInternal(message.arg1 != 0);
                        return true;
                    case 2:
                        doSomeWork();
                        return true;
                    case 3:
                        seekToInternal((SeekPosition) message.obj);
                        return true;
                    case 4:
                        setPlaybackParametersInternal((PlaybackParameters) message.obj);
                        return true;
                    case 5:
                        stopInternal();
                        return true;
                    case 6:
                        releaseInternal();
                        return true;
                    case 7:
                        handleSourceInfoRefreshed((MediaSourceRefreshInfo) message.obj);
                        return true;
                    case 8:
                        handlePeriodPrepared((MediaPeriod) message.obj);
                        return true;
                    case 9:
                        handleContinueLoadingRequested((MediaPeriod) message.obj);
                        return true;
                    case 10:
                        reselectTracksInternal();
                        return true;
                    case 11:
                        sendMessagesInternal((ExoPlayer.ExoPlayerMessage[]) message.obj);
                        return true;
                    case 12:
                        setRepeatModeInternal(message.arg1);
                        return true;
                    case 13:
                        setShuffleModeEnabledInternal(message.arg1 != 0);
                        return true;
                    default:
                        return false;
                }
            } catch (ExoPlaybackException e2) {
                this.eventHandler.obtainMessage(7, e2).sendToTarget();
                stopInternal();
                return true;
            } catch (IOException e3) {
                this.eventHandler.obtainMessage(7, ExoPlaybackException.createForSource(e3)).sendToTarget();
                stopInternal();
                return true;
            } catch (RuntimeException e4) {
                this.eventHandler.obtainMessage(7, ExoPlaybackException.createForUnexpected(e4)).sendToTarget();
                stopInternal();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mediaPeriod) == null) {
            this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, mediaSource, timeline, obj) == null) {
            this.handler.obtainMessage(7, new MediaSourceRefreshInfo(mediaSource, timeline, obj)).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.handler.sendEmptyMessage(10);
        }
    }

    public void prepare(MediaSource mediaSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSource, z) == null) {
            this.handler.obtainMessage(0, z ? 1 : 0, 0, mediaSource).sendToTarget();
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                if (this.released) {
                    return;
                }
                this.handler.sendEmptyMessage(6);
                boolean z = false;
                while (!this.released) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void seekTo(Timeline timeline, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{timeline, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.handler.obtainMessage(3, new SeekPosition(timeline, i2, j2)).sendToTarget();
        }
    }

    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, exoPlayerMessageArr) == null) || this.released) {
            return;
        }
        this.customMessagesSent++;
        this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
    }

    public void setPlayWhenReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, playbackParameters) == null) {
            this.handler.obtainMessage(4, playbackParameters).sendToTarget();
        }
    }

    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.handler.obtainMessage(12, i2, 0).sendToTarget();
        }
    }

    public void setShuffleModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.handler.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.handler.sendEmptyMessage(5);
        }
    }

    private void handleSourceInfoRefreshEndedPlayback(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, this, i2, i3) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            int i4 = timeline.isEmpty() ? 0 : timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
            this.playbackInfo = this.playbackInfo.fromNewPosition(i4, C.TIME_UNSET, C.TIME_UNSET);
            setState(4);
            notifySourceInfoRefresh(i2, i3, this.playbackInfo.fromNewPosition(i4, 0L, C.TIME_UNSET));
            resetInternal(false);
        }
    }

    private void notifySourceInfoRefresh(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65554, this, i2, i3) == null) {
            notifySourceInfoRefresh(i2, i3, this.playbackInfo);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaPeriod) == null) {
            this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
        }
    }

    private void notifySourceInfoRefresh(int i2, int i3, PlaybackInfo playbackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65555, this, i2, i3, playbackInfo) == null) {
            this.eventHandler.obtainMessage(5, i2, i3, playbackInfo).sendToTarget();
        }
    }
}
