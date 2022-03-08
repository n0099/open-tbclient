package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes7.dex */
public final class ExoPlayerImpl implements ExoPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ExoPlayerImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public final TrackSelectionArray emptyTrackSelections;
    public final Handler eventHandler;
    public final ExoPlayerImplInternal internalPlayer;
    public boolean isLoading;
    public final CopyOnWriteArraySet<Player.EventListener> listeners;
    public int maskingPeriodIndex;
    public int maskingWindowIndex;
    public long maskingWindowPositionMs;
    public int pendingPrepareAcks;
    public int pendingSeekAcks;
    public final Timeline.Period period;
    public boolean playWhenReady;
    public PlaybackInfo playbackInfo;
    public PlaybackParameters playbackParameters;
    public int playbackState;
    public final Renderer[] renderers;
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public TrackGroupArray trackGroups;
    public TrackSelectionArray trackSelections;
    public final TrackSelector trackSelector;
    public boolean tracksSelected;
    public final Timeline.Window window;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rendererArr, trackSelector, loadControl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT;
        Assertions.checkState(rendererArr.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.playbackState = 1;
        this.listeners = new CopyOnWriteArraySet<>();
        this.emptyTrackSelections = new TrackSelectionArray(new TrackSelection[rendererArr.length]);
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.trackGroups = TrackGroupArray.EMPTY;
        this.trackSelections = this.emptyTrackSelections;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.eventHandler = new Handler(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExoPlayerImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    this.this$0.handleEvent(message);
                }
            }
        };
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, null, 0, 0L);
        this.internalPlayer = new ExoPlayerImplInternal(rendererArr, trackSelector, loadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, this.eventHandler, this);
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{playbackInfo, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            Assertions.checkNotNull(playbackInfo.timeline);
            int i5 = this.pendingPrepareAcks - i2;
            this.pendingPrepareAcks = i5;
            int i6 = this.pendingSeekAcks - i3;
            this.pendingSeekAcks = i6;
            if (i5 == 0 && i6 == 0) {
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                boolean z2 = (playbackInfo2.timeline == playbackInfo.timeline && playbackInfo2.manifest == playbackInfo.manifest) ? false : true;
                this.playbackInfo = playbackInfo;
                if (playbackInfo.timeline.isEmpty()) {
                    this.maskingPeriodIndex = 0;
                    this.maskingWindowIndex = 0;
                    this.maskingWindowPositionMs = 0L;
                }
                if (z2) {
                    Iterator<Player.EventListener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onTimelineChanged(playbackInfo.timeline, playbackInfo.manifest);
                    }
                }
                if (z) {
                    Iterator<Player.EventListener> it2 = this.listeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().onPositionDiscontinuity(i4);
                    }
                }
            }
            if (this.pendingSeekAcks != 0 || i3 <= 0) {
                return;
            }
            Iterator<Player.EventListener> it3 = this.listeners.iterator();
            while (it3.hasNext()) {
                it3.next().onSeekProcessed();
            }
        }
    }

    private long playbackInfoPositionUsToWindowPositionMs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
            long usToMs = C.usToMs(j2);
            if (this.playbackInfo.periodId.isAd()) {
                return usToMs;
            }
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
            return usToMs + this.period.getPositionInWindowMs();
        }
        return invokeJ.longValue;
    }

    private boolean shouldMaskPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.playbackInfo.timeline.isEmpty() || this.pendingSeekAcks > 0 || this.pendingPrepareAcks > 0 : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eventListener) == null) {
            this.listeners.add(eventListener);
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exoPlayerMessageArr) == null) {
            this.internalPlayer.blockingSendMessages(exoPlayerMessageArr);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getBufferedPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long bufferedPosition = getBufferedPosition();
            long duration = getDuration();
            if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
                return 0;
            }
            if (duration == 0) {
                return 100;
            }
            return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (shouldMaskPosition()) {
                return this.maskingWindowPositionMs;
            }
            return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (isPlayingAd()) {
                PlaybackInfo playbackInfo = this.playbackInfo;
                playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
                return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
            }
            return getCurrentPosition();
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (isPlayingAd()) {
                return this.playbackInfo.periodId.adGroupIndex;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (isPlayingAd()) {
                return this.playbackInfo.periodId.adIndexInAdGroup;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public Object getCurrentManifest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.playbackInfo.manifest : invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (shouldMaskPosition()) {
                return this.maskingPeriodIndex;
            }
            return this.playbackInfo.periodId.periodIndex;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (shouldMaskPosition()) {
                return this.maskingWindowPositionMs;
            }
            return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.playbackInfo.timeline : (Timeline) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.trackGroups : (TrackGroupArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.trackSelections : (TrackSelectionArray) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (shouldMaskPosition()) {
                return this.maskingWindowIndex;
            }
            PlaybackInfo playbackInfo = this.playbackInfo;
            return playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period).windowIndex;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline.isEmpty()) {
                return C.TIME_UNSET;
            }
            if (isPlayingAd()) {
                MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
                timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
                return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
            }
            return timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getNextWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline.isEmpty()) {
                return -1;
            }
            return timeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.playWhenReady : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.internalPlayer.getPlaybackLooper() : (Looper) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.playbackParameters : (PlaybackParameters) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.playbackState : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPreviousWindowIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (timeline.isEmpty()) {
                return -1;
            }
            return timeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.renderers.length : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRendererType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) ? this.renderers[i2].getTrackType() : invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.repeatMode : invokeV.intValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.shuffleModeEnabled : invokeV.booleanValue;
    }

    public void handleEvent(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, message) == null) {
            switch (message.what) {
                case 0:
                    this.playbackState = message.arg1;
                    Iterator<Player.EventListener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onPlayerStateChanged(this.playWhenReady, this.playbackState);
                    }
                    return;
                case 1:
                    this.isLoading = message.arg1 != 0;
                    Iterator<Player.EventListener> it2 = this.listeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().onLoadingChanged(this.isLoading);
                    }
                    return;
                case 2:
                    if (this.pendingPrepareAcks == 0) {
                        TrackSelectorResult trackSelectorResult = (TrackSelectorResult) message.obj;
                        this.tracksSelected = true;
                        this.trackGroups = trackSelectorResult.groups;
                        this.trackSelections = trackSelectorResult.selections;
                        this.trackSelector.onSelectionActivated(trackSelectorResult.info);
                        Iterator<Player.EventListener> it3 = this.listeners.iterator();
                        while (it3.hasNext()) {
                            it3.next().onTracksChanged(this.trackGroups, this.trackSelections);
                        }
                        return;
                    }
                    return;
                case 3:
                    handlePlaybackInfo((PlaybackInfo) message.obj, 0, 1, message.arg1 != 0, 2);
                    return;
                case 4:
                    handlePlaybackInfo((PlaybackInfo) message.obj, 0, 0, true, message.arg1);
                    return;
                case 5:
                    handlePlaybackInfo((PlaybackInfo) message.obj, message.arg1, message.arg2, false, 3);
                    return;
                case 6:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    if (this.playbackParameters.equals(playbackParameters)) {
                        return;
                    }
                    this.playbackParameters = playbackParameters;
                    Iterator<Player.EventListener> it4 = this.listeners.iterator();
                    while (it4.hasNext()) {
                        it4.next().onPlaybackParametersChanged(playbackParameters);
                    }
                    return;
                case 7:
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator<Player.EventListener> it5 = this.listeners.iterator();
                    while (it5.hasNext()) {
                        it5.next().onPlayerError(exoPlaybackException);
                    }
                    return;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowDynamic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isCurrentWindowSeekable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.isLoading : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? !shouldMaskPosition() && this.playbackInfo.periodId.isAd() : invokeV.booleanValue;
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, mediaSource) == null) {
            prepare(mediaSource, true, true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            String str = "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + PreferencesUtil.RIGHT_MOUNT;
            this.internalPlayer.release();
            this.eventHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eventListener) == null) {
            this.listeners.remove(eventListener);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j2) == null) {
            seekTo(getCurrentWindowIndex(), j2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            seekToDefaultPosition(getCurrentWindowIndex());
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, exoPlayerMessageArr) == null) {
            this.internalPlayer.sendMessages(exoPlayerMessageArr);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || this.playWhenReady == z) {
            return;
        }
        this.playWhenReady = z;
        this.internalPlayer.setPlayWhenReady(z);
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(z, this.playbackState);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, playbackParameters) == null) {
            if (playbackParameters == null) {
                playbackParameters = PlaybackParameters.DEFAULT;
            }
            this.internalPlayer.setPlaybackParameters(playbackParameters);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048617, this, i2) == null) || this.repeatMode == i2) {
            return;
        }
        this.repeatMode = i2;
        this.internalPlayer.setRepeatMode(i2);
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRepeatModeChanged(i2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || this.shuffleModeEnabled == z) {
            return;
        }
        this.shuffleModeEnabled = z;
        this.internalPlayer.setShuffleModeEnabled(z);
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onShuffleModeEnabledChanged(z);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.internalPlayer.stop();
        }
    }

    @Override // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{mediaSource, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                this.maskingWindowIndex = getCurrentWindowIndex();
                this.maskingPeriodIndex = getCurrentPeriodIndex();
                this.maskingWindowPositionMs = getCurrentPosition();
            } else {
                this.maskingWindowIndex = 0;
                this.maskingPeriodIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            if (z2) {
                if (!this.playbackInfo.timeline.isEmpty() || this.playbackInfo.manifest != null) {
                    this.playbackInfo = this.playbackInfo.copyWithTimeline(Timeline.EMPTY, null);
                    Iterator<Player.EventListener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        PlaybackInfo playbackInfo = this.playbackInfo;
                        it.next().onTimelineChanged(playbackInfo.timeline, playbackInfo.manifest);
                    }
                }
                if (this.tracksSelected) {
                    this.tracksSelected = false;
                    this.trackGroups = TrackGroupArray.EMPTY;
                    this.trackSelections = this.emptyTrackSelections;
                    this.trackSelector.onSelectionActivated(null);
                    Iterator<Player.EventListener> it2 = this.listeners.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTracksChanged(this.trackGroups, this.trackSelections);
                    }
                }
            }
            this.pendingPrepareAcks++;
            this.internalPlayer.prepare(mediaSource, z);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i2, long j2) {
        long msToUs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            Timeline timeline = this.playbackInfo.timeline;
            if (i2 >= 0 && (timeline.isEmpty() || i2 < timeline.getWindowCount())) {
                if (isPlayingAd()) {
                    if (this.pendingSeekAcks == 0) {
                        Iterator<Player.EventListener> it = this.listeners.iterator();
                        while (it.hasNext()) {
                            it.next().onSeekProcessed();
                        }
                        return;
                    }
                    return;
                }
                this.pendingSeekAcks++;
                this.maskingWindowIndex = i2;
                if (timeline.isEmpty()) {
                    this.maskingWindowPositionMs = j2 == C.TIME_UNSET ? 0L : j2;
                    this.maskingPeriodIndex = 0;
                } else {
                    timeline.getWindow(i2, this.window);
                    if (j2 == C.TIME_UNSET) {
                        msToUs = this.window.getDefaultPositionUs();
                    } else {
                        msToUs = C.msToUs(j2);
                    }
                    Timeline.Window window = this.window;
                    int i3 = window.firstPeriodIndex;
                    long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + msToUs;
                    long durationUs = timeline.getPeriod(i3, this.period).getDurationUs();
                    while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i3 < this.window.lastPeriodIndex) {
                        positionInFirstPeriodUs -= durationUs;
                        i3++;
                        durationUs = timeline.getPeriod(i3, this.period).getDurationUs();
                    }
                    this.maskingWindowPositionMs = C.usToMs(msToUs);
                    this.maskingPeriodIndex = i3;
                }
                this.internalPlayer.seekTo(timeline, i2, C.msToUs(j2));
                Iterator<Player.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onPositionDiscontinuity(1);
                }
                return;
            }
            throw new IllegalSeekPositionException(timeline, i2, j2);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekToDefaultPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            seekTo(i2, C.TIME_UNSET);
        }
    }
}
