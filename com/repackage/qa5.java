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
public class qa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<jn> a(List<? extends jn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (jn jnVar : list) {
                if (jnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) jnVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        rp4 rp4Var = new rp4();
                        rp4Var.s = threadData;
                        rp4Var.position = i;
                        rp4Var.a = true;
                        rp4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(rp4Var);
                        rp4 rp4Var2 = new rp4();
                        rp4Var2.s = threadData;
                        rp4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            rp4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            rp4Var2.d = true;
                            rp4Var2.t = imageWidthAndHeight[0];
                            rp4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            rp4Var2.e = true;
                        } else {
                            rp4Var2.b = true;
                        }
                        rp4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(rp4Var2);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var3 = new rp4();
                            rp4Var3.n = true;
                            rp4Var3.s = threadData;
                            rp4Var3.position = i;
                            rp4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rp4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            rp4 rp4Var4 = new rp4();
                            rp4Var4.s = threadData;
                            rp4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                rp4Var4.p = true;
                            } else {
                                rp4Var4.q = true;
                            }
                            rp4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rp4Var4);
                        }
                        rp4 rp4Var5 = new rp4();
                        rp4Var5.m = true;
                        rp4Var5.s = threadData;
                        rp4Var5.position = i;
                        rp4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rp4Var5);
                        rp4 rp4Var6 = new rp4();
                        rp4Var6.g = true;
                        rp4Var6.s = threadData;
                        rp4Var6.position = i;
                        rp4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(rp4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        rp4 rp4Var7 = new rp4();
                        rp4Var7.s = threadData;
                        rp4Var7.position = i;
                        rp4Var7.a = true;
                        rp4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(rp4Var7);
                        rp4 rp4Var8 = new rp4();
                        rp4Var8.s = threadData;
                        rp4Var8.position = i;
                        rp4Var8.i = true;
                        rp4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rp4Var8);
                        if (threadData.getItem() != null) {
                            rp4 rp4Var9 = new rp4();
                            rp4Var9.n = true;
                            rp4Var9.s = threadData;
                            rp4Var9.position = i;
                            rp4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(rp4Var9);
                        }
                        rp4 rp4Var10 = new rp4();
                        rp4Var10.m = true;
                        rp4Var10.s = threadData;
                        rp4Var10.position = i;
                        rp4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(rp4Var10);
                        rp4 rp4Var11 = new rp4();
                        rp4Var11.g = true;
                        rp4Var11.s = threadData;
                        rp4Var11.position = i;
                        rp4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(rp4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        rp4 rp4Var12 = new rp4();
                        rp4Var12.s = threadData;
                        rp4Var12.position = i;
                        arrayList.add(rp4Var12);
                    } else if (yw5.W(threadData)) {
                        yw5 yw5Var = new yw5(threadData);
                        yw5Var.g = threadData.getTid();
                        arrayList.add(yw5Var);
                    } else {
                        rp4 rp4Var13 = new rp4();
                        rp4Var13.s = threadData;
                        rp4Var13.position = i;
                        arrayList.add(rp4Var13);
                    }
                } else if (jnVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) jnVar).position = i;
                    arrayList.add(jnVar);
                } else {
                    arrayList.add(jnVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<jn> list, om4 om4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, om4Var) == null) || om4Var == null || list == null || (i = om4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    pa5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, om4Var);
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
