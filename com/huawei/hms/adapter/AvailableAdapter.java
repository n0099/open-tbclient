package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
/* loaded from: classes9.dex */
public class AvailableAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public AvailableCallBack b;
    public boolean c;
    public SystemObserver d;

    /* loaded from: classes9.dex */
    public interface AvailableCallBack {
        void onComplete(int i);
    }

    public boolean isUserNoticeError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 29 : invokeI.booleanValue;
    }

    public boolean isUserResolvableError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i == 1 || i == 2 : invokeI.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a implements SystemObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AvailableAdapter a;

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, str)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public a(AvailableAdapter availableAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {availableAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = availableAdapter;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(1048576, this, i)) != null) {
                return invokeI.booleanValue;
            }
            AvailableCallBack a = this.a.a();
            if (a == null) {
                HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            a.onComplete(i);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) != null) {
                return invokeI.booleanValue;
            }
            AvailableCallBack a = this.a.a();
            if (a == null) {
                HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a.onComplete(i);
            return true;
        }
    }

    public AvailableAdapter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.a = i;
        this.c = false;
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            int a2 = a(context);
            if (a2 != 0) {
                return a2;
            }
            if (HMSPackageManager.getInstance(context).isApkNeedUpdate(this.a)) {
                HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
                return 2;
            }
            return a2;
        }
        return invokeL.intValue;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            int a2 = a(context);
            if (a2 != 0) {
                return a2;
            }
            if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.a)) {
                HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
                return 2;
            }
            return a2;
        }
        return invokeL.intValue;
    }

    public void setCalledBySolutionInstallHms(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c = z;
        }
    }

    public final int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
                return 21;
            }
            PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is not installed");
                return 1;
            } else if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is spoofed");
                return 29;
            } else if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is disabled");
                return 3;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public final AvailableCallBack a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (AvailableCallBack) invokeV.objValue;
    }

    public final void a(Activity activity, AvailableCallBack availableCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, availableCallBack) == null) {
            HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
            if (NotInstalledHmsAdapter.getShowLock()) {
                this.b = availableCallBack;
                SystemManager.getSystemNotifier().registerObserver(this.d);
                activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
                return;
            }
            availableCallBack.onComplete(31);
        }
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, activity, availableCallBack) == null) && activity != null && availableCallBack != null) {
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
                return;
            }
            HMSLog.i("AvailableAdapter", "startNotice");
            this.b = availableCallBack;
            SystemManager.getSystemNotifier().registerObserver(this.d);
            activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
        }
    }

    public final boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (HMSPackageManager.getInstance(activity).getHmsVersionCode() >= 40000000) {
                HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, activity, availableCallBack) == null) && activity != null && availableCallBack != null) {
            if (UIUtil.isBackground(activity)) {
                HMSLog.i("AvailableAdapter", "current app is in Background");
                availableCallBack.onComplete(28);
            } else if (!a(activity)) {
                a(activity, availableCallBack);
            } else {
                HMSLog.i("AvailableAdapter", "startResolution");
                this.b = availableCallBack;
                SystemManager.getSystemNotifier().registerObserver(this.d);
                Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
                intentStartBridgeActivity.putExtra("update_version", this.a);
                if (this.c) {
                    intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                }
                intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, true);
                activity.startActivity(intentStartBridgeActivity);
            }
        }
    }
}
