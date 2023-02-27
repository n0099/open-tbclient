package com.sdk.mobile.manager.login.cucc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.base.api.OnCustomViewListener;
import com.sdk.base.api.UiOauthListener;
import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.j.a;
import com.sdk.p.f;
import com.sdk.y.f;
/* loaded from: classes8.dex */
public class UiOauthManager extends SDKManager {
    public static /* synthetic */ Interceptable $ic;
    public static Boolean isDebug;
    public static volatile UiOauthManager manager;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public boolean cancel;
    public Context mContext;
    public f mHandler;
    public UiOauthListener oauthListener;
    public OnCustomViewListener otherLoginListener;
    public OauthResultMode resultMode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1059093382, "Lcom/sdk/mobile/manager/login/cucc/UiOauthManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1059093382, "Lcom/sdk/mobile/manager/login/cucc/UiOauthManager;");
                return;
            }
        }
        isDebug = Boolean.valueOf(com.sdk.f.f.a);
    }

    public UiOauthManager(Context context) {
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
        this.TAG = UiOauthManager.class.getSimpleName();
        this.mContext = context;
    }

    private <T> void dispatchHandler(int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, callBack) == null) {
            Log.e("ZJW_LOG", "dispatchHandler");
            new f(this.mContext, i, new CallBack<T>(this, callBack) { // from class: com.sdk.mobile.manager.login.cucc.UiOauthManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UiOauthManager this$0;
                public final /* synthetic */ CallBack val$callBack;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callBack};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = callBack;
                }

                @Override // com.sdk.base.api.CallBack
                public void onFailed(int i2, int i3, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
                        Log.e("ZJW_LOG", "onFailed code--->" + i2);
                        Log.e("ZJW_LOG", "onFailed status--->" + i3);
                        this.val$callBack.onFailed(i2, i3, str, str2);
                    }
                }

                @Override // com.sdk.base.api.CallBack
                public void onSuccess(int i2, String str, int i3, T t, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), t, str2}) == null) {
                        Log.e("ZJW_LOG", "onSuccess code--->" + i2);
                        Log.e("ZJW_LOG", "onSuccess msg--->" + str);
                        Log.e("ZJW_LOG", "onSuccess status--->" + i3);
                        Log.e("ZJW_LOG", "onSuccess response--->" + t);
                        if (i2 == 0) {
                            this.val$callBack.onSuccess(i2, str, i3, t, str2);
                        }
                        if (i2 == 1) {
                            this.val$callBack.onSuccess(i2, str, i3, null, str2);
                        }
                    }
                }
            }).a(0);
        }
    }

    public static UiOauthManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (manager == null) {
                synchronized (UiOauthManager.class) {
                    if (manager == null) {
                        manager = new UiOauthManager(context);
                    }
                }
            }
            return manager;
        }
        return (UiOauthManager) invokeL.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cancel = true;
        }
    }

    public OnCustomViewListener getOtherLoginListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.otherLoginListener : (OnCustomViewListener) invokeV.objValue;
    }

    public <T> void login(int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, callBack) == null) {
            int a = a.a();
            int a2 = com.sdk.p.f.a(this.mContext, null).a();
            if (a < 23 && a2 != f.a.b.a()) {
                callBack.onFailed(102001, 1, "选择流量通道失败", "qcandroidabc000");
                return;
            }
            com.sdk.y.f fVar = new com.sdk.y.f(this.mContext, i, callBack);
            this.mHandler = fVar;
            fVar.a(0);
        }
    }

    public void setOtherLoginListener(OnCustomViewListener onCustomViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onCustomViewListener) == null) {
            this.otherLoginListener = onCustomViewListener;
        }
    }

    public void unregisterNetworkCallback() {
        com.sdk.y.f fVar;
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (fVar = this.mHandler) != null && (connectivityManager = fVar.j) != null && (networkCallback = com.sdk.y.f.c) != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
            com.sdk.y.f.c = null;
        }
    }
}
