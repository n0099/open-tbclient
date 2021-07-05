package d.a.s0.i1.l;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.i1.d;
import d.a.s0.i1.e;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends d.a.c.c.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super(2016007);
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
    @Override // d.a.c.c.f.g
    /* renamed from: c */
    public CustomResponsedMessage a(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        List<ImMessageCenterPojo> data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage)) == null) {
            ImMessageCenterPojo imMessageCenterPojo = null;
            if (customResponsedMessage == null) {
                return null;
            }
            if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
                ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
                if (responsedMemoryListMessage.getType() == 1 && (data = responsedMemoryListMessage.getData()) != null) {
                    ImMessageCenterPojo imMessageCenterPojo2 = null;
                    for (ImMessageCenterPojo imMessageCenterPojo3 : data) {
                        if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -8) {
                            imMessageCenterPojo = imMessageCenterPojo3;
                        }
                        if (imMessageCenterPojo3 != null && imMessageCenterPojo3.getCustomGroupType() == -7) {
                            imMessageCenterPojo2 = imMessageCenterPojo3;
                        }
                    }
                    if (imMessageCenterPojo != null) {
                        data.remove(imMessageCenterPojo);
                        data.add(d.a(imMessageCenterPojo));
                    }
                    if (imMessageCenterPojo2 != null) {
                        data.remove(imMessageCenterPojo2);
                        data.add(e.a(imMessageCenterPojo2));
                    }
                }
            }
            return customResponsedMessage;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}
