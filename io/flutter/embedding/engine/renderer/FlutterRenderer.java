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
/* loaded from: classes12.dex */
public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    @NonNull
    private final FlutterJNI flutterJNI;
    @Nullable
    private Surface surface;
    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    private boolean isDisplayingFlutterUi = false;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiDisplayed() {
            FlutterRenderer.this.isDisplayingFlutterUi = true;
        }

        @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
        public void onFlutterUiNoLongerDisplayed() {
            FlutterRenderer.this.isDisplayingFlutterUi = false;
        }
    };

    /* loaded from: classes12.dex */
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
        this.flutterJNI = flutterJNI;
        this.flutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener);
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

    /* loaded from: classes12.dex */
    final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        private final long id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released) {
                    FlutterRenderer.this.markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.id);
                }
            }
        };
        private boolean released;
        @NonNull
        private final SurfaceTexture surfaceTexture;

        SurfaceTextureRegistryEntry(long j, @NonNull SurfaceTexture surfaceTexture) {
            this.id = j;
            this.surfaceTexture = surfaceTexture;
            if (Build.VERSION.SDK_INT >= 21) {
                this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                this.surfaceTexture.setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.surfaceTexture;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (!this.released) {
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
                this.surfaceTexture.release();
                FlutterRenderer.this.unregisterTexture(this.id);
                this.released = true;
            }
        }
    }

    public void startRenderingToSurface(@NonNull Surface surface) {
        if (this.surface != null) {
            stopRenderingToSurface();
        }
        this.surface = surface;
        this.flutterJNI.onSurfaceCreated(surface);
    }

    public void surfaceChanged(int i, int i2) {
        this.flutterJNI.onSurfaceChanged(i, i2);
    }

    public void stopRenderingToSurface() {
        this.flutterJNI.onSurfaceDestroyed();
        this.surface = null;
        if (this.isDisplayingFlutterUi) {
            this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
        this.isDisplayingFlutterUi = false;
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.paddingLeft + ", T: " + viewportMetrics.paddingTop + ", R: " + viewportMetrics.paddingRight + ", B: " + viewportMetrics.paddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.viewInsetBottom);
        this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.paddingTop, viewportMetrics.paddingRight, viewportMetrics.paddingBottom, viewportMetrics.paddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i);
    }

    private void registerTexture(long j, @NonNull SurfaceTexture surfaceTexture) {
        this.flutterJNI.registerTexture(j, surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long j) {
        this.flutterJNI.markTextureFrameAvailable(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long j) {
        this.flutterJNI.unregisterTexture(j);
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.nativeGetIsSoftwareRenderingEnabled();
    }

    public void setAccessibilityFeatures(int i) {
        this.flutterJNI.setAccessibilityFeatures(i);
    }

    public void setSemanticsEnabled(boolean z) {
        this.flutterJNI.setSemanticsEnabled(z);
    }

    public void dispatchSemanticsAction(int i, int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        this.flutterJNI.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }
}
