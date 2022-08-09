package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public class v52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PrefetchEvent b;

        public a(String str, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v52.d(this.a);
                v52.d(v52.e(this.a, this.b.pageUrl));
            }
        }
    }

    public static void c(@NonNull PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, prefetchEvent) == null) && av2.a()) {
            String str = prefetchEvent.appPath;
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                td3.k(new a(str, prefetchEvent), "addFileResToMemoryCache");
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list == null || list.length == 0) {
                    return;
                }
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String str3 = str + File.separator + str2;
                        File file2 = new File(str3);
                        if (file2.exists() && file2.isFile() && (str3.endsWith(FileHelper.FILE_CACHE_CSS) || str3.endsWith(".js"))) {
                            BdSailorWebView.addToWebCache("file://" + str3, true);
                        }
                    }
                }
            } else if (file.isFile()) {
                String absolutePath = file.getAbsolutePath();
                if (TextUtils.isEmpty(absolutePath)) {
                    return;
                }
                if (absolutePath.endsWith(FileHelper.FILE_CACHE_CSS) || absolutePath.endsWith(".js")) {
                    BdSailorWebView.addToWebCache("file://" + absolutePath, true);
                }
            }
        }
    }

    public static String e(@NonNull String str, String str2) {
        InterceptResult invokeLL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            String f = re3.f(str2);
            if (!TextUtils.isEmpty(f) && (lastIndexOf = f.lastIndexOf(File.separator)) > 0) {
                String substring = f.substring(0, lastIndexOf);
                return str + File.separator + substring;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
