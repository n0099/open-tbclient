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
public class wy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<ro> list) {
        yx5 yx5Var;
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
            ro roVar = (ro) ListUtils.getItem(list, i);
            if ((roVar instanceof yx5) && (threadData = (yx5Var = (yx5) roVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(kg.g(threadData.getTid(), 0L))) != null) {
                yx5Var.J(threadPersonalized.source);
                yx5Var.M(threadPersonalized.weight);
                yx5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    yx5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    yx5Var.feedBackReasonMap = sparseArray;
                    yx5Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            ro roVar = (ro) ListUtils.getItem(list, i);
            boolean z = roVar instanceof my5;
            if (z) {
                ((my5) roVar).c(true);
            }
            i++;
            ro roVar2 = (ro) ListUtils.getItem(list, i);
            if (z && (roVar2 instanceof my5)) {
                my5 my5Var = (my5) roVar;
                my5 my5Var2 = (my5) roVar2;
                if (my5Var.l()) {
                    my5Var2.c(false);
                    if (my5Var2 instanceof dz6) {
                        my5Var.t(false);
                    }
                }
            }
            if (roVar instanceof dz6) {
                ((dz6) roVar).t(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
