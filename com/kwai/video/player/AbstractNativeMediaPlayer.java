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
/* loaded from: classes5.dex */
public abstract class AbstractNativeMediaPlayer extends AbstractMediaPlayer {
    private static final String TAG;
    @AccessedByNative
    private Surface mDummySurface;
    private EventHandler mEventHandler;
    @AccessedByNative
    private int mListenerContext;
    @AccessedByNative
    private long mNativeMediaDataSource;
    @AccessedByNative
    protected long mNativeMediaPlayer;
    @AccessedByNative
    private int mNativeSurfaceTexture;
    OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    protected IMediaPlayer.OnLiveEventListener mOnLiveEventListener = null;
    protected KsMediaPlayer.OnAudioProcessPCMListener mOnAudioProcessPCMListener = null;
    protected IMediaPlayer.OnVideoRawDataListener mOnVideoRawDataListener = null;

    /* loaded from: classes5.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // com.kwai.video.player.AbstractNativeMediaPlayer.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            KsMediaCodecInfo ksMediaCodecInfo;
            String[] supportedTypes;
            KsMediaCodecInfo ksMediaCodecInfo2;
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
                                if (str2.equalsIgnoreCase(str) && (ksMediaCodecInfo2 = KsMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                    arrayList.add(ksMediaCodecInfo2);
                                    Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ksMediaCodecInfo2.mRank)));
                                    ksMediaCodecInfo2.dumpProfileLevels(str);
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                KsMediaCodecInfo ksMediaCodecInfo3 = (KsMediaCodecInfo) arrayList.get(0);
                Iterator it = arrayList.iterator();
                while (true) {
                    ksMediaCodecInfo = ksMediaCodecInfo3;
                    if (!it.hasNext()) {
                        break;
                    }
                    ksMediaCodecInfo3 = (KsMediaCodecInfo) it.next();
                    if (ksMediaCodecInfo3.mRank <= ksMediaCodecInfo.mRank) {
                        ksMediaCodecInfo3 = ksMediaCodecInfo;
                    }
                }
                if (ksMediaCodecInfo.mRank < 600) {
                    Log.w(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ksMediaCodecInfo.mCodecInfo.getName()));
                    return null;
                }
                Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ksMediaCodecInfo.mCodecInfo.getName(), Integer.valueOf(ksMediaCodecInfo.mRank)));
                return ksMediaCodecInfo.mCodecInfo.getName();
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class EventHandler extends Handler {
        private final WeakReference<AbstractNativeMediaPlayer> mWeakPlayer;

        EventHandler(AbstractNativeMediaPlayer abstractNativeMediaPlayer, Looper looper) {
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

    /* loaded from: classes5.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    static {
        KsMediaPlayerInitConfig.waitSoLibReady();
        TAG = AbstractNativeMediaPlayer.class.getName();
    }

    @CalledByNative
    private static Surface getDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return null;
        }
        abstractNativeMediaPlayer.mDummySurface = DummySurface.newInstanceV17(null, false);
        return abstractNativeMediaPlayer.mDummySurface;
    }

    @CalledByNative
    private static void onAudioProcessPCMReady(Object obj, ByteBuffer byteBuffer, long j, int i, int i2, int i3) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || abstractNativeMediaPlayer.mOnAudioProcessPCMListener == null) {
            return;
        }
        abstractNativeMediaPlayer.mOnAudioProcessPCMListener.onAudioProcessPCMAvailable(abstractNativeMediaPlayer, byteBuffer, j, i2, i, i3);
    }

    @CalledByNative
    private static void onLiveEventCallback(Object obj, byte[] bArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || abstractNativeMediaPlayer.mOnLiveEventListener == null) {
            return;
        }
        abstractNativeMediaPlayer.mOnLiveEventListener.onLiveEventChange(bArr);
    }

    @CalledByNative
    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        if (obj == null || !(obj instanceof WeakReference)) {
            return null;
        }
        AbstractNativeMediaPlayer abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get();
        if (abstractNativeMediaPlayer == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = abstractNativeMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(abstractNativeMediaPlayer, str, i, i2);
    }

    @CalledByNative
    private static void onVideoRawDataReady(Object obj, byte[] bArr, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || abstractNativeMediaPlayer.mOnVideoRawDataListener == null) {
            return;
        }
        abstractNativeMediaPlayer.mOnVideoRawDataListener.onVideoRawDataAvailable(abstractNativeMediaPlayer, bArr, i, i2, i3, i4);
    }

    @CalledByNative
    private static void onVideoRawDataSize(Object obj, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || abstractNativeMediaPlayer.mOnVideoRawDataListener == null) {
            return;
        }
        abstractNativeMediaPlayer.mOnVideoRawDataListener.onVideoRawDataSize(abstractNativeMediaPlayer, i, i2, i3, i4);
    }

    @CalledByNative
    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        if (obj == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            abstractNativeMediaPlayer.start();
        }
        if (abstractNativeMediaPlayer.mEventHandler != null) {
            abstractNativeMediaPlayer.mEventHandler.sendMessage(abstractNativeMediaPlayer.mEventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    @CalledByNative
    private static void postFftDataNative(Object obj, float[] fArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return;
        }
        abstractNativeMediaPlayer.notifyOnFftDataCapture(fArr);
    }

    @CalledByNative
    private static void releaseDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || abstractNativeMediaPlayer.mDummySurface == null) {
            return;
        }
        abstractNativeMediaPlayer.mDummySurface.release();
        abstractNativeMediaPlayer.mDummySurface = null;
    }

    protected abstract void enableVideoRawDataCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPlayer() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new EventHandler(this, mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    protected abstract void initProcessPCMBuffer();

    protected abstract void onReceivePostEvent(Message message);

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        this.mEventHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        if (onVideoRawDataListener == null) {
            enableVideoRawDataCallback(false);
        } else {
            enableVideoRawDataCallback(true);
        }
    }
}
