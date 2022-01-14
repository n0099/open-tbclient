package com.kwad.sdk.reward.presenter.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes3.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f57355b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57356c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f57357d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57358e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57359f;

    /* renamed from: g  reason: collision with root package name */
    public f f57360g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
        @Override // com.kwad.sdk.reward.a.f
        public void a() {
            if (((g) a.this).a.x) {
                return;
            }
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String f2 = com.kwad.sdk.core.response.a.c.f(this.f57358e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f57206f == 1 || (aVar.r && aVar.s)) {
            this.f57356c.setVisibility(8);
            this.f57355b.setText(f2);
            this.f57355b.setVisibility(0);
            textView = this.f57355b;
        } else {
            this.f57355b.setVisibility(8);
            this.f57356c.setText(f2);
            this.f57356c.setVisibility(0);
            textView = this.f57356c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f57358e, 17, ((g) this).a.f57205e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f57358e, 39, ((g) this).a.f57210j.getTouchCoords(), ((g) this).a.f57205e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f57357d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57357d = aVar.f57202b;
        this.f57358e = aVar.f57207g;
        this.f57359f = aVar.l;
        aVar.a(this.f57360g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f57360g);
        this.f57355b.setVisibility(8);
        this.f57356c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57355b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f57356c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57355b || view == this.f57356c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2100a(view.getContext()).a(this.f57358e).a(this.f57359f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
