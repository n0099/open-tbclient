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
    public LottieAnimationView f33502b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33503c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33504d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33505e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33506f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33507g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33508h;
    public boolean i;
    public b.a j = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.1
        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z) {
        }

        @Override // com.kwad.sdk.contentalliance.tube.b.a
        public void a(boolean z, int i, String str) {
            com.kwad.sdk.core.d.a.a("TubeFeedUpdatePresenter", "tube/feed isLoadMore" + z + " code=" + i + " msg=" + str);
            if (z) {
                return;
            }
            g.this.a(i);
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
            com.kwad.sdk.contentalliance.tube.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) g.this).f33447a.f33454g;
            if (bVar != null) {
                g.this.i = true;
                g.this.f();
                bVar.a(false, 0L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        g();
        if (this.i && !com.ksad.download.d.b.a(o())) {
            p.a(o());
            this.i = false;
        }
        c(i);
    }

    private void c(int i) {
        this.f33503c.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i == com.kwad.sdk.core.network.f.f34158a.k) {
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
        this.f33502b.setVisibility(8);
        this.f33504d.setVisibility(8);
        this.f33503c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33504d.setVisibility(0);
        this.f33502b.setVisibility(0);
        if (!this.f33502b.c()) {
            this.f33502b.b();
        }
        this.f33503c.setVisibility(8);
    }

    private void g() {
        this.f33504d.setVisibility(8);
        if (!this.f33502b.c()) {
            this.f33502b.d();
        }
        this.f33502b.setVisibility(8);
    }

    private void h() {
        this.f33506f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33505e.setText(q.d(o()));
        this.f33507g.setText(q.e(o()));
        this.f33508h.setText(q.i(o()));
    }

    private void p() {
        this.f33506f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33505e.setText(q.g(o()));
        this.f33507g.setText(q.h(o()));
        this.f33508h.setText(q.i(o()));
    }

    private void q() {
        this.f33506f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33505e.setText(o().getString(R.string.ksad_video_no_found));
        this.f33507g.setText(o().getString(R.string.ksad_click_to_next_video));
        this.f33508h.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.add(this.j);
        this.f33508h.setOnClickListener(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33447a.f33451d.remove(this.j);
        this.f33508h.setOnClickListener(null);
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33502b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33503c = (ViewGroup) b(R.id.ksad_error_container);
        this.f33504d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.f33505e = (TextView) b(R.id.ksad_load_error_title);
        this.f33506f = (ImageView) b(R.id.ksad_load_error_img);
        this.f33507g = (TextView) b(R.id.ksad_load_error_tip);
        this.f33508h = (TextView) b(R.id.ksad_retry_btn);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.f33504d.setVisibility(4);
        this.f33502b.setVisibility(0);
        this.f33502b.setRepeatMode(1);
        this.f33502b.setRepeatCount(-1);
        this.f33502b.setAnimation(i);
    }
}
