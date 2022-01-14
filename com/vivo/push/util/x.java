package com.vivo.push.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes4.dex */
public final class x extends b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static x f60776b;
    public transient /* synthetic */ FieldHolder $fh;

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized x b() {
        InterceptResult invokeV;
        x xVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (x.class) {
                if (f60776b == null) {
                    f60776b = new x();
                }
                xVar = f60776b;
            }
            return xVar;
        }
        return (x) invokeV.objValue;
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = context;
                    a(context, "com.vivo.push_preferences");
                }
            }
        }
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] c2 = c(b("com.vivo.push.secure_cache_iv", ""));
            return (c2 == null || c2.length <= 0) ? new byte[]{34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 37, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 41, Base64.INTERNAL_PADDING, 32, 32, 32} : c2;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] c2 = c(b("com.vivo.push.secure_cache_key", ""));
            return (c2 == null || c2.length <= 0) ? new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, Base64.INTERNAL_PADDING, 34, PublicSuffixDatabase.EXCEPTION_MARKER} : c2;
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] c(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] bArr = null;
            try {
                String[] split = str.split(",");
                if (split.length > 0) {
                    bArr = new byte[split.length];
                    i2 = split.length;
                } else {
                    i2 = 0;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = Byte.parseByte(split[i3].trim());
                }
            } catch (Exception e2) {
                p.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
