package com.heytap.mcssdk.callback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.SubscribeResult;
import java.util.List;
/* loaded from: classes6.dex */
public class PushAdapter implements PushCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushAdapter() {
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

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetAliases(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetNotificationStatus(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetPushStatus(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetTags(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetUserAccounts(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onRegister(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetAliases(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetPushTime(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, str) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetTags(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetUserAccounts(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnRegister(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetAliases(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetTags(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetUserAccounts(int i2, List<SubscribeResult> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, list) == null) {
        }
    }
}
