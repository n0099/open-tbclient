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
    public ImageView f33481b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33482c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33483d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33484e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33485f = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.b.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            b.this.a(userProfile);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        this.f33483d.setText(ag.b(userProfile.ownerCount.fansCount));
        this.f33484e.setText(ag.b(userProfile.ownerCount.followCount));
        this.f33482c.setText(TextUtils.isEmpty(userProfile.authorName) ? "-" : userProfile.authorName);
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a.f33471f.add(this.f33485f);
        KSImageLoader.loadCircleIcon(this.f33481b, ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a.f33469d.mAuthorIcon, o().getResources().getDrawable(R.drawable.ksad_profile_author_icon));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33465a.f33471f.remove(this.f33485f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33481b = (ImageView) b(R.id.ksad_profile_author_icon);
        this.f33482c = (TextView) b(R.id.ksad_profile_author_name);
        this.f33483d = (TextView) b(R.id.ksad_profile_fans_count);
        this.f33484e = (TextView) b(R.id.ksad_profile_follow_count);
    }
}
