package d.a.m0.a.k2.h;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.m0.a.v2.q0;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.a implements d.a.m0.t.b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f47061e = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";

    /* loaded from: classes3.dex */
    public static class a implements SwanKV.b {
        @Override // com.baidu.storage.swankv.SwanKV.b
        public void loadLibrary(@NonNull String str) {
            if (!q0.G() && "c++_shared".equals(str)) {
                d.a.m0.a.h0.s.d.g(AppRuntime.getAppContext(), c.f47061e);
                d.a.m0.a.h0.s.d.h("c++_shared", c.f47061e, false);
                return;
            }
            SoLoader.load(d.a.m0.a.c1.a.b(), str);
        }
    }

    static {
        B();
    }

    public c(@Nullable Context context, @NonNull String str, int i2) {
        super(context, str, i2, A());
    }

    public static String A() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_prefs";
    }

    public static void B() {
        try {
            SwanKV.n(d.a.m0.a.c1.a.b(), new a(), false);
        } catch (NoClassDefFoundError e2) {
            d.a.m0.a.e0.d.c("SwanKVImpl", "initializeSwanKV", e2);
        }
    }

    @Override // d.a.m0.t.b
    public Set<String> a() {
        return new HashSet(Arrays.asList(super.i()));
    }

    @Override // d.a.m0.t.b
    public boolean b() {
        return super.k() == 2;
    }

    @Override // com.baidu.storage.swankv.SwanKV, d.a.m0.t.b
    @NonNull
    public File c() {
        return super.c();
    }

    @Override // d.a.m0.t.b
    public long d() {
        return super.h();
    }

    public c(@Nullable Context context, @NonNull String str) {
        super(context, str, 2, A());
    }

    public c(@NonNull String str, int i2, @Nullable String str2) {
        super(AppRuntime.getAppContext(), str, i2, str2);
    }
}
