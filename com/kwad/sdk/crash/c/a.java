package com.kwad.sdk.crash.c;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import java.util.ArrayList;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public static void a(ExceptionMessage exceptionMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, exceptionMessage) == null) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "upload msg=" + exceptionMessage);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(com.kwad.sdk.crash.report.request.c.a(exceptionMessage));
            new com.kwad.sdk.crash.report.request.b().a(arrayList);
        }
    }

    public static void a(@NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
            caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
            caughtExceptionMessage.mCrashDetail = th.toString();
            f.a(th, caughtExceptionMessage, com.kwad.sdk.crash.d.a().f());
            f.a(caughtExceptionMessage, a());
            a(caughtExceptionMessage);
        }
    }
}
