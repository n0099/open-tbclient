package d.a.p0.i1.v.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class l implements CustomMessageTask.CustomRunnable<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
            if (customMessage == null || !(customMessage instanceof RequestOfficialBarMenuLocalMessage)) {
                return null;
            }
            String forum_id = ((RequestOfficialBarMenuLocalMessage) customMessage).getForum_id();
            byte[] bArr = d.a.o0.r.r.a.f().d("tb.official_bar_menu").get(ResponseOfficialBarMenuMessage.OFFICIAL_BAR_MENU_KEY_PRE + forum_id);
            ResponseOfficialBarMenuLocalMessage responseOfficialBarMenuLocalMessage = new ResponseOfficialBarMenuLocalMessage();
            try {
                responseOfficialBarMenuLocalMessage.decodeInBackGround(2001177, bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return responseOfficialBarMenuLocalMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
