package d.a.l0.h.e;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import d.a.l0.a.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50985a = k.f46875a;

    @NonNull
    public static V8EngineConfiguration.CodeCacheSetting a(String str, @NonNull String str2) {
        V8EngineConfiguration.CodeCacheSetting codeCacheSetting = new V8EngineConfiguration.CodeCacheSetting();
        codeCacheSetting.id = str;
        ArrayList<String> arrayList = new ArrayList<>();
        codeCacheSetting.pathList = arrayList;
        arrayList.add(str2);
        if (((str.hashCode() == -1253235525 && str.equals("gamejs")) ? (char) 0 : (char) 65535) != 0) {
            codeCacheSetting.maxCount = 20;
            codeCacheSetting.sizeLimit = 102400;
        } else {
            a a2 = b.a();
            codeCacheSetting.maxCount = a2.f50980a;
            codeCacheSetting.sizeLimit = a2.f50981b;
            codeCacheSetting.diskCodeCacheSizeThreshold = a2.f50982c;
        }
        if (f50985a) {
            Log.d("GameV8CodeCacheHelper", "buildCacheSetting cacheType: " + str);
            Log.d("GameV8CodeCacheHelper", "buildCacheSetting cachePath: " + str2);
            Log.d("GameV8CodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
            Log.d("GameV8CodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
            Log.d("GameV8CodeCacheHelper", "buildCacheSetting diskCodeCacheSizeThreshold: " + codeCacheSetting.diskCodeCacheSizeThreshold);
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
