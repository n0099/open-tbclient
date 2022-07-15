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
public class f58 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755756728, "Lcom/repackage/f58;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755756728, "Lcom/repackage/f58;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        b = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36);
        c = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
    }

    public static List<nn> a(List<ThreadData> list) {
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
                    ny5 d = d(threadData);
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

    public static List<nn> b(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                o48 o48Var = new o48();
                o48Var.d = c;
                o48Var.c = b;
                o48Var.b = a;
                o48Var.a = R.string.obfuscated_res_0x7f0f0e17;
                arrayList.add(o48Var);
                for (int i = 0; i < list.size(); i++) {
                    ThreadData threadData = list.get(i);
                    if (threadData != null) {
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        ny5 d = d(threadData);
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

    public static List<nn> c(List<nn> list) {
        InterceptResult invokeL;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.isEmpty(list)) {
                return arrayList;
            }
            for (int i = 0; i < list.size(); i++) {
                nn nnVar = (nn) ListUtils.getItem(list, i);
                if ((nnVar instanceof CardPersonDynamicThreadData) && (threadData = ((CardPersonDynamicThreadData) nnVar).p) != null) {
                    AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                    ny5 d = d(threadData);
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

    public static ny5 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData)) == null) {
            ny5 ny5Var = null;
            if (threadData == null) {
                return null;
            }
            threadData.isFromPersonPolymeric = true;
            threadData.insertItemToTitleOrAbstractText();
            if (threadData.isShareThread) {
                ny5Var = new vy5();
                ny5Var.a = threadData;
            } else if (qy5.W(threadData)) {
                ny5Var = new qy5(threadData);
            } else if (ry5.Z(threadData)) {
                ny5Var = new ry5(threadData);
            } else if (!vy5.W(threadData) && !vy5.X(threadData)) {
                if (wy5.R(threadData)) {
                    ny5Var = new wy5(threadData);
                }
            } else {
                ny5Var = new vy5();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                ny5Var.a = threadData;
            }
            if (ny5Var != null) {
                AbsGroupUbsABTest.setCardInfoUbsABTest(ny5Var);
            }
            return ny5Var;
        }
        return (ny5) invokeL.objValue;
    }

    public static ThreadData e(nn nnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, nnVar)) == null) {
            if (nnVar != null && (nnVar instanceof nn4)) {
                ThreadData threadData = ((nn4) nnVar).getThreadData();
                threadData.isFromPersonPolymeric = true;
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                return threadData;
            }
            return null;
        }
        return (ThreadData) invokeL.objValue;
    }
}
