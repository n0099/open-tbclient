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
/* loaded from: classes7.dex */
public class ye6 implements fg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ye6() {
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

    @Override // com.repackage.fg6
    public void a(jo6 jo6Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jo6Var, frsViewData) == null) || jo6Var == null || frsViewData == null) {
            return;
        }
        ArrayList<jn> threadList = frsViewData.getThreadList();
        if (ListUtils.isEmpty(threadList)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<jn> it = threadList.iterator();
        while (it.hasNext()) {
            jn next = it.next();
            if (next.getType() == ThreadData.TYPE_TOP) {
                arrayList.add(next);
            }
        }
        frsViewData.setTopThreadList(arrayList);
    }

    @Override // com.repackage.fg6
    public void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.setVisibility(8);
        }
    }

    @Override // com.repackage.fg6
    public void c(jo6 jo6Var, lb6 lb6Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jo6Var, lb6Var, frsViewData) == null) || jo6Var == null || lb6Var == null || frsViewData == null) {
            return;
        }
        jo6Var.s();
        if (frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        lb6Var.Y0(frsViewData.getForum().getFrsBannerData());
    }

    @Override // com.repackage.fg6
    public int d(int i, FrsRequestData frsRequestData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, frsRequestData)) == null) ? xn6.e(i, frsRequestData) : invokeIL.intValue;
    }

    @Override // com.repackage.fg6
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }
}
