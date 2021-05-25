package d.a.y.a;

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
    public static e f64871a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64872b;

    /* renamed from: c  reason: collision with root package name */
    public static String f64873c;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f64874d = new LinkedHashSet();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            try {
                for (File file : new File(e.f64873c).listFiles()) {
                    if (file.isFile()) {
                        e.this.g(file);
                    } else if (file.getName().equals(e.f64872b)) {
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
            if (f64871a == null) {
                f64872b = Utils.q();
                f64871a = new e();
            }
            eVar = f64871a;
        }
        return eVar;
    }

    public com.baidu.media.duplayer.d a(int i2) {
        return LibsInfoDef.getAllGroupMap().get(Integer.valueOf(i2));
    }

    public final String c(Context context, com.baidu.media.duplayer.d dVar) {
        StringBuilder sb;
        String str;
        if (dVar.e() == d.a.LIB_TYPE_JAR) {
            if (dVar.c().equals(d(dVar.a())) && d.a.y.b.a.e(context.getClassLoader())) {
                return "apk_internal_jar";
            }
            sb = new StringBuilder();
            sb.append(f64873c);
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
            sb.append(f64873c);
            sb.append(File.separator);
            sb.append(f64872b);
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

    public int h(int i2) {
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
        return (i2 & 32) == 32 ? i3 | 2048 : i3;
    }

    public final void i(Context context, String str) {
        f64873c = str + File.separator + "libs";
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            String c2 = c(context, dVar);
            dVar.b(c2);
            if (dVar.e() == d.a.LIB_TYPE_SO) {
                File parentFile = new File(c2).getParentFile();
                if (!parentFile.exists() || parentFile.isFile()) {
                    parentFile.mkdirs();
                }
                f64874d.add(parentFile.getAbsolutePath());
            }
        }
    }

    public final void k(File file) {
        File[] listFiles;
        boolean z;
        try {
            for (File file2 : file.listFiles()) {
                Iterator<String> it = f64874d.iterator();
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
        Set<String> set = f64874d;
        return (String[]) set.toArray(new String[set.size()]);
    }

    public String m() {
        return f64872b;
    }

    public String n(int i2) {
        com.baidu.media.duplayer.d a2 = a(i2);
        if (a2 == null) {
            return null;
        }
        return f64872b + "_" + a2.a() + "_" + a2.c() + ".zip";
    }

    public void o() {
        long prefLong = CyberCfgManager.getInstance().getPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - prefLong > 432000000) {
            CyberCfgManager.getInstance().setPrefLong(CyberCfgManager.LAST_CHECK_UNUSED_LIBS_TIME, currentTimeMillis);
            CyberTaskExcutor.getInstance().execute(new a());
        }
    }

    public boolean p(int i2) {
        return (i2 & 28) == i2;
    }

    public boolean r(int i2) {
        return (i2 & 32) == i2;
    }

    public boolean t(int i2) {
        return (i2 & 64) == i2;
    }

    public final void u() {
        for (com.baidu.media.duplayer.d dVar : LibsInfoDef.getAllGroupMap().values()) {
            CyberCfgManager.getInstance().setPrefStr(dVar.a(), dVar.c());
        }
    }

    public boolean v(int i2) {
        return (i2 & 896) == i2;
    }

    public boolean w(int i2) {
        return (i2 & 2048) == i2;
    }

    public boolean x(int i2) {
        return (i2 & 3) == i2;
    }
}
