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
public class gc5 {
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
                        qq4 qq4Var = new qq4();
                        qq4Var.s = threadData;
                        qq4Var.position = i;
                        qq4Var.a = true;
                        qq4Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(qq4Var);
                        qq4 qq4Var2 = new qq4();
                        qq4Var2.s = threadData;
                        qq4Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            qq4Var2.f = true;
                        } else if (threadData.picCount() == 1) {
                            qq4Var2.d = true;
                            qq4Var2.t = imageWidthAndHeight[0];
                            qq4Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            qq4Var2.e = true;
                        } else {
                            qq4Var2.b = true;
                        }
                        qq4Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(qq4Var2);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var3 = new qq4();
                            qq4Var3.n = true;
                            qq4Var3.s = threadData;
                            qq4Var3.position = i;
                            qq4Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(qq4Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            qq4 qq4Var4 = new qq4();
                            qq4Var4.s = threadData;
                            qq4Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                qq4Var4.p = true;
                            } else {
                                qq4Var4.q = true;
                            }
                            qq4Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(qq4Var4);
                        }
                        qq4 qq4Var5 = new qq4();
                        qq4Var5.m = true;
                        qq4Var5.s = threadData;
                        qq4Var5.position = i;
                        qq4Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(qq4Var5);
                        qq4 qq4Var6 = new qq4();
                        qq4Var6.g = true;
                        qq4Var6.s = threadData;
                        qq4Var6.position = i;
                        qq4Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(qq4Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        qq4 qq4Var7 = new qq4();
                        qq4Var7.s = threadData;
                        qq4Var7.position = i;
                        qq4Var7.a = true;
                        qq4Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(qq4Var7);
                        qq4 qq4Var8 = new qq4();
                        qq4Var8.s = threadData;
                        qq4Var8.position = i;
                        qq4Var8.i = true;
                        qq4Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(qq4Var8);
                        if (threadData.getItem() != null) {
                            qq4 qq4Var9 = new qq4();
                            qq4Var9.n = true;
                            qq4Var9.s = threadData;
                            qq4Var9.position = i;
                            qq4Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(qq4Var9);
                        }
                        qq4 qq4Var10 = new qq4();
                        qq4Var10.m = true;
                        qq4Var10.s = threadData;
                        qq4Var10.position = i;
                        qq4Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(qq4Var10);
                        qq4 qq4Var11 = new qq4();
                        qq4Var11.g = true;
                        qq4Var11.s = threadData;
                        qq4Var11.position = i;
                        qq4Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(qq4Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        qq4 qq4Var12 = new qq4();
                        qq4Var12.s = threadData;
                        qq4Var12.position = i;
                        arrayList.add(qq4Var12);
                    } else if (uy5.W(threadData)) {
                        uy5 uy5Var = new uy5(threadData);
                        uy5Var.g = threadData.getTid();
                        arrayList.add(uy5Var);
                    } else {
                        qq4 qq4Var13 = new qq4();
                        qq4Var13.s = threadData;
                        qq4Var13.position = i;
                        arrayList.add(qq4Var13);
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

    public static void b(List<nn> list, nn4 nn4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, nn4Var) == null) || nn4Var == null || list == null || (i = nn4Var.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    fc5.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, nn4Var);
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
