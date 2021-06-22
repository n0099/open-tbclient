package com.kwad.sdk.contentalliance.tube.profile.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class f extends com.kwad.sdk.contentalliance.tube.profile.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33994b;

    /* renamed from: c  reason: collision with root package name */
    public View f33995c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33996d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33997e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            f.this.f33996d.setText(tubeProfileResultData.tubeProfile.tubeInfo.name);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() statusBarHeight=" + a2);
            ViewGroup.LayoutParams layoutParams = this.f33994b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() titleBarLayoutParams.height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f33994b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f33994b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f33994b.getPaddingRight(), this.f33994b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33995c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a.f33947e.add(this.f33997e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a.f33947e.remove(this.f33997e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33994b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.f33995c = b(R.id.ksad_tube_left_back);
        this.f33996d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.f33995c || (m = m()) == null) {
            return;
        }
        com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a.f33948f);
        m.finish();
    }
}
