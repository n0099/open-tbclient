package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class l17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, threadData, i, arrayList) == null) {
            if (threadData.getTabShowMode() == 1) {
                b(threadData, i, arrayList, true);
            } else if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                b(threadData, i, arrayList, false);
            } else {
                b(threadData, i, arrayList, true);
            }
        }
    }

    public static void b(ThreadData threadData, int i, ArrayList<on> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            ir4 ir4Var = new ir4();
            ir4Var.t = threadData;
            ir4Var.position = i;
            if (z) {
                ir4Var.a = true;
            } else {
                ir4Var.r = true;
            }
            ir4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(ir4Var);
        }
    }

    public static ArrayList<on> c(ArrayList<on> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<on> arrayList2 = new ArrayList<>();
            Iterator<on> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                on next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        ir4 ir4Var = new ir4();
                        ir4Var.t = threadData;
                        ir4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ir4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            ir4Var.d = true;
                            ir4Var.u = imageWidthAndHeight[0];
                            ir4Var.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ir4Var.e = true;
                        } else {
                            ir4Var.b = true;
                        }
                        ir4Var.t.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        ir4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var);
                        if (threadData.getItem() != null) {
                            ir4 ir4Var2 = new ir4();
                            ir4Var2.n = true;
                            ir4Var2.t = threadData;
                            ir4Var2.position = i;
                            ir4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            ir4 ir4Var3 = new ir4();
                            ir4Var3.t = threadData;
                            ir4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                ir4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                ir4Var3.q = true;
                            }
                            ir4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(ir4Var3);
                        }
                        ir4 ir4Var4 = new ir4();
                        ir4Var4.m = true;
                        ir4Var4.t = threadData;
                        ir4Var4.position = i;
                        ir4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(ir4Var4);
                        ir4 ir4Var5 = new ir4();
                        ir4Var5.g = true;
                        ir4Var5.t = threadData;
                        ir4Var5.position = i;
                        ir4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        ir4 ir4Var6 = new ir4();
                        ir4Var6.t = threadData;
                        ir4Var6.position = i;
                        ir4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        ir4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(ir4Var6);
                        if (threadData.getItem() != null) {
                            ir4 ir4Var7 = new ir4();
                            ir4Var7.n = true;
                            ir4Var7.t = threadData;
                            ir4Var7.position = i;
                            ir4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(ir4Var7);
                        }
                        ir4 ir4Var8 = new ir4();
                        ir4Var8.m = true;
                        ir4Var8.t = threadData;
                        ir4Var8.position = i;
                        ir4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(ir4Var8);
                        ir4 ir4Var9 = new ir4();
                        ir4Var9.g = true;
                        ir4Var9.t = threadData;
                        ir4Var9.position = i;
                        ir4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(ir4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (m06.W(threadData)) {
                        m06 m06Var = new m06(threadData);
                        m06Var.g = threadData.getTid();
                        m06Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        m06Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(m06Var);
                    } else {
                        ir4 ir4Var10 = new ir4();
                        ir4Var10.t = threadData;
                        ir4Var10.position = i;
                        ir4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(ir4Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String d(g15 g15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return g15Var.a();
                }
                return g15Var.b();
            }
            return g15Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(g15 g15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, g15Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return g15Var.d();
                }
                return g15Var.e();
            }
            return g15Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static g15 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (g15 g15Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(g15Var.h()) && g15Var.h().equals(str)) {
                        return g15Var;
                    }
                }
            }
            return null;
        }
        return (g15) invokeL.objValue;
    }

    public static List<Integer> g(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                on B = bdTypeRecyclerView.B(i3);
                ThreadData threadData = null;
                if (B instanceof ir4) {
                    threadData = ((ir4) B).getThreadData();
                } else if (B instanceof ThreadData) {
                    threadData = (ThreadData) B;
                } else if (B instanceof m06) {
                    threadData = ((m06) B).a;
                }
                if (threadData != null && threadData.getTid().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void h(boolean z, ArrayList<on> arrayList, fo4 fo4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, fo4Var}) == null) || fo4Var == null || arrayList == null || (i = fo4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, fo4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
