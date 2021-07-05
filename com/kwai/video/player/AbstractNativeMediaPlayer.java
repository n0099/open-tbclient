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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public abstract class AbstractNativeMediaPlayer extends AbstractMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
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
    public KsMediaPlayer.OnAudioProcessPCMListener mOnAudioProcessPCMListener;
    public IMediaPlayer.OnLiveEventListener mOnLiveEventListener;
    public OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    public IMediaPlayer.OnVideoRawDataListener mOnVideoRawDataListener;

    /* loaded from: classes7.dex */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static /* synthetic */ Interceptable $ic;
        public static final DefaultMediaCodecSelector sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-662657510, "Lcom/kwai/video/player/AbstractNativeMediaPlayer$DefaultMediaCodecSelector;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-662657510, "Lcom/kwai/video/player/AbstractNativeMediaPlayer$DefaultMediaCodecSelector;");
                    return;
                }
            }
            sInstance = new DefaultMediaCodecSelector();
        }

        public DefaultMediaCodecSelector() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.kwai.video.player.AbstractNativeMediaPlayer.OnMediaCodecSelectListener
        @TargetApi(16)
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i2, int i3) {
            InterceptResult invokeLLII;
            String[] supportedTypes;
            KsMediaCodecInfo ksMediaCodecInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, iMediaPlayer, str, i2, i3)) == null) {
                if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(str)) {
                    Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i2), Integer.valueOf(i3)));
                    ArrayList arrayList = new ArrayList();
                    int codecCount = MediaCodecList.getCodecCount();
                    for (int i4 = 0; i4 < codecCount; i4++) {
                        MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i4);
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
            return (String) invokeLLII.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class EventHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<AbstractNativeMediaPlayer> mWeakPlayer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventHandler(AbstractNativeMediaPlayer abstractNativeMediaPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractNativeMediaPlayer, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWeakPlayer = new WeakReference<>(abstractNativeMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                AbstractNativeMediaPlayer abstractNativeMediaPlayer = this.mWeakPlayer.get();
                if (abstractNativeMediaPlayer == null || abstractNativeMediaPlayer.mNativeMediaPlayer == 0) {
                    Log.w("NativeMediaPlayer", "AbstractNativeMediaPlayer went away with unhandled events");
                } else {
                    abstractNativeMediaPlayer.onReceivePostEvent(message);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1014114424, "Lcom/kwai/video/player/AbstractNativeMediaPlayer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1014114424, "Lcom/kwai/video/player/AbstractNativeMediaPlayer;");
                return;
            }
        }
        KsMediaPlayerInitConfig.waitSoLibReady();
        TAG = AbstractNativeMediaPlayer.class.getName();
    }

    public AbstractNativeMediaPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOnLiveEventListener = null;
        this.mOnAudioProcessPCMListener = null;
        this.mOnVideoRawDataListener = null;
    }

    @CalledByNative
    public static Surface getDummySurface(Object obj) {
        InterceptResult invokeL;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            WeakReference weakReference = (WeakReference) obj;
            if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
                return null;
            }
            DummySurface newInstanceV17 = DummySurface.newInstanceV17(null, false);
            abstractNativeMediaPlayer.mDummySurface = newInstanceV17;
            return newInstanceV17;
        }
        return (Surface) invokeL.objValue;
    }

    @CalledByNative
    public static void onAudioProcessPCMReady(Object obj, ByteBuffer byteBuffer, long j, int i2, int i3, int i4) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{obj, byteBuffer, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onAudioProcessPCMListener = abstractNativeMediaPlayer.mOnAudioProcessPCMListener) == null) {
            return;
        }
        onAudioProcessPCMListener.onAudioProcessPCMAvailable(abstractNativeMediaPlayer, byteBuffer, j, i3, i2, i4);
    }

    @CalledByNative
    public static void onLiveEventCallback(Object obj, byte[] bArr) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnLiveEventListener onLiveEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, bArr) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onLiveEventListener = abstractNativeMediaPlayer.mOnLiveEventListener) == null) {
            return;
        }
        onLiveEventListener.onLiveEventChange(bArr);
    }

    @CalledByNative
    public static String onSelectCodec(Object obj, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(AdIconUtil.BAIDU_LOGO_ID, null, obj, str, i2, i3)) == null) {
            if (obj == null || !(obj instanceof WeakReference) || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
                return null;
            }
            OnMediaCodecSelectListener onMediaCodecSelectListener = abstractNativeMediaPlayer.mOnMediaCodecSelectListener;
            if (onMediaCodecSelectListener == null) {
                onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
            }
            return onMediaCodecSelectListener.onMediaCodecSelect(abstractNativeMediaPlayer, str, i2, i3);
        }
        return (String) invokeLLII.objValue;
    }

    @CalledByNative
    public static void onVideoRawDataReady(Object obj, byte[] bArr, int i2, int i3, int i4, int i5) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataAvailable(abstractNativeMediaPlayer, bArr, i2, i3, i4, i5);
    }

    @CalledByNative
    public static void onVideoRawDataSize(Object obj, int i2, int i3, int i4, int i5) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataSize(abstractNativeMediaPlayer, i2, i3, i4, i5);
    }

    @CalledByNative
    public static void postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj2}) == null) || obj == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i2 == 200 && i3 == 2) {
            abstractNativeMediaPlayer.start();
        }
        EventHandler eventHandler = abstractNativeMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            abstractNativeMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i2, i3, i4, obj2));
        }
    }

    @CalledByNative
    public static void postFftDataNative(Object obj, float[] fArr) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, obj, fArr) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return;
        }
        abstractNativeMediaPlayer.notifyOnFftDataCapture(fArr);
    }

    @CalledByNative
    public static void releaseDummySurface(Object obj) {
        WeakReference weakReference;
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Surface surface;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, obj) == null) || (weakReference = (WeakReference) obj) == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (surface = abstractNativeMediaPlayer.mDummySurface) == null) {
            return;
        }
        surface.release();
        abstractNativeMediaPlayer.mDummySurface = null;
    }

    public abstract void enableVideoRawDataCallback(boolean z);

    public void initPlayer() {
        EventHandler eventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    public abstract void initProcessPCMBuffer();

    public abstract void onReceivePostEvent(Message message);

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mEventHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer
    public void resetListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.resetListeners();
            this.mOnLiveEventListener = null;
            this.mOnAudioProcessPCMListener = null;
            this.mOnVideoRawDataListener = null;
            this.mOnMediaCodecSelectListener = null;
        }
    }

    public void setOnAudioProcessPCMAvailableListener(KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onAudioProcessPCMListener) == null) {
            this.mOnAudioProcessPCMListener = onAudioProcessPCMListener;
            initProcessPCMBuffer();
        }
    }

    public void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLiveEventListener) == null) {
            this.mOnLiveEventListener = onLiveEventListener;
        }
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onMediaCodecSelectListener) == null) {
            this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onVideoRawDataListener) == null) {
            this.mOnVideoRawDataListener = onVideoRawDataListener;
            enableVideoRawDataCallback(onVideoRawDataListener != null);
        }
    }
}
