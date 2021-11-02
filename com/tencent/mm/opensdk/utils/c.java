package com.tencent.mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Object a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, str)) == null) {
                try {
                    switch (i2) {
                        case 1:
                            return Integer.valueOf(str);
                        case 2:
                            return Long.valueOf(str);
                        case 3:
                            return str;
                        case 4:
                            return Boolean.valueOf(str);
                        case 5:
                            return Float.valueOf(str);
                        case 6:
                            return Double.valueOf(str);
                        default:
                            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                            return null;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e2.getMessage());
                    return null;
                }
            }
            return invokeIL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements BaseColumns {
        public static /* synthetic */ Interceptable $ic;
        public static final Uri CONTENT_URI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1303998210, "Lcom/tencent/mm/opensdk/utils/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1303998210, "Lcom/tencent/mm/opensdk/utils/c$b;");
                    return;
                }
            }
            CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
        }
    }
}
