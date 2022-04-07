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
public class bq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gh5 gh5Var, ForumData forumData, List<uo> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{gh5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        oh5 oh5Var = new oh5(gh5Var, 5);
        oh5Var.E(list);
        if (forumData != null) {
            oh5Var.v(forumData.getId());
            oh5Var.u(forumData.getFirst_class());
            oh5Var.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oh5Var.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        oh5Var.y(z);
        oh5Var.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, oh5Var));
    }

    public static void b(gh5 gh5Var, FrsViewData frsViewData, List<uo> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, gh5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(gh5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(mk8 mk8Var, List<uo> list, List<uo> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, mk8Var, list, list2) == null) || mk8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : mk8.f) {
            uo uoVar = (uo) ListUtils.getItem(list, i);
            if (uoVar != null && (indexOf = list2.indexOf(uoVar)) >= 0) {
                mk8Var.a(i, indexOf);
            }
        }
    }
}
