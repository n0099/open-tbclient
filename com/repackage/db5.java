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
/* loaded from: classes5.dex */
public class db5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<nn> a(List<? extends nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (nn nnVar : list) {
                if (nnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        bq4 bq4Var = new bq4();
                        bq4Var.s = threadData;
                        bq4Var.position = i;
                        bq4Var.a = true;
                        bq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(bq4Var);
                        bq4 bq4Var2 = new bq4();
                        bq4Var2.s = threadData;
                        bq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            bq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            bq4Var2.d = true;
                            bq4Var2.t = imageWidthAndHeight[0];
                            bq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            bq4Var2.e = true;
                        } else {
                            bq4Var2.b = true;
                        }
                        bq4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(bq4Var2);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var3 = new bq4();
                            bq4Var3.n = true;
                            bq4Var3.s = threadData;
                            bq4Var3.position = i;
                            bq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bq4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            bq4 bq4Var4 = new bq4();
                            bq4Var4.s = threadData;
                            bq4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                bq4Var4.p = true;
                            } else {
                                bq4Var4.q = true;
                            }
                            bq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bq4Var4);
                        }
                        bq4 bq4Var5 = new bq4();
                        bq4Var5.m = true;
                        bq4Var5.s = threadData;
                        bq4Var5.position = i;
                        bq4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bq4Var5);
                        bq4 bq4Var6 = new bq4();
                        bq4Var6.g = true;
                        bq4Var6.s = threadData;
                        bq4Var6.position = i;
                        bq4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(bq4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        bq4 bq4Var7 = new bq4();
                        bq4Var7.s = threadData;
                        bq4Var7.position = i;
                        bq4Var7.a = true;
                        bq4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(bq4Var7);
                        bq4 bq4Var8 = new bq4();
                        bq4Var8.s = threadData;
                        bq4Var8.position = i;
                        bq4Var8.i = true;
                        bq4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bq4Var8);
                        if (threadData.getItem() != null) {
                            bq4 bq4Var9 = new bq4();
                            bq4Var9.n = true;
                            bq4Var9.s = threadData;
                            bq4Var9.position = i;
                            bq4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(bq4Var9);
                        }
                        bq4 bq4Var10 = new bq4();
                        bq4Var10.m = true;
                        bq4Var10.s = threadData;
                        bq4Var10.position = i;
                        bq4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(bq4Var10);
                        bq4 bq4Var11 = new bq4();
                        bq4Var11.g = true;
                        bq4Var11.s = threadData;
                        bq4Var11.position = i;
                        bq4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(bq4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        bq4 bq4Var12 = new bq4();
                        bq4Var12.s = threadData;
                        bq4Var12.position = i;
                        arrayList.add(bq4Var12);
                    } else if (xx5.W(threadData)) {
                        xx5 xx5Var = new xx5(threadData);
                        xx5Var.g = threadData.getTid();
                        arrayList.add(xx5Var);
                    } else {
                        bq4 bq4Var13 = new bq4();
                        bq4Var13.s = threadData;
                        bq4Var13.position = i;
                        arrayList.add(bq4Var13);
                    }
                } else if (nnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nnVar).position = i;
                    arrayList.add(nnVar);
                } else {
                    arrayList.add(nnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<nn> list, ym4 ym4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, ym4Var) == null) || ym4Var == null || list == null || (i = ym4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    cb5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, ym4Var);
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
