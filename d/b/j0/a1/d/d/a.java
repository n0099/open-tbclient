package d.b.j0.a1.d.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes4.dex */
public class a {
    public static void a(DataRes dataRes, List<n> list) {
        d.b.j0.x.e0.b bVar;
        a2 n;
        ThreadPersonalized threadPersonalized;
        if (dataRes == null || list == null) {
            return;
        }
        LongSparseArray longSparseArray = new LongSparseArray();
        for (ThreadPersonalized threadPersonalized2 : dataRes.thread_personalized) {
            if (threadPersonalized2 != null) {
                longSparseArray.put(threadPersonalized2.tid.longValue(), threadPersonalized2);
            }
        }
        int count = ListUtils.getCount(list);
        for (int i = 0; i < count; i++) {
            n nVar = (n) ListUtils.getItem(list, i);
            if ((nVar instanceof d.b.j0.x.e0.b) && (n = (bVar = (d.b.j0.x.e0.b) nVar).n()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.b.c.e.m.b.f(n.w1(), 0L))) != null) {
                bVar.V(threadPersonalized.source);
                bVar.Y(threadPersonalized.weight);
                bVar.R(threadPersonalized.abtest_tag);
                n.T0 = threadPersonalized.abtest_tag;
                n.R0 = threadPersonalized.source;
                n.S0 = threadPersonalized.weight;
                if (n.u1() != null) {
                    bVar.T(n.u1().is_vertical);
                }
                List<DislikeReason> list2 = threadPersonalized.dislike_resource;
                if (list2 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list2) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.S(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(DataRes dataRes, List<n> list) {
        a(dataRes, list);
    }
}
