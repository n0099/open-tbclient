package com.dxmpay.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;
/* loaded from: classes11.dex */
public class SafeScrollView extends ScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HIDE_KEYBOARD_LISTENER = "hide_keyboard_listener";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ScrollChangedListener f62466e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62467f;

    /* renamed from: g  reason: collision with root package name */
    public EventBus f62468g;

    /* renamed from: h  reason: collision with root package name */
    public int f62469h;

    /* renamed from: i  reason: collision with root package name */
    public Context f62470i;
    public SafeKeyBoardEditText j;
    public SafeKeyBoardUtil k;
    public onKeyBoardStatusChangeListener l;
    public int m;
    public int n;
    public boolean o;

    /* loaded from: classes11.dex */
    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeScrollView f62471e;

        public a(SafeScrollView safeScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62471e = safeScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62471e.k.init(this.f62471e.f62470i, this.f62471e.j.getViewGroup(), this.f62471e);
                this.f62471e.k.showSoftKeyBoard(this.f62471e.j, this.f62471e.j.getVisibleView());
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1225566751, "Lcom/dxmpay/wallet/base/widget/SafeScrollView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1225566751, "Lcom/dxmpay/wallet/base/widget/SafeScrollView;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f62467f = false;
        this.f62468g = EventBus.getInstance();
        this.f62469h = 0;
        this.k = new SafeKeyBoardUtil();
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.f62470i = context;
        setSafeFlag(false);
    }

    private void setSafeFlag(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) && (getContext() instanceof Activity)) {
            if (z) {
                BdWalletUtils.clearFlagsSecure((Activity) getContext());
            } else {
                BdWalletUtils.addFlagsSecure((Activity) getContext());
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62466e = null;
        }
    }

    public final void c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) != null) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
                int i2 = this.f62469h + 1;
                this.f62469h = i2;
                if (i2 == 1 && (view instanceof SafeKeyBoardEditText)) {
                    this.j = (SafeKeyBoardEditText) view;
                    return;
                }
                return;
            }
            return;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return;
            }
            c(viewGroup.getChildAt(i3));
            i3++;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62468g.unregister(this);
        }
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, safeKeyBoardEditText) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
                onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.l;
                if (onkeyboardstatuschangelistener != null) {
                    onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
                }
                this.k.hideSoftKeyBoard();
                return;
            }
            GlobalUtils.hideInputMethod(this.f62470i, safeKeyBoardEditText);
        }
    }

    public boolean isPopupWindowShowing() {
        InterceptResult invokeV;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SafeKeyBoardUtil safeKeyBoardUtil = this.k;
            return (safeKeyBoardUtil == null || (safeKeyBoardPopupWindow = safeKeyBoardUtil.mPopupWindow) == null || !safeKeyBoardPopupWindow.isShowing()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view, motionEvent)) == null) {
            if (view == null || !(view instanceof EditText)) {
                return false;
            }
            int[] iArr = {0, 0};
            view.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            return motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) (view.getWidth() + i2)) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) (view.getHeight() + i3));
        }
        return invokeLL.booleanValue;
    }

    public void notifyShowKeyBoard(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.l == null) {
            return;
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.k.mPopupWindow;
        if (safeKeyBoardPopupWindow != null) {
            safeKeyBoardPopupWindow.getHeight();
        }
        this.l.onKeyBoardStatusChange(true, i2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            clear();
            b();
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.o) {
                this.o = true;
                this.m = i5;
                this.n = i5;
                return;
            }
            int i6 = this.n;
            if (i6 != i5) {
                int i7 = this.m;
                if (i5 >= i7 || i6 >= i7) {
                    this.n = i5;
                }
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, event) == null) && event != null && "hide_keyboard_listener".equals(event.mEventKey)) {
            this.k.hideSoftKeyBoard();
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
            ScrollChangedListener scrollChangedListener = this.f62466e;
            if (scrollChangedListener != null) {
                scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z && !this.f62467f) {
                this.k.hideSoftKeyBoard();
                return;
            }
            this.f62469h = 0;
            c(this);
            if (this.f62469h == 1 && (safeKeyBoardEditText = this.j) != null && safeKeyBoardEditText.isFocused() && this.j.getUseSafeKeyBoard()) {
                new Handler().postDelayed(new a(this), 100L);
            }
        }
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f62467f = z;
            this.f62468g.register(this, "hide_keyboard_listener", 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onkeyboardstatuschangelistener) == null) {
            this.l = onkeyboardstatuschangelistener;
        }
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, safeKeyBoardUtil) == null) {
            this.k = safeKeyBoardUtil;
        }
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, scrollChangedListener) == null) {
            this.f62466e = scrollChangedListener;
        }
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, viewGroup, safeKeyBoardEditText, view) == null) {
            if (safeKeyBoardEditText.getUseSafeKeyBoard() && view != null) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.k.mPopupWindow;
                if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                    this.k.init(this.f62470i, viewGroup, this);
                }
                this.k.showSoftKeyBoard(safeKeyBoardEditText, view);
                return;
            }
            GlobalUtils.showInputMethod(this.f62470i, safeKeyBoardEditText);
        }
    }

    public void dismissKeyBoard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.hideSoftKeyBoard();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeScrollView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62470i = context;
        setSafeFlag(false);
    }
}
