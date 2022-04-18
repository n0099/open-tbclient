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
public class wz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<uo> list) {
        xx5 xx5Var;
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
            if ((uoVar instanceof xx5) && (threadData = (xx5Var = (xx5) uoVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(mg.g(threadData.getTid(), 0L))) != null) {
                xx5Var.J(threadPersonalized.source);
                xx5Var.M(threadPersonalized.weight);
                xx5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    xx5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    xx5Var.feedBackReasonMap = sparseArray;
                    xx5Var.G(threadPersonalized.extra);
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
            boolean z = uoVar instanceof ly5;
            if (z) {
                ((ly5) uoVar).c(true);
            }
            i++;
            uo uoVar2 = (uo) ListUtils.getItem(list, i);
            if (z && (uoVar2 instanceof ly5)) {
                ly5 ly5Var = (ly5) uoVar;
                ly5 ly5Var2 = (ly5) uoVar2;
                if (ly5Var.l()) {
                    ly5Var2.c(false);
                    if (ly5Var2 instanceof d07) {
                        ly5Var.t(false);
                    }
                }
            }
            if (uoVar instanceof d07) {
                ((d07) uoVar).t(false);
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
