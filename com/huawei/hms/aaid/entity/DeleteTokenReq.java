package com.huawei.hms.aaid.entity;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
/* loaded from: classes8.dex */
public class DeleteTokenReq implements IMessageEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Packed
    public String appId;
    @Packed
    public int deleteType;
    @Packed
    public boolean isFastApp;
    @Packed
    public boolean isMultiSender;
    @Packed
    public String pkgName;
    @Packed
    public String projectId;
    @Packed
    public String scope;
    @Packed
    public String subjectId;
    @Packed
    public String token;

    public DeleteTokenReq() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isMultiSender = false;
        this.deleteType = 0;
        this.isFastApp = false;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.appId;
        }
        return (String) invokeV.objValue;
    }

    public int getDeleteType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.deleteType;
        }
        return invokeV.intValue;
    }

    public String getPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pkgName;
        }
        return (String) invokeV.objValue;
    }

    public String getProjectId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.projectId;
        }
        return (String) invokeV.objValue;
    }

    public String getScope() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.scope;
        }
        return (String) invokeV.objValue;
    }

    public String getSubjectId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.subjectId;
        }
        return (String) invokeV.objValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.token;
        }
        return (String) invokeV.objValue;
    }

    public boolean isFastApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isFastApp;
        }
        return invokeV.booleanValue;
    }

    public boolean isMultiSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isMultiSender;
        }
        return invokeV.booleanValue;
    }

    public void setAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.appId = str;
        }
    }

    public void setDeleteType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.deleteType = i;
        }
    }

    public void setFastApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.isFastApp = z;
        }
    }

    public void setMultiSender(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isMultiSender = z;
        }
    }

    public void setPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.pkgName = str;
        }
    }

    public void setProjectId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.projectId = str;
        }
    }

    public void setScope(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.scope = str;
        }
    }

    public void setSubjectId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.subjectId = str;
        }
    }

    public void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.token = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(DeleteTokenReq.class.getName());
            stringBuffer.append("{");
            stringBuffer.append("pkgName: ");
            stringBuffer.append(this.pkgName);
            stringBuffer.append(",scope:");
            stringBuffer.append(this.scope);
            stringBuffer.append(",appId:");
            stringBuffer.append(this.appId);
            stringBuffer.append(",projectId:");
            stringBuffer.append(this.projectId);
            stringBuffer.append(",subjectId:");
            stringBuffer.append(this.subjectId);
            stringBuffer.append(",subjectId:");
            stringBuffer.append(this.subjectId);
            stringBuffer.append("}");
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
