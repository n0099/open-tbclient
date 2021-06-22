package com.kwad.sdk.contentalliance.tube.profile.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfileResultData;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
import java.util.Set;
/* loaded from: classes6.dex */
public class e extends com.kwad.sdk.contentalliance.tube.profile.a.a {

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.profile.c f33984b;

    /* renamed from: c  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.tube.profile.e> f33985c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f33986d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f33987e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33988f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33989g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33990h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f33991i;
    public TextView k;
    public com.kwad.sdk.contentalliance.tube.profile.a j = new com.kwad.sdk.contentalliance.tube.profile.a() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a() {
            e.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a(int i2, String str) {
            e.this.a(i2);
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a(TubeProfileResultData tubeProfileResultData) {
            com.kwad.sdk.core.d.a.a("TubeProfileUpdatePresenter", "tube/profile OK");
            for (com.kwad.sdk.contentalliance.tube.profile.e eVar : e.this.f33985c) {
                eVar.a(tubeProfileResultData);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void b() {
            e.this.e();
        }
    };
    public boolean l = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        g();
        if (this.l && !com.ksad.download.d.b.a(o())) {
            p.a(o());
            this.l = false;
        }
        c(i2);
    }

    private void c(int i2) {
        this.f33987e.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i2 == com.kwad.sdk.core.network.f.f34595a.k) {
            h();
        } else if (i2 == com.kwad.sdk.core.network.f.j.k) {
            q();
        } else {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        this.f33986d.setVisibility(8);
        this.f33991i.setVisibility(8);
        this.f33987e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33991i.setVisibility(0);
        this.f33986d.setVisibility(0);
        if (!this.f33986d.c()) {
            this.f33986d.b();
        }
        this.f33987e.setVisibility(8);
    }

    private void g() {
        this.f33991i.setVisibility(8);
        if (!this.f33986d.c()) {
            this.f33986d.d();
        }
        this.f33986d.setVisibility(8);
    }

    private void h() {
        this.f33989g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33988f.setText(q.d(o()));
        this.f33990h.setText(q.e(o()));
        this.k.setText(q.i(o()));
    }

    private void p() {
        this.f33989g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33988f.setText(q.g(o()));
        this.f33990h.setText(q.h(o()));
        this.k.setText(q.i(o()));
    }

    private void q() {
        this.f33989g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33988f.setText(o().getString(R.string.ksad_video_no_found));
        this.f33990h.setText(o().getString(R.string.ksad_click_to_next_video));
        this.k.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33942a;
        this.f33985c = bVar.f33947e;
        com.kwad.sdk.contentalliance.tube.profile.c cVar = new com.kwad.sdk.contentalliance.tube.profile.c(bVar.f33948f, bVar.f33945c.getTubeId(), this.j);
        this.f33984b = cVar;
        cVar.a();
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.l = true;
                e.this.f33984b.a();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33984b.b();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33986d = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33987e = (ViewGroup) b(R.id.ksad_error_container);
        this.f33991i = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.k = (TextView) b(R.id.ksad_retry_btn);
        int i2 = R.raw.ksad_detail_loading_amin_new;
        this.f33991i.setVisibility(0);
        this.f33988f = (TextView) b(R.id.ksad_load_error_title);
        this.f33989g = (ImageView) b(R.id.ksad_load_error_img);
        this.f33990h = (TextView) b(R.id.ksad_load_error_tip);
        this.f33986d.setVisibility(0);
        this.f33986d.setRepeatMode(1);
        this.f33986d.setRepeatCount(-1);
        this.f33986d.setAnimation(i2);
    }
}
