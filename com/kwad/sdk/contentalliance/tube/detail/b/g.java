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
    public LottieAnimationView f33212b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33213c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33214d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33215e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33216f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33217g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33218h;
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
            com.kwad.sdk.contentalliance.tube.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) g.this).f33157a.f33164g;
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
        this.f33213c.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i == com.kwad.sdk.core.network.f.f33868a.k) {
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
        this.f33212b.setVisibility(8);
        this.f33214d.setVisibility(8);
        this.f33213c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33214d.setVisibility(0);
        this.f33212b.setVisibility(0);
        if (!this.f33212b.c()) {
            this.f33212b.b();
        }
        this.f33213c.setVisibility(8);
    }

    private void g() {
        this.f33214d.setVisibility(8);
        if (!this.f33212b.c()) {
            this.f33212b.d();
        }
        this.f33212b.setVisibility(8);
    }

    private void h() {
        this.f33216f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33215e.setText(q.d(o()));
        this.f33217g.setText(q.e(o()));
        this.f33218h.setText(q.i(o()));
    }

    private void p() {
        this.f33216f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33215e.setText(q.g(o()));
        this.f33217g.setText(q.h(o()));
        this.f33218h.setText(q.i(o()));
    }

    private void q() {
        this.f33216f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33215e.setText(o().getString(R.string.ksad_video_no_found));
        this.f33217g.setText(o().getString(R.string.ksad_click_to_next_video));
        this.f33218h.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33161d.add(this.j);
        this.f33218h.setOnClickListener(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33157a.f33161d.remove(this.j);
        this.f33218h.setOnClickListener(null);
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33212b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33213c = (ViewGroup) b(R.id.ksad_error_container);
        this.f33214d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.f33215e = (TextView) b(R.id.ksad_load_error_title);
        this.f33216f = (ImageView) b(R.id.ksad_load_error_img);
        this.f33217g = (TextView) b(R.id.ksad_load_error_tip);
        this.f33218h = (TextView) b(R.id.ksad_retry_btn);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.f33214d.setVisibility(4);
        this.f33212b.setVisibility(0);
        this.f33212b.setRepeatMode(1);
        this.f33212b.setRepeatCount(-1);
        this.f33212b.setAnimation(i);
    }
}
