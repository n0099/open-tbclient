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
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.IMConstants;
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
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
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
/* loaded from: classes8.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.a {
    public static volatile boolean s = false;
    public static volatile boolean t = false;
    public static volatile boolean u = false;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f73095a;

    /* renamed from: b  reason: collision with root package name */
    public b f73096b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73098d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73099e;

    /* renamed from: f  reason: collision with root package name */
    public int f73100f;

    /* renamed from: g  reason: collision with root package name */
    public int f73101g;

    /* renamed from: h  reason: collision with root package name */
    public int f73102h;

    /* renamed from: i  reason: collision with root package name */
    public int f73103i;
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
    public boolean q;
    public int r;
    public c v;
    public e w;
    public d x;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f73097c = null;
    public volatile boolean p = false;

    /* loaded from: classes8.dex */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f73104a = new a();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.d
        @TargetApi(16)
        public String a(tv.danmaku.ijk.media.player.b bVar, String str, int i2, int i3) {
            return d.a.y.a.d.b(str);
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f73105a;

        public b(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f73105a = new WeakReference<>(ijkMediaPlayer);
        }

        private String a(String str) {
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

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2;
            String str;
            IjkMediaPlayer ijkMediaPlayer = this.f73105a.get();
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
                            ijkMediaPlayer.f73100f = message.arg1;
                            ijkMediaPlayer.f73101g = message.arg2;
                            ijkMediaPlayer.a(ijkMediaPlayer.f73100f, ijkMediaPlayer.f73101g, ijkMediaPlayer.f73102h, ijkMediaPlayer.f73103i);
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
                                        ijkMediaPlayer.f73102h = message.arg1;
                                        ijkMediaPlayer.f73103i = message.arg2;
                                        ijkMediaPlayer.a(ijkMediaPlayer.f73100f, ijkMediaPlayer.f73101g, ijkMediaPlayer.f73102h, ijkMediaPlayer.f73103i);
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

    /* loaded from: classes8.dex */
    public interface c {
        String a(int i2);
    }

    /* loaded from: classes8.dex */
    public interface d {
        String a(tv.danmaku.ijk.media.player.b bVar, String str, int i2, int i3);
    }

    /* loaded from: classes8.dex */
    public interface e {
        boolean a(int i2, Bundle bundle);
    }

    /* loaded from: classes8.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f73106a;

        public f(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f73106a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.f73106a.get();
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

    public IjkMediaPlayer() {
        v();
    }

    public static int A() {
        return 8 - CyberLog.getLogLevel();
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
        f fVar;
        if (this.q) {
            if (!this.p || (fVar = this.o) == null) {
                return true;
            }
            this.o.sendMessage(fVar.obtainMessage(i2, i3, i4, obj));
            return true;
        }
        return false;
    }

    private boolean b(Context context, Uri uri) {
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7715a);
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Uri uri) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7715a);
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

    private boolean d(int i2) {
        f fVar;
        if (this.q) {
            if (!this.p || (fVar = this.o) == null) {
                return true;
            }
            fVar.sendEmptyMessage(i2);
            return true;
        }
        return false;
    }

    public static void e() {
        synchronized (IjkMediaPlayer.class) {
            if (!t) {
                native_init();
                native_setLogLevel(A());
                t = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void e(boolean z) {
        PowerManager.WakeLock wakeLock = this.f73097c;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.f73097c.acquire();
            } else if (!z && this.f73097c.isHeld()) {
                this.f73097c.release();
            }
        }
        this.f73099e = z;
        x();
    }

    public static void f() {
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
                DuplayerCore.nativeSetInfo("hardware", Build.HARDWARE);
                DuplayerCore.nativeSetInfo("os_version", Build.VERSION.RELEASE);
                DuplayerCore.nativeSetInfo(SearchJsBridge.COOKIE_OS_TYPE, "Android");
                boolean cfgBoolValue = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMO, false);
                boolean cfgBoolValue2 = CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMR, false);
                if (cfgBoolValue || cfgBoolValue2) {
                    DeviceInfoUtils.getMaxCpuFreq();
                    DeviceInfoUtils.getMinCpuFreq();
                    DuplayerCore.nativeSetInfo("board", DeviceInfoUtils.getDeviceBoard());
                    DuplayerCore.nativeSetInfo(com.baidu.android.imsdk.internal.Constants.KEY_DEVICE_ID, DeviceInfoUtils.getDeviceId());
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

    @Keep
    public static String getIpList(Object obj, String str) {
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

    @Keep
    public static String getNetworkStatus(Object obj) {
        WifiInfo connectionInfo;
        int rssi;
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

    @Keep
    public static String getSessionNetworkType(Object obj) {
        return ((IjkMediaPlayer) ((WeakReference) obj).get()) == null ? "0_0" : DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IjkMediaPlayer ijkMediaPlayer) {
        if (CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_ACCURATE_SEEK_ENABLE, 1) == 0) {
            ijkMediaPlayer._setOption(4, "enable-accurate-seek", 0L);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ijkMediaPlayer._setOption(4, "mediacodec-reuse-enable", CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_ENABLE_MEDIACODEC_REUSE, 1));
        }
        ijkMediaPlayer._setOption(1, "protocol_whitelist", "http,https,rtmp,tls,rtp,tcp,udp,crypto,httpproxy,proxytcp,file,pipe");
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
        if (obj == null || !(obj instanceof WeakReference)) {
            CyberLog.w("IjkMediaPlayer", "onNativeHasShutDownEnd weakThiz == null");
            return;
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.u();
        }
    }

    @Keep
    public static boolean onNativeInvoke(Object obj, int i2, Bundle bundle) {
        String str;
        c cVar;
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

    @Keep
    public static String onSelectCodec(Object obj, String str, int i2, int i3) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        d dVar = ijkMediaPlayer.x;
        if (dVar == null) {
            dVar = a.f73104a;
        }
        return dVar.a(ijkMediaPlayer, str, i2, i3);
    }

    @Keep
    public static void onUploadStatisticData(Object obj, String str, int i2) {
        if (i2 == -1001 || i2 == -1002) {
            UbcSessionUploader.getInstance().upload(str, UBCCloudControlProcessor.UBC_KEY, i2);
        } else {
            DpSessionDatasUploader.getInstance().upload(str, "sailor_monitor", i2);
        }
    }

    @Keep
    public static void onVideoFlowCallback(String str) {
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

    @Keep
    public static int postEventFromNative(Object obj, int i2, int i3, int i4, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return -1;
        }
        if (i2 == 200 && i3 == 2) {
            ijkMediaPlayer.h();
        }
        b bVar = ijkMediaPlayer.f73096b;
        if (bVar != null) {
            ijkMediaPlayer.f73096b.sendMessage(bVar.obtainMessage(i2, i3, i4, obj2));
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() {
        b bVar;
        DuplayerHandlerThread obtain;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.f73096b = null;
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
        this.f73096b = bVar;
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
        this.f73100f = 0;
        this.f73101g = 0;
        this.f73102h = 1;
        this.f73103i = 1;
        this.j = 0L;
        this.k = 0L;
        if (!d(13)) {
            l(this);
        }
        c(this.r);
    }

    private void x() {
        SurfaceHolder surfaceHolder = this.f73095a;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.f73098d && this.f73099e);
        }
    }

    private synchronized void y() {
        if (this.q) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.n);
            this.n = null;
            this.p = false;
        }
    }

    private void z() {
        f fVar;
        if (!this.p || (fVar = this.o) == null) {
            return;
        }
        fVar.removeMessages(13);
        this.o.removeMessages(10);
        this.o.removeMessages(11);
        this.o.removeMessages(8);
    }

    public native void _prepareAsync();

    @Override // tv.danmaku.ijk.media.player.a
    public void a() {
        super.a();
        this.x = null;
    }

    public void a(float f2) {
        if (a(23, 10003, 0, Float.valueOf(f2))) {
            return;
        }
        _setPropertyFloat(10003, f2);
    }

    public void a(float f2, float f3) {
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

    @Override // tv.danmaku.ijk.media.player.a
    public void a(int i2, int i3) {
        if (a(28, i2, i3, (Object) null)) {
            return;
        }
        nativeUpdateDisplaySize(i2, i3);
    }

    public void a(int i2, String str, long j) {
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

    public void a(int i2, String str, String str2) {
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

    public void a(long j) {
        this.k = j;
    }

    public void a(long j, int i2) {
        if (a(11, i2, 0, Long.valueOf(j))) {
            return;
        }
        nativeSeekTo(j, i2);
    }

    @SuppressLint({"Wakelock"})
    public void a(Context context, int i2) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.f73097c;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.f73097c.release();
            } else {
                z = false;
            }
            this.f73097c = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2 | 536870912, "duplayer");
        this.f73097c = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.f73097c.acquire();
        }
    }

    public void a(Context context, Uri uri) {
        a(context, uri, (Map<String, String>) null);
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
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

    public void a(Surface surface) {
        if (this.f73098d && surface != null) {
            CyberLog.w("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f73095a = null;
        if (!a(14, 0, 0, surface)) {
            _setVideoSurface(surface);
        }
        x();
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f73095a = surfaceHolder;
        Surface surface = surfaceHolder != null ? surfaceHolder.getSurface() : null;
        if (!a(14, 0, 0, surface)) {
            _setVideoSurface(surface);
        }
        x();
    }

    public void a(CyberPlayerManager.HttpDNS httpDNS) {
        this.m = httpDNS;
    }

    @TargetApi(13)
    public void a(FileDescriptor fileDescriptor) {
        String message;
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

    @Override // tv.danmaku.ijk.media.player.a
    public void a(String str) {
        if (a(26, -1, -1, str)) {
            return;
        }
        nativeSetPlayJson(str);
    }

    public void a(String str, Map<String, String> map) {
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

    public void a(String str, boolean z) {
        if (a(21, z ? 1 : 0, 0, str)) {
            return;
        }
        _changeHttpProxy(str, z ? "true" : "false");
    }

    public void a(e eVar) {
        this.w = eVar;
    }

    public void a(boolean z) {
        if (this.f73098d != z) {
            if (z && this.f73095a == null) {
                CyberLog.i("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.f73098d = z;
            x();
        }
    }

    public void b(int i2) {
        nativeSwitchMediaSource(i2);
    }

    public void b(int i2, String str, String str2) {
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

    public void b(long j) {
        this.j = j;
    }

    @TargetApi(13)
    public void b(FileDescriptor fileDescriptor) {
        if (a(15, -1, -1, fileDescriptor)) {
            return;
        }
        a(fileDescriptor);
    }

    public void b(String str) {
        this.l = str;
        d.a.y.a.b.c(SocialConstants.PARAM_PLAY_URL, str);
        if (a(8, 0, 0, str)) {
            return;
        }
        _setDataSource(str, null, null);
    }

    public void b(boolean z) {
        int i2 = !z ? 1 : 0;
        a(4, "loop", i2);
        if (a(16, i2, 0, (Object) null)) {
            return;
        }
        _setLoopCount(i2);
    }

    public void c(int i2) {
        long j;
        this.r = i2;
        if (i2 != 1) {
            j = (i2 == 2 || i2 == 0) ? 1L : 1L;
            a(4, "decode-mode", i2);
        }
        j = 0;
        a(4, "mediacodec-all-videos", j);
        a(4, "decode-mode", i2);
    }

    public void c(String str) {
        if (a(27, -1, -1, str)) {
            return;
        }
        nativeSetClarityInfo(str);
    }

    public void c(boolean z) {
        if (a(19, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _setUserHasClickStart(z);
    }

    public List<String> d(String str) {
        CyberPlayerManager.HttpDNS httpDNS = this.m;
        if (httpDNS != null) {
            return httpDNS.getIpList(str);
        }
        return null;
    }

    public void d(boolean z) {
        if (a(20, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _muteOrUnmuteAudio(z);
    }

    public void finalize() {
        f fVar;
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

    public void g() {
        if (d(10)) {
            return;
        }
        _prepareAsync();
    }

    public native int getAudioSessionId();

    public void h() {
        e(true);
        if (d(7)) {
            return;
        }
        _start();
    }

    public void i() {
        e(false);
        if (d(1)) {
            return;
        }
        _stop();
    }

    public native boolean isPlaying();

    public void j() {
        e(false);
        if (d(6)) {
            return;
        }
        _pause();
    }

    public int k() {
        return this.f73100f;
    }

    public int l() {
        return this.f73101g;
    }

    public long m() {
        return this.k;
    }

    public long n() {
        return _getCurrentPosition();
    }

    public long o() {
        return this.j;
    }

    public void p() {
        synchronized (this) {
            e(false);
            x();
            a();
            if (this.p && this.o != null) {
                this.o.removeCallbacksAndMessages(null);
            }
            this.f73096b.removeCallbacksAndMessages(null);
            if (d(2)) {
                this.p = false;
                this.o = null;
            } else {
                _release();
            }
        }
    }

    public void q() {
        f fVar;
        e(false);
        if (this.mNativeMediaPlayer == 0) {
            z();
        } else if (this.p && (fVar = this.o) != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        if (!d(3)) {
            _reset();
        }
        this.f73096b.removeCallbacksAndMessages(null);
        w();
    }

    public boolean r() {
        return _getLoopCount() != 1;
    }

    public long s() {
        return _getPropertyLong(20400, 0L);
    }

    @Keep
    public void setAndroidIOCallback(IAndroidIO iAndroidIO) {
        _setAndroidIOCallback(iAndroidIO);
    }

    @Override // tv.danmaku.ijk.media.player.a
    @Keep
    public void setDataSource(IMediaDataSource iMediaDataSource) {
        _setDataSource(iMediaDataSource);
    }

    public long t() {
        return _getPropertyLong(20200, 0L);
    }

    public void u() {
        y();
    }
}
