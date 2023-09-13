package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractPromptDialog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
/* loaded from: classes10.dex */
public class BindingFailedResolution implements IBridgeActivityDelegate, ServiceConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object LOCK_CONNECT_TIMEOUT_HANDLER;
    public static final int MSG_CONN_TIMEOUT = 2;
    public static final int MSG_SELF_DESTROY_TIMEOUT = 3;
    public static final int REQUEST_CODE = 2003;
    public static final String TAG = "BindingFailedResolution";
    public transient /* synthetic */ FieldHolder $fh;
    public FailedBinderCallBack.BinderCallBack callBack;
    public Activity curActivity;
    public boolean isStarting;
    public Handler mConnectTimeoutHandler;
    public d promptdlg;
    public Handler selfDestroyHandler;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2003;
        }
        return invokeV.intValue;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentName) == null) {
        }
    }

    /* loaded from: classes10.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BindingFailedResolution a;

        public a(BindingFailedResolution bindingFailedResolution) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bindingFailedResolution};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bindingFailedResolution;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message == null || message.what != 3) {
                    return false;
                }
                this.a.finishBridgeActivity(8);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BindingFailedResolution a;

        public b(BindingFailedResolution bindingFailedResolution) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bindingFailedResolution};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bindingFailedResolution;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message == null || message.what != 2) {
                    return false;
                }
                HMSLog.e(BindingFailedResolution.TAG, "In connect, bind core try timeout");
                this.a.fireStartResult(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c implements AbstractDialog.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BindingFailedResolution a;

        public c(BindingFailedResolution bindingFailedResolution) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bindingFailedResolution};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bindingFailedResolution;
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onCancel(AbstractDialog abstractDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, abstractDialog) != null) {
                return;
            }
            this.a.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            this.a.finishBridgeActivity(8);
        }

        @Override // com.huawei.hms.ui.AbstractDialog.Callback
        public void onDoWork(AbstractDialog abstractDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, abstractDialog) != null) {
                return;
            }
            this.a.promptdlg = null;
            BindResolveClients.getInstance().unRegisterAll();
            this.a.finishBridgeActivity(8);
        }
    }

    /* loaded from: classes10.dex */
    public static class d extends AbstractPromptDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        public /* synthetic */ d(a aVar) {
            this();
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetPositiveButtonString(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                return ResourceLoaderUtil.getString("hms_confirm");
            }
            return (String) invokeL.objValue;
        }

        @Override // com.huawei.hms.ui.AbstractDialog
        public String onGetMessageString(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return ResourceLoaderUtil.getString("hms_bindfaildlg_message", Util.getAppName(context, null), Util.getAppName(context, HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()));
            }
            return (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1517695439, "Lcom/huawei/hms/api/BindingFailedResolution;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1517695439, "Lcom/huawei/hms/api/BindingFailedResolution;");
                return;
            }
        }
        LOCK_CONNECT_TIMEOUT_HANDLER = new Object();
    }

    public BindingFailedResolution() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isStarting = true;
        this.mConnectTimeoutHandler = null;
        this.selfDestroyHandler = null;
    }

    private void cancelConnDelayHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (this.mConnectTimeoutHandler != null) {
                    this.mConnectTimeoutHandler.removeMessages(2);
                    this.mConnectTimeoutHandler = null;
                }
            }
        }
    }

    private void postConnDelayHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
            } else {
                this.mConnectTimeoutHandler = new Handler(Looper.getMainLooper(), new b(this));
            }
            this.mConnectTimeoutHandler.sendEmptyMessageDelayed(2, 5000L);
        }
    }

    private void selfDestroyHandle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.selfDestroyHandler = new Handler(Looper.getMainLooper(), new a(this));
            }
            this.selfDestroyHandler.sendEmptyMessageDelayed(3, 4000L);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.curActivity;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cancelConnDelayHandle();
            com.huawei.hms.api.a.b.b(this.curActivity);
            this.curActivity = null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.promptdlg == null) {
            return;
        }
        HMSLog.i(TAG, "re show prompt dialog");
        showPromptdlg();
    }

    private void noticeBindResult(boolean z, int i) {
        FailedBinderCallBack.BinderCallBack binderCallBack;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z && (binderCallBack = this.callBack) != null) {
            binderCallBack.binderCallBack(i);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, keyEvent) == null) {
            HMSLog.i(TAG, "On key up when resolve conn error");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, componentName, iBinder) == null) {
            cancelConnDelayHandle();
            fireStartResult(true);
            if (getActivity() == null) {
                return;
            }
            HMSLog.i(TAG, "test connect success, try to reConnect and reply message");
            BindResolveClients.getInstance().notifyClientReconnect();
        }
    }

    private void bindCoreService(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            Activity activity = getActivity();
            if (activity == null) {
                HMSLog.e(TAG, "In connect, bind core try fail");
                fireStartResult(false);
                noticeBindResult(z, 8);
                return;
            }
            Intent intent = new Intent(HMSPackageManager.getInstance(activity.getApplicationContext()).getServiceAction());
            intent.setPackage(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService());
            synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
                if (activity.bindService(intent, this, 1)) {
                    postConnDelayHandle();
                    return;
                }
                HMSLog.e(TAG, "In connect, bind core try fail");
                fireStartResult(false);
                noticeBindResult(z, 8);
            }
        }
    }

    private void tryStartHmsActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, activity) == null) {
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
            intent.setClassName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService(), HuaweiApiAvailability.ACTIVITY_NAME);
            HMSLog.i(TAG, "onBridgeActivityCreate：try to start HMS");
            try {
                activity.startActivityForResult(intent, getRequestCode());
            } catch (Throwable th) {
                HMSLog.e(TAG, "ActivityNotFoundException：" + th.getMessage());
                Handler handler = this.selfDestroyHandler;
                if (handler != null) {
                    handler.removeMessages(3);
                    this.selfDestroyHandler = null;
                }
                bindCoreService(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishBridgeActivity(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65543, this, i) == null) && (activity = getActivity()) != null && !activity.isFinishing()) {
            HMSLog.i(TAG, "finishBridgeActivity：" + i);
            Intent intent = new Intent();
            intent.putExtra(BridgeActivity.EXTRA_RESULT, i);
            activity.setResult(-1, intent);
            Util.unBindServiceCatchException(activity, this);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireStartResult(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && this.isStarting) {
            this.isStarting = false;
            onStartResult(z);
        }
    }

    public void onStartResult(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || getActivity() == null) {
            return;
        }
        if (z) {
            finishBridgeActivity(0);
        } else {
            showPromptdlg();
        }
    }

    private void showPromptdlg() {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && (activity = getActivity()) != null && !activity.isFinishing()) {
            d dVar = this.promptdlg;
            if (dVar == null) {
                this.promptdlg = new d(null);
            } else {
                dVar.dismiss();
            }
            HMSLog.i(TAG, "showPromptdlg to resolve conn error");
            this.promptdlg.show(activity, new c(this));
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            Intent intent = activity.getIntent();
            if (intent != null && intent.hasExtra(FailedBinderCallBack.CALLER_ID)) {
                this.callBack = FailedBinderCallBack.getInstance().getCallBack(Long.valueOf(intent.getLongExtra(FailedBinderCallBack.CALLER_ID, 0L)));
            }
            this.curActivity = activity;
            com.huawei.hms.api.a.b.a(activity);
            selfDestroyHandle();
            tryStartHmsActivity(activity);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, intent)) == null) {
            if (i != getRequestCode()) {
                return false;
            }
            HMSLog.i(TAG, "onBridgeActivityResult");
            Handler handler = this.selfDestroyHandler;
            if (handler != null) {
                handler.removeMessages(3);
                this.selfDestroyHandler = null;
            }
            bindCoreService(true);
            return true;
        }
        return invokeIIL.booleanValue;
    }
}
