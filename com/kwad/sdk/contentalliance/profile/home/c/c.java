package com.kwad.sdk.contentalliance.profile.home.c;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.lib.desigin.CustomReboundBehavior;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public KSAppBarLayout f33273b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f33274c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33275d = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            c.this.f33273b.post(c.this.f33276e);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f33276e = new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) c.this.f33273b.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomReboundBehavior) {
                ((CustomReboundBehavior) behavior).setScrollableSize((c.this.f33273b.getHeight() + c.this.f33274c.getHeight()) - ((ViewGroup) c.this.f33273b.getParent()).getHeight());
            }
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a;
        this.f33274c = bVar.f33255c;
        bVar.f33258f.add(this.f33275d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33273b.removeCallbacks(this.f33276e);
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a.f33258f.remove(this.f33275d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33273b = (KSAppBarLayout) b(R.id.ksad_profile_appbar);
    }
}
