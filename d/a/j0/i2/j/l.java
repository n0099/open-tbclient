package d.a.j0.i2.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class l extends d.a.i0.d0.c {
    public static final int j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds403);
    public static final int k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds90);

    public l(Context context, View.OnClickListener onClickListener) {
        super(context, onClickListener);
        g();
    }

    public final void g() {
        TbImageView tbImageView = this.f48398c;
        if (tbImageView == null || !(tbImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f48398c.getLayoutParams();
        int i2 = j;
        layoutParams.width = i2;
        layoutParams.height = i2;
        layoutParams.topMargin = k;
        this.f48398c.setLayoutParams(layoutParams);
    }
}
