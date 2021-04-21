package d.b.j0.r1.h.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.tool.TailToolController;
import d.b.i0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i);
        this.f52287d = R.drawable.icon_pure_post_vip24;
        this.f52289f = R.drawable.icon_pure_post_more_tail64;
        this.f52290g = false;
        this.f52291h = true;
        this.k = new TailToolController(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
