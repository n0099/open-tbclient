package d.a.n0.b1.e.d;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import java.util.List;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.DislikeReason;
import tbclient.RecomVertical.ThreadPersonalized;
/* loaded from: classes4.dex */
public class a {
    public static void a(DataRes dataRes, List<n> list) {
        d.a.n0.z.e0.b bVar;
        a2 i2;
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
        for (int i3 = 0; i3 < count; i3++) {
            n nVar = (n) ListUtils.getItem(list, i3);
            if ((nVar instanceof d.a.n0.z.e0.b) && (i2 = (bVar = (d.a.n0.z.e0.b) nVar).i()) != null && (threadPersonalized = (ThreadPersonalized) longSparseArray.get(d.a.c.e.m.b.f(i2.z1(), 0L))) != null) {
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

    public static void b(DataRes dataRes, List<n> list) {
        a(dataRes, list);
    }
}
