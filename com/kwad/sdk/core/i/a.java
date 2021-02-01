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
/* loaded from: classes3.dex */
public class a implements b, ap.a {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f9311a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final ap f9312b = new ap(this);
    private Set<c> c;
    private KsFragment d;
    private View e;
    private int f;
    private String g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i) {
        this.d = ksFragment;
        this.e = view;
        this.f = i;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    private void c(boolean z) {
        if (this.c == null) {
            return;
        }
        for (c cVar : this.c) {
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
        return ao.a(this.e, this.f, false);
    }

    private void h() {
        if (this.f9311a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.g);
        c(true);
    }

    private void i() {
        if (this.f9311a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.g);
            c(false);
        }
    }

    public void a() {
        this.f9312b.sendEmptyMessage(666);
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        if (message.what == 666) {
            if (this.d == null) {
                com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(this.d)) {
                this.g = "message fragment";
                i();
            } else {
                this.g = "message view";
                if (g()) {
                    h();
                } else {
                    i();
                }
            }
            this.f9312b.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        w.a();
        if (cVar == null) {
            return;
        }
        if (this.c == null) {
            this.c = new HashSet();
        }
        if (this.f9311a.get()) {
            cVar.c_();
        } else {
            cVar.b();
        }
        this.c.add(cVar);
    }

    public void a(boolean z) {
    }

    public void b() {
        this.f9312b.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        w.a();
        if (cVar == null || this.c == null) {
            return;
        }
        this.c.remove(cVar);
    }

    public void b(boolean z) {
    }

    public void c() {
    }

    public void d() {
        com.kwad.sdk.core.d.a.b("FragmentPageVisibleHelper", "onFragmentPause");
        this.g = "onFragmentPause";
        i();
    }

    @MainThread
    public boolean e() {
        return this.f9311a.get();
    }

    public void f() {
        b();
        if (this.c != null) {
            this.c.clear();
        }
        this.d = null;
    }
}
