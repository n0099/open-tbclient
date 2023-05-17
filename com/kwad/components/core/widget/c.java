package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public final class c extends View implements bg.a {
    public View Kr;
    public final bg Ks;
    public final AtomicBoolean Kt;
    public a OO;
    public boolean OP;
    public final int OQ;
    public boolean Ou;
    public boolean Ov;

    /* loaded from: classes9.dex */
    public interface a {
        void em();
    }

    public c(Context context, View view2) {
        super(context);
        this.Ks = new bg(this);
        this.Kt = new AtomicBoolean(true);
        this.OQ = (int) (com.kwad.sdk.core.config.d.sk() * 100.0f);
        this.Kr = view2;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void pU() {
        if (this.Ov) {
            this.Ks.removeCallbacksAndMessages(null);
            this.Ov = false;
        }
    }

    private void pV() {
        if (!this.OP || this.Ov) {
            return;
        }
        this.Ov = true;
        this.Ks.sendEmptyMessage(1);
    }

    private void pY() {
        this.Kt.getAndSet(false);
    }

    private void pZ() {
        this.Kt.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (!com.kwad.sdk.b.kwai.a.a(this.Kr, this.OQ, false)) {
                if (this.Ou) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (aVar = this.OO) != null) {
                aVar.em();
            }
            this.Ks.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.e.b.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.Ov) {
            if (!com.kwad.sdk.b.kwai.a.a(this.Kr, this.OQ, false)) {
                this.Ks.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            pU();
            Message obtainMessage = this.Ks.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 1000;
            this.Ks.sendMessageDelayed(obtainMessage, 1000L);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.b.d("EmptyView", "onAttachedToWindow:" + this);
        pV();
        this.Ou = false;
        pY();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.b.d("EmptyView", "onDetachedFromWindow" + this);
        pU();
        this.Ou = true;
        pZ();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.b.d("EmptyView", "onFinishTemporaryDetach:" + this.Kr.getParent());
        pY();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.b.d("EmptyView", "onStartTemporaryDetach:" + this.Kr.getParent());
        pZ();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.b.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.e.b.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.OP = z;
        if (!z && this.Ov) {
            pU();
        } else if (!z || this.Ov) {
        } else {
            pV();
        }
    }

    public final void setViewCallback(a aVar) {
        this.OO = aVar;
    }
}
