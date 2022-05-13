package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes6.dex */
public class pj7 implements ro {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public cj7 a;
    public List<qj7> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755407916, "Lcom/repackage/pj7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755407916, "Lcom/repackage/pj7;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public pj7(VipTaskList vipTaskList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vipTaskList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (vipTaskList == null || vipTaskList.item == null) {
            return;
        }
        String str = vipTaskList.card_id;
        cj7 cj7Var = new cj7();
        this.a = cj7Var;
        cj7Var.e(3);
        this.a.d(vipTaskList.class_name);
        this.a.f(vipTaskList.class_url_name);
        this.a.g(vipTaskList.class_url);
        this.b = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.b.add(new qj7(vipTaskItem));
        }
    }

    @Override // com.repackage.ro
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c : (BdUniqueId) invokeV.objValue;
    }
}
