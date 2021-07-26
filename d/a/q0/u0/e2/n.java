package d.a.q0.u0.e2;

import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h3.s;
/* loaded from: classes8.dex */
public class n implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f63360a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<d.a.q0.h3.m, ?> f63361b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, d.a.q0.h3.m> f63362c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, d.a.q0.h3.m> f63363d;

    /* renamed from: e  reason: collision with root package name */
    public s f63364e;

    public n() {
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

    public void a(FrsModelController frsModelController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsModelController) == null) {
            this.f63360a = frsModelController;
        }
    }

    public void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            this.f63364e = sVar;
        }
    }

    public void c(MvcSocketMessage<FrsRequestData, d.a.q0.h3.m> mvcSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketMessage) == null) {
            this.f63362c = mvcSocketMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, d.a.q0.h3.m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f63363d = mvcNetMessage;
        }
    }

    public void e(MvcSocketResponsedMessage<d.a.q0.h3.m, ?> mvcSocketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcSocketResponsedMessage) == null) {
            this.f63361b = mvcSocketResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f63360a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.C0(this.f63361b, this.f63362c, this.f63363d);
            s sVar = this.f63364e;
            if (sVar != null) {
                sVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
