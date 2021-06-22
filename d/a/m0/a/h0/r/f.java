package d.a.m0.a.h0.r;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46334c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.r.b f46335a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f46336b;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f46337a = new f();
    }

    public static f b() {
        return b.f46337a;
    }

    public static boolean d() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    public final d.a.m0.a.h0.r.b a() {
        if (f46334c && d()) {
            return new e();
        }
        return new d.a.m0.a.h0.r.a();
    }

    @Nullable
    public c c(String str) {
        HashMap<String, c> hashMap = this.f46336b;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void e(c cVar, d dVar) {
        this.f46335a.k(cVar, dVar);
    }

    public f() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.m0.a.h0.r.b a2 = a();
        this.f46335a = a2;
        this.f46336b = a2.h();
        if (f46334c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
