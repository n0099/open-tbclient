package com.huawei.hms.common.internal;

import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ahb;
import com.baidu.tieba.ghb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TaskApiCall";
    public transient /* synthetic */ FieldHolder $fh;
    public int apiLevel;
    public final String mRequestJson;
    public final String mUri;
    public Parcelable parcelable;
    public ahb token;
    public String transactionId;

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, ghb<ResultT> ghbVar);

    @Deprecated
    public int getMinApkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 30000000;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public TaskApiCall(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = null;
    }

    public TaskApiCall(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.apiLevel = 1;
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
        this.apiLevel = i;
    }

    public int getApiLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.apiLevel;
        }
        return invokeV.intValue;
    }

    public Parcelable getParcelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.parcelable;
        }
        return (Parcelable) invokeV.objValue;
    }

    public String getRequestJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRequestJson;
        }
        return (String) invokeV.objValue;
    }

    public ahb getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.token;
        }
        return (ahb) invokeV.objValue;
    }

    public String getTransactionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.transactionId;
        }
        return (String) invokeV.objValue;
    }

    public String getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mUri;
        }
        return (String) invokeV.objValue;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, ghb<ResultT> ghbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, clientt, responseErrorCode, str, ghbVar) == null) {
            ahb ahbVar = this.token;
            if (ahbVar != null && ahbVar.a()) {
                HMSLog.i(TAG, "This Task has been canceled, uri:" + this.mUri + ", transactionId:" + this.transactionId);
                return;
            }
            HMSLog.i(TAG, "doExecute, uri:" + this.mUri + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.transactionId);
            doExecute(clientt, responseErrorCode, str, ghbVar);
        }
    }

    public void setApiLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.apiLevel = i;
        }
    }

    public void setParcelable(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            this.parcelable = parcelable;
        }
    }

    public void setToken(ahb ahbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ahbVar) == null) {
            this.token = ahbVar;
        }
    }

    public void setTransactionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.transactionId = str;
        }
    }
}
