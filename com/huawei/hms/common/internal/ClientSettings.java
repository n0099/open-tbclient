package com.huawei.hms.common.internal;

import android.app.Activity;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes9.dex */
public class ClientSettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> apiName;
    public String appId;
    public String clientClassName;
    public String clientPackageName;
    public WeakReference<Activity> cpActivity;
    public boolean hasActivity;
    public String innerHmsPkg;
    public boolean isUseInnerHms;
    public String mCpID;
    public List<Scope> scopes;
    public SubAppInfo subAppId;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, list, str3, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.clientPackageName = str;
        this.clientClassName = str2;
        this.scopes = list;
        this.appId = str3;
        this.apiName = list2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, list, str3, list2, subAppInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (List) objArr2[2], (String) objArr2[3], (List) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setSubAppId(subAppInfo);
    }

    public List<String> getApiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.apiName;
        }
        return (List) invokeV.objValue;
    }

    public String getAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.appId;
        }
        return (String) invokeV.objValue;
    }

    public String getClientClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.clientClassName;
        }
        return (String) invokeV.objValue;
    }

    public String getClientPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.clientPackageName;
        }
        return (String) invokeV.objValue;
    }

    public Activity getCpActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            WeakReference<Activity> weakReference = this.cpActivity;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
        return (Activity) invokeV.objValue;
    }

    public String getCpID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mCpID;
        }
        return (String) invokeV.objValue;
    }

    public String getInnerHmsPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.innerHmsPkg;
        }
        return (String) invokeV.objValue;
    }

    public List<Scope> getScopes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.scopes;
        }
        return (List) invokeV.objValue;
    }

    public SubAppInfo getSubAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.subAppId;
        }
        return (SubAppInfo) invokeV.objValue;
    }

    public boolean isHasActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.hasActivity;
        }
        return invokeV.booleanValue;
    }

    public boolean isUseInnerHms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isUseInnerHms;
        }
        return invokeV.booleanValue;
    }

    public void setApiName(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.apiName = list;
        }
    }

    public void setAppID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.appId = str;
        }
    }

    public void setClientClassName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.clientClassName = str;
        }
    }

    public void setClientPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.clientPackageName = str;
        }
    }

    public void setCpActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            this.cpActivity = new WeakReference<>(activity);
            this.hasActivity = true;
        }
    }

    public void setCpID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mCpID = str;
        }
    }

    public void setInnerHmsPkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.innerHmsPkg = str;
        }
    }

    public void setScopes(List<Scope> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.scopes = list;
        }
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, subAppInfo) == null) {
            this.subAppId = subAppInfo;
        }
    }

    public void setUseInnerHms(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isUseInnerHms = z;
        }
    }
}
