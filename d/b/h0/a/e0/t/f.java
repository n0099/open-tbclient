package d.b.h0.a.e0.t;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45003c = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.a.e0.t.b f45004a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f45005b;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final f f45006a = new f();
    }

    public static f b() {
        return b.f45006a;
    }

    public static boolean d() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
    }

    public final d.b.h0.a.e0.t.b a() {
        if (f45003c && d()) {
            return new e();
        }
        return new d.b.h0.a.e0.t.a();
    }

    @Nullable
    public c c(String str) {
        HashMap<String, c> hashMap = this.f45005b;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public void e(c cVar, d dVar) {
        this.f45004a.k(cVar, dVar);
    }

    public f() {
        long currentTimeMillis = System.currentTimeMillis();
        d.b.h0.a.e0.t.b a2 = a();
        this.f45004a = a2;
        this.f45005b = a2.h();
        if (f45003c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
