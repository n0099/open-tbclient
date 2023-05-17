package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.widget.TextView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import java.util.Locale;
/* loaded from: classes9.dex */
public final class DebugTextViewHelper extends Player.DefaultEventListener implements Runnable {
    public static final int REFRESH_INTERVAL_MS = 1000;
    public final SimpleExoPlayer player;
    public boolean started;
    public final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView) {
        this.player = simpleExoPlayer;
        this.textView = textView;
    }

    @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        updateAndPost();
    }

    private String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        if (audioFormat == null) {
            return "";
        }
        return "\n" + audioFormat.sampleMimeType + "(id:" + audioFormat.id + " hz:" + audioFormat.sampleRate + " ch:" + audioFormat.channelCount + getDecoderCountersBufferCountString(this.player.getAudioDecoderCounters()) + SmallTailInfo.EMOTION_SUFFIX;
    }

    private String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        if (videoFormat == null) {
            return "";
        }
        return "\n" + videoFormat.sampleMimeType + "(id:" + videoFormat.id + " r:" + videoFormat.width + "x" + videoFormat.height + getPixelAspectRatioString(videoFormat.pixelWidthHeightRatio) + getDecoderCountersBufferCountString(this.player.getVideoDecoderCounters()) + SmallTailInfo.EMOTION_SUFFIX;
    }

    public static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        return " sib:" + decoderCounters.skippedInputBufferCount + " sb:" + decoderCounters.skippedOutputBufferCount + " rb:" + decoderCounters.renderedOutputBufferCount + " db:" + decoderCounters.droppedBufferCount + " mcdb:" + decoderCounters.maxConsecutiveDroppedBufferCount + " dk:" + decoderCounters.droppedToKeyframeCount;
    }

    public static String getPixelAspectRatioString(float f) {
        if (f != -1.0f && f != 1.0f) {
            return " par:" + String.format(Locale.US, "%.02f", Float.valueOf(f));
        }
        return "";
    }

    private String getPlayerStateString() {
        String str = "playWhenReady:" + this.player.getPlayWhenReady() + " playbackState:";
        int playbackState = this.player.getPlaybackState();
        if (playbackState != 1) {
            if (playbackState != 2) {
                if (playbackState != 3) {
                    if (playbackState != 4) {
                        return str + "unknown";
                    }
                    return str + "ended";
                }
                return str + "ready";
            }
            return str + "buffering";
        }
        return str + "idle";
    }

    private String getPlayerWindowIndexString() {
        return " window:" + this.player.getCurrentWindowIndex();
    }

    @Override // java.lang.Runnable
    public void run() {
        updateAndPost();
    }

    public void start() {
        if (this.started) {
            return;
        }
        this.started = true;
        this.player.addListener(this);
        updateAndPost();
    }

    public void stop() {
        if (!this.started) {
            return;
        }
        this.started = false;
        this.player.removeListener(this);
        this.textView.removeCallbacks(this);
    }

    @SuppressLint({"SetTextI18n"})
    private void updateAndPost() {
        TextView textView = this.textView;
        textView.setText(getPlayerStateString() + getPlayerWindowIndexString() + getVideoString() + getAudioString());
        this.textView.removeCallbacks(this);
        this.textView.postDelayed(this, 1000L);
    }

    @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i) {
        updateAndPost();
    }
}
