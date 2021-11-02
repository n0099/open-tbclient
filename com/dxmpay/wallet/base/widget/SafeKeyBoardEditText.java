package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.GlobalUtils;
/* loaded from: classes11.dex */
public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardState f62439h;

    /* renamed from: i  reason: collision with root package name */
    public Context f62440i;
    public ViewGroup j;
    public SafeScrollView k;
    public View l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public OnMyFocusChangeListener u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public CheckFunc y;

    /* loaded from: classes11.dex */
    public interface CheckFunc {
        boolean check(String str);
    }

    /* loaded from: classes11.dex */
    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SafeKeyBoardState {
        public static final /* synthetic */ SafeKeyBoardState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SafeKeyBoardState CONFRIM_STATE;
        public static final SafeKeyBoardState NORMAL_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(589892954, "Lcom/dxmpay/wallet/base/widget/SafeKeyBoardEditText$SafeKeyBoardState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(589892954, "Lcom/dxmpay/wallet/base/widget/SafeKeyBoardEditText$SafeKeyBoardState;");
                    return;
                }
            }
            NORMAL_STATE = new SafeKeyBoardState("NORMAL_STATE", 0);
            SafeKeyBoardState safeKeyBoardState = new SafeKeyBoardState("CONFRIM_STATE", 1);
            CONFRIM_STATE = safeKeyBoardState;
            $VALUES = new SafeKeyBoardState[]{NORMAL_STATE, safeKeyBoardState};
        }

        public SafeKeyBoardState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SafeKeyBoardState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SafeKeyBoardState) Enum.valueOf(SafeKeyBoardState.class, str) : (SafeKeyBoardState) invokeL.objValue;
        }

        public static SafeKeyBoardState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SafeKeyBoardState[]) $VALUES.clone() : (SafeKeyBoardState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardEditText f62441e;

        public a(SafeKeyBoardEditText safeKeyBoardEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62441e = safeKeyBoardEditText;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f62441e.w) {
                    this.f62441e.requestFocusFromTouch();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardEditText f62442e;

        public b(SafeKeyBoardEditText safeKeyBoardEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62442e = safeKeyBoardEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    SafeKeyBoardEditText safeKeyBoardEditText = this.f62442e;
                    if (!safeKeyBoardEditText.isAlwaysShow) {
                        if (safeKeyBoardEditText.k != null) {
                            this.f62442e.k.dismissKeyBoard(this.f62442e);
                        } else {
                            GlobalUtils.hideInputMethod(this.f62442e.f62440i, this.f62442e);
                        }
                    }
                } else if (this.f62442e.s) {
                    GlobalUtils.hideInputMethod(this.f62442e.f62440i, this.f62442e);
                    if (this.f62442e.k != null && this.f62442e.k.hasWindowFocus() && !this.f62442e.k.isPopupWindowShowing()) {
                        SafeScrollView safeScrollView = this.f62442e.k;
                        ViewGroup viewGroup = this.f62442e.j;
                        SafeKeyBoardEditText safeKeyBoardEditText2 = this.f62442e;
                        safeScrollView.showKeyBoard(viewGroup, safeKeyBoardEditText2, safeKeyBoardEditText2.l);
                    }
                }
                if (this.f62442e.u != null) {
                    this.f62442e.u.onMyFocusChange(view, z);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context) {
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void dismissKeyBorad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.dismissKeyBoard(this);
        }
    }

    public CheckFunc getCheckFunc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.y : (CheckFunc) invokeV.objValue;
    }

    public int getCloseBtnVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.intValue;
    }

    public int getGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.t == 0) {
                this.t = 8;
            }
            return this.t;
        }
        return invokeV.intValue;
    }

    public int getHeadLayoutVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : invokeV.intValue;
    }

    public SafeKeyBoardState getKeyBoardState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62439h : (SafeKeyBoardState) invokeV.objValue;
    }

    public View.OnClickListener getOnConfirmListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x : (View.OnClickListener) invokeV.objValue;
    }

    public boolean getUseKeyDot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean getUseKeyX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean getUseRandKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean getUseSafeKeyBoard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public ViewGroup getViewGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (ViewGroup) invokeV.objValue;
    }

    public View getVisibleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{viewGroup, safeScrollView, view, Boolean.valueOf(z)}) == null) {
            this.j = viewGroup;
            this.k = safeScrollView;
            this.l = view;
            if (z) {
                safeScrollView.showKeyBoard(viewGroup, this, view);
            }
        }
    }

    public boolean isShowLogoLockAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.base.widget.PluginEditText, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, motionEvent)) == null) {
            super.setShowSystemMethodFlag(this.v);
            super.onTouch(view, motionEvent);
            int action = motionEvent.getAction();
            Layout layout = getLayout();
            if (action != 0) {
                return true;
            }
            requestFocus();
            this.off = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
            if (hasFocus()) {
                SafeScrollView safeScrollView = this.k;
                if (safeScrollView == null) {
                    GlobalUtils.showInputMethod(this.f62440i, this);
                    return true;
                } else if (safeScrollView.isPopupWindowShowing()) {
                    return true;
                } else {
                    this.k.showKeyBoard(this.j, this, this.l);
                    return true;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, checkFunc) == null) {
            this.y = checkFunc;
        }
    }

    public void setCloseBtnVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setDisablePast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.w = z;
        }
    }

    public void setGap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.t = i2;
        }
    }

    public void setHeadLayoutVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onMyFocusChangeListener) == null) {
            this.u = onMyFocusChangeListener;
        }
    }

    public void setShowLogoLockAnim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.q = z;
        }
    }

    public void setShowSystemKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.v = z;
        }
    }

    public void setUseKeyDot(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.m = z;
        }
    }

    public void setUseKeyX(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.n = z;
        }
    }

    public void setUseRandKey(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.r = z;
        }
    }

    public void setUseSafeKeyBoard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.s = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.s = true;
        this.t = 0;
        this.v = false;
        this.w = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
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
        this.m = false;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.s = true;
        this.t = 0;
        this.v = false;
        this.w = false;
        this.f62440i = context;
        setOnLongClickListener(new a(this));
        setOnTouchListener(this);
        setOnFocusChangeListener(new b(this));
    }
}
