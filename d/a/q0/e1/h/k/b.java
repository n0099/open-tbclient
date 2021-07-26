package d.a.q0.e1.h.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.a0.e0.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(DataRes.Builder builder, List<n> list) {
        d.a.q0.a0.e0.b bVar;
        b2 threadData;
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
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list, i2);
            if ((nVar instanceof d.a.q0.a0.e0.b) && (threadData = (bVar = (d.a.q0.a0.e0.b) nVar).getThreadData()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.a.d.e.m.b.f(threadData.o1(), 0L))) != null) {
                bVar.J(threadPersonalized.source);
                bVar.M(threadPersonalized.weight);
                bVar.F(threadPersonalized.abtest_tag);
                threadData.V0 = threadPersonalized.abtest_tag;
                threadData.T0 = threadPersonalized.source;
                threadData.U0 = threadPersonalized.weight;
                if (threadData.m1() != null) {
                    bVar.H(threadData.m1().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.G(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i2 = 0;
        while (i2 < count) {
            n nVar = (n) ListUtils.getItem(list, i2);
            boolean z = nVar instanceof p;
            if (z) {
                ((p) nVar).a(true);
            }
            i2++;
            n nVar2 = (n) ListUtils.getItem(list, i2);
            if (z && (nVar2 instanceof p)) {
                p pVar = (p) nVar;
                p pVar2 = (p) nVar2;
                if (pVar.k()) {
                    pVar2.a(false);
                    if (pVar2 instanceof d.a.q0.e1.h.l.b) {
                        pVar.r(false);
                    }
                }
            }
            if (nVar instanceof d.a.q0.e1.h.l.b) {
                ((d.a.q0.e1.h.l.b) nVar).r(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, builder, list) == null) {
            b(list);
            a(builder, list);
        }
    }
}
