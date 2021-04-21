package d.b.h0.a.e0.i;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.b.h0.a.k;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44627a = k.f45772a;

    /* renamed from: d.b.h0.a.e0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0681a {

        /* renamed from: a  reason: collision with root package name */
        public int f44628a;

        /* renamed from: b  reason: collision with root package name */
        public int f44629b;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f44630a = k.f45772a;

        /* renamed from: b  reason: collision with root package name */
        public static int f44631b = -1;

        /* renamed from: c  reason: collision with root package name */
        public static int f44632c = -1;

        /* renamed from: d  reason: collision with root package name */
        public static int f44633d = -1;

        /* renamed from: e  reason: collision with root package name */
        public static int f44634e = -1;

        public static boolean a(int i) {
            if (i != 0) {
                if (i != 1) {
                    return f();
                }
                return g();
            }
            return f();
        }

        public static C0681a b() {
            C0681a c0681a = new C0681a();
            c0681a.f44628a = c();
            c0681a.f44629b = d();
            if (f44630a) {
                Log.d("CodeCacheSwitcher", "getCodeCacheConfig() maxCount: " + c0681a.f44628a + " ,sizeLimit: " + c0681a.f44629b);
            }
            return c0681a;
        }

        public static int c() {
            if (f44633d < 0) {
                d.b.h0.a.w0.a.N().getSwitch("swan_code_cache_max_count", 5);
                f44633d = 5;
            }
            return f44633d;
        }

        public static int d() {
            if (f44634e < 0) {
                d.b.h0.a.w0.a.N().getSwitch("swan_code_cache_size_limit", 100);
                f44634e = 100;
            }
            return f44634e * 1024;
        }

        public static String e() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_app_v8_code_cache", "ab");
        }

        public static boolean f() {
            boolean S = d.b.h0.a.m1.a.a.S();
            if (S) {
                f44631b = 1;
            }
            if (f44631b < 0) {
                d.b.h0.a.w0.a.N().getSwitch("swan_app_v8_code_cache", 1);
                f44631b = 1;
            }
            if (f44630a) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSwanAppCodeCacheAbSwitch() switcher: ");
                sb.append(f44631b);
                sb.append(S ? " forceAb" : "");
                Log.d("CodeCacheSwitcher", sb.toString());
            }
            return f44631b == 1;
        }

        public static boolean g() {
            boolean S = d.b.h0.a.m1.a.a.S();
            if (S) {
                f44632c = 1;
            }
            if (f44632c < 0) {
                d.b.h0.a.w0.a.N().getSwitch("swan_game_v8_code_cache", 2);
                f44632c = 2;
            }
            if (f44630a) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSwanGameCodeCacheAbSwitch() switcher: ");
                sb.append(f44632c);
                sb.append(S ? " forceAb" : "");
                Log.d("CodeCacheSwitcher", sb.toString());
            }
            return f44632c == 1;
        }

        public static boolean h(int i) {
            if (f44630a) {
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
                    return a(i);
                }
            }
            return a(i);
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
            C0681a b2 = b.b();
            codeCacheSetting.maxCount = b2.f44628a;
            codeCacheSetting.sizeLimit = b2.f44629b;
        }
        if (f44627a) {
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
