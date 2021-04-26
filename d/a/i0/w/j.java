package d.a.i0.w;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.MoreDeskView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class j extends m {
    public j(Context context) {
        super(context, null, 2, 0);
        this.f49956b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.f49958d = R.drawable.icon_pure_post_more24;
        this.f49959e = R.drawable.icon_mask_post_more24_selection;
        this.f49961g = false;
        this.f49962h = true;
        this.k = new MoreDeskView(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }

    public j(Context context, boolean z) {
        super(context, null, 2, 0);
        this.f49956b = TbadkCoreApplication.getInst().getString(R.string.more_function);
        this.f49958d = R.drawable.icon_pure_post_more24;
        this.f49959e = R.drawable.icon_mask_post_more24_selection;
        this.f49961g = false;
        this.f49962h = true;
        this.k = new MoreDeskView(context, !z);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1};
    }
}
