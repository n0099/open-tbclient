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
    public final AtomicBoolean f32449a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public final ao f32450b = new ao(this);

    /* renamed from: c  reason: collision with root package name */
    public Set<c> f32451c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragment f32452d;

    /* renamed from: e  reason: collision with root package name */
    public View f32453e;

    /* renamed from: f  reason: collision with root package name */
    public int f32454f;

    /* renamed from: g  reason: collision with root package name */
    public String f32455g;

    public a(@NonNull KsFragment ksFragment, @NonNull View view, int i2) {
        this.f32452d = ksFragment;
        this.f32453e = view;
        this.f32454f = i2;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    private void b(boolean z) {
        Set<c> set = this.f32451c;
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
        return an.a(this.f32453e, this.f32454f, false);
    }

    private void f() {
        if (this.f32449a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "start notifyPageVisible by " + this.f32455g);
        b(true);
    }

    private void g() {
        if (this.f32449a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "start notifyPageInVisible by " + this.f32455g);
            b(false);
        }
    }

    public void a() {
        this.f32450b.sendEmptyMessage(666);
    }

    @Override // com.kwad.sdk.utils.ao.a
    public void a(Message message) {
        if (message.what == 666) {
            KsFragment ksFragment = this.f32452d;
            if (ksFragment == null) {
                com.kwad.sdk.core.d.a.d("FragmentPageVisibleHelper", "mFragment is null");
                return;
            }
            if (a(ksFragment)) {
                this.f32455g = "message fragment";
            } else {
                this.f32455g = "message view";
                if (e()) {
                    f();
                    this.f32450b.sendEmptyMessageDelayed(666, 500L);
                }
            }
            g();
            this.f32450b.sendEmptyMessageDelayed(666, 500L);
        }
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void a(c cVar) {
        u.a();
        if (cVar == null) {
            return;
        }
        if (this.f32451c == null) {
            this.f32451c = new HashSet();
        }
        if (this.f32449a.get()) {
            cVar.a_();
        } else {
            cVar.e();
        }
        this.f32451c.add(cVar);
    }

    public void a(boolean z) {
    }

    public void b() {
        this.f32450b.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.i.b
    @MainThread
    public void b(c cVar) {
        Set<c> set;
        u.a();
        if (cVar == null || (set = this.f32451c) == null) {
            return;
        }
        set.remove(cVar);
    }

    public void c() {
    }

    public void d() {
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
        this.f32455g = "onFragmentPause";
        g();
    }
}
