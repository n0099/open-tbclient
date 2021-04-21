package d.b.j0.c1.e;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.i0.r.q.a2;
/* loaded from: classes4.dex */
public class b {
    public static void a(a2 a2Var, String str, String str2, int i) {
        if (a2Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13022").param("obj_name", str).param("tid", a2Var.w1()).param("fid", a2Var.c0()).param("obj_source", a2Var.R0).param("obj_locate", str2).param("obj_type", i).param("ab_tag", a2Var.T0));
    }
}
