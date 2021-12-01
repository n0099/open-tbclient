package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.AndroidTouchProcessor;
/* loaded from: classes3.dex */
public class FlutterMutatorView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @VisibleForTesting
    public ViewTreeObserver.OnGlobalFocusChangeListener activeFocusListener;
    public final AndroidTouchProcessor androidTouchProcessor;
    public int left;
    public FlutterMutatorsStack mutatorsStack;
    public int prevLeft;
    public int prevTop;
    public float screenDensity;
    public int top;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterMutatorView(@NonNull Context context, float f2, @Nullable AndroidTouchProcessor androidTouchProcessor) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Float.valueOf(f2), androidTouchProcessor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.screenDensity = f2;
        this.androidTouchProcessor = androidTouchProcessor;
    }

    @VisibleForTesting
    public static boolean childHasFocus(@Nullable View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view)) == null) {
            if (view == null) {
                return false;
            }
            if (view.hasFocus()) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (childHasFocus(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private Matrix getPlatformViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Matrix matrix = new Matrix(this.mutatorsStack.getFinalMatrix());
            float f2 = this.screenDensity;
            matrix.preScale(1.0f / f2, 1.0f / f2);
            matrix.postTranslate(-this.left, -this.top);
            return matrix;
        }
        return (Matrix) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.concat(getPlatformViewMatrix());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.save();
            for (Path path : this.mutatorsStack.getFinalClippingPaths()) {
                Path path2 = new Path(path);
                path2.offset(-this.left, -this.top);
                canvas.clipPath(path2);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.androidTouchProcessor == null) {
                return super.onTouchEvent(motionEvent);
            }
            Matrix matrix = new Matrix();
            int action = motionEvent.getAction();
            if (action == 0) {
                int i2 = this.left;
                this.prevLeft = i2;
                int i3 = this.top;
                this.prevTop = i3;
                matrix.postTranslate(i2, i3);
            } else if (action != 2) {
                matrix.postTranslate(this.left, this.top);
            } else {
                matrix.postTranslate(this.prevLeft, this.prevTop);
                this.prevLeft = this.left;
                this.prevTop = this.top;
            }
            return this.androidTouchProcessor.onTouchEvent(motionEvent, matrix);
        }
        return invokeL.booleanValue;
    }

    public void readyToDisplay(@NonNull FlutterMutatorsStack flutterMutatorsStack, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{flutterMutatorsStack, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.mutatorsStack = flutterMutatorsStack;
            this.left = i2;
            this.top = i3;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            setLayoutParams(layoutParams);
            setWillNotDraw(false);
        }
    }

    public void setOnDescendantFocusChangeListener(@NonNull View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onFocusChangeListener) == null) {
            unsetOnDescendantFocusChangeListener();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive() && this.activeFocusListener == null) {
                ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener(this, onFocusChangeListener, this) { // from class: io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FlutterMutatorView this$0;
                    public final /* synthetic */ View val$mutatorView;
                    public final /* synthetic */ View.OnFocusChangeListener val$userFocusListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onFocusChangeListener, this};
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
                        this.val$userFocusListener = onFocusChangeListener;
                        this.val$mutatorView = this;
                    }

                    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
                    public void onGlobalFocusChanged(View view, View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view, view2) == null) {
                            View.OnFocusChangeListener onFocusChangeListener2 = this.val$userFocusListener;
                            View view3 = this.val$mutatorView;
                            onFocusChangeListener2.onFocusChange(view3, FlutterMutatorView.childHasFocus(view3));
                        }
                    }
                };
                this.activeFocusListener = onGlobalFocusChangeListener;
                viewTreeObserver.addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
            }
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.activeFocusListener) == null) {
                return;
            }
            this.activeFocusListener = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlutterMutatorView(@NonNull Context context) {
        this(context, 1.0f, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Float) objArr2[1]).floatValue(), (AndroidTouchProcessor) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
