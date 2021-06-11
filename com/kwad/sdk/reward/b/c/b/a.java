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
/* loaded from: classes7.dex */
public class a extends d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f37151b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37152c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f37153d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f37154e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37155f;

    /* renamed from: g  reason: collision with root package name */
    public e f37156g = new e() { // from class: com.kwad.sdk.reward.b.c.b.a.1
        @Override // com.kwad.sdk.reward.a.e
        public void a() {
            a.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        String k = com.kwad.sdk.core.response.b.b.k(this.f37154e);
        if (TextUtils.isEmpty(k)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        if (aVar.f36954e == 1 || (aVar.p && aVar.q)) {
            this.f37152c.setVisibility(8);
            this.f37151b.setText(k);
            this.f37151b.setVisibility(0);
            textView = this.f37151b;
        } else {
            this.f37151b.setVisibility(8);
            this.f37152c.setText(k);
            this.f37152c.setVisibility(0);
            textView = this.f37152c;
        }
        textView.setOnClickListener(this);
        f();
    }

    private void f() {
        com.kwad.sdk.core.report.b.c(this.f37154e, 17, ((d) this).f37201a.f36953d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.kwad.sdk.core.report.b.a(this.f37154e, 39, ((d) this).f37201a.f36957h.getTouchCoords(), ((d) this).f37201a.f36953d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f37153d.a();
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((d) this).f37201a;
        this.f37153d = aVar.f36951b;
        this.f37154e = aVar.f36955f;
        this.f37155f = aVar.j;
        aVar.n.add(this.f37156g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((d) this).f37201a.n.remove(this.f37156g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f37151b = (TextView) b(R.id.ksad_end_left_call_btn);
        this.f37152c = (TextView) b(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f37151b || view == this.f37152c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37154e, new a.InterfaceC0379a() { // from class: com.kwad.sdk.reward.b.c.b.a.2
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.g();
                    a.this.h();
                }
            }, this.f37155f);
        }
    }
}
