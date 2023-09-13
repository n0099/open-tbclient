package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
/* loaded from: classes10.dex */
public class BinderAdapter implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BINDER_SYSTEM_ERROR = -1;
    public static final int DELAY_MILLIS = 1800000;
    public static final String TAG = "BinderAdapter";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object LOCK_CONNECT_TIMEOUT_HANDLER;
    public boolean bindFail;
    public BinderCallBack callback;
    public Handler delayDisconnectHandler;
    public final String mAction;
    public Handler mBinderTimeoutHandler;
    public Context mContext;
    public final String mService;
    public IBinder serviceBinder;

    /* loaded from: classes10.dex */
    public interface BinderCallBack {
        void onBinderFailed(int i);

        void onBinderFailed(int i, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public int getConnTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getMsgDelayDisconnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public BinderAdapter(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
        this.bindFail = false;
        this.mBinderTimeoutHandler = null;
        this.delayDisconnectHandler = null;
        this.mContext = context;
        this.mAction = str;
        this.mService = str2;
    }

    public void binder(BinderCallBack binderCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, binderCallBack) != null) || binderCallBack == null) {
            return;
        }
        this.callback = binderCallBack;
        bindCoreService();
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, componentName) == null) {
            HMSLog.e(TAG, "Enter onNullBinding, than unBind.");
            if (this.bindFail) {
                this.bindFail = false;
                return;
            }
            unBind();
            cancelConnDelayHandle();
            BinderCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onNullBinding(componentName);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, componentName) == null) {
            HMSLog.i(TAG, "Enter onServiceDisconnected.");
            BinderCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onServiceDisconnected(componentName);
            }
            removeDelayDisconnectTask();
        }
    }

    private void bindCoreService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (TextUtils.isEmpty(this.mAction) || TextUtils.isEmpty(this.mService)) {
                getBindFailPendingIntent();
            }
            Intent intent = new Intent(this.mAction);
            intent.setPackage(this.mService);
            synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (this.mContext.bindService(intent, this, 1)) {
                    postConnDelayHandle();
                    return;
                }
                this.bindFail = true;
                getBindFailPendingIntent();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void binderServiceFailed() {
        BinderCallBack callBack;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (callBack = getCallBack()) != null) {
            callBack.onBinderFailed(-1);
        }
    }

    private void cancelConnDelayHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            synchronized (this.LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (this.mBinderTimeoutHandler != null) {
                    this.mBinderTimeoutHandler.removeMessages(getConnTimeOut());
                    this.mBinderTimeoutHandler = null;
                }
            }
        }
    }

    private void delayedUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.huawei.hms.adapter.BinderAdapter.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BinderAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                        if (message != null && message.what == this.this$0.getMsgDelayDisconnect()) {
                            HMSLog.i(BinderAdapter.TAG, "The serviceConnection has been bind for 60s, need to unbind.");
                            this.this$0.unBind();
                            BinderCallBack callBack = this.this$0.getCallBack();
                            if (callBack != null) {
                                callBack.onTimedDisconnected();
                                return true;
                            }
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.delayDisconnectHandler = handler;
            handler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack getCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return this.callback;
        }
        return (BinderCallBack) invokeV.objValue;
    }

    private void removeDelayDisconnectTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            HMSLog.d(TAG, "removeDelayDisconnectTask.");
            synchronized (BinderAdapter.class) {
                if (this.delayDisconnectHandler != null) {
                    this.delayDisconnectHandler.removeMessages(getMsgDelayDisconnect());
                }
            }
        }
    }

    public IBinder getServiceBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.serviceBinder;
        }
        return (IBinder) invokeV.objValue;
    }

    public void unBind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Util.unBindServiceCatchException(this.mContext, this);
        }
    }

    private void getBindFailPendingIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            HMSLog.e(TAG, "In connect, bind core service fail");
            ComponentName componentName = new ComponentName(this.mContext.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
            BinderCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onBinderFailed(-1, intent);
            }
        }
    }

    private void postConnDelayHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            Handler handler = this.mBinderTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(getConnTimeOut());
            } else {
                this.mBinderTimeoutHandler = new Handler(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.huawei.hms.adapter.BinderAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BinderAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                            if (message != null && message.what == this.this$0.getConnTimeOut()) {
                                HMSLog.e(BinderAdapter.TAG, "In connect, bind core service time out");
                                this.this$0.binderServiceFailed();
                                return true;
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                });
            }
            this.mBinderTimeoutHandler.sendEmptyMessageDelayed(getConnTimeOut(), 10000L);
        }
    }

    public void updateDelayTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HMSLog.d(TAG, "updateDelayTask.");
            synchronized (BinderAdapter.class) {
                if (this.delayDisconnectHandler != null) {
                    this.delayDisconnectHandler.removeMessages(getMsgDelayDisconnect());
                    this.delayDisconnectHandler.sendEmptyMessageDelayed(getMsgDelayDisconnect(), 1800000L);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, componentName, iBinder) == null) {
            HMSLog.i(TAG, "BinderAdapter Enter onServiceConnected.");
            this.serviceBinder = iBinder;
            cancelConnDelayHandle();
            BinderCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onServiceConnected(componentName, iBinder);
            }
            delayedUnbind();
        }
    }
}
