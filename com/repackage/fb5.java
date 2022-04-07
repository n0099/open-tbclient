package com.repackage;

import android.util.Log;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class fb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<uo> a(List<? extends uo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (uo uoVar : list) {
                if (uoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) uoVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        rq4 rq4Var = new rq4();
                        rq4Var.s = threadData;
                        rq4Var.position = i;
                        rq4Var.a = true;
                        rq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(rq4Var);
                        rq4 rq4Var2 = new rq4();
                        rq4Var2.s = threadData;
                        rq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rq4Var2.d = true;
                            rq4Var2.t = imageWidthAndHeight[0];
                            rq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rq4Var2.e = true;
                        } else {
                            rq4Var2.b = true;
                        }
                        rq4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(rq4Var2);
                        if (threadData.getItem() != null) {
                            rq4 rq4Var3 = new rq4();
                            rq4Var3.n = true;
                            rq4Var3.s = threadData;
                            rq4Var3.position = i;
                            rq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rq4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            rq4 rq4Var4 = new rq4();
                            rq4Var4.s = threadData;
                            rq4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                rq4Var4.p = true;
                            } else {
                                rq4Var4.q = true;
                            }
                            rq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rq4Var4);
                        }
                        rq4 rq4Var5 = new rq4();
                        rq4Var5.m = true;
                        rq4Var5.s = threadData;
                        rq4Var5.position = i;
                        rq4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rq4Var5);
                        rq4 rq4Var6 = new rq4();
                        rq4Var6.g = true;
                        rq4Var6.s = threadData;
                        rq4Var6.position = i;
                        rq4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(rq4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        rq4 rq4Var7 = new rq4();
                        rq4Var7.s = threadData;
                        rq4Var7.position = i;
                        rq4Var7.a = true;
                        rq4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(rq4Var7);
                        rq4 rq4Var8 = new rq4();
                        rq4Var8.s = threadData;
                        rq4Var8.position = i;
                        rq4Var8.i = true;
                        rq4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rq4Var8);
                        if (threadData.getItem() != null) {
                            rq4 rq4Var9 = new rq4();
                            rq4Var9.n = true;
                            rq4Var9.s = threadData;
                            rq4Var9.position = i;
                            rq4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rq4Var9);
                        }
                        rq4 rq4Var10 = new rq4();
                        rq4Var10.m = true;
                        rq4Var10.s = threadData;
                        rq4Var10.position = i;
                        rq4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rq4Var10);
                        rq4 rq4Var11 = new rq4();
                        rq4Var11.g = true;
                        rq4Var11.s = threadData;
                        rq4Var11.position = i;
                        rq4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(rq4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        rq4 rq4Var12 = new rq4();
                        rq4Var12.s = threadData;
                        rq4Var12.position = i;
                        arrayList.add(rq4Var12);
                    } else if (cy5.W(threadData)) {
                        cy5 cy5Var = new cy5(threadData);
                        cy5Var.g = threadData.getTid();
                        arrayList.add(cy5Var);
                    } else {
                        rq4 rq4Var13 = new rq4();
                        rq4Var13.s = threadData;
                        rq4Var13.position = i;
                        arrayList.add(rq4Var13);
                    }
                } else if (uoVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) uoVar).position = i;
                    arrayList.add(uoVar);
                } else {
                    arrayList.add(uoVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<uo> list, qn4 qn4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, qn4Var) == null) || qn4Var == null || list == null || (i = qn4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    eb5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, qn4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public static List<ThreadData> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                arrayList.add(threadData);
            }
            Log.i("Template", "parserThreadList-> size = " + arrayList.size());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
