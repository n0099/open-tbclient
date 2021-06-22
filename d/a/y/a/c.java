package d.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.PathUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.media.duplayer.Utils;
import com.baidu.media.duplayer.d;
import com.baidu.media.duplayer.monitor.DuplayerQualityMonitorManager;
import com.baidu.media.ext.CyberMediaExtLoader;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f68684a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68685b;

    /* renamed from: c  reason: collision with root package name */
    public static String f68686c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f68687d;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.d();
        }
    }

    public static void a(int i2, Map<String, String> map) {
        int i3;
        int j = e.b().j(i2);
        if ((f68684a & j) == j) {
            return;
        }
        do {
            i3 = (f68684a ^ j) & j;
            if (i3 <= 0) {
                break;
            }
        } while (l(1 << Integer.numberOfTrailingZeros(i3), map));
        e.b().s();
    }

    public static void b(Context context, String str) {
        f68686c = str;
        f68687d = Utils.t(context);
        e.b().f(context, str);
    }

    public static void c(Context context, Map<String, String> map) {
        String str;
        String str2;
        CyberLog.d("CyberLibsLoader", "initCyberPlayer");
        IjkMediaPlayer.e();
        IjkMediaPlayer.f();
        String str3 = map != null ? map.get("cache-path") : null;
        CyberTaskExcutor.getInstance().execute(new a());
        if (str3 == null) {
            str = Utils.b(context) + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + Utils.f8039c + File.separator + context.getPackageName() + File.separator;
        } else {
            str = str3 + File.separator + Utils.f8039c + File.separator;
        }
        if (f68687d) {
            str = str + "remote" + File.separator;
        }
        Utils.f(str);
        int i2 = 5;
        if (map != null && (str2 = map.get(CyberPlayerManager.INSTALL_OPT_PIPELINE_NUM)) != null) {
            try {
                i2 = Integer.parseInt(str2);
            } catch (Exception unused) {
            }
        }
        Utils.c(i2);
        Utils.q();
        m();
        n();
    }

    public static boolean d(int i2) {
        int j = e.b().j(i2);
        return (f68684a & j) == j;
    }

    public static boolean e(int i2, String str) {
        if (f68687d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
            if (i2 != 512) {
                System.load(str);
            } else {
                String str2 = f68686c + File.separator + "model_video-sr_1.2";
                String str3 = str2 + File.separator + "params.mlm";
                if (!new File(str2 + File.separator + "model.mlm").exists() || !new File(str3).exists()) {
                    throw new FileNotFoundException("model_video-sr_1.2.zip");
                }
                CyberLog.d("CyberLibsLoader", "initVideoSR");
                Utils.g(str, str2);
            }
            return true;
        }
        return false;
    }

    public static boolean f(String str) {
        if (f68687d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_BSO, false)) {
            Utils.m(str);
            return true;
        }
        return false;
    }

    public static String[] g() {
        return e.b().o();
    }

    public static String h() {
        return f68685b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean i(int i2, Map<String, String> map) {
        String str;
        int i3;
        StringBuilder sb;
        String error;
        String str2;
        if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_CRASHPAD, true)) {
            String str3 = null;
            String str4 = "-1";
            if (map != null) {
                String str5 = map.get(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE);
                if (!TextUtils.isEmpty(str5)) {
                    try {
                        i3 = Integer.parseInt(str5);
                    } catch (Exception unused) {
                    }
                    str = map.get("abtest_sid");
                    str2 = map.get(CyberPlayerManager.INSTALL_OPT_PROCESS_TYPE);
                    if (!TextUtils.isEmpty(str2)) {
                        str4 = str2;
                    }
                }
                i3 = 3;
                str = map.get("abtest_sid");
                str2 = map.get(CyberPlayerManager.INSTALL_OPT_PROCESS_TYPE);
                if (!TextUtils.isEmpty(str2)) {
                }
            } else {
                str = null;
                i3 = 3;
            }
            if (f68687d) {
                if ((i3 & 2) != 2) {
                    return false;
                }
            } else if ((i3 & 1) != 1) {
                return false;
            }
            if (b.e()) {
                if (i2 == 1) {
                    return true;
                }
                try {
                    try {
                        File file = new File(e.b().a(1).j());
                        File file2 = new File(e.b().a(2).j());
                        String parent = file.getParent();
                        String parent2 = file2.getParent();
                        try {
                            str3 = CyberPlayerManager.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
                        } catch (Exception unused2) {
                        }
                        if (f68687d) {
                            str4 = "4";
                        }
                        if (!file2.canExecute()) {
                            file2.setExecutable(true);
                            CyberLog.d("CyberLibsLoader", "set " + file2.getAbsolutePath() + " executable");
                        }
                        String[] strArr = {SDKVersion.VERSION, "neon", CyberPlayerManager.getClientID(), "unKnown", "0", "0", str4, "true", str3, GlobalConstants.DEFAULT_VERSION, parent, parent2, ""};
                        b.d(true);
                        b.a(CyberPlayerManager.getApplicationContext(), strArr);
                        b.b("{searchbox_sid=" + str + "}");
                        return true;
                    } catch (Exception e2) {
                        sb = new StringBuilder();
                        sb.append("initCrashPad Exception:");
                        error = e2.toString();
                        sb.append(error);
                        CyberLog.e("CyberLibsLoader", sb.toString());
                        return false;
                    }
                } catch (Error e3) {
                    sb = new StringBuilder();
                    sb.append("initCrashPad Error:");
                    error = e3.toString();
                    sb.append(error);
                    CyberLog.e("CyberLibsLoader", sb.toString());
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean j(String str) {
        if (f68687d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_DMO, false)) {
            Utils.o(str);
            return true;
        }
        return false;
    }

    public static String k() {
        return f68686c;
    }

    public static boolean l(int i2, Map<String, String> map) {
        com.baidu.media.duplayer.d a2 = e.b().a(i2);
        boolean z = false;
        if (a2 == null) {
            CyberLog.e("CyberLibsLoader", "Unable to find (" + i2 + ") LibInfo");
            return false;
        }
        String a3 = a2.a();
        String d2 = a2.d();
        String j = a2.j();
        File file = new File(j);
        if (a2.l() == d.a.LIB_TYPE_JAR) {
            if (!"apk_internal_jar".equals(j)) {
                if (file.exists()) {
                    if (e.b().C(i2)) {
                        z = CyberMediaExtLoader.init(CyberPlayerManager.getApplicationContext());
                    }
                } else if (CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_RTC, false)) {
                    throw new FileNotFoundException(e.b().q(i2));
                } else {
                    CyberLog.e("CyberLibsLoader", "not exist: " + a3);
                }
            }
            z = true;
        } else {
            if (a2.l() == d.a.LIB_TYPE_SO) {
                if (!file.exists() && !a2.p()) {
                    if (i2 == 8) {
                        i2 = 16;
                    }
                    throw new FileNotFoundException(e.b().q(i2));
                } else if (e.b().u(i2)) {
                    System.load(j);
                    if (i2 == 16) {
                        c(CyberPlayerManager.getApplicationContext(), map);
                    }
                } else if (e.b().w(i2)) {
                    IjkMediaPlayer.nativeSetEnableFFmpegExtend(j);
                } else if (e.b().y(i2)) {
                    f68685b = j;
                } else if (e.b().E(i2)) {
                    z = i(i2, map);
                } else if (e.b().A(i2)) {
                    z = e(i2, j);
                } else if (e.b().F(i2)) {
                    z = i2 == 4096 ? f(j) : true;
                    if (i2 == 8192) {
                        z = j(j);
                    }
                }
            }
            z = true;
        }
        f68684a = i2 | f68684a;
        if (z) {
            CyberLog.d("CyberLibsLoader", "isMediaProcess:" + f68687d + " abi:" + e.b().p() + " lib:" + a3 + " ver:" + d2 + " path:" + j + " load success");
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007d A[Catch: Exception -> 0x0082, TRY_LEAVE, TryCatch #0 {Exception -> 0x0082, blocks: (B:5:0x000e, B:7:0x0061, B:9:0x0065, B:17:0x007d, B:11:0x006b, B:13:0x0076), top: B:20:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m() {
        boolean z = true;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MONITOR, true)) {
            return;
        }
        try {
            String str = f68686c + File.separator + "config";
            String str2 = str + File.separator + LibsInfoDef.CYBER_CODEC_MONITOR_NAME + "_" + CyberCfgManager.getInstance().getCfgValue("monitor_version", LibsInfoDef.CYBER_CODEC_MONITOR_VERSION) + ".json";
            File file = new File(str);
            if (file.exists()) {
                if (!new File(str2).exists() && !f68687d) {
                    z = false;
                }
                if (z) {
                }
            } else {
                if (f68687d) {
                    file.mkdirs();
                    if (z) {
                        Utils.h(str2, f68687d);
                        return;
                    }
                    return;
                }
                z = false;
                if (z) {
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073 A[Catch: Exception -> 0x007c, TRY_LEAVE, TryCatch #0 {Exception -> 0x007c, blocks: (B:5:0x000e, B:7:0x0057, B:9:0x005b, B:17:0x0073, B:11:0x0061, B:13:0x006c), top: B:20:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n() {
        boolean z = true;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_PLAY_SCORE_MONITOR, true)) {
            return;
        }
        try {
            String str = f68686c + File.separator + "config";
            String str2 = str + File.separator + LibsInfoDef.CYBER_PLAY_SCORE_STORAGE_NAME + "_" + LibsInfoDef.CYBER_PLAY_SCORE_STORAGE_VERSION + ".json";
            File file = new File(str);
            if (file.exists()) {
                if (!new File(str2).exists() && !f68687d) {
                    z = false;
                }
                if (z) {
                }
            } else {
                if (f68687d) {
                    file.mkdirs();
                    if (z) {
                        DuplayerQualityMonitorManager.getInstance().init(str2, f68687d);
                        return;
                    }
                    return;
                }
                z = false;
                if (z) {
                }
            }
        } catch (Exception unused) {
        }
    }
}
