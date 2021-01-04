package com.kwad.sdk.reward.b.c.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.d;
/* loaded from: classes5.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private TextView f10925b;
    private TextView c;
    @NonNull
    private com.kwad.sdk.reward.a.b d;
    @NonNull
    private AdTemplate e;
    @Nullable
    private com.kwad.sdk.core.download.b.b f;
    private e g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String k = com.kwad.sdk.core.response.b.b.k(this.e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        if (this.f10949a.e == 1 || (this.f10949a.p && this.f10949a.q)) {
            this.c.setVisibility(8);
            this.f10925b.setText(k);
            this.f10925b.setVisibility(0);
            this.f10925b.setOnClickListener(this);
        } else {
            this.f10925b.setVisibility(8);
            this.c.setText(k);
            this.c.setVisibility(0);
            this.c.setOnClickListener(this);
        }
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.e, 17, this.f10949a.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.e, 39, this.f10949a.h.getTouchCoords(), this.f10949a.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f10949a.f10824b;
        this.e = this.f10949a.f;
        this.f = this.f10949a.j;
        this.f10949a.n.add(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f10949a.n.remove(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f10925b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f10925b || view == this.c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.e, new a.InterfaceC1064a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1064a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f);
        }
    }
}
