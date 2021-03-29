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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31928b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f31929c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f31930d = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            ImageView.ScaleType scaleType;
            ImageView imageView;
            if (((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.k == null || !((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.k.isAdded() || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.k.getActivity() == null) {
                return;
            }
            int width = a.this.l().getWidth();
            int height = a.this.l().getHeight();
            com.kwad.sdk.core.response.model.c m = com.kwad.sdk.core.response.b.c.m(a.this.f31929c);
            ViewGroup.LayoutParams layoutParams = a.this.f31928b.getLayoutParams();
            int c2 = m.c();
            int b2 = m.b();
            try {
                if (c2 == 0 || b2 == 0) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    a.this.f31928b.setLayoutParams(layoutParams);
                } else if (!ao.a(null, width, height, a.this.f31929c.photoInfo.videoInfo)) {
                    layoutParams.width = width;
                    layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                    a.this.f31928b.setLayoutParams(layoutParams);
                    imageView = a.this.f31928b;
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                    imageView.setScaleType(scaleType);
                    final String a2 = m.a();
                    com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, a.this.f31929c)).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                            return false;
                        }

                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, a2);
                            return false;
                        }
                    }).a(a.this.f31928b);
                    return;
                } else {
                    ViewGroup.LayoutParams layoutParams2 = a.this.f31928b.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    a.this.f31928b.setLayoutParams(layoutParams2);
                }
                com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, a.this.f31929c)).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                        return false;
                    }

                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, a2);
                        return false;
                    }
                }).a(a.this.f31928b);
                return;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return;
            }
            imageView = a.this.f31928b;
            scaleType = ImageView.ScaleType.CENTER_CROP;
            imageView.setScaleType(scaleType);
            final String a22 = m.a();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f31931e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f31928b.setVisibility(0);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31932f = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (com.kwad.sdk.core.response.b.c.c(a.this.f31929c)) {
                return;
            }
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.l.post(a.this.f31933g);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f31928b.getVisibility() == 0) {
                a.this.f31928b.setVisibility(8);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public Runnable f31933g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.e()) {
                ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.l.a(true);
            } else if (((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.m != null) {
                ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.m.h();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.f31929c;
        int pageScene = (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? 0 : sceneImpl.getPageScene();
        return ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.a() || !((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.k() || ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32158g || ((pageScene == 1 && com.kwad.sdk.core.config.c.t() == 1) || (pageScene == 5 && com.kwad.sdk.core.config.c.u() == 1));
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f31929c = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
        l().post(this.f31930d);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.f31931e);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.a(this.f31932f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f31930d);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.removeCallbacks(this.f31933g);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.f31931e);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.b(this.f31932f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31928b = (ImageView) b(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        View l = l();
        if (l != null) {
            l.removeCallbacks(this.f31930d);
        }
    }
}
