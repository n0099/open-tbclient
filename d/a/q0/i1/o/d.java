package d.a.q0.i1.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.c.f.j;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super(202009);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.c.f.g
    /* renamed from: c */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
            if (socketResponsedMessage instanceof PushResponseMessage) {
                if (socketResponsedMessage.getError() == 110000) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
                }
                PushResponseMessage pushResponseMessage = (PushResponseMessage) socketResponsedMessage;
                if (pushResponseMessage.getNotificationData() != null && TbadkCoreApplication.getInst().isInBackground()) {
                    CustomMessage customMessage = new CustomMessage(2012100);
                    customMessage.setData(pushResponseMessage.getNotificationData());
                    MessageManager.getInstance().sendMessage(customMessage);
                    return null;
                }
                List<GroupMsgData> groupMsg = pushResponseMessage.getGroupMsg();
                if (groupMsg != null && groupMsg.size() > 0) {
                    for (GroupMsgData groupMsgData : groupMsg) {
                        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
                        }
                    }
                }
                return socketResponsedMessage;
            }
            return null;
        }
        return (SocketResponsedMessage) invokeL.objValue;
    }
}
