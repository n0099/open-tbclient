package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.p;
import com.vivo.push.util.s;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class BasePushMessageReceiver extends BroadcastReceiver implements PushMessageCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushMessageReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    public BasePushMessageReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean isAllowNet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context == null) {
                p.a("PushMessageReceiver", "isAllowNet sContext is null");
                return false;
            }
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                p.a("PushMessageReceiver", "isAllowNet pkgName is null");
                return false;
            }
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(packageName);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                return s.a(context, packageName);
            }
            p.a("PushMessageReceiver", "this is client sdk");
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onBind(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onListTags(Context context, int i2, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, context, i2, list, str) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onLog(Context context, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onPublish(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, context, i2, str) == null) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, intent) == null) {
            Context applicationContext = context.getApplicationContext();
            com.vivo.push.p.a().a(applicationContext);
            try {
                int intExtra = intent.getIntExtra("method", -1);
                String stringExtra = intent.getStringExtra(IAdRequestParam.REQ_ID);
                p.d("PushMessageReceiver", "PushMessageReceiver " + applicationContext.getPackageName() + " ; type = " + intExtra + " ; requestId = " + stringExtra);
                try {
                    com.vivo.push.p.a().a(intent, this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                p.b("PushMessageReceiver", "get method error", e3);
            }
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, unvarnishedMessage) == null) {
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onUnBind(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, context, i2, str) == null) {
        }
    }
}
