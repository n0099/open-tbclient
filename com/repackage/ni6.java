package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ni6 implements vj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ni6() {
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

    @Override // com.repackage.vj6
    public void a(sr6 sr6Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, sr6Var, frsViewData) == null) || sr6Var == null || frsViewData == null) {
            return;
        }
        ArrayList<on> threadList = frsViewData.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<on> it = threadList.iterator();
        while (it.hasNext()) {
            on next = it.next();
            if (next.getType() == ThreadData.TYPE_TOP) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }

    @Override // com.repackage.vj6
    public void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.repackage.vj6
    public void c(sr6 sr6Var, af6 af6Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sr6Var, af6Var, frsViewData) == null) || sr6Var == null || af6Var == null || frsViewData == null) {
            return;
        }
        sr6Var.w();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        af6Var.a1(frsViewData.getForum().getFrsBannerData());
    }

    @Override // com.repackage.vj6
    public int d(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, frsRequestData)) == null) ? gr6.e(i, frsRequestData) : invokeIL.intValue;
    }

    @Override // com.repackage.vj6
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }
}
