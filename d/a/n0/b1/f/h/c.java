package d.a.n0.b1.f.h;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.MoreTreasureTrove.DataRes;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {
    public static List<n> a(List<ThreadInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (ThreadInfo threadInfo : list) {
            a2 a2Var = new a2();
            a2Var.U2(threadInfo);
            a2Var.a2 = true;
            arrayList.add(a2Var);
        }
        return d.a.n0.b1.e.a.c.a(arrayList);
    }

    public static List<n> b(MoreTreasureTroveResIdl moreTreasureTroveResIdl) {
        DataRes dataRes;
        if (moreTreasureTroveResIdl == null || (dataRes = moreTreasureTroveResIdl.data) == null || ListUtils.isEmpty(dataRes.hot_thread_info)) {
            return null;
        }
        return a(moreTreasureTroveResIdl.data.hot_thread_info);
    }
}
