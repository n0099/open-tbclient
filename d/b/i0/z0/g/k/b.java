package d.b.i0.z0.g.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.x.e0.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes3.dex */
public class b {
    public static void a(DataRes.Builder builder, List<n> list) {
        d.b.i0.x.e0.b bVar;
        a2 n;
        ThreadPersonalized threadPersonalized;
        if (builder == null || list == null) {
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
            n nVar = (n) ListUtils.getItem(list, i);
            if ((nVar instanceof d.b.i0.x.e0.b) && (n = (bVar = (d.b.i0.x.e0.b) nVar).n()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.b.b.e.m.b.f(n.w1(), 0L))) != null) {
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

    public static void b(List<n> list) {
        if (list == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        int i = 0;
        while (i < count) {
            n nVar = (n) ListUtils.getItem(list, i);
            boolean z = nVar instanceof p;
            if (z) {
                ((p) nVar).b(true);
            }
            i++;
            n nVar2 = (n) ListUtils.getItem(list, i);
            if (z && (nVar2 instanceof p)) {
                p pVar = (p) nVar;
                p pVar2 = (p) nVar2;
                if (pVar.m()) {
                    pVar2.b(false);
                    if (pVar2 instanceof d.b.i0.z0.g.l.b) {
                        pVar.h(false);
                    }
                }
            }
            if (nVar instanceof d.b.i0.z0.g.l.b) {
                ((d.b.i0.z0.g.l.b) nVar).h(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<n> list) {
        b(list);
        a(builder, list);
    }
}
