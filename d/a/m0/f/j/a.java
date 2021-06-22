package d.a.m0.f.j;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f50631a = AppRuntime.getAppContext().getCacheDir() + File.separator + "gamenowGuide" + File.separator + "configCache";

    /* renamed from: b  reason: collision with root package name */
    public static a f50632b = new a();

    public static a c() {
        return f50632b;
    }

    public synchronized void a(String str, String str2, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && j > elapsedRealtime) {
            File file = new File(f50631a);
            if (!file.exists() && !file.mkdirs()) {
                if (d.a.m0.a.k.f46983a) {
                    Log.d("GameGuideConfigCache", "创建缓存目录失败");
                }
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists() && file2.getName().startsWith(str)) {
                        d.a.m0.t.d.i(file2);
                    }
                }
            }
            boolean M = d.a.m0.t.d.M(str2, new File(f50631a, b(str, j)));
            if (d.a.m0.a.k.f46983a) {
                Log.d("GameGuideConfigCache", "缓存配置信息成功：  " + M);
            }
            return;
        }
        if (d.a.m0.a.k.f46983a) {
            Log.d("GameGuideConfigCache", "缓存失败，参数异常  appKey = " + str + ",  config = " + str2 + ",  expiration = " + j + ",  currentTime = " + elapsedRealtime);
        }
    }

    public final String b(String str, long j) {
        return str + "_" + j;
    }

    public final boolean d(File file) {
        if (file != null && file.exists()) {
            String[] split = file.getName().split("_");
            if (split.length != 2) {
                return true;
            }
            try {
                if (Long.valueOf(split[1]).longValue() > SystemClock.elapsedRealtime()) {
                    return false;
                }
            } catch (Throwable th) {
                if (d.a.m0.a.k.f46983a) {
                    th.printStackTrace();
                }
            }
        }
        return true;
    }

    public synchronized String e(String str) {
        if (TextUtils.isEmpty(str)) {
            if (d.a.m0.a.k.f46983a) {
                Log.d("GameGuideConfigCache", "获取缓存配置失败， appKey为null");
            }
            return null;
        }
        File file = new File(f50631a);
        if (!file.exists()) {
            if (d.a.m0.a.k.f46983a) {
                Log.d("GameGuideConfigCache", "获取缓存配置失败， 缓存目录不存在");
            }
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            File file2 = null;
            for (File file3 : listFiles) {
                if (d(file3)) {
                    d.a.m0.t.d.i(file3);
                } else if (file3.getName().startsWith(str)) {
                    file2 = file3;
                }
            }
            if (file2 == null) {
                return null;
            }
            return d.a.m0.t.d.D(file2);
        }
        if (d.a.m0.a.k.f46983a) {
            Log.d("GameGuideConfigCache", "获取缓存配置失败， 缓存目录中的文件为空");
        }
        return null;
    }
}
