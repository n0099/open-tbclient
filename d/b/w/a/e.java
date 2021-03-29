package d.b.w.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberTaskExcutor;
import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.LibsInfoDef;
import com.baidu.media.duplayer.Utils;
import com.baidu.media.duplayer.d;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f64819a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64820b;

    /* renamed from: c  reason: collision with root package name */
    public static String f64821c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f64822d = new LinkedHashSet();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                for (File file : new File(e.f64821c).listFiles()) {
                    if (file.isFile()) {
                        e.this.g(file);
                    } else if (file.getName().equals(e.f64820b)) {
                        e.this.k(file);
                    } else {
                        Utils.d(file);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (f64819a == null) {
                f64820b = Utils.q();
                f64819a = new e();
            }
            eVar = f64819a;
        }
        return eVar;
    }

    public com.baidu.media.duplayer.d a(int i) {
        return LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i));
    }

    public final String c(Context context, com.baidu.media.duplayer.d dVar) {
        StringBuilder sb;
        String str;
        if (dVar.e() == d.a.LIB_TYPE_JAR) {
            if (dVar.c().equals(d(dVar.a())) && d.b.w.b.a.e(context.getClassLoader())) {
                return "apk_internal_jar";
            }
            sb = new StringBuilder();
            sb.append(f64821c);
            sb.append(File.separator);
            sb.append(dVar.a());
            sb.append("_");
            sb.append(dVar.c());
            str = ".jar";
        } else if (dVar.e() != d.a.LIB_TYPE_SO) {
            return null;
        } else {
            String findLibrary = dVar.c().equals(d(dVar.a())) ? ((BaseDexClassLoader) context.getClassLoader()).findLibrary(dVar.a()) : null;
            if (!TextUtils.isEmpty(findLibrary)) {
                return findLibrary;
            }
            sb = new StringBuilder();
            sb.append(f64821c);
            sb.append(File.separator);
            sb.append(f64820b);
            sb.append(File.separator);
            sb.append(dVar.a());
            sb.append("_");
            sb.append(dVar.c());
            sb.append(File.separator);
            sb.append("lib");
            sb.append(dVar.a());
            str = ".so";
        }
        sb.append(str);
        return sb.toString();
    }

    public final String d(String str) {
        return CyberCfgManager.getInstance().getPrefStr(str, "");
    }

    public void e(Context context, String str) {
        if (SDKVersion.VERSION.equals(CyberPlayerManager.getSDKVersion())) {
            u();
        }
        i(context, str);
    }

    public final void g(File file) {
        try {
            if (!file.isFile() || file.getName().contains(SDKVersion.VERSION)) {
                return;
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public int h(int i) {
        int i2 = (i & 2) == 2 ? 92 : 28;
        if ((i & 4) == 4) {
            i2 |= 32;
        }
        if ((i & 8) == 8) {
            i2 |= 896;
        }
        if ((i & 16) == 16) {
            i2 |= 3;
        }
        return (i & 32) == 32 ? i2 | 2048 : i2;
    }

    public final void i(Context context, String str) {
        f64821c = str + File.separator + "libs";
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            String c2 = c(context, dVar);
            dVar.b(c2);
            if (dVar.e() == d.a.LIB_TYPE_SO) {
                File parentFile = new File(c2).getParentFile();
                if (!parentFile.exists() || parentFile.isFile()) {
                    parentFile.mkdirs();
                }
                f64822d.add(parentFile.getAbsolutePath());
            }
        }
    }

    public final void k(File file) {
        File[] listFiles;
        boolean z;
        try {
            for (File file2 : file.listFiles()) {
                Iterator<String> it = f64822d.iterator();
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
                    Utils.d(file2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public String[] l() {
        Set<String> set = f64822d;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String m() {
        return f64820b;
    }

    public String n(int i) {
        com.baidu.media.duplayer.d a2 = a(i);
        if (a2 == null) {
            return null;
        }
        return f64820b + "_" + a2.a() + "_" + a2.c() + ".zip";
    }

    public void o() {
        long prefLong = CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - prefLong > 432000000) {
            CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, currentTimeMillis);
            CyberTaskExcutor.getInstance().execute(new a());
        }
    }

    public boolean p(int i) {
        return (i & 28) == i;
    }

    public boolean r(int i) {
        return (i & 32) == i;
    }

    public boolean t(int i) {
        return (i & 64) == i;
    }

    public final void u() {
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            CyberCfgManager.getInstance().setPrefStr(dVar.a(), dVar.c());
        }
    }

    public boolean v(int i) {
        return (i & 896) == i;
    }

    public boolean w(int i) {
        return (i & 2048) == i;
    }

    public boolean x(int i) {
        return (i & 3) == i;
    }
}
