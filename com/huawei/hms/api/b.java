package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cqb;
import com.baidu.tieba.dqb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.update.note.DoNothingResolution;
import com.huawei.hms.update.note.NotInstalledHmsResolution;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
/* loaded from: classes9.dex */
public final class b extends HuaweiApiAvailability {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i, PendingIntent pendingIntent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i, pendingIntent)) == null) {
            if (i == 0) {
                return false;
            }
            return pendingIntent != null || i == 1 || i == 2 || i == 6 || i == 9;
        }
        return invokeIL.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class a implements BusResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dqb[] a;

        public a(b bVar, dqb[] dqbVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, dqbVarArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dqbVarArr;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult innerError(Activity activity, int i, String str) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activity, i, str)) == null) {
                HMSLog.e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i + ", errMessage" + str);
                this.a[0].c(new AvailabilityException());
                return null;
            }
            return (BusResponseResult) invokeLIL.objValue;
        }

        @Override // com.huawei.hms.activity.internal.BusResponseCallback
        public BusResponseResult succeedReturn(Activity activity, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, i, intent)) == null) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i + ", data" + intent);
                return null;
            }
            return (BusResponseResult) invokeLIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-803976035, "Lcom/huawei/hms/api/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-803976035, "Lcom/huawei/hms/api/b;");
                return;
            }
        }
        a = new b();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return a;
        }
        return (b) invokeV.objValue;
    }

    public static Dialog a(Activity activity, int i, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, null, activity, i, dialogRedirect, onCancelListener)) == null) {
            if (i == 0) {
                return null;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, NotInstalledHmsDialogHelper.getDialogThemeId(activity));
            builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i));
            if (onCancelListener != null) {
                builder.setOnCancelListener(onCancelListener);
            }
            builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i), dialogRedirect);
            String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i);
            if (errorTitle != null) {
                builder.setTitle(errorTitle);
            }
            return builder.create();
        }
        return (Dialog) invokeLILL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), onCancelListener})) == null) {
            Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
            if (errorDialog == null) {
                return false;
            }
            a(activity, errorDialog, HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    private Intent a(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, activity, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "getErrorResolutionIntent, errorCode: " + i);
            if (i != 1 && i != 2) {
                if (i != 6) {
                    if (i == 9 && Util.isAvailableLibExist(activity)) {
                        return BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName());
                    }
                    return null;
                }
                return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
            }
            return BridgeActivity.getIntentStartBridgeActivity(activity, DoNothingResolution.class.getName());
        }
        return (Intent) invokeLI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public cqb<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, huaweiApi, huaweiApiArr)) == null) {
            cqb<Void> b = new dqb().b();
            if (huaweiApi != null) {
                try {
                    a(huaweiApi);
                } catch (AvailabilityException e) {
                    HMSLog.i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e.getMessage());
                }
            }
            if (huaweiApiArr != null) {
                for (HuaweiApi<?> huaweiApi2 : huaweiApiArr) {
                    a(huaweiApi2);
                }
            }
            return b;
        }
        return (cqb) invokeLL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Intent getResolveErrorIntent(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, activity, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
            if (i != 1 && i != 2) {
                if (i != 6) {
                    if (i == 9 && Util.isAvailableLibExist(activity)) {
                        return a(activity, AppSpoofResolution.class.getName());
                    }
                    return null;
                }
                return a(activity, BindingFailedResolution.class.getName());
            }
            return a(activity, NotInstalledHmsResolution.class.getName());
        }
        return (Intent) invokeLI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void showErrorNotification(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, context, i) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i);
            if (!(context instanceof Activity)) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "context not instanceof Activity");
                return;
            }
            Dialog errorDialog = getErrorDialog((Activity) context, i, 0);
            if (errorDialog == null) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
            } else {
                errorDialog.show();
            }
        }
    }

    public static Intent a(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str)) == null) {
            return BridgeActivity.getIntentStartBridgeActivity(activity, str);
        }
        return (Intent) invokeLL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, connectionResult)) == null) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(connectionResult);
            return b(context, connectionResult.getErrorCode());
        }
        return (PendingIntent) invokeLL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, context, i)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i);
        }
        return invokeLI.intValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, connectionResult) == null) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(connectionResult);
            showErrorNotification(context, connectionResult.getErrorCode());
        }
    }

    public static Intent a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            return BridgeActivity.getIntentStartBridgeActivity(context, str);
        }
        return (Intent) invokeLL.objValue;
    }

    public static void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, activity, dialog, str, onCancelListener) == null) {
            Checker.checkNonNull(activity, "activity must not be null.");
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    private void a(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, obj) == null) {
            AvailabilityException availabilityException = new AvailabilityException();
            if (obj instanceof HuaweiApi) {
                connectionResult = availabilityException.getConnectionResult((HuaweiApi) obj);
            } else {
                connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
            }
            if (connectionResult.getErrorCode() == 0) {
                return;
            }
            HMSLog.i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
            throw availabilityException;
        }
    }

    public Intent a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
            if (i != 1 && i != 2) {
                if (i != 6) {
                    if (i == 9 && Util.isAvailableLibExist(context)) {
                        return a(context, AppSpoofResolution.class.getName());
                    }
                    return null;
                }
                return a(context, BindingFailedResolution.class.getName());
            }
            return a(context, NotInstalledHmsResolution.class.getName());
        }
        return (Intent) invokeLI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public cqb<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, huaweiApiCallable, huaweiApiCallableArr)) == null) {
            cqb<Void> b = new dqb().b();
            if (huaweiApiCallable != null) {
                try {
                    a(huaweiApiCallable);
                } catch (AvailabilityException e) {
                    HMSLog.i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e.getMessage());
                }
            }
            if (huaweiApiCallableArr != null) {
                for (HuaweiApiCallable huaweiApiCallable2 : huaweiApiCallableArr) {
                    a(huaweiApiCallable2);
                }
            }
            return b;
        }
        return (cqb) invokeLL.objValue;
    }

    public PendingIntent b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
            Intent a2 = a(context, i);
            if (a2 != null) {
                return PendingIntent.getActivity(context, 0, a2, 67108864);
            }
            return null;
        }
        return (PendingIntent) invokeLI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getResolveErrorPendingIntent(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, activity, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
            Intent resolveErrorIntent = getResolveErrorIntent(activity, i);
            if (resolveErrorIntent != null) {
                return PendingIntent.getActivity(activity, 0, resolveErrorIntent, 67108864);
            }
            return null;
        }
        return (PendingIntent) invokeLI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public PendingIntent getErrPendingIntent(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, context, i, i2)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i + " requestCode: " + i2);
            Intent a2 = a(context, i);
            if (a2 != null) {
                return PendingIntent.getActivity(context, i2, a2, 67108864);
            }
            return null;
        }
        return (PendingIntent) invokeLII.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, activity, i, i2)) == null) {
            Checker.checkNonNull(activity, "activity must not be null.");
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
            return getErrorDialog(activity, i, i2, null);
        }
        return (Dialog) invokeLII.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), onCancelListener})) == null) {
            Checker.checkNonNull(activity, "activity must not be null.");
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
            return a(activity, i, DialogRedirect.getInstance(activity, a(activity, i), i2), onCancelListener);
        }
        return (Dialog) invokeCommon.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public String getErrorString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i);
            return ConnectionResult.getErrorString(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileServicesAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
        }
        return invokeL.intValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean isUserResolvableError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            return isUserResolvableError(i, null);
        }
        return invokeI.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public cqb<Void> getHuaweiServicesReady(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, activity)) == null) {
            Preconditions.checkNotNull(activity);
            dqb[] dqbVarArr = {new dqb()};
            cqb<Void> b = dqbVarArr[0].b();
            int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
            Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
            if (resolveErrorIntent != null) {
                ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new a(this, dqbVarArr));
                Bundle bundle = new Bundle();
                bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, resolveErrorIntent);
                intentStartBridgeActivity.putExtras(bundle);
                activity.startActivity(intentStartBridgeActivity);
            } else if (isHuaweiMobileServicesAvailable == 3) {
                Intent intent = new Intent();
                intent.setClass(activity, EnableServiceActivity.class);
                activity.startActivity(intent);
            } else if (isHuaweiMobileServicesAvailable == 0) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
            } else {
                HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
                dqbVarArr[0].c(new AvailabilityException());
            }
            return b;
        }
        return (cqb) invokeL.objValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public int isHuaweiMobileNoticeAvailable(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            Checker.checkNonNull(context, "context must not be null.");
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(new PackageManagerHelper(context).getPackageStates(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService()))) {
                return 1;
            }
            if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000)) {
                return 2;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, activity, i, i2) == null) {
            resolveError(activity, i, i2, null);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048596, this, activity, i, i2)) == null) {
            return showErrorDialogFragment(activity, i, i2, null);
        }
        return invokeLII.booleanValue;
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public void resolveError(Activity activity, int i, int i2, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2), pendingIntent}) == null) {
            Checker.checkNonNull(activity, "activity must not be null.");
            if (pendingIntent != null) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i);
            } else {
                HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i);
                pendingIntent = getResolveErrorPendingIntent(activity, i);
            }
            if (pendingIntent != null) {
                HMSLog.i("HuaweiApiAvailabilityImpl", "In resolveError, start pendingIntent.errorCode: " + i);
                try {
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
                } catch (IntentSender.SendIntentException unused) {
                    HMSLog.e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i);
                }
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiAvailability
    public boolean showErrorDialogFragment(Activity activity, int i, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{activity, Integer.valueOf(i), fragment, Integer.valueOf(i2), onCancelListener})) == null) {
            return showErrorDialogFragment(activity, i, i2, onCancelListener);
        }
        return invokeCommon.booleanValue;
    }
}
