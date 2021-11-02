package com.ss.android.socialbase.appdownloader.f.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(d dVar, int i2) throws IOException {
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, dVar, i2) == null) || (b2 = dVar.b()) == i2) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i2) + ", read 0x" + Integer.toHexString(b2) + ".");
    }
}
