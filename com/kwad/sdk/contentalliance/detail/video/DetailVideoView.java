package com.kwad.sdk.contentalliance.detail.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class DetailVideoView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.page.widget.c f31925a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f31926b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f31927c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f31928d;

    /* renamed from: e  reason: collision with root package name */
    public a f31929e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31930f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31931g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31932h;

    /* renamed from: i  reason: collision with root package name */
    public Matrix f31933i;
    public PhotoInfo.VideoInfo j;
    public final RectF k;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f31930f = false;
        this.f31931g = false;
        this.f31932h = false;
        this.k = new RectF();
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31930f = false;
        this.f31931g = false;
        this.f31932h = false;
        this.k = new RectF();
        a(context);
    }

    private void a() {
        this.f31925a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.f31928d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f31928d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f31926b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f31927c != null) {
                    DetailVideoView.this.f31927c.a(DetailVideoView.this.f31926b);
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
        this.f31933i = new Matrix();
        this.f31925a = new com.kwad.sdk.core.page.widget.c(context);
        addView(this.f31925a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    private void a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f2 = ((float) j) / ((float) j2);
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
        this.f31925a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f31926b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f31926b = null;
        }
    }

    public void a(int i2, int i3) {
        if (this.f31931g) {
            an.b(this.f31925a, i2, i3);
        } else if (this.f31930f) {
            an.a(this.f31925a, i2, i3);
        } else if (this.f31932h) {
            a(this.f31925a, i2, i3);
        } else {
            View view = (View) this.f31925a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.j;
            if (videoInfo == null || !an.a(this.f31933i, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f31925a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                this.f31933i.reset();
                this.f31925a.setTransform(this.f31933i);
                this.f31925a.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f31925a.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.f31925a.setTransform(this.f31933i);
                this.f31925a.setLayoutParams(layoutParams2);
            }
            this.k.set(this.f31925a.getLeft(), this.f31925a.getTop(), this.f31925a.getRight(), this.f31925a.getBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31925a) {
            a aVar = this.f31929e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f31929e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f31928d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f31928d = null;
        }
    }

    public void setAd(boolean z) {
        this.f31930f = z;
    }

    public void setClickListener(a aVar) {
        this.f31929e = aVar;
        setOnClickListener(this);
    }

    public void setHorizontalVideo(boolean z) {
        this.f31932h = z;
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f31927c = aVar;
        Surface surface = this.f31926b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.j = videoInfo;
    }
}
