package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public final class a extends KSFrameLayout implements bg.a {
    public final View Kr;
    public final bg Ks;
    public final int OA;
    public InterfaceC0617a Ot;
    public boolean Ou;
    public boolean Ov;
    public int Ow;
    public boolean Ox;
    public long Oy;
    public final float Oz;

    /* renamed from: com.kwad.components.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0617a {
        void em();
    }

    public a(Context context, View view2) {
        super(context, view2);
        this.Ks = new bg(this);
        this.Ow = 5;
        this.Kr = view2;
        setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        float sk = com.kwad.sdk.core.config.d.sk();
        this.Oz = sk;
        setVisiblePercent(sk);
        float sl = com.kwad.sdk.core.config.d.sl();
        this.OA = (int) ((sl < 0.0f ? 1.0f : sl) * 1000.0f);
    }

    private void pT() {
        Message obtainMessage = this.Ks.obtainMessage();
        obtainMessage.what = 2;
        this.Ks.sendMessageDelayed(obtainMessage, this.OA);
    }

    private void pU() {
        this.Ks.removeCallbacksAndMessages(null);
        this.Ov = false;
    }

    private void pV() {
        if (this.Ov) {
            return;
        }
        this.Ov = true;
        this.Ks.sendEmptyMessage(1);
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        if (this.Ou) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.Kr, (int) (this.Oz * 100.0f), false)) {
                this.Ow = 5;
                this.Ks.sendEmptyMessage(1);
                return;
            }
            InterfaceC0617a interfaceC0617a = this.Ot;
            if (interfaceC0617a != null) {
                interfaceC0617a.em();
                return;
            }
            return;
        }
        com.kwad.sdk.core.e.b.d("AdExposureView", "handleMsg MSG_CHECKING");
        if (!com.kwad.sdk.b.kwai.a.a(this.Kr, (int) (this.Oz * 100.0f), false)) {
            bg bgVar = this.Ks;
            int i2 = this.Ow;
            this.Ow = i2 - 1;
            bgVar.sendEmptyMessageDelayed(1, i2 > 0 ? 100L : 500L);
            return;
        }
        pU();
        if (this.OA != 0 && !this.Ox) {
            this.Ox = true;
            this.Oy = System.currentTimeMillis();
            pT();
            return;
        }
        InterfaceC0617a interfaceC0617a2 = this.Ot;
        if (interfaceC0617a2 != null) {
            interfaceC0617a2.em();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
        this.Ow = 5;
        this.Ou = false;
        this.Ox = false;
        pV();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        pU();
        this.Ow = 0;
        this.Oy = 0L;
        this.Ou = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        InterfaceC0617a interfaceC0617a;
        InterfaceC0617a interfaceC0617a2;
        super.k(view2);
        if (this.OA == 0 && (interfaceC0617a2 = this.Ot) != null) {
            interfaceC0617a2.em();
        } else if (!this.Ox) {
            this.Ox = true;
            this.Oy = System.currentTimeMillis();
            pU();
            pT();
        } else if (System.currentTimeMillis() - this.Oy <= this.OA || (interfaceC0617a = this.Ot) == null) {
        } else {
            interfaceC0617a.em();
            pU();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.b.d("AdExposureView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    public final void pW() {
        pV();
    }

    public final void setViewCallback(InterfaceC0617a interfaceC0617a) {
        this.Ot = interfaceC0617a;
    }
}
