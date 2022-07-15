package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class y75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<w75> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public y75() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDispatchMvcEventing = false;
    }

    public void addEventDelegate(w75 w75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, w75Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(w75Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(w75Var);
        }
    }

    public boolean dispatchMvcEvent(x75 x75Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x75Var)) == null) {
            if (x75Var == null) {
                return false;
            }
            if (x75Var.e() == null) {
                x75Var.i(this.uniqueId);
            }
            if (this.eventDelegates != null) {
                try {
                    this.isDispatchMvcEventing = true;
                    onBeforeDispatchMvcEvent(x75Var);
                    int size = this.eventDelegates.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        try {
                            w75 w75Var = this.eventDelegates.get(i);
                            if (w75Var != null && ((!w75Var.T0() || (w75Var.T0() && x75Var.e() == w75Var.getUniqueId())) && (z = w75Var.t0(x75Var)) && x75Var.f())) {
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

    public void onBeforeDispatchMvcEvent(x75 x75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x75Var) == null) {
        }
    }

    public void removeEventDelegate(w75 w75Var) {
        List<w75> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, w75Var) == null) && (list = this.eventDelegates) != null && list.contains(w75Var)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(w75Var);
        }
    }
}
