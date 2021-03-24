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
    public ViewGroup f32906b;

    /* renamed from: c  reason: collision with root package name */
    public View f32907c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f32908d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.profile.home.a.a f32909e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.f.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            f.this.f32908d.setText(userProfile.authorName);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f32906b.getLayoutParams();
            layoutParams.height += a2;
            this.f32906b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f32906b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f32906b.getPaddingRight(), this.f32906b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32907c.setOnClickListener(this);
        e();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32873f.add(this.f32909e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.profile.home.b.a) this).f32867a.f32873f.remove(this.f32909e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32906b = (ViewGroup) b(R.id.ksad_profile_title_bar);
        this.f32907c = b(R.id.ksad_profile_left_back);
        this.f32908d = (TextView) b(R.id.ksad_profile_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.f32907c || (m = m()) == null) {
            return;
        }
        m.finish();
    }
}
