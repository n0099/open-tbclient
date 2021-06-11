package com.kwad.sdk.contentalliance.tube.detail.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.tube.detail.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f33814b;

    /* renamed from: c  reason: collision with root package name */
    public View f33815c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33816d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f33817e = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.e.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i2, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) e.this).f33768a.f33770b.mTubeInfo != null) {
                e.this.f33816d.setText(((com.kwad.sdk.contentalliance.tube.detail.a.a) e.this).f33768a.f33770b.mTubeInfo.name);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
        }
    };

    private void e() {
        Activity m = m();
        if (m != null && com.kwad.sdk.utils.d.a(m)) {
            int a2 = ao.a(o());
            ViewGroup.LayoutParams layoutParams = this.f33814b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f33814b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f33814b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f33814b.getPaddingRight(), this.f33814b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33815c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.add(this.f33817e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.remove(this.f33817e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33814b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.f33815c = b(R.id.ksad_tube_left_back);
        this.f33816d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33815c) {
            Activity m = m();
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33774f);
            if (m != null) {
                m.finish();
            }
        }
    }
}
