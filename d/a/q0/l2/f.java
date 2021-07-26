package d.a.q0.l2;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personExtra.PersonBarByUidLocalMessage;
import com.baidu.tieba.personExtra.ResponsePersonBarByUidLocalMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f implements CustomMessageTask.CustomRunnable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
            if (customMessage == null || !(customMessage instanceof PersonBarByUidLocalMessage)) {
                return null;
            }
            String str = d.a.p0.s.r.a.f().g("tb.my_pages").get(TbadkCoreApplication.getCurrentAccount());
            ResponsePersonBarByUidLocalMessage responsePersonBarByUidLocalMessage = new ResponsePersonBarByUidLocalMessage();
            if (str != null) {
                try {
                    responsePersonBarByUidLocalMessage.decodeInBackGround(2001183, str);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return responsePersonBarByUidLocalMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
