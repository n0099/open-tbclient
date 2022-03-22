package com.kwad.sdk.core.j;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f39558b;

    /* renamed from: c  reason: collision with root package name */
    public KsFragment f39559c;

    /* renamed from: d  reason: collision with root package name */
    public String f39560d;

    public b(@NonNull KsFragment ksFragment, @NonNull View view, int i) {
        super(view, i);
        this.f39558b = new AtomicBoolean(false);
        this.f39559c = ksFragment;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    public void a(boolean z) {
    }

    @Override // com.kwad.sdk.core.j.a
    public boolean c() {
        KsFragment ksFragment = this.f39559c;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.f39560d = "message fragment";
            return false;
        }
        this.f39560d = "message view";
        return d();
    }

    @Override // com.kwad.sdk.core.j.a
    public void g() {
        super.g();
        this.f39559c = null;
    }

    public void h() {
    }

    public void i() {
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
        this.f39560d = "onFragmentPause";
        f();
    }
}
