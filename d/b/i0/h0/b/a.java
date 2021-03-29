package d.b.i0.h0.b;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.emotion.editortool.EmotionTabHost;
import d.b.h0.w.m;
/* loaded from: classes4.dex */
public class a extends m {
    public a(Context context, int i, boolean z) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.f51533d = R.drawable.icon_pure_post_expression24;
        this.f51534e = R.drawable.icon_pure_post_expression24_selection;
        this.f51535f = R.drawable.icon_pure_post_expression64_big;
        this.f51536g = false;
        this.f51537h = true;
        EmotionTabHost emotionTabHost = new EmotionTabHost(context);
        emotionTabHost.setShowBigEmotion(z);
        this.k = emotionTabHost;
        this.m = true;
        this.l = 6;
        this.n = new int[]{1, 34, 35};
    }

    @Override // d.b.h0.w.m
    public void f(boolean z) {
        ((EmotionTabHost) this.k).setShowUserCollect(z);
    }

    public a(Context context, int i) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.editor_express), 5, i);
        this.f51533d = R.drawable.icon_pure_post_expression24;
        this.f51534e = R.drawable.icon_pure_post_expression24_selection;
        this.f51535f = R.drawable.icon_pure_post_expression64_big;
        this.f51536g = false;
        this.f51537h = true;
        this.k = new EmotionTabHost(context);
        this.m = true;
        this.l = 6;
        this.n = new int[]{1, 34, 35};
    }
}
