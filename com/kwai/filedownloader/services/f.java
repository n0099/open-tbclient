package com.kwai.filedownloader.services;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, cVar) == null) {
            if (cVar == null) {
                throw new IllegalArgumentException();
            }
            if (cVar.f() != -3) {
                throw new IllegalStateException();
            }
            Intent intent = new Intent("filedownloader.intent.action.completed");
            intent.putExtra("model", cVar);
            com.kwai.filedownloader.e.c.a().sendBroadcast(intent);
        }
    }
}
