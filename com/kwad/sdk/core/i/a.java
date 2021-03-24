package com.kwad.sdk.core.i;

import android.os.Message;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.w;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a implements b, ap.a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f33851a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final ap f33852b = new ap(this);

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f33853c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f33854d;

    /* renamed from: e  reason: collision with root package name */
    public View f33855e;

    /* renamed from: f  reason: collision with root package name */
    public int f33856f;

    /* renamed from: g  reason: collision with root package name */
    public String f33857g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i) {
        this.f33854d = ksFragment;
        this.f33855e = view;
        this.f33856f = i;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    private void c(boolean z) {
        Set<c> set = this.f33853c;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.c_();
                } else {
                    cVar.b();
                }
            }
        }
    }

    private boolean g() {
        return ao.a(this.f33855e, this.f33856f, false);
    }

    private void h() {
        if (this.f33851a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.f33857g);
        c(true);
    }

    private void i() {
        if (this.f33851a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.f33857g);
            c(false);
        }
    }

    public void a() {
        this.f33852b.sendEmptyMessage(666);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 666) {
            KsFragment ksFragment = this.f33854d;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f33857g = "message fragment";
            } else {
                this.f33857g = "message view";
                if (g()) {
                    h();
                    this.f33852b.sendEmptyMessageDelayed(666, 500L);
                }
            }
            i();
            this.f33852b.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        w.a();
        if (cVar == null) {
            return;
        }
        if (this.f33853c == null) {
            this.f33853c = new HashSet();
        }
        if (this.f33851a.get()) {
            cVar.c_();
        } else {
            cVar.b();
        }
        this.f33853c.add(cVar);
    }

    public void a(boolean z) {
    }

    public void b() {
        this.f33852b.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        Set<c> set;
        w.a();
        if (cVar == null || (set = this.f33853c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public void d() {
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "onFragmentPause");
        this.f33857g = "onFragmentPause";
        i();
    }

    @MainThread
    public boolean e() {
        return this.f33851a.get();
    }

    public void f() {
        b();
        Set<c> set = this.f33853c;
        if (set != null) {
            set.clear();
        }
        this.f33854d = null;
    }
}
