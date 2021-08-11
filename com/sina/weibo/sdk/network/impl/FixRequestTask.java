package com.sina.weibo.sdk.network.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.RequestCancelable;
import com.sina.weibo.sdk.network.base.RequestResult;
import com.sina.weibo.sdk.network.base.WbResponse;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.network.exception.SdkException;
import com.sina.weibo.sdk.network.intercept.GlobalInterceptHelper;
import com.sina.weibo.sdk.network.target.Target;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class FixRequestTask<T, R> implements Runnable, RequestCancelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FixRequestTask<T, R>.RequestCallback callback;
    public IRequestParam param;
    public Class<T> tClass;
    public Target<R> target;

    /* renamed from: com.sina.weibo.sdk.network.impl.FixRequestTask$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public class RequestCallback implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FixRequestTask this$0;

        public RequestCallback(FixRequestTask fixRequestTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fixRequestTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = fixRequestTask;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: com.sina.weibo.sdk.network.target.Target */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                RequestResult requestResult = (RequestResult) message.obj;
                if (this.this$0.target != null) {
                    this.this$0.target.onRequestDone();
                    if (requestResult.getE() != null) {
                        this.this$0.target.onFailure(requestResult.getE());
                        this.this$0.target.onError();
                        return false;
                    }
                    this.this$0.target.onRequestSuccess(requestResult.getResponse());
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ RequestCallback(FixRequestTask fixRequestTask, AnonymousClass1 anonymousClass1) {
            this(fixRequestTask);
        }
    }

    public FixRequestTask(IRequestParam iRequestParam, Target<R> target) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iRequestParam, target};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.param = iRequestParam;
        this.target = target;
        this.callback = new RequestCallback(this, null);
    }

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public void cancelRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            run();
        }
    }

    @Override // com.sina.weibo.sdk.network.RequestCancelable
    public boolean isCancelRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RequestResult requestResult = new RequestResult();
            if (!NetStateManager.isNetworkConnected(this.param.getContext())) {
                LogUtil.e("Task", "FixRequestTask:android.permission.ACCESS_NETWORK_STATE");
                requestResult.setE(new SdkException(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION));
            }
            if (this.param.needIntercept()) {
                try {
                    Bundle bundle = new Bundle();
                    HashMap<String, IRequestIntercept> globalIntercept = GlobalInterceptHelper.init().getGlobalIntercept();
                    for (String str : globalIntercept.keySet()) {
                        IRequestIntercept iRequestIntercept = globalIntercept.get(str);
                        if (iRequestIntercept != null && iRequestIntercept.needIntercept(this.param, bundle)) {
                            iRequestIntercept.doIntercept(this.param, bundle);
                        }
                    }
                    Iterator<IRequestIntercept> it = this.param.getIntercept().iterator();
                    while (it.hasNext()) {
                        IRequestIntercept next = it.next();
                        if (next.needIntercept(this.param, bundle)) {
                            next.doIntercept(this.param, bundle);
                        }
                    }
                    this.param.getGetBundle().putAll(bundle);
                    this.param.getPostBundle().putAll(bundle);
                } catch (InterceptException e2) {
                    LogUtil.e("Task", "FixRequestTask:" + e2.getMessage());
                    requestResult.setE(e2);
                    Handler handler = new Handler(Looper.getMainLooper(), this.callback);
                    Message message = new Message();
                    message.obj = requestResult;
                    handler.sendMessage(message);
                    return;
                }
            }
            try {
                WbResponse request = RequestEngine.request(this.param);
                R transResponse = this.target.transResponse(request);
                this.target.onRequestSuccessBg(transResponse);
                requestResult.setResponse(transResponse);
                try {
                    InputStream byteStream = request.body().byteStream();
                    if (byteStream != null) {
                        byteStream.close();
                    }
                } catch (Exception unused) {
                }
            } catch (Exception e3) {
                requestResult.setE(e3);
            }
            Handler handler2 = new Handler(Looper.getMainLooper(), this.callback);
            Message message2 = new Message();
            message2.obj = requestResult;
            handler2.sendMessage(message2);
        }
    }
}
