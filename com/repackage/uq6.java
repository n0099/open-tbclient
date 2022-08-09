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
/* loaded from: classes7.dex */
public class uq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gk5 gk5Var, ForumData forumData, List<on> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{gk5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        ok5 ok5Var = new ok5(gk5Var, 5);
        ok5Var.G(list);
        if (forumData != null) {
            ok5Var.w(forumData.getId());
            ok5Var.v(forumData.getFirst_class());
            ok5Var.E(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ok5Var.B(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        ok5Var.A(z);
        ok5Var.C(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
    }

    public static void b(gk5 gk5Var, FrsViewData frsViewData, List<on> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, gk5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(gk5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(tk8 tk8Var, List<on> list, List<on> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, tk8Var, list, list2) == null) || tk8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : tk8.f) {
            on onVar = (on) ListUtils.getItem(list, i);
            if (onVar != null && (indexOf = list2.indexOf(onVar)) >= 0) {
                tk8Var.a(i, indexOf);
            }
        }
    }
}
