package com.sina.weibo.sdk.network.impl;

import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.IRequestService;
import com.sina.weibo.sdk.network.RequestCancelable;
import com.sina.weibo.sdk.network.base.RequestResult;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.network.exception.RequestException;
import com.sina.weibo.sdk.network.exception.SdkException;
import com.sina.weibo.sdk.network.intercept.GlobalInterceptHelper;
import com.sina.weibo.sdk.network.target.Target;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class RequestService implements IRequestService {
    public static /* synthetic */ Interceptable $ic;
    public static IRequestService iRequestService;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService fixedThreadPool;

    public RequestService() {
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
        GlobalInterceptHelper.init();
        this.fixedThreadPool = Executors.newFixedThreadPool(10);
    }

    public static IRequestService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (iRequestService == null) {
                iRequestService = new RequestService();
            }
            return iRequestService;
        }
        return (IRequestService) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestService
    public <T> RequestCancelable asyncRequest(IRequestParam iRequestParam, Target<T> target) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iRequestParam, target)) == null) {
            this.fixedThreadPool.execute(new FixRequestTask(iRequestParam, target));
            return null;
        }
        return (RequestCancelable) invokeLL.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestService
    public RequestResult request(IRequestParam iRequestParam) throws RequestException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iRequestParam)) == null) {
            RequestResult requestResult = new RequestResult();
            if (!NetStateManager.isNetworkConnected(iRequestParam.getContext())) {
                LogUtil.e("Task", "RequestService:网络连接错误，请检查网络状态");
                requestResult.setE(new SdkException("网络连接错误，请检查网络状态"));
            }
            if (iRequestParam.needIntercept()) {
                try {
                    Bundle bundle = new Bundle();
                    HashMap<String, IRequestIntercept> globalIntercept = GlobalInterceptHelper.init().getGlobalIntercept();
                    for (String str : globalIntercept.keySet()) {
                        IRequestIntercept iRequestIntercept = globalIntercept.get(str);
                        if (iRequestIntercept != null && iRequestIntercept.needIntercept(iRequestParam, bundle)) {
                            iRequestIntercept.doIntercept(iRequestParam, bundle);
                        }
                    }
                    Iterator<IRequestIntercept> it = iRequestParam.getIntercept().iterator();
                    while (it.hasNext()) {
                        IRequestIntercept next = it.next();
                        if (next.needIntercept(iRequestParam, bundle)) {
                            next.doIntercept(iRequestParam, bundle);
                        }
                    }
                    iRequestParam.getPostBundle().putAll(bundle);
                    iRequestParam.getGetBundle().putAll(bundle);
                } catch (InterceptException e) {
                    requestResult.setE(e);
                    return requestResult;
                }
            }
            try {
                requestResult.setResponse(String.valueOf(RequestEngine.request(iRequestParam).body().string()));
            } catch (Exception e2) {
                requestResult.setE(e2);
            }
            return requestResult;
        }
        return (RequestResult) invokeL.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestService
    @Deprecated
    public <T> T request(IRequestParam iRequestParam, Class<T> cls) throws RequestException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, iRequestParam, cls)) == null) {
            return null;
        }
        return (T) invokeLL.objValue;
    }
}
