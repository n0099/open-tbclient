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
/* loaded from: classes5.dex */
public class cz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<nn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<nn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            bq4 bq4Var = new bq4();
            bq4Var.s = threadData;
            bq4Var.position = i;
            if (z) {
                bq4Var.a = true;
            } else {
                bq4Var.r = true;
            }
            bq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(bq4Var);
        }
    }

    public static ArrayList<nn> c(ArrayList<nn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<nn> arrayList2 = new ArrayList<>();
            Iterator<nn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        bq4 bq4Var = new bq4();
                        bq4Var.s = threadData;
                        bq4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bq4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            bq4Var.d = true;
                            bq4Var.t = imageWidthAndHeight[0];
                            bq4Var.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bq4Var.e = true;
                        } else {
                            bq4Var.b = true;
                        }
                        bq4Var.s.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        bq4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bq4Var);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var2 = new bq4();
                            bq4Var2.n = true;
                            bq4Var2.s = threadData;
                            bq4Var2.position = i;
                            bq4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bq4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            bq4 bq4Var3 = new bq4();
                            bq4Var3.s = threadData;
                            bq4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                bq4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                bq4Var3.q = true;
                            }
                            bq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(bq4Var3);
                        }
                        bq4 bq4Var4 = new bq4();
                        bq4Var4.m = true;
                        bq4Var4.s = threadData;
                        bq4Var4.position = i;
                        bq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bq4Var4);
                        bq4 bq4Var5 = new bq4();
                        bq4Var5.g = true;
                        bq4Var5.s = threadData;
                        bq4Var5.position = i;
                        bq4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bq4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        bq4 bq4Var6 = new bq4();
                        bq4Var6.s = threadData;
                        bq4Var6.position = i;
                        bq4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        bq4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(bq4Var6);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var7 = new bq4();
                            bq4Var7.n = true;
                            bq4Var7.s = threadData;
                            bq4Var7.position = i;
                            bq4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(bq4Var7);
                        }
                        bq4 bq4Var8 = new bq4();
                        bq4Var8.m = true;
                        bq4Var8.s = threadData;
                        bq4Var8.position = i;
                        bq4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(bq4Var8);
                        bq4 bq4Var9 = new bq4();
                        bq4Var9.g = true;
                        bq4Var9.s = threadData;
                        bq4Var9.position = i;
                        bq4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(bq4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (xx5.W(threadData)) {
                        xx5 xx5Var = new xx5(threadData);
                        xx5Var.g = threadData.getTid();
                        xx5Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        xx5Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(xx5Var);
                    } else {
                        bq4 bq4Var10 = new bq4();
                        bq4Var10.s = threadData;
                        bq4Var10.position = i;
                        bq4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(bq4Var10);
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

    public static String d(jz4 jz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jz4Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return jz4Var.a();
                }
                return jz4Var.b();
            }
            return jz4Var.c();
        }
        return (String) invokeL.objValue;
    }

    public static String e(jz4 jz4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jz4Var)) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (skinType != 1) {
                if (skinType != 4) {
                    return jz4Var.d();
                }
                return jz4Var.e();
            }
            return jz4Var.f();
        }
        return (String) invokeL.objValue;
    }

    public static jz4 f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!ListUtils.isEmpty(TbSingleton.getInstance().getHomePageLuckyConfig())) {
                for (jz4 jz4Var : TbSingleton.getInstance().getHomePageLuckyConfig()) {
                    if (!StringUtils.isNull(jz4Var.h()) && jz4Var.h().equals(str)) {
                        return jz4Var;
                    }
                }
            }
            return null;
        }
        return (jz4) invokeL.objValue;
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
                nn C = bdTypeRecyclerView.C(i3);
                ThreadData threadData = null;
                if (C instanceof bq4) {
                    threadData = ((bq4) C).getThreadData();
                } else if (C instanceof ThreadData) {
                    threadData = (ThreadData) C;
                } else if (C instanceof xx5) {
                    threadData = ((xx5) C).a;
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

    public static void h(boolean z, ArrayList<nn> arrayList, ym4 ym4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), arrayList, ym4Var}) == null) || ym4Var == null || arrayList == null || (i = ym4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, ym4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
