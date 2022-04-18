package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
public class p07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<uo> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<uo> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            qq4 qq4Var = new qq4();
            qq4Var.s = threadData;
            qq4Var.position = i;
            if (z) {
                qq4Var.a = true;
            } else {
                qq4Var.r = true;
            }
            qq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(qq4Var);
        }
    }

    public static ArrayList<uo> c(ArrayList<uo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<uo> arrayList2 = new ArrayList<>();
            Iterator<uo> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                uo next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        qq4 qq4Var = new qq4();
                        qq4Var.s = threadData;
                        qq4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            qq4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            qq4Var.d = true;
                            qq4Var.t = imageWidthAndHeight[0];
                            qq4Var.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            qq4Var.e = true;
                        } else {
                            qq4Var.b = true;
                        }
                        qq4Var.s.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        qq4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(qq4Var);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var2 = new qq4();
                            qq4Var2.n = true;
                            qq4Var2.s = threadData;
                            qq4Var2.position = i;
                            qq4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            qq4 qq4Var3 = new qq4();
                            qq4Var3.s = threadData;
                            qq4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                qq4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                qq4Var3.q = true;
                            }
                            qq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(qq4Var3);
                        }
                        qq4 qq4Var4 = new qq4();
                        qq4Var4.m = true;
                        qq4Var4.s = threadData;
                        qq4Var4.position = i;
                        qq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(qq4Var4);
                        qq4 qq4Var5 = new qq4();
                        qq4Var5.g = true;
                        qq4Var5.s = threadData;
                        qq4Var5.position = i;
                        qq4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(qq4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        qq4 qq4Var6 = new qq4();
                        qq4Var6.s = threadData;
                        qq4Var6.position = i;
                        qq4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        qq4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(qq4Var6);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var7 = new qq4();
                            qq4Var7.n = true;
                            qq4Var7.s = threadData;
                            qq4Var7.position = i;
                            qq4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(qq4Var7);
                        }
                        qq4 qq4Var8 = new qq4();
                        qq4Var8.m = true;
                        qq4Var8.s = threadData;
                        qq4Var8.position = i;
                        qq4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(qq4Var8);
                        qq4 qq4Var9 = new qq4();
                        qq4Var9.g = true;
                        qq4Var9.s = threadData;
                        qq4Var9.position = i;
                        qq4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(qq4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (ey5.W(threadData)) {
                        ey5 ey5Var = new ey5(threadData);
                        ey5Var.g = threadData.getTid();
                        ey5Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        ey5Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(ey5Var);
                    } else {
                        qq4 qq4Var10 = new qq4();
                        qq4Var10.s = threadData;
                        qq4Var10.position = i;
                        qq4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(qq4Var10);
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

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                uo C = bdTypeRecyclerView.C(i3);
                ThreadData threadData = null;
                if (C instanceof qq4) {
                    threadData = ((qq4) C).getThreadData();
                } else if (C instanceof ThreadData) {
                    threadData = (ThreadData) C;
                } else if (C instanceof ey5) {
                    threadData = ((ey5) C).a;
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

    public static void e(boolean z, ArrayList<uo> arrayList, pn4 pn4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, pn4Var}) == null) || pn4Var == null || arrayList == null || (i = pn4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, pn4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
