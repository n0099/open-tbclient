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
/* loaded from: classes7.dex */
public class wb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ro> a(List<? extends ro> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ro roVar : list) {
                if (roVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) roVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        br4 br4Var = new br4();
                        br4Var.s = threadData;
                        br4Var.position = i;
                        br4Var.a = true;
                        br4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(br4Var);
                        br4 br4Var2 = new br4();
                        br4Var2.s = threadData;
                        br4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            br4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            br4Var2.d = true;
                            br4Var2.t = imageWidthAndHeight[0];
                            br4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            br4Var2.e = true;
                        } else {
                            br4Var2.b = true;
                        }
                        br4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(br4Var2);
                        if (threadData.getItem() != null) {
                            br4 br4Var3 = new br4();
                            br4Var3.n = true;
                            br4Var3.s = threadData;
                            br4Var3.position = i;
                            br4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(br4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            br4 br4Var4 = new br4();
                            br4Var4.s = threadData;
                            br4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                br4Var4.p = true;
                            } else {
                                br4Var4.q = true;
                            }
                            br4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(br4Var4);
                        }
                        br4 br4Var5 = new br4();
                        br4Var5.m = true;
                        br4Var5.s = threadData;
                        br4Var5.position = i;
                        br4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(br4Var5);
                        br4 br4Var6 = new br4();
                        br4Var6.g = true;
                        br4Var6.s = threadData;
                        br4Var6.position = i;
                        br4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(br4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        br4 br4Var7 = new br4();
                        br4Var7.s = threadData;
                        br4Var7.position = i;
                        br4Var7.a = true;
                        br4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(br4Var7);
                        br4 br4Var8 = new br4();
                        br4Var8.s = threadData;
                        br4Var8.position = i;
                        br4Var8.i = true;
                        br4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(br4Var8);
                        if (threadData.getItem() != null) {
                            br4 br4Var9 = new br4();
                            br4Var9.n = true;
                            br4Var9.s = threadData;
                            br4Var9.position = i;
                            br4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(br4Var9);
                        }
                        br4 br4Var10 = new br4();
                        br4Var10.m = true;
                        br4Var10.s = threadData;
                        br4Var10.position = i;
                        br4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(br4Var10);
                        br4 br4Var11 = new br4();
                        br4Var11.g = true;
                        br4Var11.s = threadData;
                        br4Var11.position = i;
                        br4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(br4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        br4 br4Var12 = new br4();
                        br4Var12.s = threadData;
                        br4Var12.position = i;
                        arrayList.add(br4Var12);
                    } else if (fy5.W(threadData)) {
                        fy5 fy5Var = new fy5(threadData);
                        fy5Var.g = threadData.getTid();
                        arrayList.add(fy5Var);
                    } else {
                        br4 br4Var13 = new br4();
                        br4Var13.s = threadData;
                        br4Var13.position = i;
                        arrayList.add(br4Var13);
                    }
                } else if (roVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) roVar).position = i;
                    arrayList.add(roVar);
                } else {
                    arrayList.add(roVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<ro> list, zn4 zn4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, zn4Var) == null) || zn4Var == null || list == null || (i = zn4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    vb5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, zn4Var);
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
