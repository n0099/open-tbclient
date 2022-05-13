package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class oy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final View b;
    public wy2 c;
    public Context d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755423447, "Lcom/repackage/oy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755423447, "Lcom/repackage/oy2;");
                return;
            }
        }
        e = eh1.a;
    }

    public oy2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = view2;
        this.d = view2.getContext();
    }

    public final wy2 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            wy2 wy2Var = this.c;
            if (wy2Var != null) {
                return wy2Var;
            }
            if (view2 instanceof wy2) {
                wy2 wy2Var2 = (wy2) view2;
                this.c = wy2Var2;
                return wy2Var2;
            } else if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    wy2 a = a(viewGroup.getChildAt(i));
                    if (a != null) {
                        this.c = a;
                        return a;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
        return (wy2) invokeL.objValue;
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            Context context = this.d;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (vy2.f(activity) && this.b.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.b.getWindowVisibleDisplayFrame(rect);
                    i2 = rect.bottom - rect.top;
                    if (e) {
                        Log.d("SPSwitchRootLayout", "TranslucentStatus && FitsSystemWindows = true, height: " + i2);
                    }
                }
                if (vy2.e(activity) && this.b.getFitsSystemWindows()) {
                    Rect rect2 = new Rect();
                    this.b.getWindowVisibleDisplayFrame(rect2);
                    i2 = rect2.bottom - rect2.top;
                    if (e) {
                        Log.d("SPSwitchRootLayout", "systemUILayoutFullScreen && FitsSystemWindows = true, height: " + i2);
                    }
                }
            }
            if (e) {
                Log.d("SPSwitchRootLayout", "onMeasure, width: " + i + " height: " + i2);
            }
            if (i2 < 0) {
                return;
            }
            int i3 = this.a;
            if (i3 < 0) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "onMeasure, oldHeight < 0, oldHeight: " + this.a);
                }
                this.a = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "offset == 0, break;");
                    return;
                }
                return;
            }
            this.a = i2;
            wy2 a = a(this.b);
            if (a == null) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "cannot find the valid panel layout, give up!");
                    return;
                }
                return;
            }
            int visibility = ((LinearLayout) a).getVisibility();
            if (e) {
                Log.d("SPSwitchRootLayout", "panel visibility: " + visibility);
            }
            if (Math.abs(i4) < ty2.g(this.b.getContext())) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "layout change min, not caused by softinput/panel switch!");
                }
            } else if (Math.abs(i4) > ty2.e(this.b.getContext())) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "layout change max , but not caused by softinput/panel switch!");
                }
            } else if (i4 > 0) {
                if (e) {
                    Log.d("SPSwitchRootLayout", "offset > 0, offset : " + i4 + ", panel->handleHide...");
                }
                a.handleHide();
            } else {
                if (e) {
                    Log.d("SPSwitchRootLayout", "offset < 0, offset : " + i4 + ", panel->handleShow...");
                }
                a.handleShow();
            }
        }
    }
}
