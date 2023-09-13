package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
/* loaded from: classes10.dex */
public class CoreBaseResponse implements IMessageEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Packed
    public Intent intent;
    @Packed
    public String jsonBody;
    @Packed
    public String jsonHeader;
    @Packed
    public PendingIntent pendingIntent;

    public CoreBaseResponse() {
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

    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.intent;
        }
        return (Intent) invokeV.objValue;
    }

    public String getJsonBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.jsonBody;
        }
        return (String) invokeV.objValue;
    }

    public String getJsonHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.jsonHeader;
        }
        return (String) invokeV.objValue;
    }

    public PendingIntent getPendingIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.pendingIntent;
        }
        return (PendingIntent) invokeV.objValue;
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            this.intent = intent;
        }
    }

    public void setJsonBody(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.jsonBody = str;
        }
    }

    public void setJsonHeader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.jsonHeader = str;
        }
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pendingIntent) == null) {
            this.pendingIntent = pendingIntent;
        }
    }
}
