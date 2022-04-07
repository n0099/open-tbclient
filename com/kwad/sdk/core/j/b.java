package com.kwad.sdk.core.j;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class b extends a {
    public final AtomicBoolean b;
    public KsFragment c;
    public String d;

    public b(@NonNull KsFragment ksFragment, @NonNull View view2, int i) {
        super(view2, i);
        this.b = new AtomicBoolean(false);
        this.c = ksFragment;
    }

    private boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    public void a(boolean z) {
    }

    @Override // com.kwad.sdk.core.j.a
    public boolean c() {
        KsFragment ksFragment = this.c;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.d = "message fragment";
            return false;
        }
        this.d = "message view";
        return d();
    }

    @Override // com.kwad.sdk.core.j.a
    public void g() {
        super.g();
        this.c = null;
    }

    public void h() {
    }

    public void i() {
        com.kwad.sdk.core.d.a.c("FragmentPageVisibleHelper", "onFragmentPause");
        this.d = "onFragmentPause";
        f();
    }
}
