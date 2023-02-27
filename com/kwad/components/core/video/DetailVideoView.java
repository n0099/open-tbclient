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
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b Kb;
    public b Kc;
    public SurfaceTexture Kd;
    public Surface Ke;
    public a Kf;
    public boolean Kg;
    public boolean Kh;
    public boolean Ki;
    public boolean Kj;
    public PhotoInfo.VideoInfo Kk;
    public final RectF Kl;
    public Matrix mMatrix;

    /* loaded from: classes8.dex */
    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.Kg = false;
        this.Kh = false;
        this.Ki = false;
        this.Kj = false;
        this.Kl = new RectF();
        E(context);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kg = false;
        this.Kh = false;
        this.Ki = false;
        this.Kj = false;
        this.Kl = new RectF();
        E(context);
    }

    private void E(Context context) {
        this.mMatrix = new Matrix();
        this.Kb = new com.kwad.components.core.page.widget.b(context);
        addView(this.Kb, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        oZ();
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
        this.Kb.setLayoutParams(layoutParams);
    }

    private void oZ() {
        this.Kb.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.Kd == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.Kd = surfaceTexture;
                DetailVideoView.this.pa();
                DetailVideoView.this.Ke = new Surface(surfaceTexture);
                if (DetailVideoView.this.Kc != null) {
                    DetailVideoView.this.Kc.setSurface(DetailVideoView.this.Ke);
                }
            }

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
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa() {
        Surface surface = this.Ke;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
            this.Ke = null;
        }
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean I = com.kwad.sdk.core.response.a.a.I(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt((int) height, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (I) {
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
        if (this.Kg) {
            com.kwad.sdk.b.kwai.a.e(this.Kb, i, i2);
        } else if (this.Ki) {
            com.kwad.sdk.b.kwai.a.f(this.Kb, i, i2);
        } else if (this.Kh) {
            com.kwad.sdk.b.kwai.a.d(this.Kb, i, i2);
        } else if (this.Kj) {
            a(this.Kb, i, i2);
        } else {
            View view2 = (View) this.Kb.getParent();
            if (view2 == null) {
                return;
            }
            int width = view2.getWidth();
            int height = view2.getHeight();
            if (width == 0 || height == 0) {
                return;
            }
            PhotoInfo.VideoInfo videoInfo = this.Kk;
            if (videoInfo == null || !com.kwad.sdk.core.response.a.f.a(this.mMatrix, width, height, videoInfo)) {
                ViewGroup.LayoutParams layoutParams = this.Kb.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
                this.mMatrix.reset();
                this.Kb.setTransform(this.mMatrix);
                this.Kb.setLayoutParams(layoutParams);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.Kb.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                this.Kb.setTransform(this.mMatrix);
                this.Kb.setLayoutParams(layoutParams2);
            }
            this.Kl.set(this.Kb.getLeft(), this.Kb.getTop(), this.Kb.getRight(), this.Kb.getBottom());
        }
    }

    @Nullable
    public final ValueAnimator ar(int i) {
        float width = getWidth();
        final float height = width / getHeight();
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt((int) width, i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams2 = layoutParams;
                layoutParams2.height = (int) (intValue / height);
                layoutParams2.width = intValue;
                DetailVideoView.this.setLayoutParams(layoutParams2);
            }
        });
        return ofInt;
    }

    public final void fixWidth(boolean z) {
        this.Ki = z;
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.Kb;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.Kb) {
            a aVar = this.Kf;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.Kf;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pa();
        SurfaceTexture surfaceTexture = this.Kd;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Kd = null;
        }
    }

    public void setAd(boolean z) {
        this.Kh = z;
    }

    public void setClickListener(a aVar) {
        this.Kf = aVar;
        setOnClickListener(this);
    }

    public void setForce(boolean z) {
        this.Kg = z;
    }

    public void setHorizontalVideo(boolean z) {
        this.Kj = z;
    }

    public void setMediaPlayer(b bVar) {
        this.Kc = bVar;
        Surface surface = this.Ke;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.kwad.components.core.widget.g.b(this, f);
        }
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.Kk = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.Kb;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.Kb.requestLayout();
        }
    }
}
