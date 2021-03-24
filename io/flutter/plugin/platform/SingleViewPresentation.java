package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
@TargetApi(17)
/* loaded from: classes7.dex */
public class SingleViewPresentation extends Presentation {
    public final AccessibilityEventsDelegate accessibilityEventsDelegate;
    public FrameLayout container;
    public Object createParams;
    public final View.OnFocusChangeListener focusChangeListener;
    public AccessibilityDelegatingFrameLayout rootView;
    public boolean startFocused;
    public PresentationState state;
    public final PlatformViewFactory viewFactory;
    public int viewId;

    /* loaded from: classes7.dex */
    public static class AccessibilityDelegatingFrameLayout extends FrameLayout {
        public final AccessibilityEventsDelegate accessibilityEventsDelegate;
        public final View embeddedView;

        public AccessibilityDelegatingFrameLayout(Context context, AccessibilityEventsDelegate accessibilityEventsDelegate, View view) {
            super(context);
            this.accessibilityEventsDelegate = accessibilityEventsDelegate;
            this.embeddedView = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.accessibilityEventsDelegate.requestSendAccessibilityEvent(this.embeddedView, view, accessibilityEvent);
        }
    }

    /* loaded from: classes7.dex */
    public static class FakeWindowViewGroup extends ViewGroup {
        public final Rect childRect;
        public final Rect viewBounds;

        public FakeWindowViewGroup(Context context) {
            super(context);
            this.viewBounds = new Rect();
            this.childRect = new Rect();
        }

        public static int atMost(int i) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.viewBounds.set(i, i2, i3, i4);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.viewBounds, layoutParams.x, layoutParams.y, this.childRect);
                Rect rect = this.childRect;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).measure(atMost(i), atMost(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    /* loaded from: classes7.dex */
    public static class ImmContext extends ContextWrapper {
        @NonNull
        public final InputMethodManager inputMethodManager;

        public ImmContext(Context context) {
            this(context, null);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new ImmContext(super.createDisplayContext(display), this.inputMethodManager);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            if ("input_method".equals(str)) {
                return this.inputMethodManager;
            }
            return super.getSystemService(str);
        }

        public ImmContext(Context context, @Nullable InputMethodManager inputMethodManager) {
            super(context);
            this.inputMethodManager = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }
    }

    /* loaded from: classes7.dex */
    public static class PresentationContext extends ContextWrapper {
        @Nullable
        public WindowManager windowManager;
        @NonNull
        public final WindowManagerHandler windowManagerHandler;

        public PresentationContext(Context context, @NonNull WindowManagerHandler windowManagerHandler) {
            super(context);
            this.windowManagerHandler = windowManagerHandler;
        }

        private WindowManager getWindowManager() {
            if (this.windowManager == null) {
                this.windowManager = this.windowManagerHandler.getWindowManager();
            }
            return this.windowManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            if ("window".equals(str)) {
                return getWindowManager();
            }
            return super.getSystemService(str);
        }
    }

    /* loaded from: classes7.dex */
    public static class PresentationState {
        public FakeWindowViewGroup fakeWindowViewGroup;
        public PlatformView platformView;
        public WindowManagerHandler windowManagerHandler;
    }

    /* loaded from: classes7.dex */
    public static class WindowManagerHandler implements InvocationHandler {
        public static final String TAG = "PlatformViewsController";
        public final WindowManager delegate;
        public FakeWindowViewGroup fakeWindowRootView;

        public WindowManagerHandler(WindowManager windowManager, FakeWindowViewGroup fakeWindowViewGroup) {
            this.delegate = windowManager;
            this.fakeWindowRootView = fakeWindowViewGroup;
        }

        private void addView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
            } else {
                fakeWindowViewGroup.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void removeView(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
            } else {
                fakeWindowViewGroup.removeView((View) objArr[0]);
            }
        }

        private void removeViewImmediate(Object[] objArr) {
            if (this.fakeWindowRootView == null) {
                Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.fakeWindowRootView.removeView(view);
        }

        private void updateViewLayout(Object[] objArr) {
            FakeWindowViewGroup fakeWindowViewGroup = this.fakeWindowRootView;
            if (fakeWindowViewGroup == null) {
                Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
            } else {
                fakeWindowViewGroup.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager getWindowManager() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            char c2;
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
    }

    public SingleViewPresentation(Context context, Display display, PlatformViewFactory platformViewFactory, AccessibilityEventsDelegate accessibilityEventsDelegate, int i, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new ImmContext(context), display);
        this.startFocused = false;
        this.viewFactory = platformViewFactory;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.viewId = i;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.state = new PresentationState();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public PresentationState detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public PlatformView getView() {
        if (this.state.platformView == null) {
            return null;
        }
        return this.state.platformView;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
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

    public SingleViewPresentation(Context context, Display display, AccessibilityEventsDelegate accessibilityEventsDelegate, PresentationState presentationState, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new ImmContext(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.viewFactory = null;
        this.state = presentationState;
        this.focusChangeListener = onFocusChangeListener;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }
}
