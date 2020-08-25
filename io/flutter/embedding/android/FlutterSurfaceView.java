package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
/* loaded from: classes19.dex */
public class FlutterSurfaceView extends SurfaceView implements RenderSurface {
    private static final String TAG = "FlutterSurfaceView";
    @Nullable
    private FlutterRenderer flutterRenderer;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private boolean isAttachedToFlutterRenderer;
    private boolean isSurfaceAvailableForRendering;
    private final boolean renderTransparently;
    private final SurfaceHolder.Callback surfaceCallback;

    public FlutterSurfaceView(@NonNull Context context) {
        this(context, null, false);
    }

    public FlutterSurfaceView(@NonNull Context context, boolean z) {
        this(context, null, z);
    }

    public FlutterSurfaceView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceCallback = new SurfaceHolder.Callback() { // from class: io.flutter.embedding.android.FlutterSurfaceView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.startRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = true;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.connectSurfaceToRenderer();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.surfaceChanged()");
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.changeSurfaceSize(i2, i3);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                Log.v(FlutterSurfaceView.TAG, "SurfaceHolder.Callback.stopRenderingToSurface()");
                FlutterSurfaceView.this.isSurfaceAvailableForRendering = false;
                if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
                    FlutterSurfaceView.this.disconnectSurfaceFromRenderer();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterSurfaceView.2
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                Log.v(FlutterSurfaceView.TAG, "onFlutterUiDisplayed()");
                FlutterSurfaceView.this.setAlpha(1.0f);
                if (FlutterSurfaceView.this.flutterRenderer != null) {
                    FlutterSurfaceView.this.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }
        };
        this.renderTransparently = z;
        init();
    }

    private void init() {
        if (this.renderTransparently) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.surfaceCallback);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer) {
        Log.v(TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        }
        this.flutterRenderer = flutterRenderer;
        this.isAttachedToFlutterRenderer = true;
        this.flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (this.isSurfaceAvailableForRendering) {
            Log.v(TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        if (this.flutterRenderer != null) {
            if (getWindowToken() != null) {
                Log.v(TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            setAlpha(0.0f);
            this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w(TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectSurfaceToRenderer() {
        if (this.flutterRenderer == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceSize(int i, int i2) {
        if (this.flutterRenderer == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        Log.v(TAG, "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.flutterRenderer.surfaceChanged(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectSurfaceFromRenderer() {
        if (this.flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        this.flutterRenderer.stopRenderingToSurface();
    }
}
