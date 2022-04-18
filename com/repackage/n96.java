package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y05;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class n96 extends y05 {
    public static /* synthetic */ Interceptable $ic;
    public static n96 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<a15> a;

    public n96() {
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
        this.a = new LinkedList<>();
    }

    public static n96 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (n96.class) {
                    if (b == null) {
                        b = new n96();
                    }
                }
            }
            return b;
        }
        return (n96) invokeV.objValue;
    }

    @Override // com.repackage.y05
    public void b(y05.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD()) {
            List<MyEmotionGroupData> h = y86.c().h(TbadkCoreApplication.getCurrentAccount());
            this.a.clear();
            for (MyEmotionGroupData myEmotionGroupData : h) {
                EmotionGroupData j = e96.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    a96 a96Var = new a96(j);
                    if (a96Var.d() != null) {
                        this.a.add(a96Var);
                        if (aVar != null) {
                            aVar.a(a96Var);
                        }
                    }
                }
            }
        }
    }

    @Override // com.repackage.y05
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.y05
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
