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
    public KSAppBarLayout f33487b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f33488c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33489d = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            c.this.f33487b.post(c.this.f33490e);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f33490e = new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) c.this.f33487b.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomReboundBehavior) {
                ((CustomReboundBehavior) behavior).setScrollableSize((c.this.f33487b.getHeight() + c.this.f33488c.getHeight()) - ((ViewGroup) c.this.f33487b.getParent()).getHeight());
            }
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a;
        this.f33488c = bVar.f33468c;
        bVar.f33471f.add(this.f33489d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33487b.removeCallbacks(this.f33490e);
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a.f33471f.remove(this.f33489d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33487b = (KSAppBarLayout) b(R.id.ksad_profile_appbar);
    }
}
