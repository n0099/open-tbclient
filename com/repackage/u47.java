package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b77.p();
            q77.o();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            i77.l().m(TbadkCoreApplication.getInst().getContext());
            r77.b().d();
            m77.i();
            v77.j();
        }
    }
}
