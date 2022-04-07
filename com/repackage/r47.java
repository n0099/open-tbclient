package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            y67.p();
            n77.o();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            f77.l().m(TbadkCoreApplication.getInst().getContext());
            o77.b().d();
            j77.i();
            s77.j();
        }
    }
}
