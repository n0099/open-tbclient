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
import com.repackage.m15;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class s86 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public static s86 b;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<p15> a;

    public s86() {
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

    public static s86 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (s86.class) {
                    if (b == null) {
                        b = new s86();
                    }
                }
            }
            return b;
        }
        return (s86) invokeV.objValue;
    }

    @Override // com.repackage.m15
    public void b(m15.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && FileHelper.checkSD()) {
            List<MyEmotionGroupData> h = h86.c().h(TbadkCoreApplication.getCurrentAccount());
            this.a.clear();
            for (MyEmotionGroupData myEmotionGroupData : h) {
                EmotionGroupData j = n86.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    j86 j86Var = new j86(j);
                    if (j86Var.d() != null) {
                        this.a.add(j86Var);
                        if (aVar != null) {
                            aVar.a(j86Var);
                        }
                    }
                }
            }
        }
    }

    @Override // com.repackage.m15
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.m15
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
