package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ax;
/* loaded from: classes9.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    public a Ab;
    public final b Bn;
    public View Bo;
    public TextView Bp;
    public TextView Bq;
    public int Br;
    public Runnable Bs;
    public boolean kC;
    public Context mContext;
    public boolean pX;

    /* loaded from: classes9.dex */
    public interface a {
        void kb();

        void kc();
    }

    /* loaded from: classes9.dex */
    public static class b {
        public String Bu;
        public String Bv;
        public int Bw;
        public int Bx;
        public boolean By;
        public boolean Bz;

        public b() {
            this.Bu = "跳过";
            this.Bv = "";
            this.Bw = 5;
            this.Bx = 5;
            this.By = true;
            this.Bz = true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static /* synthetic */ int b(b bVar) {
            int i = bVar.Bx;
            bVar.Bx = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean kK() {
            return this.By && this.Bz;
        }

        public final void aa(int i) {
            this.Bw = i;
            this.Bx = i;
        }

        public final void ac(String str) {
            this.Bx = -1;
            this.Bv = str;
        }

        public final String kI() {
            StringBuilder sb;
            int i;
            int i2 = this.Bx;
            if (i2 < 0) {
                return this.Bv;
            }
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append(this.Bv);
                i = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.Bv);
                i = this.Bx;
            }
            sb.append(i);
            return sb.toString();
        }

        public final boolean kJ() {
            return this.Bx <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.kC) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Bn);
                if (!SkipView.this.Bn.kJ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.b(SkipView.this.Bn);
                } else if (SkipView.this.Ab != null) {
                    SkipView.this.Ab.kc();
                }
            }
        };
        ae(context);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.kC) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Bn);
                if (!SkipView.this.Bn.kJ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.b(SkipView.this.Bn);
                } else if (SkipView.this.Ab != null) {
                    SkipView.this.Ab.kc();
                }
            }
        };
        ae(context);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.kC) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Bn);
                if (!SkipView.this.Bn.kJ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.b(SkipView.this.Bn);
                } else if (SkipView.this.Ab != null) {
                    SkipView.this.Ab.kc();
                }
            }
        };
        ae(context);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Bn = new b((byte) 0);
        this.Br = -1;
        this.kC = false;
        this.pX = true;
        this.Bs = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.kC) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Bn);
                if (!SkipView.this.Bn.kJ()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.b(SkipView.this.Bn);
                } else if (SkipView.this.Ab != null) {
                    SkipView.this.Ab.kc();
                }
            }
        };
        ae(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.Bp != null) {
            if (bVar.Bu != null) {
                this.Bp.setText(bVar.Bu);
            }
            this.Bp.setVisibility(this.Bn.By ? 0 : 8);
        }
        String kI = bVar.kI();
        TextView textView = this.Bq;
        if (textView != null) {
            if (kI != null) {
                textView.setText(kI);
            }
            this.Bq.setVisibility(this.Bn.Bz ? 0 : 8);
        }
        if (this.Bo != null) {
            boolean kK = this.Bn.kK();
            this.Bo.setVisibility(kK ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!kK) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.Br;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    public static boolean a(SplashSkipViewModel splashSkipViewModel) {
        return splashSkipViewModel.needShowMiniWindow && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL());
    }

    private void ae(Context context) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04d1, this);
        this.mContext = context;
        this.Bp = (TextView) findViewById(R.id.obfuscated_res_0x7f0913cc);
        this.Bq = (TextView) findViewById(R.id.obfuscated_res_0x7f0913cd);
        this.Bo = findViewById(R.id.obfuscated_res_0x7f0913cb);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (SkipView.this.Ab != null) {
                    SkipView.this.Ab.kb();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void b(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        setTimerBtnVisible(a(splashSkipViewModel) ? false : com.kwad.sdk.core.response.a.a.bA(adInfo));
    }

    private void eA() {
        this.kC = true;
    }

    private void eB() {
        this.kC = false;
    }

    private void ez() {
        a(this.Bn);
        post(this.Bs);
    }

    private void kH() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int Y(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.mContext, 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        String bo;
        this.pX = com.kwad.sdk.core.response.a.a.bz(adInfo);
        setTimerPrefixText(com.kwad.components.ad.splashscreen.a.b.jQ());
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            ez();
        }
        if (!splashSkipViewModel.needShowMiniWindow || ax.dT(com.kwad.components.ad.splashscreen.a.b.jL())) {
            bo = com.kwad.sdk.core.response.a.a.bo(adInfo);
        } else {
            bo = com.kwad.components.ad.splashscreen.a.b.jL() + " " + com.kwad.components.ad.splashscreen.a.b.jP();
        }
        setSkipText(bo);
        setVisibility(8);
        b(splashSkipViewModel, adInfo);
    }

    public final void ac(String str) {
        if (str == null) {
            return;
        }
        this.Bn.ac(str);
        a(this.Bn);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bj() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void s(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            return;
        }
        eA();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.Br = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        this.Ab = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.Bn.By = z;
        a(this.Bn);
    }

    public void setSkipText(String str) {
        this.Bn.Bu = str;
        a(this.Bn);
    }

    public void setTimerBtnVisible(boolean z) {
        this.Bn.Bz = z;
        a(this.Bn);
    }

    public void setTimerPrefixText(String str) {
        this.Bn.Bv = str;
        a(this.Bn);
    }

    public void setTimerSecond(int i) {
        this.Bn.aa(i);
        a(this.Bn);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void t(AdInfo adInfo) {
        if (this.pX) {
            kH();
        }
        if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            return;
        }
        eB();
    }
}
