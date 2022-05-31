package com.repackage;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class vr7 extends ur7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr7(ne5 ne5Var) {
        super(ne5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ne5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ne5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
