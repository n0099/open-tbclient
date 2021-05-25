package d.a.n0.s1.h.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.tool.TailToolController;
import d.a.m0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context, int i2) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i2);
        this.f50850d = R.drawable.icon_pure_post_vip24;
        this.f50852f = R.drawable.icon_pure_post_more_tail64;
        this.f50853g = false;
        this.f50854h = true;
        this.k = new TailToolController(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
