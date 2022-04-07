package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class ta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<oa> a;
    public final LinkedList<va> b;
    public final LinkedList<ma> c;
    public final LinkedList<na> d;
    public final LinkedList<ua> e;
    public final LinkedList<la> f;
    public final LinkedList<pa> g;

    public ta() {
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
        this.a = new LinkedList<>();
        this.b = new LinkedList<>();
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = new LinkedList<>();
        this.f = new LinkedList<>();
        this.g = new LinkedList<>();
    }

    public void a(pa paVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, paVar) == null) {
            this.g.add(paVar);
        }
    }

    public void b(qa<?, ?> qaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qaVar) == null) || qaVar == null) {
            return;
        }
        oi.c();
        if (qaVar instanceof oa) {
            FrameHelper.insert(this.a, (oa) qaVar);
        } else if (qaVar instanceof va) {
            FrameHelper.insert(this.b, (va) qaVar);
        } else if (qaVar instanceof ma) {
            FrameHelper.insert(this.c, (ma) qaVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(ra<?> raVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, raVar) == null) || raVar == null) {
            return;
        }
        oi.c();
        if (raVar instanceof na) {
            FrameHelper.insert(this.d, (na) raVar);
        } else if (raVar instanceof ua) {
            FrameHelper.insert(this.e, (ua) raVar);
        } else if (raVar instanceof la) {
            FrameHelper.insert(this.f, (la) raVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(qa<?, ?> qaVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, qaVar) == null) || qaVar == null) {
            return;
        }
        oi.c();
        if (qaVar instanceof oa) {
            this.a.remove(qaVar);
        } else if (qaVar instanceof va) {
            this.b.remove(qaVar);
        } else if (qaVar instanceof ma) {
            this.c.remove(qaVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> e(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, customMessage, customMessageTask)) == null) ? (CustomMessage) i(this.c, customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public CustomResponsedMessage<?> f(CustomResponsedMessage<?> customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customResponsedMessage)) == null) ? (CustomResponsedMessage) j(this.f, customResponsedMessage) : (CustomResponsedMessage) invokeL.objValue;
    }

    public HttpMessage g(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, httpMessage, httpMessageTask)) == null) ? (HttpMessage) i(this.a, httpMessage, httpMessageTask) : (HttpMessage) invokeLL.objValue;
    }

    public HttpResponsedMessage h(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpResponsedMessage)) == null) ? (HttpResponsedMessage) j(this.d, httpResponsedMessage) : (HttpResponsedMessage) invokeL.objValue;
    }

    public final <M extends Message<?>, T extends MessageTask> M i(LinkedList<? extends qa<M, T>> linkedList, M m, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linkedList, m, t)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && m != null; i++) {
                try {
                    m = linkedList.get(i).rule(m, t);
                } catch (Exception e) {
                    BdLog.e(e, true);
                }
            }
            return m;
        }
        return (M) invokeLLL.objValue;
    }

    public final <M extends ResponsedMessage<?>> M j(LinkedList<? extends ra<M>> linkedList, M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, linkedList, m)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i = 0; i < size && m != null; i++) {
                try {
                    m = linkedList.get(i).b(m);
                } catch (Exception e) {
                    BdLog.e("rule error = " + e.getMessage());
                }
            }
            return m;
        }
        return (M) invokeLL.objValue;
    }

    public SocketMessage k(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, socketMessage, socketMessageTask)) == null) ? (SocketMessage) i(this.b, socketMessage, socketMessageTask) : (SocketMessage) invokeLL.objValue;
    }

    public SocketResponsedMessage l(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, socketResponsedMessage)) == null) ? (SocketResponsedMessage) j(this.e, socketResponsedMessage) : (SocketResponsedMessage) invokeL.objValue;
    }

    public void m(int i, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bdUniqueId) == null) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.g.get(i2).a(i, bdUniqueId);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                this.g.get(i).b(bdUniqueId);
            }
        }
    }
}
