package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;
/* loaded from: classes8.dex */
public class ForegroundIntentBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity activity;
    public String foregroundBody;
    public RequestHeader foregroundHeader;
    public ForegroundInnerHeader innerHeader;
    public String innerPkgName;
    public Context mHostContext;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (activity != null) {
            this.activity = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.foregroundHeader = requestHeader;
            requestHeader.setSdkVersion(60500300);
            this.foregroundBody = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.innerHeader = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, busResponseCallback) == null) {
            ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        }
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, busResponseCallback)) == null) {
            this.innerHeader.setResponseCallbackKey(str);
            ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
            return this;
        }
        return (ForegroundIntentBuilder) invokeLL.objValue;
    }

    public static void unregisterResponseCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
        }
    }

    public ForegroundIntentBuilder setAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.foregroundHeader.setApiName(str);
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setApiLevel(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.foregroundHeader.setApiLevel(i);
            return this;
        }
        return (ForegroundIntentBuilder) invokeI.objValue;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            this.mHostContext = context;
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.foregroundHeader.setKitSdkVersion(i);
            return this;
        }
        return (ForegroundIntentBuilder) invokeI.objValue;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.innerHeader.setApkVersion(i);
            return this;
        }
        return (ForegroundIntentBuilder) invokeI.objValue;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.foregroundBody = str;
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.innerHeader.setResponseCallbackKey(str);
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.foregroundHeader.setSrvName(str);
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.foregroundHeader.setAppID(str);
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.foregroundHeader.setTransactionId(str);
            return this;
        }
        return (ForegroundIntentBuilder) invokeL.objValue;
    }

    public Intent build() {
        InterceptResult invokeV;
        String packageName;
        String appId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.activity, ForegroundBusDelegate.class.getName());
            Context context = this.mHostContext;
            if (context != null) {
                packageName = context.getPackageName();
                appId = Util.getAppId(this.mHostContext);
            } else {
                packageName = this.activity.getPackageName();
                appId = Util.getAppId(this.activity);
            }
            if (this.foregroundHeader.getAppID() == null) {
                RequestHeader requestHeader = this.foregroundHeader;
                requestHeader.setAppID(appId + "|");
            } else {
                RequestHeader requestHeader2 = this.foregroundHeader;
                requestHeader2.setAppID(appId + "|" + this.foregroundHeader.getAppID());
            }
            if (TextUtils.isEmpty(this.foregroundHeader.getTransactionId())) {
                RequestHeader requestHeader3 = this.foregroundHeader;
                requestHeader3.setTransactionId(TransactionIdCreater.getId(requestHeader3.getAppID(), CoreNaming.HUBREQUEST));
            }
            this.foregroundHeader.setPkgName(packageName);
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.innerHeader.toJson());
            if (!TextUtils.isEmpty(this.innerPkgName)) {
                intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.innerPkgName);
            }
            return intentStartBridgeActivity;
        }
        return (Intent) invokeV.objValue;
    }

    public ForegroundIntentBuilder setInnerHms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.innerPkgName = this.activity.getPackageName();
            return this;
        }
        return (ForegroundIntentBuilder) invokeV.objValue;
    }
}
