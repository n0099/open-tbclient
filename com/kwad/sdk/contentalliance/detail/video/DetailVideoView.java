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
    public com.kwad.sdk.core.page.widget.c f32751a;

    /* renamed from: b  reason: collision with root package name */
    public Surface f32752b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.a f32753c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceTexture f32754d;

    /* renamed from: e  reason: collision with root package name */
    public a f32755e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32756f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32757g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32758h;

    /* renamed from: i  reason: collision with root package name */
    public Matrix f32759i;
    public PhotoInfo.VideoInfo j;
    public final RectF k;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.f32756f = false;
        this.f32757g = false;
        this.f32758h = false;
        this.k = new RectF();
        a(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32756f = false;
        this.f32757g = false;
        this.f32758h = false;
        this.k = new RectF();
        a(context);
    }

    private void a() {
        this.f32751a.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.sdk.contentalliance.detail.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                if (DetailVideoView.this.f32754d == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.f32754d = surfaceTexture;
                DetailVideoView.this.b();
                DetailVideoView.this.f32752b = new Surface(surfaceTexture);
                if (DetailVideoView.this.f32753c != null) {
                    DetailVideoView.this.f32753c.a(DetailVideoView.this.f32752b);
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
        this.f32759i = new Matrix();
        this.f32751a = new com.kwad.sdk.core.page.widget.c(context);
        addView(this.f32751a, 0, new FrameLayout.LayoutParams(-1, -1, 17));
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
        this.f32751a.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Surface surface = this.f32752b;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
            }
            this.f32752b = null;
        }
    }

    public void a(int i2, int i3) {
        if (this.f32757g) {
            an.b(this.f32751a, i2, i3);
        } else if (this.f32756f) {
            an.a(this.f32751a, i2, i3);
        } else if (this.f32758h) {
            a(this.f32751a, i2, i3);
        } else {
            View view = (View) this.f32751a.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.j;
            if (videoInfo == null || !an.a(this.f32759i, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.f32751a.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
                this.f32759i.reset();
                this.f32751a.setTransform(this.f32759i);
                this.f32751a.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.f32751a.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.f32751a.setTransform(this.f32759i);
                this.f32751a.setLayoutParams(layoutParams2);
            }
            this.k.set(this.f32751a.getLeft(), this.f32751a.getTop(), this.f32751a.getRight(), this.f32751a.getBottom());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32751a) {
            a aVar = this.f32755e;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a aVar2 = this.f32755e;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SurfaceTexture surfaceTexture = this.f32754d;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f32754d = null;
        }
    }

    public void setAd(boolean z) {
        this.f32756f = z;
    }

    public void setClickListener(a aVar) {
        this.f32755e = aVar;
        setOnClickListener(this);
    }

    public void setHorizontalVideo(boolean z) {
        this.f32758h = z;
    }

    public void setMediaPlayer(com.kwad.sdk.contentalliance.detail.video.a aVar) {
        this.f32753c = aVar;
        Surface surface = this.f32752b;
        if (surface == null || aVar == null) {
            return;
        }
        aVar.a(surface);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.j = videoInfo;
    }
}
