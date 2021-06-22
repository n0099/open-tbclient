package d.a.y.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreProvider;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.downloader.SilentDownloaderManager;
import com.baidu.cyberplayer.sdk.loader.CyberCoreLoaderManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.media.duplayer.Utils;
import com.baidu.media.duplayer.d;
import com.heytap.mcssdk.mode.CommandMessage;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f68693a;

    /* renamed from: b  reason: collision with root package name */
    public static String f68694b;

    /* renamed from: c  reason: collision with root package name */
    public static String f68695c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f68696d = new LinkedHashSet();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                for (File file : new File(e.f68695c).listFiles()) {
                    if (file.isFile()) {
                        e.this.h(file);
                    } else if (file.getName().equals(e.f68694b)) {
                        e.this.n(file);
                    } else {
                        Utils.e(file);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (f68693a == null) {
                f68694b = Utils.s();
                f68693a = new e();
            }
            eVar = f68693a;
        }
        return eVar;
    }

    public boolean A(int i2) {
        return (i2 & 896) == i2;
    }

    public final void B() {
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
            cyberCfgManager.setPrefStr("build_in_" + dVar.a(), dVar.d());
        }
    }

    public boolean C(int i2) {
        return (i2 & 2048) == i2;
    }

    public final void D() {
        if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                if (dVar != null && i(dVar)) {
                    r(dVar);
                    t(dVar);
                    return;
                }
            }
        }
    }

    public boolean E(int i2) {
        return (i2 & 3) == i2;
    }

    public boolean F(int i2) {
        return (i2 & CommandMessage.COMMAND_BASE) == i2;
    }

    public com.baidu.media.duplayer.d a(int i2) {
        return LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i2));
    }

    public final String c(Context context, com.baidu.media.duplayer.d dVar) {
        StringBuilder sb;
        String str;
        String str2 = null;
        if (dVar.l() == d.a.LIB_TYPE_JAR) {
            if (dVar.d().equals(d(dVar.a())) && d.a.y.b.a.e(context.getClassLoader())) {
                return "apk_internal_jar";
            }
            sb = new StringBuilder();
            sb.append(f68695c);
            sb.append(File.separator);
            sb.append(dVar.a());
            sb.append("_");
            sb.append(dVar.d());
            str = ".jar";
        } else if (dVar.l() != d.a.LIB_TYPE_SO) {
            return null;
        } else {
            if (dVar.d().equals(d(dVar.a())) && CyberCfgManager.getInstance().getCfgBoolValue("enable_libs_reuse", true)) {
                str2 = ((BaseDexClassLoader) context.getClassLoader()).findLibrary(dVar.a());
            }
            if (!TextUtils.isEmpty(str2)) {
                dVar.i(true);
                return str2;
            }
            sb = new StringBuilder();
            sb.append(f68695c);
            sb.append(File.separator);
            sb.append(f68694b);
            sb.append(File.separator);
            sb.append(dVar.a());
            sb.append("_");
            sb.append(dVar.d());
            sb.append(File.separator);
            sb.append("lib");
            sb.append(dVar.a());
            str = ".so";
        }
        sb.append(str);
        return sb.toString();
    }

    public final String d(String str) {
        CyberCfgManager cyberCfgManager = CyberCfgManager.getInstance();
        return cyberCfgManager.getPrefStr("build_in_" + str, "");
    }

    public Map<String, String> e(CyberPlayerCoreProvider.LibsVersionType libsVersionType) {
        HashMap hashMap = new HashMap();
        if (CyberPlayerCoreProvider.LibsVersionType.ALL_VERSION == libsVersionType) {
            for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
                hashMap.put(dVar.a(), dVar.d());
            }
        } else if (CyberPlayerCoreProvider.LibsVersionType.SUCCESS_LOADED_VERSION == libsVersionType) {
            for (com.baidu.media.duplayer.d dVar2 : LibsInfoDef.getAllGroupMap().values()) {
                if (c.d(dVar2.g())) {
                    hashMap.put(dVar2.a(), dVar2.d());
                }
            }
        }
        return hashMap;
    }

    public void f(Context context, String str) {
        if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            B();
        }
        k(context, str);
        D();
    }

    public final void h(File file) {
        try {
            if (!file.isFile() || file.getName().contains(SDKVersion.VERSION)) {
                return;
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public final boolean i(com.baidu.media.duplayer.d dVar) {
        String[] split;
        if (dVar != null && !"cyber-player".equals(dVar.a()) && !"cyber-sdl".equals(dVar.a())) {
            String cfgValue = CyberCfgManager.getInstance().getCfgValue(dVar.a(), "");
            if (!TextUtils.isEmpty(cfgValue) && (split = cfgValue.split(";")) != null && split.length == 3 && CyberCfgManager.getInstance().isAllowUpdate(dVar.a(), split[1], dVar.d())) {
                dVar.h(dVar.d());
                dVar.k(dVar.j());
                CyberCfgManager.getInstance();
                dVar.b(CyberCfgManager.keepMainProcessVersion(dVar.a(), split[1]));
                dVar.e(c(CyberPlayerManager.getApplicationContext(), dVar));
                dVar.f("1".equals(split[2]));
                dVar.c(true);
                l(dVar);
                return true;
            }
        }
        return false;
    }

    public int j(int i2) {
        int i3 = (i2 & 2) == 2 ? 92 : 28;
        if ((i2 & 4) == 4) {
            i3 |= 32;
        }
        if ((i2 & 8) == 8) {
            i3 |= 896;
        }
        if ((i2 & 16) == 16) {
            i3 |= 3;
        }
        if ((i2 & 32) == 32) {
            i3 |= 2048;
        }
        return (i2 & 64) == 64 ? i3 | CommandMessage.COMMAND_BASE : i3;
    }

    public final void k(Context context, String str) {
        f68695c = str + File.separator + "libs";
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            String c2 = c(context, dVar);
            dVar.e(c2);
            if (dVar.l() == d.a.LIB_TYPE_SO) {
                File parentFile = new File(c2).getParentFile();
                if (!parentFile.exists() || parentFile.isFile()) {
                    parentFile.mkdirs();
                }
                f68696d.add(parentFile.getAbsolutePath());
            }
        }
    }

    public final void l(com.baidu.media.duplayer.d dVar) {
        if (Utils.r(CyberPlayerManager.getApplicationContext())) {
            String prefStr = CyberCfgManager.getInstance().getPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, dVar.a());
            String prefStr2 = CyberCfgManager.getInstance().getPrefStr("update_version", dVar.d());
            if (dVar.a().equals(prefStr) && CyberCfgManager.compareVersion(dVar.d(), prefStr2) == -1) {
                return;
            }
            CyberCfgManager.getInstance().setPrefStr(CyberCfgManager.SP_KEY_UPDATE_TYPE, dVar.a());
            CyberCfgManager.getInstance().setPrefStr("update_version", dVar.d());
        }
    }

    public final void n(File file) {
        File[] listFiles;
        boolean z;
        try {
            for (File file2 : file.listFiles()) {
                Iterator<String> it = f68696d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().contains(file2.getAbsolutePath())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    Utils.e(file2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public String[] o() {
        Set<String> set = f68696d;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String p() {
        return f68694b;
    }

    public String q(int i2) {
        com.baidu.media.duplayer.d a2 = a(i2);
        if (a2 == null) {
            return null;
        }
        return f68694b + "_" + a2.a() + "_" + a2.d() + ".zip";
    }

    public final boolean r(com.baidu.media.duplayer.d dVar) {
        if (dVar == null || !dVar.q() || dVar.d().equals(dVar.n())) {
            return false;
        }
        if (SilentDownloaderManager.getInstance().checkLibs(dVar.a(), dVar.d())) {
            String latestLoadedVersion = CyberCoreLoaderManager.getLatestLoadedVersion(dVar.a());
            if (CyberCfgManager.compareVersion(latestLoadedVersion, dVar.n()) != 1) {
                latestLoadedVersion = dVar.n();
            }
            dVar.b(latestLoadedVersion);
            dVar.e(c(CyberPlayerManager.getApplicationContext(), dVar));
            dVar.c(false);
        }
        return true;
    }

    public void s() {
        long prefLong = CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - prefLong > 432000000) {
            CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, currentTimeMillis);
            CyberTaskExcutor.getInstance().execute(new a());
        }
    }

    public final void t(com.baidu.media.duplayer.d dVar) {
        if (dVar == null || dVar.l() != d.a.LIB_TYPE_SO) {
            return;
        }
        try {
            File parentFile = new File(dVar.j()).getParentFile();
            if (!parentFile.exists() || parentFile.isFile()) {
                parentFile.mkdirs();
            }
            f68696d.add(parentFile.getAbsolutePath());
        } catch (Exception unused) {
        }
    }

    public boolean u(int i2) {
        return (i2 & 28) == i2;
    }

    public boolean v() {
        int size = LibsInfoDef.getAllGroupMap().size();
        for (int i2 = 0; i2 <= size; i2++) {
            com.baidu.media.duplayer.d a2 = a(1 << i2);
            if (a2 != null && a2.m()) {
                if (a2.q()) {
                    a2.b(a2.n());
                    a2.e(a2.o());
                    a2.c(false);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean w(int i2) {
        return (i2 & 32) == i2;
    }

    public boolean y(int i2) {
        return (i2 & 64) == i2;
    }
}
