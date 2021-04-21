package d.b.j0.r1.h.d;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView;
import d.b.i0.w.m;
/* loaded from: classes3.dex */
public class b extends m {
    public b(Context context) {
        super(context, null, 18, 0);
        this.f52285b = TbadkCoreApplication.getInst().getResources().getString(R.string.member);
        this.k = new PrivilegeDeskView(context);
        this.m = true;
        this.f52290g = false;
        this.f52291h = true;
        this.f52287d = R.drawable.icon_pure_post_vip24;
        this.f52288e = R.drawable.icon_pure_post_vip24_selection;
        this.l = 6;
        this.n = new int[]{1};
    }
}
