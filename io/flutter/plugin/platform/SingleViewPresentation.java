package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
@TargetApi(17)
/* loaded from: classes2.dex */
public class SingleViewPresentation extends Presentation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AccessibilityEventsDelegate accessibilityEventsDelegate;
    public FrameLayout container;
    public Object createParams;
    public final View.OnFocusChangeListener focusChangeListener;
    public AccessibilityDelegatingFrameLayout rootView;
    public boolean startFocused;
    public PresentationState state;
    public final PlatformViewFactory viewFactory;
    public int viewId;

    /* loaded from: classes2.dex */
    public static class AccessibilityDelegatingFrameLayout extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AccessibilityEventsDelegate accessibilityEventsDelegate;
        public final View embeddedView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessibilityDelegatingFrameLayout(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, View view) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, accessibilityEventsDelegate, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.accessibilityEventsDelegate = accessibilityEventsDelegate;
            this.embeddedView = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, accessibilityEvent)) == null) ? this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, view, accessibilityEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class FakeWindowViewGroup extends ViewGroup {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Rect childRect;
        public final Rect viewBounds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FakeWindowViewGroup(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.viewBounds = new Rect();
            this.childRect = new Rect();
        }

        public static int atMost(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Integer.MIN_VALUE) : invokeI.intValue;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                for (int i6 = 0; i6 < getChildCount(); i6++) {
                    View childAt = getChildAt(i6);
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                    this.viewBounds.set(i2, i3, i4, i5);
                    Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams.x, layoutParams.y, this.childRect);
                    Rect rect = this.childRect;
                    childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }

        @Override // android.view.View
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    getChildAt(i4).measure(atMost(i2), atMost(i3));
                }
                super.onMeasure(i2, i3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ImmContext extends ContextWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final InputMethodManager inputMethodManager;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ImmContext(Context context) {
            this(context, null);
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
                    this((Context) objArr2[0], (InputMethodManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, display)) == null) ? new ImmContext(super.createDisplayContext(display), this.inputMethodManager) : (Context) invokeL.objValue;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if ("input_method".equals(str)) {
                    return this.inputMethodManager;
                }
                return super.getSystemService(str);
            }
            return invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImmContext(Context context, @Nullable InputMethodManager inputMethodManager) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, inputMethodManager};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.inputMethodManager = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }
    }

    /* loaded from: classes2.dex */
    public static class PresentationContext extends ContextWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public WindowManager windowManager;
        @NonNull
        public final WindowManagerHandler windowManagerHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PresentationContext(Context context, @NonNull WindowManagerHandler windowManagerHandler) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, windowManagerHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.windowManagerHandler = windowManagerHandler;
        }

        private WindowManager getWindowManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                if (this.windowManager == null) {
                    this.windowManager = this.windowManagerHandler.getWindowManager();
                }
                return this.windowManager;
            }
            return (WindowManager) invokeV.objValue;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if ("window".equals(str)) {
                    return getWindowManager();
                }
                return super.getSystemService(str);
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class PresentationState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FakeWindowViewGroup fakeWindowViewGroup;
        public PlatformView platformView;
        public WindowManagerHandler windowManagerHandler;

        public PresentationState() {
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
    }

    /* loaded from: classes2.dex */
    public static class WindowManagerHandler implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "PlatformViewsController";
        public transient /* synthetic */ FieldHolder $fh;
        public final WindowManager delegate;
        public FakeWindowViewGroup fakeWindowRootView;

        public WindowManagerHandler(WindowManager windowManager, FakeWindowViewGroup fakeWindowViewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowManager, fakeWindowViewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.delegate = windowManager;
            this.fakeWindowRootView = fakeWindowViewGroup;
        }

        private void addView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, objArr) == null) || (fakeWindowViewGroup = this.fakeWindowRootView) == null) {
                return;
            }
            fakeWindowViewGroup.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
        }

        private void removeView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, objArr) == null) || (fakeWindowViewGroup = this.fakeWindowRootView) == null) {
                return;
            }
            fakeWindowViewGroup.removeView((View) objArr[0]);
        }

        private void removeViewImmediate(Object[] objArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65539, this, objArr) == null) || this.fakeWindowRootView == null) {
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }

        private void updateViewLayout(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, objArr) == null) || (fakeWindowViewGroup = this.fakeWindowRootView) == null) {
                return;
            }
            fakeWindowViewGroup.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
        }

        public WindowManager getWindowManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this) : (WindowManager) invokeV.objValue;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, method, objArr)) == null) {
                String name = method.getName();
                switch (name.hashCode()) {
                    case -1148522778:
                        if (name.equals("addView")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 542766184:
                        if (name.equals("removeViewImmediate")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 931413976:
                        if (name.equals("updateViewLayout")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1098630473:
                        if (name.equals("removeView")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    addView(objArr);
                    return null;
                } else if (c2 == 1) {
                    removeView(objArr);
                    return null;
                } else if (c2 == 2) {
                    removeViewImmediate(objArr);
                    return null;
                } else if (c2 != 3) {
                    try {
                        return method.invoke(this.delegate, objArr);
                    } catch (InvocationTargetException e2) {
                        throw e2.getCause();
                    }
                } else {
                    updateViewLayout(objArr);
                    return null;
                }
            }
            return invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleViewPresentation(Context context, Display display, PlatformViewFactory platformViewFactory, AccessibilityEventsDelegate accessibilityEventsDelegate, int i2, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new ImmContext(context), display);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, display, platformViewFactory, accessibilityEventsDelegate, Integer.valueOf(i2), obj, onFocusChangeListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Display) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.startFocused = false;
        this.viewFactory = platformViewFactory;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.viewId = i2;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.state = new PresentationState();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(SpeedStatsStampTable.INIT_RUKA_STAMP_KEY);
        }
    }

    public PresentationState detachState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.container.removeAllViews();
            this.rootView.removeAllViews();
            return this.state;
        }
        return (PresentationState) invokeV.objValue;
    }

    public PlatformView getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.state.platformView == null) {
                return null;
            }
            return this.state.platformView;
        }
        return (PlatformView) invokeV.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            if (this.state.fakeWindowViewGroup == null) {
                this.state.fakeWindowViewGroup = new FakeWindowViewGroup(getContext());
            }
            if (this.state.windowManagerHandler == null) {
                PresentationState presentationState = this.state;
                presentationState.windowManagerHandler = new WindowManagerHandler((WindowManager) getContext().getSystemService("window"), presentationState.fakeWindowViewGroup);
            }
            this.container = new FrameLayout(getContext());
            PresentationContext presentationContext = new PresentationContext(getContext(), this.state.windowManagerHandler);
            if (this.state.platformView == null) {
                this.state.platformView = this.viewFactory.create(presentationContext, this.viewId, this.createParams);
            }
            View view = this.state.platformView.getView();
            this.container.addView(view);
            AccessibilityDelegatingFrameLayout accessibilityDelegatingFrameLayout = new AccessibilityDelegatingFrameLayout(getContext(), this.accessibilityEventsDelegate, view);
            this.rootView = accessibilityDelegatingFrameLayout;
            accessibilityDelegatingFrameLayout.addView(this.container);
            this.rootView.addView(this.state.fakeWindowViewGroup);
            view.setOnFocusChangeListener(this.focusChangeListener);
            this.rootView.setFocusableInTouchMode(true);
            if (this.startFocused) {
                view.requestFocus();
            } else {
                this.rootView.requestFocus();
            }
            setContentView(this.rootView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleViewPresentation(Context context, Display display, AccessibilityEventsDelegate accessibilityEventsDelegate, PresentationState presentationState, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new ImmContext(context), display);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, display, accessibilityEventsDelegate, presentationState, onFocusChangeListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Display) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.startFocused = false;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.viewFactory = null;
        this.state = presentationState;
        this.focusChangeListener = onFocusChangeListener;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }
}
