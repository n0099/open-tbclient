package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mu7 extends lu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu7(tf5 tf5Var) {
        super(tf5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tf5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
