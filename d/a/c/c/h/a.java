package d.a.c.c.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, d.a.c.c.f.b, CustomResponsedMessage<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.e.b f43952i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43952i = null;
        this.f43952i = new d.a.c.c.e.b(messageManager);
        this.f43959e = d.a.c.c.j.a.c();
    }

    @Override // d.a.c.c.b
    public LinkedList<CustomMessage<?>> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? this.f43952i.e(i2, bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // d.a.c.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bdUniqueId) == null) {
            this.f43952i.h(i2, bdUniqueId);
        }
    }

    public LinkedList<CustomMessage<?>> v(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdUniqueId)) == null) ? this.f43952i.i(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.h.c
    /* renamed from: w */
    public CustomMessage<?> l(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, customMessage, customMessageTask)) == null) ? this.f43955a.getController().g(customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f43952i.j(bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> y(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, customMessage, customMessageTask, cls)) == null) ? this.f43952i.k(customMessage, customMessageTask, cls) : (CustomResponsedMessage) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.c.b
    /* renamed from: z */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customMessage, customMessageTask) == null) {
            this.f43952i.f(customMessage, customMessageTask);
        }
    }
}
