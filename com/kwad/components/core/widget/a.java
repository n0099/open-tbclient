package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class a extends KSFrameLayout implements br.a {
    public final View Ux;
    public InterfaceC0673a aaQ;
    public boolean aaR;
    public boolean aaS;
    public int aaT;
    public boolean aaU;
    public long aaV;
    public boolean aaW;
    public final float aaX;
    public final int aaY;
    public final br hh;

    /* renamed from: com.kwad.components.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0673a {
        void ac();

        void ad();

        void eo();

        void k(View view2);
    }

    public a(Context context, View view2) {
        super(context, view2);
        this.hh = new br(this);
        this.aaT = 5;
        this.Ux = view2;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float Bb = com.kwad.sdk.core.config.d.Bb();
        this.aaX = Bb;
        setVisiblePercent(Bb);
        float Bc = com.kwad.sdk.core.config.d.Bc();
        this.aaY = (int) ((Bc < 0.0f ? 1.0f : Bc) * 1000.0f);
    }

    private void sV() {
        InterfaceC0673a interfaceC0673a;
        if (this.aaY == 0 && (interfaceC0673a = this.aaQ) != null) {
            interfaceC0673a.k(this.Ux);
            return;
        }
        Message obtainMessage = this.hh.obtainMessage();
        obtainMessage.what = 2;
        this.hh.sendMessageDelayed(obtainMessage, this.aaY);
    }

    private void sW() {
        this.hh.removeCallbacksAndMessages(null);
        this.aaS = false;
    }

    private void sX() {
        if (!this.aaS) {
            this.aaS = true;
            this.hh.sendEmptyMessage(1);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.aaT = 5;
        this.aaR = false;
        this.aaU = false;
        sX();
        InterfaceC0673a interfaceC0673a = this.aaQ;
        if (interfaceC0673a != null) {
            interfaceC0673a.ac();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        sW();
        this.aaT = 0;
        this.aaV = 0L;
        this.aaR = true;
        InterfaceC0673a interfaceC0673a = this.aaQ;
        if (interfaceC0673a != null) {
            interfaceC0673a.ad();
        }
    }

    public final void sY() {
        sX();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void A(View view2) {
        InterfaceC0673a interfaceC0673a;
        InterfaceC0673a interfaceC0673a2;
        super.A(view2);
        if (this.aaY == 0 && (interfaceC0673a2 = this.aaQ) != null) {
            interfaceC0673a2.k(view2);
        } else if (!this.aaU) {
            this.aaU = true;
            this.aaV = System.currentTimeMillis();
            sW();
            sV();
        } else if (System.currentTimeMillis() - this.aaV > this.aaY && (interfaceC0673a = this.aaQ) != null) {
            interfaceC0673a.k(view2);
            sW();
        }
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (this.aaR) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                if (bq.a(this.Ux, (int) (this.aaX * 100.0f), false)) {
                    InterfaceC0673a interfaceC0673a = this.aaQ;
                    if (interfaceC0673a != null) {
                        interfaceC0673a.k(this.Ux);
                        return;
                    }
                    return;
                }
                this.aaT = 5;
                this.hh.sendEmptyMessage(1);
                return;
            }
            return;
        }
        com.kwad.sdk.core.e.c.d("AdExposureView", "handleMsg MSG_CHECKING");
        long j = 100;
        if (bq.a(this.Ux, (int) (this.aaX * 100.0f), false)) {
            sW();
            if (this.aaU) {
                InterfaceC0673a interfaceC0673a2 = this.aaQ;
                if (interfaceC0673a2 != null) {
                    interfaceC0673a2.k(this.Ux);
                }
            } else {
                this.aaU = true;
                this.aaV = System.currentTimeMillis();
                sV();
            }
            this.aaW = false;
            br brVar = this.hh;
            int i2 = this.aaT;
            this.aaT = i2 - 1;
            if (i2 <= 0) {
                j = 500;
            }
            brVar.sendEmptyMessageDelayed(1, j);
            return;
        }
        InterfaceC0673a interfaceC0673a3 = this.aaQ;
        if (interfaceC0673a3 != null && !this.aaW) {
            interfaceC0673a3.eo();
        }
        this.aaW = true;
        br brVar2 = this.hh;
        int i3 = this.aaT;
        this.aaT = i3 - 1;
        if (i3 <= 0) {
            j = 500;
        }
        brVar2.sendEmptyMessageDelayed(1, j);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.c.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    public final void setViewCallback(InterfaceC0673a interfaceC0673a) {
        this.aaQ = interfaceC0673a;
    }
}
