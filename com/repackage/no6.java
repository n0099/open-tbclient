package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes6.dex */
public class no6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(qh5 qh5Var, ForumData forumData, List<nn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{qh5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        yh5 yh5Var = new yh5(qh5Var, 5);
        yh5Var.E(list);
        if (forumData != null) {
            yh5Var.v(forumData.getId());
            yh5Var.u(forumData.getFirst_class());
            yh5Var.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            yh5Var.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        yh5Var.y(z);
        yh5Var.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yh5Var));
    }

    public static void b(qh5 qh5Var, FrsViewData frsViewData, List<nn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, qh5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(qh5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(kh8 kh8Var, List<nn> list, List<nn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, kh8Var, list, list2) == null) || kh8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : kh8.f) {
            nn nnVar = (nn) ListUtils.getItem(list, i);
            if (nnVar != null && (indexOf = list2.indexOf(nnVar)) >= 0) {
                kh8Var.a(i, indexOf);
            }
        }
    }
}
