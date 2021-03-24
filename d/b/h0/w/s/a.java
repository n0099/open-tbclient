package d.b.h0.w.s;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.inputtool.InputView;
import com.baidu.tieba.R;
import d.b.h0.w.m;
/* loaded from: classes3.dex */
public class a extends m {
    public static final int[] r = {4, 17, 24, 3, 9, 6, 44};
    public InputView q;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        g(context, z);
    }

    public final void g(Context context, boolean z) {
        this.m = false;
        this.l = 2;
        this.n = r;
        InputView inputView = new InputView(context, z);
        this.q = inputView;
        this.k = inputView;
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        ((LinearLayout.LayoutParams) layoutParams).leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds30);
        ((LinearLayout.LayoutParams) layoutParams).rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
        ((View) this.k).setLayoutParams(layoutParams);
    }

    public void h(boolean z) {
        ((InputView) this.k).setIsOnlyLocalEmotion(z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        g(context, z);
        InputView inputView = this.q;
        if (inputView != null) {
            inputView.setNeedFaceMaxCount(z2);
        }
    }
}
