package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
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
    public final class MediaPeriodHolder {
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

        public MediaPeriodHolder(Renderer[] rendererArr, RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, LoadControl loadControl, MediaSource mediaSource, Object obj, int i, MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rendererArr, rendererCapabilitiesArr, Long.valueOf(j), trackSelector, loadControl, mediaSource, obj, Integer.valueOf(i), mediaPeriodInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.renderers = rendererArr;
            this.rendererCapabilities = rendererCapabilitiesArr;
            this.rendererPositionOffsetUs = j;
            this.trackSelector = trackSelector;
            this.loadControl = loadControl;
            this.mediaSource = mediaSource;
            this.uid = Assertions.checkNotNull(obj);
            this.index = i;
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
            if (interceptable == null || interceptable.invokeL(65537, this, sampleStreamArr) == null) {
                int i = 0;
                while (true) {
                    RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
                    if (i < rendererCapabilitiesArr.length) {
                        if (rendererCapabilitiesArr[i].getTrackType() == 5 && this.trackSelectorResult.renderersEnabled[i]) {
                            sampleStreamArr[i] = new EmptySampleStream();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }

        private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, sampleStreamArr) == null) {
                int i = 0;
                while (true) {
                    RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
                    if (i < rendererCapabilitiesArr.length) {
                        if (rendererCapabilitiesArr[i].getTrackType() == 5) {
                            sampleStreamArr[i] = null;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }

        public void continueLoading(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.mediaPeriod.continueLoading(toPeriodTime(j));
            }
        }

        public boolean shouldContinueLoading(long j) {
            InterceptResult invokeJ;
            long nextLoadPositionUs;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
                if (!this.prepared) {
                    nextLoadPositionUs = 0;
                } else {
                    nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
                }
                if (nextLoadPositionUs == Long.MIN_VALUE) {
                    return false;
                }
                return this.loadControl.shouldContinueLoading(nextLoadPositionUs - toPeriodTime(j));
            }
            return invokeJ.booleanValue;
        }

        public long toPeriodTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                return j - getRendererOffset();
            }
            return invokeJ.longValue;
        }

        public long toRendererTime(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
                return j + getRendererOffset();
            }
            return invokeJ.longValue;
        }

        public long getRendererOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.index == 0) {
                    return this.rendererPositionOffsetUs;
                }
                return this.rendererPositionOffsetUs - this.info.startPositionUs;
            }
            return invokeV.longValue;
        }

        public void handlePrepared() throws ExoPlaybackException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.prepared = true;
                selectTracks();
                this.info = this.info.copyWithStartPositionUs(updatePeriodTrackSelection(this.info.startPositionUs, false));
            }
        }

        public boolean isFullyBuffered() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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

        public boolean haveSufficientBuffer(boolean z, long j) {
            InterceptResult invokeCommon;
            long bufferedPositionUs;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)})) == null) {
                if (!this.prepared) {
                    bufferedPositionUs = this.info.startPositionUs;
                } else {
                    bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
                }
                if (bufferedPositionUs == Long.MIN_VALUE) {
                    MediaPeriodInfoSequence.MediaPeriodInfo mediaPeriodInfo = this.info;
                    if (mediaPeriodInfo.isFinal) {
                        return true;
                    }
                    bufferedPositionUs = mediaPeriodInfo.durationUs;
                }
                return this.loadControl.shouldStartPlayback(bufferedPositionUs - toPeriodTime(j), z);
            }
            return invokeCommon.booleanValue;
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
                } catch (RuntimeException e) {
                    Log.e(ExoPlayerImplInternal.TAG, "Period release failed.", e);
                }
            }
        }

        public long updatePeriodTrackSelection(long j, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
                return updatePeriodTrackSelection(j, z, new boolean[this.renderers.length]);
            }
            return invokeCommon.longValue;
        }

        public long updatePeriodTrackSelection(long j, boolean z, boolean[] zArr) {
            InterceptResult invokeCommon;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), zArr})) == null) {
                TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
                int i = 0;
                while (true) {
                    boolean z3 = true;
                    if (i >= trackSelectionArray.length) {
                        break;
                    }
                    boolean[] zArr2 = this.mayRetainStreamFlags;
                    if (z || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i)) {
                        z3 = false;
                    }
                    zArr2[i] = z3;
                    i++;
                }
                disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
                long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
                associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
                this.periodTrackSelectorResult = this.trackSelectorResult;
                this.hasEnabledTracks = false;
                int i2 = 0;
                while (true) {
                    SampleStream[] sampleStreamArr = this.sampleStreams;
                    if (i2 < sampleStreamArr.length) {
                        if (sampleStreamArr[i2] != null) {
                            Assertions.checkState(this.trackSelectorResult.renderersEnabled[i2]);
                            if (this.rendererCapabilities[i2].getTrackType() != 5) {
                                this.hasEnabledTracks = true;
                            }
                        } else {
                            if (trackSelectionArray.get(i2) == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            Assertions.checkState(z2);
                        }
                        i2++;
                    } else {
                        this.loadControl.onTracksSelected(this.renderers, this.trackSelectorResult.groups, trackSelectionArray);
                        return selectTracks;
                    }
                }
            } else {
                return invokeCommon.longValue;
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class MediaSourceRefreshInfo {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
    public final class SeekPosition {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeline, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.timeline = timeline;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, boolean z, int i, boolean z2, Handler handler, ExoPlayer exoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rendererArr, trackSelector, loadControl, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), handler, exoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.renderers = rendererArr;
        this.trackSelector = trackSelector;
        this.loadControl = loadControl;
        this.playWhenReady = z;
        this.repeatMode = i;
        this.shuffleModeEnabled = z2;
        this.eventHandler = handler;
        this.state = 1;
        this.player = exoPlayer;
        this.playbackInfo = new PlaybackInfo(null, null, 0, C.TIME_UNSET);
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i4 = 0; i4 < rendererArr.length; i4++) {
            rendererArr[i4].setIndex(i4);
            this.rendererCapabilities[i4] = rendererArr[i4].getCapabilities();
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

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, renderer) == null) && renderer.getState() == 2) {
            renderer.stop();
        }
    }

    public static Format[] getFormats(TrackSelection trackSelection) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, trackSelection)) == null) {
            if (trackSelection != null) {
                i = trackSelection.length();
            } else {
                i = 0;
            }
            Format[] formatArr = new Format[i];
            for (int i2 = 0; i2 < i; i2++) {
                formatArr[i2] = trackSelection.getFormat(i2);
            }
            return formatArr;
        }
        return (Format[]) invokeL.objValue;
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, mediaPeriod) == null) && (mediaPeriodHolder = this.loadingPeriodHolder) != null && mediaPeriodHolder.mediaPeriod == mediaPeriod) {
            maybeContinueLoading();
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
            if (mediaPeriodHolder != null && mediaPeriodHolder.prepared && renderer.hasReadStreamToEnd()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void setIsLoading(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65569, this, z) == null) && this.isLoading != z) {
            this.isLoading = z;
            this.eventHandler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
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

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65573, this, i) == null) {
            this.repeatMode = i;
            this.mediaPeriodInfoSequence.setRepeatMode(i);
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

    private void setState(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65575, this, i) == null) && this.state != i) {
            this.state = i;
            this.eventHandler.obtainMessage(0, i, 0).sendToTarget();
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

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mediaPeriod) == null) {
            this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
        }
    }

    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, exoPlayerMessageArr) == null) {
            if (this.released) {
                Log.w(TAG, "Ignoring messages sent after release.");
                return;
            }
            this.customMessagesSent++;
            this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
        }
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

    public void setRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.handler.obtainMessage(12, i, 0).sendToTarget();
        }
    }

    public void setShuffleModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.handler.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        Renderer[] rendererArr;
        boolean isTimelineReady;
        int i;
        boolean z;
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
            boolean z2 = true;
            boolean z3 = true;
            for (Renderer renderer : this.enabledRenderers) {
                renderer.render(this.rendererPositionUs, this.elapsedRealtimeUs);
                if (z3 && renderer.isEnded()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!renderer.isReady() && !renderer.isEnded() && !rendererWaitingForNextStream(renderer)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    renderer.maybeThrowStreamError();
                }
                if (z2 && z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
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
            long j = this.playingPeriodHolder.info.durationUs;
            if (z3 && ((j == C.TIME_UNSET || j <= this.playbackInfo.positionUs) && this.playingPeriodHolder.info.isFinal)) {
                setState(4);
                stopRenderers();
            } else {
                int i2 = this.state;
                if (i2 == 2) {
                    if (this.enabledRenderers.length > 0) {
                        if (z2 && this.loadingPeriodHolder.haveSufficientBuffer(this.rebuffering, this.rendererPositionUs)) {
                            isTimelineReady = true;
                        } else {
                            isTimelineReady = false;
                        }
                    } else {
                        isTimelineReady = isTimelineReady(j);
                    }
                    if (isTimelineReady) {
                        setState(3);
                        if (this.playWhenReady) {
                            startRenderers();
                        }
                    }
                } else if (i2 == 3) {
                    if (this.enabledRenderers.length <= 0) {
                        z2 = isTimelineReady(j);
                    }
                    if (!z2) {
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
            if ((this.playWhenReady && this.state == 3) || (i = this.state) == 2) {
                scheduleNextWork(elapsedRealtime, 10L);
            } else if (this.enabledRenderers.length != 0 && i != 4) {
                scheduleNextWork(elapsedRealtime, 1000L);
            } else {
                this.handler.removeMessages(2);
            }
            TraceUtil.endSection();
        }
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        boolean z;
        boolean z2;
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            if (this.playbackInfo.timeline == null) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
                return;
            }
            maybeUpdateLoadingPeriod();
            MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder;
            int i = 0;
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
                    if (i < rendererArr.length) {
                        Renderer renderer = rendererArr[i];
                        SampleStream sampleStream = this.readingPeriodHolder.sampleStreams[i];
                        if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                            renderer.setCurrentStreamFinal();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodHolder3.next;
                if (mediaPeriodHolder4 != null && mediaPeriodHolder4.prepared) {
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr2 = this.renderers;
                        if (i2 < rendererArr2.length) {
                            Renderer renderer2 = rendererArr2[i2];
                            SampleStream sampleStream2 = this.readingPeriodHolder.sampleStreams[i2];
                            if (renderer2.getStream() == sampleStream2) {
                                if (sampleStream2 == null || renderer2.hasReadStreamToEnd()) {
                                    i2++;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            MediaPeriodHolder mediaPeriodHolder5 = this.readingPeriodHolder;
                            TrackSelectorResult trackSelectorResult = mediaPeriodHolder5.trackSelectorResult;
                            MediaPeriodHolder mediaPeriodHolder6 = mediaPeriodHolder5.next;
                            this.readingPeriodHolder = mediaPeriodHolder6;
                            TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder6.trackSelectorResult;
                            if (mediaPeriodHolder6.mediaPeriod.readDiscontinuity() != C.TIME_UNSET) {
                                z = true;
                            } else {
                                z = false;
                            }
                            int i3 = 0;
                            while (true) {
                                Renderer[] rendererArr3 = this.renderers;
                                if (i3 < rendererArr3.length) {
                                    Renderer renderer3 = rendererArr3[i3];
                                    if (trackSelectorResult.renderersEnabled[i3]) {
                                        if (z) {
                                            renderer3.setCurrentStreamFinal();
                                        } else if (!renderer3.isCurrentStreamFinal()) {
                                            TrackSelection trackSelection = trackSelectorResult2.selections.get(i3);
                                            boolean z3 = trackSelectorResult2.renderersEnabled[i3];
                                            if (this.rendererCapabilities[i3].getTrackType() == 5) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i3];
                                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i3];
                                            if (z3 && rendererConfiguration2.equals(rendererConfiguration) && !z2) {
                                                Format[] formats = getFormats(trackSelection);
                                                MediaPeriodHolder mediaPeriodHolder7 = this.readingPeriodHolder;
                                                renderer3.replaceStream(formats, mediaPeriodHolder7.sampleStreams[i3], mediaPeriodHolder7.getRendererOffset());
                                            } else {
                                                renderer3.setCurrentStreamFinal();
                                            }
                                        }
                                    }
                                    i3++;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void enableRenderer(int i, boolean z, int i2) throws ExoPlaybackException {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            Renderer renderer = this.renderers[i];
            this.enabledRenderers[i2] = renderer;
            if (renderer.getState() == 0) {
                TrackSelectorResult trackSelectorResult = this.playingPeriodHolder.trackSelectorResult;
                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
                Format[] formats = getFormats(trackSelectorResult.selections.get(i));
                if (this.playWhenReady && this.state == 3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z && z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
                renderer.enable(rendererConfiguration, formats, mediaPeriodHolder.sampleStreams[i], this.rendererPositionUs, z3, mediaPeriodHolder.getRendererOffset());
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

    private void enableRenderers(boolean[] zArr, int i) throws ExoPlaybackException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, zArr, i) == null) {
            this.enabledRenderers = new Renderer[i];
            int i2 = 0;
            for (int i3 = 0; i3 < this.renderers.length; i3++) {
                if (this.playingPeriodHolder.trackSelectorResult.renderersEnabled[i3]) {
                    enableRenderer(i3, zArr[i3], i2);
                    i2++;
                }
            }
        }
    }

    private void notifySourceInfoRefresh(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65554, this, i, i2) == null) {
            notifySourceInfoRefresh(i, i2, this.playbackInfo);
        }
    }

    private MediaPeriodHolder updatePeriodInfo(MediaPeriodHolder mediaPeriodHolder, int i) {
        MediaPeriodHolder mediaPeriodHolder2;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65580, this, mediaPeriodHolder, i)) == null) {
            while (true) {
                MediaPeriodInfoSequence.MediaPeriodInfo updatedMediaPeriodInfo = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder.info, i);
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

    public void prepare(MediaSource mediaSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSource, z) == null) {
            this.handler.obtainMessage(0, z ? 1 : 0, 0, mediaSource).sendToTarget();
        }
    }

    private Pair getPeriodPosition(Timeline timeline, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{timeline, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return timeline.getPeriodPosition(this.window, this.period, i, j);
        }
        return (Pair) invokeCommon.objValue;
    }

    private int resolveSubsequentPeriod(int i, Timeline timeline, Timeline timeline2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65564, this, i, timeline, timeline2)) == null) {
            int periodCount = timeline.getPeriodCount();
            int i2 = i;
            int i3 = -1;
            for (int i4 = 0; i4 < periodCount && i3 == -1; i4++) {
                i2 = timeline.getNextPeriodIndex(i2, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
                if (i2 == -1) {
                    break;
                }
                i3 = timeline2.getIndexOfPeriod(timeline.getPeriod(i2, this.period, true).uid);
            }
            return i3;
        }
        return invokeILL.intValue;
    }

    public void seekTo(Timeline timeline, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{timeline, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
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

    private boolean isTimelineReady(long j) {
        InterceptResult invokeJ;
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65549, this, j)) == null) {
            if (j != C.TIME_UNSET && this.playbackInfo.positionUs >= j && ((mediaPeriodHolder = this.playingPeriodHolder.next) == null || (!mediaPeriodHolder.prepared && !mediaPeriodHolder.info.id.isAd()))) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        long rendererTime;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65562, this, j) == null) {
            MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
            if (mediaPeriodHolder == null) {
                rendererTime = j + 60000000;
            } else {
                rendererTime = mediaPeriodHolder.toRendererTime(j);
            }
            this.rendererPositionUs = rendererTime;
            this.standaloneMediaClock.setPositionUs(rendererTime);
            for (Renderer renderer : this.enabledRenderers) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
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
            int i = this.state;
            if (i == 3) {
                startRenderers();
                this.handler.sendEmptyMessage(2);
            } else if (i == 2) {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    public synchronized void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, exoPlayerMessageArr) == null) {
            synchronized (this) {
                if (this.released) {
                    Log.w(TAG, "Ignoring messages sent after release.");
                    return;
                }
                int i = this.customMessagesSent;
                this.customMessagesSent = i + 1;
                this.handler.obtainMessage(11, exoPlayerMessageArr).sendToTarget();
                boolean z = false;
                while (this.customMessagesProcessed <= i) {
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

    private void handleSourceInfoRefreshEndedPlayback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            handleSourceInfoRefreshEndedPlayback(0, 0);
        }
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

    private void notifySourceInfoRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            notifySourceInfoRefresh(0, 0);
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

    public Looper getPlaybackLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.internalPlaybackThread.getLooper();
        }
        return (Looper) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener
    public void onTrackSelectionsInvalidated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.handler.sendEmptyMessage(10);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.handler.sendEmptyMessage(5);
        }
    }

    private void handleSourceInfoRefreshEndedPlayback(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65547, this, i, i2) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline.isEmpty()) {
                i3 = 0;
            } else {
                i3 = timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
            }
            int i4 = i3;
            this.playbackInfo = this.playbackInfo.fromNewPosition(i4, C.TIME_UNSET, C.TIME_UNSET);
            setState(4);
            notifySourceInfoRefresh(i, i2, this.playbackInfo.fromNewPosition(i4, 0L, C.TIME_UNSET));
            resetInternal(false);
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
        Object obj;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, this, mediaSourceRefreshInfo) != null) || mediaSourceRefreshInfo.source != this.mediaSource) {
            return;
        }
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = mediaSourceRefreshInfo.timeline;
        Object obj2 = mediaSourceRefreshInfo.manifest;
        this.mediaPeriodInfoSequence.setTimeline(timeline2);
        PlaybackInfo copyWithTimeline = this.playbackInfo.copyWithTimeline(timeline2, obj2);
        this.playbackInfo = copyWithTimeline;
        long j3 = C.TIME_UNSET;
        boolean z = false;
        if (timeline == null) {
            int i = this.pendingPrepareCount;
            this.pendingPrepareCount = 0;
            if (this.pendingInitialSeekCount > 0) {
                Pair resolveSeekPosition = resolveSeekPosition(this.pendingSeekPosition);
                int i2 = this.pendingInitialSeekCount;
                this.pendingInitialSeekCount = 0;
                this.pendingSeekPosition = null;
                if (resolveSeekPosition == null) {
                    handleSourceInfoRefreshEndedPlayback(i, i2);
                    return;
                }
                int intValue = ((Integer) resolveSeekPosition.first).intValue();
                long longValue = ((Long) resolveSeekPosition.second).longValue();
                MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue, longValue);
                PlaybackInfo playbackInfo = this.playbackInfo;
                if (resolvePeriodPositionForAds.isAd()) {
                    j2 = 0;
                } else {
                    j2 = longValue;
                }
                this.playbackInfo = playbackInfo.fromNewPosition(resolvePeriodPositionForAds, j2, longValue);
                notifySourceInfoRefresh(i, i2);
                return;
            } else if (copyWithTimeline.startPositionUs == C.TIME_UNSET) {
                if (timeline2.isEmpty()) {
                    handleSourceInfoRefreshEndedPlayback(i, 0);
                    return;
                }
                Pair periodPosition = getPeriodPosition(timeline2, timeline2.getFirstWindowIndex(this.shuffleModeEnabled), C.TIME_UNSET);
                int intValue2 = ((Integer) periodPosition.first).intValue();
                long longValue2 = ((Long) periodPosition.second).longValue();
                MediaSource.MediaPeriodId resolvePeriodPositionForAds2 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue2, longValue2);
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                if (resolvePeriodPositionForAds2.isAd()) {
                    j = 0;
                } else {
                    j = longValue2;
                }
                this.playbackInfo = playbackInfo2.fromNewPosition(resolvePeriodPositionForAds2, j, longValue2);
                notifySourceInfoRefresh(i, 0);
                return;
            } else {
                notifySourceInfoRefresh(i, 0);
                return;
            }
        }
        int i3 = copyWithTimeline.periodId.periodIndex;
        MediaPeriodHolder mediaPeriodHolder = this.playingPeriodHolder;
        if (mediaPeriodHolder == null) {
            mediaPeriodHolder = this.loadingPeriodHolder;
        }
        if (mediaPeriodHolder == null && i3 >= timeline.getPeriodCount()) {
            notifySourceInfoRefresh();
            return;
        }
        if (mediaPeriodHolder == null) {
            obj = timeline.getPeriod(i3, this.period, true).uid;
        } else {
            obj = mediaPeriodHolder.uid;
        }
        int indexOfPeriod = timeline2.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            int resolveSubsequentPeriod = resolveSubsequentPeriod(i3, timeline, timeline2);
            if (resolveSubsequentPeriod == -1) {
                handleSourceInfoRefreshEndedPlayback();
                return;
            }
            Pair periodPosition2 = getPeriodPosition(timeline2, timeline2.getPeriod(resolveSubsequentPeriod, this.period).windowIndex, C.TIME_UNSET);
            int intValue3 = ((Integer) periodPosition2.first).intValue();
            long longValue3 = ((Long) periodPosition2.second).longValue();
            timeline2.getPeriod(intValue3, this.period, true);
            if (mediaPeriodHolder != null) {
                Object obj3 = this.period.uid;
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithPeriodIndex(-1);
                while (true) {
                    mediaPeriodHolder = mediaPeriodHolder.next;
                    if (mediaPeriodHolder == null) {
                        break;
                    } else if (mediaPeriodHolder.uid.equals(obj3)) {
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
        if (indexOfPeriod != i3) {
            this.playbackInfo = this.playbackInfo.copyWithPeriodIndex(indexOfPeriod);
        }
        if (this.playbackInfo.periodId.isAd()) {
            MediaSource.MediaPeriodId resolvePeriodPositionForAds3 = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(indexOfPeriod, this.playbackInfo.contentPositionUs);
            if (!resolvePeriodPositionForAds3.isAd() || resolvePeriodPositionForAds3.adIndexInAdGroup != this.playbackInfo.periodId.adIndexInAdGroup) {
                long seekToPeriodPosition = seekToPeriodPosition(resolvePeriodPositionForAds3, this.playbackInfo.contentPositionUs);
                if (resolvePeriodPositionForAds3.isAd()) {
                    j3 = this.playbackInfo.contentPositionUs;
                }
                this.playbackInfo = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds3, seekToPeriodPosition, j3);
                notifySourceInfoRefresh();
                return;
            }
        }
        if (mediaPeriodHolder == null) {
            notifySourceInfoRefresh();
            return;
        }
        MediaPeriodHolder updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder, indexOfPeriod);
        int i4 = indexOfPeriod;
        while (true) {
            MediaPeriodHolder mediaPeriodHolder2 = updatePeriodInfo.next;
            if (mediaPeriodHolder2 == null) {
                break;
            }
            i4 = timeline2.getNextPeriodIndex(i4, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (i4 == -1 || !mediaPeriodHolder2.uid.equals(timeline2.getPeriod(i4, this.period, true).uid)) {
                break;
            }
            updatePeriodInfo = updatePeriodInfo(mediaPeriodHolder2, i4);
        }
        notifySourceInfoRefresh();
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && (mediaPeriodHolder = this.loadingPeriodHolder) != null && !mediaPeriodHolder.prepared) {
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

    private void maybeUpdateLoadingPeriod() throws IOException {
        MediaPeriodInfoSequence.MediaPeriodInfo nextMediaPeriodInfo;
        long rendererOffset;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            MediaPeriodHolder mediaPeriodHolder = this.loadingPeriodHolder;
            if (mediaPeriodHolder == null) {
                nextMediaPeriodInfo = this.mediaPeriodInfoSequence.getFirstMediaPeriodInfo(this.playbackInfo);
            } else if (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered()) {
                MediaPeriodHolder mediaPeriodHolder2 = this.loadingPeriodHolder;
                if (mediaPeriodHolder2.info.durationUs != C.TIME_UNSET) {
                    MediaPeriodHolder mediaPeriodHolder3 = this.playingPeriodHolder;
                    if (mediaPeriodHolder3 != null && mediaPeriodHolder2.index - mediaPeriodHolder3.index == 100) {
                        return;
                    }
                    MediaPeriodInfoSequence mediaPeriodInfoSequence = this.mediaPeriodInfoSequence;
                    MediaPeriodHolder mediaPeriodHolder4 = this.loadingPeriodHolder;
                    nextMediaPeriodInfo = mediaPeriodInfoSequence.getNextMediaPeriodInfo(mediaPeriodHolder4.info, mediaPeriodHolder4.getRendererOffset(), this.rendererPositionUs);
                } else {
                    return;
                }
            } else {
                return;
            }
            if (nextMediaPeriodInfo == null) {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
                return;
            }
            MediaPeriodHolder mediaPeriodHolder5 = this.loadingPeriodHolder;
            if (mediaPeriodHolder5 == null) {
                rendererOffset = 60000000;
            } else {
                rendererOffset = mediaPeriodHolder5.getRendererOffset() + this.loadingPeriodHolder.info.durationUs;
            }
            long j = rendererOffset;
            MediaPeriodHolder mediaPeriodHolder6 = this.loadingPeriodHolder;
            if (mediaPeriodHolder6 == null) {
                i = 0;
            } else {
                i = mediaPeriodHolder6.index + 1;
            }
            MediaPeriodHolder mediaPeriodHolder7 = new MediaPeriodHolder(this.renderers, this.rendererCapabilities, j, this.trackSelector, this.loadControl, this.mediaSource, this.playbackInfo.timeline.getPeriod(nextMediaPeriodInfo.id.periodIndex, this.period, true).uid, i, nextMediaPeriodInfo);
            MediaPeriodHolder mediaPeriodHolder8 = this.loadingPeriodHolder;
            if (mediaPeriodHolder8 != null) {
                mediaPeriodHolder8.next = mediaPeriodHolder7;
            }
            this.loadingPeriodHolder = mediaPeriodHolder7;
            mediaPeriodHolder7.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        long bufferedPositionUs;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65582, this) != null) || (mediaPeriodHolder = this.playingPeriodHolder) == null) {
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
        if (this.enabledRenderers.length == 0) {
            bufferedPositionUs = Long.MIN_VALUE;
        } else {
            bufferedPositionUs = this.playingPeriodHolder.mediaPeriod.getBufferedPositionUs();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (bufferedPositionUs == Long.MIN_VALUE) {
            bufferedPositionUs = this.playingPeriodHolder.info.durationUs;
        }
        playbackInfo2.bufferedPositionUs = bufferedPositionUs;
    }

    private void validateExistingPeriodHolders() throws ExoPlaybackException {
        int i;
        boolean z;
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
            if (mediaPeriodHolder5 != null) {
                i = mediaPeriodHolder5.index;
            } else {
                i = -1;
            }
            MediaPeriodHolder mediaPeriodHolder6 = mediaPeriodHolder3.next;
            if (mediaPeriodHolder6 != null) {
                releasePeriodHoldersFrom(mediaPeriodHolder6);
                mediaPeriodHolder3.next = null;
            }
            mediaPeriodHolder3.info = this.mediaPeriodInfoSequence.getUpdatedMediaPeriodInfo(mediaPeriodHolder3.info);
            boolean z2 = true;
            if (i2 <= mediaPeriodHolder3.index) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.loadingPeriodHolder = mediaPeriodHolder3;
            }
            if (!((i == -1 || i > mediaPeriodHolder3.index) ? false : false) && (mediaPeriodHolder = this.playingPeriodHolder) != null) {
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
    }

    private void notifySourceInfoRefresh(int i, int i2, PlaybackInfo playbackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65555, this, i, i2, playbackInfo) == null) {
            this.eventHandler.obtainMessage(5, i, i2, playbackInfo).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.Listener
    public void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, mediaSource, timeline, obj) == null) {
            this.handler.obtainMessage(7, new MediaSourceRefreshInfo(mediaSource, timeline, obj)).sendToTarget();
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65560, this) != null) || (mediaPeriodHolder = this.playingPeriodHolder) == null) {
            return;
        }
        boolean z3 = true;
        for (mediaPeriodHolder = this.playingPeriodHolder; mediaPeriodHolder != null && mediaPeriodHolder.prepared; mediaPeriodHolder = mediaPeriodHolder.next) {
            if (mediaPeriodHolder.selectTracks()) {
                if (z3) {
                    if (this.readingPeriodHolder != this.playingPeriodHolder) {
                        z = true;
                    } else {
                        z = false;
                    }
                    releasePeriodHoldersFrom(this.playingPeriodHolder.next);
                    MediaPeriodHolder mediaPeriodHolder2 = this.playingPeriodHolder;
                    mediaPeriodHolder2.next = null;
                    this.loadingPeriodHolder = mediaPeriodHolder2;
                    this.readingPeriodHolder = mediaPeriodHolder2;
                    boolean[] zArr = new boolean[this.renderers.length];
                    long updatePeriodTrackSelection = mediaPeriodHolder2.updatePeriodTrackSelection(this.playbackInfo.positionUs, z, zArr);
                    if (this.state != 4 && updatePeriodTrackSelection != this.playbackInfo.positionUs) {
                        PlaybackInfo playbackInfo = this.playbackInfo;
                        PlaybackInfo fromNewPosition = playbackInfo.fromNewPosition(playbackInfo.periodId, updatePeriodTrackSelection, playbackInfo.contentPositionUs);
                        this.playbackInfo = fromNewPosition;
                        this.eventHandler.obtainMessage(4, 3, 0, fromNewPosition).sendToTarget();
                        resetRendererPosition(updatePeriodTrackSelection);
                    }
                    boolean[] zArr2 = new boolean[this.renderers.length];
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i];
                        if (renderer.getState() != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zArr2[i] = z2;
                        SampleStream sampleStream = this.playingPeriodHolder.sampleStreams[i];
                        if (sampleStream != null) {
                            i2++;
                        }
                        if (zArr2[i]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr[i]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i++;
                    }
                    this.eventHandler.obtainMessage(2, mediaPeriodHolder.trackSelectorResult).sendToTarget();
                    enableRenderers(zArr2, i2);
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
                z3 = false;
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
                } catch (ExoPlaybackException | RuntimeException e) {
                    Log.e(TAG, "Stop failed.", e);
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

    private Pair resolveSeekPosition(SeekPosition seekPosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, seekPosition)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            Timeline timeline2 = seekPosition.timeline;
            if (timeline2.isEmpty()) {
                timeline2 = timeline;
            }
            try {
                Pair periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
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

    private void setPlayingPeriodHolder(MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65572, this, mediaPeriodHolder) != null) || this.playingPeriodHolder == mediaPeriodHolder) {
            return;
        }
        boolean[] zArr = new boolean[this.renderers.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i < rendererArr.length) {
                Renderer renderer = rendererArr[i];
                if (renderer.getState() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i] = z;
                if (mediaPeriodHolder.trackSelectorResult.renderersEnabled[i]) {
                    i2++;
                }
                if (zArr[i] && (!mediaPeriodHolder.trackSelectorResult.renderersEnabled[i] || (renderer.isCurrentStreamFinal() && renderer.getStream() == this.playingPeriodHolder.sampleStreams[i]))) {
                    disableRenderer(renderer);
                }
                i++;
            } else {
                this.playingPeriodHolder = mediaPeriodHolder;
                this.eventHandler.obtainMessage(2, mediaPeriodHolder.trackSelectorResult).sendToTarget();
                enableRenderers(zArr, i2);
                return;
            }
        }
    }

    private void scheduleNextWork(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65565, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.handler.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                this.handler.sendEmptyMessage(2);
            } else {
                this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }

    private void seekToInternal(SeekPosition seekPosition) throws ExoPlaybackException {
        int i;
        int i2;
        long j;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, seekPosition) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline == null) {
                this.pendingInitialSeekCount++;
                this.pendingSeekPosition = seekPosition;
                return;
            }
            Pair resolveSeekPosition = resolveSeekPosition(seekPosition);
            if (resolveSeekPosition == null) {
                if (timeline.isEmpty()) {
                    i4 = 0;
                } else {
                    i4 = timeline.getWindow(timeline.getFirstWindowIndex(this.shuffleModeEnabled), this.window).firstPeriodIndex;
                }
                int i5 = i4;
                this.playbackInfo = this.playbackInfo.fromNewPosition(i5, C.TIME_UNSET, C.TIME_UNSET);
                setState(4);
                this.eventHandler.obtainMessage(3, 1, 0, this.playbackInfo.fromNewPosition(i5, 0L, C.TIME_UNSET)).sendToTarget();
                resetInternal(false);
                return;
            }
            if (seekPosition.windowPositionUs == C.TIME_UNSET) {
                i = 1;
            } else {
                i = 0;
            }
            int intValue = ((Integer) resolveSeekPosition.first).intValue();
            long longValue = ((Long) resolveSeekPosition.second).longValue();
            MediaSource.MediaPeriodId resolvePeriodPositionForAds = this.mediaPeriodInfoSequence.resolvePeriodPositionForAds(intValue, longValue);
            if (resolvePeriodPositionForAds.isAd()) {
                j = 0;
                i2 = 1;
            } else {
                i2 = i;
                j = longValue;
            }
            try {
                if (resolvePeriodPositionForAds.equals(this.playbackInfo.periodId) && j / 1000 == this.playbackInfo.positionUs / 1000) {
                    return;
                }
                long seekToPeriodPosition = seekToPeriodPosition(resolvePeriodPositionForAds, j);
                if (j != seekToPeriodPosition) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                int i6 = i2 | i3;
                PlaybackInfo fromNewPosition = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds, seekToPeriodPosition, longValue);
                this.playbackInfo = fromNewPosition;
                this.eventHandler.obtainMessage(3, i6, 0, fromNewPosition).sendToTarget();
            } finally {
                PlaybackInfo fromNewPosition2 = this.playbackInfo.fromNewPosition(resolvePeriodPositionForAds, j, longValue);
                this.playbackInfo = fromNewPosition2;
                this.eventHandler.obtainMessage(3, i2, 0, fromNewPosition2).sendToTarget();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message)) == null) {
            try {
                boolean z = false;
                switch (message.what) {
                    case 0:
                        MediaSource mediaSource = (MediaSource) message.obj;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        prepareInternal(mediaSource, z);
                        return true;
                    case 1:
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        setPlayWhenReadyInternal(z);
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
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        setShuffleModeEnabledInternal(z);
                        return true;
                    default:
                        return false;
                }
            } catch (ExoPlaybackException e) {
                Log.e(TAG, "Renderer error.", e);
                this.eventHandler.obtainMessage(7, e).sendToTarget();
                stopInternal();
                return true;
            } catch (IOException e2) {
                Log.e(TAG, "Source error.", e2);
                this.eventHandler.obtainMessage(7, ExoPlaybackException.createForSource(e2)).sendToTarget();
                stopInternal();
                return true;
            } catch (RuntimeException e3) {
                Log.e(TAG, "Internal runtime error.", e3);
                this.eventHandler.obtainMessage(7, ExoPlaybackException.createForUnexpected(e3)).sendToTarget();
                stopInternal();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j) throws ExoPlaybackException {
        InterceptResult invokeLJ;
        MediaPeriodHolder mediaPeriodHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65567, this, mediaPeriodId, j)) == null) {
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
                    if (mediaPeriodHolder == null && shouldKeepPeriodHolder(mediaPeriodId, j, mediaPeriodHolder2)) {
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
                    j = mediaPeriodHolder5.mediaPeriod.seekToUs(j);
                }
                resetRendererPosition(j);
                maybeContinueLoading();
            } else {
                this.loadingPeriodHolder = null;
                this.readingPeriodHolder = null;
                this.playingPeriodHolder = null;
                resetRendererPosition(j);
            }
            this.handler.sendEmptyMessage(2);
            return j;
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

    private boolean shouldKeepPeriodHolder(MediaSource.MediaPeriodId mediaPeriodId, long j, MediaPeriodHolder mediaPeriodHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65576, this, new Object[]{mediaPeriodId, Long.valueOf(j), mediaPeriodHolder})) == null) {
            if (mediaPeriodId.equals(mediaPeriodHolder.info.id) && mediaPeriodHolder.prepared) {
                this.playbackInfo.timeline.getPeriod(mediaPeriodHolder.info.id.periodIndex, this.period);
                int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j);
                if (adGroupIndexAfterPositionUs == -1 || this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) == mediaPeriodHolder.info.endPositionUs) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
