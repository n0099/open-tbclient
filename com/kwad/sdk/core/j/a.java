package com.kwad.sdk.core.j;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bc;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class a implements c, bc.a {

    /* renamed from: c  reason: collision with root package name */
    public Set<d> f55870c;

    /* renamed from: d  reason: collision with root package name */
    public final View f55871d;

    /* renamed from: e  reason: collision with root package name */
    public final int f55872e;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f55869b = new AtomicBoolean(false);
    public final bc a = new bc(this);

    public a(@NonNull View view, int i2) {
        this.f55871d = view;
        this.f55872e = i2;
    }

    private void a(boolean z) {
        Set<d> set = this.f55870c;
        if (set == null) {
            return;
        }
        for (d dVar : set) {
            if (dVar != null) {
                if (z) {
                    dVar.e();
                } else {
                    dVar.f();
                }
            }
        }
    }

    public final void a() {
        this.a.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.a.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    @Override // com.kwad.sdk.utils.bc.a
    public void a(Message message) {
        if (message.what == 666) {
            if (c()) {
                e();
            } else {
                f();
            }
            this.a.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void a(d dVar) {
        ae.a();
        if (dVar == null) {
            return;
        }
        if (c()) {
            dVar.e();
        } else {
            dVar.f();
        }
        if (this.f55870c == null) {
            this.f55870c = new HashSet();
        }
        this.f55870c.add(dVar);
    }

    public final void b() {
        this.a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void b(d dVar) {
        Set<d> set;
        ae.a();
        if (dVar == null || (set = this.f55870c) == null) {
            return;
        }
        set.remove(dVar);
    }

    public abstract boolean c();

    public final boolean d() {
        return bb.a(this.f55871d, this.f55872e, false);
    }

    public final void e() {
        if (this.f55869b.getAndSet(true)) {
            return;
        }
        a(true);
    }

    public final void f() {
        if (this.f55869b.getAndSet(false)) {
            a(false);
        }
    }

    @CallSuper
    public void g() {
        b();
        Set<d> set = this.f55870c;
        if (set != null) {
            set.clear();
        }
    }
}
