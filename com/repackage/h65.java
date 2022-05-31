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
/* loaded from: classes6.dex */
public abstract class h65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<f65> eventDelegates;
    public boolean isDispatchMvcEventing;
    public BdUniqueId uniqueId;

    public h65() {
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

    public void addEventDelegate(f65 f65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f65Var) == null) {
            if (this.eventDelegates == null) {
                this.eventDelegates = new ArrayList();
            }
            if (this.eventDelegates.contains(f65Var)) {
                return;
            }
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.add(f65Var);
        }
    }

    public boolean dispatchMvcEvent(g65 g65Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g65Var)) == null) {
            if (g65Var == null) {
                return false;
            }
            if (g65Var.e() == null) {
                g65Var.i(this.uniqueId);
            }
            if (this.eventDelegates != null) {
                try {
                    this.isDispatchMvcEventing = true;
                    onBeforeDispatchMvcEvent(g65Var);
                    int size = this.eventDelegates.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        try {
                            f65 f65Var = this.eventDelegates.get(i);
                            if (f65Var != null && ((!f65Var.j0() || (f65Var.j0() && g65Var.e() == f65Var.getUniqueId())) && (z = f65Var.P(g65Var)) && g65Var.f())) {
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

    public void onBeforeDispatchMvcEvent(g65 g65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g65Var) == null) {
        }
    }

    public void removeEventDelegate(f65 f65Var) {
        List<f65> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, f65Var) == null) && (list = this.eventDelegates) != null && list.contains(f65Var)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(f65Var);
        }
    }
}
