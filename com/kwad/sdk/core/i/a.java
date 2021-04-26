package com.kwad.sdk.core.i;

import android.os.Message;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.u;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a implements b, ao.a {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f33204a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final ao f33205b = new ao(this);

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f33206c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f33207d;

    /* renamed from: e  reason: collision with root package name */
    public View f33208e;

    /* renamed from: f  reason: collision with root package name */
    public int f33209f;

    /* renamed from: g  reason: collision with root package name */
    public String f33210g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i2) {
        this.f33207d = ksFragment;
        this.f33208e = view;
        this.f33209f = i2;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    private void b(boolean z) {
        Set<c> set = this.f33206c;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.a_();
                } else {
                    cVar.e();
                }
            }
        }
    }

    private boolean e() {
        return an.a(this.f33208e, this.f33209f, false);
    }

    private void f() {
        if (this.f33204a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.f33210g);
        b(true);
    }

    private void g() {
        if (this.f33204a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.f33210g);
            b(false);
        }
    }

    public void a() {
        this.f33205b.sendEmptyMessage(666);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        if (message.what == 666) {
            KsFragment ksFragment = this.f33207d;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.d("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f33210g = "message fragment";
            } else {
                this.f33210g = "message view";
                if (e()) {
                    f();
                    this.f33205b.sendEmptyMessageDelayed(666, 500L);
                }
            }
            g();
            this.f33205b.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        u.a();
        if (cVar == null) {
            return;
        }
        if (this.f33206c == null) {
            this.f33206c = new HashSet();
        }
        if (this.f33204a.get()) {
            cVar.a_();
        } else {
            cVar.e();
        }
        this.f33206c.add(cVar);
    }

    public void a(boolean z) {
    }

    public void b() {
        this.f33205b.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        Set<c> set;
        u.a();
        if (cVar == null || (set = this.f33206c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void c() {
    }

    public void d() {
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
        this.f33210g = "onFragmentPause";
        g();
    }
}
