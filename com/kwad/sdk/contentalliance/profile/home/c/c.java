package com.kwad.sdk.contentalliance.profile.home.c;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.lib.desigin.CustomReboundBehavior;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.contentalliance.profile.home.b.a {
    private KSAppBarLayout b;
    private ViewPager c;
    private com.kwad.sdk.contentalliance.profile.home.a.a d = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            c.this.b.post(c.this.e);
        }
    };
    private Runnable e = new Runnable() { // from class: com.kwad.sdk.contentalliance.profile.home.c.c.2
        @Override // java.lang.Runnable
        public void run() {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) c.this.b.getLayoutParams()).getBehavior();
            if (behavior instanceof CustomReboundBehavior) {
                ((CustomReboundBehavior) behavior).setScrollableSize((c.this.b.getHeight() + c.this.c.getHeight()) - ((ViewGroup) c.this.b.getParent()).getHeight());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f5850a.c;
        this.f5850a.f.add(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.removeCallbacks(this.e);
        this.f5850a.f.remove(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (KSAppBarLayout) b(R.id.ksad_profile_appbar);
    }
}
