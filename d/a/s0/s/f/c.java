package d.a.s0.s.f;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements CustomMessageTask.CustomRunnable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof GetContactListRequestMessage)) {
                return null;
            }
            List<d.a.r0.s.f.a> e2 = f.f().e();
            if (e2 != null) {
                Iterator<d.a.r0.s.f.a> it = e2.iterator();
                while (it.hasNext()) {
                    d.a.r0.s.f.a next = it.next();
                    if ((k.isEmpty(next.f()) && k.isEmpty(next.g())) || next.i() == 1) {
                        it.remove();
                    }
                }
            }
            GetContactListResponsedMessage getContactListResponsedMessage = new GetContactListResponsedMessage();
            getContactListResponsedMessage.setContacts(e2);
            return getContactListResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
