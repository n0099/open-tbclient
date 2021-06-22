package d.a.o0.s1.b;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import d.a.n0.w.m;
/* loaded from: classes4.dex */
public class b extends m {
    public b(Context context) {
        super(context, context.getString(R.string.editor_privilege), 12);
        int i2;
        try {
            i2 = R.drawable.icon_pure_post_bubble24;
        } catch (NoSuchFieldError e2) {
            BdLog.e(e2.getMessage());
            i2 = 0;
        }
        this.f54634d = i2;
        this.f54636f = R.drawable.icon_pure_post_more_bubble64;
        this.f54637g = false;
        this.f54638h = true;
        this.m = true;
        CommonTabHost commonTabHost = new CommonTabHost(context);
        this.k = commonTabHost;
        commonTabHost.k(new a());
        this.l = 6;
        this.n = new int[]{1};
    }
}
