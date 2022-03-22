package org.apache.http.impl.conn.tsccm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes8.dex */
public class ConnPoolByRoute extends AbstractConnPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Queue<BasicPoolEntry> freeConnections;
    public final int maxTotalConnections;
    public final ClientConnectionOperator operator;
    public final Map<HttpRoute, RouteSpecificPool> routeToPool;
    public Queue<WaitingThread> waitingThreads;

    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator, HttpParams httpParams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clientConnectionOperator, httpParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry createEntry(RouteSpecificPool routeSpecificPool, ClientConnectionOperator clientConnectionOperator) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, routeSpecificPool, clientConnectionOperator)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (BasicPoolEntry) invokeLL.objValue;
    }

    public Queue<BasicPoolEntry> createFreeConnQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Queue) invokeV.objValue;
    }

    public Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Map) invokeV.objValue;
    }

    public Queue<WaitingThread> createWaitingThreadQueue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (Queue) invokeV.objValue;
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void deleteClosedConnections() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void deleteEntry(BasicPoolEntry basicPoolEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, basicPoolEntry) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void deleteLeastUsedEntry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{basicPoolEntry, Boolean.valueOf(z), Long.valueOf(j), timeUnit}) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpRoute)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.intValue;
    }

    public BasicPoolEntry getEntryBlocking(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit, WaitingThreadAborter waitingThreadAborter) throws ConnectionPoolTimeoutException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{httpRoute, obj, Long.valueOf(j), timeUnit, waitingThreadAborter})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (BasicPoolEntry) invokeCommon.objValue;
    }

    public BasicPoolEntry getFreeEntry(RouteSpecificPool routeSpecificPool, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, routeSpecificPool, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (BasicPoolEntry) invokeLL.objValue;
    }

    public RouteSpecificPool getRoutePool(HttpRoute httpRoute, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, httpRoute, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RouteSpecificPool) invokeLZ.objValue;
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void handleLostEntry(HttpRoute httpRoute) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, httpRoute) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public RouteSpecificPool newRouteSpecificPool(HttpRoute httpRoute) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, httpRoute)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (RouteSpecificPool) invokeL.objValue;
    }

    public WaitingThread newWaitingThread(Condition condition, RouteSpecificPool routeSpecificPool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, condition, routeSpecificPool)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (WaitingThread) invokeLL.objValue;
    }

    public void notifyWaitingThread(RouteSpecificPool routeSpecificPool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, routeSpecificPool) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, httpRoute, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (PoolEntryRequest) invokeLL.objValue;
    }

    @Override // org.apache.http.impl.conn.tsccm.AbstractConnPool
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
