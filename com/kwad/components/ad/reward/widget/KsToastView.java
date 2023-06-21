package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class KsToastView extends LinearLayout {
    public int countDown;
    public TextView wC;
    public String wD;
    public Runnable wE;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.wD = "%ss后自动进入";
        this.wE = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.wD = "%ss后自动进入";
        this.wE = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.wD = "%ss后自动进入";
        this.wE = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.wD = "%ss后自动进入";
        this.wE = null;
        init(context);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    private void init(Context context) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04a1, this);
        this.wC = (TextView) findViewById(R.id.obfuscated_res_0x7f0913e0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.wC.setText(String.format(this.wD, Integer.valueOf(i)));
    }

    public final void U(int i) {
        if (this.wE == null) {
            this.wE = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (KsToastView.this.countDown == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.x(ksToastView.countDown);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.countDown = 3;
        post(this.wE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.wE);
    }
}
