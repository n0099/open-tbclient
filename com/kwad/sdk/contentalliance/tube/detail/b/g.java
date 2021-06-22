package com.kwad.sdk.contentalliance.tube.detail.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.q;
/* loaded from: classes6.dex */
public class g extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f33923b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33924c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33925d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33926e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33927f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33928g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33929h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33930i;
    public b.a j = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i2, String str) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i2 + " msg=" + str);
            if (z) {
                return;
            }
            g.this.a(i2);
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, @NonNull AdResultData adResultData) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void b(boolean z) {
            if (z) {
                return;
            }
            g.this.e();
        }
    };
    public View.OnClickListener k = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.kwad.sdk.contentalliance.tube.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) g.this).f33866a.f33873g;
            if (bVar != null) {
                g.this.f33930i = true;
                g.this.f();
                bVar.a(false, 0L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        g();
        if (this.f33930i && !com.ksad.download.d.b.a(o())) {
            p.a(o());
            this.f33930i = false;
        }
        c(i2);
    }

    private void c(int i2) {
        this.f33924c.setVisibility(0);
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
        this.f33923b.setVisibility(8);
        this.f33925d.setVisibility(8);
        this.f33924c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33925d.setVisibility(0);
        this.f33923b.setVisibility(0);
        if (!this.f33923b.c()) {
            this.f33923b.b();
        }
        this.f33924c.setVisibility(8);
    }

    private void g() {
        this.f33925d.setVisibility(8);
        if (!this.f33923b.c()) {
            this.f33923b.d();
        }
        this.f33923b.setVisibility(8);
    }

    private void h() {
        this.f33927f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33926e.setText(q.d(o()));
        this.f33928g.setText(q.e(o()));
        this.f33929h.setText(q.i(o()));
    }

    private void p() {
        this.f33927f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33926e.setText(q.g(o()));
        this.f33928g.setText(q.h(o()));
        this.f33929h.setText(q.i(o()));
    }

    private void q() {
        this.f33927f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33926e.setText(o().getString(R.string.ksad_video_no_found));
        this.f33928g.setText(o().getString(R.string.ksad_click_to_next_video));
        this.f33929h.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33870d.add(this.j);
        this.f33929h.setOnClickListener(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33866a.f33870d.remove(this.j);
        this.f33929h.setOnClickListener(null);
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33923b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33924c = (ViewGroup) b(R.id.ksad_error_container);
        this.f33925d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.f33926e = (TextView) b(R.id.ksad_load_error_title);
        this.f33927f = (ImageView) b(R.id.ksad_load_error_img);
        this.f33928g = (TextView) b(R.id.ksad_load_error_tip);
        this.f33929h = (TextView) b(R.id.ksad_retry_btn);
        int i2 = R.raw.ksad_detail_loading_amin_new;
        this.f33925d.setVisibility(4);
        this.f33923b.setVisibility(0);
        this.f33923b.setRepeatMode(1);
        this.f33923b.setRepeatCount(-1);
        this.f33923b.setAnimation(i2);
    }
}
