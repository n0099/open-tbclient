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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
@RequiresApi(21)
/* loaded from: classes9.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static WeakReference<View> capturedSharedElement;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean entering;
    @Nullable
    public Rect returnEndBounds;
    @Nullable
    public ShapeProvider shapeProvider;
    public boolean sharedElementReenterTransitionEnabled;
    public boolean transparentWindowBackgroundEnabled;

    /* loaded from: classes9.dex */
    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View view);
    }

    /* loaded from: classes9.dex */
    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ShapeableViewShapeProvider() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof Shapeable) {
                    return ((Shapeable) view).getShapeAppearanceModel();
                }
                return null;
            }
            return (ShapeAppearanceModel) invokeL.objValue;
        }
    }

    public MaterialContainerTransformSharedElementCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new ShapeableViewShapeProvider();
    }

    public static void removeWindowBackground(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, window) == null) {
            window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
        }
    }

    public static void restoreWindowBackground(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, window) == null) {
            window.getDecorView().getBackground().mutate().clearColorFilter();
        }
    }

    private void setUpEnterTransform(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, window) == null) {
            Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
            if (sharedElementEnterTransition instanceof MaterialContainerTransform) {
                MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementEnterTransition;
                if (!this.sharedElementReenterTransitionEnabled) {
                    window.setSharedElementReenterTransition(null);
                }
                if (this.transparentWindowBackgroundEnabled) {
                    updateBackgroundFadeDuration(window, materialContainerTransform);
                    materialContainerTransform.addListener(new TransitionListenerAdapter(this, window) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MaterialContainerTransformSharedElementCallback this$0;
                        public final /* synthetic */ Window val$window;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, window};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$window = window;
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public void onTransitionEnd(Transition transition) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                MaterialContainerTransformSharedElementCallback.restoreWindowBackground(this.val$window);
                            }
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public void onTransitionStart(Transition transition) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                                MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
                            }
                        }
                    });
                }
            }
        }
    }

    private void setUpReturnTransform(Activity activity, Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, activity, window) == null) {
            Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
            if (sharedElementReturnTransition instanceof MaterialContainerTransform) {
                MaterialContainerTransform materialContainerTransform = (MaterialContainerTransform) sharedElementReturnTransition;
                materialContainerTransform.setHoldAtEndEnabled(true);
                materialContainerTransform.addListener(new TransitionListenerAdapter(this, activity) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MaterialContainerTransformSharedElementCallback this$0;
                    public final /* synthetic */ Activity val$activity;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$activity = activity;
                    }

                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        View view;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                            if (MaterialContainerTransformSharedElementCallback.capturedSharedElement != null && (view = (View) MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()) != null) {
                                view.setAlpha(1.0f);
                                WeakReference unused = MaterialContainerTransformSharedElementCallback.capturedSharedElement = null;
                            }
                            this.val$activity.finish();
                            this.val$activity.overridePendingTransition(0, 0);
                        }
                    }
                });
                if (this.transparentWindowBackgroundEnabled) {
                    updateBackgroundFadeDuration(window, materialContainerTransform);
                    materialContainerTransform.addListener(new TransitionListenerAdapter(this, window) { // from class: com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MaterialContainerTransformSharedElementCallback this$0;
                        public final /* synthetic */ Window val$window;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, window};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$window = window;
                        }

                        @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                        public void onTransitionStart(Transition transition) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                                MaterialContainerTransformSharedElementCallback.removeWindowBackground(this.val$window);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void updateBackgroundFadeDuration(Window window, MaterialContainerTransform materialContainerTransform) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, window, materialContainerTransform) == null) {
            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
        }
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.shapeProvider : (ShapeProvider) invokeV.objValue;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sharedElementReenterTransitionEnabled : invokeV.booleanValue;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.transparentWindowBackgroundEnabled : invokeV.booleanValue;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View view, @NonNull Matrix matrix, @NonNull RectF rectF) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, view, matrix, rectF)) == null) {
            capturedSharedElement = new WeakReference<>(view);
            return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }
        return (Parcelable) invokeLLL.objValue;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context context, @Nullable Parcelable parcelable) {
        InterceptResult invokeLL;
        WeakReference<View> weakReference;
        View view;
        ShapeAppearanceModel provideShape;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, parcelable)) == null) {
            View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
            if (onCreateSnapshotView != null && (weakReference = capturedSharedElement) != null && this.shapeProvider != null && (view = weakReference.get()) != null && (provideShape = this.shapeProvider.provideShape(view)) != null) {
                onCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, provideShape);
            }
            return onCreateSnapshotView;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> list, @NonNull Map<String, View> map) {
        View view;
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, list, map) == null) || list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activity = ContextUtils.getActivity(view.getContext())) == null) {
            return;
        }
        Window window = activity.getWindow();
        if (this.entering) {
            setUpEnterTransform(window);
        } else {
            setUpReturnTransform(activity, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, list, list2, list3) == null) {
            if (!list2.isEmpty() && (list2.get(0).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)) {
                list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, null);
            }
            if (!this.entering && !list2.isEmpty()) {
                this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(list2.get(0));
            }
            this.entering = false;
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> list, @NonNull List<View> list2, @NonNull List<View> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, list, list2, list3) == null) {
            if (!list2.isEmpty() && !list3.isEmpty()) {
                list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
            }
            if (this.entering || list2.isEmpty() || this.returnEndBounds == null) {
                return;
            }
            View view = list2.get(0);
            view.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
            Rect rect = this.returnEndBounds;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public void setShapeProvider(@Nullable ShapeProvider shapeProvider) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, shapeProvider) == null) {
            this.shapeProvider = shapeProvider;
        }
    }

    public void setSharedElementReenterTransitionEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.sharedElementReenterTransitionEnabled = z;
        }
    }

    public void setTransparentWindowBackgroundEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.transparentWindowBackgroundEnabled = z;
        }
    }
}
