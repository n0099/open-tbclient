package d.b.i0.q1.h.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.tool.TailToolController;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        this.f51532d = R.drawable.icon_pure_post_vip24;
        this.f51534f = R.drawable.icon_pure_post_more_tail64;
        this.f51535g = false;
        this.f51536h = true;
        this.k = new TailToolController(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
