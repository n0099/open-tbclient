package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.diskcache.kwai.a;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        a.c a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aVar, str)) == null) {
            InputStream inputStream2 = null;
            try {
                a = aVar.a(str);
            } catch (Exception e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                d.a((Closeable) inputStream2);
                throw th;
            }
            if (a == null) {
                d.a((Closeable) null);
                return null;
            }
            inputStream = a.a(0);
            try {
                try {
                    Object a2 = d.a(inputStream);
                    d.a((Closeable) inputStream);
                    return a2;
                } catch (Exception e3) {
                    e = e3;
                    com.kwad.sdk.core.d.a.a(e);
                    d.a((Closeable) inputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                d.a((Closeable) inputStream2);
                throw th;
            }
        }
        return invokeLL.objValue;
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, aVar, str, obj) == null) {
            OutputStream outputStream = null;
            try {
                try {
                    a.C2013a b2 = aVar.b(str);
                    if (b2 != null) {
                        outputStream = b2.a(0);
                        if (d.a(outputStream, obj)) {
                            b2.a();
                        } else {
                            b2.b();
                        }
                        aVar.b();
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            } finally {
                d.a(outputStream);
            }
        }
    }
}
