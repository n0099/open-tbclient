package d.b.g0.a.e0.t;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44281c = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.e0.t.b f44282a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f44283b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f44284a = new f();
    }

    public static f b() {
        return b.f44284a;
    }

    public static boolean d() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    public final d.b.g0.a.e0.t.b a() {
        if (f44281c && d()) {
            return new e();
        }
        return new d.b.g0.a.e0.t.a();
    }

    @Nullable
    public c c(String str) {
        HashMap<String, c> hashMap = this.f44283b;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void e(c cVar, d dVar) {
        this.f44282a.k(cVar, dVar);
    }

    public f() {
        long currentTimeMillis = System.currentTimeMillis();
        d.b.g0.a.e0.t.b a2 = a();
        this.f44282a = a2;
        this.f44283b = a2.h();
        if (f44281c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
