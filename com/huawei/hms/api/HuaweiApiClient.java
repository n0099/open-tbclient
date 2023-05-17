package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public abstract class HuaweiApiClient implements AidlApiClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes9.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener);

    public abstract void connect(Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity activity);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long j, TimeUnit timeUnit);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);

    /* loaded from: classes9.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final List<Scope> b;
        public final List<PermissionInfo> c;
        public final Map<Api<?>, Api.ApiOptions> d;
        public OnConnectionFailedListener e;
        public ConnectionCallbacks f;
        public int g;
        public Activity h;

        public Builder applyDefaultAccount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (Builder) invokeV.objValue;
        }

        public Builder setAccountName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setHandler(Handler handler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, handler)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder setPopupsGravity(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? this : (Builder) invokeI.objValue;
        }

        public Builder setViewForPopups(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view2)) == null) ? this : (Builder) invokeL.objValue;
        }

        public Builder(Context context) throws NullPointerException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new HashMap();
            Checker.checkNonNull(context, "context must not be null.");
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            this.g = -1;
            ResourceLoaderUtil.setmContext(applicationContext);
            a(context);
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, api)) == null) {
                this.d.put(api, null);
                if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                    HiAnalyticsUtil hiAnalyticsUtil = HiAnalyticsUtil.getInstance();
                    Context applicationContext = this.a.getApplicationContext();
                    hiAnalyticsUtil.onEvent(applicationContext, HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, "|" + System.currentTimeMillis());
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        private void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, context) == null) {
                HMSBIInitializer.getInstance(context).initBI();
            }
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, connectionCallbacks)) == null) {
                Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
                this.f = connectionCallbacks;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, onConnectionFailedListener)) == null) {
                Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
                this.e = onConnectionFailedListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addScope(Scope scope) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, scope)) == null) {
                Checker.checkNonNull(scope, "scope must not be null.");
                this.b.add(scope);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        private void a(HuaweiApiClient huaweiApiClient) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, huaweiApiClient) == null) {
                AutoLifecycleFragment.getInstance(this.h).startAutoMange(this.g, huaweiApiClient);
            }
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, api, o)) == null) {
                Checker.checkNonNull(api, "Api must not be null");
                Checker.checkNonNull(o, "Null options are not permitted for this Api");
                this.d.put(api, o);
                if (api.getOptions() != null) {
                    this.b.addAll(api.getOptions().getScopeList(o));
                    this.c.addAll(api.getOptions().getPermissionInfoList(o));
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> api, O o, Scope... scopeArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, api, o, scopeArr)) == null) {
                Checker.checkNonNull(api, "Api must not be null");
                Checker.checkNonNull(o, "Null options are not permitted for this Api");
                Checker.checkNonNull(scopeArr, "Scopes must not be null");
                this.d.put(api, o);
                if (api.getOptions() != null) {
                    this.b.addAll(api.getOptions().getScopeList(o));
                    this.c.addAll(api.getOptions().getPermissionInfoList(o));
                }
                this.b.addAll(new ArrayList(Arrays.asList(scopeArr)));
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, api, scopeArr)) == null) {
                Checker.checkNonNull(api, "Api must not be null");
                Checker.checkNonNull(scopeArr, "Scopes must not be null");
                this.d.put(api, null);
                this.b.addAll(new ArrayList(Arrays.asList(scopeArr)));
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder allowLifeCycleManagement(Activity activity, OnConnectionFailedListener onConnectionFailedListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, onConnectionFailedListener)) == null) {
                return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder allowLifeCycleManagement(Activity activity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, activity, i, onConnectionFailedListener)) == null) {
                if (i >= 0) {
                    this.g = i;
                    this.h = (Activity) Preconditions.checkNotNull(activity, "activity must not be Null.");
                    return this;
                }
                throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
            }
            return (Builder) invokeLIL.objValue;
        }

        public HuaweiApiClient build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                addApi(new Api<>("Core.API"));
                HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.a);
                huaweiApiClientImpl.setScopes(this.b);
                huaweiApiClientImpl.setPermissionInfos(this.c);
                huaweiApiClientImpl.setApiMap(this.d);
                huaweiApiClientImpl.setConnectionCallbacks(this.f);
                huaweiApiClientImpl.setConnectionFailedListener(this.e);
                huaweiApiClientImpl.setAutoLifecycleClientId(this.g);
                if (this.g >= 0) {
                    a(huaweiApiClientImpl);
                }
                return huaweiApiClientImpl;
            }
            return (HuaweiApiClient) invokeV.objValue;
        }
    }

    public HuaweiApiClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void connect(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            throw new UnsupportedOperationException();
        }
    }
}
