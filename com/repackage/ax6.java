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
/* loaded from: classes5.dex */
public class ax6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<jn> list) {
        rw5 rw5Var;
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
            jn jnVar = (jn) ListUtils.getItem(list, i);
            if ((jnVar instanceof rw5) && (threadData = (rw5Var = (rw5) jnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(jg.g(threadData.getTid(), 0L))) != null) {
                rw5Var.J(threadPersonalized.source);
                rw5Var.M(threadPersonalized.weight);
                rw5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    rw5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    rw5Var.feedBackReasonMap = sparseArray;
                    rw5Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            jn jnVar = (jn) ListUtils.getItem(list, i);
            boolean z = jnVar instanceof fx5;
            if (z) {
                ((fx5) jnVar).c(true);
            }
            i++;
            jn jnVar2 = (jn) ListUtils.getItem(list, i);
            if (z && (jnVar2 instanceof fx5)) {
                fx5 fx5Var = (fx5) jnVar;
                fx5 fx5Var2 = (fx5) jnVar2;
                if (fx5Var.l()) {
                    fx5Var2.c(false);
                    if (fx5Var2 instanceof hx6) {
                        fx5Var.t(false);
                    }
                }
            }
            if (jnVar instanceof hx6) {
                ((hx6) jnVar).t(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
