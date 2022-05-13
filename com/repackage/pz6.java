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
public class pz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<ro> arrayList) {
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

    public static void b(ThreadData threadData, int i, ArrayList<ro> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            br4 br4Var = new br4();
            br4Var.s = threadData;
            br4Var.position = i;
            if (z) {
                br4Var.a = true;
            } else {
                br4Var.r = true;
            }
            br4Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(br4Var);
        }
    }

    public static ArrayList<ro> c(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<ro> arrayList2 = new ArrayList<>();
            Iterator<ro> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ro next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        br4 br4Var = new br4();
                        br4Var.s = threadData;
                        br4Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            br4Var.f = true;
                        } else if (threadData.picCount() == 1) {
                            br4Var.d = true;
                            br4Var.t = imageWidthAndHeight[0];
                            br4Var.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            br4Var.e = true;
                        } else {
                            br4Var.b = true;
                        }
                        br4Var.s.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        br4Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var);
                        if (threadData.getItem() != null) {
                            br4 br4Var2 = new br4();
                            br4Var2.n = true;
                            br4Var2.s = threadData;
                            br4Var2.position = i;
                            br4Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            br4 br4Var3 = new br4();
                            br4Var3.s = threadData;
                            br4Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                br4Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                br4Var3.q = true;
                            }
                            br4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(br4Var3);
                        }
                        br4 br4Var4 = new br4();
                        br4Var4.m = true;
                        br4Var4.s = threadData;
                        br4Var4.position = i;
                        br4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(br4Var4);
                        br4 br4Var5 = new br4();
                        br4Var5.g = true;
                        br4Var5.s = threadData;
                        br4Var5.position = i;
                        br4Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(br4Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        br4 br4Var6 = new br4();
                        br4Var6.s = threadData;
                        br4Var6.position = i;
                        br4Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        br4Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(br4Var6);
                        if (threadData.getItem() != null) {
                            br4 br4Var7 = new br4();
                            br4Var7.n = true;
                            br4Var7.s = threadData;
                            br4Var7.position = i;
                            br4Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(br4Var7);
                        }
                        br4 br4Var8 = new br4();
                        br4Var8.m = true;
                        br4Var8.s = threadData;
                        br4Var8.position = i;
                        br4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(br4Var8);
                        br4 br4Var9 = new br4();
                        br4Var9.g = true;
                        br4Var9.s = threadData;
                        br4Var9.position = i;
                        br4Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(br4Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (fy5.W(threadData)) {
                        fy5 fy5Var = new fy5(threadData);
                        fy5Var.g = threadData.getTid();
                        fy5Var.feedBackReasonMap = threadData.feedBackReasonMap;
                        fy5Var.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(fy5Var);
                    } else {
                        br4 br4Var10 = new br4();
                        br4Var10.s = threadData;
                        br4Var10.position = i;
                        br4Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(br4Var10);
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
                ro C = bdTypeRecyclerView.C(i3);
                ThreadData threadData = null;
                if (C instanceof br4) {
                    threadData = ((br4) C).getThreadData();
                } else if (C instanceof ThreadData) {
                    threadData = (ThreadData) C;
                } else if (C instanceof fy5) {
                    threadData = ((fy5) C).a;
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

    public static void e(boolean z, ArrayList<ro> arrayList, zn4 zn4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, zn4Var}) == null) || zn4Var == null || arrayList == null || (i = zn4Var.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, zn4Var);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
