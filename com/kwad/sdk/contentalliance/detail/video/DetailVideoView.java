package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.g;
/* loaded from: classes4.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {
    public com.kwad.sdk.core.page.widget.c a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f55769b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f55770c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f55771d;

    /* renamed from: e  reason: collision with root package name */
    public a f55772e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55773f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55774g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55775h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55776i;

    /* renamed from: j  reason: collision with root package name */
    public Matrix f55777j;
    public PhotoInfo.VideoInfo k;
    public final RectF l;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f55773f = false;
        this.f55774g = false;
        this.f55775h = false;
        this.f55776i = false;
        this.l = new RectF();
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55773f = false;
        this.f55774g = false;
        this.f55775h = false;
        this.f55776i = false;
        this.l = new RectF();
        a(context);
    }

    private void a() {
        this.a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.f55771d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f55771d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f55769b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f55770c != null) {
                    DetailVideoView.this.f55770c.a(DetailVideoView.this.f55769b);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    private void a(Context context) {
        this.f55777j = new Matrix();
        this.a = new com.kwad.sdk.core.page.widget.c(context);
        addView(this.a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    private void a(View view, long j2, long j3) {
        View view2;
        if (view == null || j2 == 0 || j3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f2 = ((float) j2) / ((float) j3);
        float f3 = height * f2;
        float f4 = width;
        if (f3 > f4) {
            height = (int) (f4 / f2);
        } else {
            width = (int) f3;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f55769b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f55769b = null;
        }
    }

    public void a(int i2) {
        com.kwad.sdk.core.page.widget.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = cVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
            this.a.requestLayout();
        }
    }

    public void a(int i2, int i3) {
        if (this.f55773f) {
            com.kwad.sdk.a.kwai.a.b(this.a, i2, i3);
        } else if (this.f55775h) {
            com.kwad.sdk.a.kwai.a.c(this.a, i2, i3);
        } else if (this.f55774g) {
            com.kwad.sdk.a.kwai.a.a(this.a, i2, i3);
        } else if (this.f55776i) {
            a(this.a, i2, i3);
        } else {
            View view = (View) this.a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.k;
            if (videoInfo == null || !bb.a(this.f55777j, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                this.f55777j.reset();
                this.a.setTransform(this.f55777j);
                this.a.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.a.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.a.setTransform(this.f55777j);
                this.a.setLayoutParams(layoutParams2);
            }
            this.l.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
        }
    }

    public void a(boolean z) {
        this.f55775h = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a) {
            a aVar = this.f55772e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f55772e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f55771d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f55771d = null;
        }
    }

    public void setAd(boolean z) {
        this.f55774g = z;
    }

    public void setClickListener(a aVar) {
        this.f55772e = aVar;
        setOnClickListener(this);
    }

    public void setForce(boolean z) {
        this.f55773f = z;
    }

    public void setHorizontalVideo(boolean z) {
        this.f55776i = z;
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f55770c = aVar;
        Surface surface = this.f55769b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setRadius(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            g.a(this, f2);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.k = videoInfo;
    }
}
