package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object A;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    public static final Object z;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Context b;
    public final String c;
    public String d;
    public String e;
    public volatile IAIDLInvoke f;
    public String g;
    public WeakReference<Activity> h;
    public WeakReference<Activity> i;
    public boolean j;
    public AtomicInteger k;
    public List<Scope> l;
    public List<PermissionInfo> m;
    public Map<Api<?>, Api.ApiOptions> n;
    public SubAppInfo o;
    public long p;
    public int q;
    public final Object r;
    public final ReentrantLock s;
    public final Condition t;
    public ConnectionResult u;
    public HuaweiApiClient.ConnectionCallbacks v;
    public HuaweiApiClient.OnConnectionFailedListener w;
    public Handler x;
    public Handler y;

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048610, this, str, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class e implements ResultCallback<ResolveResult<ConnectResp>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HuaweiApiClientImpl a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResolveResult a;
            public final /* synthetic */ e b;

            public a(e eVar, ResolveResult resolveResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, resolveResult};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.b.a.a(this.a);
            }
        }

        public e(HuaweiApiClientImpl huaweiApiClientImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClientImpl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, resolveResult) == null) {
                new Handler(Looper.getMainLooper()).post(new a(this, resolveResult));
            }
        }

        public /* synthetic */ e(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this(huaweiApiClientImpl);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ResultCallback<ResolveResult<DisconnectResp>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HuaweiApiClientImpl a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResolveResult a;
            public final /* synthetic */ f b;

            public a(f fVar, ResolveResult resolveResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, resolveResult};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.b.a.b(this.a);
            }
        }

        public f(HuaweiApiClientImpl huaweiApiClientImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClientImpl;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, resolveResult) == null) {
                new Handler(Looper.getMainLooper()).post(new a(this, resolveResult));
            }
        }

        public /* synthetic */ f(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this(huaweiApiClientImpl);
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HuaweiApiClientImpl a;

        public a(HuaweiApiClientImpl huaweiApiClientImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClientImpl;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message != null && message.what == 2) {
                    HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service time out");
                    if (this.a.k.get() == 5) {
                        this.a.c(1);
                        this.a.b();
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HuaweiApiClientImpl a;

        public b(HuaweiApiClientImpl huaweiApiClientImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClientImpl;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message != null && message.what == 3) {
                    HMSLog.e("HuaweiApiClientImpl", "In connect, process time out");
                    if (this.a.k.get() == 2) {
                        this.a.c(1);
                        this.a.b();
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends IAIDLCallback.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ResultCallback a;

        public c(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl, resultCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataBuffer) == null) {
                if (dataBuffer != null) {
                    MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                    ResponseHeader responseHeader = new ResponseHeader();
                    find.decode(dataBuffer.header, responseHeader);
                    BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                    HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                    this.a.onResult(bundleResult);
                    return;
                }
                HMSLog.i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
                this.a.onResult(new BundleResult(-1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends PendingResultImpl<Status, IMessageEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apiClient, str, iMessageEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ApiClient) objArr2[0], (String) objArr2[1], (IMessageEntity) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.PendingResultImpl
        public Status onComplete(IMessageEntity iMessageEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMessageEntity)) == null) {
                return new Status(0);
            }
            return (Status) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HuaweiApiClientImpl a;

        public g(HuaweiApiClientImpl huaweiApiClientImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {huaweiApiClientImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = huaweiApiClientImpl;
        }

        public /* synthetic */ g(HuaweiApiClientImpl huaweiApiClientImpl, a aVar) {
            this(huaweiApiClientImpl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, resolveResult) == null) && resolveResult != null && resolveResult.getStatus().isSuccess() && (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) != null && value.getStatusCode() == 0) {
                HMSLog.i("HuaweiApiClientImpl", "get notice has intent.");
                Activity validActivity = Util.getValidActivity((Activity) this.a.h.get(), this.a.getTopActivity());
                if (validActivity == null) {
                    HMSLog.e("HuaweiApiClientImpl", "showNotice no valid activity!");
                    return;
                }
                this.a.j = true;
                validActivity.startActivity(noticeIntent);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1105184769, "Lcom/huawei/hms/api/HuaweiApiClientImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1105184769, "Lcom/huawei/hms/api/HuaweiApiClientImpl;");
                return;
            }
        }
        z = new Object();
        A = new Object();
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            Handler handler = this.x;
            if (handler != null) {
                handler.removeMessages(2);
            } else {
                this.x = new Handler(Looper.getMainLooper(), new a(this));
            }
            this.x.sendEmptyMessageDelayed(2, 5000L);
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
            ConnectService.connect(this, c()).setResultCallback(new e(this, null));
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            ConnectService.disconnect(this, d()).setResultCallback(new f(this, null));
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
            ConnectService.forceConnect(this, c()).setResultCallback(new e(this, null));
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            Util.unBindServiceCatchException(this.b, this);
            this.f = null;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new d(this, null, null);
        }
        return (PendingResult) invokeV.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return (IAIDLInvoke) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (SubAppInfo) invokeV.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            WeakReference<Activity> weakReference = this.i;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return IPCTransport.class.getName();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.k.get() != 3 && this.k.get() != 4) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int i = this.k.get();
            if (i != 2 && i != 5) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            disconnect();
            connect((Activity) null);
        }
    }

    public HuaweiApiClientImpl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.j = false;
        this.k = new AtomicInteger(1);
        this.p = 0L;
        this.q = 0;
        this.r = new Object();
        ReentrantLock reentrantLock = new ReentrantLock();
        this.s = reentrantLock;
        this.t = reentrantLock.newCondition();
        this.x = null;
        this.y = null;
        this.b = context;
        String appId = Util.getAppId(context);
        this.c = appId;
        this.d = appId;
        this.e = Util.getCpId(context);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            connect((Activity) null);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            if (this.a >= 0) {
                AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.a);
                return;
            }
            throw new IllegalStateException("disableLifeCycleManagement failed");
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, api)) == null) {
            if (isConnected()) {
                this.u = null;
                return new ConnectionResult(0, (PendingIntent) null);
            }
            ConnectionResult connectionResult = this.u;
            if (connectionResult != null) {
                return connectionResult;
            }
            return new ConnectionResult(13, (PendingIntent) null);
        }
        return (ConnectionResult) invokeL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, api)) == null) {
            return isConnected();
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, onConnectionFailedListener)) == null) {
            Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
            synchronized (this.r) {
                if (this.w == onConnectionFailedListener) {
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, connectionCallbacks)) == null) {
            Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
            synchronized (this.r) {
                if (this.v == connectionCallbacks) {
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, activity) == null) {
            HMSLog.i("HuaweiApiClientImpl", MissionEvent.MESSAGE_PAUSE);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, activity) == null) && activity != null) {
            HMSLog.i("HuaweiApiClientImpl", "onResume");
            this.i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, componentName) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
            this.f = null;
            c(1);
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(1);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onConnectionFailedListener) == null) {
            Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
            synchronized (this.r) {
                if (this.w != onConnectionFailedListener) {
                    HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
                } else {
                    this.w = null;
                }
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, connectionCallbacks) == null) {
            Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
            synchronized (this.r) {
                if (this.v != connectionCallbacks) {
                    HMSLog.w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
                } else {
                    this.v = null;
                }
            }
        }
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, map) == null) {
            this.n = map;
        }
    }

    public void setAutoLifecycleClientId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, connectionCallbacks) == null) {
            this.v = connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onConnectionFailedListener) == null) {
            this.w = onConnectionFailedListener;
        }
    }

    public void setHasShowNotice(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) {
            this.j = z2;
        }
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, list) == null) {
            this.m = list;
        }
    }

    public void setScopes(List<Scope> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            this.l = list;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Intent intent = new Intent(HMSPackageManager.getInstance(this.b).getServiceAction());
            HMSPackageManager.getInstance(this.b).refreshForMultiService();
            intent.setPackage(HMSPackageManager.getInstance(this.b).getHMSPackageNameForMultiService());
            synchronized (z) {
                if (this.b.bindService(intent, this, 1)) {
                    h();
                    return;
                }
                c(1);
                HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            n();
            if (this.w != null) {
                if (UIUtil.isBackground(this.b)) {
                    i = 7;
                } else {
                    i = 6;
                }
                PendingIntent pendingIntent = null;
                WeakReference<Activity> weakReference = this.h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i);
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                this.w.onConnectionFailed(connectionResult);
                this.u = connectionResult;
            }
        }
    }

    private int f() {
        InterceptResult invokeV;
        Integer num;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
            int i = 0;
            if (apiMap == null) {
                return 0;
            }
            for (Api<?> api : apiMap.keySet()) {
                String apiName = api.getApiName();
                if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i) {
                    i = intValue;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            synchronized (A) {
                if (this.y != null) {
                    this.y.removeMessages(3);
                } else {
                    this.y = new Handler(Looper.getMainLooper(), new b(this));
                }
                boolean sendEmptyMessageDelayed = this.y.sendEmptyMessageDelayed(3, 3000L);
                HMSLog.d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + sendEmptyMessageDelayed);
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
            int i = this.k.get();
            HMSLog.i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i);
            if (i != 3 && i != 5 && i != 2 && i != 4) {
                if (TextUtils.isEmpty(this.c)) {
                    str = Util.getAppId(this.b);
                } else {
                    str = this.c;
                }
                this.d = str;
                l();
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.k.get();
            HMSLog.i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i);
            if (i != 2) {
                if (i != 3) {
                    if (i == 5) {
                        a(2);
                        c(4);
                        return;
                    }
                    return;
                }
                c(4);
                k();
                return;
            }
            c(4);
        }
    }

    private void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            if (i == 2) {
                synchronized (z) {
                    if (this.x != null) {
                        this.x.removeMessages(i);
                        this.x = null;
                    }
                }
            }
            if (i == 3) {
                synchronized (A) {
                    if (this.y != null) {
                        this.y.removeMessages(i);
                        this.y = null;
                    }
                }
            }
            synchronized (z) {
                if (this.x != null) {
                    this.x.removeMessages(2);
                    this.x = null;
                }
            }
        }
    }

    private void b(int i) {
        PendingIntent pendingIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65546, this, i) == null) {
            WeakReference<Activity> weakReference = this.h;
            if (weakReference != null && weakReference.get() != null) {
                pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), i);
                HMSLog.i("HuaweiApiClientImpl", "connect 2.0 fail: " + i);
            } else {
                pendingIntent = null;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            this.w.onConnectionFailed(connectionResult);
            this.u = connectionResult;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, subAppInfo)) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter setSubAppInfo");
            if (subAppInfo == null) {
                HMSLog.e("HuaweiApiClientImpl", "subAppInfo is null");
                return false;
            }
            String subAppID = subAppInfo.getSubAppID();
            if (TextUtils.isEmpty(subAppID)) {
                HMSLog.e("HuaweiApiClientImpl", "subAppId is empty");
                return false;
            }
            if (TextUtils.isEmpty(this.c)) {
                str = Util.getAppId(this.b);
            } else {
                str = this.c;
            }
            if (subAppID.equals(str)) {
                HMSLog.e("HuaweiApiClientImpl", "subAppId is host appid");
                return false;
            }
            this.o = new SubAppInfo(subAppInfo);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, checkUpdatelistener) == null) {
            if (checkUpdatelistener == null) {
                HMSLog.e("HuaweiApiClientImpl", "listener is null!");
            } else {
                checkUpdatelistener.onResult(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResolveResult<ConnectResp> resolveResult) {
        String subAppID;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, resolveResult) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult");
            if (this.f != null && this.k.get() == 2) {
                a(3);
                ConnectResp value = resolveResult.getValue();
                if (value != null) {
                    this.g = value.sessionId;
                }
                SubAppInfo subAppInfo = this.o;
                PendingIntent pendingIntent = null;
                if (subAppInfo == null) {
                    subAppID = null;
                } else {
                    subAppID = subAppInfo.getSubAppID();
                }
                if (!TextUtils.isEmpty(subAppID)) {
                    this.d = subAppID;
                }
                int statusCode = resolveResult.getStatus().getStatusCode();
                HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
                if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                    c(resolveResult);
                    return;
                } else if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                    n();
                    c(1);
                    HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
                    if (connectionCallbacks != null) {
                        connectionCallbacks.onConnectionSuspended(3);
                        return;
                    }
                    return;
                } else {
                    n();
                    c(1);
                    if (this.w != null) {
                        WeakReference<Activity> weakReference = this.h;
                        if (weakReference != null && weakReference.get() != null) {
                            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), statusCode);
                        }
                        ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                        this.w.onConnectionFailed(connectionResult);
                        this.u = connectionResult;
                        return;
                    }
                    return;
                }
            }
            HMSLog.e("HuaweiApiClientImpl", "Invalid onConnectionResult");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResolveResult<DisconnectResp> resolveResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, resolveResult) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
            n();
            c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            this.k.set(i);
            if (i == 1 || i == 3 || i == 2) {
                this.s.lock();
                try {
                    this.t.signalAll();
                } finally {
                    this.s.unlock();
                }
            }
        }
    }

    private ConnectInfo c() {
        InterceptResult invokeV;
        String subAppID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            String packageSignature = new PackageManagerHelper(this.b).getPackageSignature(this.b.getPackageName());
            if (packageSignature == null) {
                packageSignature = "";
            }
            SubAppInfo subAppInfo = this.o;
            if (subAppInfo == null) {
                subAppID = null;
            } else {
                subAppID = subAppInfo.getSubAppID();
            }
            return new ConnectInfo(getApiNameList(), this.l, packageSignature, subAppID);
        }
        return (ConnectInfo) invokeV.objValue;
    }

    private DisconnectInfo d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<Api<?>, Api.ApiOptions> map = this.n;
            if (map != null) {
                for (Api<?> api : map.keySet()) {
                    arrayList.add(api.getApiName());
                }
            }
            return new DisconnectInfo(this.l, arrayList);
        }
        return (DisconnectInfo) invokeV.objValue;
    }

    private int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int hmsVersion = Util.getHmsVersion(this.b);
            if (hmsVersion != 0 && hmsVersion >= 20503000) {
                return hmsVersion;
            }
            int f2 = f();
            if (g()) {
                if (f2 < 20503000) {
                    return 20503000;
                }
                return f2;
            } else if (f2 < 20600000) {
                return 20600000;
            } else {
                return f2;
            }
        }
        return invokeV.intValue;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            Map<Api<?>, Api.ApiOptions> map = this.n;
            if (map != null) {
                for (Api<?> api : map.keySet()) {
                    if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            if (this.j) {
                HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
            } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.b) == 0) {
                ConnectService.getNotice(this, 0, "6.5.0.300").setResultCallback(new g(this, null));
            }
        }
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<Api<?>, Api.ApiOptions> map = this.n;
            if (map != null) {
                for (Api<?> api : map.keySet()) {
                    arrayList.add(api.getApiName());
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private void c(ResolveResult<ConnectResp> resolveResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, resolveResult) == null) {
            if (resolveResult.getValue() != null) {
                ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
            }
            c(3);
            this.u = null;
            HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.v;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (this.h != null) {
                m();
            }
            for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
                if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                    HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                    for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                        HMSLog.i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                        connectionPostProcessor.run(this, this.h);
                    }
                }
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            HMSLog.i("HuaweiApiClientImpl", "====== HMSSDK version: 60500300 ======");
            int i = this.k.get();
            HMSLog.i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i);
            if (i != 3 && i != 5 && i != 2 && i != 4) {
                if (activity != null) {
                    this.h = new WeakReference<>(activity);
                    this.i = new WeakReference<>(activity);
                }
                if (TextUtils.isEmpty(this.c)) {
                    str = Util.getAppId(this.b);
                } else {
                    str = this.c;
                }
                this.d = str;
                int e2 = e();
                HMSLog.i("HuaweiApiClientImpl", "connect minVersion:" + e2);
                HuaweiApiAvailability.setServicesVersionCode(e2);
                int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, e2);
                HMSLog.i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
                this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
                if (isHuaweiMobileServicesAvailable == 0) {
                    c(5);
                    if (this.f == null) {
                        a();
                        return;
                    }
                    c(2);
                    j();
                    i();
                } else if (this.w != null) {
                    b(isHuaweiMobileServicesAvailable);
                }
            }
        }
    }

    public int asyncRequest(Bundle bundle, String str, int i, ResultCallback<BundleResult> resultCallback) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048576, this, bundle, str, i, resultCallback)) == null) {
            HMSLog.i("HuaweiApiClientImpl", "Enter asyncRequest.");
            if (resultCallback != null && str != null && bundle != null) {
                if (!innerIsConnected()) {
                    HMSLog.e("HuaweiApiClientImpl", "client is unConnect.");
                    return CommonCode.ErrorCode.CLIENT_API_INVALID;
                }
                DataBuffer dataBuffer = new DataBuffer(str, i);
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                dataBuffer.addBody(bundle);
                RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 60500300, getSessionId());
                requestHeader.setApiNameList(getApiNameList());
                dataBuffer.header = find.encode(requestHeader, new Bundle());
                try {
                    getService().asyncCall(dataBuffer, new c(this, resultCallback));
                    return 0;
                } catch (RemoteException e2) {
                    HMSLog.e("HuaweiApiClientImpl", "remote exception:" + e2.getMessage());
                    return CommonCode.ErrorCode.INTERNAL_ERROR;
                }
            }
            HMSLog.e("HuaweiApiClientImpl", "arguments is invalid.");
            return CommonCode.ErrorCode.ARGUMENTS_INVALID;
        }
        return invokeLLIL.intValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.s.lock();
                try {
                    connect((Activity) null);
                    while (isConnecting()) {
                        this.t.await();
                    }
                    if (isConnected()) {
                        this.u = null;
                        return new ConnectionResult(0, (PendingIntent) null);
                    } else if (this.u != null) {
                        return this.u;
                    } else {
                        return new ConnectionResult(13, (PendingIntent) null);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                } finally {
                    this.s.unlock();
                }
            }
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        return (ConnectionResult) invokeV.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j, TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048602, this, j, timeUnit)) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.s.lock();
                try {
                    connect((Activity) null);
                    long nanos = timeUnit.toNanos(j);
                    while (isConnecting()) {
                        if (nanos <= 0) {
                            disconnect();
                            return new ConnectionResult(14, (PendingIntent) null);
                        }
                        nanos = this.t.awaitNanos(nanos);
                    }
                    if (isConnected()) {
                        this.u = null;
                        return new ConnectionResult(0, (PendingIntent) null);
                    } else if (this.u != null) {
                        return this.u;
                    } else {
                        return new ConnectionResult(13, (PendingIntent) null);
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                } finally {
                    this.s.unlock();
                }
            }
            throw new IllegalStateException("blockingConnect must not be called on the UI thread");
        }
        return (ConnectionResult) invokeJL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.q == 0) {
                this.q = HMSPackageManager.getInstance(this.b).getHmsMultiServiceVersion();
            }
            if (this.q < 20504000) {
                long currentTimeMillis = System.currentTimeMillis() - this.p;
                if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
                    return innerIsConnected();
                }
                if (innerIsConnected()) {
                    Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
                    if (status.isSuccess()) {
                        this.p = System.currentTimeMillis();
                        return true;
                    }
                    int statusCode = status.getStatusCode();
                    HMSLog.i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
                    if (statusCode != 907135004) {
                        n();
                        c(1);
                        this.p = System.currentTimeMillis();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return innerIsConnected();
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, componentName, iBinder) == null) {
            HMSLog.i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
            a(2);
            this.f = IAIDLInvoke.Stub.asInterface(iBinder);
            if (this.f == null) {
                HMSLog.e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
                n();
                c(1);
                if (this.w != null) {
                    PendingIntent pendingIntent = null;
                    WeakReference<Activity> weakReference = this.h;
                    if (weakReference != null && weakReference.get() != null) {
                        pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.h.get(), 10);
                    }
                    ConnectionResult connectionResult = new ConnectionResult(10, pendingIntent);
                    this.w.onConnectionFailed(connectionResult);
                    this.u = connectionResult;
                }
            } else if (this.k.get() == 5) {
                c(2);
                j();
                i();
            } else if (this.k.get() != 3) {
                n();
            }
        }
    }
}
