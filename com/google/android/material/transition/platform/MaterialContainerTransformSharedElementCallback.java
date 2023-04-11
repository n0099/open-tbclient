package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.baidu.tieba.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
@RequiresApi(21)
/* loaded from: classes8.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    @Nullable
    public static WeakReference<View> capturedSharedElement;
    @Nullable
    public Rect returnEndBounds;
    public boolean entering = true;
    public boolean transparentWindowBackgroundEnabled = true;
    public boolean sharedElementReenterTransitionEnabled = false;
    @Nullable
    public ShapeProvider shapeProvider = new ShapeableViewShapeProvider();

    /* loaded from: classes8.dex */
    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View view2);
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    /* loaded from: classes8.dex */
    public static class ShapeableViewShapeProvider implements ShapeProvider {
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View view2) {
            if (view2 instanceof Shapeable) {
                return ((Shapeable) view2).getShapeAppearanceModel();
            }
            return null;
        }
    }

    public static void removeWindowBackground(Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    public static void restoreWindowBackground(Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void setUpEnterTransform(final Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
            if (!this.sharedElementReenterTransitionEnabled) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.restoreWindowBackground(window);
                    }

                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }
                });
            }
        }
    }

    public void setShapeProvider(@Nullable ShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    public void setSharedElementReenterTransitionEnabled(boolean z) {
        this.sharedElementReenterTransitionEnabled = z;
    }

    public void setTransparentWindowBackgroundEnabled(boolean z) {
        this.transparentWindowBackgroundEnabled = z;
    }

    private void setUpReturnTransform(final Activity activity, final Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
            MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementReturnTransition;
            materialContainerTransform.setHoldAtEndEnabled(true);
            materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
                @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    View view2;
                    if (MaterialContainerTransformSharedElementCallback.capturedSharedElement != null && (view2 = (View) MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()) != null) {
                        view2.setAlpha(1.0f);
                        WeakReference unused = MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                    }
                    activity.finish();
                    activity.overridePendingTransition(0, 0);
                }
            });
            if (this.transparentWindowBackgroundEnabled) {
                updateBackgroundFadeDuration(window, materialContainerTransform);
                materialContainerTransform.addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.3
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition) {
                        MaterialContainerTransformSharedElementCallback.removeWindowBackground(window);
                    }
                });
            }
        }
    }

    public static void updateBackgroundFadeDuration(Window window, MaterialContainerTransform materialContainerTransform) {
        window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view2;
        ShapeAppearanceModel provideShape;
        View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (onCreateSnapshotView != null && (weakReference = capturedSharedElement) != null && this.shapeProvider != null && (view2 = weakReference.get()) != null && (provideShape = this.shapeProvider.provideShape(view2)) != null) {
            onCreateSnapshotView.setTag(R.id.obfuscated_res_0x7f091716, provideShape);
        }
        return onCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view2, @NonNull Matrix matrix, @NonNull RectF rectF) {
        capturedSharedElement = new WeakReference<>(view2);
        return super.onCaptureSharedElementSnapshot(view2, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view2;
        Activity activity;
        if (!list.isEmpty() && !map.isEmpty() && (view2 = map.get(list.get(0))) != null && (activity = ContextUtils.getActivity(view2.getContext())) != null) {
            Window window = activity.getWindow();
            if (this.entering) {
                setUpEnterTransform(window);
            } else {
                setUpReturnTransform(activity, window);
            }
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && (list2.get(0).getTag(R.id.obfuscated_res_0x7f091716) instanceof View)) {
            list2.get(0).setTag(R.id.obfuscated_res_0x7f091716, null);
        }
        if (!this.entering && !list2.isEmpty()) {
            this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(list2.get(0));
        }
        this.entering = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.obfuscated_res_0x7f091716, list3.get(0));
        }
        if (!this.entering && !list2.isEmpty() && this.returnEndBounds != null) {
            View view2 = list2.get(0);
            view2.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
            Rect rect = this.returnEndBounds;
            view2.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
