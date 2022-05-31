package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class uc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List<sw5> b;

    /* loaded from: classes7.dex */
    public class a implements Comparator<sw5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(uc5 uc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(sw5 sw5Var, sw5 sw5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sw5Var, sw5Var2)) == null) ? sw5Var.sort() - sw5Var2.sort() : invokeLL.intValue;
        }
    }

    public uc5() {
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
        this.b = new LinkedList();
    }

    public List<sw5> a(List<PbLinkData> list, List<PbGoodsData> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, list2)) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (int i = 0; i < list.size(); i++) {
                    PbLinkData pbLinkData = list.get(i);
                    if (pbLinkData.urlType == 2 && !this.a) {
                        this.a = true;
                    }
                    this.b.add(pbLinkData);
                }
            }
            if (!ListUtils.isEmpty(list2)) {
                this.a = true;
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    this.b.add(list2.get(i2));
                }
            }
            Collections.sort(this.b, new a(this));
            return this.b;
        }
        return (List) invokeLL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
