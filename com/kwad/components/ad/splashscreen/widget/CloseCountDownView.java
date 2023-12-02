package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class CloseCountDownView extends LinearLayout {
    public a EH;
    public String FI;
    public int FJ;
    public TextView FK;
    public TextView FL;
    public ImageView FM;
    public Runnable FN;
    public boolean nC;

    /* loaded from: classes10.dex */
    public interface a {
        void df();

        void kU();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.FI = "%ss";
        this.FJ = 5;
        this.nC = false;
        this.FN = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nC) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.FJ > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FJ);
                    CloseCountDownView.d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.EH != null) {
                    CloseCountDownView.this.EH.kU();
                }
            }
        };
        V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i) {
        this.FK.setText(String.format(this.FI, Integer.valueOf(i)));
    }

    public static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.FJ;
        closeCountDownView.FJ = i - 1;
        return i;
    }

    public void setOnViewClickListener(a aVar) {
        this.EH = aVar;
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FI = "%ss";
        this.FJ = 5;
        this.nC = false;
        this.FN = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nC) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.FJ > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FJ);
                    CloseCountDownView.d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.EH != null) {
                    CloseCountDownView.this.EH.kU();
                }
            }
        };
        V(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FI = "%ss";
        this.FJ = 5;
        this.nC = false;
        this.FN = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nC) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.FJ > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FJ);
                    CloseCountDownView.d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.EH != null) {
                    CloseCountDownView.this.EH.kU();
                }
            }
        };
        V(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.FI = "%ss";
        this.FJ = 5;
        this.nC = false;
        this.FN = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nC) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                } else if (CloseCountDownView.this.FJ > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FJ);
                    CloseCountDownView.d(CloseCountDownView.this);
                } else if (CloseCountDownView.this.EH != null) {
                    CloseCountDownView.this.EH.kU();
                }
            }
        };
        V(context);
    }

    private void V(Context context) {
        setOrientation(0);
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04c5, this);
        this.FK = (TextView) findViewById(R.id.obfuscated_res_0x7f0912ed);
        this.FL = (TextView) findViewById(R.id.obfuscated_res_0x7f0912eb);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914c1);
        this.FM = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (CloseCountDownView.this.EH != null) {
                    CloseCountDownView.this.EH.df();
                }
            }
        });
    }

    private void eE() {
        post(this.FN);
    }

    private void eF() {
        this.nC = true;
    }

    private void eG() {
        this.nC = false;
    }

    public final void aM() {
        eG();
    }

    public final void aN() {
        eF();
    }

    public final void bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public final void a(AdInfo adInfo) {
        boolean ck = com.kwad.sdk.core.response.b.a.ck(adInfo);
        this.FJ = com.kwad.sdk.core.response.b.a.cj(adInfo);
        if (ck) {
            this.FK.setVisibility(0);
            this.FL.setVisibility(0);
            ab(this.FJ);
            setPadding(com.kwad.sdk.d.a.a.a(getContext(), 12.0f), 0, com.kwad.sdk.d.a.a.a(getContext(), 12.0f), 0);
        } else {
            setPadding(com.kwad.sdk.d.a.a.a(getContext(), 4.0f), 0, com.kwad.sdk.d.a.a.a(getContext(), 4.0f), 0);
        }
        eE();
    }
}
