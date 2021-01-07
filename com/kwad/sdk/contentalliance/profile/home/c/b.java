package com.kwad.sdk.contentalliance.profile.home.c;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.ag;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.contentalliance.profile.home.b.a {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f9084b;
    private TextView c;
    private TextView d;
    private TextView e;
    private com.kwad.sdk.contentalliance.profile.home.a.a f = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.b.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            b.this.a(userProfile);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull UserProfile userProfile) {
        this.d.setText(ag.b(userProfile.ownerCount.fansCount));
        this.e.setText(ag.b(userProfile.ownerCount.followCount));
        this.c.setText(TextUtils.isEmpty(userProfile.authorName) ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : userProfile.authorName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f9078a.f.add(this.f);
        KSImageLoader.loadCircleIcon(this.f9084b, this.f9078a.d.mAuthorIcon, o().getResources().getDrawable(R.drawable.ksad_profile_author_icon));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9078a.f.remove(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9084b = (ImageView) b(R.id.ksad_profile_author_icon);
        this.c = (TextView) b(R.id.ksad_profile_author_name);
        this.d = (TextView) b(R.id.ksad_profile_fans_count);
        this.e = (TextView) b(R.id.ksad_profile_follow_count);
    }
}
