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
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpNetworkUtils;
import com.baidu.cyberplayer.sdk.statistics.DpSessionDatasUploader;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThread;
import com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.media.duplayer.DuplayerCore;
import com.baidu.media.duplayer.Keep;
import com.baidu.media.duplayer.Utils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidubce.auth.NTLMEngineImpl;
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
/* loaded from: classes7.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.a {
    public static volatile boolean r = false;
    public static volatile boolean s = false;
    public static volatile boolean t = false;

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f68659a;

    /* renamed from: b  reason: collision with root package name */
    public b f68660b;

    /* renamed from: c  reason: collision with root package name */
    public PowerManager.WakeLock f68661c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68662d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68663e;

    /* renamed from: f  reason: collision with root package name */
    public int f68664f;

    /* renamed from: g  reason: collision with root package name */
    public int f68665g;

    /* renamed from: h  reason: collision with root package name */
    public int f68666h;
    public int i;
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
    public boolean p;
    public int q;
    public c u;
    public e v;
    public d w;

    /* loaded from: classes7.dex */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f68667a = new a();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.d
        @TargetApi(16)
        public String a(tv.danmaku.ijk.media.player.b bVar, String str, int i, int i2) {
            return d.b.w.a.d.b(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f68668a;

        public b(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f68668a = new WeakReference<>(ijkMediaPlayer);
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
                hashMap.put(DpStatConstants.KEY_PREPARED, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9);
                hashMap.put("start_play", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                hashMap.put("frame_decoded", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                hashMap.put("render_pic", Constants.VIA_REPORT_TYPE_SET_AVATAR);
                hashMap.put(DpStatConstants.KEY_FIRST_DISPLAY, Constants.VIA_REPORT_TYPE_JOININ_GROUP);
                hashMap.put("kernel_total", Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            String str;
            IjkMediaPlayer ijkMediaPlayer = this.f68668a.get();
            if (ijkMediaPlayer != null) {
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i2 = message.what;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            ijkMediaPlayer.b();
                            ijkMediaPlayer.b(10005, 0, (Object) null);
                            return;
                        } else if (i2 == 2) {
                            ijkMediaPlayer.e(false);
                            ijkMediaPlayer.b(10004, 0, (Object) null);
                            ijkMediaPlayer.c();
                            return;
                        } else if (i2 == 3) {
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long o = ijkMediaPlayer.o();
                            long j2 = o > 0 ? (j * 100) / o : 0L;
                            ijkMediaPlayer.a((int) (j2 < 100 ? j2 : 100L));
                            return;
                        } else if (i2 == 4) {
                            ijkMediaPlayer.d();
                            return;
                        } else if (i2 == 5) {
                            ijkMediaPlayer.f68664f = message.arg1;
                            ijkMediaPlayer.f68665g = message.arg2;
                            ijkMediaPlayer.a(ijkMediaPlayer.f68664f, ijkMediaPlayer.f68665g, ijkMediaPlayer.f68666h, ijkMediaPlayer.i);
                            ijkMediaPlayer.b(10006, 0, (Object) null);
                            return;
                        } else if (i2 == 99) {
                            if (message.obj == null) {
                                ijkMediaPlayer.a((tv.danmaku.ijk.media.player.c) null);
                                return;
                            } else {
                                ijkMediaPlayer.a(new tv.danmaku.ijk.media.player.c(new Rect(0, 0, 1, 1), (String) message.obj));
                                return;
                            }
                        } else if (i2 == 100) {
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
                        } else if (i2 != 200) {
                            if (i2 == 300) {
                                ijkMediaPlayer.c(message.arg1, message.arg2, message.obj);
                                return;
                            } else if (i2 != 953) {
                                switch (i2) {
                                    case 60001:
                                        ijkMediaPlayer.f68666h = message.arg1;
                                        ijkMediaPlayer.i = message.arg2;
                                        ijkMediaPlayer.a(ijkMediaPlayer.f68664f, ijkMediaPlayer.f68665g, ijkMediaPlayer.f68666h, ijkMediaPlayer.i);
                                        return;
                                    case IMConstants.ERROR_GROUP_NAME_NOT_VALID /* 60002 */:
                                        ijkMediaPlayer.c(message.arg1 | (message.arg2 << 32));
                                        return;
                                    default:
                                        CyberLog.e("IjkMediaPlayer", "Unknown message type " + message.what);
                                        return;
                                }
                            } else {
                                int i3 = message.arg1;
                                int i4 = message.arg2;
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("audio_duration", i3);
                                    jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, i4);
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                                CyberLog.d("IjkMediaPlayer", "DP_MSG_INFO_CACHE_DURATION audioDuration:" + i3 + " videoDuration:" + i4);
                                ijkMediaPlayer.b(CyberPlayerManager.DP_MSG_INFO_CACHE_DURATION, i4, jSONObject.toString());
                                return;
                            }
                        } else {
                            int i5 = message.arg1;
                            if (i5 == 3) {
                                CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                                Object obj = message.obj;
                                if (obj != null) {
                                    str = a((String) obj);
                                    i = message.arg2;
                                } else {
                                    i = message.arg2;
                                    str = "";
                                }
                                ijkMediaPlayer.b(904, i, str);
                                return;
                            } else if (i5 == 910) {
                                ijkMediaPlayer.b(message.arg2);
                                ijkMediaPlayer.b(message.arg1, message.arg2, message.obj);
                                return;
                            } else if (i5 == 931) {
                                CyberLog.d("IjkMediaPlayer", "Info: MEDIA_INFO_SERVER_CHANGE server : " + ((String) message.obj));
                                ijkMediaPlayer.b(5000, message.arg2, message.obj);
                                return;
                            } else if (i5 != 12002) {
                                ijkMediaPlayer.b(i5, message.arg2, message.obj);
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

    /* loaded from: classes7.dex */
    public interface c {
        String a(int i);
    }

    /* loaded from: classes7.dex */
    public interface d {
        String a(tv.danmaku.ijk.media.player.b bVar, String str, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface e {
        boolean a(int i, Bundle bundle);
    }

    /* loaded from: classes7.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<IjkMediaPlayer> f68669a;

        public f(IjkMediaPlayer ijkMediaPlayer, Looper looper) {
            super(looper);
            this.f68669a = new WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IjkMediaPlayer ijkMediaPlayer = this.f68669a.get();
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
                        ijkMediaPlayer._seekTo(((Long) obj3).longValue());
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

    public static native void _changeHttpProxy(String str, String str2);

    private native String _getAudioCodecInfo();

    public static native String _getColorFormatName(int i);

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
            f fVar = this.o;
            if (fVar != null) {
                this.o.sendMessage(fVar.obtainMessage(i, i2, i3, obj));
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean b(Context context, Uri uri) {
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7663a);
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
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, r.f7663a);
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

    private boolean d(int i) {
        if (this.p) {
            f fVar = this.o;
            if (fVar != null) {
                fVar.sendEmptyMessage(i);
                return true;
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
        PowerManager.WakeLock wakeLock = this.f68661c;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.f68661c.acquire();
            } else if (!z && this.f68661c.isHeld()) {
                this.f68661c.release();
            }
        }
        this.f68663e = z;
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
                String j = Utils.j(applicationContext);
                if (packageManager != null) {
                    try {
                        str = packageManager.getPackageInfo(packageName, 0).versionName;
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                DuplayerCore.nativeStatisticInit(packageName, str, sDKVersion, SDKVersion.VERSION, j, CyberPlayerManager.getClientID(), networkStatisticsData, CyberPlayerManager.getInstallOpts().get("abtest_sid"));
                DuplayerCore.nativeSetInfo("hardware", Build.HARDWARE);
                DuplayerCore.nativeSetInfo("model", Build.MODEL);
                DuplayerCore.nativeSetInfo("os_version", Build.VERSION.RELEASE);
                DuplayerCore.nativeSetInfo("os_type", "Android");
                t = true;
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
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
        if (com.baidu.cyberplayer.sdk.config.CyberCfgManager.getInstance().getCfgBoolValue(com.baidu.cyberplayer.sdk.config.CyberCfgManager.KEY_INT_ENABLE_MEDIACODEC_OMX_GOOGLE_HEVC, true) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(IjkMediaPlayer ijkMediaPlayer) {
        if (CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_ACCURATE_SEEK_ENABLE, 1) == 0) {
            ijkMediaPlayer._setOption(4, "enable-accurate-seek", 0L);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ijkMediaPlayer._setOption(4, "mediacodec-reuse-enable", CyberCfgManager.getInstance().getCfgIntValue(CyberCfgManager.KEY_INT_ENABLE_MEDIACODEC_REUSE, 1));
        }
        ijkMediaPlayer._setOption(4, "mediacodec-enable-omx-google-hevc", 0L);
        ijkMediaPlayer._setOption(1, "protocol_whitelist", "http,https,rtmp,tls,rtp,tcp,udp,crypto,httpproxy,proxytcp,file,pipe");
    }

    private native void nativeSetClarityInfo(String str);

    public static native void nativeSetEnableFFmpegExtend(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSetPlayJson(String str);

    private native void nativeSwitchMediaSource(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void native_finalize();

    public static native void native_init();

    private native void native_message_loop(Object obj);

    public static native void native_profileBegin(String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

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
    public static boolean onNativeInvoke(Object obj, int i, Bundle bundle) {
        String str;
        c cVar;
        if (obj == null || !(obj instanceof WeakReference)) {
            str = "<null weakThiz>.onNativeInvoke()";
        } else {
            IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get();
            if (ijkMediaPlayer == null) {
                str = "<null weakPlayer>.onNativeInvoke()";
            } else {
                e eVar = ijkMediaPlayer.v;
                if (eVar != null && eVar.a(i, bundle)) {
                    return true;
                }
                if (i != 131079 || (cVar = ijkMediaPlayer.u) == null) {
                    return false;
                }
                int i2 = bundle.getInt("segment_index", -1);
                if (i2 < 0) {
                    str = "onNativeInvoke(invalid segment index)";
                } else {
                    String a2 = cVar.a(i2);
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
    public static String onSelectCodec(Object obj, String str, int i, int i2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        d dVar = ijkMediaPlayer.w;
        if (dVar == null) {
            dVar = a.f68667a;
        }
        return dVar.a(ijkMediaPlayer, str, i, i2);
    }

    @Keep
    public static void onUploadStatisticData(Object obj, String str, int i) {
        DpSessionDatasUploader.getInstance().upload(str, DpSessionDatasUploader.SAILOR_MONITOR, i);
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
    public static int postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (IjkMediaPlayer) ((WeakReference) obj).get()) == null) {
            return -1;
        }
        if (i == 200 && i2 == 2) {
            ijkMediaPlayer.h();
        }
        b bVar = ijkMediaPlayer.f68660b;
        if (bVar != null) {
            ijkMediaPlayer.f68660b.sendMessage(bVar.obtainMessage(i, i2, i3, obj2));
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() {
        b bVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            bVar = new b(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                this.f68660b = null;
                this.p = false;
                if (Utils.n(CyberPlayerManager.getApplicationContext()) || Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    this.n = DuplayerHandlerThreadPool.getInstance().obtain();
                    this.o = new f(this, this.n.getLooper());
                    CyberLog.i("IjkMediaPlayer", "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.o);
                    this.p = true;
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
        this.f68660b = bVar;
        this.p = false;
        if (Utils.n(CyberPlayerManager.getApplicationContext())) {
        }
        this.n = DuplayerHandlerThreadPool.getInstance().obtain();
        this.o = new f(this, this.n.getLooper());
        CyberLog.i("IjkMediaPlayer", "create player in main thread, use request handler. thread:" + Thread.currentThread().getName() + " request thread:" + this.n.getName() + " mRequestHandler:" + this.o);
        this.p = true;
        if (!d(12)) {
        }
        if (d(13)) {
        }
    }

    private void w() {
        this.f68664f = 0;
        this.f68665g = 0;
        this.f68666h = 1;
        this.i = 1;
        this.j = 0L;
        this.k = 0L;
        if (!d(13)) {
            l(this);
        }
        c(this.q);
    }

    private void x() {
        SurfaceHolder surfaceHolder = this.f68659a;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.f68662d && this.f68663e);
        }
    }

    private synchronized void y() {
        if (this.p) {
            DuplayerHandlerThreadPool.getInstance().recycle(this.n);
            this.n = null;
        }
    }

    public static int z() {
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
        bundle.putFloat(CustomDialogData.POS_LEFT, f2);
        bundle.putFloat("right", f3);
        Message obtainMessage = this.o.obtainMessage(22);
        obtainMessage.setData(bundle);
        this.o.sendMessage(obtainMessage);
    }

    public void a(int i, String str, long j) {
        if (this.o != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(String.valueOf(j));
            if (a(18, i, 0, arrayList)) {
                return;
            }
        }
        _setOption(i, str, j);
    }

    public void a(int i, String str, String str2) {
        if (this.o != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(str2);
            if (a(17, i, 0, arrayList)) {
                return;
            }
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
        PowerManager.WakeLock wakeLock = this.f68661c;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.f68661c.release();
            } else {
                z = false;
            }
            this.f68661c = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH, "duplayer");
        this.f68661c = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.f68661c.acquire();
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
        if (this.f68662d && surface != null) {
            CyberLog.w("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.f68659a = null;
        if (!a(14, 0, 0, surface)) {
            _setVideoSurface(surface);
        }
        x();
    }

    public void a(SurfaceHolder surfaceHolder) {
        this.f68659a = surfaceHolder;
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
        int i = -1;
        try {
            Field declaredField = fileDescriptor.getClass().getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            i = declaredField.getInt(fileDescriptor);
        } catch (IllegalAccessException e2) {
            message = e2.getMessage();
            CyberLog.e("IjkMediaPlayer", message);
            _setDataSourceFd(i);
        } catch (NoSuchFieldException e3) {
            message = e3.getMessage();
            CyberLog.e("IjkMediaPlayer", message);
            _setDataSourceFd(i);
        }
        _setDataSourceFd(i);
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
        this.v = eVar;
    }

    public void a(boolean z) {
        if (this.f68662d != z) {
            if (z && this.f68659a == null) {
                CyberLog.i("IjkMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.f68662d = z;
            x();
        }
    }

    public void b(int i) {
        nativeSwitchMediaSource(i);
    }

    public void b(int i, String str, String str2) {
        if (this.o != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(str2);
            if (a(9, i, 0, arrayList)) {
                return;
            }
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

    public void b(String str) {
        this.l = str;
        d.b.w.a.b.c(SocialConstants.PARAM_PLAY_URL, str);
        if (a(8, 0, 0, str)) {
            return;
        }
        _setDataSource(str, null, null);
    }

    public void b(boolean z) {
        int i = !z ? 1 : 0;
        a(4, "loop", i);
        if (a(16, i, 0, (Object) null)) {
            return;
        }
        _setLoopCount(i);
    }

    public void c(int i) {
        long j;
        this.q = i;
        if (i != 1) {
            j = (i == 2 || i == 0) ? 1L : 1L;
            a(4, "decode-mode", i);
        }
        j = 0;
        a(4, "mediacodec-all-videos", j);
        a(4, "decode-mode", i);
    }

    public void c(long j) {
        this.j = j;
    }

    public void c(String str) {
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
        super.finalize();
        f fVar = this.o;
        if (fVar != null) {
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
        return this.f68664f;
    }

    public int l() {
        return this.f68665g;
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
            this.f68660b.removeCallbacksAndMessages(null);
            if (d(2)) {
                this.o = null;
            } else {
                _release();
            }
        }
    }

    public void q() {
        e(false);
        f fVar = this.o;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        if (!d(3)) {
            _reset();
        }
        this.f68660b.removeCallbacksAndMessages(null);
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
