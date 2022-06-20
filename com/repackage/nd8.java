package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nd8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public NetWork b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755473233, "Lcom/repackage/nd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755473233, "Lcom/repackage/nd8;");
                return;
            }
        }
        c = TbConfig.SERVER_ADDRESS + "c/c/forum/msign";
    }

    public nd8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
    }

    public void a() {
        NetWork netWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (netWork = this.b) == null) {
            return;
        }
        netWork.cancelNetConnect();
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NetWork netWork = this.b;
            if (netWork != null) {
                return netWork.getErrorString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NetWork netWork = this.b;
            if (netWork != null) {
                return netWork.getNetContext().getResponse().isRequestSuccess();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
        }
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            String id = currentAccountObj != null ? currentAccountObj.getID() : null;
            NetWork netWork = new NetWork(c);
            this.b = netWork;
            netWork.addPostData("user_id", id);
            this.b.addPostData("forum_ids", str);
            this.b.addPostData("authsid", this.a);
            this.b.getNetContext().getRequest().mNeedBackgroundLogin = true;
            this.b.getNetContext().getRequest().mIsNeedTbs = true;
            this.b.setNeedSig(true);
            return this.b.postNetData();
        }
        return (String) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            NetWork netWork = new NetWork(c);
            this.b = netWork;
            netWork.addPostData("authsid", this.a);
            this.b.getNetContext().getRequest().mNeedBackgroundLogin = true;
            this.b.getNetContext().getRequest().mIsNeedTbs = true;
            this.b.setNeedSig(true);
            return this.b.postNetData();
        }
        return (String) invokeV.objValue;
    }
}
