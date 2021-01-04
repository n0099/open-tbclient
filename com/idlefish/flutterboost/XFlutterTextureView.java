package com.idlefish.flutterboost;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
/* loaded from: classes7.dex */
public class XFlutterTextureView extends TextureView implements RenderSurface {
    @Nullable
    private FlutterRenderer flutterRenderer;
    private boolean isAttachedToFlutterRenderer;
    private boolean isSurfaceAvailableForRendering;
    private Surface renderSurface;
    private final TextureView.SurfaceTextureListener surfaceTextureListener;

    public XFlutterTextureView(@NonNull Context context) {
        this(context, null);
    }

    public XFlutterTextureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.idlefish.flutterboost.XFlutterTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
                XFlutterTextureView.this.isSurfaceAvailableForRendering = true;
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.connectSurfaceToRenderer();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i2) {
                Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.changeSurfaceSize(i, i2);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                XFlutterTextureView.this.isSurfaceAvailableForRendering = false;
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.disconnectSurfaceFromRenderer();
                    return true;
                }
                return true;
            }
        };
        init();
    }

    private void init() {
        setSurfaceTextureListener(this.surfaceTextureListener);
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer) {
        Log.v("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
        }
        this.flutterRenderer = flutterRenderer;
        this.isAttachedToFlutterRenderer = true;
        if (this.isSurfaceAvailableForRendering) {
            Log.v("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        if (this.flutterRenderer != null) {
            if (getWindowToken() != null) {
                Log.v("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectSurfaceToRenderer() {
        if (this.flutterRenderer == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        this.renderSurface = new Surface(getSurfaceTexture());
        this.flutterRenderer.startRenderingToSurface(this.renderSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSurfaceSize(int i, int i2) {
        if (this.flutterRenderer == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        Log.v("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.flutterRenderer.surfaceChanged(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectSurfaceFromRenderer() {
        if (this.flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        this.flutterRenderer.stopRenderingToSurface();
        if (this.renderSurface != null) {
            this.renderSurface.release();
            this.renderSurface = null;
        }
    }
}
