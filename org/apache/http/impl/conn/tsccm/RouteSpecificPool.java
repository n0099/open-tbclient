package org.apache.http.impl.conn.tsccm;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.http.conn.routing.HttpRoute;
@Deprecated
/* loaded from: classes10.dex */
public class RouteSpecificPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<BasicPoolEntry> freeEntries;
    public final int maxEntries;
    public int numEntries;
    public final HttpRoute route;
    public final Queue<WaitingThread> waitingThreads;

    public RouteSpecificPool(HttpRoute httpRoute, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpRoute, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry allocEntry(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (BasicPoolEntry) invokeL.objValue;
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, basicPoolEntry) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, basicPoolEntry)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    public void dropEntry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, basicPoolEntry) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    public final int getEntryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    public final int getMaxEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.intValue;
    }

    public final HttpRoute getRoute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpRoute) invokeV.objValue;
    }

    public boolean hasThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public boolean isUnused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public WaitingThread nextThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (WaitingThread) invokeV.objValue;
    }

    public void queueThread(WaitingThread waitingThread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, waitingThread) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void removeThread(WaitingThread waitingThread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, waitingThread) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
