package d.a.q0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebSettings;
import d.a.q0.a.h0.d.a;
import d.a.q0.a.k;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47897a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705327858, "Ld/a/q0/a/h0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705327858, "Ld/a/q0/a/h0/d/b;");
                return;
            }
        }
        f47897a = k.f49133a;
    }

    @NonNull
    public static WebSettings.CodeCacheSetting a(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            WebSettings.CodeCacheSetting codeCacheSetting = new WebSettings.CodeCacheSetting();
            codeCacheSetting.id = str;
            ArrayList<String> arrayList = new ArrayList<>();
            codeCacheSetting.pathList = arrayList;
            arrayList.add(str2);
            if (((str.hashCode() == 93029162 && str.equals("appjs")) ? (char) 0 : (char) 65535) != 0) {
                codeCacheSetting.maxCount = 20;
                codeCacheSetting.sizeLimit = 102400;
            } else {
                a.C0764a a2 = a.b.a();
                codeCacheSetting.maxCount = a2.f47893a;
                codeCacheSetting.sizeLimit = a2.f47894b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f47895c;
            }
            if (f47897a) {
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
            }
            return codeCacheSetting;
        }
        return (WebSettings.CodeCacheSetting) invokeLL.objValue;
    }
}
