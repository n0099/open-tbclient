package d.b.i0.z0.k.c;

import android.util.SparseArray;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import java.util.HashMap;
import java.util.List;
import tbclient.RecomVideo.DislikeReason;
import tbclient.RecomVideo.ThreadPersonalized;
/* loaded from: classes3.dex */
public class a {
    public static void a(List<ThreadPersonalized> list, List<n> list2) {
        d.b.i0.x.e0.b bVar;
        a2 n;
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
        for (int i = 0; i < count; i++) {
            n nVar = (n) ListUtils.getItem(list2, i);
            if ((nVar instanceof d.b.i0.x.e0.b) && (n = (bVar = (d.b.i0.x.e0.b) nVar).n()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(n.w1())) != null) {
                bVar.V(threadPersonalized.source);
                bVar.Y(threadPersonalized.weight);
                bVar.R(threadPersonalized.abtest_tag);
                n.T0 = threadPersonalized.abtest_tag;
                n.R0 = threadPersonalized.source;
                n.S0 = threadPersonalized.weight;
                if (n.u1() != null) {
                    bVar.T(n.u1().is_vertical);
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
