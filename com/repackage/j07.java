package com.repackage;

import android.util.SparseArray;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes6.dex */
public class j07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<jn> list2) {
        rw5 rw5Var;
        ThreadData threadData;
        ThreadPersonalized threadPersonalized;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, list, list2) == null) || list == null || list2 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ThreadPersonalized threadPersonalized2 : list) {
            if (threadPersonalized2 != null) {
                hashMap.put(String.valueOf(threadPersonalized2.tid), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list2);
        for (int i = 0; i < count; i++) {
            jn jnVar = (jn) ListUtils.getItem(list2, i);
            if ((jnVar instanceof rw5) && (threadData = (rw5Var = (rw5) jnVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.getTid())) != null) {
                rw5Var.J(threadPersonalized.source);
                rw5Var.M(threadPersonalized.weight);
                rw5Var.F(threadPersonalized.abtest_tag);
                threadData.mRecomAbTag = threadPersonalized.abtest_tag;
                threadData.mRecomSource = threadPersonalized.source;
                threadData.mRecomWeight = threadPersonalized.weight;
                if (threadData.getThreadVideoInfo() != null) {
                    rw5Var.H(threadData.getThreadVideoInfo().is_vertical);
                }
                List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                if (list3 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list3) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    rw5Var.feedBackReasonMap = sparseArray;
                    rw5Var.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<jn> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
