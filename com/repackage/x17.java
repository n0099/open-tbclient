package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            q47.o();
            f57.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            x47.l().m(TbadkCoreApplication.getInst().getContext());
            g57.b().c();
            b57.i();
            j57.k();
        }
    }
}
