package com.kwad.sdk.contentalliance.profile.home.c;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.profile.home.model.UserProfile;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class f extends com.kwad.sdk.contentalliance.profile.home.b.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f9092b;
    private View c;
    private TextView d;
    private com.kwad.sdk.contentalliance.profile.home.a.a e = new com.kwad.sdk.contentalliance.profile.home.a.a() { // from class: com.kwad.sdk.contentalliance.profile.home.c.f.1
        @Override // com.kwad.sdk.contentalliance.profile.home.a.a
        public void a(@NonNull UserProfile userProfile) {
            f.this.d.setText(userProfile.authorName);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f9092b.getLayoutParams();
            layoutParams.height += a2;
            this.f9092b.setLayoutParams(layoutParams);
            this.f9092b.setPadding(this.f9092b.getPaddingLeft(), a2, this.f9092b.getPaddingRight(), this.f9092b.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.profile.home.b.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c.setOnClickListener(this);
        e();
        this.f9077a.f.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f9077a.f.remove(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9092b = (ViewGroup) b(R.id.ksad_profile_title_bar);
        this.c = b(R.id.ksad_profile_left_back);
        this.d = (TextView) b(R.id.ksad_profile_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.c || (m = m()) == null) {
            return;
        }
        m.finish();
    }
}
