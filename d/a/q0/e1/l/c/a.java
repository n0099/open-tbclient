package d.a.q0.e1.l.c;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<ThreadPersonalized> list, List<n> list2) {
        d.a.q0.a0.e0.b bVar;
        b2 threadData;
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
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list2, i2);
            if ((nVar instanceof d.a.q0.a0.e0.b) && (threadData = (bVar = (d.a.q0.a0.e0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(threadData.o1())) != null) {
                bVar.J(threadPersonalized.source);
                bVar.M(threadPersonalized.weight);
                bVar.F(threadPersonalized.abtest_tag);
                threadData.V0 = threadPersonalized.abtest_tag;
                threadData.T0 = threadPersonalized.source;
                threadData.U0 = threadPersonalized.weight;
                if (threadData.m1() != null) {
                    bVar.H(threadData.m1().is_vertical);
                }
                List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                if (list3 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list3) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, list, list2) == null) {
            a(list, list2);
        }
    }
}
