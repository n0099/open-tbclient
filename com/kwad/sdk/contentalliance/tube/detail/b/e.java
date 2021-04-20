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
    public ViewGroup f33491b;

    /* renamed from: c  reason: collision with root package name */
    public View f33492c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33493d;

    /* renamed from: e  reason: collision with root package name */
    public b.a f33494e = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.e.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (((com.kwad.sdk.contentalliance.tube.detail.a.a) e.this).f33447a.f33449b.mTubeInfo != null) {
                e.this.f33493d.setText(((com.kwad.sdk.contentalliance.tube.detail.a.a) e.this).f33447a.f33449b.mTubeInfo.name);
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
            ViewGroup.LayoutParams layoutParams = this.f33491b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() height=" + layoutParams.height);
            layoutParams.height = layoutParams.height + a2;
            this.f33491b.setLayoutParams(layoutParams);
            ViewGroup viewGroup = this.f33491b;
            viewGroup.setPadding(viewGroup.getPaddingLeft(), a2, this.f33491b.getPaddingRight(), this.f33491b.getPaddingBottom());
        }
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33492c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.add(this.f33494e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.remove(this.f33494e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33491b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.f33492c = b(R.id.ksad_tube_left_back);
        this.f33493d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33492c) {
            Activity m = m();
            com.kwad.sdk.core.report.e.d(((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33453f);
            if (m != null) {
                m.finish();
            }
        }
    }
}
