package d.a.j0.w.x;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.sendtool.SendView;
import d.a.j0.w.m;
import d.a.j0.w.n;
/* loaded from: classes3.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 4);
        this.m = false;
        this.l = 2;
        this.n = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.k = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
        ((View) this.k).setLayoutParams(layoutParams);
    }

    public void g(int i2) {
        n nVar = this.k;
        if (nVar == null || !(nVar instanceof TextView)) {
            return;
        }
        ((TextView) nVar).setText(i2);
    }

    public void h(@ColorRes int i2) {
        n nVar = this.k;
        if (nVar != null) {
            ((SendView) nVar).setTextColor(i2);
        }
    }
}
