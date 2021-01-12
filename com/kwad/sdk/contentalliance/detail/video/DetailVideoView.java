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
/* loaded from: classes4.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.page.widget.b f8585a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f8586b;
    private com.kwad.sdk.contentalliance.detail.video.a c;
    private SurfaceTexture d;
    private a e;
    private boolean f;
    private boolean g;
    private Matrix h;
    private PhotoInfo.VideoInfo i;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f = false;
        this.g = false;
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
        a(context);
    }

    private void a() {
        this.f8585a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f8586b = new Surface(surfaceTexture);
                if (DetailVideoView.this.c != null) {
                    DetailVideoView.this.c.a(DetailVideoView.this.f8586b);
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
        this.h = new Matrix();
        this.f8585a = new com.kwad.sdk.core.page.widget.b(context);
        addView(this.f8585a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f8586b != null) {
            try {
                this.f8586b.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f8586b = null;
        }
    }

    public void a(int i, int i2) {
        if (this.g) {
            ao.b(this.f8585a, i, i2);
        } else if (this.f) {
            ao.a(this.f8585a, i, i2);
        } else {
            View view = (View) this.f8585a.getParent();
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                if (this.i != null && ao.a(this.h, width, height, this.i)) {
                    ViewGroup.LayoutParams layoutParams = this.f8585a.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.f8585a.setTransform(this.h);
                    this.f8585a.setLayoutParams(layoutParams);
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.f8585a.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = (int) (width * (i2 / (i * 1.0f)));
                this.h.reset();
                this.f8585a.setTransform(this.h);
                this.f8585a.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f8585a) {
            if (this.e != null) {
                this.e.a();
            }
        } else if (this.e != null) {
            this.e.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        if (this.d != null) {
            this.d.release();
            this.d = null;
        }
    }

    public void setAd(boolean z) {
        this.f = z;
    }

    public void setClickListener(a aVar) {
        this.e = aVar;
        setOnClickListener(this);
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.c = aVar;
        if (this.f8586b == null || this.c == null) {
            return;
        }
        this.c.a(this.f8586b);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.i = videoInfo;
    }
}
