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
/* loaded from: classes3.dex */
public class g extends com.kwad.sdk.contentalliance.tube.detail.a.a {

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f8948b;
    private ViewGroup c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private boolean i;
    private b.a j = new b.a() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.1
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
    private View.OnClickListener k = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.detail.b.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.kwad.sdk.contentalliance.tube.b bVar = g.this.f8924a.g;
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
        this.c.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i == com.kwad.sdk.core.network.f.f9323a.k) {
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
        this.f8948b.setVisibility(8);
        this.d.setVisibility(8);
        this.c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d.setVisibility(0);
        this.f8948b.setVisibility(0);
        if (!this.f8948b.c()) {
            this.f8948b.b();
        }
        this.c.setVisibility(8);
    }

    private void g() {
        this.d.setVisibility(8);
        if (!this.f8948b.c()) {
            this.f8948b.d();
        }
        this.f8948b.setVisibility(8);
    }

    private void h() {
        this.f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.e.setText(q.d(o()));
        this.g.setText(q.e(o()));
        this.h.setText(q.i(o()));
    }

    private void p() {
        this.f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.e.setText(q.g(o()));
        this.g.setText(q.h(o()));
        this.h.setText(q.i(o()));
    }

    private void q() {
        this.f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.e.setText(o().getString(R.string.ksad_video_no_found));
        this.g.setText(o().getString(R.string.ksad_click_to_next_video));
        this.h.setText(o().getString(R.string.ksad_watch_next_video));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f8924a.d.add(this.j);
        this.h.setOnClickListener(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8924a.d.remove(this.j);
        this.h.setOnClickListener(null);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8948b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.c = (ViewGroup) b(R.id.ksad_error_container);
        this.d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.e = (TextView) b(R.id.ksad_load_error_title);
        this.f = (ImageView) b(R.id.ksad_load_error_img);
        this.g = (TextView) b(R.id.ksad_load_error_tip);
        this.h = (TextView) b(R.id.ksad_retry_btn);
        int i = R.raw.ksad_detail_loading_amin_new;
        this.d.setVisibility(4);
        this.f8948b.setVisibility(0);
        this.f8948b.setRepeatMode(1);
        this.f8948b.setRepeatCount(-1);
        this.f8948b.setAnimation(i);
    }
}
