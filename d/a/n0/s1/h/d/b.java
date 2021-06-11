package d.a.n0.s1.h.d;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.privilegetool.PrivilegeDeskView;
import d.a.m0.w.m;
/* loaded from: classes3.dex */
public class b extends m {
    public b(Context context) {
        super(context, null, 18, 0);
        this.f54525b = TbadkCoreApplication.getInst().getResources().getString(R.string.member);
        this.k = new PrivilegeDeskView(context);
        this.m = true;
        this.f54530g = false;
        this.f54531h = true;
        this.f54527d = R.drawable.icon_pure_post_vip24;
        this.f54528e = R.drawable.icon_pure_post_vip24_selection;
        this.l = 6;
        this.n = new int[]{1};
    }
}
