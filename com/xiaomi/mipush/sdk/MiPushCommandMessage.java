package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MiPushCommandMessage implements PushMessageHandler.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_COMMAND = "command";
    public static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
    public static final String KEY_REASON = "reason";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String category;
    public String command;
    public List<String> commandArguments;
    public String reason;
    public long resultCode;

    public MiPushCommandMessage() {
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

    public static MiPushCommandMessage fromBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            miPushCommandMessage.command = bundle.getString("command");
            miPushCommandMessage.resultCode = bundle.getLong(KEY_RESULT_CODE);
            miPushCommandMessage.reason = bundle.getString("reason");
            miPushCommandMessage.commandArguments = bundle.getStringArrayList(KEY_COMMAND_ARGUMENTS);
            miPushCommandMessage.category = bundle.getString("category");
            return miPushCommandMessage;
        }
        return (MiPushCommandMessage) invokeL.objValue;
    }

    public String getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.category : (String) invokeV.objValue;
    }

    public String getCommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.command : (String) invokeV.objValue;
    }

    public List<String> getCommandArguments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.commandArguments : (List) invokeV.objValue;
    }

    public String getReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.reason : (String) invokeV.objValue;
    }

    public long getResultCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.resultCode : invokeV.longValue;
    }

    public void setCategory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.category = str;
        }
    }

    public void setCommand(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.command = str;
        }
    }

    public void setCommandArguments(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.commandArguments = list;
        }
    }

    public void setReason(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.reason = str;
        }
    }

    public void setResultCode(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.resultCode = j2;
        }
    }

    public Bundle toBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("command", this.command);
            bundle.putLong(KEY_RESULT_CODE, this.resultCode);
            bundle.putString("reason", this.reason);
            List<String> list = this.commandArguments;
            if (list != null) {
                bundle.putStringArrayList(KEY_COMMAND_ARGUMENTS, (ArrayList) list);
            }
            bundle.putString("category", this.category);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "command={" + this.command + "}, resultCode={" + this.resultCode + "}, reason={" + this.reason + "}, category={" + this.category + "}, commandArguments={" + this.commandArguments + "}";
        }
        return (String) invokeV.objValue;
    }
}
