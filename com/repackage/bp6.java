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
/* loaded from: classes5.dex */
public class bp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ti5 ti5Var, ForumData forumData, List<nn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{ti5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        bj5 bj5Var = new bj5(ti5Var, 5);
        bj5Var.E(list);
        if (forumData != null) {
            bj5Var.v(forumData.getId());
            bj5Var.u(forumData.getFirst_class());
            bj5Var.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            bj5Var.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        bj5Var.y(z);
        bj5Var.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bj5Var));
    }

    public static void b(ti5 ti5Var, FrsViewData frsViewData, List<nn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, ti5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(ti5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(fi8 fi8Var, List<nn> list, List<nn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, fi8Var, list, list2) == null) || fi8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : fi8.f) {
            nn nnVar = (nn) ListUtils.getItem(list, i);
            if (nnVar != null && (indexOf = list2.indexOf(nnVar)) >= 0) {
                fi8Var.a(i, indexOf);
            }
        }
    }
}
