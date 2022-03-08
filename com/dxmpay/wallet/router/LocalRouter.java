package com.dxmpay.wallet.router;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class LocalRouter implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LocalRouter";
    public static LocalRouter sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, RouterProvider> mProviders;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1217531203, "Lcom/dxmpay/wallet/router/LocalRouter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1217531203, "Lcom/dxmpay/wallet/router/LocalRouter;");
        }
    }

    public LocalRouter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mProviders = null;
        this.mProviders = new HashMap<>();
    }

    private RouterAction findRequestAction(RouterRequest routerRequest) {
        InterceptResult invokeL;
        RouterAction findAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, routerRequest)) == null) {
            RouterProvider routerProvider = this.mProviders.get(routerRequest.getProvider());
            ErrorAction errorAction = new ErrorAction();
            return (routerProvider == null || (findAction = routerProvider.findAction(routerRequest.getAction())) == null) ? errorAction : findAction;
        }
        return (RouterAction) invokeL.objValue;
    }

    public static synchronized LocalRouter getInstance(@NonNull Context context) {
        InterceptResult invokeL;
        LocalRouter localRouter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (LocalRouter.class) {
                if (sInstance == null) {
                    sInstance = new LocalRouter(context);
                }
                localRouter = sInstance;
            }
            return localRouter;
        }
        return (LocalRouter) invokeL.objValue;
    }

    public boolean isProviderExisted(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (TextUtils.isEmpty(str) || this.mProviders.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public boolean isRequestAvailable(RouterRequest routerRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, routerRequest)) == null) {
            RouterProvider routerProvider = this.mProviders.get(routerRequest.getProvider());
            return (routerProvider == null || routerProvider.findAction(routerRequest.getAction()) == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, routerProvider) == null) {
            this.mProviders.put(str, routerProvider);
        }
    }

    public void route(Context context, @NonNull RouterRequest routerRequest, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, routerRequest, routerCallback) == null) {
            String str = "Process:Local find action start: " + System.currentTimeMillis();
            String str2 = "Process:Local find action end: " + System.currentTimeMillis();
            try {
                findRequestAction(routerRequest).invoke(context, routerRequest.getData(), routerCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                HashMap hashMap = new HashMap();
                hashMap.put("errorMsg", e2.getMessage());
                routerCallback.onResult(1, hashMap);
            }
            String str3 = "Process:Local route end: " + System.currentTimeMillis();
        }
    }
}
