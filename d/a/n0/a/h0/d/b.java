package d.a.n0.a.h0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebSettings;
import d.a.n0.a.h0.d.a;
import d.a.n0.a.k;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44595a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(318079701, "Ld/a/n0/a/h0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(318079701, "Ld/a/n0/a/h0/d/b;");
                return;
            }
        }
        f44595a = k.f45831a;
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
                a.C0713a a2 = a.b.a();
                codeCacheSetting.maxCount = a2.f44591a;
                codeCacheSetting.sizeLimit = a2.f44592b;
                codeCacheSetting.diskCodeCacheSizeThreshold = a2.f44593c;
            }
            if (f44595a) {
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting cacheType: " + str);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting maxCount: " + codeCacheSetting.maxCount);
                Log.d("WebViewCodeCacheHelper", "buildCacheSetting sizeLimit: " + codeCacheSetting.sizeLimit);
            }
            return codeCacheSetting;
        }
        return (WebSettings.CodeCacheSetting) invokeLL.objValue;
    }
}
