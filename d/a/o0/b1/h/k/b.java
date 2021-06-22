package d.a.o0.b1.h.k;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.n0.r.q.a2;
import d.a.o0.z.e0.p;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.DislikeReason;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes4.dex */
public class b {
    public static void a(DataRes.Builder builder, List<n> list) {
        d.a.o0.z.e0.b bVar;
        a2 i2;
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
        for (int i3 = 0; i3 < count; i3++) {
            n nVar = (n) ListUtils.getItem(list, i3);
            if ((nVar instanceof d.a.o0.z.e0.b) && (i2 = (bVar = (d.a.o0.z.e0.b) nVar).i()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.a.c.e.m.b.f(i2.z1(), 0L))) != null) {
                bVar.V(threadPersonalized.source);
                bVar.Y(threadPersonalized.weight);
                bVar.R(threadPersonalized.abtest_tag);
                i2.V0 = threadPersonalized.abtest_tag;
                i2.T0 = threadPersonalized.source;
                i2.U0 = threadPersonalized.weight;
                if (i2.x1() != null) {
                    bVar.T(i2.x1().is_vertical);
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
                if (pVar.j()) {
                    pVar2.a(false);
                    if (pVar2 instanceof d.a.o0.b1.h.l.b) {
                        pVar.r(false);
                    }
                }
            }
            if (nVar instanceof d.a.o0.b1.h.l.b) {
                ((d.a.o0.b1.h.l.b) nVar).r(false);
            }
        }
    }

    public static void c(DataRes.Builder builder, List<n> list) {
        b(list);
        a(builder, list);
    }
}
