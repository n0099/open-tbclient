package d.b.h0.w;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.MoreDeskView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.f51531b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.f51533d = R.drawable.icon_pure_post_more24;
        this.f51534e = R.drawable.icon_mask_post_more24_selection;
        this.f51536g = false;
        this.f51537h = true;
        this.k = new MoreDeskView(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.f51531b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.f51533d = R.drawable.icon_pure_post_more24;
        this.f51534e = R.drawable.icon_mask_post_more24_selection;
        this.f51536g = false;
        this.f51537h = true;
        this.k = new MoreDeskView(context, !z);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
