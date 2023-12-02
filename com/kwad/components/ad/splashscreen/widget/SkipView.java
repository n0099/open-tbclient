package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.m.l;
/* loaded from: classes10.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.a {
    public a FC;
    public Runnable FN;
    public final b GV;
    public View GW;
    public TextView GX;
    public TextView GY;
    public int GZ;
    public boolean nC;
    public boolean sA;

    /* loaded from: classes10.dex */
    public interface a {
        void Y(int i);

        void kT();

        void kU();
    }

    /* loaded from: classes10.dex */
    public static class b {
        public int FJ;
        public String Hb;
        public String Hc;
        public int Hd;
        public boolean He;
        public boolean Hf;

        public b() {
            this.Hb = "跳过";
            this.Hc = "";
            this.Hd = 5;
            this.FJ = 5;
            this.He = true;
            this.Hf = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean lT() {
            if (this.He && this.Hf) {
                return true;
            }
            return false;
        }

        public final String lR() {
            int i = this.FJ;
            if (i < 0) {
                return this.Hc;
            }
            if (i == 0) {
                return this.Hc + 1;
            }
            return this.Hc + this.FJ;
        }

        public final boolean lS() {
            if (this.FJ <= 0) {
                return true;
            }
            return false;
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static /* synthetic */ int d(b bVar) {
            int i = bVar.FJ;
            bVar.FJ = i - 1;
            return i;
        }

        public final void W(String str) {
            this.FJ = -1;
            this.Hc = str;
        }

        public final void ad(int i) {
            this.Hd = i;
            this.FJ = i;
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cw(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i) {
        a aVar = this.FC;
        if (aVar != null) {
            aVar.Y(i);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void A(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            eF();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void B(AdInfo adInfo) {
        if (this.sA) {
            lQ();
        }
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            eG();
        }
    }

    public final void W(String str) {
        if (str == null) {
            return;
        }
        this.GV.W(str);
        a(this.GV);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int aa(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.d.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.GZ = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(a aVar) {
        this.FC = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.GV.He = z;
        a(this.GV);
    }

    public void setSkipText(String str) {
        this.GV.Hb = str;
        a(this.GV);
    }

    public void setTimerBtnVisible(boolean z) {
        this.GV.Hf = z;
        a(this.GV);
    }

    public void setTimerPrefixText(String str) {
        this.GV.Hc = str;
        a(this.GV);
    }

    public void setTimerSecond(int i) {
        this.GV.ad(i);
        a(this.GV);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.GV = new b((byte) 0);
        this.GZ = -1;
        this.nC = false;
        this.sA = true;
        this.FN = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.nC) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.GV);
                SkipView skipView2 = SkipView.this;
                skipView2.X(skipView2.GV.Hd - SkipView.this.GV.FJ);
                if (!SkipView.this.GV.lS()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.GV);
                } else if (SkipView.this.FC != null) {
                    SkipView.this.FC.kU();
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        int i;
        int i2;
        if (bVar == null) {
            return;
        }
        int i3 = 0;
        if (this.GX != null) {
            if (bVar.Hb != null) {
                this.GX.setText(bVar.Hb);
            }
            if (this.GV.He) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            this.GX.setVisibility(i2);
        }
        String lR = bVar.lR();
        TextView textView = this.GY;
        if (textView != null) {
            if (lR != null) {
                textView.setText(lR);
            }
            if (this.GV.Hf) {
                i = 0;
            } else {
                i = 8;
            }
            this.GY.setVisibility(i);
        }
        if (this.GW != null) {
            boolean lT = this.GV.lT();
            if (!lT) {
                i3 = 8;
            }
            this.GW.setVisibility(i3);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!lT) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i4 = this.GZ;
                if (i4 > 0) {
                    layoutParams.width = i4;
                    invalidate();
                }
            }
        }
    }

    private void eE() {
        a(this.GV);
        post(this.FN);
    }

    private void eF() {
        this.nC = true;
    }

    private void eG() {
        this.nC = false;
    }

    private void lQ() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    private void init() {
        setOrientation(0);
        l.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0513, this);
        this.GX = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ab);
        this.GY = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ac);
        this.GW = findViewById(R.id.obfuscated_res_0x7f0914aa);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (SkipView.this.FC != null) {
                    SkipView.this.FC.kT();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sA = com.kwad.sdk.core.response.b.a.cv(adInfo);
        setTimerPrefixText(d.a(com.kwad.components.ad.splashscreen.b.a.CM));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bc(adInfo)) {
            eE();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.ch(adInfo));
        setVisibility(8);
        C(adInfo);
    }
}
