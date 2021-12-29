package com.kwad.sdk.core.j;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f58069b;

    /* renamed from: c  reason: collision with root package name */
    public KsFragment f58070c;

    /* renamed from: d  reason: collision with root package name */
    public String f58071d;

    public b(@NonNull KsFragment ksFragment, @NonNull View view, int i2) {
        super(view, i2);
        this.f58069b = new AtomicBoolean(false);
        this.f58070c = ksFragment;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    public void a(boolean z) {
    }

    @Override // com.kwad.sdk.core.j.a
    public boolean c() {
        KsFragment ksFragment = this.f58070c;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.f58071d = "message fragment";
            return false;
        }
        this.f58071d = "message view";
        return d();
    }

    @Override // com.kwad.sdk.core.j.a
    public void g() {
        super.g();
        this.f58070c = null;
    }

    public void h() {
    }

    public void i() {
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
        this.f58071d = "onFragmentPause";
        f();
    }
}
