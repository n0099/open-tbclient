package d.a.i0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.i0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41784a = k.f43025a;

    /* renamed from: d.a.i0.a.h0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0634a {

        /* renamed from: a  reason: collision with root package name */
        public int f41785a;

        /* renamed from: b  reason: collision with root package name */
        public int f41786b;

        /* renamed from: c  reason: collision with root package name */
        public long f41787c;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f41788a = k.f43025a;

        public static C0634a a() {
            C0634a c0634a = new C0634a();
            c0634a.f41785a = c();
            c0634a.f41786b = d();
            c0634a.f41787c = b();
            if (f41788a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0634a.f41785a + " ,sizeLimit: " + c0634a.f41786b + " ,diskSizeThreshold: " + c0634a.f41787c);
            }
            return c0634a;
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
            C0634a a2 = b.a();
            codeCacheSetting.maxCount = a2.f41785a;
            codeCacheSetting.sizeLimit = a2.f41786b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f41787c;
        }
        if (f41784a) {
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
