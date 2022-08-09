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
public class fd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<on> a(List<? extends on> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (on onVar : list) {
                if (onVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) onVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        ir4 ir4Var = new ir4();
                        ir4Var.t = threadData;
                        ir4Var.position = i;
                        ir4Var.a = true;
                        ir4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(ir4Var);
                        ir4 ir4Var2 = new ir4();
                        ir4Var2.t = threadData;
                        ir4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            ir4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            ir4Var2.d = true;
                            ir4Var2.u = imageWidthAndHeight[0];
                            ir4Var2.v = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            ir4Var2.e = true;
                        } else {
                            ir4Var2.b = true;
                        }
                        ir4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(ir4Var2);
                        if (threadData.getItem() != null) {
                            ir4 ir4Var3 = new ir4();
                            ir4Var3.n = true;
                            ir4Var3.t = threadData;
                            ir4Var3.position = i;
                            ir4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ir4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            ir4 ir4Var4 = new ir4();
                            ir4Var4.t = threadData;
                            ir4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                ir4Var4.p = true;
                            } else {
                                ir4Var4.q = true;
                            }
                            ir4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ir4Var4);
                        }
                        ir4 ir4Var5 = new ir4();
                        ir4Var5.m = true;
                        ir4Var5.t = threadData;
                        ir4Var5.position = i;
                        ir4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ir4Var5);
                        ir4 ir4Var6 = new ir4();
                        ir4Var6.g = true;
                        ir4Var6.t = threadData;
                        ir4Var6.position = i;
                        ir4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(ir4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        ir4 ir4Var7 = new ir4();
                        ir4Var7.t = threadData;
                        ir4Var7.position = i;
                        ir4Var7.a = true;
                        ir4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(ir4Var7);
                        ir4 ir4Var8 = new ir4();
                        ir4Var8.t = threadData;
                        ir4Var8.position = i;
                        ir4Var8.i = true;
                        ir4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ir4Var8);
                        if (threadData.getItem() != null) {
                            ir4 ir4Var9 = new ir4();
                            ir4Var9.n = true;
                            ir4Var9.t = threadData;
                            ir4Var9.position = i;
                            ir4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(ir4Var9);
                        }
                        ir4 ir4Var10 = new ir4();
                        ir4Var10.m = true;
                        ir4Var10.t = threadData;
                        ir4Var10.position = i;
                        ir4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(ir4Var10);
                        ir4 ir4Var11 = new ir4();
                        ir4Var11.g = true;
                        ir4Var11.t = threadData;
                        ir4Var11.position = i;
                        ir4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(ir4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        ir4 ir4Var12 = new ir4();
                        ir4Var12.t = threadData;
                        ir4Var12.position = i;
                        arrayList.add(ir4Var12);
                    } else if (m06.W(threadData)) {
                        m06 m06Var = new m06(threadData);
                        m06Var.g = threadData.getTid();
                        arrayList.add(m06Var);
                    } else {
                        ir4 ir4Var13 = new ir4();
                        ir4Var13.t = threadData;
                        ir4Var13.position = i;
                        arrayList.add(ir4Var13);
                    }
                } else if (onVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) onVar).position = i;
                    arrayList.add(onVar);
                } else {
                    arrayList.add(onVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<on> list, fo4 fo4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, fo4Var) == null) || fo4Var == null || list == null || (i = fo4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    ed5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, fo4Var);
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
