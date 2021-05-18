package d.a.w.a;

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
    public static volatile int f64809a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64810b;

    /* renamed from: c  reason: collision with root package name */
    public static String f64811c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64812d;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.d();
        }
    }

    public static void a(int i2, Map<String, String> map) {
        int i3;
        int h2 = e.b().h(i2);
        if ((f64809a & h2) == h2) {
            return;
        }
        do {
            i3 = (f64809a ^ h2) & h2;
            if (i3 <= 0) {
                break;
            }
        } while (j(1 << Integer.numberOfTrailingZeros(i3), map));
        e.b().o();
    }

    public static void b(Context context, String str) {
        f64811c = str;
        f64812d = Utils.p(context);
        e.b().e(context, str);
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
            str = Utils.b(context) + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + Utils.f8094c + File.separator + context.getPackageName() + File.separator;
        } else {
            str = str3 + File.separator + Utils.f8094c + File.separator;
        }
        if (f64812d) {
            str = str + "remote" + File.separator;
        }
        Utils.e(str);
        int i2 = 5;
        if (map != null && (str2 = map.get(CyberPlayerManager.INSTALL_OPT_PIPELINE_NUM)) != null) {
            try {
                i2 = Integer.parseInt(str2);
            } catch (Exception unused) {
            }
        }
        Utils.c(i2);
        Utils.o();
        k();
    }

    public static boolean d(int i2) {
        int h2 = e.b().h(i2);
        return (f64809a & h2) == h2;
    }

    public static boolean e(int i2, String str) {
        if (f64812d && CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_SR, true)) {
            if (i2 != 512) {
                System.load(str);
            } else {
                String str2 = f64811c + File.separator + "model_video-sr_1.2";
                String str3 = str2 + File.separator + "params.mlm";
                if (!new File(str2 + File.separator + "model.mlm").exists() || !new File(str3).exists()) {
                    throw new FileNotFoundException("model_video-sr_1.2.zip");
                }
                CyberLog.d("CyberLibsLoader", "initVideoSR");
                Utils.f(str, str2);
            }
            return true;
        }
        return false;
    }

    public static String[] f() {
        return e.b().l();
    }

    public static String g() {
        return f64810b;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean h(int i2, Map<String, String> map) {
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
            if (f64812d) {
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
                        File file = new File(e.b().a(1).d());
                        File file2 = new File(e.b().a(2).d());
                        String parent = file.getParent();
                        String parent2 = file2.getParent();
                        try {
                            str3 = CyberPlayerManager.getApplicationContext().getExternalFilesDir("").getAbsolutePath();
                        } catch (Exception unused2) {
                        }
                        if (f64812d) {
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

    public static String i() {
        return f64811c;
    }

    public static boolean j(int i2, Map<String, String> map) {
        boolean e2;
        com.baidu.media.duplayer.d a2 = e.b().a(i2);
        if (a2 == null) {
            CyberLog.e("CyberLibsLoader", "Unable to find (" + i2 + ") LibInfo");
            return false;
        }
        String a3 = a2.a();
        String c2 = a2.c();
        String d2 = a2.d();
        File file = new File(d2);
        if (a2.e() == d.a.LIB_TYPE_JAR) {
            if (!"apk_internal_jar".equals(d2)) {
                if (!file.exists()) {
                    throw new FileNotFoundException(e.b().n(i2));
                }
                if (e.b().w(i2)) {
                    e2 = CyberMediaExtLoader.init(CyberPlayerManager.getApplicationContext());
                }
            }
            e2 = true;
        } else {
            if (a2.e() == d.a.LIB_TYPE_SO) {
                if (!file.exists()) {
                    if (i2 == 8) {
                        i2 = 16;
                    }
                    throw new FileNotFoundException(e.b().n(i2));
                } else if (e.b().p(i2)) {
                    System.load(d2);
                    if (i2 == 16) {
                        c(CyberPlayerManager.getApplicationContext(), map);
                    }
                } else if (e.b().r(i2)) {
                    IjkMediaPlayer.nativeSetEnableFFmpegExtend(d2);
                } else if (e.b().t(i2)) {
                    f64810b = d2;
                } else if (e.b().x(i2)) {
                    e2 = h(i2, map);
                } else if (e.b().v(i2)) {
                    e2 = e(i2, d2);
                }
            }
            e2 = true;
        }
        f64809a = i2 | f64809a;
        if (e2) {
            CyberLog.d("CyberLibsLoader", "isMediaProcess:" + f64812d + " abi:" + e.b().m() + " lib:" + a3 + " ver:" + c2 + " load success");
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0073 A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:5:0x000e, B:7:0x0057, B:9:0x005b, B:17:0x0073, B:11:0x0061, B:13:0x006c), top: B:20:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k() {
        boolean z = true;
        if (!CyberCfgManager.getInstance().getCfgBoolValue(CyberCfgManager.KEY_INT_ENABLE_MONITOR, true)) {
            return;
        }
        try {
            String str = f64811c + File.separator + "config";
            String str2 = str + File.separator + LibsInfoDef.CYBER_CODEC_MONITOR_NAME + "_" + LibsInfoDef.CYBER_CODEC_MONITOR_VERSION + ".json";
            File file = new File(str);
            if (file.exists()) {
                if (!new File(str2).exists() && !f64812d) {
                    z = false;
                }
                if (z) {
                }
            } else {
                if (f64812d) {
                    file.mkdirs();
                    if (z) {
                        Utils.g(str2, f64812d);
                        DuplayerQualityMonitorManager.getInstance().init();
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
