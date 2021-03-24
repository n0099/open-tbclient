package com.kwai.video.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.annotations.AccessedByNative;
import com.kwai.video.player.annotations.CalledByNative;
import com.kwai.video.player.surface.DummySurface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes6.dex */
public abstract class AbstractNativeMediaPlayer extends AbstractMediaPlayer {
    public static final String TAG;
    @AccessedByNative
    public Surface mDummySurface;
    public EventHandler mEventHandler;
    @AccessedByNative
    public int mListenerContext;
    @AccessedByNative
    public long mNativeMediaDataSource;
    @AccessedByNative
    public long mNativeMediaPlayer;
    @AccessedByNative
    public int mNativeSurfaceTexture;
    public OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    public IMediaPlayer.OnLiveEventListener mOnLiveEventListener = null;
    public KsMediaPlayer.OnAudioProcessPCMListener mOnAudioProcessPCMListener = null;
    public IMediaPlayer.OnVideoRawDataListener mOnVideoRawDataListener = null;

    /* loaded from: classes6.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // com.kwai.video.player.AbstractNativeMediaPlayer.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String[] supportedTypes;
            KsMediaCodecInfo ksMediaCodecInfo;
            if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str)) {
                Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                for (int i3 = 0; i3 < codecCount; i3++) {
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                    Log.d(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                    if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                        for (String str2 : supportedTypes) {
                            if (!TextUtils.isEmpty(str2)) {
                                Log.d(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "    mime: %s", str2));
                                if (str2.equalsIgnoreCase(str) && (ksMediaCodecInfo = KsMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                    arrayList.add(ksMediaCodecInfo);
                                    Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ksMediaCodecInfo.mRank)));
                                    ksMediaCodecInfo.dumpProfileLevels(str);
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                KsMediaCodecInfo ksMediaCodecInfo2 = (KsMediaCodecInfo) arrayList.get(0);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    KsMediaCodecInfo ksMediaCodecInfo3 = (KsMediaCodecInfo) it.next();
                    if (ksMediaCodecInfo3.mRank > ksMediaCodecInfo2.mRank) {
                        ksMediaCodecInfo2 = ksMediaCodecInfo3;
                    }
                }
                if (ksMediaCodecInfo2.mRank < 600) {
                    Log.w(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ksMediaCodecInfo2.mCodecInfo.getName()));
                    return null;
                }
                Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ksMediaCodecInfo2.mCodecInfo.getName(), Integer.valueOf(ksMediaCodecInfo2.mRank)));
                return ksMediaCodecInfo2.mCodecInfo.getName();
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class EventHandler extends Handler {
        public final WeakReference<AbstractNativeMediaPlayer> mWeakPlayer;

        public EventHandler(AbstractNativeMediaPlayer abstractNativeMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(abstractNativeMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractNativeMediaPlayer abstractNativeMediaPlayer = this.mWeakPlayer.get();
            if (abstractNativeMediaPlayer == null || abstractNativeMediaPlayer.mNativeMediaPlayer == 0) {
                Log.w("NativeMediaPlayer", "AbstractNativeMediaPlayer went away with unhandled events");
            } else {
                abstractNativeMediaPlayer.onReceivePostEvent(message);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    static {
        KsMediaPlayerInitConfig.waitSoLibReady();
        TAG = AbstractNativeMediaPlayer.class.getName();
    }

    @CalledByNative
    public static Surface getDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return null;
        }
        DummySurface newInstanceV17 = DummySurface.newInstanceV17(null, false);
        abstractNativeMediaPlayer.mDummySurface = newInstanceV17;
        return newInstanceV17;
    }

    @CalledByNative
    public static void onAudioProcessPCMReady(Object obj, ByteBuffer byteBuffer, long j, int i, int i2, int i3) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onAudioProcessPCMListener = abstractNativeMediaPlayer.mOnAudioProcessPCMListener) == null) {
            return;
        }
        onAudioProcessPCMListener.onAudioProcessPCMAvailable(abstractNativeMediaPlayer, byteBuffer, j, i2, i, i3);
    }

    @CalledByNative
    public static void onLiveEventCallback(Object obj, byte[] bArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnLiveEventListener onLiveEventListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onLiveEventListener = abstractNativeMediaPlayer.mOnLiveEventListener) == null) {
            return;
        }
        onLiveEventListener.onLiveEventChange(bArr);
    }

    @CalledByNative
    public static String onSelectCodec(Object obj, String str, int i, int i2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = abstractNativeMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(abstractNativeMediaPlayer, str, i, i2);
    }

    @CalledByNative
    public static void onVideoRawDataReady(Object obj, byte[] bArr, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataAvailable(abstractNativeMediaPlayer, bArr, i, i2, i3, i4);
    }

    @CalledByNative
    public static void onVideoRawDataSize(Object obj, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataSize(abstractNativeMediaPlayer, i, i2, i3, i4);
    }

    @CalledByNative
    public static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        if (obj == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            abstractNativeMediaPlayer.start();
        }
        EventHandler eventHandler = abstractNativeMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            abstractNativeMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    @CalledByNative
    public static void postFftDataNative(Object obj, float[] fArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return;
        }
        abstractNativeMediaPlayer.notifyOnFftDataCapture(fArr);
    }

    @CalledByNative
    public static void releaseDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Surface surface;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (surface = abstractNativeMediaPlayer.mDummySurface) == null) {
            return;
        }
        surface.release();
        abstractNativeMediaPlayer.mDummySurface = null;
    }

    public abstract void enableVideoRawDataCallback(boolean z);

    public void initPlayer() {
        EventHandler eventHandler;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            eventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.mEventHandler = null;
                return;
            }
            eventHandler = new EventHandler(this, mainLooper);
        }
        this.mEventHandler = eventHandler;
    }

    public abstract void initProcessPCMBuffer();

    public abstract void onReceivePostEvent(Message message);

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        this.mEventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnLiveEventListener = null;
        this.mOnAudioProcessPCMListener = null;
        this.mOnVideoRawDataListener = null;
        this.mOnMediaCodecSelectListener = null;
    }

    public void setOnAudioProcessPCMAvailableListener(KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener) {
        this.mOnAudioProcessPCMListener = onAudioProcessPCMListener;
        initProcessPCMBuffer();
    }

    public void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener) {
        this.mOnLiveEventListener = onLiveEventListener;
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
        this.mOnVideoRawDataListener = onVideoRawDataListener;
        enableVideoRawDataCallback(onVideoRawDataListener != null);
    }
}
