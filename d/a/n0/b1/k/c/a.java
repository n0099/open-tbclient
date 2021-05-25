package d.a.n0.b1.k.c;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes4.dex */
public class a {
    public static void a(List<ThreadPersonalized> list, List<n> list2) {
        d.a.n0.z.e0.b bVar;
        a2 m;
        ThreadPersonalized threadPersonalized;
        if (list == null || list2 == null) {
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
            if ((nVar instanceof d.a.n0.z.e0.b) && (m = (bVar = (d.a.n0.z.e0.b) nVar).m()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(m.y1())) != null) {
                bVar.V(threadPersonalized.source);
                bVar.Y(threadPersonalized.weight);
                bVar.R(threadPersonalized.abtest_tag);
                m.U0 = threadPersonalized.abtest_tag;
                m.S0 = threadPersonalized.source;
                m.T0 = threadPersonalized.weight;
                if (m.w1() != null) {
                    bVar.T(m.w1().is_vertical);
                }
                List<DislikeReason> list3 = threadPersonalized.dislike_resource;
                if (list3 != null) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeReason dislikeReason : list3) {
                        int intValue = dislikeReason.dislike_id.intValue();
                        sparseArray.put(intValue, dislikeReason.dislike_reason + "%" + dislikeReason.extra);
                    }
                    bVar.feedBackReasonMap = sparseArray;
                    bVar.S(threadPersonalized.extra);
                }
            }
        }
    }

    public static void b(List<ThreadPersonalized> list, List<n> list2) {
        a(list, list2);
    }
}
