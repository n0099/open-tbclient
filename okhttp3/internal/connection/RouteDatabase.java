package okhttp3.internal.connection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;
/* loaded from: classes2.dex */
public final class RouteDatabase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Route> failedRoutes;

    public RouteDatabase() {
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
        this.failedRoutes = new LinkedHashSet();
    }

    public synchronized void connected(Route route) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, route) == null) {
            synchronized (this) {
                this.failedRoutes.remove(route);
            }
        }
    }

    public synchronized void failed(Route route) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, route) == null) {
            synchronized (this) {
                this.failedRoutes.add(route);
            }
        }
    }

    public synchronized boolean shouldPostpone(Route route) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, route)) == null) {
            synchronized (this) {
                contains = this.failedRoutes.contains(route);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }
}
