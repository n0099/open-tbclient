package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class sv7 extends rv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv7(bi5 bi5Var) {
        super(bi5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bi5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bi5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
