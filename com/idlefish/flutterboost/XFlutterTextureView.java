package com.idlefish.flutterboost;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
/* loaded from: classes6.dex */
public class XFlutterTextureView extends TextureView implements RenderSurface {
    @Nullable
    public FlutterRenderer flutterRenderer;
    public boolean isAttachedToFlutterRenderer;
    public boolean isSurfaceAvailableForRendering;
    public Surface renderSurface;
    public final TextureView.SurfaceTextureListener surfaceTextureListener;

    public XFlutterTextureView(@NonNull Context context) {
        this(context, null);
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void attachToRenderer(@NonNull FlutterRenderer flutterRenderer) {
        Log.v(FlutterTextureView.TAG, "Attaching to FlutterRenderer.");
        if (this.flutterRenderer != null) {
            Log.v(FlutterTextureView.TAG, "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.flutterRenderer.stopRenderingToSurface();
        }
        this.flutterRenderer = flutterRenderer;
        this.isAttachedToFlutterRenderer = true;
        if (this.isSurfaceAvailableForRendering) {
            Log.v(FlutterTextureView.TAG, "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            connectSurfaceToRenderer();
        }
    }

    public final void changeSurfaceSize(int i2, int i3) {
        if (this.flutterRenderer != null) {
            Log.v(FlutterTextureView.TAG, "Notifying FlutterRenderer that Android surface size has changed to " + i2 + " x " + i3);
            this.flutterRenderer.surfaceChanged(i2, i3);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }

    public final void connectSurfaceToRenderer() {
        if (this.flutterRenderer != null && getSurfaceTexture() != null) {
            Surface surface = new Surface(getSurfaceTexture());
            this.renderSurface = surface;
            this.flutterRenderer.startRenderingToSurface(surface);
            return;
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    public void detachFromRenderer() {
        if (this.flutterRenderer != null) {
            if (getWindowToken() != null) {
                Log.v(FlutterTextureView.TAG, "Disconnecting FlutterRenderer from Android surface.");
                disconnectSurfaceFromRenderer();
            }
            this.flutterRenderer = null;
            this.isAttachedToFlutterRenderer = false;
            return;
        }
        Log.w(FlutterTextureView.TAG, "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    }

    public final void disconnectSurfaceFromRenderer() {
        FlutterRenderer flutterRenderer = this.flutterRenderer;
        if (flutterRenderer != null) {
            flutterRenderer.stopRenderingToSurface();
            Surface surface = this.renderSurface;
            if (surface != null) {
                surface.release();
                this.renderSurface = null;
                return;
            }
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }

    @Override // io.flutter.embedding.engine.renderer.RenderSurface
    @Nullable
    public FlutterRenderer getAttachedRenderer() {
        return this.flutterRenderer;
    }

    public final void init() {
        setSurfaceTextureListener(this.surfaceTextureListener);
    }

    public XFlutterTextureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSurfaceAvailableForRendering = false;
        this.isAttachedToFlutterRenderer = false;
        this.surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.idlefish.flutterboost.XFlutterTextureView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureAvailable()");
                XFlutterTextureView.this.isSurfaceAvailableForRendering = true;
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.connectSurfaceToRenderer();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureDestroyed()");
                XFlutterTextureView.this.isSurfaceAvailableForRendering = false;
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.disconnectSurfaceFromRenderer();
                    return true;
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i2, int i3) {
                Log.v(FlutterTextureView.TAG, "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
                if (XFlutterTextureView.this.isAttachedToFlutterRenderer) {
                    XFlutterTextureView.this.changeSurfaceSize(i2, i3);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
            }
        };
        init();
    }
}
