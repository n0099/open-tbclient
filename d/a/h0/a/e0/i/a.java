package d.a.h0.a.e0.i;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.h0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41924a = k.f43101a;

    /* renamed from: d.a.h0.a.e0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0620a {

        /* renamed from: a  reason: collision with root package name */
        public int f41925a;

        /* renamed from: b  reason: collision with root package name */
        public int f41926b;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f41927a = k.f43101a;

        /* renamed from: b  reason: collision with root package name */
        public static int f41928b = -1;

        /* renamed from: c  reason: collision with root package name */
        public static int f41929c = -1;

        /* renamed from: d  reason: collision with root package name */
        public static int f41930d = -1;

        /* renamed from: e  reason: collision with root package name */
        public static int f41931e = -1;

        public static boolean a(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return f();
                }
                return g();
            }
            return f();
        }

        public static C0620a b() {
            C0620a c0620a = new C0620a();
            c0620a.f41925a = c();
            c0620a.f41926b = d();
            if (f41927a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0620a.f41925a + " ,sizeLimit: " + c0620a.f41926b);
            }
            return c0620a;
        }

        public static int c() {
            if (f41930d < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_code_cache_max_count", 5);
                f41930d = 5;
            }
            return f41930d;
        }

        public static int d() {
            if (f41931e < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_code_cache_size_limit", 100);
                f41931e = 100;
            }
            return f41931e * 1024;
        }

        public static String e() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        public static boolean f() {
            boolean S = d.a.h0.a.m1.a.a.S();
            if (S) {
                f41928b = 1;
            }
            if (f41928b < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_app_v8_code_cache", 1);
                f41928b = 1;
            }
            if (f41927a) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSwanAppCodeCacheAbSwitch() switcher: ");
                sb.append(f41928b);
                sb.append(S ? " forceAb" : "");
                Log.d("CodeCacheSwitcher", sb.toString());
            }
            return f41928b == 1;
        }

        public static boolean g() {
            boolean S = d.a.h0.a.m1.a.a.S();
            if (S) {
                f41929c = 1;
            }
            if (f41929c < 0) {
                d.a.h0.a.w0.a.N().getSwitch("swan_game_v8_code_cache", 2);
                f41929c = 2;
            }
            if (f41927a) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSwanGameCodeCacheAbSwitch() switcher: ");
                sb.append(f41929c);
                sb.append(S ? " forceAb" : "");
                Log.d("CodeCacheSwitcher", sb.toString());
            }
            return f41929c == 1;
        }

        public static boolean h(int i2) {
            if (f41927a) {
                String e2 = e();
                char c2 = 65535;
                int hashCode = e2.hashCode();
                if (hashCode != 3105) {
                    if (hashCode != 143821548) {
                        if (hashCode == 2081401959 && e2.equals("disable_code_cache")) {
                            c2 = 1;
                        }
                    } else if (e2.equals("enable_code_cache")) {
                        c2 = 0;
                    }
                } else if (e2.equals("ab")) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    return true;
                }
                if (c2 == 1) {
                    return false;
                }
                if (c2 == 2) {
                    return a(i2);
                }
            }
            return a(i2);
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
            codeCacheSetting.maxCount = 5;
            codeCacheSetting.sizeLimit = 102400;
        } else {
            C0620a b2 = b.b();
            codeCacheSetting.maxCount = b2.f41925a;
            codeCacheSetting.sizeLimit = b2.f41926b;
        }
        if (f41924a) {
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
