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
public class gj7 implements nn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId c;
    public transient /* synthetic */ FieldHolder $fh;
    public ti7 a;
    public List<hj7> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755676035, "Lcom/repackage/gj7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755676035, "Lcom/repackage/gj7;");
                return;
            }
        }
        c = BdUniqueId.gen();
    }

    public gj7(VipTaskList vipTaskList) {
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
        ti7 ti7Var = new ti7();
        this.a = ti7Var;
        ti7Var.e(3);
        this.a.d(vipTaskList.class_name);
        this.a.f(vipTaskList.class_url_name);
        this.a.g(vipTaskList.class_url);
        this.b = new ArrayList();
        for (VipTaskItem vipTaskItem : vipTaskList.item) {
            this.b.add(new hj7(vipTaskItem));
        }
    }

    @Override // com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c : (BdUniqueId) invokeV.objValue;
    }
}
