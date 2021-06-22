package d.a.m0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.m0.a.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45742a = k.f46983a;

    /* renamed from: d.a.m0.a.h0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0704a {

        /* renamed from: a  reason: collision with root package name */
        public int f45743a;

        /* renamed from: b  reason: collision with root package name */
        public int f45744b;

        /* renamed from: c  reason: collision with root package name */
        public long f45745c;
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f45746a = k.f46983a;

        public static C0704a a() {
            C0704a c0704a = new C0704a();
            c0704a.f45743a = c();
            c0704a.f45744b = d();
            c0704a.f45745c = b();
            if (f45746a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0704a.f45743a + " ,sizeLimit: " + c0704a.f45744b + " ,diskSizeThreshold: " + c0704a.f45745c);
            }
            return c0704a;
        }

        public static long b() {
            return 31457280L;
        }

        public static int c() {
            return 20;
        }

        public static int d() {
            return 102400;
        }
    }

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting a(String str, @NonNull String str2) {
        V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
        codeCacheSetting.id = str;
        ArrayList<String> arrayList = new ArrayList<>();
        codeCacheSetting.pathList = arrayList;
        arrayList.add(str2);
        if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
            codeCacheSetting.maxCount = 20;
            codeCacheSetting.sizeLimit = 102400;
        } else {
            C0704a a2 = b.a();
            codeCacheSetting.maxCount = a2.f45743a;
            codeCacheSetting.sizeLimit = a2.f45744b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45745c;
        }
        if (f45742a) {
            Log.d("V8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
            Log.d("V8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
            Log.d("V8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
        }
        return codeCacheSetting;
    }

    public static int b(boolean z, boolean z2) {
        if (z && z2) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }
}
