package d.b.f.b;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.audiorecorder.lib.voice.SendVoiceView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import d.b.h0.w.m;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 6);
        this.f51531b = TbadkCoreApplication.getInst().getResources().getString(R.string.switch_to_voice);
        this.f51533d = R.drawable.icon_pure_post_speak24;
        this.f51536g = false;
        this.f51537h = true;
        this.m = true;
        this.l = 5;
        this.k = new SendVoiceView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        ((View) this.k).setLayoutParams(layoutParams);
        this.n = new int[0];
    }
}
