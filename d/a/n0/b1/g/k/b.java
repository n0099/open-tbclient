package d.a.n0.b1.g.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.z.e0.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes4.dex */
public class b {
    public static void a(DataRes.Builder builder, List<n> list) {
        d.a.n0.z.e0.b bVar;
        a2 m;
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
        for (int i2 = 0; i2 < count; i2++) {
            n nVar = (n) ListUtils.getItem(list, i2);
            if ((nVar instanceof d.a.n0.z.e0.b) && (m = (bVar = (d.a.n0.z.e0.b) nVar).m()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.a.c.e.m.b.f(m.y1(), 0L))) != null) {
                bVar.V(threadPersonalized.source);
                bVar.Y(threadPersonalized.weight);
                bVar.R(threadPersonalized.abtest_tag);
                m.U0 = threadPersonalized.abtest_tag;
                m.S0 = threadPersonalized.source;
                m.T0 = threadPersonalized.weight;
                if (m.w1() != null) {
                    bVar.T(m.w1().is_vertical);
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
                if (pVar.g()) {
                    pVar2.a(false);
                    if (pVar2 instanceof d.a.n0.b1.g.l.b) {
                        pVar.n(false);
                    }
                }
            }
            if (nVar instanceof d.a.n0.b1.g.l.b) {
                ((d.a.n0.b1.g.l.b) nVar).n(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<n> list) {
        b(list);
        a(builder, list);
    }
}
