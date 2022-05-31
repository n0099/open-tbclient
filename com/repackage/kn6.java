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
public class kn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(tg5 tg5Var, ForumData forumData, List<jn> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{tg5Var, forumData, list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        bh5 bh5Var = new bh5(tg5Var, 5);
        bh5Var.E(list);
        if (forumData != null) {
            bh5Var.v(forumData.getId());
            bh5Var.u(forumData.getFirst_class());
            bh5Var.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            bh5Var.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        bh5Var.y(z);
        bh5Var.A(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var));
    }

    public static void b(tg5 tg5Var, FrsViewData frsViewData, List<jn> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, tg5Var, frsViewData, list, i) == null) || frsViewData == null) {
            return;
        }
        a(tg5Var, frsViewData.getForum(), list, false, i);
    }

    public static void c(rg8 rg8Var, List<jn> list, List<jn> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, rg8Var, list, list2) == null) || rg8Var == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i : rg8.f) {
            jn jnVar = (jn) ListUtils.getItem(list, i);
            if (jnVar != null && (indexOf = list2.indexOf(jnVar)) >= 0) {
                rg8Var.a(i, indexOf);
            }
        }
    }
}
