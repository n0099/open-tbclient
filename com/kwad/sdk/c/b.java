package com.kwad.sdk.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.q;
import java.io.File;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public String a(com.kwad.sdk.c.kwai.d dVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, dVar, z)) == null) {
            com.kwad.sdk.c.b.b.a(dVar, 2);
            String b2 = com.kwad.sdk.c.b.a.b(this.a, dVar.f());
            try {
                com.kwad.sdk.c.b.a.a(b2, com.kwad.sdk.c.b.a.a(this.a, dVar.f()));
            } catch (Exception e2) {
                e2.printStackTrace();
                com.kwad.sdk.c.b.b.a(dVar, 2, e2.getMessage());
            }
            if (b2 != null) {
                q.c(new File(b2));
            }
            return dVar.f();
        }
        return (String) invokeLZ.objValue;
    }
}
