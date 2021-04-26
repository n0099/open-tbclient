package d.a.j0.r1.h.e;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.tool.TailToolController;
import d.a.i0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context, int i2) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title), 16, i2);
        this.f49958d = R.drawable.icon_pure_post_vip24;
        this.f49960f = R.drawable.icon_pure_post_more_tail64;
        this.f49961g = false;
        this.f49962h = true;
        this.k = new TailToolController(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
