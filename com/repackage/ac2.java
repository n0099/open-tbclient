package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class ac2 implements v73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w73 a;

    public ac2() {
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
        cc2.X(cc2.p(), cc2.t());
    }

    @Override // com.repackage.v73
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? cc2.Y(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (!pb2.USER_DATA_PATH.equals(str)) {
                    if (str.startsWith(pb2.USER_DATA_PATH + File.separator)) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.v73
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return cc2.N("bdfile://tmp" + File.separator + str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    @NonNull
    public synchronized w73 d() {
        InterceptResult invokeV;
        w73 w73Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new bc2();
                }
                w73Var = this.a;
            }
            return w73Var;
        }
        return (w73) invokeV.objValue;
    }

    @Override // com.repackage.v73
    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (a73.s(str) == PathType.RELATIVE) {
                return cc2.Y(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? cc2.P(pb2.USER_DATA_PATH) : (String) invokeV.objValue;
    }

    @Override // com.repackage.v73
    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? cc2.Z(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? g(str) : (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String B = cc2.B(str);
            if (TextUtils.isEmpty(B)) {
                return null;
            }
            return B;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.v73
    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048585, this, str, z)) == null) ? cc2.V(str) : invokeLZ.booleanValue;
    }

    @Override // com.repackage.v73
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? cc2.N("bdfile://tmp") : (String) invokeV.objValue;
    }

    @Override // com.repackage.v73
    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.v73
    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? e(str) : (String) invokeL.objValue;
    }
}
