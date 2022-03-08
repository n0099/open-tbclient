package com.kwad.sdk.reward.presenter.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes8.dex */
public class a extends g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public TextView f55917b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55918c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f55919d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f55920e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f55921f;

    /* renamed from: g  reason: collision with root package name */
    public f f55922g = new f() { // from class: com.kwad.sdk.reward.presenter.a.a.a.1
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
        String f2 = com.kwad.sdk.core.response.a.c.f(this.f55920e);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        if (aVar.f55768f == 1 || (aVar.r && aVar.s)) {
            this.f55918c.setVisibility(8);
            this.f55917b.setText(f2);
            this.f55917b.setVisibility(0);
            textView = this.f55917b;
        } else {
            this.f55917b.setVisibility(8);
            this.f55918c.setText(f2);
            this.f55918c.setVisibility(0);
            textView = this.f55918c;
        }
        textView.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.f55920e, 17, ((g) this).a.f55767e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.f55920e, 39, ((g) this).a.f55772j.getTouchCoords(), ((g) this).a.f55767e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f55919d.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.f55919d = aVar.f55764b;
        this.f55920e = aVar.f55769g;
        this.f55921f = aVar.l;
        aVar.a(this.f55922g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((g) this).a.b(this.f55922g);
        this.f55917b.setVisibility(8);
        this.f55918c.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55917b = (TextView) a(R.id.ksad_end_left_call_btn);
        this.f55918c = (TextView) a(R.id.ksad_end_right_call_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55917b || view == this.f55918c) {
            com.kwad.sdk.core.download.a.a.a(new a.C2095a(view.getContext()).a(this.f55920e).a(this.f55921f).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.reward.presenter.a.a.a.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    a.this.r();
                    a.this.s();
                }
            }));
        }
    }
}
