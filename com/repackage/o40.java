package com.repackage;

import com.baidu.helios.ids.gaid.GaidProvider;
import com.baidu.helios.ids.oid.OaidProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h40;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o40 implements h40.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.h40.a
    public List<g40> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i40());
            arrayList.add(new OaidProvider());
            arrayList.add(new GaidProvider());
            arrayList.add(new l40());
            arrayList.add(new k40());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
