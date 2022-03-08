package com.google.android.exoplayer2;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        void handleMessage(int i2, Object obj) throws ExoPlaybackException;
    }

    /* loaded from: classes7.dex */
    public static final class ExoPlayerMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object message;
        public final int messageType;
        public final ExoPlayerComponent target;

        public ExoPlayerMessage(ExoPlayerComponent exoPlayerComponent, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exoPlayerComponent, Integer.valueOf(i2), obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.target = exoPlayerComponent;
            this.messageType = i2;
            this.message = obj;
        }
    }

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    Looper getPlaybackLooper();

    void prepare(MediaSource mediaSource);

    void prepare(MediaSource mediaSource, boolean z, boolean z2);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);
}
