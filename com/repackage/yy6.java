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
public class yy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<nn> list) {
        ny5 ny5Var;
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
            if ((nnVar instanceof ny5) && (threadData = (ny5Var = (ny5) nnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(ng.g(threadData.getTid(), 0L))) != null) {
                ny5Var.J(threadPersonalized.source);
                ny5Var.M(threadPersonalized.weight);
                ny5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    ny5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    ny5Var.feedBackReasonMap = sparseArray;
                    ny5Var.G(threadPersonalized.extra);
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
            boolean z = nnVar instanceof cz5;
            if (z) {
                ((cz5) nnVar).e(true);
            }
            i++;
            nn nnVar2 = (nn) ListUtils.getItem(list, i);
            if (z && (nnVar2 instanceof cz5)) {
                cz5 cz5Var = (cz5) nnVar;
                cz5 cz5Var2 = (cz5) nnVar2;
                if (cz5Var.n()) {
                    cz5Var2.e(false);
                    if (cz5Var2 instanceof fz6) {
                        cz5Var.v(false);
                    }
                }
            }
            if (nnVar instanceof fz6) {
                ((fz6) nnVar).v(false);
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
