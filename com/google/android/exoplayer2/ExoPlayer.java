package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.MediaSource;
/* loaded from: classes7.dex */
public interface ExoPlayer extends Player {
    @Deprecated
    public static final int REPEAT_MODE_ALL = 2;
    @Deprecated
    public static final int REPEAT_MODE_OFF = 0;
    @Deprecated
    public static final int REPEAT_MODE_ONE = 1;
    @Deprecated
    public static final int STATE_BUFFERING = 2;
    @Deprecated
    public static final int STATE_ENDED = 4;
    @Deprecated
    public static final int STATE_IDLE = 1;
    @Deprecated
    public static final int STATE_READY = 3;

    @Deprecated
    /* loaded from: classes7.dex */
    public interface EventListener extends Player.EventListener {
    }

    /* loaded from: classes7.dex */
    public interface ExoPlayerComponent {
        void handleMessage(int i, Object obj) throws ExoPlaybackException;
    }

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    Looper getPlaybackLooper();

    void prepare(MediaSource mediaSource);

    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    /* loaded from: classes7.dex */
    public static final class ExoPlayerMessage {
        public final Object message;
        public final int messageType;
        public final ExoPlayerComponent target;

        public ExoPlayerMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
            this.target = exoPlayerComponent;
            this.messageType = i;
            this.message = obj;
        }
    }
}
