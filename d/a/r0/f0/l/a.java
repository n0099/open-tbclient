package d.a.r0.f0.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.f0.b;
import d.a.s0.h3.h0.e;
/* loaded from: classes9.dex */
public class a implements b<AgreeEvent> {
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
    @Override // d.a.r0.f0.b
    /* renamed from: a */
    public boolean onEvent(AgreeEvent agreeEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, agreeEvent)) == null) {
            if (agreeEvent != null && agreeEvent.agreeData != null) {
                e eVar = new e();
                eVar.f61216b = agreeEvent.agreeData;
                String str = agreeEvent.agreeExtra;
                if (AgreeEvent.IS_THREAD.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                    return true;
                } else if (AgreeEvent.IS_POST.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
