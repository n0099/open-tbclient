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
    public final AtomicBoolean f34141a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final ap f34142b = new ap(this);

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f34143c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f34144d;

    /* renamed from: e  reason: collision with root package name */
    public View f34145e;

    /* renamed from: f  reason: collision with root package name */
    public int f34146f;

    /* renamed from: g  reason: collision with root package name */
    public String f34147g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i) {
        this.f34144d = ksFragment;
        this.f34145e = view;
        this.f34146f = i;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    private void c(boolean z) {
        Set<c> set = this.f34143c;
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
        return ao.a(this.f34145e, this.f34146f, false);
    }

    private void h() {
        if (this.f34141a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.f34147g);
        c(true);
    }

    private void i() {
        if (this.f34141a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.f34147g);
            c(false);
        }
    }

    public void a() {
        this.f34142b.sendEmptyMessage(666);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 666) {
            KsFragment ksFragment = this.f34144d;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f34147g = "message fragment";
            } else {
                this.f34147g = "message view";
                if (g()) {
                    h();
                    this.f34142b.sendEmptyMessageDelayed(666, 500L);
                }
            }
            i();
            this.f34142b.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        w.a();
        if (cVar == null) {
            return;
        }
        if (this.f34143c == null) {
            this.f34143c = new HashSet();
        }
        if (this.f34141a.get()) {
            cVar.c_();
        } else {
            cVar.b();
        }
        this.f34143c.add(cVar);
    }

    public void a(boolean z) {
    }

    public void b() {
        this.f34142b.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        Set<c> set;
        w.a();
        if (cVar == null || (set = this.f34143c) == null) {
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
        this.f34147g = "onFragmentPause";
        i();
    }

    @MainThread
    public boolean e() {
        return this.f34141a.get();
    }

    public void f() {
        b();
        Set<c> set = this.f34143c;
        if (set != null) {
            set.clear();
        }
        this.f34144d = null;
    }
}
