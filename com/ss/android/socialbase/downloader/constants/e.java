package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f70096a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f70097b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f70098c = "";

    /* renamed from: d  reason: collision with root package name */
    public static long f70099d = 512000;

    /* renamed from: e  reason: collision with root package name */
    public static long f70100e = 50;

    /* renamed from: f  reason: collision with root package name */
    public static long f70101f = 5242880;

    /* renamed from: g  reason: collision with root package name */
    public static long f70102g = 31457280;

    /* renamed from: h  reason: collision with root package name */
    public static long f70103h = 10485760;

    /* renamed from: i  reason: collision with root package name */
    public static final JSONObject f70104i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992788, "Lcom/ss/android/socialbase/downloader/constants/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992788, "Lcom/ss/android/socialbase/downloader/constants/e;");
                return;
            }
        }
        f70104i = new JSONObject();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        f70096a = str;
    }
}
