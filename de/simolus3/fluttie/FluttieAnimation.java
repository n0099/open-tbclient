package de.simolus3.fluttie;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.airbnb.lottie.e;
import com.airbnb.lottie.g;
import com.baidu.adp.lib.util.BdLog;
import io.flutter.view.TextureRegistry;
@RequiresApi(api = 15)
/* loaded from: classes18.dex */
public class FluttieAnimation implements ValueAnimator.AnimatorUpdateListener {
    private e composition;
    private g drawable;
    private volatile boolean isDisposed;
    private boolean pausedButNotByUser;

    /* renamed from: plugin  reason: collision with root package name */
    private final FluttiePlugin f5131plugin;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry surfaceTexture;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FluttieAnimation(FluttiePlugin fluttiePlugin, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, e eVar, float f, String str) {
        this.f5131plugin = fluttiePlugin;
        this.surfaceTexture = surfaceTextureEntry;
        this.surface = new Surface(surfaceTextureEntry.surfaceTexture());
        Rect iu = eVar.iu();
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize((int) (iu.width() * f), (int) (iu.height() * f));
        this.drawable = new g();
        this.drawable.enableMergePathsForKitKatAndAbove(true);
        this.drawable.setScale(f);
        this.composition = eVar;
        this.drawable.a(eVar);
        if (str != null) {
            this.drawable.be("flutter_assets/" + str);
        }
        this.drawable.addAnimatorUpdateListener(this);
        fluttiePlugin.getRenderingThreads().markDirty(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRepeatOptions(int i, int i2) {
        this.drawable.setRepeatCount(i);
        this.drawable.setRepeatMode(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDuration(int i) {
        this.drawable.setSpeed(Math.copySign(this.composition.iv() / i, this.drawable.getSpeed()));
    }

    public int getId() {
        return (int) this.surfaceTexture.id();
    }

    public Canvas lockCanvas() {
        try {
            if (!this.surface.isValid() || this.isDisposed) {
                return null;
            }
            return this.surface.lockCanvas(null);
        } catch (Exception e) {
            BdLog.w("Could not obtain canvas. If you remembered to call FluttieAnimationController.dispose(), this should not occur often and is not a problem. exception:" + e);
            return null;
        }
    }

    public void drawFrame(Canvas canvas) {
        if (!this.isDisposed) {
            canvas.drawColor(-1, PorterDuff.Mode.CLEAR);
            try {
                this.drawable.draw(canvas);
            } catch (NullPointerException e) {
                BdLog.d("Could not draw. Disposed: " + this.isDisposed + " exception:" + e);
            }
        }
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        try {
            this.surface.unlockCanvasAndPost(canvas);
        } catch (Exception e) {
            BdLog.w("Could not send canvas to flutter. If you remembered to call FluttieAnimationController.dispose(), this should not occur often and is not a problem. exception:" + e);
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@Nullable ValueAnimator valueAnimator) {
        this.f5131plugin.getRenderingThreads().markDirty(this);
    }

    public boolean isPlaying() {
        return this.drawable.isAnimating();
    }

    public boolean isPausedButNotByUser() {
        return this.pausedButNotByUser;
    }

    public void setPausedButNotByUser(boolean z) {
        this.pausedButNotByUser = z;
    }

    public void startAnimation() {
        stopAnimation(true);
        this.drawable.start();
    }

    public void resumeAnimation() {
        this.drawable.resumeAnimation();
    }

    public void pauseAnimation() {
        this.drawable.pauseAnimation();
    }

    public void stopAnimation(boolean z) {
        this.drawable.stop();
        this.drawable.setProgress(z ? 0.0f : 1.0f);
    }

    public void stopAndRelease() {
        BdLog.d("Disposing animation with id " + getId());
        this.isDisposed = true;
        stopAnimation(false);
        this.drawable.clearComposition();
        this.surfaceTexture.release();
        this.surface.release();
    }
}
