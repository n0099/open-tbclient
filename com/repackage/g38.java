package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g38 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755728859, "Lcom/repackage/g38;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755728859, "Lcom/repackage/g38;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<jn> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                ThreadData threadData = (ThreadData) ListUtils.getItem(list, i);
                if (threadData != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    rw5 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                p28 p28Var = new p28();
                p28Var.d = c;
                p28Var.c = b;
                p28Var.b = a;
                p28Var.a = R.string.obfuscated_res_0x7f0f0e19;
                arrayList.add(p28Var);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        rw5 d = d(threadData);
                        if (d != null) {
                            arrayList.add(d);
                        }
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<jn> c(List<jn> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                jn jnVar = (jn) ListUtils.getItem(list, i);
                if ((jnVar instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) jnVar).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    rw5 d = d(threadData);
                    if (d != null) {
                        arrayList.add(d);
                    }
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static rw5 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            rw5 rw5Var = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                rw5Var = new zw5();
                rw5Var.a = threadData;
            } else if (uw5.W(threadData)) {
                rw5Var = new uw5(threadData);
            } else if (vw5.Z(threadData)) {
                rw5Var = new vw5(threadData);
            } else if (!zw5.W(threadData) && !zw5.X(threadData)) {
                if (ax5.R(threadData)) {
                    rw5Var = new ax5(threadData);
                }
            } else {
                rw5Var = new zw5();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                rw5Var.a = threadData;
            }
            if (rw5Var != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(rw5Var);
            }
            return rw5Var;
        }
        return (rw5) invokeL.objValue;
    }

    public static ThreadData e(jn jnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jnVar)) == null) {
            if (jnVar != null && (jnVar instanceof om4)) {
                ThreadData threadData = ((om4) jnVar).getThreadData();
                threadData.isFromPersonPolymeric = true;
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                return threadData;
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }
}
