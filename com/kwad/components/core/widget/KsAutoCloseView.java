package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    public static String wD = "%s秒后自动关闭";
    public TextView Pr;
    public ImageView Ps;
    public a Pt;
    public boolean Pu;
    public boolean Pv;
    public int countDown;

    /* loaded from: classes9.dex */
    public interface a {
        void dg();

        void dh();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.Pu = true;
        this.Pv = false;
        L(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.Pu = true;
        this.Pv = false;
        L(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.Pu = true;
        this.Pv = false;
        L(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.Pu = true;
        this.Pv = false;
        L(context);
    }

    private void L(Context context) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0476, this);
        this.Pr = (TextView) findViewById(R.id.obfuscated_res_0x7f09123e);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09123d);
        this.Ps = imageView;
        imageView.setOnClickListener(this);
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.Pr.setText(String.format(wD, Integer.valueOf(i)));
    }

    public final void U(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new Runnable() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (KsAutoCloseView.this.Pu) {
                    if (!KsAutoCloseView.this.Pv) {
                        if (KsAutoCloseView.this.countDown == 0) {
                            if (KsAutoCloseView.this.Pt != null) {
                                KsAutoCloseView.this.Pt.dg();
                                return;
                            }
                            return;
                        }
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.x(ksAutoCloseView.countDown);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public final void aG(boolean z) {
        this.Pu = z;
        int i = z ? 0 : 8;
        TextView textView = this.Pr;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.Pt != null && view2.equals(this.Ps)) {
            this.Pt.dh();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.Pv = z;
    }

    public void setViewListener(a aVar) {
        this.Pt = aVar;
    }
}
