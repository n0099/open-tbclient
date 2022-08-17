package com.repackage;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            l87.o();
            a97.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            s87.l().m(TbadkCoreApplication.getInst().getContext());
            b97.b().c();
            w87.i();
            e97.k();
        }
    }
}
