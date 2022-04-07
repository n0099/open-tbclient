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
/* loaded from: classes7.dex */
public class uz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<uo> list) {
        vx5 vx5Var;
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
            uo uoVar = (uo) ListUtils.getItem(list, i);
            if ((uoVar instanceof vx5) && (threadData = (vx5Var = (vx5) uoVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(mg.g(threadData.getTid(), 0L))) != null) {
                vx5Var.J(threadPersonalized.source);
                vx5Var.M(threadPersonalized.weight);
                vx5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    vx5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    vx5Var.feedBackReasonMap = sparseArray;
                    vx5Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            uo uoVar = (uo) ListUtils.getItem(list, i);
            boolean z = uoVar instanceof jy5;
            if (z) {
                ((jy5) uoVar).c(true);
            }
            i++;
            uo uoVar2 = (uo) ListUtils.getItem(list, i);
            if (z && (uoVar2 instanceof jy5)) {
                jy5 jy5Var = (jy5) uoVar;
                jy5 jy5Var2 = (jy5) uoVar2;
                if (jy5Var.l()) {
                    jy5Var2.c(false);
                    if (jy5Var2 instanceof b07) {
                        jy5Var.t(false);
                    }
                }
            }
            if (uoVar instanceof b07) {
                ((b07) uoVar).t(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
