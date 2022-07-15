package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes7.dex */
public class si7 implements nn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e;
    public transient /* synthetic */ FieldHolder $fh;
    public ti7 a;
    public List<VipSpecialItem> b;
    public int c;
    public String d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755319504, "Lcom/repackage/si7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755319504, "Lcom/repackage/si7;");
                return;
            }
        }
        e = BdUniqueId.gen();
    }

    public si7(VipBasicList vipBasicList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipBasicList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = "";
        if (vipBasicList == null || vipBasicList.item.size() <= 0) {
            return;
        }
        this.d = vipBasicList.card_id;
        this.c = vipBasicList.card_type.intValue();
        ti7 ti7Var = new ti7();
        this.a = ti7Var;
        ti7Var.e(5);
        this.a.d(vipBasicList.class_name);
        this.a.f(vipBasicList.class_url_name);
        this.a.g(vipBasicList.class_url);
        this.b = new ArrayList();
        for (VipSpecialItem vipSpecialItem : vipBasicList.item) {
            this.b.add(vipSpecialItem);
        }
    }

    public List<VipSpecialItem> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    @Override // com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e : (BdUniqueId) invokeV.objValue;
    }
}
