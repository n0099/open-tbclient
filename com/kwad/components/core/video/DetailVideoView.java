package com.kwad.components.core.video;

import android.animation.ValueAnimator;
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
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.VideoAdapters;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b Uc;
    public b Ud;
    public SurfaceTexture Ue;
    public Surface Uf;
    public a Ug;
    public PhotoInfo.VideoInfo Uh;
    public final RectF Ui;
    public int Uj;
    public int Uk;
    @NonNull
    public final d Ul;
    public Matrix mMatrix;

    /* loaded from: classes10.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Ui = new RectF();
        this.Uj = 0;
        this.Uk = 0;
        this.Ul = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.Uc = new com.kwad.components.core.page.widget.b(context);
        addView(this.Uc, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        rm();
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.Ul.aQ(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.Uc) {
            a aVar = this.Ug;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Ug;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Deprecated
    public void setAd(boolean z) {
        this.Ul.setAd(z);
    }

    public void setClickListener(a aVar) {
        this.Ug = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.Ul.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.Ul.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.Ul.setHorizontalVideo(z);
    }

    public void setMediaPlayer(b bVar) {
        this.Ud = bVar;
        Surface surface = this.Uf;
        if (surface != null && bVar != null) {
            bVar.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.h.b(this, f);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Uh = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.Uc;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.Uc.requestLayout();
        }
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ui = new RectF();
        this.Uj = 0;
        this.Uk = 0;
        this.Ul = new d();
        B(context);
    }

    public final void g(boolean z, int i) {
        this.Ul.setAd(true);
        this.Ul.aI(i);
    }

    private void a(View view2, long j, long j2) {
        View view3;
        if (view2 == null || j == 0 || j2 == 0 || (view3 = (View) view2.getParent()) == null) {
            return;
        }
        int width = view3.getWidth();
        int height = view3.getHeight();
        if (width != 0 && height != 0) {
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
            this.Uc.setLayoutParams(layoutParams);
        }
    }

    private void rm() {
        this.Uc.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.Ue != surfaceTexture) {
                    DetailVideoView.this.Ue = surfaceTexture;
                    DetailVideoView.this.rn();
                    DetailVideoView.this.Uf = new Surface(surfaceTexture);
                    if (DetailVideoView.this.Ud != null) {
                        DetailVideoView.this.Ud.setSurface(DetailVideoView.this.Uf);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn() {
        Surface surface = this.Uf;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            this.Uf = null;
        }
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.Uc;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return 17;
        }
        return ((FrameLayout.LayoutParams) layoutParams).gravity;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rn();
        SurfaceTexture surfaceTexture = this.Ue;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Ue = null;
        }
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean W = com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.dP(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (W) {
                    int i2 = (int) (intValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = intValue;
                        layoutParams2.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, intValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = intValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ofInt.setDuration(500L);
        ofInt.setInterpolator(create);
        return ofInt;
    }

    public final void adaptVideoSize(int i, int i2) {
        if (this.Uc == null) {
            com.kwad.sdk.core.e.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.Uk = i2;
        this.Uj = i;
        if (this.Ul.ro()) {
            int rp = this.Ul.rp();
            VideoAdapters.a aVar = null;
            if (rp != 1) {
                if (rp == 2) {
                    aVar = new VideoAdapters.b();
                }
            } else {
                aVar = new VideoAdapters.c();
            }
            if (aVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.Uc;
                aVar.a(bVar, (View) bVar.getParent(), i, i2);
            }
        } else if (this.Ul.ru()) {
            com.kwad.sdk.d.a.a.D(this.Uc);
        } else if (this.Ul.rq()) {
            com.kwad.sdk.d.a.a.e(this.Uc, i, i2);
        } else if (this.Ul.rs()) {
            com.kwad.sdk.d.a.a.f(this.Uc, i, i2);
        } else if (this.Ul.rr()) {
            com.kwad.sdk.d.a.a.d(this.Uc, i, i2);
        } else if (this.Ul.rt()) {
            a(this.Uc, i, i2);
        } else {
            View view2 = (View) this.Uc.getParent();
            if (view2 == null) {
                return;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width != 0 && height != 0) {
                PhotoInfo.VideoInfo videoInfo = this.Uh;
                if (videoInfo != null && com.kwad.sdk.core.response.b.h.a(this.mMatrix, width, height, videoInfo)) {
                    ViewGroup.LayoutParams layoutParams = this.Uc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.Uc.setTransform(this.mMatrix);
                    this.Uc.setLayoutParams(layoutParams);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.Uc.getLayoutParams();
                    layoutParams2.width = width;
                    layoutParams2.height = (int) ((i2 / (i * 1.0f)) * width);
                    this.mMatrix.reset();
                    this.Uc.setTransform(this.mMatrix);
                    this.Uc.setLayoutParams(layoutParams2);
                }
                this.Ui.set(this.Uc.getLeft(), this.Uc.getTop(), this.Uc.getRight(), this.Uc.getBottom());
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.Uj;
        if (i6 > 0 && (i5 = this.Uk) > 0) {
            adaptVideoSize(i6, i5);
        }
    }
}
