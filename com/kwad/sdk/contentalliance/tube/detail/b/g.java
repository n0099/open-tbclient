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
    public LottieAnimationView f33825b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f33826c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33827d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33828e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33829f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33830g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33831h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33832i;
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
            com.kwad.sdk.contentalliance.tube.b bVar = ((com.kwad.sdk.contentalliance.tube.detail.a.a) g.this).f33768a.f33775g;
            if (bVar != null) {
                g.this.f33832i = true;
                g.this.f();
                bVar.a(false, 0L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        g();
        if (this.f33832i && !com.ksad.download.d.b.a(o())) {
            p.a(o());
            this.f33832i = false;
        }
        c(i2);
    }

    private void c(int i2) {
        this.f33826c.setVisibility(0);
        if (!com.ksad.download.d.b.a(o()) || i2 == com.kwad.sdk.core.network.f.f34497a.k) {
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
        this.f33825b.setVisibility(8);
        this.f33827d.setVisibility(8);
        this.f33826c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33827d.setVisibility(0);
        this.f33825b.setVisibility(0);
        if (!this.f33825b.c()) {
            this.f33825b.b();
        }
        this.f33826c.setVisibility(8);
    }

    private void g() {
        this.f33827d.setVisibility(8);
        if (!this.f33825b.c()) {
            this.f33825b.d();
        }
        this.f33825b.setVisibility(8);
    }

    private void h() {
        this.f33829f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_content_network_error));
        this.f33828e.setText(q.d(o()));
        this.f33830g.setText(q.e(o()));
        this.f33831h.setText(q.i(o()));
    }

    private void p() {
        this.f33829f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_data_img));
        this.f33828e.setText(q.g(o()));
        this.f33830g.setText(q.h(o()));
        this.f33831h.setText(q.i(o()));
    }

    private void q() {
        this.f33829f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_no_video_img));
        this.f33828e.setText(o().getString(R.string.ksad_video_no_found));
        this.f33830g.setText(o().getString(R.string.ksad_click_to_next_video));
        this.f33831h.setText(o().getString(R.string.ksad_watch_next_video));
    }

    @Override // com.kwad.sdk.contentalliance.tube.detail.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.add(this.j);
        this.f33831h.setOnClickListener(this.k);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.contentalliance.tube.detail.a.a) this).f33768a.f33772d.remove(this.j);
        this.f33831h.setOnClickListener(null);
        g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33825b = (LottieAnimationView) b(R.id.ksad_center_loading_animation_view);
        this.f33826c = (ViewGroup) b(R.id.ksad_error_container);
        this.f33827d = (ImageView) b(R.id.ksad_tube_loading_mask_view);
        this.f33828e = (TextView) b(R.id.ksad_load_error_title);
        this.f33829f = (ImageView) b(R.id.ksad_load_error_img);
        this.f33830g = (TextView) b(R.id.ksad_load_error_tip);
        this.f33831h = (TextView) b(R.id.ksad_retry_btn);
        int i2 = R.raw.ksad_detail_loading_amin_new;
        this.f33827d.setVisibility(4);
        this.f33825b.setVisibility(0);
        this.f33825b.setRepeatMode(1);
        this.f33825b.setRepeatCount(-1);
        this.f33825b.setAnimation(i2);
    }
}
