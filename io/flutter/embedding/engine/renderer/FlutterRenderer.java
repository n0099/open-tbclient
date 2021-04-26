package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
@TargetApi(16)
/* loaded from: classes7.dex */
public class FlutterRenderer implements TextureRegistry {
    public static final String TAG = "FlutterRenderer";
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final FlutterUiDisplayListener flutterUiDisplayListener;
    @Nullable
    public Surface surface;
    @NonNull
    public final AtomicLong nextTextureId = new AtomicLong(0);
    public boolean isDisplayingFlutterUi = false;

    /* loaded from: classes7.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        public final long id;
        public SurfaceTexture.OnFrameAvailableListener onFrameListener;
        public boolean released;
        @NonNull
        public final SurfaceTexture surfaceTexture;

        public SurfaceTextureRegistryEntry(long j, @NonNull SurfaceTexture surfaceTexture) {
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture2) {
                    if (SurfaceTextureRegistryEntry.this.released) {
                        return;
                    }
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = SurfaceTextureRegistryEntry.this;
                    FlutterRenderer.this.markTextureFrameAvailable(surfaceTextureRegistryEntry.id);
                }
            };
            this.onFrameListener = onFrameAvailableListener;
            this.id = j;
            this.surfaceTexture = surfaceTexture;
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener, new Handler());
            } else {
                surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
            this.surfaceTexture.release();
            FlutterRenderer.this.unregisterTexture(this.id);
            this.released = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.surfaceTexture;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ViewportMetrics {
        public float devicePixelRatio = 1.0f;
        public int width = 0;
        public int height = 0;
        public int paddingTop = 0;
        public int paddingRight = 0;
        public int paddingBottom = 0;
        public int paddingLeft = 0;
        public int viewInsetTop = 0;
        public int viewInsetRight = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int systemGestureInsetTop = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI) {
        FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = flutterUiDisplayListener;
        this.flutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long j) {
        this.flutterJNI.markTextureFrameAvailable(j);
    }

    private void registerTexture(long j, @NonNull SurfaceTexture surfaceTexture) {
        this.flutterJNI.registerTexture(j, surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long j) {
        this.flutterJNI.unregisterTexture(j);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTexture);
        return surfaceTextureRegistryEntry;
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i2) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i2);
    }

    public void dispatchSemanticsAction(int i2, int i3, @Nullable ByteBuffer byteBuffer, int i4) {
        this.flutterJNI.dispatchSemanticsAction(i2, i3, byteBuffer, i4);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.nativeGetIsSoftwareRenderingEnabled();
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    public void setAccessibilityFeatures(int i2) {
        this.flutterJNI.setAccessibilityFeatures(i2);
    }

    public void setSemanticsEnabled(boolean z) {
        this.flutterJNI.setSemanticsEnabled(z);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.paddingLeft + ", T: " + viewportMetrics.paddingTop + ", R: " + viewportMetrics.paddingRight + ", B: " + viewportMetrics.paddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.viewInsetBottom);
        this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.paddingTop, viewportMetrics.paddingRight, viewportMetrics.paddingBottom, viewportMetrics.paddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft);
    }

    public void startRenderingToSurface(@NonNull Surface surface) {
        if (this.surface != null) {
            stopRenderingToSurface();
        }
        this.surface = surface;
        this.flutterJNI.onSurfaceCreated(surface);
    }

    public void stopRenderingToSurface() {
        this.flutterJNI.onSurfaceDestroyed();
        this.surface = null;
        if (this.isDisplayingFlutterUi) {
            this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
        this.isDisplayingFlutterUi = false;
    }

    public void surfaceChanged(int i2, int i3) {
        this.flutterJNI.onSurfaceChanged(i2, i3);
    }
}
