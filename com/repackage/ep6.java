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
public class ep6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(zh5 zh5Var, ForumData forumData, List<ro> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{zh5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        hi5 hi5Var = new hi5(zh5Var, 5);
        hi5Var.E(list);
        if (forumData != null) {
            hi5Var.v(forumData.getId());
            hi5Var.u(forumData.getFirst_class());
            hi5Var.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            hi5Var.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        hi5Var.y(z);
        hi5Var.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, hi5Var));
    }

    public static void b(zh5 zh5Var, FrsViewData frsViewData, List<ro> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, zh5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(zh5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(qj8 qj8Var, List<ro> list, List<ro> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, qj8Var, list, list2) == null) || qj8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : qj8.f) {
            ro roVar = (ro) ListUtils.getItem(list, i);
            if (roVar != null && (indexOf = list2.indexOf(roVar)) >= 0) {
                qj8Var.a(i, indexOf);
            }
        }
    }
}
