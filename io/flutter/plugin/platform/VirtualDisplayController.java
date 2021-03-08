package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.TextureRegistry;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(20)
/* loaded from: classes14.dex */
public class VirtualDisplayController {
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    @VisibleForTesting
    SingleViewPresentation presentation;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    private VirtualDisplay virtualDisplay;

    public static VirtualDisplayController create(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, PlatformViewFactory platformViewFactory, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize(i, i2);
        Surface surface = new Surface(surfaceTextureEntry.surfaceTexture());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new VirtualDisplayController(context, accessibilityEventsDelegate, createVirtualDisplay, platformViewFactory, surface, surfaceTextureEntry, onFocusChangeListener, i3, obj);
    }

    private VirtualDisplayController(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, VirtualDisplay virtualDisplay, PlatformViewFactory platformViewFactory, Surface surface, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        this.context = context;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.textureEntry = surfaceTextureEntry;
        this.focusChangeListener = onFocusChangeListener;
        this.surface = surface;
        this.virtualDisplay = virtualDisplay;
        this.densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        this.presentation = new SingleViewPresentation(context, this.virtualDisplay.getDisplay(), platformViewFactory, accessibilityEventsDelegate, i, obj, onFocusChangeListener);
        this.presentation.show();
    }

    public void resize(int i, int i2, final Runnable runnable) {
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState detachState = this.presentation.detachState();
        this.virtualDisplay.setSurface(null);
        this.virtualDisplay.release();
        this.textureEntry.surfaceTexture().setDefaultBufferSize(i, i2);
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.densityDpi, this.surface, 0);
        final View view = getView();
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: io.flutter.plugin.platform.VirtualDisplayController.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                OneTimeOnDrawListener.schedule(view, new Runnable() { // from class: io.flutter.plugin.platform.VirtualDisplayController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.postDelayed(runnable, 128L);
                    }
                });
                view.removeOnAttachStateChangeListener(this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
        singleViewPresentation.show();
        this.presentation.cancel();
        this.presentation = singleViewPresentation;
    }

    public void dispose() {
        PlatformView view = this.presentation.getView();
        this.presentation.cancel();
        this.presentation.detachState();
        view.dispose();
        this.virtualDisplay.release();
        this.textureEntry.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFlutterViewAttached(@NonNull View view) {
        if (this.presentation != null && this.presentation.getView() != null) {
            this.presentation.getView().onFlutterViewAttached(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onFlutterViewDetached() {
        if (this.presentation != null && this.presentation.getView() != null) {
            this.presentation.getView().onFlutterViewDetached();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputConnectionLocked() {
        if (this.presentation != null && this.presentation.getView() != null) {
            this.presentation.getView().onInputConnectionLocked();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputConnectionUnlocked() {
        if (this.presentation != null && this.presentation.getView() != null) {
            this.presentation.getView().onInputConnectionUnlocked();
        }
    }

    public View getView() {
        if (this.presentation == null) {
            return null;
        }
        return this.presentation.getView().getView();
    }

    @TargetApi(16)
    /* loaded from: classes14.dex */
    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            if (this.mOnDrawRunnable != null) {
                this.mOnDrawRunnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() { // from class: io.flutter.plugin.platform.VirtualDisplayController.OneTimeOnDrawListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }
}
