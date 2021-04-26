package d.a.h0.a.e0.t;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42308c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.e0.t.b f42309a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f42310b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f42311a = new f();
    }

    public static f b() {
        return b.f42311a;
    }

    public static boolean d() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    public final d.a.h0.a.e0.t.b a() {
        if (f42308c && d()) {
            return new e();
        }
        return new d.a.h0.a.e0.t.a();
    }

    @Nullable
    public c c(String str) {
        HashMap<String, c> hashMap = this.f42310b;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void e(c cVar, d dVar) {
        this.f42309a.k(cVar, dVar);
    }

    public f() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.h0.a.e0.t.b a2 = a();
        this.f42309a = a2;
        this.f42310b = a2.h();
        if (f42308c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
