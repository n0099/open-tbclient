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
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    public static String Bd = "%s秒后自动关闭";
    public TextView abS;
    public ImageView abT;
    public a abU;
    public boolean abV;
    public boolean abW;
    public int countDown;

    /* loaded from: classes10.dex */
    public interface a {
        void de();

        void df();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.countDown = 10;
        this.abV = true;
        this.abW = false;
        P(context);
    }

    private void P(Context context) {
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04b4, this);
        this.abS = (TextView) findViewById(R.id.obfuscated_res_0x7f091316);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091315);
        this.abT = imageView;
        imageView.setOnClickListener(this);
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.countDown;
        ksAutoCloseView.countDown = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        this.abS.setText(String.format(Bd, Integer.valueOf(i)));
    }

    public final void U(int i) {
        if (i <= 0) {
            return;
        }
        this.countDown = i;
        post(new Runnable() { // from class: com.kwad.components.core.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!KsAutoCloseView.this.abV) {
                    return;
                }
                if (KsAutoCloseView.this.abW) {
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                } else if (KsAutoCloseView.this.countDown == 0) {
                    if (KsAutoCloseView.this.abU != null) {
                        KsAutoCloseView.this.abU.de();
                    }
                } else {
                    KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                    ksAutoCloseView.x(ksAutoCloseView.countDown);
                    KsAutoCloseView.e(KsAutoCloseView.this);
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public final void aX(boolean z) {
        int i;
        this.abV = z;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        TextView textView = this.abS;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.abU != null && view2.equals(this.abT)) {
            this.abU.df();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.abW = z;
    }

    public void setViewListener(a aVar) {
        this.abU = aVar;
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.countDown = 10;
        this.abV = true;
        this.abW = false;
        P(context);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.countDown = 10;
        this.abV = true;
        this.abW = false;
        P(context);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.countDown = 10;
        this.abV = true;
        this.abW = false;
        P(context);
    }
}
