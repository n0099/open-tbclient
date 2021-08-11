package com.vivo.push.sdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.LocalAliasTagsManager;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;
/* loaded from: classes10.dex */
public abstract class PushMessageReceiver extends BasePushMessageReceiver implements LocalAliasTagsManager.LocalMessageCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushMessageReceiver() {
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
    public void onDelAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
            LocalAliasTagsManager.getInstance(context).onDelAlias(list, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
            LocalAliasTagsManager.getInstance(context).onDelTags(list, str);
        }
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public boolean onNotificationMessageArrived(Context context, UPSNotificationMessage uPSNotificationMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, uPSNotificationMessage)) == null) ? LocalAliasTagsManager.getInstance(context).onReceiverNotification(uPSNotificationMessage, this) : invokeLL.booleanValue;
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onSetAlias(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
            LocalAliasTagsManager.getInstance(context).onSetAlias(list, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
            LocalAliasTagsManager.getInstance(context).onSetTags(list, str);
        }
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(Context context, UnvarnishedMessage unvarnishedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, unvarnishedMessage) == null) {
            LocalAliasTagsManager.getInstance(context).onReceiverMsg(unvarnishedMessage, this);
        }
    }
}
