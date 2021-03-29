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
    public com.kwad.sdk.contentalliance.tube.profile.c f33272b;

    /* renamed from: c  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.tube.profile.e> f33273c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f33274d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f33275e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33276f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33277g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33278h;
    public ImageView i;
    public TextView k;
    public com.kwad.sdk.contentalliance.tube.profile.a j = new com.kwad.sdk.contentalliance.tube.profile.a() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.1
        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a() {
            e.this.f();
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a(int i, String str) {
            e.this.a(i);
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void a(TubeProfileResultData tubeProfileResultData) {
            com.kwad.sdk.core.d.a.a("TubeProfileUpdatePresenter", "tube/profile OK");
            for (com.kwad.sdk.contentalliance.tube.profile.e eVar : e.this.f33273c) {
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
    public void a(int i) {
        g();
        if (this.l && !com.ksad.download.d.b.a(o())) {
            p.a(o());
            this.l = false;
        }
        c(i);
    }

    private void c(int i) {
        this.f33275e.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i == com.kwad.sdk.core.network.f.f33869a.k) {
            h();
        } else if (i == com.kwad.sdk.core.network.f.j.k) {
            q();
        } else {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        this.f33274d.setVisibility(8);
        this.i.setVisibility(8);
        this.f33275e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i.setVisibility(0);
        this.f33274d.setVisibility(0);
        if (!this.f33274d.c()) {
            this.f33274d.b();
        }
        this.f33275e.setVisibility(8);
    }

    private void g() {
        this.i.setVisibility(8);
        if (!this.f33274d.c()) {
            this.f33274d.d();
        }
        this.f33274d.setVisibility(8);
    }

    private void h() {
        this.f33277g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33276f.setText(q.d(o()));
        this.f33278h.setText(q.e(o()));
        this.k.setText(q.i(o()));
    }

    private void p() {
        this.f33277g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33276f.setText(q.g(o()));
        this.f33278h.setText(q.h(o()));
        this.k.setText(q.i(o()));
    }

    private void q() {
        this.f33277g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33276f.setText(o().getString(R.string.ksad_video_no_found));
        this.f33278h.setText(o().getString(R.string.ksad_click_to_next_video));
        this.k.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.tube.profile.a.b bVar = ((com.kwad.sdk.contentalliance.tube.profile.a.a) this).f33231a;
        this.f33273c = bVar.f33236e;
        com.kwad.sdk.contentalliance.tube.profile.c cVar = new com.kwad.sdk.contentalliance.tube.profile.c(bVar.f33237f, bVar.f33234c.getTubeId(), this.j);
        this.f33272b = cVar;
        cVar.a();
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.l = true;
                e.this.f33272b.a();
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33272b.b();
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33274d = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33275e = (ViewGroup) b(R.id.ksad_error_container);
        this.i = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.k = (TextView) b(R.id.ksad_retry_btn);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.i.setVisibility(0);
        this.f33276f = (TextView) b(R.id.ksad_load_error_title);
        this.f33277g = (ImageView) b(R.id.ksad_load_error_img);
        this.f33278h = (TextView) b(R.id.ksad_load_error_tip);
        this.f33274d.setVisibility(0);
        this.f33274d.setRepeatMode(1);
        this.f33274d.setRepeatCount(-1);
        this.f33274d.setAnimation(i);
    }
}
