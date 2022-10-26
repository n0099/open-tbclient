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
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference capturedSharedElement;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean entering;
    public Rect returnEndBounds;
    public ShapeProvider shapeProvider;
    public boolean sharedElementReenterTransitionEnabled;
    public boolean transparentWindowBackgroundEnabled;

    /* loaded from: classes7.dex */
    public interface ShapeProvider {
        ShapeAppearanceModel provideShape(View view2);
    }

    /* loaded from: classes7.dex */
    public class ShapeableViewShapeProvider implements ShapeProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ShapeableViewShapeProvider() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        public ShapeAppearanceModel provideShape(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 instanceof Shapeable) {
                    return ((Shapeable) view2).getShapeAppearanceModel();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public ShapeProvider getShapeProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.shapeProvider;
        }
        return (ShapeProvider) invokeV.objValue;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sharedElementReenterTransitionEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.transparentWindowBackgroundEnabled;
        }
        return invokeV.booleanValue;
    }

    public static void removeWindowBackground(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, window) == null) {
            window.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
        }
    }

    public static void restoreWindowBackground(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, window) == null) {
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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

    public void setShapeProvider(ShapeProvider shapeProvider) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                        View view2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                            if (MaterialContainerTransformSharedElementCallback.capturedSharedElement != null && (view2 = (View) MaterialContainerTransformSharedElementCallback.capturedSharedElement.get()) != null) {
                                view2.setAlpha(1.0f);
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
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
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

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        InterceptResult invokeLL;
        WeakReference weakReference;
        View view2;
        ShapeAppearanceModel provideShape;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, parcelable)) == null) {
            View onCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
            if (onCreateSnapshotView != null && (weakReference = capturedSharedElement) != null && this.shapeProvider != null && (view2 = (View) weakReference.get()) != null && (provideShape = this.shapeProvider.provideShape(view2)) != null) {
                onCreateSnapshotView.setTag(R.id.obfuscated_res_0x7f09158b, provideShape);
            }
            return onCreateSnapshotView;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List list, Map map) {
        View view2;
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, list, map) == null) && !list.isEmpty() && !map.isEmpty() && (view2 = (View) map.get(list.get(0))) != null && (activity = ContextUtils.getActivity(view2.getContext())) != null) {
            Window window = activity.getWindow();
            if (this.entering) {
                setUpEnterTransform(window);
            } else {
                setUpReturnTransform(activity, window);
            }
        }
    }

    public static void updateBackgroundFadeDuration(Window window, MaterialContainerTransform materialContainerTransform) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, window, materialContainerTransform) == null) {
            window.setTransitionBackgroundFadeDuration(materialContainerTransform.getDuration());
        }
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view2, Matrix matrix, RectF rectF) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, view2, matrix, rectF)) == null) {
            capturedSharedElement = new WeakReference(view2);
            return super.onCaptureSharedElementSnapshot(view2, matrix, rectF);
        }
        return (Parcelable) invokeLLL.objValue;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List list, List list2, List list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, list, list2, list3) == null) {
            if (!list2.isEmpty() && (((View) list2.get(0)).getTag(R.id.obfuscated_res_0x7f09158b) instanceof View)) {
                ((View) list2.get(0)).setTag(R.id.obfuscated_res_0x7f09158b, null);
            }
            if (!this.entering && !list2.isEmpty()) {
                this.returnEndBounds = TransitionUtils.getRelativeBoundsRect((View) list2.get(0));
            }
            this.entering = false;
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List list, List list2, List list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, list, list2, list3) == null) {
            if (!list2.isEmpty() && !list3.isEmpty()) {
                ((View) list2.get(0)).setTag(R.id.obfuscated_res_0x7f09158b, list3.get(0));
            }
            if (!this.entering && !list2.isEmpty() && this.returnEndBounds != null) {
                View view2 = (View) list2.get(0);
                view2.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), 1073741824));
                Rect rect = this.returnEndBounds;
                view2.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }
    }
}
