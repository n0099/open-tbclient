package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;
    public String b;

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public BaseResolutionAdapter() {
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
        this.b = "";
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SystemManager.getInstance().notifyResolutionResult(null, this.b);
            a();
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
            this.a = null;
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
            this.a = new WeakReference<>(activity);
            Intent intent = activity.getIntent();
            if (intent == null) {
                c();
                return;
            }
            Bundle extras = intent.getExtras();
            this.b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            if (extras == null) {
                c();
                return;
            }
            Parcelable parcelable = extras.getParcelable(CommonCode.MapKey.HAS_RESOLUTION);
            if (parcelable == null) {
                c();
            } else if (parcelable instanceof Intent) {
                try {
                    activity.startActivityForResult((Intent) parcelable, 1001);
                } catch (ActivityNotFoundException unused) {
                    c();
                    HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                }
            } else if (parcelable instanceof PendingIntent) {
                try {
                    activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
                } catch (IntentSender.SendIntentException unused2) {
                    c();
                    HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
                }
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i, i2, intent)) == null) {
            if (i != getRequestCode()) {
                return false;
            }
            HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i2);
            if (i2 == 1001 || i2 == 1002) {
                if (intent == null) {
                    intent = new Intent();
                }
                intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i2);
            }
            if (i2 != -1 && !intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) && !intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
                SystemManager.getInstance().notifyResolutionResult(null, this.b);
            } else {
                SystemManager.getInstance().notifyResolutionResult(intent, this.b);
            }
            a();
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, keyEvent) == null) {
            HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
        }
    }
}
