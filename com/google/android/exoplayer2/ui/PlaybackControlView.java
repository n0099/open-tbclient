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
/* loaded from: classes9.dex */
public class PlaybackControlView extends FrameLayout {
    @Deprecated
    public static final ControlDispatcher DEFAULT_CONTROL_DISPATCHER;
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
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

    @Deprecated
    /* loaded from: classes9.dex */
    public interface ControlDispatcher extends com.google.android.exoplayer2.ControlDispatcher {
    }

    /* loaded from: classes9.dex */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    @SuppressLint({"InlinedApi"})
    public static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    /* loaded from: classes9.dex */
    public final class ComponentListener extends Player.DefaultEventListener implements TimeBar.OnScrubListener, View.OnClickListener {
        public ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            PlaybackControlView.this.updateNavigation();
            PlaybackControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            PlaybackControlView.this.updateRepeatModeButton();
            PlaybackControlView.this.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            PlaybackControlView.this.updateShuffleButton();
            PlaybackControlView.this.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            PlaybackControlView.this.updatePlayPauseButton();
            PlaybackControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long j) {
            if (PlaybackControlView.this.positionView != null) {
                PlaybackControlView.this.positionView.setText(Util.getStringForTime(PlaybackControlView.this.formatBuilder, PlaybackControlView.this.formatter, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long j) {
            PlaybackControlView playbackControlView = PlaybackControlView.this;
            playbackControlView.removeCallbacks(playbackControlView.hideAction);
            PlaybackControlView.this.scrubbing = true;
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, Object obj) {
            PlaybackControlView.this.updateNavigation();
            PlaybackControlView.this.updateTimeBarMode();
            PlaybackControlView.this.updateProgress();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (PlaybackControlView.this.player != null) {
                if (PlaybackControlView.this.nextButton == view2) {
                    PlaybackControlView.this.next();
                } else if (PlaybackControlView.this.previousButton == view2) {
                    PlaybackControlView.this.previous();
                } else if (PlaybackControlView.this.fastForwardButton == view2) {
                    PlaybackControlView.this.fastForward();
                } else if (PlaybackControlView.this.rewindButton == view2) {
                    PlaybackControlView.this.rewind();
                } else if (PlaybackControlView.this.playButton == view2) {
                    PlaybackControlView.this.controlDispatcher.dispatchSetPlayWhenReady(PlaybackControlView.this.player, true);
                } else if (PlaybackControlView.this.pauseButton == view2) {
                    PlaybackControlView.this.controlDispatcher.dispatchSetPlayWhenReady(PlaybackControlView.this.player, false);
                } else if (PlaybackControlView.this.repeatToggleButton == view2) {
                    PlaybackControlView.this.controlDispatcher.dispatchSetRepeatMode(PlaybackControlView.this.player, RepeatModeUtil.getNextRepeatMode(PlaybackControlView.this.player.getRepeatMode(), PlaybackControlView.this.repeatToggleModes));
                } else if (PlaybackControlView.this.shuffleButton == view2) {
                    PlaybackControlView.this.controlDispatcher.dispatchSetShuffleModeEnabled(PlaybackControlView.this.player, true ^ PlaybackControlView.this.player.getShuffleModeEnabled());
                }
            }
            PlaybackControlView.this.hideAfterTimeout();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            PlaybackControlView.this.scrubbing = false;
            if (!z && PlaybackControlView.this.player != null) {
                PlaybackControlView.this.seekToTimeBarPosition(j);
            }
            PlaybackControlView.this.hideAfterTimeout();
        }
    }

    /* loaded from: classes9.dex */
    public static final class DefaultControlDispatcher extends com.google.android.exoplayer2.DefaultControlDispatcher implements ControlDispatcher {
        public DefaultControlDispatcher() {
        }
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
        DEFAULT_CONTROL_DISPATCHER = new DefaultControlDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fastForward() {
        if (this.fastForwardMs <= 0) {
            return;
        }
        long duration = this.player.getDuration();
        long currentPosition = this.player.getCurrentPosition() + this.fastForwardMs;
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(currentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAfterTimeout() {
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

    private void requestPlayPauseFocus() {
        boolean z;
        View view2;
        View view3;
        Player player = this.player;
        if (player != null && player.getPlayWhenReady()) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (view3 = this.playButton) != null) {
            view3.requestFocus();
        } else if (z && (view2 = this.pauseButton) != null) {
            view2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewind() {
        if (this.rewindMs <= 0) {
            return;
        }
        seekTo(Math.max(this.player.getCurrentPosition() - this.rewindMs, 0L));
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeBarMode() {
        boolean z;
        Player player = this.player;
        if (player == null) {
            return;
        }
        if (this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player.getCurrentTimeline(), this.window)) {
            z = true;
        } else {
            z = false;
        }
        this.multiWindowTimeBar = z;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void hide() {
        if (isVisible()) {
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
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    public void show() {
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

    public PlaybackControlView(Context context) {
        this(context, null);
    }

    private void seekTo(long j) {
        seekTo(this.player.getCurrentWindowIndex(), j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!dispatchMediaKeyEvent(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void setControlDispatcher(@Nullable com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        if (controlDispatcher == null) {
            controlDispatcher = new com.google.android.exoplayer2.DefaultControlDispatcher();
        }
        this.controlDispatcher = controlDispatcher;
    }

    public void setFastForwardIncrementMs(int i) {
        this.fastForwardMs = i;
        updateNavigation();
    }

    public void setPlayer(Player player) {
        Player player2 = this.player;
        if (player2 == player) {
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

    public void setRewindIncrementMs(int i) {
        this.rewindMs = i;
        updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeBarMode();
    }

    public void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        updateShuffleButton();
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        this.visibilityListener = visibilityListener;
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window) {
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

    public static int getRepeatToggleModes(TypedArray typedArray, int i) {
        return typedArray.getInt(2, i);
    }

    private void seekTo(int i, long j) {
        if (!this.controlDispatcher.dispatchSeekTo(this.player, i, j)) {
            updateProgress();
        }
    }

    private void setButtonEnabled(boolean z, View view2) {
        float f;
        if (view2 == null) {
            return;
        }
        view2.setEnabled(z);
        if (z) {
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        view2.setAlpha(f);
        view2.setVisibility(0);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        } else {
            if (jArr.length == zArr.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.extraAdGroupTimesMs = jArr;
            this.extraPlayedAdGroups = zArr;
        }
        updateProgress();
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.updateProgressAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.1
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.updateProgress();
            }
        };
        this.hideAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlaybackControlView.2
            @Override // java.lang.Runnable
            public void run() {
                PlaybackControlView.this.hide();
            }
        };
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.showShuffleButton = false;
        int i2 = com.baidu.tieba.R.layout.obfuscated_res_0x7f0d02b6;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.PlaybackControlView, 0, 0);
            try {
                this.rewindMs = obtainStyledAttributes.getInt(3, this.rewindMs);
                this.fastForwardMs = obtainStyledAttributes.getInt(1, this.fastForwardMs);
                this.showTimeoutMs = obtainStyledAttributes.getInt(5, this.showTimeoutMs);
                i2 = obtainStyledAttributes.getResourceId(0, com.baidu.tieba.R.layout.obfuscated_res_0x7f0d02b6);
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
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        this.durationView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a70);
        this.positionView = (TextView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a76);
        TimeBar timeBar = (TimeBar) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a78);
        this.timeBar = timeBar;
        if (timeBar != null) {
            timeBar.addListener(this.componentListener);
        }
        View findViewById = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a75);
        this.playButton = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this.componentListener);
        }
        View findViewById2 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a74);
        this.pauseButton = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this.componentListener);
        }
        View findViewById3 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a77);
        this.previousButton = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this.componentListener);
        }
        View findViewById4 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a72);
        this.nextButton = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this.componentListener);
        }
        View findViewById5 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a7a);
        this.rewindButton = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(this.componentListener);
        }
        View findViewById6 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a71);
        this.fastForwardButton = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(this.componentListener);
        }
        ImageView imageView = (ImageView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a79);
        this.repeatToggleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this.componentListener);
        }
        View findViewById7 = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090a7b);
        this.shuffleButton = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(this.componentListener);
        }
        Resources resources = context.getResources();
        this.repeatOffButtonDrawable = resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08061b);
        this.repeatOneButtonDrawable = resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08061c);
        this.repeatAllButtonDrawable = resources.getDrawable(com.baidu.tieba.R.drawable.obfuscated_res_0x7f08061a);
        this.repeatOffButtonContentDescription = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f06d0);
        this.repeatOneButtonContentDescription = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f06d1);
        this.repeatAllButtonContentDescription = resources.getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f06cf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void next() {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r1.isSeekable == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void previous() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        View view2;
        float f;
        if (isVisible() && this.isAttachedToWindow && (view2 = this.shuffleButton) != null) {
            if (!this.showShuffleButton) {
                view2.setVisibility(8);
                return;
            }
            Player player = this.player;
            if (player == null) {
                setButtonEnabled(false, view2);
                return;
            }
            if (player.getShuffleModeEnabled()) {
                f = 1.0f;
            } else {
                f = 0.3f;
            }
            view2.setAlpha(f);
            this.shuffleButton.setEnabled(true);
            this.shuffleButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(long j) {
        int currentWindowIndex;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateNavigation() {
        Timeline timeline;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        TimeBar timeBar;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player != null) {
                timeline = player.getCurrentTimeline();
            } else {
                timeline = null;
            }
            boolean z6 = true;
            if (timeline != null && !timeline.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z && !this.player.isPlayingAd()) {
                timeline.getWindow(this.player.getCurrentWindowIndex(), this.window);
                Timeline.Window window = this.window;
                z3 = window.isSeekable;
                if (!z3 && window.isDynamic && this.player.getPreviousWindowIndex() == -1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (this.window.isDynamic || this.player.getNextWindowIndex() != -1) {
                    z4 = true;
                    setButtonEnabled(z2, this.previousButton);
                    setButtonEnabled(z4, this.nextButton);
                    if (this.fastForwardMs <= 0 && z3) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    setButtonEnabled(z5, this.fastForwardButton);
                    setButtonEnabled((this.rewindMs > 0 || !z3) ? false : false, this.rewindButton);
                    timeBar = this.timeBar;
                    if (timeBar == null) {
                        timeBar.setEnabled(z3);
                        return;
                    }
                    return;
                }
            } else {
                z2 = false;
                z3 = false;
            }
            z4 = false;
            setButtonEnabled(z2, this.previousButton);
            setButtonEnabled(z4, this.nextButton);
            if (this.fastForwardMs <= 0) {
            }
            z5 = false;
            setButtonEnabled(z5, this.fastForwardButton);
            setButtonEnabled((this.rewindMs > 0 || !z3) ? false : false, this.rewindButton);
            timeBar = this.timeBar;
            if (timeBar == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                imageView.setVisibility(8);
            } else if (this.player == null) {
                setButtonEnabled(false, imageView);
            } else {
                setButtonEnabled(true, imageView);
                int repeatMode = this.player.getRepeatMode();
                if (repeatMode != 0) {
                    if (repeatMode != 1) {
                        if (repeatMode == 2) {
                            this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                            this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
                        }
                    } else {
                        this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                        this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
                    }
                } else {
                    this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                }
                this.repeatToggleButton.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            boolean z4 = true;
            int i2 = 0;
            if (player != null && player.getPlayWhenReady()) {
                z = true;
            } else {
                z = false;
            }
            View view2 = this.playButton;
            if (view2 != null) {
                if (z && view2.isFocused()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3 | false;
                View view3 = this.playButton;
                if (z) {
                    i = 8;
                } else {
                    i = 0;
                }
                view3.setVisibility(i);
            } else {
                z2 = false;
            }
            View view4 = this.pauseButton;
            if (view4 != null) {
                z2 |= (z || !view4.isFocused()) ? false : false;
                View view5 = this.pauseButton;
                if (!z) {
                    i2 = 8;
                }
                view5.setVisibility(i2);
            }
            if (z2) {
                requestPlayPauseFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long j;
        long j2;
        int playbackState;
        long j3;
        int i;
        int i2;
        int i3;
        Timeline.Window window;
        int i4;
        int length;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            long j4 = 0;
            boolean z = true;
            if (player != null) {
                Timeline currentTimeline = player.getCurrentTimeline();
                if (!currentTimeline.isEmpty()) {
                    int currentWindowIndex = this.player.getCurrentWindowIndex();
                    if (this.multiWindowTimeBar) {
                        i2 = 0;
                    } else {
                        i2 = currentWindowIndex;
                    }
                    if (this.multiWindowTimeBar) {
                        i3 = currentTimeline.getWindowCount() - 1;
                    } else {
                        i3 = currentWindowIndex;
                    }
                    long j5 = 0;
                    j3 = 0;
                    i = 0;
                    while (true) {
                        if (i2 > i3) {
                            break;
                        }
                        if (i2 == currentWindowIndex) {
                            j3 = j5;
                        }
                        currentTimeline.getWindow(i2, this.window);
                        Timeline.Window window2 = this.window;
                        int i5 = i2;
                        if (window2.durationUs == C.TIME_UNSET) {
                            Assertions.checkState(this.multiWindowTimeBar ^ z);
                            break;
                        }
                        int i6 = window2.firstPeriodIndex;
                        while (true) {
                            window = this.window;
                            if (i6 <= window.lastPeriodIndex) {
                                currentTimeline.getPeriod(i6, this.period);
                                int adGroupCount = this.period.getAdGroupCount();
                                int i7 = 0;
                                while (i7 < adGroupCount) {
                                    long adGroupTimeUs = this.period.getAdGroupTimeUs(i7);
                                    if (adGroupTimeUs == Long.MIN_VALUE) {
                                        i4 = currentWindowIndex;
                                        long j6 = this.period.durationUs;
                                        if (j6 != C.TIME_UNSET) {
                                            adGroupTimeUs = j6;
                                        } else {
                                            i7++;
                                            currentWindowIndex = i4;
                                        }
                                    } else {
                                        i4 = currentWindowIndex;
                                    }
                                    long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
                                    if (positionInWindowUs >= 0 && positionInWindowUs <= this.window.durationUs) {
                                        long[] jArr = this.adGroupTimesMs;
                                        if (i == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.adGroupTimesMs = Arrays.copyOf(this.adGroupTimesMs, length);
                                            this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                        }
                                        this.adGroupTimesMs[i] = C.usToMs(j5 + positionInWindowUs);
                                        this.playedAdGroups[i] = this.period.hasPlayedAdGroup(i7);
                                        i++;
                                    }
                                    i7++;
                                    currentWindowIndex = i4;
                                }
                                i6++;
                            }
                        }
                        j5 += window.durationUs;
                        i2 = i5 + 1;
                        currentWindowIndex = currentWindowIndex;
                        z = true;
                    }
                    j4 = j5;
                } else {
                    j3 = 0;
                    i = 0;
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
                    int i8 = i + length2;
                    long[] jArr2 = this.adGroupTimesMs;
                    if (i8 > jArr2.length) {
                        this.adGroupTimesMs = Arrays.copyOf(jArr2, i8);
                        this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i8);
                    }
                    System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
                    System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
                    this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i8);
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
            if (player2 == null) {
                playbackState = 1;
            } else {
                playbackState = player2.getPlaybackState();
            }
            if (playbackState != 1 && playbackState != 4) {
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
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
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
                if (keyCode != 85) {
                    if (keyCode != 87) {
                        if (keyCode != 88) {
                            if (keyCode != 126) {
                                if (keyCode == 127) {
                                    this.controlDispatcher.dispatchSetPlayWhenReady(this.player, false);
                                }
                            } else {
                                this.controlDispatcher.dispatchSetPlayWhenReady(this.player, true);
                            }
                        } else {
                            previous();
                        }
                    } else {
                        next();
                    }
                } else {
                    com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.controlDispatcher;
                    Player player = this.player;
                    controlDispatcher.dispatchSetPlayWhenReady(player, !player.getPlayWhenReady());
                }
            }
        }
        return true;
    }
}
