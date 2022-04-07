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
/* loaded from: classes5.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {
    public com.kwad.sdk.core.page.widget.c a;
    public Surface b;
    public com.kwad.sdk.contentalliance.detail.video.a c;
    public SurfaceTexture d;
    public a e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public Matrix j;
    public PhotoInfo.VideoInfo k;
    public final RectF l;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.l = new RectF();
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.l = new RectF();
        a(context);
    }

    private void a() {
        this.a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.b = new Surface(surfaceTexture);
                if (DetailVideoView.this.c != null) {
                    DetailVideoView.this.c.a(DetailVideoView.this.b);
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
        this.j = new Matrix();
        this.a = new com.kwad.sdk.core.page.widget.c(context);
        addView(this.a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    private void a(View view2, long j, long j2) {
        View view3;
        if (view2 == null || j == 0 || j2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view2.getLayoutParams();
        float f = ((float) j) / ((float) j2);
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.b = null;
        }
    }

    public void a(int i) {
        com.kwad.sdk.core.page.widget.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = cVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.a.requestLayout();
        }
    }

    public void a(int i, int i2) {
        if (this.f) {
            com.kwad.sdk.a.kwai.a.b(this.a, i, i2);
        } else if (this.h) {
            com.kwad.sdk.a.kwai.a.c(this.a, i, i2);
        } else if (this.g) {
            com.kwad.sdk.a.kwai.a.a(this.a, i, i2);
        } else if (this.i) {
            a(this.a, i, i2);
        } else {
            View view2 = (View) this.a.getParent();
            if (view2 == null) {
                return;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.k;
            if (videoInfo == null || !bb.a(this.j, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
                this.j.reset();
                this.a.setTransform(this.j);
                this.a.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.a.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.a.setTransform(this.j);
                this.a.setLayoutParams(layoutParams2);
            }
            this.l.set(this.a.getLeft(), this.a.getTop(), this.a.getRight(), this.a.getBottom());
        }
    }

    public void a(boolean z) {
        this.h = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.a) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.d = null;
        }
    }

    public void setAd(boolean z) {
        this.g = z;
    }

    public void setClickListener(a aVar) {
        this.e = aVar;
        setOnClickListener(this);
    }

    public void setForce(boolean z) {
        this.f = z;
    }

    public void setHorizontalVideo(boolean z) {
        this.i = z;
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.c = aVar;
        Surface surface = this.b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            g.a(this, f);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.k = videoInfo;
    }
}
