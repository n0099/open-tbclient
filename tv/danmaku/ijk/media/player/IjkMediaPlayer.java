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
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.media.duplayer.DuplayerCore;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.Utils;
import com.baidu.mobstat.Config;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.misc.IAndroidIO;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;
/* loaded from: classes18.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.a {
    private static volatile boolean r = false;
    private static volatile boolean s = false;
    private static volatile boolean t = false;

    /* renamed from: a  reason: collision with root package name */
    private SurfaceHolder f5399a;
    private b b;
    private PowerManager.WakeLock c = null;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long j;
    private long k;
    private String l;
    private CyberPlayerManager.HttpDNS m;
    @Keep
    private int mListenerContext;
    @Keep
    private long mNativeAndroidIO;
    @Keep
    private long mNativeMediaDataSource;
    @Keep
    private long mNativeMediaPlayer;
    @Keep
    private int mNativeSurfaceTexture;
    private DuplayerHandlerThread n;
    private f o;
    private boolean p;
    private int q;
    private c u;
    private e v;
    private d w;

    /* loaded from: classes18.dex */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5400a = new a();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.d
        @TargetApi(16)
        public String a(tv.danmaku.ijk.media.player.b bVar, String str, int i, int i2) {
            return com.baidu.media.duplayer.c.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<IjkMediaPlayer> f5401a;

        public b(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f5401a = new WeakReference<>(ijkMediaPlayer);
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
                hashMap.put(DpStatConstants.KEY_FIRST_DISPLAY, Constants.VIA_REPORT_TYPE_JOININ_GROUP);
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
                jSONObject.put("first_disp_notify_time", "" + SystemClock.elapsedRealtime());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.f5401a.get();
            if (ijkMediaPlayer == null || ijkMediaPlayer.mNativeMediaPlayer == 0) {
                CyberLog.w("IjkMediaPlayer", "IjkMediaPlayer went away with unhandled events");
                return;
            }
            switch (message.what) {
                case 0:
                    return;
                case 1:
                    ijkMediaPlayer.b();
                    ijkMediaPlayer.b(10005, 0, (Object) null);
                    return;
                case 2:
                    ijkMediaPlayer.e(false);
                    ijkMediaPlayer.b(10004, 0, (Object) null);
                    ijkMediaPlayer.c();
                    return;
                case 3:
                    long j = message.arg1;
                    if (j < 0) {
                        j = 0;
                    }
                    long o = ijkMediaPlayer.o();
                    long j2 = o > 0 ? (j * 100) / o : 0L;
                    if (j2 >= 100) {
                        j2 = 100;
                    }
                    ijkMediaPlayer.a((int) j2);
                    return;
                case 4:
                    ijkMediaPlayer.d();
                    return;
                case 5:
                    ijkMediaPlayer.f = message.arg1;
                    ijkMediaPlayer.g = message.arg2;
                    ijkMediaPlayer.a(ijkMediaPlayer.f, ijkMediaPlayer.g, ijkMediaPlayer.h, ijkMediaPlayer.i);
                    ijkMediaPlayer.b(10006, 0, (Object) null);
                    return;
                case 99:
                    if (message.obj == null) {
                        ijkMediaPlayer.a((tv.danmaku.ijk.media.player.c) null);
                        return;
                    } else {
                        ijkMediaPlayer.a(new tv.danmaku.ijk.media.player.c(new Rect(0, 0, 1, 1), (String) message.obj));
                        return;
                    }
                case 100:
                    CyberLog.i("IjkMediaPlayer", "Error (" + message.arg1 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + message.arg2 + ")");
                    ijkMediaPlayer.b(10007, 0, (Object) null);
                    if (!ijkMediaPlayer.a(message.arg1, message.arg2, message.obj)) {
                        ijkMediaPlayer.c();
                    }
                    CyberLog.i("IjkMediaPlayer", "MEDIA_ERROR called stop release");
                    ijkMediaPlayer.i();
                    ijkMediaPlayer.p();
                    ijkMediaPlayer.e(false);
                    return;
                case 200:
                    switch (message.arg1) {
                        case 3:
                            CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            if (message.obj != null) {
                                ijkMediaPlayer.b(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, message.arg2, a((String) message.obj));
                                return;
                            } else {
                                ijkMediaPlayer.b(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, message.arg2, "");
                                return;
                            }
                        case CyberPlayerManager.MEDIA_INFO_PROCESS /* 910 */:
                            ijkMediaPlayer.b(message.arg2);
                            ijkMediaPlayer.b(message.arg1, message.arg2, message.obj);
                            return;
                        case CyberPlayerManager.MEDIA_INFO_SERVER_CHANGE /* 931 */:
                            CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_SERVER_CHANGE server : " + ((String) message.obj));
                            ijkMediaPlayer.b(5000, message.arg2, message.obj);
                            return;
                        case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                            CyberLog.d("IjkMediaPlayer", "DP_MEDIA_INFO_SR_REMAINING_NB:" + message.arg2);
                            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SR_REMAINING_INFO, System.currentTimeMillis() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + message.arg2);
                            return;
                        default:
                            ijkMediaPlayer.b(message.arg1, message.arg2, message.obj);
                            return;
                    }
                case CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION /* 953 */:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    Bundle bundle = new Bundle();
                    bundle.putInt("audio_duration", i);
                    bundle.putInt("video_duration", i2);
                    CyberLog.d("IjkMediaPlayer", "DP_MSG_INFO_CACHE_DURATION audioDuration:" + i + " videoDuration:" + i2);
                    ijkMediaPlayer.b(CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION, i2, bundle);
                    return;
                case 60001:
                    ijkMediaPlayer.h = message.arg1;
                    ijkMediaPlayer.i = message.arg2;
                    ijkMediaPlayer.a(ijkMediaPlayer.f, ijkMediaPlayer.g, ijkMediaPlayer.h, ijkMediaPlayer.i);
                    return;
                case IMConstants.ERROR_GROUP_NAME_NOT_VALID /* 60002 */:
                    ijkMediaPlayer.c(message.arg1 | (message.arg2 << 32));
                    return;
                default:
                    CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                    return;
            }
        }
    }

    /* loaded from: classes18.dex */
    public interface c {
        String a(int i);
    }

    /* loaded from: classes18.dex */
    public interface d {
        String a(tv.danmaku.ijk.media.player.b bVar, String str, int i, int i2);
    }

    /* loaded from: classes18.dex */
    public interface e {
        boolean a(int i, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<IjkMediaPlayer> f5402a;

        public f(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f5402a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.f5402a.get();
            if (ijkMediaPlayer == null || (ijkMediaPlayer.mNativeMediaPlayer == 0 && message.what != 12)) {
                CyberLog.w("IjkMediaPlayer", "IjkMediaPlayer went away with unhandled events msg.what:" + message.what);
                return;
            }
            switch (message.what) {
                case 1:
                    ijkMediaPlayer._stop();
                    return;
                case 2:
                    ijkMediaPlayer._release();
                    return;
                case 3:
                    ijkMediaPlayer._reset();
                    ijkMediaPlayer.b(0L);
                    ijkMediaPlayer.c(0L);
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
                    if (message.obj == null || !(message.obj instanceof String)) {
                        return;
                    }
                    try {
                        ijkMediaPlayer._setDataSource((String) message.obj, null, null);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                case 9:
                    if (message.obj == null || !(message.obj instanceof ArrayList)) {
                        return;
                    }
                    ArrayList arrayList = (ArrayList) message.obj;
                    ijkMediaPlayer._setStatisticInfo(message.arg1, (String) arrayList.get(0), (String) arrayList.get(1));
                    return;
                case 10:
                    ijkMediaPlayer._prepareAsync();
                    return;
                case 11:
                    if (message.obj == null || !(message.obj instanceof Long)) {
                        return;
                    }
                    ijkMediaPlayer._seekTo(((Long) message.obj).longValue());
                    return;
                case 12:
                    ijkMediaPlayer.native_setup(new WeakReference(ijkMediaPlayer));
                    return;
                case 13:
                    ijkMediaPlayer.l(ijkMediaPlayer);
                    return;
                case 14:
                    if (message.obj == null || !(message.obj instanceof Surface)) {
                        ijkMediaPlayer._setVideoSurface(null);
                        return;
                    } else {
                        ijkMediaPlayer._setVideoSurface((Surface) message.obj);
                        return;
                    }
                case 15:
                    if (message.obj == null || !(message.obj instanceof FileDescriptor)) {
                        return;
                    }
                    try {
                        ijkMediaPlayer.a((FileDescriptor) message.obj);
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 16:
                    ijkMediaPlayer._setLoopCount(message.arg1);
                    return;
                case 17:
                    if (message.obj == null || !(message.obj instanceof ArrayList)) {
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) message.obj;
                    ijkMediaPlayer._setOption(message.arg1, (String) arrayList2.get(0), (String) arrayList2.get(1));
                    return;
                case 18:
                    if (message.obj == null || !(message.obj instanceof ArrayList)) {
                        return;
                    }
                    ArrayList arrayList3 = (ArrayList) message.obj;
                    ijkMediaPlayer._setOption(message.arg1, (String) arrayList3.get(0), Long.valueOf((String) arrayList3.get(1)).longValue());
                    return;
                case 19:
                    ijkMediaPlayer._setUserHasClickStart(message.arg1 == 1);
                    return;
                case 20:
                    ijkMediaPlayer._muteOrUnmuteAudio(message.arg1 == 1);
                    return;
                case 21:
                    if (message.obj == null || !(message.obj instanceof String)) {
                        IjkMediaPlayer._changeHttpProxy(null, "false");
                        return;
                    } else {
                        IjkMediaPlayer._changeHttpProxy((String) message.obj, message.arg1 == 1 ? "true" : "false");
                        return;
                    }
                case 22:
                    Bundle data = message.getData();
                    if (data != null) {
                        float f = data.getFloat("left");
                        float f2 = data.getFloat(HorizontalTranslateLayout.DIRECTION_RIGHT);
                        CyberLog.i("IjkMediaPlayer", "_setVolume leftVolume:" + f + " rightVolume:" + f2);
                        ijkMediaPlayer._setVolume(f, f2);
                        return;
                    }
                    return;
                case 23:
                    if (message.obj == null || !(message.obj instanceof Float)) {
                        return;
                    }
                    ijkMediaPlayer._setPropertyFloat(message.arg1, ((Float) message.obj).floatValue());
                    return;
                case 24:
                    if (message.obj != null) {
                        ArrayList arrayList4 = (ArrayList) message.obj;
                        try {
                            ijkMediaPlayer.c((Context) arrayList4.get(0), (Uri) arrayList4.get(1));
                            return;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 25:
                    if (message.obj == null || !(message.obj instanceof ArrayList)) {
                        return;
                    }
                    ArrayList arrayList5 = (ArrayList) message.obj;
                    ijkMediaPlayer._setExternalInfo((String) arrayList5.get(0), message.arg1, Long.valueOf((String) arrayList5.get(1)).longValue(), (String) arrayList5.get(2));
                    return;
                default:
                    CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                    return;
            }
        }
    }

    public IjkMediaPlayer() {
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _changeHttpProxy(String str, String str2);

    private native String _getAudioCodecInfo();

    private static native String _getColorFormatName(int i);

    private native long _getCurrentPosition();

    private native int _getLoopCount();

    private native Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f2);

    private native long _getPropertyLong(int i, long j);

    private native String _getVideoCodecInfo();

    private native void _injectCacheNode(int i, long j, long j2, long j3, long j4);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _muteOrUnmuteAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _pause();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _release();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _reset();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _seekTo(long j);

    private native void _setAndroidIOCallback(IAndroidIO iAndroidIO);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setDataSource(String str, String[] strArr, String[] strArr2);

    private native void _setDataSource(IMediaDataSource iMediaDataSource);

    private native void _setDataSourceFd(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setExternalInfo(String str, int i, long j, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setLoopCount(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i, String str, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setOption(int i, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setPropertyFloat(int i, float f2);

    private native void _setPropertyLong(int i, long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void _setStatisticInfo(int i, String str, String str2);

    private native void _setStreamSelected(int i, boolean z);

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

    private boolean a(int i, int i2, int i3, Object obj) {
        if (this.p) {
            if (this.o != null) {
                this.o.sendMessage(this.o.obtainMessage(i, i2, i3, obj));
            }
            return true;
        }
        return false;
    }

    private boolean b(Context context, Uri uri) {
        boolean z = false;
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor != null) {
                z = true;
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } else if (openAssetFileDescriptor != null) {
                openAssetFileDescriptor.close();
            }
        } catch (IOException e2) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
        } catch (SecurityException e3) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
            throw th;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, Uri uri) {
        AssetFileDescriptor assetFileDescriptor;
        Throwable th;
        AssetFileDescriptor assetFileDescriptor2 = null;
        try {
            try {
                AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor == null) {
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                        return;
                    }
                    return;
                }
                try {
                    a(openAssetFileDescriptor.getFileDescriptor());
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                } catch (Throwable th2) {
                    assetFileDescriptor = openAssetFileDescriptor;
                    th = th2;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                assetFileDescriptor = null;
                th = th3;
            }
        } catch (IOException e2) {
            if (0 != 0) {
                assetFileDescriptor2.close();
            }
        } catch (SecurityException e3) {
            if (0 != 0) {
                assetFileDescriptor2.close();
            }
        }
    }

    private boolean c(int i) {
        if (this.p) {
            if (this.o != null) {
                this.o.sendEmptyMessage(i);
            }
            return true;
        }
        return false;
    }

    public static void e() {
        synchronized (IjkMediaPlayer.class) {
            if (!s) {
                native_init();
                native_setLogLevel(z());
                s = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Wakelock"})
    public void e(boolean z) {
        if (this.c != null) {
            if (z && !this.c.isHeld()) {
                this.c.acquire();
            } else if (!z && this.c.isHeld()) {
                this.c.release();
            }
        }
        this.e = z;
        x();
    }

    public static void f() {
        synchronized (IjkMediaPlayer.class) {
            if (!t) {
                Context applicationContext = CyberPlayerManager.getApplicationContext();
                PackageManager packageManager = applicationContext.getPackageManager();
                String packageName = applicationContext.getPackageName();
                String str = "0.0";
                String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(applicationContext);
                String sDKVersion = CyberPlayerManager.getSDKVersion();
                String b2 = Utils.b(applicationContext);
                if (packageManager != null) {
                    try {
                        str = packageManager.getPackageInfo(packageName, 0).versionName;
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                DuplayerCore.nativeStatisticInit(packageName, str, sDKVersion, SDKVersion.VERSION, b2, CyberPlayerManager.getClientID(), networkStatisticsData, CyberPlayerManager.getInstallOpts().get("abtest_sid"));
                DuplayerCore.nativeSetInfo(HttpConstants.HTTP_HARDWARE, Build.HARDWARE);
                DuplayerCore.nativeSetInfo("model", Build.MODEL);
                DuplayerCore.nativeSetInfo("os_version", Build.VERSION.RELEASE);
                DuplayerCore.nativeSetInfo(HttpConstants.HTTP_OS_TYPE, "Android");
                t = true;
            }
        }
    }

    @Keep
    private static String getIpList(Object obj, String str) {
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        List<String> b2 = ((IjkMediaPlayer) ((WeakReference) obj).get()).b(str);
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : b2) {
            sb.append(str2).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        }
        return sb.toString();
    }

    @Keep
    private static String getNetworkStatus(Object obj) {
        String str;
        if (((IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return "N/A";
        }
        try {
            Context applicationContext = CyberPlayerManager.getApplicationContext();
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    str = "Disconnect";
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 0) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        str = TextUtils.isEmpty(extraInfo) ? "Disconnect" : "mobile_" + extraInfo;
                    } else if (type == 1) {
                        WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                        if (wifiManager != null) {
                            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                            if (connectionInfo != null) {
                                int rssi = connectionInfo.getRssi();
                                str = rssi <= -127 ? "Disconnect" : "wifi:" + rssi;
                            } else {
                                str = "Disconnect";
                            }
                        } else {
                            str = "Disconnect";
                        }
                    } else {
                        str = "N/A";
                    }
                }
            } else {
                str = "N/A";
            }
            return str;
        } catch (Exception e2) {
            return "N/A";
        }
    }

    @Keep
    private static String getSessionNetworkType(Object obj) {
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

    public static native void nativeSetEnableFFmpegExtend(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_setup(Object obj);

    @Keep
    private static void onNativeHasShutDownEnd(Object obj) {
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
    private static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        if (obj == null || !(obj instanceof WeakReference)) {
            throw new IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer == null) {
            throw new IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        e eVar = ijkMediaPlayer.v;
        if (eVar == null || !eVar.a(i, bundle)) {
            switch (i) {
                case 131079:
                    c cVar = ijkMediaPlayer.u;
                    if (cVar == null) {
                        return false;
                    }
                    int i2 = bundle.getInt("segment_index", -1);
                    if (i2 < 0) {
                        throw new InvalidParameterException("onNativeInvoke(invalid segment index)");
                    }
                    String a2 = cVar.a(i2);
                    if (a2 == null) {
                        throw new RuntimeException(new IOException("onNativeInvoke() = <NULL newUrl>"));
                    }
                    bundle.putString("url", a2);
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    @Keep
    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        if (obj == null || !(obj instanceof WeakReference)) {
            return null;
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
        if (ijkMediaPlayer == null) {
            return null;
        }
        d dVar = ijkMediaPlayer.w;
        if (dVar == null) {
            dVar = a.f5400a;
        }
        return dVar.a(ijkMediaPlayer, str, i, i2);
    }

    @Keep
    private static void onUploadStatisticData(Object obj, String str, int i) {
        DpSessionDatasUploader.getInstance().upload(str, DpSessionDatasUploader.SAILOR_MONITOR, i);
    }

    @Keep
    private static void onVideoFlowCallback(String str) {
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
    private static int postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj != null && (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) != null) {
            if (i == 200 && i2 == 2) {
                ijkMediaPlayer.h();
            }
            if (ijkMediaPlayer.b != null) {
                ijkMediaPlayer.b.sendMessage(ijkMediaPlayer.b.obtainMessage(i, i2, i3, obj2));
            }
            return 0;
        }
        return -1;
    }

    private void v() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.b = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.b = new b(this, mainLooper);
            } else {
                this.b = null;
            }
        }
        this.p = false;
        if (!Utils.d(CyberPlayerManager.getApplicationContext()) || Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.n = DuplayerHandlerThreadPool.getInstance().obtain();
            this.o = new f(this, this.n.getLooper());
            CyberLog.i("IjkMediaPlayer", "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.o);
            this.p = true;
        } else {
            CyberLog.i("IjkMediaPlayer", "create player in thread, don't use request handler. thread:" + Thread.currentThread().getName());
            this.o = null;
        }
        if (!c(12)) {
            native_setup(new WeakReference(this));
        }
        if (c(13)) {
            return;
        }
        l(this);
    }

    private void w() {
        this.f = 0;
        this.g = 0;
        this.h = 1;
        this.i = 1;
        this.j = 0L;
        this.k = 0L;
        if (!c(13)) {
            l(this);
        }
        b(this.q);
    }

    private void x() {
        if (this.f5399a != null) {
            this.f5399a.setKeepScreenOn(this.d && this.e);
        }
    }

    private synchronized void y() {
        if (this.p) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.n);
            this.n = null;
        }
    }

    private static int z() {
        return 8 - CyberLog.getLogLevel();
    }

    public native void _prepareAsync();

    @Override // tv.danmaku.ijk.media.player.a
    public void a() {
        super.a();
        this.w = null;
    }

    public void a(float f2) {
        if (a(23, 10003, 0, Float.valueOf(f2))) {
            return;
        }
        _setPropertyFloat(10003, f2);
    }

    public void a(float f2, float f3) {
        if (this.o == null) {
            _setVolume(f2, f3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat("left", f2);
        bundle.putFloat(HorizontalTranslateLayout.DIRECTION_RIGHT, f3);
        Message obtainMessage = this.o.obtainMessage(22);
        obtainMessage.setData(bundle);
        this.o.sendMessage(obtainMessage);
    }

    public void a(int i, String str, long j) {
        if (this.o == null) {
            _setOption(i, str, j);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(j));
        if (a(18, i, 0, arrayList)) {
            return;
        }
        _setOption(i, str, j);
    }

    public void a(int i, String str, String str2) {
        if (this.o == null) {
            _setOption(i, str, str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (a(17, i, 0, arrayList)) {
            return;
        }
        _setOption(i, str, str2);
    }

    public void a(long j) {
        if (a(11, 0, 0, Long.valueOf(j))) {
            return;
        }
        _seekTo(j);
    }

    @SuppressLint({"Wakelock"})
    public void a(Context context, int i) {
        boolean z;
        boolean z2;
        if (this.c != null) {
            if (this.c.isHeld()) {
                z2 = true;
                this.c.release();
            } else {
                z2 = false;
            }
            this.c = null;
            z = z2;
        } else {
            z = false;
        }
        this.c = ((PowerManager) context.getSystemService("power")).newWakeLock(536870912 | i, "duplayer");
        this.c.setReferenceCounted(false);
        if (z) {
            this.c.acquire();
        }
    }

    public void a(Context context, Uri uri) {
        a(context, uri, (Map<String, String>) null);
    }

    @TargetApi(14)
    public void a(Context context, Uri uri, Map<String, String> map) {
        String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            a(uri.getPath());
        } else if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Failed to resolve default ringtone");
        } else {
            if (!b(context, uri)) {
                a(uri.toString(), map);
                return;
            }
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
        if (this.d && surface != null) {
            CyberLog.w("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f5399a = null;
        if (!a(14, 0, 0, surface)) {
            _setVideoSurface(surface);
        }
        x();
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f5399a = surfaceHolder;
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
        if (Build.VERSION.SDK_INT >= 12) {
            ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
            try {
                _setDataSourceFd(dup.getFd());
                return;
            } finally {
                dup.close();
            }
        }
        try {
            Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            _setDataSourceFd(declaredField.getInt(fileDescriptor));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void a(String str) {
        this.l = str;
        com.baidu.media.duplayer.a.a(SocialConstants.PARAM_PLAY_URL, str);
        if (a(8, 0, 0, str)) {
            return;
        }
        _setDataSource(str, null, null);
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
                    sb.append("\r\n");
                }
            }
            a(1, "headers", sb.toString());
        }
        a(str);
    }

    public void a(String str, boolean z) {
        if (a(21, z ? 1 : 0, 0, str)) {
            return;
        }
        _changeHttpProxy(str, z ? "true" : "false");
    }

    public void a(e eVar) {
        this.v = eVar;
    }

    public void a(boolean z) {
        if (this.d != z) {
            if (z && this.f5399a == null) {
                CyberLog.i("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.d = z;
            x();
        }
    }

    public List<String> b(String str) {
        if (this.m != null) {
            return this.m.getIpList(str);
        }
        return null;
    }

    public void b(int i) {
        this.q = i;
        if (this.q == 1) {
            a(4, "mediacodec-all-videos", 0L);
        } else if (this.q == 2 || this.q == 0) {
            a(4, "mediacodec-all-videos", 1L);
        }
        a(4, "decode-mode", i);
    }

    public void b(int i, String str, String str2) {
        if (this.o == null) {
            _setStatisticInfo(i, str, str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (a(9, i, 0, arrayList)) {
            return;
        }
        _setStatisticInfo(i, str, str2);
    }

    public void b(long j) {
        this.k = j;
    }

    @TargetApi(13)
    public void b(FileDescriptor fileDescriptor) {
        if (a(15, -1, -1, fileDescriptor)) {
            return;
        }
        a(fileDescriptor);
    }

    public void b(boolean z) {
        int i = z ? 0 : 1;
        a(4, "loop", i);
        if (a(16, i, 0, (Object) null)) {
            return;
        }
        _setLoopCount(i);
    }

    public void c(long j) {
        this.j = j;
    }

    public void c(boolean z) {
        if (a(19, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _setUserHasClickStart(z);
    }

    public void d(boolean z) {
        if (a(20, z ? 1 : 0, 0, (Object) null)) {
            return;
        }
        _muteOrUnmuteAudio(z);
    }

    protected void finalize() {
        super.finalize();
        if (this.o != null) {
            this.o.removeCallbacksAndMessages(null);
        }
        if (!c(4)) {
            native_finalize();
            return;
        }
        this.o = null;
        y();
    }

    public void g() {
        if (c(10)) {
            return;
        }
        _prepareAsync();
    }

    public native int getAudioSessionId();

    public void h() {
        e(true);
        if (c(7)) {
            return;
        }
        _start();
    }

    public void i() {
        e(false);
        if (c(1)) {
            return;
        }
        _stop();
    }

    public native boolean isPlaying();

    public void j() {
        e(false);
        if (c(6)) {
            return;
        }
        _pause();
    }

    public int k() {
        return this.f;
    }

    public int l() {
        return this.g;
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
            if (this.o != null) {
                this.o.removeCallbacksAndMessages(null);
            }
            this.b.removeCallbacksAndMessages(null);
            if (c(2)) {
                this.o = null;
            } else {
                _release();
            }
        }
    }

    public void q() {
        e(false);
        if (this.o != null) {
            this.o.removeCallbacksAndMessages(null);
        }
        if (!c(3)) {
            _reset();
        }
        this.b.removeCallbacksAndMessages(null);
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
