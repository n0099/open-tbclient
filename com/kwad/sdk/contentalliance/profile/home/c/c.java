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
    public KSAppBarLayout f33178b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f33179c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33180d = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            c.this.f33178b.post(c.this.f33181e);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public Runnable f33181e = new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) c.this.f33178b.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomReboundBehavior) {
                ((CustomReboundBehavior) behavior).setScrollableSize((c.this.f33178b.getHeight() + c.this.f33179c.getHeight()) - ((ViewGroup) c.this.f33178b.getParent()).getHeight());
            }
        }
    };

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.profile.home.b.b bVar = ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a;
        this.f33179c = bVar.f33160c;
        bVar.f33163f.add(this.f33180d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33178b.removeCallbacks(this.f33181e);
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33163f.remove(this.f33180d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33178b = (KSAppBarLayout) b(R.id.ksad_profile_appbar);
    }
}
