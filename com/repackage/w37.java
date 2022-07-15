package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class w37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            s67.o();
            h77.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            z67.l().m(TbadkCoreApplication.getInst().getContext());
            i77.b().c();
            d77.i();
            l77.k();
        }
    }
}
