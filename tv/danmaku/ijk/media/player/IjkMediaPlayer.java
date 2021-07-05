package tv.danmaku.ijk.media.player;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Rect;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.DeviceInfoUtils;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.UbcSessionUploader;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.media.duplayer.DuplayerCore;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.Utils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes2.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean s;
    public static volatile boolean t;
    public static volatile boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f76771a;

    /* renamed from: b  reason: collision with root package name */
    public b f76772b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f76773c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76774d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f76775e;

    /* renamed from: f  reason: collision with root package name */
    public int f76776f;

    /* renamed from: g  reason: collision with root package name */
    public int f76777g;

    /* renamed from: h  reason: collision with root package name */
    public int f76778h;

    /* renamed from: i  reason: collision with root package name */
    public int f76779i;
    public long j;
    public long k;
    public String l;
    public CyberPlayerManager.HttpDNS m;
    @Keep
    public int mListenerContext;
    @Keep
    public long mNativeAndroidIO;
    @Keep
    public long mNativeMediaDataSource;
    @Keep
    public long mNativeMediaPlayer;
    @Keep
    public int mNativeSurfaceTexture;
    public DuplayerHandlerThread n;
    public f o;
    public volatile boolean p;
    public boolean q;
    public int r;
    public c v;
    public e w;
    public d x;

    /* loaded from: classes2.dex */
    public static class a implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f76780a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1589103546, "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1589103546, "Ltv/danmaku/ijk/media/player/IjkMediaPlayer$a;");
                    return;
                }
            }
            f76780a = new a();
        }

        public a() {
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

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.d
        @TargetApi(16)
        public String a(tv.danmaku.ijk.media.player.b bVar, String str, int i2, int i3) {
            InterceptResult invokeLLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, bVar, str, i2, i3)) == null) ? d.a.b0.a.d.b(str) : (String) invokeLLII.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f76781a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ijkMediaPlayer, looper};
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
            this.f76781a = new WeakReference<>(ijkMediaPlayer);
        }

        private String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("start_prepare", "1");
                    hashMap.put("open_input", "2");
                    hashMap.put("dns", "3");
                    hashMap.put("first_connect", "4");
                    hashMap.put("first_response", "5");
                    hashMap.put("find_st_info", "6");
                    hashMap.put("init_audio", "7");
                    hashMap.put("init_video", "8");
                    hashMap.put(DpStatConstants.KEY_PREPARED, "9");
                    hashMap.put("start_play", "10");
                    hashMap.put("frame_decoded", "11");
                    hashMap.put("render_pic", "12");
                    hashMap.put(DpStatConstants.KEY_FIRST_DISPLAY, "13");
                    hashMap.put("kernel_total", "14");
                    hashMap.put("client_total", Constants.VIA_REPORT_TYPE_WPA_STATE);
                    JSONObject jSONObject2 = new JSONObject(str);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String str2 = (String) hashMap.get(next);
                        if (str2 != null) {
                            jSONObject.put(String.format("P3%s_%s", str2, next), jSONObject2.getString(next));
                        }
                    }
                    jSONObject.put("first_disp_notify_time", "" + System.currentTimeMillis());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                IjkMediaPlayer ijkMediaPlayer = this.f76781a.get();
                if (ijkMediaPlayer != null) {
                    if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                        int i3 = message.what;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ijkMediaPlayer.b();
                                ijkMediaPlayer.b(10005, 0, (Object) null);
                                return;
                            } else if (i3 == 2) {
                                ijkMediaPlayer.e(false);
                                ijkMediaPlayer.b(10004, 0, (Object) null);
                                ijkMediaPlayer.c();
                                return;
                            } else if (i3 == 3) {
                                long j = message.arg1;
                                if (j < 0) {
                                    j = 0;
                                }
                                long o = ijkMediaPlayer.o();
                                long j2 = o > 0 ? (j * 100) / o : 0L;
                                ijkMediaPlayer.a((int) (j2 < 100 ? j2 : 100L));
                                return;
                            } else if (i3 == 4) {
                                ijkMediaPlayer.d();
                                return;
                            } else if (i3 == 5) {
                                ijkMediaPlayer.f76776f = message.arg1;
                                ijkMediaPlayer.f76777g = message.arg2;
                                ijkMediaPlayer.a(ijkMediaPlayer.f76776f, ijkMediaPlayer.f76777g, ijkMediaPlayer.f76778h, ijkMediaPlayer.f76779i);
                                ijkMediaPlayer.b(10006, 0, (Object) null);
                                return;
                            } else if (i3 == 99) {
                                if (message.obj == null) {
                                    ijkMediaPlayer.a((tv.danmaku.ijk.media.player.c) null);
                                    return;
                                } else {
                                    ijkMediaPlayer.a(new tv.danmaku.ijk.media.player.c(new Rect(0, 0, 1, 1), (String) message.obj));
                                    return;
                                }
                            } else if (i3 == 100) {
                                CyberLog.i("IjkMediaPlayer", "Error (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                                ijkMediaPlayer.b(10007, 0, (Object) null);
                                if (!ijkMediaPlayer.a(message.arg1, message.arg2, message.obj)) {
                                    ijkMediaPlayer.c();
                                }
                                CyberLog.i("IjkMediaPlayer", "MEDIA_ERROR called stop release");
                                ijkMediaPlayer.i();
                                ijkMediaPlayer.p();
                                ijkMediaPlayer.e(false);
                                return;
                            } else if (i3 != 200) {
                                if (i3 == 300) {
                                    ijkMediaPlayer.c(message.arg1, message.arg2, message.obj);
                                    return;
                                } else if (i3 != 953) {
                                    switch (i3) {
                                        case IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL /* 60001 */:
                                            ijkMediaPlayer.f76778h = message.arg1;
                                            ijkMediaPlayer.f76779i = message.arg2;
                                            ijkMediaPlayer.a(ijkMediaPlayer.f76776f, ijkMediaPlayer.f76777g, ijkMediaPlayer.f76778h, ijkMediaPlayer.f76779i);
                                            return;
                                        case IMConstants.ERROR_GROUP_NAME_NOT_VALID /* 60002 */:
                                            ijkMediaPlayer.b(message.arg1 | (message.arg2 << 32));
                                            return;
                                        default:
                                            CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                                            return;
                                    }
                                } else {
                                    int i4 = message.arg1;
                                    int i5 = message.arg2;
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("audio_duration", i4);
                                        jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, i5);
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                    CyberLog.d("IjkMediaPlayer", "DP_MSG_INFO_CACHE_DURATION audioDuration:" + i4 + " videoDuration:" + i5);
                                    ijkMediaPlayer.b(CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION, i5, jSONObject.toString());
                                    return;
                                }
                            } else {
                                int i6 = message.arg1;
                                if (i6 == 3) {
                                    CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                                    Object obj = message.obj;
                                    if (obj != null) {
                                        str = a((String) obj);
                                        i2 = message.arg2;
                                    } else {
                                        i2 = message.arg2;
                                        str = "";
                                    }
                                    ijkMediaPlayer.b(904, i2, str);
                                    return;
                                } else if (i6 == 910) {
                                    ijkMediaPlayer.a(message.arg2);
                                    ijkMediaPlayer.b(message.arg1, message.arg2, message.obj);
                                    return;
                                } else if (i6 == 931) {
                                    CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_SERVER_CHANGE server : " + ((String) message.obj));
                                    ijkMediaPlayer.b(5000, message.arg2, message.obj);
                                    return;
                                } else if (i6 != 12002) {
                                    ijkMediaPlayer.b(i6, message.arg2, message.obj);
                                    return;
                                } else {
                                    CyberLog.d("IjkMediaPlayer", "DP_MEDIA_INFO_SR_REMAINING_NB:" + message.arg2);
                                    CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SR_REMAINING_INFO, System.currentTimeMillis() + ";" + message.arg2);
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
                CyberLog.w("IjkMediaPlayer", "IjkMediaPlayer went away with unhandled events");
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        String a(int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        String a(tv.danmaku.ijk.media.player.b bVar, String str, int i2, int i3);
    }

    /* loaded from: classes2.dex */
    public interface e {
        boolean a(int i2, Bundle bundle);
    }

    /* loaded from: classes2.dex */
    public static class f extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f76782a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ijkMediaPlayer, looper};
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
            this.f76782a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                IjkMediaPlayer ijkMediaPlayer = this.f76782a.get();
                if (ijkMediaPlayer == null || (ijkMediaPlayer.mNativeMediaPlayer == 0 && message.what != 12)) {
                    CyberLog.w("IjkMediaPlayer", "IjkMediaPlayer went away with unhandled events msg.what:" + message.what);
                    return;
                }
                try {
                    switch (message.what) {
                        case 1:
                            ijkMediaPlayer._stop();
                            return;
                        case 2:
                            ijkMediaPlayer._release();
                            return;
                        case 3:
                            ijkMediaPlayer._reset();
                            ijkMediaPlayer.a(0L);
                            ijkMediaPlayer.b(0L);
                            return;
                        case 4:
                            ijkMediaPlayer.native_finalize();
                            return;
                        case 5:
                            return;
                        case 6:
                            ijkMediaPlayer._pause();
                            return;
                        case 7:
                            ijkMediaPlayer._start();
                            return;
                        case 8:
                            Object obj = message.obj;
                            if (obj != null && (obj instanceof String)) {
                                ijkMediaPlayer._setDataSource((String) obj, null, null);
                                break;
                            } else {
                                return;
                            }
                            break;
                        case 9:
                            Object obj2 = message.obj;
                            if (obj2 == null || !(obj2 instanceof ArrayList)) {
                                return;
                            }
                            ArrayList arrayList = (ArrayList) obj2;
                            ijkMediaPlayer._setStatisticInfo(message.arg1, (String) arrayList.get(0), (String) arrayList.get(1));
                            return;
                        case 10:
                            ijkMediaPlayer._prepareAsync();
                            return;
                        case 11:
                            Object obj3 = message.obj;
                            if (obj3 == null || !(obj3 instanceof Long)) {
                                return;
                            }
                            ijkMediaPlayer.nativeSeekTo(((Long) obj3).longValue(), message.arg1);
                            return;
                        case 12:
                            ijkMediaPlayer.native_setup(new WeakReference(ijkMediaPlayer));
                            return;
                        case 13:
                            ijkMediaPlayer.l(ijkMediaPlayer);
                            return;
                        case 14:
                            Object obj4 = message.obj;
                            if (obj4 == null || !(obj4 instanceof Surface)) {
                                ijkMediaPlayer._setVideoSurface(null);
                                return;
                            } else {
                                ijkMediaPlayer._setVideoSurface((Surface) obj4);
                                return;
                            }
                        case 15:
                            Object obj5 = message.obj;
                            if (obj5 != null && (obj5 instanceof FileDescriptor)) {
                                ijkMediaPlayer.a((FileDescriptor) obj5);
                                break;
                            } else {
                                return;
                            }
                            break;
                        case 16:
                            ijkMediaPlayer._setLoopCount(message.arg1);
                            return;
                        case 17:
                            Object obj6 = message.obj;
                            if (obj6 == null || !(obj6 instanceof ArrayList)) {
                                return;
                            }
                            ArrayList arrayList2 = (ArrayList) obj6;
                            ijkMediaPlayer._setOption(message.arg1, (String) arrayList2.get(0), (String) arrayList2.get(1));
                            return;
                        case 18:
                            Object obj7 = message.obj;
                            if (obj7 == null || !(obj7 instanceof ArrayList)) {
                                return;
                            }
                            ArrayList arrayList3 = (ArrayList) obj7;
                            ijkMediaPlayer._setOption(message.arg1, (String) arrayList3.get(0), Long.valueOf((String) arrayList3.get(1)).longValue());
                            return;
                        case 19:
                            ijkMediaPlayer._setUserHasClickStart(message.arg1 == 1);
                            return;
                        case 20:
                            ijkMediaPlayer._muteOrUnmuteAudio(message.arg1 == 1);
                            return;
                        case 21:
                            Object obj8 = message.obj;
                            if (obj8 == null || !(obj8 instanceof String)) {
                                IjkMediaPlayer._changeHttpProxy(null, "false");
                                return;
                            } else {
                                IjkMediaPlayer._changeHttpProxy((String) obj8, message.arg1 == 1 ? "true" : "false");
                                return;
                            }
                        case 22:
                            Bundle data = message.getData();
                            if (data != null) {
                                float f2 = data.getFloat(CustomDialogData.POS_LEFT);
                                float f3 = data.getFloat("right");
                                CyberLog.i("IjkMediaPlayer", "_setVolume leftVolume:" + f2 + " rightVolume:" + f3);
                                ijkMediaPlayer._setVolume(f2, f3);
                                return;
                            }
                            return;
                        case 23:
                            Object obj9 = message.obj;
                            if (obj9 == null || !(obj9 instanceof Float)) {
                                return;
                            }
                            ijkMediaPlayer._setPropertyFloat(message.arg1, ((Float) obj9).floatValue());
                            return;
                        case 24:
                            Object obj10 = message.obj;
                            if (obj10 != null) {
                                ArrayList arrayList4 = (ArrayList) obj10;
                                ijkMediaPlayer.c((Context) arrayList4.get(0), (Uri) arrayList4.get(1));
                                break;
                            } else {
                                return;
                            }
                        case 25:
                            Object obj11 = message.obj;
                            if (obj11 == null || !(obj11 instanceof ArrayList)) {
                                return;
                            }
                            ArrayList arrayList5 = (ArrayList) obj11;
                            ijkMediaPlayer._setExternalInfo((String) arrayList5.get(0), message.arg1, Long.valueOf((String) arrayList5.get(1)).longValue(), (String) arrayList5.get(2));
                            return;
                        case 26:
                            CyberLog.i("IjkMediaPlayer", "REQ_SET_PLAY_JSON");
                            Object obj12 = message.obj;
                            if (obj12 == null || !(obj12 instanceof String)) {
                                return;
                            }
                            CyberLog.i("IjkMediaPlayer", "REQ_SET_PLAY_JSON " + ((String) message.obj));
                            ijkMediaPlayer.nativeSetPlayJson((String) message.obj);
                            return;
                        case 27:
                            CyberLog.i("IjkMediaPlayer", "REQ_SET_CLARITY_INFO");
                            Object obj13 = message.obj;
                            if (obj13 == null || !(obj13 instanceof String)) {
                                return;
                            }
                            CyberLog.i("IjkMediaPlayer", "REQ_SET_CLARITY_INFO " + ((String) message.obj));
                            ijkMediaPlayer.nativeSetClarityInfo((String) message.obj);
                            return;
                        case 28:
                            CyberLog.i("IjkMediaPlayer", "REQ_SET_DISPLAY_SIZE width: " + message.arg1 + ", height:" + message.arg2);
                            ijkMediaPlayer.nativeUpdateDisplaySize(message.arg1, message.arg2);
                            return;
                        default:
                            CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                            return;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-846345373, "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-846345373, "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;");
        }
    }

    public IjkMediaPlayer() {
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
        this.f76773c = null;
        this.p = false;
        v();
    }

    public static int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? 8 - CyberLog.getLogLevel() : invokeV.intValue;
    }

    public static native void _changeHttpProxy(String str, String str2);

    private native String _getAudioCodecInfo();

    public static native String _getColorFormatName(int i2);

    private native long _getCurrentPosition();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i2, float f2);

    private native long _getPropertyLong(int i2, long j);

    private native String _getVideoCodecInfo();

    private native void _injectCacheNode(int i2, long j, long j2, long j3, long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _muteOrUnmuteAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _pause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _release();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _reset();

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSourceFd(int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setExternalInfo(String str, int i2, long j, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setLoopCount(int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i2, String str, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setPropertyFloat(int i2, float f2);

    private native void _setPropertyLong(int i2, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setStatisticInfo(int i2, String str, String str2);

    private native void _setStreamSelected(int i2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setUserHasClickStart(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setVideoSurface(Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setVolume(float f2, float f3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _start();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _stop();

    private boolean a(int i2, int i3, int i4, Object obj) {
        InterceptResult invokeCommon;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65587, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) {
            if (this.q) {
                if (!this.p || (fVar = this.o) == null) {
                    return true;
                }
                this.o.sendMessage(fVar.obtainMessage(i2, i3, i4, obj));
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean b(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65593, this, context, uri)) == null) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7745a);
                if (openAssetFileDescriptor == null) {
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    return false;
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                return true;
            } catch (IOException | SecurityException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, this, context, uri) == null) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7745a);
                if (openAssetFileDescriptor == null) {
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                        return;
                    }
                    return;
                }
                a(openAssetFileDescriptor.getFileDescriptor());
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } catch (IOException unused) {
                if (0 == 0) {
                    return;
                }
                assetFileDescriptor.close();
            } catch (SecurityException unused2) {
                if (0 == 0) {
                    return;
                }
                assetFileDescriptor.close();
            } catch (Throwable th) {
                if (0 != 0) {
                    assetFileDescriptor.close();
                }
                throw th;
            }
        }
    }

    private boolean d(int i2) {
        InterceptResult invokeI;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65600, this, i2)) == null) {
            if (this.q) {
                if (!this.p || (fVar = this.o) == null) {
                    return true;
                }
                fVar.sendEmptyMessage(i2);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, null) == null) {
            synchronized (IjkMediaPlayer.class) {
                if (!t) {
                    native_init();
                    native_setLogLevel(A());
                    t = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65604, this, z) == null) {
            PowerManager.WakeLock wakeLock = this.f76773c;
            if (wakeLock != null) {
                if (z && !wakeLock.isHeld()) {
                    this.f76773c.acquire();
                } else if (!z && this.f76773c.isHeld()) {
                    this.f76773c.release();
                }
            }
            this.f76775e = z;
            x();
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65605, null) == null) {
            synchronized (IjkMediaPlayer.class) {
                if (!u) {
                    Context applicationContext = CyberPlayerManager.getApplicationContext();
                    PackageManager packageManager = applicationContext.getPackageManager();
                    String packageName = applicationContext.getPackageName();
                    String appVerionName = CyberPlayerManager.getAppVerionName();
                    String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
                    String sDKVersion = CyberPlayerManager.getSDKVersion();
                    String k = Utils.k(applicationContext);
                    if (appVerionName == null && packageManager != null) {
                        try {
                            appVerionName = packageManager.getPackageInfo(packageName, 0).versionName;
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    }
                    DuplayerCore.nativeStatisticInit(packageName, appVerionName, sDKVersion, SDKVersion.VERSION, k, CyberPlayerManager.getClientID(), networkStatisticsData, CyberPlayerManager.getInstallOpts().get("abtest_sid"));
                    long currentTimeMillis = System.currentTimeMillis();
                    DuplayerCore.nativeSetInfo("model", Build.MODEL);
                    DuplayerCore.nativeSetInfo(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                    DuplayerCore.nativeSetInfo(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                    DuplayerCore.nativeSetInfo("os_type", "Android");
                    boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMO, false);
                    boolean cfgBoolValue2 = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMR, false);
                    if (cfgBoolValue || cfgBoolValue2) {
                        DeviceInfoUtils.getMaxCpuFreq();
                        DeviceInfoUtils.getMinCpuFreq();
                        DuplayerCore.nativeSetInfo(HttpConstants.HTTP_BOARD, DeviceInfoUtils.getDeviceBoard());
                        DuplayerCore.nativeSetInfo("device_id", DeviceInfoUtils.getDeviceId());
                        DuplayerCore.nativeSetInfo("display", DeviceInfoUtils.getDeviceDisplay());
                        DuplayerCore.nativeSetInfo("product", DeviceInfoUtils.getDeviceProduct());
                        DuplayerCore.nativeSetInfo("device_name", DeviceInfoUtils.getDeviceDevice());
                        DuplayerCore.nativeSetInfo("serial", DeviceInfoUtils.getDeviceSerial());
                        DuplayerCore.nativeSetInfo("width", String.valueOf(DeviceInfoUtils.getDeviceWidth(CyberPlayerManager.getApplicationContext())));
                        DuplayerCore.nativeSetInfo("height", String.valueOf(DeviceInfoUtils.getDeviceHeight(CyberPlayerManager.getApplicationContext())));
                        DuplayerCore.nativeSetInfo("density", String.valueOf(DeviceInfoUtils.getDeviceDensityDpi(CyberPlayerManager.getApplicationContext())));
                        DuplayerCore.nativeSetInfo("branch", DeviceInfoUtils.getDeviceBrand());
                        CyberLog.v("IjkMediaPlayer", "[wxc] cost times1:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                    u = true;
                }
            }
        }
    }

    @Keep
    public static String getIpList(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65608, null, obj, str)) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                CyberLog.e("IjkMediaPlayer", "<null weakThiz>.onNativeInvoke()");
                return null;
            }
            List<String> d2 = ((IjkMediaPlayer) ((WeakReference) obj).get()).d(str);
            if (d2 == null || d2.size() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : d2) {
                sb.append(str2);
                sb.append(";");
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    @Keep
    public static String getNetworkStatus(Object obj) {
        InterceptResult invokeL;
        WifiInfo connectionInfo;
        int rssi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, obj)) == null) {
            if (((IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
                return "N/A";
            }
            try {
                Context applicationContext = CyberPlayerManager.getApplicationContext();
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return "Disconnect";
                    }
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (TextUtils.isEmpty(extraInfo)) {
                            return "Disconnect";
                        }
                        return "mobile_" + extraInfo;
                    } else if (type == 1) {
                        WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && (rssi = connectionInfo.getRssi()) > -127) {
                            return "wifi:" + rssi;
                        }
                        return "Disconnect";
                    }
                }
            } catch (Exception unused) {
            }
            return "N/A";
        }
        return (String) invokeL.objValue;
    }

    @Keep
    public static String getSessionNetworkType(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65610, null, obj)) == null) ? ((IjkMediaPlayer) ((WeakReference) obj).get()) == null ? "0_0" : DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()) : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IjkMediaPlayer ijkMediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, this, ijkMediaPlayer) == null) {
            if (CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_ACCURATE_SEEK_ENABLE, 1) == 0) {
                ijkMediaPlayer._setOption(4, "enable-accurate-seek", 0L);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                ijkMediaPlayer._setOption(4, "mediacodec-reuse-enable", CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_ENABLE_MEDIACODEC_REUSE, 1));
            }
            ijkMediaPlayer._setOption(1, "protocol_whitelist", "http,https,rtmp,tls,rtp,tcp,udp,crypto,httpproxy,proxytcp,file,pipe");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSeekTo(long j, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetClarityInfo(String str);

    public static native void nativeSetEnableFFmpegExtend(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetPlayJson(String str);

    private native void nativeSwitchMediaSource(int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateDisplaySize(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_finalize();

    public static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_setup(Object obj);

    @Keep
    public static void onNativeHasShutDownEnd(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65629, null, obj) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                CyberLog.w("IjkMediaPlayer", "onNativeHasShutDownEnd weakThiz == null");
                return;
            }
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
            if (ijkMediaPlayer != null) {
                ijkMediaPlayer.u();
            }
        }
    }

    @Keep
    public static boolean onNativeInvoke(Object obj, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        String str;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65630, null, obj, i2, bundle)) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                str = "<null weakThiz>.onNativeInvoke()";
            } else {
                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
                if (ijkMediaPlayer == null) {
                    str = "<null weakPlayer>.onNativeInvoke()";
                } else {
                    e eVar = ijkMediaPlayer.w;
                    if (eVar != null && eVar.a(i2, bundle)) {
                        return true;
                    }
                    if (i2 != 131079 || (cVar = ijkMediaPlayer.v) == null) {
                        return false;
                    }
                    int i3 = bundle.getInt("segment_index", -1);
                    if (i3 < 0) {
                        str = "onNativeInvoke(invalid segment index)";
                    } else {
                        String a2 = cVar.a(i3);
                        if (a2 != null) {
                            bundle.putString("url", a2);
                            return true;
                        }
                        str = "onNativeInvoke() = <NULL newUrl>";
                    }
                }
            }
            CyberLog.e("IjkMediaPlayer", str);
            return false;
        }
        return invokeLIL.booleanValue;
    }

    @Keep
    public static String onSelectCodec(Object obj, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65631, null, obj, str, i2, i3)) == null) {
            if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
                return null;
            }
            d dVar = ijkMediaPlayer.x;
            if (dVar == null) {
                dVar = a.f76780a;
            }
            return dVar.a(ijkMediaPlayer, str, i2, i3);
        }
        return (String) invokeLLII.objValue;
    }

    @Keep
    public static void onUploadStatisticData(Object obj, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65632, null, obj, str, i2) == null) {
            if (i2 == -1001 || i2 == -1002) {
                UbcSessionUploader.getInstance().upload(str, UBCCloudControlProcessor.UBC_KEY, i2);
            } else {
                DpSessionDatasUploader.getInstance().upload(str, "sailor_monitor", i2);
            }
        }
    }

    @Keep
    public static void onVideoFlowCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65633, null, str) == null) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap.put(CyberPlayerManager.VIDEO_FLOW_STAGE, jSONObject.getString(CyberPlayerManager.VIDEO_FLOW_STAGE));
                hashMap.put(CyberPlayerManager.VIDEO_FLOW_URL, jSONObject.getString(CyberPlayerManager.VIDEO_FLOW_URL));
                hashMap.put(CyberPlayerManager.VIDEO_FLOW_VALUE, jSONObject.getString(CyberPlayerManager.VIDEO_FLOW_VALUE));
                hashMap.put(CyberPlayerManager.VIDEO_FLOW_IS_PREFETCH, jSONObject.getString(CyberPlayerManager.VIDEO_FLOW_IS_PREFETCH));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            CyberLog.i("IjkMediaPlayer", "stageType:" + ((String) hashMap.get(CyberPlayerManager.VIDEO_FLOW_STAGE)) + " | url:" + ((String) hashMap.get(CyberPlayerManager.VIDEO_FLOW_URL)) + " | value:" + ((String) hashMap.get(CyberPlayerManager.VIDEO_FLOW_VALUE)) + " | isPrefetch:" + ((String) hashMap.get(CyberPlayerManager.VIDEO_FLOW_IS_PREFETCH)));
            CyberPlayerManager.videoFlowCallback(hashMap);
        }
    }

    @Keep
    public static int postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        InterceptResult invokeCommon;
        IjkMediaPlayer ijkMediaPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65634, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj2})) == null) {
            if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
                return -1;
            }
            if (i2 == 200 && i3 == 2) {
                ijkMediaPlayer.h();
            }
            b bVar = ijkMediaPlayer.f76772b;
            if (bVar != null) {
                ijkMediaPlayer.f76772b.sendMessage(bVar.obtainMessage(i2, i3, i4, obj2));
                return 0;
            }
            return 0;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() {
        b bVar;
        DuplayerHandlerThread obtain;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65635, this) != null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.f76772b = null;
                this.q = false;
                if (Utils.r(CyberPlayerManager.getApplicationContext()) || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    obtain = DuplayerHandlerThreadPool.getInstance().obtain();
                    this.n = obtain;
                    if (obtain.getLooper() != null) {
                        this.o = new f(this, this.n.getLooper());
                        CyberLog.i("IjkMediaPlayer", "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.o);
                        this.q = true;
                        this.p = true;
                    }
                } else {
                    CyberLog.i("IjkMediaPlayer", "create player in thread, don't use request handler. thread:" + Thread.currentThread().getName());
                    this.o = null;
                }
                if (!d(12)) {
                    native_setup(new WeakReference(this));
                }
                if (d(13)) {
                    l(this);
                    return;
                }
                return;
            }
            bVar = new b(this, mainLooper);
        }
        this.f76772b = bVar;
        this.q = false;
        if (Utils.r(CyberPlayerManager.getApplicationContext())) {
        }
        obtain = DuplayerHandlerThreadPool.getInstance().obtain();
        this.n = obtain;
        if (obtain.getLooper() != null) {
        }
        if (!d(12)) {
        }
        if (d(13)) {
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65636, this) == null) {
            this.f76776f = 0;
            this.f76777g = 0;
            this.f76778h = 1;
            this.f76779i = 1;
            this.j = 0L;
            this.k = 0L;
            if (!d(13)) {
                l(this);
            }
            c(this.r);
        }
    }

    private void x() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65637, this) == null) || (surfaceHolder = this.f76771a) == null) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.f76774d && this.f76775e);
    }

    private synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65638, this) == null) {
            synchronized (this) {
                if (this.q) {
                    DuplayerHandlerThreadPool.getInstance().recycle(this.n);
                    this.n = null;
                    this.p = false;
                }
            }
        }
    }

    private void z() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65639, this) == null) && this.p && (fVar = this.o) != null) {
            fVar.removeMessages(13);
            this.o.removeMessages(10);
            this.o.removeMessages(11);
            this.o.removeMessages(8);
        }
    }

    public native void _prepareAsync();

    @Override // tv.danmaku.ijk.media.player.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            this.x = null;
        }
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, f2) == null) || a(23, 10003, 0, Float.valueOf(f2))) {
            return;
        }
        _setPropertyFloat(10003, f2);
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (!this.p || this.o == null) {
                _setVolume(f2, f3);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(CustomDialogData.POS_LEFT, f2);
            bundle.putFloat("right", f3);
            Message obtainMessage = this.o.obtainMessage(22);
            obtainMessage.setData(bundle);
            this.o.sendMessage(obtainMessage);
        }
    }

    @Override // tv.danmaku.ijk.media.player.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || a(28, i2, i3, (Object) null)) {
            return;
        }
        nativeUpdateDisplaySize(i2, i3);
    }

    public void a(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            if (this.o != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(String.valueOf(j));
                if (a(18, i2, 0, arrayList)) {
                    return;
                }
            }
            _setOption(i2, str, j);
        }
    }

    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) {
            if (this.o != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(str2);
                if (a(17, i2, 0, arrayList)) {
                    return;
                }
            }
            _setOption(i2, str, str2);
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.k = j;
        }
    }

    public void a(long j, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || a(11, i2, 0, Long.valueOf(j))) {
            return;
        }
        nativeSeekTo(j, i2);
    }

    @SuppressLint({"Wakelock"})
    public void a(Context context, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, context, i2) == null) {
            PowerManager.WakeLock wakeLock = this.f76773c;
            if (wakeLock != null) {
                if (wakeLock.isHeld()) {
                    z = true;
                    this.f76773c.release();
                } else {
                    z = false;
                }
                this.f76773c = null;
            } else {
                z = false;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2 | 536870912, "duplayer");
            this.f76773c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.f76773c.acquire();
            }
        }
    }

    public void a(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, uri) == null) {
            a(context, uri, (Map<String, String>) null);
        }
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, uri, map) == null) {
            String scheme = uri.getScheme();
            if ("file".equals(scheme)) {
                b(uri.getPath());
            } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
                CyberLog.e("IjkMediaPlayer", "Failed to resolve default ringtone");
            } else if (!b(context, uri)) {
                a(uri.toString(), map);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(context.getApplicationContext());
                arrayList.add(uri);
                if (a(24, -1, -1, arrayList)) {
                    return;
                }
                c(context, uri);
            }
        }
    }

    public void a(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, surface) == null) {
            if (this.f76774d && surface != null) {
                CyberLog.w("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
            }
            this.f76771a = null;
            if (!a(14, 0, 0, surface)) {
                _setVideoSurface(surface);
            }
            x();
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.f76771a = surfaceHolder;
            Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
            if (!a(14, 0, 0, surface)) {
                _setVideoSurface(surface);
            }
            x();
        }
    }

    public void a(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, httpDNS) == null) {
            this.m = httpDNS;
        }
    }

    @TargetApi(13)
    public void a(FileDescriptor fileDescriptor) {
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fileDescriptor) == null) {
            if (Build.VERSION.SDK_INT >= 12) {
                ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
                try {
                    _setDataSourceFd(dup.getFd());
                    return;
                } finally {
                    dup.close();
                }
            }
            int i2 = -1;
            try {
                Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
                declaredField.setAccessible(true);
                i2 = declaredField.getInt(fileDescriptor);
            } catch (IllegalAccessException e2) {
                message = e2.getMessage();
                CyberLog.e("IjkMediaPlayer", message);
                _setDataSourceFd(i2);
            } catch (NoSuchFieldException e3) {
                message = e3.getMessage();
                CyberLog.e("IjkMediaPlayer", message);
                _setDataSourceFd(i2);
            }
            _setDataSourceFd(i2);
        }
    }

    @Override // tv.danmaku.ijk.media.player.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || a(26, -1, -1, str)) {
            return;
        }
        nativeSetPlayJson(str);
    }

    public void a(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, map) == null) {
            CyberLog.i("IjkMediaPlayer", "setDataSource called path:" + str);
            if (map != null && !map.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey().equals("Referer")) {
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(value)) {
                            a(1, Config.LAUNCH_REFERER, value);
                        }
                    } else {
                        sb.append(entry.getKey());
                        sb.append(": ");
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            sb.append(entry.getValue());
                        }
                        sb.append(Part.CRLF);
                    }
                }
                a(1, "headers", sb.toString());
            }
            b(str);
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) || a(21, z ? 1 : 0, 0, str)) {
            return;
        }
        _changeHttpProxy(str, z ? "true" : "false");
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.w = eVar;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.f76774d == z) {
            return;
        }
        if (z && this.f76771a == null) {
            CyberLog.i("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
        }
        this.f76774d = z;
        x();
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            nativeSwitchMediaSource(i2);
        }
    }

    public void b(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048598, this, i2, str, str2) == null) {
            if (this.o != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(str2);
                if (a(9, i2, 0, arrayList)) {
                    return;
                }
            }
            _setStatisticInfo(i2, str, str2);
        }
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.j = j;
        }
    }

    @TargetApi(13)
    public void b(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, fileDescriptor) == null) || a(15, -1, -1, fileDescriptor)) {
            return;
        }
        a(fileDescriptor);
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.l = str;
            d.a.b0.a.b.c(SocialConstants.PARAM_PLAY_URL, str);
            if (a(8, 0, 0, str)) {
                return;
            }
            _setDataSource(str, null, null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            int i2 = !z ? 1 : 0;
            a(4, "loop", i2);
            if (a(16, i2, 0, (Object) null)) {
                return;
            }
            _setLoopCount(i2);
        }
    }

    public void c(int i2) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.r = i2;
            if (i2 != 1) {
                j = (i2 == 2 || i2 == 0) ? 1L : 1L;
                a(4, "decode-mode", i2);
            }
            j = 0;
            a(4, "mediacodec-all-videos", j);
            a(4, "decode-mode", i2);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || a(27, -1, -1, str)) {
            return;
        }
        nativeSetClarityInfo(str);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || a(19, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _setUserHasClickStart(z);
    }

    public List<String> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            CyberPlayerManager.HttpDNS httpDNS = this.m;
            if (httpDNS != null) {
                return httpDNS.getIpList(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || a(20, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _muteOrUnmuteAudio(z);
    }

    public void finalize() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.finalize();
            if (this.p && (fVar = this.o) != null) {
                fVar.removeCallbacksAndMessages(null);
            }
            if (!d(4)) {
                native_finalize();
                return;
            }
            this.o = null;
            y();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || d(10)) {
            return;
        }
        _prepareAsync();
    }

    public native int getAudioSessionId();

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            e(true);
            if (d(7)) {
                return;
            }
            _start();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            e(false);
            if (d(1)) {
                return;
            }
            _stop();
        }
    }

    public native boolean isPlaying();

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            e(false);
            if (d(6)) {
                return;
            }
            _pause();
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f76776f : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f76777g : invokeV.intValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.k : invokeV.longValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? _getCurrentPosition() : invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.j : invokeV.longValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            synchronized (this) {
                e(false);
                x();
                a();
                if (this.p && this.o != null) {
                    this.o.removeCallbacksAndMessages(null);
                }
                this.f76772b.removeCallbacksAndMessages(null);
                if (d(2)) {
                    this.p = false;
                    this.o = null;
                } else {
                    _release();
                }
            }
        }
    }

    public void q() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            e(false);
            if (this.mNativeMediaPlayer == 0) {
                z();
            } else if (this.p && (fVar = this.o) != null) {
                fVar.removeCallbacksAndMessages(null);
            }
            if (!d(3)) {
                _reset();
            }
            this.f76772b.removeCallbacksAndMessages(null);
            w();
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? _getLoopCount() != 1 : invokeV.booleanValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? _getPropertyLong(20400, 0L) : invokeV.longValue;
    }

    @Keep
    public void setAndroidIOCallback(IAndroidIO iAndroidIO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, iAndroidIO) == null) {
            _setAndroidIOCallback(iAndroidIO);
        }
    }

    @Override // tv.danmaku.ijk.media.player.a
    @Keep
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, iMediaDataSource) == null) {
            _setDataSource(iMediaDataSource);
        }
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? _getPropertyLong(20200, 0L) : invokeV.longValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            y();
        }
    }
}
