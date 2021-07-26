package d.a.q0.h2.k.e;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.p0.d1.m.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.p0.d1.m.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o(TbConfig.getContentLineSpace(), 1.0f);
        i(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        y(0);
        l(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        m(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        r(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32), d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44));
        f(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        s(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
        u(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds38));
        j(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
        h(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }
}
