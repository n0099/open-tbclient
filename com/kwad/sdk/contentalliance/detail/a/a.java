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
    public ImageView f32217b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32218c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f32219d = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            ImageView.ScaleType scaleType;
            ImageView imageView;
            if (((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.k == null || !((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.k.isAdded() || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.k.getActivity() == null) {
                return;
            }
            int width = a.this.l().getWidth();
            int height = a.this.l().getHeight();
            com.kwad.sdk.core.response.model.c m = com.kwad.sdk.core.response.b.c.m(a.this.f32218c);
            ViewGroup.LayoutParams layoutParams = a.this.f32217b.getLayoutParams();
            int c2 = m.c();
            int b2 = m.b();
            try {
                if (c2 == 0 || b2 == 0) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    a.this.f32217b.setLayoutParams(layoutParams);
                } else if (!ao.a(null, width, height, a.this.f32218c.photoInfo.videoInfo)) {
                    layoutParams.width = width;
                    layoutParams.height = (int) ((b2 / (c2 * 1.0f)) * width);
                    a.this.f32217b.setLayoutParams(layoutParams);
                    imageView = a.this.f32217b;
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                    imageView.setScaleType(scaleType);
                    final String a2 = m.a();
                    com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, a.this.f32218c)).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                            return false;
                        }

                        @Override // com.kwad.sdk.glide.request.e
                        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                            com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.j, a2);
                            return false;
                        }
                    }).a(a.this.f32217b);
                    return;
                } else {
                    ViewGroup.LayoutParams layoutParams2 = a.this.f32217b.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    a.this.f32217b.setLayoutParams(layoutParams2);
                }
                com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.k).a(a2).a((com.kwad.sdk.glide.request.e<Drawable>) new com.kwad.sdk.c(a2, a.this.f32218c)).b(new com.kwad.sdk.glide.request.e<Drawable>() { // from class: com.kwad.sdk.contentalliance.detail.a.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z) {
                        return false;
                    }

                    @Override // com.kwad.sdk.glide.request.e
                    public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z) {
                        com.kwad.sdk.core.report.e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.j, a2);
                        return false;
                    }
                }).a(a.this.f32217b);
                return;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
                return;
            }
            imageView = a.this.f32217b;
            scaleType = ImageView.ScaleType.CENTER_CROP;
            imageView.setScaleType(scaleType);
            final String a22 = m.a();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f32220e = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            a.this.f32217b.setVisibility(0);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32221f = new f() { // from class: com.kwad.sdk.contentalliance.detail.a.a.3
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            if (com.kwad.sdk.core.response.b.c.c(a.this.f32218c)) {
                return;
            }
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.l.post(a.this.f32222g);
        }

        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void d() {
            super.d();
            if (a.this.f32217b.getVisibility() == 0) {
                a.this.f32217b.setVisibility(8);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public Runnable f32222g = new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.a.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.e()) {
                ((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.l.a(true);
            } else if (((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.m != null) {
                ((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.m.h();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.f32218c;
        int pageScene = (adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? 0 : sceneImpl.getPageScene();
        return ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.l.a() || !((com.kwad.sdk.contentalliance.detail.b) this).f32422a.l.k() || ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32447g || ((pageScene == 1 && com.kwad.sdk.core.config.c.t() == 1) || (pageScene == 5 && com.kwad.sdk.core.config.c.u() == 1));
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32218c = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
        l().post(this.f32219d);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.f32220e);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.a(this.f32221f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        l().removeCallbacks(this.f32219d);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.l.removeCallbacks(this.f32222g);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.f32220e);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.b(this.f32221f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32217b = (ImageView) b(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        super.d();
        View l = l();
        if (l != null) {
            l.removeCallbacks(this.f32219d);
        }
    }
}
