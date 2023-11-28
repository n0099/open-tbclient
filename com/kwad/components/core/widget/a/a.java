package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.br;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public abstract class a implements com.kwad.sdk.core.h.a, br.a {
    public Set<c> aci;
    public final int acj;
    public final View mRootView;
    public final AtomicBoolean ach = new AtomicBoolean(false);
    public final br hh = new br(this);

    public abstract boolean dW();

    public a(@NonNull View view2, int i) {
        this.mRootView = view2;
        this.acj = i;
    }

    private void aY(boolean z) {
        Set<c> set = this.aci;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        }
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (message.what == 666) {
            tl();
            this.hh.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        ah.checkUiThread();
        if (cVar != null && (set = this.aci) != null) {
            set.remove(cVar);
        }
    }

    private void iW() {
        if (!this.ach.getAndSet(true)) {
            aY(true);
        }
    }

    private void tl() {
        if (dW()) {
            iW();
        } else {
            to();
        }
    }

    private void to() {
        if (this.ach.getAndSet(false)) {
            aY(false);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    @CallSuper
    public final void release() {
        tn();
        Set<c> set = this.aci;
        if (set != null) {
            set.clear();
        }
    }

    public final void tm() {
        this.hh.removeMessages(666);
        this.hh.sendEmptyMessage(666);
    }

    public final void tn() {
        tl();
        this.hh.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final boolean tp() {
        return this.ach.get();
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void a(final c cVar) {
        ah.checkUiThread();
        if (cVar == null) {
            return;
        }
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.dW()) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        });
        if (this.aci == null) {
            this.aci = new HashSet();
        }
        this.aci.add(cVar);
    }
}
