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
/* loaded from: classes4.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f57567b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57568c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f57569d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f57570e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f57571f;

    /* renamed from: g  reason: collision with root package name */
    public f f57572g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
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
        String f2 = com.kwad.sdk.core.response.a.c.f(this.f57570e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f57418f == 1 || (aVar.r && aVar.s)) {
            this.f57568c.setVisibility(8);
            this.f57567b.setText(f2);
            this.f57567b.setVisibility(0);
            textView = this.f57567b;
        } else {
            this.f57567b.setVisibility(8);
            this.f57568c.setText(f2);
            this.f57568c.setVisibility(0);
            textView = this.f57568c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f57570e, 17, ((g) this).a.f57417e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f57570e, 39, ((g) this).a.f57422j.getTouchCoords(), ((g) this).a.f57417e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f57569d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f57569d = aVar.f57414b;
        this.f57570e = aVar.f57419g;
        this.f57571f = aVar.l;
        aVar.a(this.f57572g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f57572g);
        this.f57567b.setVisibility(8);
        this.f57568c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57567b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f57568c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57567b || view == this.f57568c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2116a(view.getContext()).a(this.f57570e).a(this.f57571f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
