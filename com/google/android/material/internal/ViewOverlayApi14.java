package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ViewOverlayApi14 implements ViewOverlayImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OverlayViewGroup overlayViewGroup;

    /* loaded from: classes7.dex */
    public class OverlayViewGroup extends ViewGroup {
        public static /* synthetic */ Interceptable $ic;
        public static Method invalidateChildInParentFastMethod;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean disposed;
        public ArrayList drawables;
        public ViewGroup hostView;
        public View requestingView;
        public ViewOverlayApi14 viewOverlay;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1637733253, "Lcom/google/android/material/internal/ViewOverlayApi14$OverlayViewGroup;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1637733253, "Lcom/google/android/material/internal/ViewOverlayApi14$OverlayViewGroup;");
                    return;
                }
            }
            try {
                invalidateChildInParentFastMethod = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view2, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, view2, viewOverlayApi14};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.drawables = null;
            this.hostView = viewGroup;
            this.requestingView = view2;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.viewOverlay = viewOverlayApi14;
        }

        private void assertNotDisposed() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(65538, this) != null) || !this.disposed) {
                return;
            }
            throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
        }

        private void disposeIfEmpty() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && getChildCount() == 0) {
                ArrayList arrayList = this.drawables;
                if (arrayList == null || arrayList.size() == 0) {
                    this.disposed = true;
                    this.hostView.removeView(this);
                }
            }
        }

        private void getOffset(int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, iArr) == null) {
                int[] iArr2 = new int[2];
                int[] iArr3 = new int[2];
                this.hostView.getLocationOnScreen(iArr2);
                this.requestingView.getLocationOnScreen(iArr3);
                iArr[0] = iArr3[0] - iArr2[0];
                iArr[1] = iArr3[1] - iArr2[1];
            }
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
                invalidate(drawable.getBounds());
            }
        }

        public void remove(Drawable drawable) {
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) && (arrayList = this.drawables) != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                disposeIfEmpty();
            }
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            InterceptResult invokeL;
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, drawable)) == null) {
                if (!super.verifyDrawable(drawable) && ((arrayList = this.drawables) == null || !arrayList.contains(drawable))) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public void add(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                assertNotDisposed();
                if (this.drawables == null) {
                    this.drawables = new ArrayList();
                }
                if (!this.drawables.contains(drawable)) {
                    this.drawables.add(drawable);
                    invalidate(drawable.getBounds());
                    drawable.setCallback(this);
                }
            }
        }

        public void add(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                assertNotDisposed();
                if (view2.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2.getParent();
                    if (viewGroup != this.hostView && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                        int[] iArr = new int[2];
                        int[] iArr2 = new int[2];
                        viewGroup.getLocationOnScreen(iArr);
                        this.hostView.getLocationOnScreen(iArr2);
                        ViewCompat.offsetLeftAndRight(view2, iArr[0] - iArr2[0]);
                        ViewCompat.offsetTopAndBottom(view2, iArr[1] - iArr2[1]);
                    }
                    viewGroup.removeView(view2);
                    if (view2.getParent() != null) {
                        viewGroup.removeView(view2);
                    }
                }
                super.addView(view2);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            int size;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                this.hostView.getLocationOnScreen(iArr);
                this.requestingView.getLocationOnScreen(iArr2);
                canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
                canvas.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
                super.dispatchDraw(canvas);
                ArrayList arrayList = this.drawables;
                if (arrayList == null) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                for (int i = 0; i < size; i++) {
                    ((Drawable) this.drawables.get(i)).draw(canvas);
                }
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, iArr, rect)) == null) {
                if (this.hostView != null) {
                    rect.offset(iArr[0], iArr[1]);
                    if (this.hostView != null) {
                        iArr[0] = 0;
                        iArr[1] = 0;
                        int[] iArr2 = new int[2];
                        getOffset(iArr2);
                        rect.offset(iArr2[0], iArr2[1]);
                        return super.invalidateChildInParent(iArr, rect);
                    }
                    invalidate(rect);
                    return null;
                }
                return null;
            }
            return (ViewParent) invokeLL.objValue;
        }

        public ViewParent invalidateChildInParentFast(int i, int i2, Rect rect) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, rect)) == null) {
                if (this.hostView != null && invalidateChildInParentFastMethod != null) {
                    try {
                        getOffset(new int[2]);
                        invalidateChildInParentFastMethod.invoke(this.hostView, Integer.valueOf(i), Integer.valueOf(i2), rect);
                        return null;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
            return (ViewParent) invokeIIL.objValue;
        }

        public void remove(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
                super.removeView(view2);
                disposeIfEmpty();
            }
        }
    }

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.overlayViewGroup = new OverlayViewGroup(context, viewGroup, view2, this);
    }

    public static ViewOverlayApi14 createFrom(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            ViewGroup contentView = ViewUtils.getContentView(view2);
            if (contentView != null) {
                int childCount = contentView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = contentView.getChildAt(i);
                    if (childAt instanceof OverlayViewGroup) {
                        return ((OverlayViewGroup) childAt).viewOverlay;
                    }
                }
                return new ViewGroupOverlayApi14(contentView.getContext(), contentView, view2);
            }
            return null;
        }
        return (ViewOverlayApi14) invokeL.objValue;
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            this.overlayViewGroup.add(drawable);
        }
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable) == null) {
            this.overlayViewGroup.remove(drawable);
        }
    }
}
