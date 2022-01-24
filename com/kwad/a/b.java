package com.kwad.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, com.kwad.a.c cVar);
    }

    /* renamed from: com.kwad.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2092b {
        void a(String str);

        String[] a();

        void b(String str);

        String c(String str);

        String d(String str);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(String str);

        void a(String str, Throwable th);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str);
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            a(context, str, null, null);
        }
    }

    public static void a(Context context, String str, String str2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, str, str2, cVar) == null) {
            new com.kwad.a.c().a(context, str, str2, cVar);
        }
    }
}
