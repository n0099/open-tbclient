package d.b.i0.r1.h.d;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class b extends m {
    public b(Context context) {
        super(context, null, 18, 0);
        this.f51949b = TbadkCoreApplication.getInst().getResources().getString(R.string.member);
        this.k = new PrivilegeDeskView(context);
        this.m = true;
        this.f51954g = false;
        this.f51955h = true;
        this.f51951d = R.drawable.icon_pure_post_vip24;
        this.f51952e = R.drawable.icon_pure_post_vip24_selection;
        this.l = 6;
        this.n = new int[]{1};
    }
}
