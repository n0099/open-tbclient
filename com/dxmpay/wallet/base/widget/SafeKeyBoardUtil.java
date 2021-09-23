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
/* loaded from: classes9.dex */
public final class SafeKeyBoardUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f69997a;

    /* renamed from: b  reason: collision with root package name */
    public SafeKeyBoardEditText f69998b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f69999c;

    /* renamed from: d  reason: collision with root package name */
    public SafeScrollView f70000d;

    /* renamed from: e  reason: collision with root package name */
    public View f70001e;

    /* renamed from: f  reason: collision with root package name */
    public int f70002f;

    /* renamed from: g  reason: collision with root package name */
    public int f70003g;

    /* renamed from: h  reason: collision with root package name */
    public int f70004h;

    /* renamed from: i  reason: collision with root package name */
    public int f70005i;

    /* renamed from: j  reason: collision with root package name */
    public SafeKeyBoardState f70006j;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardUtil f70007e;

        /* renamed from: com.dxmpay.wallet.base.widget.SafeKeyBoardUtil$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC1948a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f70008e;

            public RunnableC1948a(a aVar) {
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
                this.f70008e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (safeKeyBoardPopupWindow = this.f70008e.f70007e.mPopupWindow) != null && safeKeyBoardPopupWindow.isShowing() && this.f70008e.f70007e.f70000d.hasWindowFocus()) {
                    this.f70008e.f70007e.d();
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
            this.f70007e = safeKeyBoardUtil;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.f70007e.mPopupWindow;
                if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing() && this.f70007e.f70000d.hasWindowFocus()) {
                    this.f70007e.d();
                } else {
                    new Handler().postDelayed(new RunnableC1948a(this), 150L);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f70009e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SafeKeyBoardUtil f70010f;

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
            this.f70010f = safeKeyBoardUtil;
            this.f70009e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int[] iArr = new int[2];
                this.f70010f.f70001e.getLocationOnScreen(iArr);
                SafeKeyBoardUtil safeKeyBoardUtil = this.f70010f;
                safeKeyBoardUtil.f70004h = ((iArr[1] + safeKeyBoardUtil.f70001e.getHeight()) - (this.f70010f.f70002f - this.f70010f.f70005i)) + this.f70010f.f69998b.getGap() + this.f70009e;
                if (this.f70010f.f70004h > 0) {
                    this.f70010f.f70000d.smoothScrollBy(0, this.f70010f.f70004h);
                }
                this.f70010f.f70000d.notifyShowKeyBoard(this.f70010f.f70005i);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mPopupWindow == null || this.f70000d == null || this.f70001e == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f69997a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f70002f = displayMetrics.heightPixels;
        this.f70005i = this.mPopupWindow.getPopupWindowHeight();
        int[] iArr = new int[2];
        this.f70000d.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int i3 = 0;
        View b2 = b(this.f70000d);
        if (b2 != null) {
            i3 = this.f70002f - b2.getHeight();
        }
        int i4 = ((this.f70002f - this.f70005i) - i2) - i3;
        if (i4 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f70000d.getLayoutParams();
        layoutParams.height = i4;
        this.f70000d.setLayoutParams(layoutParams);
        this.f70000d.post(new b(this, i3));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f70000d.getLayoutParams();
            layoutParams.height = this.f70003g;
            this.f70000d.setLayoutParams(layoutParams);
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editText) == null) {
            ((InputMethodManager) this.f69997a.getSystemService("input_method")).hideSoftInputFromWindow(this.f69998b.getWindowToken(), 0);
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
            this.f69997a = context;
            this.f69999c = viewGroup;
            this.f70000d = safeScrollView;
            if (this.mPopupWindow == null) {
                if (this.f70006j == SafeKeyBoardState.CONFRIM_STATE) {
                    this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
                } else {
                    this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
                }
            }
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
                SafeScrollView safeScrollView2 = this.f70000d;
                if (safeScrollView2 != null) {
                    this.f70003g = safeScrollView2.getLayoutParams().height;
                } else {
                    LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
                }
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, safeKeyBoardState) == null) {
            this.f70006j = safeKeyBoardState;
        }
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, safeKeyBoardEditText, view) == null) {
            this.f69998b = safeKeyBoardEditText;
            this.f70001e = view;
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
            if (safeKeyBoardPopupWindow != null && safeKeyBoardEditText != null && view != null && this.f70000d != null && this.f69999c != null) {
                safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
                this.mPopupWindow.setScrollView(this.f70000d);
                hideSoftInputMethod(this.f69998b);
                if (this.f70000d.hasWindowFocus() && this.f69998b.isEnabled()) {
                    if (this.mPopupWindow != null && this.f70000d.hasWindowFocus()) {
                        this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                        try {
                            this.mPopupWindow.showAtLocation(this.f69999c, 80, 0, 0);
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
