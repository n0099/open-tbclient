package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class SafeKeyBoardUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public SafeKeyBoardEditText f53901b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f53902c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f53903d;

    /* renamed from: e  reason: collision with root package name */
    public View f53904e;

    /* renamed from: f  reason: collision with root package name */
    public int f53905f;

    /* renamed from: g  reason: collision with root package name */
    public int f53906g;

    /* renamed from: h  reason: collision with root package name */
    public int f53907h;

    /* renamed from: i  reason: collision with root package name */
    public int f53908i;

    /* renamed from: j  reason: collision with root package name */
    public SafeKeyBoardState f53909j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SafeKeyBoardState {
        public static final /* synthetic */ SafeKeyBoardState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SafeKeyBoardState CONFRIM_STATE;
        public static final SafeKeyBoardState NORMAL_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500706993, "Lcom/dxmpay/wallet/base/widget/SafeKeyBoardUtil$SafeKeyBoardState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-500706993, "Lcom/dxmpay/wallet/base/widget/SafeKeyBoardUtil$SafeKeyBoardState;");
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardUtil f53910e;

        /* renamed from: com.dxmpay.wallet.base.widget.SafeKeyBoardUtil$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC2062a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f53911e;

            public RunnableC2062a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53911e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow = this.f53911e.f53910e.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing() && this.f53911e.f53910e.f53903d.hasWindowFocus()) {
                    this.f53911e.f53910e.d();
                }
            }
        }

        public a(SafeKeyBoardUtil safeKeyBoardUtil) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardUtil};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53910e = safeKeyBoardUtil;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f53910e.mPopupWindow;
                if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing() && this.f53910e.f53903d.hasWindowFocus()) {
                    this.f53910e.d();
                } else {
                    new Handler().postDelayed(new RunnableC2062a(this), 150L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f53912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardUtil f53913f;

        public b(SafeKeyBoardUtil safeKeyBoardUtil, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeKeyBoardUtil, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53913f = safeKeyBoardUtil;
            this.f53912e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.f53913f.f53904e.getLocationOnScreen(iArr);
                SafeKeyBoardUtil safeKeyBoardUtil = this.f53913f;
                safeKeyBoardUtil.f53907h = ((iArr[1] + safeKeyBoardUtil.f53904e.getHeight()) - (this.f53913f.f53905f - this.f53913f.f53908i)) + this.f53913f.f53901b.getGap() + this.f53912e;
                if (this.f53913f.f53907h > 0) {
                    this.f53913f.f53903d.smoothScrollBy(0, this.f53913f.f53907h);
                }
                this.f53913f.f53903d.notifyShowKeyBoard(this.f53913f.f53908i);
            }
        }
    }

    public SafeKeyBoardUtil() {
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

    public final View b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            while (view instanceof View) {
                if (16908290 == view.getId()) {
                    return view;
                }
                view = (View) view.getParent();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mPopupWindow == null || this.f53903d == null || this.f53904e == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f53905f = displayMetrics.heightPixels;
        this.f53908i = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f53903d.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int i3 = 0;
        View b2 = b(this.f53903d);
        if (b2 != null) {
            i3 = this.f53905f - b2.getHeight();
        }
        int i4 = ((this.f53905f - this.f53908i) - i2) - i3;
        if (i4 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f53903d.getLayoutParams();
        layoutParams.height = i4;
        this.f53903d.setLayoutParams(layoutParams);
        this.f53903d.post(new b(this, i3));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f53903d.getLayoutParams();
            layoutParams.height = this.f53906g;
            this.f53903d.setLayoutParams(layoutParams);
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editText) == null) {
            ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.f53901b.getWindowToken(), 0);
            if (Build.VERSION.SDK_INT < 11) {
                editText.setInputType(0);
                return;
            }
            try {
                Method method = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(editText, Boolean.FALSE);
            } catch (IllegalAccessException e2) {
                e2.getMessage();
            } catch (IllegalArgumentException e3) {
                e3.getMessage();
            } catch (NoSuchMethodException e4) {
                e4.getMessage();
                try {
                    Method method2 = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                    method2.setAccessible(true);
                    method2.invoke(editText, Boolean.FALSE);
                } catch (NoSuchMethodException e5) {
                    e5.getMessage();
                    editText.setInputType(0);
                } catch (Exception e6) {
                    e6.getMessage();
                    editText.setInputType(0);
                }
            } catch (InvocationTargetException e7) {
                e7.getMessage();
            } catch (Exception e8) {
                e8.getMessage();
            }
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (safeKeyBoardPopupWindow = this.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            e();
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, viewGroup, safeScrollView) == null) {
            this.a = context;
            this.f53902c = viewGroup;
            this.f53903d = safeScrollView;
            if (this.mPopupWindow == null) {
                if (this.f53909j == SafeKeyBoardState.CONFRIM_STATE) {
                    this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
                } else {
                    this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
                }
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f53903d;
                if (safeScrollView2 != null) {
                    this.f53906g = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, safeKeyBoardState) == null) {
            this.f53909j = safeKeyBoardState;
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, safeKeyBoardEditText, view) == null) {
            this.f53901b = safeKeyBoardEditText;
            this.f53904e = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f53903d != null && this.f53902c != null) {
                safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
                this.mPopupWindow.setScrollView(this.f53903d);
                hideSoftInputMethod(this.f53901b);
                if (this.f53903d.hasWindowFocus() && this.f53901b.isEnabled()) {
                    if (this.mPopupWindow != null && this.f53903d.hasWindowFocus()) {
                        this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                        try {
                            this.mPopupWindow.showAtLocation(this.f53902c, 80, 0, 0);
                            if (Build.VERSION.SDK_INT <= 23) {
                                this.mPopupWindow.update();
                            }
                        } catch (Exception unused) {
                            this.mPopupWindow = null;
                            return;
                        }
                    }
                    new Handler().postDelayed(new a(this), 150L);
                    return;
                }
                return;
            }
            LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
        }
    }
}
