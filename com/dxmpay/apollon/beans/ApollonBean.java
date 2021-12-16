package com.dxmpay.apollon.beans;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.taskmanager.TaskManager;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ApollonBean<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context mContext;
    public RestTemplate mRestTemplate;
    public IBeanResponseCallback mRspCallback;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Class f55644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Class f55645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ApollonBean f55646g;

        public a(ApollonBean apollonBean, Class cls, Class cls2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apollonBean, cls, cls2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55646g = apollonBean;
            this.f55644e = cls;
            this.f55645f = cls2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.f55646g.prepareRestTemplate();
                        this.f55646g.executeAndHandleResponse(this.f55644e, this.f55645f);
                    } catch (Exception e2) {
                        this.f55646g.handleCommonErrors(e2);
                    }
                } finally {
                    this.f55646g.mRspCallback = null;
                }
            }
        }
    }

    public ApollonBean(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.mContext = context.getApplicationContext();
        getClass().getName();
    }

    public void destroyBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRspCallback = null;
            TaskManager.getInstance("DxmBeanTaskManager").cancelTask("DxmApollonBeanTask", this.a);
            RestTemplate restTemplate = this.mRestTemplate;
            if (restTemplate != null) {
                restTemplate.setRequestInterceptor(null);
            }
        }
    }

    public abstract void execBean();

    public <T> void execBean(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
            execBean(cls, null);
        }
    }

    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> restResponseEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                restResponseEntity = this.mRestTemplate.i(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else if (getHttpMethod() == 1) {
                restResponseEntity = this.mRestTemplate.n(getUrl(), getRequestParams(), getEncode(), JsonUtils.DataType.isString(cls) ? BeanResponseString.class : BeanResponseBase.class);
            } else {
                restResponseEntity = null;
            }
            handleResponse(cls, cls2, restResponseEntity);
        }
    }

    public int getAuthLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public abstract int getBeanId();

    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "UTF-8" : (String) invokeV.objValue;
    }

    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract List<RestNameValuePair> getRequestParams();

    public abstract String getUrl();

    public abstract <T, E> void handleCommonErrors(Exception exc);

    public abstract void handleNetworkFailureError();

    public abstract <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity);

    public abstract <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity);

    public abstract void prepareRestTemplate();

    public void setResponseCallback(IBeanResponseCallback iBeanResponseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iBeanResponseCallback) == null) {
            this.mRspCallback = iBeanResponseCallback;
        }
    }

    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cls, cls2) == null) {
            a aVar = new a(this, cls, cls2);
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                handleNetworkFailureError();
                return;
            }
            TaskManager taskManager = TaskManager.getInstance("DxmBeanTaskManager");
            this.a = "BeanTask_" + getBeanId() + "_" + System.currentTimeMillis();
            taskManager.getClass();
            taskManager.addTask(new TaskManager.Task(taskManager, 0L, 0L, false, this.a, aVar), "DxmApollonBeanTask");
        }
    }
}
