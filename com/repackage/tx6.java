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
/* loaded from: classes7.dex */
public class tx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<jn> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<jn> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            rp4 rp4Var = new rp4();
            rp4Var.s = threadData;
            rp4Var.position = i;
            if (z) {
                rp4Var.a = true;
            } else {
                rp4Var.r = true;
            }
            rp4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(rp4Var);
        }
    }

    public static ArrayList<jn> c(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<jn> arrayList2 = new ArrayList<>();
            Iterator<jn> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        rp4 rp4Var = new rp4();
                        rp4Var.s = threadData;
                        rp4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rp4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            rp4Var.d = true;
                            rp4Var.t = imageWidthAndHeight[0];
                            rp4Var.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rp4Var.e = true;
                        } else {
                            rp4Var.b = true;
                        }
                        rp4Var.s.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        rp4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var2 = new rp4();
                            rp4Var2.n = true;
                            rp4Var2.s = threadData;
                            rp4Var2.position = i;
                            rp4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            rp4 rp4Var3 = new rp4();
                            rp4Var3.s = threadData;
                            rp4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                rp4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                rp4Var3.q = true;
                            }
                            rp4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(rp4Var3);
                        }
                        rp4 rp4Var4 = new rp4();
                        rp4Var4.m = true;
                        rp4Var4.s = threadData;
                        rp4Var4.position = i;
                        rp4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(rp4Var4);
                        rp4 rp4Var5 = new rp4();
                        rp4Var5.g = true;
                        rp4Var5.s = threadData;
                        rp4Var5.position = i;
                        rp4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        rp4 rp4Var6 = new rp4();
                        rp4Var6.s = threadData;
                        rp4Var6.position = i;
                        rp4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        rp4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(rp4Var6);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var7 = new rp4();
                            rp4Var7.n = true;
                            rp4Var7.s = threadData;
                            rp4Var7.position = i;
                            rp4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(rp4Var7);
                        }
                        rp4 rp4Var8 = new rp4();
                        rp4Var8.m = true;
                        rp4Var8.s = threadData;
                        rp4Var8.position = i;
                        rp4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(rp4Var8);
                        rp4 rp4Var9 = new rp4();
                        rp4Var9.g = true;
                        rp4Var9.s = threadData;
                        rp4Var9.position = i;
                        rp4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(rp4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (yw5.W(threadData)) {
                        yw5 yw5Var = new yw5(threadData);
                        yw5Var.g = threadData.getTid();
                        yw5Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        yw5Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(yw5Var);
                    } else {
                        rp4 rp4Var10 = new rp4();
                        rp4Var10.s = threadData;
                        rp4Var10.position = i;
                        rp4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(rp4Var10);
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
                jn C = bdTypeRecyclerView.C(i3);
                ThreadData threadData = null;
                if (C instanceof rp4) {
                    threadData = ((rp4) C).getThreadData();
                } else if (C instanceof ThreadData) {
                    threadData = (ThreadData) C;
                } else if (C instanceof yw5) {
                    threadData = ((yw5) C).a;
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

    public static void e(boolean z, ArrayList<jn> arrayList, om4 om4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, om4Var}) == null) || om4Var == null || arrayList == null || (i = om4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, om4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
