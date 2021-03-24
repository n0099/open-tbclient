package d.b.i0.q1.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class b extends m {
    public b(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        int i;
        try {
            i = R.drawable.icon_pure_post_bubble24;
        } catch (NoSuchFieldError e2) {
            BdLog.e(e2.getMessage());
            i = 0;
        }
        this.f51532d = i;
        this.f51534f = R.drawable.icon_pure_post_more_bubble64;
        this.f51535g = false;
        this.f51536h = true;
        this.m = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.k = commonTabHost;
        commonTabHost.k(new a());
        this.l = 6;
        this.n = new int[]{1};
    }
}
