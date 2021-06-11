package d.a.l0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.l0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45634a = k.f46875a;

    /* renamed from: d.a.l0.a.h0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0701a {

        /* renamed from: a  reason: collision with root package name */
        public int f45635a;

        /* renamed from: b  reason: collision with root package name */
        public int f45636b;

        /* renamed from: c  reason: collision with root package name */
        public long f45637c;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f45638a = k.f46875a;

        public static C0701a a() {
            C0701a c0701a = new C0701a();
            c0701a.f45635a = c();
            c0701a.f45636b = d();
            c0701a.f45637c = b();
            if (f45638a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0701a.f45635a + " ,sizeLimit: " + c0701a.f45636b + " ,diskSizeThreshold: " + c0701a.f45637c);
            }
            return c0701a;
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
            C0701a a2 = b.a();
            codeCacheSetting.maxCount = a2.f45635a;
            codeCacheSetting.sizeLimit = a2.f45636b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f45637c;
        }
        if (f45634a) {
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
