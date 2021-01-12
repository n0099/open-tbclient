package com.kwad.sdk.contentalliance.detail.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8283b;
    private AdTemplate c;
    private Runnable d = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f8393a.k == null || !a.this.f8393a.k.isAdded() || a.this.f8393a.k.getActivity() == null) {
                return;
            }
            int width = a.this.l().getWidth();
            int height = a.this.l().getHeight();
            com.kwad.sdk.core.response.model.c m = com.kwad.sdk.core.response.b.c.m(a.this.c);
            ViewGroup.LayoutParams layoutParams = a.this.f8283b.getLayoutParams();
            int c = m.c();
            int b2 = m.b();
            if (c == 0 || b2 == 0) {
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f8283b.setLayoutParams(layoutParams);
                a.this.f8283b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if (ao.a(null, width, height, a.this.c.photoInfo.videoInfo)) {
                ViewGroup.LayoutParams layoutParams2 = a.this.f8283b.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                a.this.f8283b.setLayoutParams(layoutParams2);
                a.this.f8283b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                layoutParams.width = width;
                layoutParams.height = (int) (width * (b2 / (c * 1.0f)));
                a.this.f8283b.setLayoutParams(layoutParams);
                a.this.f8283b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            final String a2 = m.a();
            try {
                com.kwad.sdk.glide.c.a(a.this.f8393a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, a.this.c)).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                        return false;
                    }

                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                        com.kwad.sdk.core.report.e.a(a.this.f8393a.j, a2);
                        return false;
                    }
                }).a(a.this.f8283b);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.b(e);
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.a e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f8283b.setVisibility(0);
        }
    };
    private com.kwad.sdk.contentalliance.detail.video.e f = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (com.kwad.sdk.core.response.b.c.c(a.this.c)) {
                return;
            }
            a.this.f8393a.l.post(a.this.g);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f8283b.getVisibility() == 0) {
                a.this.f8283b.setVisibility(8);
            }
        }
    };
    private Runnable g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.e()) {
                a.this.f8393a.l.a(true);
            } else if (a.this.f8393a.m != null) {
                a.this.f8393a.m.h();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        SceneImpl sceneImpl;
        int pageScene = (this.c == null || (sceneImpl = this.c.mAdScene) == null) ? 0 : sceneImpl.getPageScene();
        return this.f8393a.l.a() || !this.f8393a.l.k() || this.f8393a.g || ((pageScene == 1 && com.kwad.sdk.core.config.c.t() == 1) || (pageScene == 5 && com.kwad.sdk.core.config.c.u() == 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = this.f8393a.j;
        l().post(this.d);
        this.f8393a.f8403b.add(this.e);
        if (this.f8393a.m != null) {
            this.f8393a.m.a(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.d);
        this.f8393a.l.removeCallbacks(this.g);
        this.f8393a.f8403b.remove(this.e);
        if (this.f8393a.m != null) {
            this.f8393a.m.b(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8283b = (ImageView) b(R.id.ksad_video_first_frame);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        View l = l();
        if (l != null) {
            l.removeCallbacks(this.d);
        }
    }
}
