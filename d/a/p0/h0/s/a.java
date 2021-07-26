package d.a.p0.h0.s;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.h0.b;
/* loaded from: classes7.dex */
public class a implements b<PrePageKeyEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.h0.b
    /* renamed from: a */
    public boolean onEvent(PrePageKeyEvent prePageKeyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, prePageKeyEvent)) == null) {
            if (prePageKeyEvent == null && StringUtil.isEmpty(prePageKeyEvent.prePageKey)) {
                return false;
            }
            TbPageExtraHelper.u(prePageKeyEvent.prePageKey);
            return true;
        }
        return invokeL.booleanValue;
    }
}
