package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes5.dex */
public class PlaybackControlView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final ControlDispatcher DEFAULT_CONTROL_DISPATCHER;
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] adGroupTimesMs;
    public final ComponentListener componentListener;
    public com.google.android.exoplayer2.ControlDispatcher controlDispatcher;
    public final TextView durationView;
    public long[] extraAdGroupTimesMs;
    public boolean[] extraPlayedAdGroups;
    public final View fastForwardButton;
    public int fastForwardMs;
    public final StringBuilder formatBuilder;
    public final Formatter formatter;
    public final Runnable hideAction;
    public long hideAtMs;
    public boolean isAttachedToWindow;
    public boolean multiWindowTimeBar;
    public final View nextButton;
    public final View pauseButton;
    public final Timeline.Period period;
    public final View playButton;
    public boolean[] playedAdGroups;
    public Player player;
    public final TextView positionView;
    public final View previousButton;
    public final String repeatAllButtonContentDescription;
    public final Drawable repeatAllButtonDrawable;
    public final String repeatOffButtonContentDescription;
    public final Drawable repeatOffButtonDrawable;
    public final String repeatOneButtonContentDescription;
    public final Drawable repeatOneButtonDrawable;
    public final ImageView repeatToggleButton;
    public int repeatToggleModes;
    public final View rewindButton;
    public int rewindMs;
    public boolean scrubbing;
    public boolean showMultiWindowTimeBar;
    public boolean showShuffleButton;
    public int showTimeoutMs;
    public final View shuffleButton;
    public final TimeBar timeBar;
    public final Runnable updateProgressAction;
    public VisibilityListener visibilityListener;
    public final Timeline.Window window;

    /* loaded from: classes5.dex */
    public final class ComponentListener extends Player.DefaultEventListener implements TimeBar.OnScrubListener, View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PlaybackControlView this$0;

        public ComponentListener(PlaybackControlView playbackControlView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {playbackControlView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = playbackControlView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.this$0.player != null) {
                    if (this.this$0.nextButton == view2) {
                        this.this$0.next();
                    } else if (this.this$0.previousButton == view2) {
                        this.this$0.previous();
                    } else if (this.this$0.fastForwardButton == view2) {
                        this.this$0.fastForward();
                    } else if (this.this$0.rewindButton == view2) {
                        this.this$0.rewind();
                    } else if (this.this$0.playButton == view2) {
                        this.this$0.controlDispatcher.dispatchSetPlayWhenReady(this.this$0.player, true);
                    } else if (this.this$0.pauseButton == view2) {
                        this.this$0.controlDispatcher.dispatchSetPlayWhenReady(this.this$0.player, false);
                    } else if (this.this$0.repeatToggleButton != view2) {
                        if (this.this$0.shuffleButton == view2) {
                            this.this$0.controlDispatcher.dispatchSetShuffleModeEnabled(this.this$0.player, true ^ this.this$0.player.getShuffleModeEnabled());
                        }
                    } else {
                        this.this$0.controlDispatcher.dispatchSetRepeatMode(this.this$0.player, RepeatModeUtil.getNextRepeatMode(this.this$0.player.getRepeatMode(), this.this$0.repeatToggleModes));
                    }
                }
                this.this$0.hideAfterTimeout();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.this$0.updatePlayPauseButton();
                this.this$0.updateProgress();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.this$0.updateNavigation();
                this.this$0.updateProgress();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.this$0.updateRepeatModeButton();
                this.this$0.updateNavigation();
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLJ(1048580, this, timeBar, j) == null) || this.this$0.positionView == null) {
                return;
            }
            this.this$0.positionView.setText(Util.getStringForTime(this.this$0.formatBuilder, this.this$0.formatter, j));
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, timeBar, j) == null) {
                PlaybackControlView playbackControlView = this.this$0;
                playbackControlView.removeCallbacks(playbackControlView.hideAction);
                this.this$0.scrubbing = true;
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{timeBar, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                this.this$0.scrubbing = false;
                if (!z && this.this$0.player != null) {
                    this.this$0.seekToTimeBarPosition(j);
                }
                this.this$0.hideAfterTimeout();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.this$0.updateShuffleButton();
                this.this$0.updateNavigation();
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, timeline, obj) == null) {
                this.this$0.updateNavigation();
                this.this$0.updateTimeBarMode();
                this.this$0.updateProgress();
            }
        }
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public interface ControlDispatcher extends com.google.android.exoplayer2.ControlDispatcher {
    }

    /* loaded from: classes5.dex */
    public static final class DefaultControlDispatcher extends com.google.android.exoplayer2.DefaultControlDispatcher implements ControlDispatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultControlDispatcher() {
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
    }

    /* loaded from: classes5.dex */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779824241, "Lcom/google/android/exoplayer2/ui/PlaybackControlView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(779824241, "Lcom/google/android/exoplayer2/ui/PlaybackControlView;");
                return;
            }
        }
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
        DEFAULT_CONTROL_DISPATCHER = new DefaultControlDispatcher();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, timeline, window)) == null) {
            if (timeline.getWindowCount() > 100) {
                return false;
            }
            int windowCount = timeline.getWindowCount();
            for (int i = 0; i < windowCount; i++) {
                if (timeline.getWindow(i, window).durationUs == C.TIME_UNSET) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65570, this) == null) || this.fastForwardMs <= 0) {
            return;
        }
        long duration = this.player.getDuration();
        long currentPosition = this.player.getCurrentPosition() + this.fastForwardMs;
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(currentPosition);
    }

    public static int getRepeatToggleModes(TypedArray typedArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, typedArray, i)) == null) ? typedArray.getInt(2, i) : invokeLI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAfterTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            removeCallbacks(this.hideAction);
            if (this.showTimeoutMs > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = this.showTimeoutMs;
                this.hideAtMs = uptimeMillis + i;
                if (this.isAttachedToWindow) {
                    postDelayed(this.hideAction, i);
                    return;
                }
                return;
            }
            this.hideAtMs = C.TIME_UNSET;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static boolean isHandledMediaKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65573, null, i)) == null) ? i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88 : invokeI.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (currentTimeline.isEmpty()) {
                return;
            }
            int currentWindowIndex = this.player.getCurrentWindowIndex();
            int nextWindowIndex = this.player.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                seekTo(nextWindowIndex, C.TIME_UNSET);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.window, false).isDynamic) {
                seekTo(currentWindowIndex, C.TIME_UNSET);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r1.isSeekable == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void previous() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (currentTimeline.isEmpty()) {
                return;
            }
            currentTimeline.getWindow(this.player.getCurrentWindowIndex(), this.window);
            int previousWindowIndex = this.player.getPreviousWindowIndex();
            if (previousWindowIndex != -1) {
                if (this.player.getCurrentPosition() > 3000) {
                    Timeline.Window window = this.window;
                    if (window.isDynamic) {
                    }
                }
                seekTo(previousWindowIndex, C.TIME_UNSET);
                return;
            }
            seekTo(0L);
        }
    }

    private void requestPlayPauseFocus() {
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            Player player = this.player;
            boolean z = player != null && player.getPlayWhenReady();
            if (!z && (view3 = this.playButton) != null) {
                view3.requestFocus();
            } else if (!z || (view2 = this.pauseButton) == null) {
            } else {
                view2.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65577, this) == null) || this.rewindMs <= 0) {
            return;
        }
        seekTo(Math.max(this.player.getCurrentPosition() - this.rewindMs, 0L));
    }

    private void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65579, this, j) == null) {
            seekTo(this.player.getCurrentWindowIndex(), j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(long j) {
        int currentWindowIndex;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65580, this, j) == null) {
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (this.multiWindowTimeBar && !currentTimeline.isEmpty()) {
                int windowCount = currentTimeline.getWindowCount();
                currentWindowIndex = 0;
                while (true) {
                    long durationMs = currentTimeline.getWindow(currentWindowIndex, this.window).getDurationMs();
                    if (j < durationMs) {
                        break;
                    } else if (currentWindowIndex == windowCount - 1) {
                        j = durationMs;
                        break;
                    } else {
                        j -= durationMs;
                        currentWindowIndex++;
                    }
                }
            } else {
                currentWindowIndex = this.player.getCurrentWindowIndex();
            }
            seekTo(currentWindowIndex, j);
        }
    }

    private void setButtonEnabled(boolean z, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65581, this, z, view2) == null) || view2 == null) {
            return;
        }
        view2.setEnabled(z);
        view2.setAlpha(z ? 1.0f : 0.3f);
        view2.setVisibility(0);
    }

    private void updateAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            updatePlayPauseButton();
            updateNavigation();
            updateRepeatModeButton();
            updateShuffleButton();
            updateProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateNavigation() {
        boolean z;
        boolean z2;
        boolean z3;
        TimeBar timeBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65583, this) != null) || !isVisible() || !this.isAttachedToWindow) {
            return;
        }
        Player player = this.player;
        Timeline currentTimeline = player != null ? player.getCurrentTimeline() : null;
        boolean z4 = true;
        if (!((currentTimeline == null || currentTimeline.isEmpty()) ? false : true) || this.player.isPlayingAd()) {
            z = false;
            z2 = false;
        } else {
            currentTimeline.getWindow(this.player.getCurrentWindowIndex(), this.window);
            Timeline.Window window = this.window;
            z2 = window.isSeekable;
            z = (!z2 && window.isDynamic && this.player.getPreviousWindowIndex() == -1) ? false : true;
            if (this.window.isDynamic || this.player.getNextWindowIndex() != -1) {
                z3 = true;
                setButtonEnabled(z, this.previousButton);
                setButtonEnabled(z3, this.nextButton);
                setButtonEnabled(this.fastForwardMs <= 0 && z2, this.fastForwardButton);
                setButtonEnabled((this.rewindMs > 0 || !z2) ? false : false, this.rewindButton);
                timeBar = this.timeBar;
                if (timeBar == null) {
                    timeBar.setEnabled(z2);
                    return;
                }
                return;
            }
        }
        z3 = false;
        setButtonEnabled(z, this.previousButton);
        setButtonEnabled(z3, this.nextButton);
        setButtonEnabled(this.fastForwardMs <= 0 && z2, this.fastForwardButton);
        setButtonEnabled((this.rewindMs > 0 || !z2) ? false : false, this.rewindButton);
        timeBar = this.timeBar;
        if (timeBar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65584, this) == null) && isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            boolean z2 = true;
            boolean z3 = player != null && player.getPlayWhenReady();
            View view2 = this.playButton;
            if (view2 != null) {
                z = (z3 && view2.isFocused()) | false;
                this.playButton.setVisibility(z3 ? 8 : 0);
            } else {
                z = false;
            }
            View view3 = this.pauseButton;
            if (view3 != null) {
                z |= (z3 || !view3.isFocused()) ? false : false;
                this.pauseButton.setVisibility(z3 ? 0 : 8);
            }
            if (z) {
                requestPlayPauseFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long j;
        long j2;
        long j3;
        int i;
        Timeline.Window window;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65585, this) == null) && isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            long j4 = 0;
            boolean z = true;
            if (player != null) {
                Timeline currentTimeline = player.getCurrentTimeline();
                if (currentTimeline.isEmpty()) {
                    j3 = 0;
                    i = 0;
                } else {
                    int currentWindowIndex = this.player.getCurrentWindowIndex();
                    int i3 = this.multiWindowTimeBar ? 0 : currentWindowIndex;
                    int windowCount = this.multiWindowTimeBar ? currentTimeline.getWindowCount() - 1 : currentWindowIndex;
                    long j5 = 0;
                    j3 = 0;
                    i = 0;
                    while (true) {
                        if (i3 > windowCount) {
                            break;
                        }
                        if (i3 == currentWindowIndex) {
                            j3 = j5;
                        }
                        currentTimeline.getWindow(i3, this.window);
                        Timeline.Window window2 = this.window;
                        int i4 = i3;
                        if (window2.durationUs == C.TIME_UNSET) {
                            Assertions.checkState(this.multiWindowTimeBar ^ z);
                            break;
                        }
                        int i5 = window2.firstPeriodIndex;
                        while (true) {
                            window = this.window;
                            if (i5 <= window.lastPeriodIndex) {
                                currentTimeline.getPeriod(i5, this.period);
                                int adGroupCount = this.period.getAdGroupCount();
                                int i6 = 0;
                                while (i6 < adGroupCount) {
                                    long adGroupTimeUs = this.period.getAdGroupTimeUs(i6);
                                    if (adGroupTimeUs == Long.MIN_VALUE) {
                                        i2 = currentWindowIndex;
                                        long j6 = this.period.durationUs;
                                        if (j6 == C.TIME_UNSET) {
                                            i6++;
                                            currentWindowIndex = i2;
                                        } else {
                                            adGroupTimeUs = j6;
                                        }
                                    } else {
                                        i2 = currentWindowIndex;
                                    }
                                    long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
                                    if (positionInWindowUs >= 0 && positionInWindowUs <= this.window.durationUs) {
                                        long[] jArr = this.adGroupTimesMs;
                                        if (i == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.adGroupTimesMs = Arrays.copyOf(this.adGroupTimesMs, length);
                                            this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                        }
                                        this.adGroupTimesMs[i] = C.usToMs(j5 + positionInWindowUs);
                                        this.playedAdGroups[i] = this.period.hasPlayedAdGroup(i6);
                                        i++;
                                    }
                                    i6++;
                                    currentWindowIndex = i2;
                                }
                                i5++;
                            }
                        }
                        j5 += window.durationUs;
                        i3 = i4 + 1;
                        currentWindowIndex = currentWindowIndex;
                        z = true;
                    }
                    j4 = j5;
                }
                j4 = C.usToMs(j4);
                long usToMs = C.usToMs(j3);
                if (this.player.isPlayingAd()) {
                    j = usToMs + this.player.getContentPosition();
                    j2 = j;
                } else {
                    long currentPosition = this.player.getCurrentPosition() + usToMs;
                    long bufferedPosition = usToMs + this.player.getBufferedPosition();
                    j = currentPosition;
                    j2 = bufferedPosition;
                }
                if (this.timeBar != null) {
                    int length2 = this.extraAdGroupTimesMs.length;
                    int i7 = i + length2;
                    long[] jArr2 = this.adGroupTimesMs;
                    if (i7 > jArr2.length) {
                        this.adGroupTimesMs = Arrays.copyOf(jArr2, i7);
                        this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i7);
                    }
                    System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
                    System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
                    this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i7);
                }
            } else {
                j = 0;
                j2 = 0;
            }
            TextView textView = this.durationView;
            if (textView != null) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, j4));
            }
            TextView textView2 = this.positionView;
            if (textView2 != null && !this.scrubbing) {
                textView2.setText(Util.getStringForTime(this.formatBuilder, this.formatter, j));
            }
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setPosition(j);
                this.timeBar.setBufferedPosition(j2);
                this.timeBar.setDuration(j4);
            }
            removeCallbacks(this.updateProgressAction);
            Player player2 = this.player;
            int playbackState = player2 == null ? 1 : player2.getPlaybackState();
            if (playbackState == 1 || playbackState == 4) {
                return;
            }
            long j7 = 1000;
            if (this.player.getPlayWhenReady() && playbackState == 3) {
                float f = this.player.getPlaybackParameters().speed;
                if (f > 0.1f) {
                    if (f <= 5.0f) {
                        long max = 1000 / Math.max(1, Math.round(1.0f / f));
                        long j8 = max - (j % max);
                        if (j8 < max / 5) {
                            j8 += max;
                        }
                        if (f != 1.0f) {
                            j8 = ((float) j8) / f;
                        }
                        j7 = j8;
                    } else {
                        j7 = 200;
                    }
                }
            }
            postDelayed(this.updateProgressAction, j7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65586, this) == null) && isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                imageView.setVisibility(8);
            } else if (this.player == null) {
                setButtonEnabled(false, imageView);
            } else {
                setButtonEnabled(true, imageView);
                int repeatMode = this.player.getRepeatMode();
                if (repeatMode == 0) {
                    this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                } else if (repeatMode == 1) {
                    this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
                } else if (repeatMode == 2) {
                    this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
                }
                this.repeatToggleButton.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65587, this) == null) && isVisible() && this.isAttachedToWindow && (view2 = this.shuffleButton) != null) {
            if (!this.showShuffleButton) {
                view2.setVisibility(8);
                return;
            }
            Player player = this.player;
            if (player == null) {
                setButtonEnabled(false, view2);
                return;
            }
            view2.setAlpha(player.getShuffleModeEnabled() ? 1.0f : 0.3f);
            this.shuffleButton.setEnabled(true);
            this.shuffleButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeBarMode() {
        Player player;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65588, this) == null) || (player = this.player) == null) {
            return;
        }
        this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player.getCurrentTimeline(), this.window);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) ? dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, keyEvent)) == null) {
            int keyCode = keyEvent.getKeyCode();
            if (this.player == null || !isHandledMediaKey(keyCode)) {
                return false;
            }
            if (keyEvent.getAction() == 0) {
                if (keyCode == 90) {
                    fastForward();
                } else if (keyCode == 89) {
                    rewind();
                } else if (keyEvent.getRepeatCount() == 0) {
                    if (keyCode == 85) {
                        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.controlDispatcher;
                        Player player = this.player;
                        controlDispatcher.dispatchSetPlayWhenReady(player, !player.getPlayWhenReady());
                    } else if (keyCode == 87) {
                        next();
                    } else if (keyCode == 88) {
                        previous();
                    } else if (keyCode == 126) {
                        this.controlDispatcher.dispatchSetPlayWhenReady(this.player, true);
                    } else if (keyCode == 127) {
                        this.controlDispatcher.dispatchSetPlayWhenReady(this.player, false);
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Player getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.player : (Player) invokeV.objValue;
    }

    public boolean getShowShuffleButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.showShuffleButton : invokeV.booleanValue;
    }

    public int getShowTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.showTimeoutMs : invokeV.intValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && isVisible()) {
            setVisibility(8);
            VisibilityListener visibilityListener = this.visibilityListener;
            if (visibilityListener != null) {
                visibilityListener.onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            this.isAttachedToWindow = true;
            long j = this.hideAtMs;
            if (j != C.TIME_UNSET) {
                long uptimeMillis = j - SystemClock.uptimeMillis();
                if (uptimeMillis <= 0) {
                    hide();
                } else {
                    postDelayed(this.hideAction, uptimeMillis);
                }
            }
            updateAll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            this.isAttachedToWindow = false;
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
        }
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, controlDispatcher) == null) {
            if (controlDispatcher == null) {
                controlDispatcher = new com.google.android.exoplayer2.DefaultControlDispatcher();
            }
            this.controlDispatcher = controlDispatcher;
        }
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, jArr, zArr) == null) {
            if (jArr == null) {
                this.extraAdGroupTimesMs = new long[0];
                this.extraPlayedAdGroups = new boolean[0];
            } else {
                Assertions.checkArgument(jArr.length == zArr.length);
                this.extraAdGroupTimesMs = jArr;
                this.extraPlayedAdGroups = zArr;
            }
            updateProgress();
        }
    }

    public void setFastForwardIncrementMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.fastForwardMs = i;
            updateNavigation();
        }
    }

    public void setPlayer(Player player) {
        Player player2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, player) == null) || (player2 = this.player) == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.componentListener);
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.componentListener);
        }
        updateAll();
    }

    public void setRepeatToggleModes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.repeatToggleModes = i;
            Player player = this.player;
            if (player != null) {
                int repeatMode = player.getRepeatMode();
                if (i == 0 && repeatMode != 0) {
                    this.controlDispatcher.dispatchSetRepeatMode(this.player, 0);
                } else if (i == 1 && repeatMode == 2) {
                    this.controlDispatcher.dispatchSetRepeatMode(this.player, 1);
                } else if (i == 2 && repeatMode == 1) {
                    this.controlDispatcher.dispatchSetRepeatMode(this.player, 2);
                }
            }
        }
    }

    public void setRewindIncrementMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.rewindMs = i;
            updateNavigation();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.showMultiWindowTimeBar = z;
            updateTimeBarMode();
        }
    }

    public void setShowShuffleButton(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.showShuffleButton = z;
            updateShuffleButton();
        }
    }

    public void setShowTimeoutMs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.showTimeoutMs = i;
        }
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, visibilityListener) == null) {
            this.visibilityListener = visibilityListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!isVisible()) {
                setVisibility(0);
                VisibilityListener visibilityListener = this.visibilityListener;
                if (visibilityListener != null) {
                    visibilityListener.onVisibilityChange(getVisibility());
                }
                updateAll();
                requestPlayPauseFocus();
            }
            hideAfterTimeout();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void seekTo(int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65578, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) || this.controlDispatcher.dispatchSeekTo(this.player, i, j)) {
            return;
        }
        updateProgress();
    }

    public int getRepeatToggleModes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.repeatToggleModes : invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (AttributeSet) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaybackControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), attributeSet2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.updateProgressAction = new Runnable(this) { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlaybackControlView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.updateProgress();
                }
            }
        };
        this.hideAction = new Runnable(this) { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PlaybackControlView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.hide();
                }
            }
        };
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.showShuffleButton = false;
        int i4 = R.layout.obfuscated_res_0x7f0d0276;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, new int[]{R.attr.obfuscated_res_0x7f04019c, R.attr.obfuscated_res_0x7f0402b2, R.attr.obfuscated_res_0x7f0405b9, R.attr.obfuscated_res_0x7f0405be, R.attr.obfuscated_res_0x7f040624, R.attr.obfuscated_res_0x7f040625}, 0, 0);
            try {
                this.rewindMs = obtainStyledAttributes.getInt(3, this.rewindMs);
                this.fastForwardMs = obtainStyledAttributes.getInt(1, this.fastForwardMs);
                this.showTimeoutMs = obtainStyledAttributes.getInt(5, this.showTimeoutMs);
                i4 = obtainStyledAttributes.getResourceId(0, R.layout.obfuscated_res_0x7f0d0276);
                this.repeatToggleModes = getRepeatToggleModes(obtainStyledAttributes, this.repeatToggleModes);
                this.showShuffleButton = obtainStyledAttributes.getBoolean(4, this.showShuffleButton);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        this.componentListener = new ComponentListener();
        this.controlDispatcher = new com.google.android.exoplayer2.DefaultControlDispatcher();
        LayoutInflater.from(context).inflate(i4, this);
        setDescendantFocusability(262144);
        this.durationView = (TextView) findViewById(R.id.obfuscated_res_0x7f09092c);
        this.positionView = (TextView) findViewById(R.id.obfuscated_res_0x7f090932);
        TimeBar timeBar = (TimeBar) findViewById(R.id.obfuscated_res_0x7f090934);
        this.timeBar = timeBar;
        if (timeBar != null) {
            timeBar.addListener(this.componentListener);
        }
        View findViewById = findViewById(R.id.obfuscated_res_0x7f090931);
        this.playButton = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.componentListener);
        }
        View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090930);
        this.pauseButton = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this.componentListener);
        }
        View findViewById3 = findViewById(R.id.obfuscated_res_0x7f090933);
        this.previousButton = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this.componentListener);
        }
        View findViewById4 = findViewById(R.id.obfuscated_res_0x7f09092e);
        this.nextButton = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this.componentListener);
        }
        View findViewById5 = findViewById(R.id.obfuscated_res_0x7f090936);
        this.rewindButton = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this.componentListener);
        }
        View findViewById6 = findViewById(R.id.obfuscated_res_0x7f09092d);
        this.fastForwardButton = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(this.componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090935);
        this.repeatToggleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.componentListener);
        }
        View findViewById7 = findViewById(R.id.obfuscated_res_0x7f090937);
        this.shuffleButton = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(this.componentListener);
        }
        Resources resources = context.getResources();
        this.repeatOffButtonDrawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0804db);
        this.repeatOneButtonDrawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0804dc);
        this.repeatAllButtonDrawable = resources.getDrawable(R.drawable.obfuscated_res_0x7f0804da);
        this.repeatOffButtonContentDescription = resources.getString(R.string.obfuscated_res_0x7f0f05d1);
        this.repeatOneButtonContentDescription = resources.getString(R.string.obfuscated_res_0x7f0f05d2);
        this.repeatAllButtonContentDescription = resources.getString(R.string.obfuscated_res_0x7f0f05d0);
    }
}
