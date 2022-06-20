package com.repackage;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes6.dex */
public class iy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<nn> list) {
        qx5 qx5Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, builder, list) == null) || builder == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i = 0; i < count; i++) {
            nn nnVar = (nn) ListUtils.getItem(list, i);
            if ((nnVar instanceof qx5) && (threadData = (qx5Var = (qx5) nnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(ng.g(threadData.getTid(), 0L))) != null) {
                qx5Var.J(threadPersonalized.source);
                qx5Var.M(threadPersonalized.weight);
                qx5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    qx5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    qx5Var.feedBackReasonMap = sparseArray;
                    qx5Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            nn nnVar = (nn) ListUtils.getItem(list, i);
            boolean z = nnVar instanceof fy5;
            if (z) {
                ((fy5) nnVar).d(true);
            }
            i++;
            nn nnVar2 = (nn) ListUtils.getItem(list, i);
            if (z && (nnVar2 instanceof fy5)) {
                fy5 fy5Var = (fy5) nnVar;
                fy5 fy5Var2 = (fy5) nnVar2;
                if (fy5Var.m()) {
                    fy5Var2.d(false);
                    if (fy5Var2 instanceof py6) {
                        fy5Var.u(false);
                    }
                }
            }
            if (nnVar instanceof py6) {
                ((py6) nnVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
