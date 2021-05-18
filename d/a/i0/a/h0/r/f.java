package d.a.i0.a.h0.r;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42376c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.h0.r.b f42377a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f42378b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f42379a = new f();
    }

    public static f b() {
        return b.f42379a;
    }

    public static boolean d() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    public final d.a.i0.a.h0.r.b a() {
        if (f42376c && d()) {
            return new e();
        }
        return new d.a.i0.a.h0.r.a();
    }

    @Nullable
    public c c(String str) {
        HashMap<String, c> hashMap = this.f42378b;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void e(c cVar, d dVar) {
        this.f42377a.k(cVar, dVar);
    }

    public f() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.i0.a.h0.r.b a2 = a();
        this.f42377a = a2;
        this.f42378b = a2.h();
        if (f42376c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
