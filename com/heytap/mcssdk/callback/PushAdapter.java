package com.heytap.mcssdk.callback;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class PushAdapter implements PushCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushAdapter() {
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

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetAliases(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetNotificationStatus(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetPushStatus(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetTags(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onGetUserAccounts(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onRegister(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetAliases(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetPushTime(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetTags(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onSetUserAccounts(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnRegister(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetAliases(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetTags(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, list) == null) {
        }
    }

    @Override // com.heytap.mcssdk.callback.PushCallback
    public void onUnsetUserAccounts(int i, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, list) == null) {
        }
    }
}
