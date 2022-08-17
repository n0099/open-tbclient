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
public class r07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<on> list) {
        f06 f06Var;
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
            on onVar = (on) ListUtils.getItem(list, i);
            if ((onVar instanceof f06) && (threadData = (f06Var = (f06) onVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(og.g(threadData.getTid(), 0L))) != null) {
                f06Var.J(threadPersonalized.source);
                f06Var.M(threadPersonalized.weight);
                f06Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    f06Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    f06Var.feedBackReasonMap = sparseArray;
                    f06Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<on> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            on onVar = (on) ListUtils.getItem(list, i);
            boolean z = onVar instanceof u06;
            if (z) {
                ((u06) onVar).d(true);
            }
            i++;
            on onVar2 = (on) ListUtils.getItem(list, i);
            if (z && (onVar2 instanceof u06)) {
                u06 u06Var = (u06) onVar;
                u06 u06Var2 = (u06) onVar2;
                if (u06Var.m()) {
                    u06Var2.d(false);
                    if (u06Var2 instanceof y07) {
                        u06Var.u(false);
                    }
                }
            }
            if (onVar instanceof y07) {
                ((y07) onVar).u(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
