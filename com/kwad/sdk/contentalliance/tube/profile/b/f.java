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
    public ViewGroup f33281b;

    /* renamed from: c  reason: collision with root package name */
    public View f33282c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33283d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.e f33284e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            f.this.f33283d.setText(tubeProfileResultData.tubeProfile.tubeInfo.name);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() statusBarHeight=" + a2);
            ViewGroup.LayoutParams layoutParams = this.f33281b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() titleBarLayoutParams.height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f33281b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f33281b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f33281b.getPaddingRight(), this.f33281b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33282c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33236e.add(this.f33284e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33236e.remove(this.f33284e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33281b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.f33282c = b(R.id.ksad_tube_left_back);
        this.f33283d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.f33282c || (m = m()) == null) {
            return;
        }
        com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a.f33237f);
        m.finish();
    }
}
