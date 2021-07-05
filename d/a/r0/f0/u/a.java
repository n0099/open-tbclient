package d.a.r0.f0.u;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mutiprocess.showreplyinpb.ShowReplyInPbEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.f0.b;
/* loaded from: classes9.dex */
public class a implements b<ShowReplyInPbEvent> {
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
    public boolean onEvent(ShowReplyInPbEvent showReplyInPbEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, showReplyInPbEvent)) == null) {
            if (showReplyInPbEvent == null) {
                return false;
            }
            if (showReplyInPbEvent.isSubPbReply) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921481, showReplyInPbEvent.writeData));
                return true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921480, showReplyInPbEvent.writeData));
            return true;
        }
        return invokeL.booleanValue;
    }
}
