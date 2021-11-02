package com.vivo.push.sdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class OpenClientPushMessageReceiver extends BasePushMessageReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenClientPushMessageReceiver() {
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

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final boolean isAllowNet(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? super.isAllowNet(context) : invokeL.booleanValue;
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onBind(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str) == null) {
            super.onBind(context, i2, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onListTags(Context context, int i2, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, context, i2, list, str) == null) {
            super.onListTags(context, i2, list, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onLog(Context context, String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            super.onLog(context, str, i2, z);
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public final boolean onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, uPSNotificationMessage)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onPublish(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, context, i2, str) == null) {
            super.onPublish(context, i2, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, unvarnishedMessage) == null) {
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onUnBind(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, context, i2, str) == null) {
            super.onUnBind(context, i2, str);
        }
    }
}
