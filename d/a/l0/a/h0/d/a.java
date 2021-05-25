package d.a.l0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.l0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41958a = k.f43199a;

    /* renamed from: d.a.l0.a.h0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0645a {

        /* renamed from: a  reason: collision with root package name */
        public int f41959a;

        /* renamed from: b  reason: collision with root package name */
        public int f41960b;

        /* renamed from: c  reason: collision with root package name */
        public long f41961c;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f41962a = k.f43199a;

        public static C0645a a() {
            C0645a c0645a = new C0645a();
            c0645a.f41959a = c();
            c0645a.f41960b = d();
            c0645a.f41961c = b();
            if (f41962a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0645a.f41959a + " ,sizeLimit: " + c0645a.f41960b + " ,diskSizeThreshold: " + c0645a.f41961c);
            }
            return c0645a;
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
            C0645a a2 = b.a();
            codeCacheSetting.maxCount = a2.f41959a;
            codeCacheSetting.sizeLimit = a2.f41960b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f41961c;
        }
        if (f41958a) {
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
