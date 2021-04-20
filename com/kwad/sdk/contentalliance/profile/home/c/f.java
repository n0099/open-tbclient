package com.kwad.sdk.contentalliance.profile.home.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.profile.home.b.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33196b;

    /* renamed from: c  reason: collision with root package name */
    public View f33197c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33198d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f33199e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.f.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            f.this.f33198d.setText(userProfile.authorName);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f33196b.getLayoutParams();
            layoutParams.height += a2;
            this.f33196b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f33196b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f33196b.getPaddingRight(), this.f33196b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33197c.setOnClickListener(this);
        e();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33163f.add(this.f33199e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f33157a.f33163f.remove(this.f33199e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33196b = (ViewGroup) b(R.id.ksad_profile_title_bar);
        this.f33197c = b(R.id.ksad_profile_left_back);
        this.f33198d = (TextView) b(R.id.ksad_profile_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.f33197c || (m = m()) == null) {
            return;
        }
        m.finish();
    }
}
