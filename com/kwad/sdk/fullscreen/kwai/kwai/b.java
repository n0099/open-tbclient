package com.kwad.sdk.fullscreen.kwai.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
/* loaded from: classes5.dex */
public class b extends g implements View.OnClickListener {
    public ImageView b;
    public TextView c;
    public AdTemplate d;
    public com.kwad.sdk.core.download.a.b e;
    public String f;
    public long g;
    public com.kwad.sdk.contentalliance.detail.video.d h = new e() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void a(long j, long j2) {
            if (j2 >= b.this.g) {
                b.this.e();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.c.getVisibility() == 0) {
            return;
        }
        String e = com.kwad.sdk.core.response.a.c.e(this.d);
        if (TextUtils.isEmpty(e)) {
            return;
        }
        this.c.setText(e);
        this.c.setVisibility(0);
        this.c.setOnClickListener(this);
        i();
    }

    private void i() {
        com.kwad.sdk.core.report.a.c(this.d, 18, ((g) this).a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.kwad.sdk.core.report.a.a(this.d, 40, ((g) this).a.j.getTouchCoords(), ((g) this).a.e);
        ((g) this).a.b.a();
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((g) this).a.g;
        this.d = adTemplate;
        this.g = com.kwad.sdk.core.response.a.c.d(adTemplate);
        String e = com.kwad.sdk.core.response.a.c.e(this.d);
        this.f = e;
        if (TextUtils.isEmpty(e)) {
            return;
        }
        com.kwad.sdk.reward.a aVar = ((g) this).a;
        this.e = aVar.l;
        aVar.k.a(this.h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        ((g) this).a.k.b(this.h);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.c = (TextView) a(R.id.obfuscated_res_0x7f09105d);
        this.b = (ImageView) a(R.id.obfuscated_res_0x7f091131);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.c) {
            com.kwad.sdk.core.download.a.a.a(new a.C0296a(view2.getContext()).a(this.d).a(this.e).a(false).a(2).a(new a.b() { // from class: com.kwad.sdk.fullscreen.kwai.kwai.b.2
                @Override // com.kwad.sdk.core.download.a.a.b
                public void a() {
                    b.this.r();
                }
            }));
        }
    }
}
