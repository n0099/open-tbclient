package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PendingResultImpl";
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<ApiClient> api;
    public CountDownLatch countLatch;
    public boolean isNeedReport;
    public R result;
    public String transId;
    public DatagramTransport transport;
    public String url;

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public boolean checkApiClient(ApiClient apiClient) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, apiClient)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract R onComplete(T t);

    /* loaded from: classes10.dex */
    public class a implements DatagramTransport.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PendingResultImpl a;

        public a(PendingResultImpl pendingResultImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pendingResultImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pendingResultImpl;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, IMessageEntity iMessageEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, iMessageEntity) != null) {
                return;
            }
            this.a.setResult(i, iMessageEntity);
            this.a.countLatch.countDown();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements DatagramTransport.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ PendingResultImpl b;

        public b(PendingResultImpl pendingResultImpl, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pendingResultImpl, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pendingResultImpl;
            this.a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, IMessageEntity iMessageEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, iMessageEntity) == null) {
                if (!this.a.get()) {
                    this.b.setResult(i, iMessageEntity);
                }
                this.b.countLatch.countDown();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements DatagramTransport.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ ResultCallback b;
        public final /* synthetic */ PendingResultImpl c;

        public c(PendingResultImpl pendingResultImpl, d dVar, ResultCallback resultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pendingResultImpl, dVar, resultCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pendingResultImpl;
            this.a = dVar;
            this.b = resultCallback;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: com.huawei.hms.support.api.PendingResultImpl$d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, IMessageEntity iMessageEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048576, this, i, iMessageEntity) != null) {
                return;
            }
            this.c.setResult(i, iMessageEntity);
            this.a.a(this.b, this.c.result);
        }
    }

    /* loaded from: classes10.dex */
    public static class d<R extends Result> extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(ResultCallback<? super R> resultCallback, R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, resultCallback, r) == null) {
                sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
            }
        }

        public void b(ResultCallback<? super R> resultCallback, R r) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resultCallback, r) == null) {
                resultCallback.onResult(r);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.huawei.hms.support.api.PendingResultImpl$d<R extends com.huawei.hms.support.api.client.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) && message.what == 1) {
                Pair pair = (Pair) message.obj;
                b((ResultCallback) pair.first, (Result) pair.second);
            }
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apiClient, str, iMessageEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.transport = null;
        this.result = null;
        this.url = null;
        this.transId = null;
        this.isNeedReport = true;
        init(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apiClient, str, iMessageEntity, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.transport = null;
        this.result = null;
        this.url = null;
        this.transId = null;
        this.isNeedReport = true;
        init(apiClient, str, iMessageEntity, getResponseType(), i);
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apiClient, str, iMessageEntity, cls};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.transport = null;
        this.result = null;
        this.url = null;
        this.transId = null;
        this.isNeedReport = true;
        init(apiClient, str, iMessageEntity, cls, 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{resultCallback, Long.valueOf(j), timeUnit}) == null) {
            setResultCallback(resultCallback);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, resultCallback) == null) {
            this.isNeedReport = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
            setResultCallback(Looper.getMainLooper(), resultCallback);
        }
    }

    private void biReportEvent(int i, int i2) {
        SubAppInfo subAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65542, this, i, i2) == null) {
            HMSLog.i(TAG, "biReportEvent ====== ");
            ApiClient apiClient = this.api.get();
            if (apiClient != null && this.url != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
                HashMap hashMap = new HashMap();
                hashMap.put("package", apiClient.getPackageName());
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
                if (i2 == 1) {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "req");
                } else {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                    hashMap.put("result", String.valueOf(i));
                    R r = this.result;
                    if (r != null && r.getStatus() != null) {
                        hashMap.put("statusCode", String.valueOf(this.result.getStatus().getStatusCode()));
                    }
                }
                hashMap.put("version", "0");
                String appId = Util.getAppId(apiClient.getContext());
                if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                    appId = subAppInfo.getSubAppID();
                }
                hashMap.put("appid", appId);
                if (TextUtils.isEmpty(this.transId)) {
                    String id = TransactionIdCreater.getId(appId, this.url);
                    this.transId = id;
                    hashMap.put("transId", id);
                } else {
                    hashMap.put("transId", this.transId);
                    this.transId = null;
                }
                String[] split = this.url.split("\\.");
                if (split.length >= 2) {
                    hashMap.put("service", split[0]);
                    hashMap.put("apiName", split[1]);
                }
                hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
                HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.huawei.hms.core.aidl.IMessageEntity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setResult(int i, IMessageEntity iMessageEntity) {
        Status status;
        Status status2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, this, i, iMessageEntity) == null) {
            HMSLog.i(TAG, "setResult:" + i);
            if (iMessageEntity instanceof AbstractMessageEntity) {
                status = ((AbstractMessageEntity) iMessageEntity).getCommonStatus();
            } else {
                status = null;
            }
            if (i == 0) {
                this.result = onComplete(iMessageEntity);
            } else {
                this.result = onError(i);
            }
            if (this.isNeedReport) {
                biReportEvent(i, 2);
            }
            R r = this.result;
            if (r != null && (status2 = r.getStatus()) != null && status != null) {
                int statusCode = status2.getStatusCode();
                String statusMessage = status2.getStatusMessage();
                int statusCode2 = status.getStatusCode();
                String statusMessage2 = status.getStatusMessage();
                if (statusCode != statusCode2) {
                    HMSLog.e(TAG, "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + SmallTailInfo.EMOTION_SUFFIX);
                    HMSLog.e(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + SmallTailInfo.EMOTION_SUFFIX);
                } else if (TextUtils.isEmpty(statusMessage) && !TextUtils.isEmpty(statusMessage2)) {
                    HMSLog.i(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + SmallTailInfo.EMOTION_SUFFIX);
                    this.result.setStatus(new Status(statusCode, statusMessage2, status2.getResolution()));
                }
            }
        }
    }

    private void init(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{apiClient, str, iMessageEntity, cls, Integer.valueOf(i)}) == null) {
            HMSLog.i(TAG, "init uri:" + str);
            this.url = str;
            if (apiClient == null) {
                HMSLog.e(TAG, "client is null");
                return;
            }
            this.api = new WeakReference<>(apiClient);
            this.countLatch = new CountDownLatch(1);
            try {
                this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i));
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                HMSLog.e(TAG, "gen transport error:" + e.getMessage());
                throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
            }
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HMSLog.i(TAG, "await");
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return awaitOnAnyThread();
            }
            HMSLog.e(TAG, "await in main thread");
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        return (R) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit)) == null) {
            HMSLog.i(TAG, "await timeout:" + j + " unit:" + timeUnit.toString());
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return awaitOnAnyThread(j, timeUnit);
            }
            HMSLog.i(TAG, "await in main thread");
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        return (R) invokeJL.objValue;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, looper, resultCallback) == null) {
            HMSLog.i(TAG, "setResultCallback");
            if (looper == null) {
                looper = Looper.myLooper();
            }
            d dVar = new d(looper);
            WeakReference<ApiClient> weakReference = this.api;
            if (weakReference == null) {
                HMSLog.e(TAG, "api is null");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                return;
            }
            ApiClient apiClient = weakReference.get();
            if (!checkApiClient(apiClient)) {
                HMSLog.e(TAG, "client is invalid");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                dVar.a(resultCallback, this.result);
                return;
            }
            if (this.isNeedReport) {
                biReportEvent(0, 1);
            }
            this.transport.post(apiClient, new c(this, dVar, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HMSLog.i(TAG, "awaitOnAnyThread");
            WeakReference<ApiClient> weakReference = this.api;
            if (weakReference == null) {
                HMSLog.e(TAG, "api is null");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                return this.result;
            }
            ApiClient apiClient = weakReference.get();
            if (!checkApiClient(apiClient)) {
                HMSLog.e(TAG, "client invalid");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                return this.result;
            }
            if (this.isNeedReport) {
                biReportEvent(0, 1);
            }
            this.transport.send(apiClient, new a(this));
            try {
                this.countLatch.await();
            } catch (InterruptedException unused) {
                HMSLog.e(TAG, "await in anythread InterruptedException");
                setResult(CommonCode.ErrorCode.INTERNAL_ERROR, null);
            }
            return this.result;
        }
        return (R) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048579, this, j, timeUnit)) == null) {
            HMSLog.i(TAG, "awaitOnAnyThread timeout:" + j + " unit:" + timeUnit.toString());
            WeakReference<ApiClient> weakReference = this.api;
            if (weakReference == null) {
                HMSLog.e(TAG, "api is null");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                return this.result;
            }
            ApiClient apiClient = weakReference.get();
            if (!checkApiClient(apiClient)) {
                HMSLog.e(TAG, "client invalid");
                setResult(CommonCode.ErrorCode.CLIENT_API_INVALID, null);
                return this.result;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            if (this.isNeedReport) {
                biReportEvent(0, 1);
            }
            this.transport.post(apiClient, new b(this, atomicBoolean));
            try {
                if (!this.countLatch.await(j, timeUnit)) {
                    atomicBoolean.set(true);
                    setResult(CommonCode.ErrorCode.EXECUTE_TIMEOUT, null);
                }
            } catch (InterruptedException unused) {
                HMSLog.e(TAG, "awaitOnAnyThread InterruptedException");
                setResult(CommonCode.ErrorCode.INTERNAL_ERROR, null);
            }
            return this.result;
        }
        return (R) invokeJL.objValue;
    }

    public Class<T> getResponseType() {
        InterceptResult invokeV;
        Type type;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass != null && (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) != null) {
                return (Class) type;
            }
            return null;
        }
        return (Class) invokeV.objValue;
    }

    public R onError(int i) {
        InterceptResult invokeI;
        Type type;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            } else {
                type = null;
            }
            if (type != null) {
                cls = GenericTypeReflector.getType(type);
            } else {
                cls = null;
            }
            if (cls != null) {
                try {
                    R r = (R) cls.newInstance();
                    this.result = r;
                    r.setStatus(new Status(i));
                } catch (Exception e) {
                    HMSLog.e(TAG, "on Error:" + e.getMessage());
                    return null;
                }
            }
            return this.result;
        }
        return (R) invokeI.objValue;
    }
}
