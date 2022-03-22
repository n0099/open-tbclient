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
/* loaded from: classes7.dex */
public abstract class a implements c, bc.a {

    /* renamed from: c  reason: collision with root package name */
    public Set<d> f39555c;

    /* renamed from: d  reason: collision with root package name */
    public final View f39556d;

    /* renamed from: e  reason: collision with root package name */
    public final int f39557e;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f39554b = new AtomicBoolean(false);
    public final bc a = new bc(this);

    public a(@NonNull View view, int i) {
        this.f39556d = view;
        this.f39557e = i;
    }

    private void a(boolean z) {
        Set<d> set = this.f39555c;
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
        if (this.f39555c == null) {
            this.f39555c = new HashSet();
        }
        this.f39555c.add(dVar);
    }

    public final void b() {
        this.a.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.c
    @MainThread
    public final void b(d dVar) {
        Set<d> set;
        ae.a();
        if (dVar == null || (set = this.f39555c) == null) {
            return;
        }
        set.remove(dVar);
    }

    public abstract boolean c();

    public final boolean d() {
        return bb.a(this.f39556d, this.f39557e, false);
    }

    public final void e() {
        if (this.f39554b.getAndSet(true)) {
            return;
        }
        a(true);
    }

    public final void f() {
        if (this.f39554b.getAndSet(false)) {
            a(false);
        }
    }

    @CallSuper
    public void g() {
        b();
        Set<d> set = this.f39555c;
        if (set != null) {
            set.clear();
        }
    }
}
