package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class KsToastView extends LinearLayout {
    public TextView Bc;
    public String Bd;
    public Runnable Be;
    public int countDown;

    public KsToastView(Context context) {
        super(context);
        this.countDown = 3;
        this.Bd = "%ss后自动进入";
        this.Be = null;
        init(context);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.countDown;
        ksToastView.countDown = i - 1;
        return i;
    }

    private void init(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04e7, this);
        this.Bc = (TextView) findViewById(R.id.obfuscated_res_0x7f0914e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.Bc.setText(String.format(this.Bd, Integer.valueOf(i)));
    }

    public final void U(int i) {
        if (this.Be == null) {
            this.Be = new Runnable() { // from class: com.kwad.components.ad.reward.widget.KsToastView.1
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
        post(this.Be);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 3;
        this.Bd = "%ss后自动进入";
        this.Be = null;
        init(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 3;
        this.Bd = "%ss后自动进入";
        this.Be = null;
        init(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.countDown = 3;
        this.Bd = "%ss后自动进入";
        this.Be = null;
        init(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Be);
    }
}
