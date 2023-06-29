package com.kwad.components.core.widget.kwai;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bg;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public abstract class a implements com.kwad.sdk.core.h.a, bg.a {
    public Set<com.kwad.sdk.core.h.b> PH;
    public final int PI;
    public final View mRootView;
    public final AtomicBoolean PG = new AtomicBoolean(false);
    public final bg Ks = new bg(this);

    public a(@NonNull View view2, int i) {
        this.mRootView = view2;
        this.PI = i;
    }

    private void aH(boolean z) {
        Set<com.kwad.sdk.core.h.b> set = this.PH;
        if (set == null) {
            return;
        }
        for (com.kwad.sdk.core.h.b bVar : set) {
            if (bVar != null) {
                if (z) {
                    bVar.aR();
                } else {
                    bVar.aS();
                }
            }
        }
    }

    private void qk() {
        if (this.PG.getAndSet(true)) {
            return;
        }
        aH(true);
    }

    private void ql() {
        if (this.PG.getAndSet(false)) {
            aH(false);
        }
    }

    @Override // com.kwad.sdk.utils.bg.a
    public final void a(Message message) {
        if (message.what == 666) {
            if (dK()) {
                qk();
            } else {
                ql();
            }
            this.Ks.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void a(com.kwad.sdk.core.h.b bVar) {
        af.checkUiThread();
        if (bVar == null) {
            return;
        }
        if (dK()) {
            bVar.aR();
        } else {
            bVar.aS();
        }
        if (this.PH == null) {
            this.PH = new HashSet();
        }
        this.PH.add(bVar);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void b(com.kwad.sdk.core.h.b bVar) {
        Set<com.kwad.sdk.core.h.b> set;
        af.checkUiThread();
        if (bVar == null || (set = this.PH) == null) {
            return;
        }
        set.remove(bVar);
    }

    public abstract boolean dK();

    public final void qi() {
        this.Ks.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.Ks.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    public final void qj() {
        this.Ks.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final boolean qm() {
        return this.PG.get();
    }

    @CallSuper
    public final void release() {
        qj();
        Set<com.kwad.sdk.core.h.b> set = this.PH;
        if (set != null) {
            set.clear();
        }
    }
}
