package com.kwai.player.live;

import androidx.annotation.Keep;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.annotations.CalledByNative;
import java.lang.ref.WeakReference;
@Keep
/* loaded from: classes7.dex */
public class KwaiPlayerLiveListenerBridge {
    public static IKwaiMediaPlayer.OnLiveInterActiveListener getListener(Object obj) {
        if (obj == null) {
            return null;
        }
        return (IKwaiMediaPlayer.OnLiveInterActiveListener) ((WeakReference) obj).get();
    }

    @CalledByNative
    public static void onParseAdSei(Object obj, long j, int i2, String str) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onParseAdSei(j, i2, str);
        }
    }

    @CalledByNative
    public static void onTsptInfo(Object obj, byte[] bArr, int i2) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onTsptInfo(bArr, i2);
        }
    }

    @CalledByNative
    public static void onVideoFrameRender(Object obj, long j) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onVideoFrameRender(j);
        }
    }
}
