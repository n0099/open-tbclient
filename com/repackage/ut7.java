package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ut7 extends tt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut7(ng5 ng5Var) {
        super(ng5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ng5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ng5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
