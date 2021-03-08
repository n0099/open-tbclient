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
/* loaded from: classes3.dex */
public class e extends com.kwad.sdk.contentalliance.tube.profile.a.a {
    private com.kwad.sdk.contentalliance.tube.profile.c b;
    private Set<com.kwad.sdk.contentalliance.tube.profile.e> c;
    private LottieAnimationView d;
    private ViewGroup e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private ImageView i;
    private TextView k;
    private com.kwad.sdk.contentalliance.tube.profile.a j = new com.kwad.sdk.contentalliance.tube.profile.a() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.1
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
            for (com.kwad.sdk.contentalliance.tube.profile.e eVar : e.this.c) {
                eVar.a(tubeProfileResultData);
            }
        }

        @Override // com.kwad.sdk.contentalliance.tube.profile.a
        public void b() {
            e.this.e();
        }
    };
    private boolean l = false;

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
        this.e.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i == com.kwad.sdk.core.network.f.f6187a.k) {
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
        this.d.setVisibility(8);
        this.i.setVisibility(8);
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.i.setVisibility(0);
        this.d.setVisibility(0);
        if (!this.d.c()) {
            this.d.b();
        }
        this.e.setVisibility(8);
    }

    private void g() {
        this.i.setVisibility(8);
        if (!this.d.c()) {
            this.d.d();
        }
        this.d.setVisibility(8);
    }

    private void h() {
        this.g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f.setText(q.d(o()));
        this.h.setText(q.e(o()));
        this.k.setText(q.i(o()));
    }

    private void p() {
        this.g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f.setText(q.g(o()));
        this.h.setText(q.h(o()));
        this.k.setText(q.i(o()));
    }

    private void q() {
        this.g.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f.setText(o().getString(R.string.ksad_video_no_found));
        this.h.setText(o().getString(R.string.ksad_click_to_next_video));
        this.k.setText(o().getString(R.string.ksad_watch_next_video));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.profile.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f5963a.e;
        this.b = new com.kwad.sdk.contentalliance.tube.profile.c(this.f5963a.f, this.f5963a.c.getTubeId(), this.j);
        this.b.a();
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.profile.b.e.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.this.l = true;
                e.this.b.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.b.b();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.e = (ViewGroup) b(R.id.ksad_error_container);
        this.i = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.k = (TextView) b(R.id.ksad_retry_btn);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.i.setVisibility(0);
        this.f = (TextView) b(R.id.ksad_load_error_title);
        this.g = (ImageView) b(R.id.ksad_load_error_img);
        this.h = (TextView) b(R.id.ksad_load_error_tip);
        this.d.setVisibility(0);
        this.d.setRepeatMode(1);
        this.d.setRepeatCount(-1);
        this.d.setAnimation(i);
    }
}
