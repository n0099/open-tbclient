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
    public com.kwad.sdk.core.page.widget.b f33076a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f33077b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f33078c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f33079d;

    /* renamed from: e  reason: collision with root package name */
    public a f33080e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33081f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f33082g;

    /* renamed from: h  reason: collision with root package name */
    public Matrix f33083h;

    /* renamed from: i  reason: collision with root package name */
    public PhotoInfo.VideoInfo f33084i;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f33081f = false;
        this.f33082g = false;
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33081f = false;
        this.f33082g = false;
        a(context);
    }

    private void a() {
        this.f33076a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.f33079d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f33079d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f33077b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f33078c != null) {
                    DetailVideoView.this.f33078c.a(DetailVideoView.this.f33077b);
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
        this.f33083h = new Matrix();
        this.f33076a = new com.kwad.sdk.core.page.widget.b(context);
        addView(this.f33076a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f33077b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f33077b = null;
        }
    }

    public void a(int i2, int i3) {
        if (this.f33082g) {
            ao.b(this.f33076a, i2, i3);
        } else if (this.f33081f) {
            ao.a(this.f33076a, i2, i3);
        } else {
            View view = (View) this.f33076a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.f33084i;
            if (videoInfo != null && ao.a(this.f33083h, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f33076a.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.f33076a.setTransform(this.f33083h);
                this.f33076a.setLayoutParams(layoutParams);
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.f33076a.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = (int) ((i3 / (i2 * 1.0f)) * width);
            this.f33083h.reset();
            this.f33076a.setTransform(this.f33083h);
            this.f33076a.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33076a) {
            a aVar = this.f33080e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f33080e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f33079d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f33079d = null;
        }
    }

    public void setAd(boolean z) {
        this.f33081f = z;
    }

    public void setClickListener(a aVar) {
        this.f33080e = aVar;
        setOnClickListener(this);
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f33078c = aVar;
        Surface surface = this.f33077b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.f33084i = videoInfo;
    }
}
