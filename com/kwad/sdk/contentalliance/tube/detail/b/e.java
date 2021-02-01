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
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.contentalliance.tube.detail.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f8943b;
    private View c;
    private TextView d;
    private b.a e = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.e.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
            if (e.this.f8924a.f8926b.mTubeInfo != null) {
                e.this.d.setText(e.this.f8924a.f8926b.mTubeInfo.name);
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
            ViewGroup.LayoutParams layoutParams = this.f8943b.getLayoutParams();
            com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "initImmersiveTitleBar() height=" + layoutParams.height);
            layoutParams.height += a2;
            this.f8943b.setLayoutParams(layoutParams);
            this.f8943b.setPadding(this.f8943b.getPaddingLeft(), a2, this.f8943b.getPaddingRight(), this.f8943b.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c.setOnClickListener(this);
        com.kwad.sdk.core.d.a.a("TubeTitleBarPresenter", "onBind()");
        e();
        this.f8924a.d.add(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8924a.d.remove(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8943b = (ViewGroup) b(R.id.ksad_tube_title_bar);
        this.c = b(R.id.ksad_tube_left_back);
        this.d = (TextView) b(R.id.ksad_tube_title);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            Activity m = m();
            com.kwad.sdk.core.report.e.d(this.f8924a.f);
            if (m != null) {
                m.finish();
            }
        }
    }
}
