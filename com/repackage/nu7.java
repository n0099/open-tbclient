package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nu7 extends mu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu7(af5 af5Var) {
        super(af5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {af5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((af5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
