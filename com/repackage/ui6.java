package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.ForumInfo;
import tbclient.ForumRule;
import tbclient.ForumRuleDetail.DataRes;
/* loaded from: classes7.dex */
public class ui6 implements nn {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId m;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumInfo a;
    public String b;
    public String c;
    public List<ForumRule> d;
    public int e;
    public String f;
    public boolean g;
    public String h;
    public BawuRoleInfoPub i;
    public String j;
    public wi6 k;
    public ti6 l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755259953, "Lcom/repackage/ui6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755259953, "Lcom/repackage/ui6;");
                return;
            }
        }
        m = BdUniqueId.gen();
    }

    public ui6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : invokeV.intValue;
    }

    public BawuRoleInfoPub c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (BawuRoleInfoPub) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public ForumInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ForumInfo) invokeV.objValue;
    }

    @Override // com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? m : (BdUniqueId) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public List<ForumRule> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d : (List) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public ti6 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (ti6) invokeV.objValue;
    }

    public void p(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.a = dataRes.forum;
        this.b = dataRes.title;
        this.c = dataRes.preface;
        this.d = dataRes.rules;
        this.e = dataRes.audit_status.intValue();
        this.f = dataRes.audit_opinion;
        this.g = dataRes.is_manager.intValue() == 1;
        Long l = dataRes.forum_rule_id;
        this.h = dataRes.publish_time;
        this.i = dataRes.bazhu;
        this.j = dataRes.cur_time;
        wi6 wi6Var = new wi6();
        this.k = wi6Var;
        wi6Var.a(dataRes);
        ti6 ti6Var = new ti6();
        this.l = ti6Var;
        ti6Var.h(dataRes);
    }

    public void r(BawuRoleInfoPub bawuRoleInfoPub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bawuRoleInfoPub) == null) {
            this.i = bawuRoleInfoPub;
        }
    }

    public void s(ForumInfo forumInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, forumInfo) == null) {
            this.a = forumInfo;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.g = z;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.c = str;
        }
    }
}
