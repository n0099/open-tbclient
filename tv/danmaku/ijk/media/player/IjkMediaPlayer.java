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
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
    public static volatile boolean t;
    public static volatile boolean u;
    public static volatile boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f80019a;

    /* renamed from: b  reason: collision with root package name */
    public b f80020b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f80021c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f80022d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f80023e;

    /* renamed from: f  reason: collision with root package name */
    public int f80024f;

    /* renamed from: g  reason: collision with root package name */
    public int f80025g;

    /* renamed from: h  reason: collision with root package name */
    public int f80026h;

    /* renamed from: i  reason: collision with root package name */
    public int f80027i;

    /* renamed from: j  reason: collision with root package name */
    public long f80028j;
    public long k;
    public String l;
    public String m;
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
    public CyberPlayerManager.HttpDNS n;
    public DuplayerHandlerThread o;
    public f p;
    public volatile boolean q;
    public boolean r;
    public int s;
    public c w;
    public e x;
    public d y;

    /* loaded from: classes2.dex */
    public static class a implements d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f80029a;
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
            f80029a = new a();
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
            return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, bVar, str, i2, i3)) == null) ? c.a.z.a.d.b(str) : (String) invokeLLII.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f80030a;

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
            this.f80030a = new WeakReference<>(ijkMediaPlayer);
        }

        private String a(IjkMediaPlayer ijkMediaPlayer, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, ijkMediaPlayer, str)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("start_prepare", "1");
                    hashMap.put("open_input", "2");
                    hashMap.put(b.InterfaceC1615b.f38078b, "3");
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
                    hashMap.put("client_total", "15");
                    hashMap.put("first_display_time", Constants.VIA_REPORT_TYPE_START_WAP);
                    hashMap.put("open_input_io_open", Constants.VIA_REPORT_TYPE_START_GROUP);
                    hashMap.put("open_input_read_header_cost", "18");
                    hashMap.put("start_play_time", Constants.VIA_ACT_TYPE_NINETEEN);
                    hashMap.put("client_set_url", "20");
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
                    jSONObject.put(CyberPlayerManager.STAGE_INFO_TYPE, ijkMediaPlayer.p());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeLL.objValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                IjkMediaPlayer ijkMediaPlayer = this.f80030a.get();
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
                                long j2 = message.arg1;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                long o = ijkMediaPlayer.o();
                                long j3 = o > 0 ? (j2 * 100) / o : 0L;
                                ijkMediaPlayer.a((int) (j3 < 100 ? j3 : 100L));
                                return;
                            } else if (i3 == 4) {
                                ijkMediaPlayer.d();
                                return;
                            } else if (i3 == 5) {
                                ijkMediaPlayer.f80024f = message.arg1;
                                ijkMediaPlayer.f80025g = message.arg2;
                                ijkMediaPlayer.a(ijkMediaPlayer.f80024f, ijkMediaPlayer.f80025g, ijkMediaPlayer.f80026h, ijkMediaPlayer.f80027i);
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
                                ijkMediaPlayer.q();
                                ijkMediaPlayer.e(false);
                                return;
                            } else if (i3 == 200) {
                                int i4 = message.arg1;
                                if (i4 == 3) {
                                    CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                                    Object obj = message.obj;
                                    if (obj != null) {
                                        str = a(ijkMediaPlayer, (String) obj);
                                        i2 = message.arg2;
                                    } else {
                                        i2 = message.arg2;
                                        str = "";
                                    }
                                    ijkMediaPlayer.b(904, i2, str);
                                    return;
                                } else if (i4 == 910) {
                                    ijkMediaPlayer.a(message.arg2);
                                    ijkMediaPlayer.b(message.arg1, message.arg2, message.obj);
                                    return;
                                } else if (i4 == 931) {
                                    CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_SERVER_CHANGE server : " + ((String) message.obj));
                                    ijkMediaPlayer.b(5000, message.arg2, message.obj);
                                    return;
                                } else if (i4 != 12002) {
                                    ijkMediaPlayer.b(i4, message.arg2, message.obj);
                                    return;
                                } else {
                                    CyberLog.d("IjkMediaPlayer", "DP_MEDIA_INFO_SR_REMAINING_NB:" + message.arg2);
                                    CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SR_REMAINING_INFO, System.currentTimeMillis() + ";" + message.arg2);
                                    return;
                                }
                            } else if (i3 == 300) {
                                ijkMediaPlayer.c(message.arg1, message.arg2, message.obj);
                                CyberLog.i("IjkMediaPlayer", "notifyOnOnMediaSourceChanged (" + message.arg1 + "," + message.arg2 + SmallTailInfo.EMOTION_SUFFIX);
                                return;
                            } else if (i3 != 953) {
                                switch (i3) {
                                    case IMConstants.ERROR_JOIN_GROUP_NUMBER_FULL /* 60001 */:
                                        ijkMediaPlayer.f80026h = message.arg1;
                                        ijkMediaPlayer.f80027i = message.arg2;
                                        ijkMediaPlayer.a(ijkMediaPlayer.f80024f, ijkMediaPlayer.f80025g, ijkMediaPlayer.f80026h, ijkMediaPlayer.f80027i);
                                        return;
                                    case IMConstants.ERROR_GROUP_NAME_NOT_VALID /* 60002 */:
                                        ijkMediaPlayer.b(message.arg1 | (message.arg2 << 32));
                                        return;
                                    default:
                                        CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                                        return;
                                }
                            } else {
                                int i5 = message.arg1;
                                int i6 = message.arg2;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("audio_duration", i5);
                                    jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, i6);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                CyberLog.d("IjkMediaPlayer", "DP_MSG_INFO_CACHE_DURATION audioDuration:" + i5 + " videoDuration:" + i6);
                                ijkMediaPlayer.b(CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION, i6, jSONObject.toString());
                                return;
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
        public final WeakReference<IjkMediaPlayer> f80031a;

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
            this.f80031a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                IjkMediaPlayer ijkMediaPlayer = this.f80031a.get();
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
                                float f2 = data.getFloat("left");
                                float f3 = data.getFloat(HorizontalTranslateLayout.RIGHT);
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
        this.f80021c = null;
        this.l = "-1";
        this.q = false;
        w();
    }

    private void A() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && this.q && (fVar = this.p) != null) {
            fVar.removeMessages(13);
            this.p.removeMessages(10);
            this.p.removeMessages(11);
            this.p.removeMessages(8);
        }
    }

    public static int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? 8 - CyberLog.getLogLevel() : invokeV.intValue;
    }

    public static native void _changeHttpProxy(String str, String str2);

    private native String _getAudioCodecInfo();

    public static native String _getColorFormatName(int i2);

    private native long _getCurrentPosition();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i2, float f2);

    private native long _getPropertyLong(int i2, long j2);

    private native String _getVideoCodecInfo();

    private native void _injectCacheNode(int i2, long j2, long j3, long j4, long j5);

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
    public native void _setExternalInfo(String str, int i2, long j2, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setLoopCount(int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i2, String str, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setPropertyFloat(int i2, float f2);

    private native void _setPropertyLong(int i2, long j2);

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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65588, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj})) == null) {
            if (this.r) {
                if (!this.q || (fVar = this.p) == null) {
                    return true;
                }
                this.p.sendMessage(fVar.obtainMessage(i2, i3, i4, obj));
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    private boolean b(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65594, this, context, uri)) == null) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f42280a);
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
        if (interceptable == null || interceptable.invokeLL(65596, this, context, uri) == null) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f42280a);
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
        if (interceptable == null || (invokeI = interceptable.invokeI(65601, this, i2)) == null) {
            if (this.r) {
                if (!this.q || (fVar = this.p) == null) {
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
        if (interceptable == null || interceptable.invokeV(65603, null) == null) {
            synchronized (IjkMediaPlayer.class) {
                if (!u) {
                    native_init();
                    native_setLogLevel(B());
                    u = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65605, this, z) == null) {
            PowerManager.WakeLock wakeLock = this.f80021c;
            if (wakeLock != null) {
                if (z && !wakeLock.isHeld()) {
                    this.f80021c.acquire();
                } else if (!z && this.f80021c.isHeld()) {
                    this.f80021c.release();
                }
            }
            this.f80023e = z;
            y();
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65606, null) == null) {
            synchronized (IjkMediaPlayer.class) {
                if (!v) {
                    Context applicationContext = CyberPlayerManager.getApplicationContext();
                    PackageManager packageManager = applicationContext.getPackageManager();
                    String packageName = applicationContext.getPackageName();
                    String appVerionName = CyberPlayerManager.getAppVerionName();
                    String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
                    String sDKVersionInternal = CyberVersion.getSDKVersionInternal();
                    String k = Utils.k(applicationContext);
                    if (appVerionName == null && packageManager != null) {
                        try {
                            appVerionName = packageManager.getPackageInfo(packageName, 0).versionName;
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.printStackTrace();
                        }
                    }
                    DuplayerCore.nativeStatisticInit(packageName, appVerionName, sDKVersionInternal, SDKVersion.VERSION, k, CyberPlayerManager.getClientID(), networkStatisticsData, CyberPlayerManager.getInstallOpts().get("abtest_sid"));
                    long currentTimeMillis = System.currentTimeMillis();
                    DuplayerCore.nativeSetInfo("model", Build.MODEL);
                    DuplayerCore.nativeSetInfo(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                    DuplayerCore.nativeSetInfo(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
                    DuplayerCore.nativeSetInfo("os_type", "Android");
                    DuplayerCore.nativeSetInfo("screen_width", String.valueOf(DeviceInfoUtils.getDeviceWidth(CyberPlayerManager.getApplicationContext())));
                    DuplayerCore.nativeSetInfo("screen_height", String.valueOf(DeviceInfoUtils.getDeviceHeight(CyberPlayerManager.getApplicationContext())));
                    DuplayerCore.nativeSetInfo("density", String.valueOf(DeviceInfoUtils.getDeviceDensityDpi(CyberPlayerManager.getApplicationContext())));
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
                        DuplayerCore.nativeSetInfo("branch", DeviceInfoUtils.getDeviceBrand());
                        CyberLog.v("IjkMediaPlayer", "[wxc] cost times1:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    }
                    v = true;
                }
            }
        }
    }

    @Keep
    public static String getIpList(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65609, null, obj, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, obj)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65611, null, obj)) == null) ? ((IjkMediaPlayer) ((WeakReference) obj).get()) == null ? "0_0" : DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()) : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IjkMediaPlayer ijkMediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, this, ijkMediaPlayer) == null) {
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
    public native void nativeSeekTo(long j2, int i2);

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
        if (interceptable == null || interceptable.invokeL(65630, null, obj) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                CyberLog.w("IjkMediaPlayer", "onNativeHasShutDownEnd weakThiz == null");
                return;
            }
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
            if (ijkMediaPlayer != null) {
                ijkMediaPlayer.v();
            }
        }
    }

    @Keep
    public static boolean onNativeInvoke(Object obj, int i2, Bundle bundle) {
        InterceptResult invokeLIL;
        String str;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65631, null, obj, i2, bundle)) == null) {
            if (obj == null || !(obj instanceof WeakReference)) {
                str = "<null weakThiz>.onNativeInvoke()";
            } else {
                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
                if (ijkMediaPlayer == null) {
                    str = "<null weakPlayer>.onNativeInvoke()";
                } else {
                    e eVar = ijkMediaPlayer.x;
                    if (eVar != null && eVar.a(i2, bundle)) {
                        return true;
                    }
                    if (i2 != 131079 || (cVar = ijkMediaPlayer.w) == null) {
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
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65632, null, obj, str, i2, i3)) == null) {
            if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
                return null;
            }
            d dVar = ijkMediaPlayer.y;
            if (dVar == null) {
                dVar = a.f80029a;
            }
            return dVar.a(ijkMediaPlayer, str, i2, i3);
        }
        return (String) invokeLLII.objValue;
    }

    @Keep
    public static void onUploadStatisticData(Object obj, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65633, null, obj, str, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(65634, null, str) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65635, null, new Object[]{obj, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), obj2})) == null) {
            if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
                return -1;
            }
            if (i2 == 200 && i3 == 2) {
                ijkMediaPlayer.h();
            }
            b bVar = ijkMediaPlayer.f80020b;
            if (bVar != null) {
                ijkMediaPlayer.f80020b.sendMessage(bVar.obtainMessage(i2, i3, i4, obj2));
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
    private void w() {
        b bVar;
        DuplayerHandlerThread obtain;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65636, this) != null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.f80020b = null;
                this.r = false;
                if (Utils.r(CyberPlayerManager.getApplicationContext()) || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    obtain = DuplayerHandlerThreadPool.getInstance().obtain();
                    this.o = obtain;
                    if (obtain.getLooper() != null) {
                        this.p = new f(this, this.o.getLooper());
                        CyberLog.i("IjkMediaPlayer", "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.o.getName() + " mRequestHandler:" + this.p);
                        this.r = true;
                        this.q = true;
                    }
                } else {
                    CyberLog.i("IjkMediaPlayer", "create player in thread, don't use request handler. thread:" + Thread.currentThread().getName());
                    this.p = null;
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
        this.f80020b = bVar;
        this.r = false;
        if (Utils.r(CyberPlayerManager.getApplicationContext())) {
        }
        obtain = DuplayerHandlerThreadPool.getInstance().obtain();
        this.o = obtain;
        if (obtain.getLooper() != null) {
        }
        if (!d(12)) {
        }
        if (d(13)) {
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65637, this) == null) {
            this.f80024f = 0;
            this.f80025g = 0;
            this.f80026h = 1;
            this.f80027i = 1;
            this.f80028j = 0L;
            this.k = 0L;
            this.l = "-1";
            if (!d(13)) {
                l(this);
            }
            c(this.s);
        }
    }

    private void y() {
        SurfaceHolder surfaceHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65638, this) == null) || (surfaceHolder = this.f80019a) == null) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.f80022d && this.f80023e);
    }

    private synchronized void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65639, this) == null) {
            synchronized (this) {
                if (this.r) {
                    DuplayerHandlerThreadPool.getInstance().recycle(this.o);
                    this.o = null;
                    this.q = false;
                }
            }
        }
    }

    public native void _prepareAsync();

    @Override // tv.danmaku.ijk.media.player.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            this.y = null;
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
            if (!this.q || this.p == null) {
                _setVolume(f2, f3);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("left", f2);
            bundle.putFloat(HorizontalTranslateLayout.RIGHT, f3);
            Message obtainMessage = this.p.obtainMessage(22);
            obtainMessage.setData(bundle);
            this.p.sendMessage(obtainMessage);
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

    public void a(int i2, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2)}) == null) {
            if (this.p != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(String.valueOf(j2));
                if (a(18, i2, 0, arrayList)) {
                    return;
                }
            }
            _setOption(i2, str, j2);
        }
    }

    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) {
            if (this.p != null) {
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

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.k = j2;
        }
    }

    public void a(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || a(11, i2, 0, Long.valueOf(j2))) {
            return;
        }
        nativeSeekTo(j2, i2);
    }

    @SuppressLint({"Wakelock"})
    public void a(Context context, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, context, i2) == null) {
            PowerManager.WakeLock wakeLock = this.f80021c;
            if (wakeLock != null) {
                if (wakeLock.isHeld()) {
                    z = true;
                    this.f80021c.release();
                } else {
                    z = false;
                }
                this.f80021c = null;
            } else {
                z = false;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2 | 536870912, "duplayer");
            this.f80021c = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.f80021c.acquire();
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
            if (this.f80022d && surface != null) {
                CyberLog.w("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
            }
            this.f80019a = null;
            if (!a(14, 0, 0, surface)) {
                _setVideoSurface(surface);
            }
            y();
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, surfaceHolder) == null) {
            this.f80019a = surfaceHolder;
            Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
            if (!a(14, 0, 0, surface)) {
                _setVideoSurface(surface);
            }
            y();
        }
    }

    public void a(CyberPlayerManager.HttpDNS httpDNS) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, httpDNS) == null) {
            this.n = httpDNS;
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
                            a(1, "referer", value);
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
            this.x = eVar;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.f80022d == z) {
            return;
        }
        if (z && this.f80019a == null) {
            CyberLog.i("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
        }
        this.f80022d = z;
        y();
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
            if (this.p != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(str2);
                if (str != null && str2 != null && CyberPlayerManager.STAGE_INFO_TYPE.equals(str)) {
                    this.l = str2;
                }
                if (a(9, i2, 0, arrayList)) {
                    return;
                }
            }
            _setStatisticInfo(i2, str, str2);
        }
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.f80028j = j2;
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
            this.m = str;
            c.a.z.a.b.c(SocialConstants.PARAM_PLAY_URL, str);
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
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.s = i2;
            if (i2 != 1) {
                j2 = (i2 == 2 || i2 == 0) ? 1L : 1L;
                a(4, "decode-mode", i2);
            }
            j2 = 0;
            a(4, "mediacodec-all-videos", j2);
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
            CyberPlayerManager.HttpDNS httpDNS = this.n;
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
            if (this.q && (fVar = this.p) != null) {
                fVar.removeCallbacksAndMessages(null);
            }
            if (!d(4)) {
                native_finalize();
                return;
            }
            this.p = null;
            z();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f80024f : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f80025g : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f80028j : invokeV.longValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            synchronized (this) {
                e(false);
                y();
                a();
                if (this.q && this.p != null) {
                    this.p.removeCallbacksAndMessages(null);
                }
                this.f80020b.removeCallbacksAndMessages(null);
                if (d(2)) {
                    this.q = false;
                    this.p = null;
                } else {
                    _release();
                }
            }
        }
    }

    public void r() {
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            e(false);
            if (this.mNativeMediaPlayer == 0) {
                A();
            } else if (this.q && (fVar = this.p) != null) {
                fVar.removeCallbacksAndMessages(null);
            }
            if (!d(3)) {
                _reset();
            }
            this.f80020b.removeCallbacksAndMessages(null);
            x();
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? _getLoopCount() != 1 : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? _getPropertyLong(20400, 0L) : invokeV.longValue;
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? _getPropertyLong(20200, 0L) : invokeV.longValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            z();
        }
    }
}
