package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.page.widget.b f32787a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f32788b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32789c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f32790d;

    /* renamed from: e  reason: collision with root package name */
    public a f32791e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32792f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32793g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f32794h;
    public PhotoInfo.VideoInfo i;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f32792f = false;
        this.f32793g = false;
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32792f = false;
        this.f32793g = false;
        a(context);
    }

    private void a() {
        this.f32787a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.f32790d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f32790d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f32788b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f32789c != null) {
                    DetailVideoView.this.f32789c.a(DetailVideoView.this.f32788b);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    private void a(Context context) {
        this.f32794h = new Matrix();
        this.f32787a = new com.kwad.sdk.core.page.widget.b(context);
        addView(this.f32787a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f32788b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f32788b = null;
        }
    }

    public void a(int i, int i2) {
        if (this.f32793g) {
            ao.b(this.f32787a, i, i2);
        } else if (this.f32792f) {
            ao.a(this.f32787a, i, i2);
        } else {
            View view = (View) this.f32787a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.i;
            if (videoInfo != null && ao.a(this.f32794h, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f32787a.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f32787a.setTransform(this.f32794h);
                this.f32787a.setLayoutParams(layoutParams);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.f32787a.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
            this.f32794h.reset();
            this.f32787a.setTransform(this.f32794h);
            this.f32787a.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32787a) {
            a aVar = this.f32791e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f32791e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f32790d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f32790d = null;
        }
    }

    public void setAd(boolean z) {
        this.f32792f = z;
    }

    public void setClickListener(a aVar) {
        this.f32791e = aVar;
        setOnClickListener(this);
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f32789c = aVar;
        Surface surface = this.f32788b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.i = videoInfo;
    }
}
