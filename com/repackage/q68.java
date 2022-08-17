package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GiftInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class q68 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public int f;
    public List<on> g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755428066, "Lcom/repackage/q68;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755428066, "Lcom/repackage/q68;");
                return;
            }
        }
        h = BdUniqueId.gen();
    }

    public q68() {
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

    public void c(User user) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, user) == null) || user == null || ListUtils.isEmpty(user.gift_list)) {
            return;
        }
        this.c = String.valueOf(user.id);
        this.d = user.name;
        this.e = user.name_show;
        this.f = user.sex.intValue();
        String str = this.c;
        if (str != null && str.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.a = true;
        } else {
            this.a = false;
        }
        if (user.sex.intValue() == 2) {
            this.b = false;
        } else {
            this.b = true;
        }
        Integer num = user.gift_num;
        if (num != null) {
            num.intValue();
        }
        this.g = new ArrayList();
        for (GiftInfo giftInfo : user.gift_list) {
            if (giftInfo != null) {
                y68 y68Var = new y68();
                y68Var.c(giftInfo);
                this.g.add(y68Var);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.on
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h : (BdUniqueId) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !ListUtils.isEmpty(this.g) : invokeV.booleanValue;
    }
}
