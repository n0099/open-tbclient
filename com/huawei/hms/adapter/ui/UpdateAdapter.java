package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class UpdateAdapter implements IBridgeActivityDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;
    public int b;
    public boolean c;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public UpdateAdapter() {
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
        this.c = false;
    }

    public final void a() {
        Activity b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b = b()) != null && !b.isFinishing()) {
            b.finish();
        }
    }

    public final Activity b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SystemManager.getInstance().notifyUpdateResult(8);
            a();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
            a.b.b(b());
            this.a = null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
        }
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) {
            int intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
            if (intExtra == 0) {
                HMSLog.i("UpdateAdapter", "Error resolved successfully!");
                SystemManager.getInstance().notifyUpdateResult(0);
            } else if (intExtra == 13) {
                HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else if (intExtra == 8) {
                HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
                SystemManager.getInstance().notifyUpdateResult(8);
            } else {
                HMSLog.i("UpdateAdapter", "Other error codes.");
                SystemManager.getInstance().notifyUpdateResult(intExtra);
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (activity == null) {
                HMSLog.i("UpdateAdapter", "activity == null");
                c();
                return;
            }
            activity.getApplicationContext();
            this.a = new WeakReference<>(activity);
            if (!a.b.a(b())) {
                return;
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                c();
                return;
            }
            int intExtra = intent.getIntExtra("update_version", 0);
            this.b = intExtra;
            if (intExtra == 0) {
                c();
                return;
            }
            if (intent.hasExtra("installHMS")) {
                this.c = true;
            }
            a(intent, activity);
        }
    }

    public final boolean a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, str, i)) == null) {
            if (context == null || TextUtils.isEmpty(str) || i == 0) {
                return false;
            }
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
            if (!PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str)) && packageManagerHelper.getPackageVersionCode(str) >= i) {
                return false;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean a(Intent intent, Activity activity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, intent, activity)) == null) {
            if (!intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
                return false;
            }
            HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
            String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent2 = new Intent();
            intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
            intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
            intent2.setComponent(componentName);
            activity.startActivityForResult(intent2, 1001);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, intent)) == null) {
            if (i != getRequestCode()) {
                return false;
            }
            HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i2);
            if (i2 == -1) {
                if (intent != null) {
                    if (intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                        HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                        SystemManager.getInstance().notifyUpdateResult(0);
                        a();
                        return true;
                    }
                    a(intent);
                }
            } else if (i2 == 0) {
                HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
                Activity b = b();
                if (b == null) {
                    return true;
                }
                String hMSPackageName = HMSPackageManager.getInstance(b.getApplicationContext()).getHMSPackageName();
                if (!this.c && !a(b, hMSPackageName, this.b)) {
                    SystemManager.getInstance().notifyUpdateResult(0);
                } else {
                    HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                    SystemManager.getInstance().notifyUpdateResult(13);
                }
            } else if (i2 == 1) {
                SystemManager.getInstance().notifyUpdateResult(28);
            }
            a();
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, keyEvent) == null) {
            HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
        }
    }
}
