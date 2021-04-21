package com.kwad.sdk.contentalliance.profile.home.c;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33267b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33268c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33269d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33270e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33271f = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.b.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            b.this.a(userProfile);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        this.f33269d.setText(ag.b(userProfile.ownerCount.fansCount));
        this.f33270e.setText(ag.b(userProfile.ownerCount.followCount));
        this.f33268c.setText(TextUtils.isEmpty(userProfile.authorName) ? "-" : userProfile.authorName);
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a.f33258f.add(this.f33271f);
        KSImageLoader.loadCircleIcon(this.f33267b, ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a.f33256d.mAuthorIcon, o().getResources().getDrawable(R.drawable.ksad_profile_author_icon));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33252a.f33258f.remove(this.f33271f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33267b = (ImageView) b(R.id.ksad_profile_author_icon);
        this.f33268c = (TextView) b(R.id.ksad_profile_author_name);
        this.f33269d = (TextView) b(R.id.ksad_profile_fans_count);
        this.f33270e = (TextView) b(R.id.ksad_profile_follow_count);
    }
}
