package com.kwad.sdk.contentalliance.tube.profile.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class f extends com.kwad.sdk.contentalliance.tube.profile.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8976b;
    private View c;
    private TextView d;
    private com.kwad.sdk.contentalliance.tube.profile.e e = new com.kwad.sdk.contentalliance.tube.profile.e() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.f.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.e
        public void a(@NonNull TubeProfileResultData tubeProfileResultData) {
            f.this.d.setText(tubeProfileResultData.tubeProfile.tubeInfo.name);
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() statusBarHeight=" + a2);
            ViewGroup.LayoutParams layoutParams = this.f8976b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() titleBarLayoutParams.height=" + layoutParams.height);
            layoutParams.height += a2;
            this.f8976b.setLayoutParams(layoutParams);
            this.f8976b.setPadding(this.f8976b.getPaddingLeft(), a2, this.f8976b.getPaddingRight(), this.f8976b.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        this.f8953a.e.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8953a.e.remove(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8976b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.c = b(R.id.ksad_tube_left_back);
        this.d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity m;
        if (view != this.c || (m = m()) == null) {
            return;
        }
        com.kwad.sdk.core.report.e.d(this.f8953a.f);
        m.finish();
    }
}
