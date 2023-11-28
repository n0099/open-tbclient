package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class c extends View implements br.a {
    public View Ux;
    public final AtomicBoolean Uy;
    public boolean aaR;
    public boolean aaS;
    public a abl;
    public boolean abm;
    public final int abn;
    public final br hh;

    /* loaded from: classes10.dex */
    public interface a {
        void ep();
    }

    public c(Context context, View view2) {
        super(context);
        this.hh = new br(this);
        this.Uy = new AtomicBoolean(true);
        this.abn = (int) (com.kwad.sdk.core.config.d.Bb() * 100.0f);
        this.Ux = view2;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void sW() {
        if (this.aaS) {
            this.hh.removeCallbacksAndMessages(null);
            this.aaS = false;
        }
    }

    private void sX() {
        if (this.abm && !this.aaS) {
            this.aaS = true;
            this.hh.sendEmptyMessage(1);
        }
    }

    private void tb() {
        this.Uy.getAndSet(false);
    }

    private void tc() {
        this.Uy.getAndSet(true);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onAttachedToWindow:" + this);
        sX();
        this.aaR = false;
        tb();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onDetachedFromWindow" + this);
        sW();
        this.aaR = true;
        tc();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onFinishTemporaryDetach:" + this.Ux.getParent());
        tb();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onStartTemporaryDetach:" + this.Ux.getParent());
        tc();
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                if (!bq.a(this.Ux, this.abn, false)) {
                    if (!this.aaR) {
                        setNeedCheckingShow(true);
                        return;
                    }
                    return;
                }
                if (message.arg1 == 1000 && (aVar = this.abl) != null) {
                    aVar.ep();
                }
                this.hh.sendEmptyMessageDelayed(2, 500L);
                return;
            }
            return;
        }
        com.kwad.sdk.core.e.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.aaS) {
            if (bq.a(this.Ux, this.abn, false)) {
                sW();
                Message obtainMessage = this.hh.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.hh.sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.abm = z;
        if (!z && this.aaS) {
            sW();
        } else if (z && !this.aaS) {
            sX();
        }
    }

    public final void setViewCallback(a aVar) {
        this.abl = aVar;
    }
}
