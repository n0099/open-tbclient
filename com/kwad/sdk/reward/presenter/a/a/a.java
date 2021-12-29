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
    public TextView f59607b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59608c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f59609d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59610e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59611f;

    /* renamed from: g  reason: collision with root package name */
    public f f59612g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
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
        String f2 = com.kwad.sdk.core.response.a.c.f(this.f59610e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f59454f == 1 || (aVar.r && aVar.s)) {
            this.f59608c.setVisibility(8);
            this.f59607b.setText(f2);
            this.f59607b.setVisibility(0);
            textView = this.f59607b;
        } else {
            this.f59607b.setVisibility(8);
            this.f59608c.setText(f2);
            this.f59608c.setVisibility(0);
            textView = this.f59608c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f59610e, 17, ((g) this).a.f59453e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f59610e, 39, ((g) this).a.f59458j.getTouchCoords(), ((g) this).a.f59453e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f59609d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f59609d = aVar.f59450b;
        this.f59610e = aVar.f59455g;
        this.f59611f = aVar.l;
        aVar.a(this.f59612g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f59612g);
        this.f59607b.setVisibility(8);
        this.f59608c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59607b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f59608c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f59607b || view == this.f59608c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2083a(view.getContext()).a(this.f59610e).a(this.f59611f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
