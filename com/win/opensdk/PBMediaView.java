package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.win.opensdk.d;
/* loaded from: classes3.dex */
public class PBMediaView extends FrameLayout {
    private Context pYI;
    private bw pYP;

    public PBMediaView(Context context) {
        this(context, null);
    }

    public PBMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pYI = context;
        this.pYP = new bw(context);
        addView(this.pYP.qal, new FrameLayout.LayoutParams(-1, -1));
        try {
            ImageView imageView = new ImageView(context);
            int k = bi.k(context, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
            layoutParams.gravity = 3;
            imageView.setImageResource(d.a.btn_op);
            addView(imageView, layoutParams);
        } catch (Exception e) {
        }
    }

    public bw getHtmlWebView() {
        return this.pYP;
    }
}
