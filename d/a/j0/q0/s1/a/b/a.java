package d.a.j0.q0.s1.a.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.n0;
import d.a.j0.q0.s1.a.a.b;
import d.a.j0.q0.s1.a.d.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {
    public static List<e> a(List<GameForumSubTab> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GameForumSubTab gameForumSubTab : list) {
            e eVar = new e();
            if (gameForumSubTab != null) {
                eVar.f58749a = gameForumSubTab.id.intValue();
                eVar.f58750b = gameForumSubTab.sub_tab_name;
                LabelDataList labelDataList = new LabelDataList();
                labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                eVar.f58751c = labelDataList;
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    public static List<n> b(List<ThreadInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = new b();
            a2 a2Var = new a2();
            bVar.l(a2Var);
            a2Var.R2(list.get(i2));
            a2Var.V2();
            if (!TextUtils.isEmpty(a2Var.E0())) {
                n0 n0Var = new n0();
                n0Var.m(a2Var.E0());
                linkedList.add(n0Var);
            } else {
                linkedList.add(bVar);
            }
        }
        return linkedList;
    }
}
