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
    public com.kwad.sdk.core.page.widget.c f31996a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f31997b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f31998c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f31999d;

    /* renamed from: e  reason: collision with root package name */
    public a f32000e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32001f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32002g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32003h;

    /* renamed from: i  reason: collision with root package name */
    public Matrix f32004i;
    public PhotoInfo.VideoInfo j;
    public final RectF k;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f32001f = false;
        this.f32002g = false;
        this.f32003h = false;
        this.k = new RectF();
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32001f = false;
        this.f32002g = false;
        this.f32003h = false;
        this.k = new RectF();
        a(context);
    }

    private void a() {
        this.f31996a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.f31999d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f31999d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f31997b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f31998c != null) {
                    DetailVideoView.this.f31998c.a(DetailVideoView.this.f31997b);
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
        this.f32004i = new Matrix();
        this.f31996a = new com.kwad.sdk.core.page.widget.c(context);
        addView(this.f31996a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
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
        this.f31996a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f31997b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f31997b = null;
        }
    }

    public void a(int i2, int i3) {
        if (this.f32002g) {
            an.b(this.f31996a, i2, i3);
        } else if (this.f32001f) {
            an.a(this.f31996a, i2, i3);
        } else if (this.f32003h) {
            a(this.f31996a, i2, i3);
        } else {
            View view = (View) this.f31996a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.j;
            if (videoInfo == null || !an.a(this.f32004i, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f31996a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                this.f32004i.reset();
                this.f31996a.setTransform(this.f32004i);
                this.f31996a.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f31996a.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.f31996a.setTransform(this.f32004i);
                this.f31996a.setLayoutParams(layoutParams2);
            }
            this.k.set(this.f31996a.getLeft(), this.f31996a.getTop(), this.f31996a.getRight(), this.f31996a.getBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31996a) {
            a aVar = this.f32000e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f32000e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f31999d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f31999d = null;
        }
    }

    public void setAd(boolean z) {
        this.f32001f = z;
    }

    public void setClickListener(a aVar) {
        this.f32000e = aVar;
        setOnClickListener(this);
    }

    public void setHorizontalVideo(boolean z) {
        this.f32003h = z;
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f31998c = aVar;
        Surface surface = this.f31997b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.j = videoInfo;
    }
}
