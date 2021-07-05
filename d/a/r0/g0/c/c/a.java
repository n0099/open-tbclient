package d.a.r0.g0.c.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.g0.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d.a.r0.g0.c.a> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

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
                return;
            }
        }
        this.isDispatchMvcEventing = false;
    }

    public void addEventDelegate(d.a.r0.g0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(aVar)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(aVar);
        }
    }

    public boolean dispatchMvcEvent(b bVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar != null && bVar.e() == null) {
                bVar.i(this.uniqueId);
            }
            if (this.eventDelegates != null) {
                try {
                    this.isDispatchMvcEventing = true;
                    onBeforeDispatchMvcEvent(bVar);
                    int size = this.eventDelegates.size();
                    z = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        try {
                            d.a.r0.g0.c.a aVar = this.eventDelegates.get(i2);
                            if (aVar != null && ((!aVar.isEventMustSelf() || (aVar.isEventMustSelf() && bVar.e() == aVar.getUniqueId())) && (z = aVar.onEventDispatch(bVar)) && bVar.f())) {
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                BdLog.e(th);
                                if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException(th);
                                }
                                this.isDispatchMvcEventing = false;
                                return z;
                            } finally {
                                this.isDispatchMvcEventing = false;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                this.isDispatchMvcEventing = false;
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onBeforeDispatchMvcEvent(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
        }
    }

    public void removeEventDelegate(d.a.r0.g0.c.a aVar) {
        List<d.a.r0.g0.c.a> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) && (list = this.eventDelegates) != null && list.contains(aVar)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(aVar);
        }
    }
}
